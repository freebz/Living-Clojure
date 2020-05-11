;; 흐름 제어 이용하기

(if true "it is true" "it is false")
;=> "it is true"

(if false "it is true" "it is false")
;=> "it is false"

(if nil "it is true" "it is false")
;=> "it is false"

(if (= :drinkme :drinkme)
  "Try it"
  "Don't try it")
;=> "Try it"


(let [need-to-grow-small (> 5 3)]
  (if need-to-grow-small
    "drink bottle"
    "don't drink bottle"))
;=> "drink bottle"

;; 아래 예제는 if를 사용해도 되지만, 설명을 위해 일부러 만든 것이다.
(if-let [need-to-grow-small (> 5 1)]
  "drink bottle"
  "don't drink bottle")
;=> "drink bottle"


(defn drink [need-to-grow-small]
  (when need-to-grow-small "drink bottle"))

(drink true)
;=> "drink bottle"
(drink false)
;=> nil


(when-let [need-to-grow-small true]
  "drink bottle")
;=> "drink bottle"


(when-let [need-to-grow-small false]
  "drink bottle")
;=> nil


(let [bottle "drinkme"]
  (cond
    (= bottle "poison") "don't touch"
    (= bottle "drinkme") "grow smaller"
    (= bottle "empty") "all gone"))
;=> "grow smaller"


(let [x 5]
  (cond
    (> x 10) "bigger than 10"
    (> x 4) "bigger than 4"
    (> x 3) "bigger than 3"))
;=> "bigger than 4"


(let [x 5]
  (cond
    (> x 3) "bigger than 3"
    (> x 10) "bigger than 10"
    (> x 4) "bigger than 4"))
;=> "bigger than 3"


(let [x 1]
  (cond
    (> x 10) "bigger than 10"
    (> x 4) "bigger than 4"
    (> x 3) "bigger than 3"))
;=> nil


(let [bottle "mystery"]
  (cond
    (= bottle "poison") "don't touch"
    (= bottle "drinkme") "grow smaller"
    (= bottle "empty") "all gone"
    :else "unknown"))
;=> "unknown"


(let [bottle "mystery"]
  (cond
    (= bottle "poison") "don't touch"
    (= bottle "drinkme") "grow smaller"
    (= bottle "empty") "all gone"
    "default" "unknown"))
;=> "unknown"


(let [bottle "drinkme"]
  (case bottle
    "poison" "don't touch"
    "drinkme" "grow smaller"
    "empty" "all gone"))


(let [bottle "mystery"]
  (case bottle
    "poison" "don't touch"
    "drinkme" "grow smaller"
    "empty" "all gone"))
;=> IllegalArgumentException No matching clause: mystery


(let [bottle "mystery"]
  (case bottle
    "poison" "don't touch"
    "drinkme" "grow smaller"
    "empty" "all gone"
    "unknown"))
;=> "unknown"
