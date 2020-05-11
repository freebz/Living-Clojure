;; 재귀

["normal" "too small" "too big" "swimming"]


["Alice is normal"
 "Alice is too small"
 "Alice is too big"
 "Alice is swimming"]


#(str "Alice is " %)


(def adjs ["normal"
           "too small"
           "too big"
           "is swimming"])

(defn alice-is [in out]
  (if (empty? in)
    out
    (alice-is
     (rest in)
     (conj out
           (str "Alice is " (first in))))))

(alice-is adjs [])
;=> ["Alice is normal" "Alice is too small"
;    "Alice is too big" "Alice is is swimming"]


(defn alice-is [input]
  (loop [in input
         out []]
    (if (empty? in)
      out
      (recur (rest in)
             (conj out (str "Alice is " (first in)))))))

(alice-is adjs)
;=> ["Alice is normal"
;    "Alice is too small"
;    "Alice is too big"
;    "Alice is is swimming"]


(defn countdown [n]
  (if (= n 0)
    n
    (countdown (- n 1))))

(countdown 3)
;=> 0

(countdown 100000)
;=> StackOverflowError


(defn countdown [n]
  (if (= n 0)
    n
    (recur (- n 1))))

(countdown 100000)
;=> 0
