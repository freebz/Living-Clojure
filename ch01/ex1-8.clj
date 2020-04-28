;; 리스트는 클로저의 핵심이다

'("marmalade-jar" "empty-jar" "pickle-jam-jar")


("marmalade-jar" "empty-jar" "pickle-jam-jar")
;=> ClassCastException java.lang.String cannot be cast to clojure.lang.IFn


'(+ 1 1)
;=> (+ 1 1)


(first '(+ 1 1))
;=> +
