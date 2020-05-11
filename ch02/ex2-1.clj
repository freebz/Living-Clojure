;; 논리에 따라 흐름 제어하기

(class true)
;=> java.lang.Boolean


(true? true)
;=> true

(true? false)
;=> false


(false? false)
;=> true

(false? true)
;=> false


(nil? nil)
;=> true

(nil? 1)
;=> false


(not true)
;=> false

(not false)
;=> true


(not nil)
;=> true


(not "hi")
;=> false


(= :drinkme :drinkme)
;=> true


(= :drinkme 4)
;=> false


(= '(:drinkme :bottle) [:drinkme :bottle])
;=> true


(not= :drinkme :4)
;=> true
