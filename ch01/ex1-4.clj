;; 벡터를 사용해 인덱스로 데이터 접근하기

[:jar1 1 2 3 :jar2]
;=> [:jar1 1 2 3 :jar2]


(first [:jar1 1 2 3 :jar2])
;=> :jar1

(rest [:jar1 1 2 3 :jar2])
;=> (1 2 3 :jar2)


(nth [:jar1 1 2 3 :jar2] 0)
;=> :jar1

(nth [:jar1 1 2 3 :jar2] 2)
;=> 2


;; 벡터에 last 적용
(last [:rabbit :pocket-watch :marmalade])
;=> :marmalade

;; 리스트에 last 적용
(last '(:rabbit :pocket-watch :marmalade))
;=> :marmalade
