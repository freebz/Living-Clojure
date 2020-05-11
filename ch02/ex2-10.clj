;; 다른 유용한 데이터 처리 함수들

((complement nil?) nil)
;=> false

((complement nil?) 1)
;=> true


(filter (complement nil?) [:mouse nil :duck nil])
;=> (:mouse :duck)


(filter keyword? [:mouse nil :duck nil])
;=> (:mouse :duck)


(remove nil? [:mouse nil :duck nil])
;=> (:mouse :duck)


(for [animal [:mouse :duck :lory]]
  (str (name animal)))
;=> ("mouse" "duck" "lory")


(for [animal [:mouse :duck :lory]
      color  [:red :blue]]
  (str (name color) (name animal)))
;=> ("redmouse" "bluemouse"
;    "redduck" "blueduck"
;    "redlory" "bluelory")


(for [animal [:mouse :duck :lory]
      color [:red :blue]
      :let [animal-str (str "animal-"(name animal))
            color-str (str "color-"(name color))
            display-str (str animal-str "-" color-str)]]
  display-str)
;=> ("animal-mouse-color-red" "animal-mouse-color-blue"
;    "animal-duck-color-red" "animal-duck-color-blue"
;    "animal-lory-color-red" "animal-lory-color-blue")


(for [animal [:mouse :duck :lory]
      color [:red :blue]
      :let [animal-str (str "animal-"(name animal))
            color-str (str "color-"(name color))
            display-str (str animal-str "-" color-str)]
      :when (= color :blue)]
  display-str)
;=> ("animal-mouse-color-blue"
;    "animal-duck-color-blue"
;    "animal-lory-color-blue")


(flatten [[:duck [:mouse] [[:lory]]]])
;=> (:duck :mouse :lory)


(vec '(1 2 3))
;=> [1 2 3]

(into [] '(1 2 3))
;=> [1 2 3]


(sorted-map :b 2 :a 1 :z 3)
;=> {:a 1, :b 2, :z 3}


(into (sorted-map) {:b 2 :c 3 :a 1})
;=> {:a 1, :b 2, :z 3}


(into {} [[:a 1] [:b 2] [:c 3]])
;=> {:a 1, :b 2, :z 3}


(into [] {:a 1, :b 2, :c 3})
;=> [[:a 1] [:b 2] [:c 3]]


(partition 3 [1 2 3 4 5 6 7 8 9])
;=> ((1 2 3) (4 5 6) (7 8 9))


(partition 3 [1 2 3 4 5 6 7 8 9 10])
;=> ((1 2 3) (4 5 6) (7 8 9))


(partition-all 3 [1 2 3 4 5 6 7 8 9 10])
;=> ((1 2 3) (4 5 6) (7 8 9) (10))


(partition-by #(= 6 %) [1 2 3 4 5 6 7 8 9 10])
;=> ((1 2 3 4 5) (6) (7 8 9 10))
