;; 컬렉션의 공통점들

(count [1 2 3 4])
;=> 4


;; conj는 벡터의 맥 뒤에 요소를 추가한다.
(conj [:toast :butter] :jam)
;=> [:toast :butter :jam]

;; 여러 개의 요소를 맨 뒤에 추가한다.
(conj [:toast :butter] :jam :honey)
;=> [:toast :butter :jam :honey]


;; conj는 리스트의 맨 앞에 요소를 추가한다.
(conj '(:toast :butter) :jam)
;=> (:jam :toast :butter)

;; 여러 개의 요소를 맨 앞에 추가한다.
(conj '(:toast :butter) :jam :honey)
;=> (:honey :jam :toast :butter)
