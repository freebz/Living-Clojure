(ns queen-of-hearts.core
  (:require [clojure.core.async :as async]))


(def flowers ["white carnation"
              "yellow daffodil"
              "yellow rose"
              "red rose"
              "white rose"
              "purple lily"
              "pink carnation"])
;=> #'user/flowers


(defn paint-it-red [s]
  (str "red "
       (last (clojure.string/split s #"\s"))))


(paint-it-red "white carnation")
;=> "red carnation"


(map paint-it-red flowers)
;=> ("red carnation"
;    "red daffodil"
;    "red rose"
;    "red rose"
;    "red rose"
;    "red lily"
;    "red carnation")


(defn is-a-rose? [s]
  (= "rose"
     (last (clojure.string/split s #"\s"))))

(is-a-rose? "yellow rose")
;=> true


(filter is-a-rose? flowers)
;=> ("yellow rose" "red rose" "white rose")


(map paint-it-red)
;=> #function[clojure.core/map/fn--4781]


(filter is-a-rose?)
;=> #function[clojure.core/filter/fn--4808]


(def fix-for-the-queen-xform
  (comp
   (map paint-it-red)
   (filter is-a-rose?)))


(into [] fix-for-the-queen-xform flowers)
;=> ["red rose" "red rose" "red rose"]


(class (sequence fix-for-the-queen-xform flowers))
;=> clojure.lang.LazySeq

(take 1 (sequence fix-for-the-queen-xform flowers))
;=> ("red rose")


(transduce fix-for-the-queen-xform
           (completing #(str %1 %2 ":"))
           ""
           flowers)
;=> "red rose:red rose:red rose:"


(def flower-chan (async/chan 1 fix-for-the-queen-xform))


(def result-chan (async/reduce
                  (completing #(str %1 %2 ":"))
                  ""
                  flower-chan))


(async/onto-chan flower-chan flowers)
;=> #object[clojure.core.async.impl.channels.ManyToManyChannel ...]


(def flowers-for-the-queen (async/<!! result-chan))

flowers-for-the-queen
;=> "red rose:red rose:red rose:"
