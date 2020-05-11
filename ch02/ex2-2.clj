;; 컬렉션에 사용하는 논리 검사

(empty? [:table :door :key])
;=> false

(empty? [])
;=> true

(empty? {})
;=> true

(empty? '())
;=> true


(defn empty? [coll]
  (not (seq coll)))


(seq [1 2 3])
;=> (1 2 3)

(class [1 2 3])
;=> clojure.lang.PersistentVector

(class (seq [1 2 3]))
;=> clojure.lang.PersistentVector$ChunkedSeq

(seq [])
;=> nil


(empty? [])
;=> true

;; 비어 있지 않은 것을 확인하려면 seq를 쓰자
(seq [])
;=> nil


(every? odd? [1 3 5])
;=> true

(every? odd? [1 2 3 4 5])
;=> false


(defn drinkable? [x]
  (= x :drinkme))
;=> #'user/drinkable?

(every? drinkable? [:drinkme :drinkme])
;=> true

(every? drinkable? [:drinkme :poison])
;=> false


(every? (fn [x] (= x :drinkme)) [:drinkme :drinkme])
;=> true


(every? #(= % :drinkme) [:drinkme :drinkme])
;=> true


(not-any? #(= % :drinkme) [:drinkme :poison])
;=> false

(not-any? #(= % :drinkme) [:poison :poison])
;=> true


(some #(> % 3) [1 2 3 4 5])
;=> true


(#{1 2 3 4 5} 3)
;=> 3


(some #{3} [1 2 3 4 5])
;=> 3

(some #{4 5} [1 2 3 4 5])
;=> 4


(some #{nil} [nil nil nil])
;=> nil

(some #{false} [false false false])
;=> nil
