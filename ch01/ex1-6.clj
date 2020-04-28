;; 맵을 사용해 키-값 쌍의 데이터를 저장하기

{:jam1 "strawberry" :jam2 "blackberry"}
;=> {:jam1 "strawberry", :jam2 "blackberry"}


{:jam1 "strawberry", :jam2 "blackberry"}
;=> {:jam1 "strawberry", :jam2 "blackberry"}

{:jam1 "strawberry" :jam2 "blackberry"}
;=> {:jam1 "strawberry", :jam2 "blackberry"}


;; get을 명시적으로 사용한 예
(get {:jam1 "strawberry" :jam2 "blackberry"} :jam2)
;=> "blackberry"


(get {:jam1 "strawberry" :jam2 "blackberry"} :jam3 "not found")
;=> "not found"


;; 키를 함수로 사용해 값 가져오기
(:jam2 {:jam1 "strawberry" :jam2 "blackberry" :jam3 "marmalade"})
;=> "blackberry"


;; keys 함수
(keys {:jam1 "strawberry" :jam2 "blackberry" :jam3 "marmalade"})
;=> (:jam1 :jam2 :jam3)

;; vals 함수
(vals {:jam1 "strawberry" :jam2 "blackberry" :jam3 "marmalade"})
;=> ("strawberry" "blackberry" "marmalade")


(assoc {:jam1 "red" :jam2 "black"} :jam1 "orange")
;=> {:jam1 "orange", :jam2 "black"}


(dissoc {:jam1 "strawberry" :jam2 "blackberry"} :jam1)
;=> {:jam2 "blackberry"}


(merge {:jam1 "red" :jam2 "black"}
       {:jam1 "orange" :jam3 "red"}
       {:jam4 "blue"})
;=> {:jam1 "orange", :jam2 "black", :jam3 "red", :jam4 "blue"}
