;; 템플릿을 이용해 매크로 만들기

'(first [1 2 3])
;=> (first [1 2 3])


`(first [1 2 3])
;=> (clojure.core/first [1 2 3])


(let [x 5]
  `(first [x 2 3]))
;=> (clojure.core/first [user/x 2 3])


(let [x 5]
  `(first [~x 2 3]))
;=> (clojure.core/first [5 2 3])


(defmacro def-hi-queen [name phrase]
  `(defn ~(symbol name) []
     (hi-queen ~phrase)))


(macroexpand-1 '(def-hi-queen alice-hi-queen "My name is Alice"))
;=> (clojure.core/defn alice-hi-queen []
;     (user/hi-queen "My name is Alice"))


(def-hi-queen dormouse-hi-queen "I am the Dormouse")
;=> #'user/dormouse-hi-queen

(dormouse-hi-queen)
;=> "I am the Dormouse, so please your Majesty."
