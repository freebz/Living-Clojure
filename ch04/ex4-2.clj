;; 실용적인 다형성

(defn who-are-you [input]
  (cond
    (= java.lang.String (class input)) "String - Who are you?"
    (= clojure.lang.Keyword (class input)) "Keyword - Who are you?"
    (= java.lang.Long (class input)) "Number - Who are you?"))

(who-are-you :alice)
;=> "Keyword - Who are you?"

(who-are-you "alice")
;=> "String - Who are you?"

(who-are-you 123)
;=> "Number - Who are you?"

(who-are-you true)
;=> nil


(defmulti who-are-you class)

(defmethod who-are-you java.lang.String [input]
  (str "String - who are you? " input))

(defmethod who-are-you clojure.lang.Keyword [input]
  (str "Keyword - who are you? " input))

(defmethod who-are-you java.lang.Long [input]
  (str "Number - Who are you? " input))

(who-are-you :alice)
;=> "Keyword - who are you? :alice"

(who-are-you "Alice")
;=> "String - who are you? Alice"

(who-are-you 123)
;=> "Number - Who are you? 123"

(who-are-you true)
;=> IllegalArgumentException No method in multimethod
;   'who-are-you' for dispatch value: class java.lang.Boolean


(defmethod who-are-you :default [input]
  (str "I don't know - who are you? " input))

(who-are-you true)
;=> "I don't know - who are you? true"


(defmulti eat-mushroom (fn [height]
                         (if (< height 3)
                           :grow
                           :shrink)))


(defmethod eat-mushroom :grow [_]
  "Eat the right side to grow.")


(defmethod eat-mushroom :shrink [_]
  "Eat the left side to shrink.")


(eat-mushroom 1)
;=> "Eat the right side to grow."


(eat-mushroom 9)
;=> "Eat the left side to shrink."


(defprotocol BigMushroom
  (eat-mushroom [this]))


(extend-protocol BigMushroom
  java.lang.String
  (eat-mushroom [this]
    (str (.toUpperCase this) " mmmm tasty!"))

  clojure.lang.Keyword
  (eat-mushroom [this]
    (case this
      :grow "Eat the right side!"
      :shrink "Eat the left side!"))

  java.lang.Long
  (eat-mushroom [this]
    (if (< this 3)
      "Eat the right side to grow"
      "Eat the left side to shrink")))


(eat-mushroom "Big Mushroom")
;=> "BIG MUSHROOM mmmm tasty!"

(eat-mushroom :grow)
;=> "Eat the right side!"

(eat-mushroom 1)
;=> "Eat the right side to grow"


(defrecord Mushroom [color height])
;=> caterpillar.network.Mushroom


(def regular-mushroom (Mushroom. "white and blue polka dots" "2 inches"))
;=> #'caterpillar.network/regular-mushroom

(class regular-mushroom)
;=> caterpillar.network.Mushroom


(.-color regular-mushroom)
;=> "white and blue polka dots"

(.-height regular-mushroom)
;=> "2 inches"


(defprotocol Edible
  (bite-right-side [this])
  (bite-left-side [this]))


(defrecord WonderlandMushroom [color height]
  Edible
  (bite-right-side [this]
    (str "The " color " bite makes you grow bigger"))
  (bite-left-side [this]
    (str "The " color " bite makes you grow smaller")))


(defrecord RegularMushroom [color height]
  Edible
  (bite-right-side [this]
    (str "The " color " bite tastes bad"))
  (bite-left-side [this]
    (str "The " color " bite tastes bad too")))


(def alice-mushroom (WonderlandMushroom. "blue dots" "3 inches"))
(def reg-mushroom (RegularMushroom. "brown" "1 inches"))


(bite-right-side alice-mushroom)
;=> "The blue dots bite makes you grow bigger"

(bite-left-side alice-mushroom)
;=> "The blue dots bite makes you grow smaller"


(bite-right-side reg-mushroom)
;=> "The brown bite tastes bad"

(bite-left-side reg-mushroom)
;=> "The brown bite tastes bad too"


(defprotocol Edible
  (bite-right-side [this])
  (bite-left-side [this]))


(deftype WonderlandMushroom []
  Edible
  (bite-right-side [this]
    (str "The bite makes you grow bigger"))
  (bite-left-side [this]
    (str "The bite makes you grow smaller")))


(deftype RegularMushroom []
  Edible
  (bite-right-side [this]
    (str "The bite tastes bad"))
  (bite-left-side [this]
    (str "The bite tastes bad too")))


(def alice-mushroom (WonderlandMushroom.))
(def reg-mushroom (RegularMushroom.))


(bite-right-side alice-mushroom)
;=> "The bite makes you grow bigger"

(bite-left-side alice-mushroom)
;=> "The bite makes you grow smaller"

(bite-right-side reg-mushroom)
;=> "The bite tastes bad"

(bite-left-side reg-mushroom)
;=> "The bite tastes bad too"


(defn bite-right-side [mushroom]
  (if (= (:type mushroom) "wonderland")
    "The bite makes you grow bigger"
    "The bite tastes bad"))


(defn bite-left-side [mushroom]
  (if (= (:type mushroom) "wonderland")
    "The bite makes you grow smaller"
    "The bite tastes bad too"))


(bite-right-side {:type "wonderland"})
;=> "The bite makes you grow bigger"

(bite-left-side {:type "wonderland"})
;=> "The bite makes you grow smaller"


(bite-right-side {:type "regular"})
;=> "The bite tastes bad"

(bite-left-side {:type "regular"})
;=> "The bite tastes bad too"
