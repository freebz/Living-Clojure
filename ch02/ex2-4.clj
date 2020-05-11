;; 함수를 만드는 함수

(defn grow [name direction]
  (if (= direction :small)
    (str name " is growing smaller")
    (str name " is growing bigger")))
;=> #'user/grow

(grow "Alice" :small)
;=> "Alice is growing smaller"

(grow "Alice" :big)
;=> "Alice is growing bigger"


(partial grow "Alice")
;=> #function[clojure.core/partial/fn--4759]

((partial grow "Alice") :small)
;=> "Alice is growing smaller"


(defn toggle-grow [direction]
  (if (= direction :small) :big :small))
;=> #'user/toggle-grow

(toggle-grow :big)
;=> :small

(toggle-grow :small)
;=> :big


(defn oh-my [direction]
  (str "Oh My! You are growing " direction))
;=> #'user/oh-my


(oh-my (toggle-grow :small))
;=> "Oh My! You are growing :big"


(defn surprise [direction]
  ((comp oh-my toggle-grow) direction))

(surprise :small)
;=> "Oh My! You are growing :big"


(defn adder [x y]
  (+ x y))
;=> #'user/adder

(adder 3 4)
;=> 7

(def adder-5 (partial adder 5))
;=> #'user/adder-5

(adder-5 10)
;=> 10
