;; 지연의 힘

(take 5 (range))
;=> (0 1 2 3 4)

(take 10 (range))
;=> (0 1 2 3 4 5 6 7 8 9)


(range 5)
;=> (0 1 2 3 4)

(class (range 5))
;=> clojure.lang.LongRange


;; 이 코드를 평가하지 마라. 평가하면 크래시가 발생한다.
(range)


(take 10 (range))
;=> (0 1 2 3 4 5 6 7 8 9)


(count (take 1000 (range)))       
;=> 1000

(count (take 100000 (range)))
;=> 100000


(repeat 3 "rabit")
;=> ("rabit" "rabit" "rabit")

(class (repeat 3 "rabit"))
;=> clojure.lang.Repeat


(take 5 (repeat "rabbit"))
;=> ("rabbit" "rabbit" "rabbit" "rabbit" "rabbit")

(count (take 5000 (repeat "rabbit")))
;=> 5000


(rand-int 10)
;=> 3

(rand-int 10)
;=> 4


(repeat 5 (rand-int 10))
;=> (7 7 7 7 7)


#(rand-int 10)
;=> #function[user/eval4795/fn--4796]

(#(rand-int 10))
;=> 3


(repeatedly 5 #(rand-int 10))
;=> (1 5 8 4 3)


(take 10 (repeatedly #(rand-int 10)))
;=> (9 9 5 8 3 1 0 9 3 2)


(take 3 (cycle ["big" "small"]))
;=> ("big" "small" "big")

(take 6 (cycle ["big" "small"]))
;=> ("big" "small" "big" "small" "big" "small")


(take 3 (rest (cycle ["big" "small"])))
;=> ("small" "big" "small")
