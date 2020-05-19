;; 매크로 탐함하기

(defmacro when
  "Evaluates test. If logical true, evaluates body in an implicit do."
  {:added "1.0"}
  [test & body]
  (list 'if test (cons 'do body)))


(when (= 2 2) (println "It is four!"))

;; 화면에 "It is four!"가 출력된다.


(macroexpand-1
 '(when (= 2 2) (println "It is four!")))
;=> (if (= 2 2)
;     (do (println "It is four!")))
