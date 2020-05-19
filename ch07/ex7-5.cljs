;; 클로저스크립트로 브라우저에서 클로저 사용하기

cljs.user=> (+ 1 1)
;=> 2


(class "hi")
;=> WARNING: Use of undeclared Var cljs.user/class ...
;   TypeError: Cannot call method "call" of undefined


js/Date
;=> #object[Date "function Date() { [native code for Date.Date, arity=1] }"]


(js/Date)
;=> "Wed May 13 2020 15:48:54 GMT+0900 (KST)"


(first [1 2 3 4])
;=> 1


(def x (atom 0))
;=> #'cljs.user/x

(swap! x inc)
;=> 1
