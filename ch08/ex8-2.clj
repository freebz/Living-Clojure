;; 매크로 만들기

(defn hi-queen [phrase]
  (str phrase ", so please your Majesty."))

(defn alice-hi-queen []
  (hi-queen "My name is Alice"))

(alice-hi-queen)
;=> "My name is Alice, so please your Majesty."

(defn march-hare-hi-queen []
  (hi-queen "I'm the March Hare"))

(march-hare-hi-queen)
;=> "I'm the March Hare, so please your Majesty."

(defn white-rabbit-hi-queen []
  (hi-queen "I'm the White Rabbit"))

(white-rabbit-hi-queen)
;=> "I'm the White Rabbit, so please your Majesty."

(defn mad-hatter-hi-queen []
  (hi-queen "I'm the Mad Hatter"))

(mad-hatter-hi-queen)
;=> "I'm the Mad Hatter, so please your Majesty."


(defmacro def-hi-queen [name phrase]
  (list 'defn
        (symbol name)
        []
        (list 'hi-queen phrase)))


(macroexpand-1 '(def-hi-queen alice-hi-queen "My name is Alice"))
;=> (defn alice-hi-queen []
;     (hi-queen "My name is Alice"))


(def-hi-queen alice-hi-queen "My name is Alice")
;=> #'user/alice-hi-queen


(alice-hi-queen)
;=> "My name is Alice, so please your Majesty."


(defmacro def-hi-queen [name phrase]
  (list 'defn
        (symbol name)
        []
        (list 'hi-queen phrase)))
;=> #'user/def-hi-queen

(def-hi-queen alice-hi-queen "My name is Alice")
;=> #'user/alice-hi-queen

(def-hi-queen march-hare-hi-queen "I'm the March Hare")
;=> #'user/march-hare-hi-queen

(def-hi-queen white-rabbit-hi-queen "I'm the White Rabbit")
;=> #'user/white-rabbit-hi-queen

(def-hi-queen mad-hatter-hi-queen "I'm the Mad Hatter")
;=> #'user/mad-hatter-hi-queen


(alice-hi-queen)
;=> "My name is Alice, so please your Majesty."

(march-hare-hi-queen)
;=> "I'm the March Hare, so please your Majesty."

(white-rabbit-hi-queen)
;=> "I'm the White Rabbit, so please your Majesty."

(mad-hatter-hi-queen)
;=> "I'm the Mad Hatter, so please your Majesty."
