;; 함수형 프로그래밍에서의 데이터 변환

;; 궁극의 map

(def animals [:mouse :duck :dodo :lory :eaglet])


(#(str %) :mouse)
;=> ":mouse"


(map #(str %) animals)
;=> (":mouse" ":duck" ":dodo" ":lory" ":eaglet")


(class (map #(str %) animals))
;=> clojure.lang.LazySeq


(take 3 (map #(str %) (range)))
;=> ("0" "1" "2")

(take 10 (map #(str %) (range)))
;=> ("0" "1" "2" "3" "4" "5" "6" "7" "8" "9")


(println "Look at the mouse!")
; Look at the mouse!
;=> nil


(def animal-print (map #(println %) animals))
;=> #'user/animal-print


animal-print
; :mouse
; :duck
; :dodo
; :lory
; :eaglet
;=> (nil nil nil nil nil)


(def animal-print (doall (map #(println %) animals)))
; :mouse
; :duck
; :dodo
; :lory
; :eaglet
;=> #'user/animal-print

animal-print
;=> (nil nil nil nil nil)


(def animals
  ["mouse" "duck" "dodo" "lory" "eaglet"])

(def colors
  ["brown" "black" "blue" "pink" "gold"])

(defn gen-animal-string [animal color]
  (str color "-" animal))

(map gen-animal-string animals colors)
;=> ("brown-mouse" "black-duck" "blue-dodo"
;    "pink-lory" "gold-eaglet")


(def animals
  ["mouse" "duck" "dodo" "lory" "eaglet"])

(def colors
  ["brown" "black"])

(map gen-animal-string animals colors)
;=> ("brown-mouse" "black-duck")


(def animals
  ["mouse" "duck" "dodo" "lory" "eaglet"])

(map gen-animal-string animals (cycle ["brown" "black"]))
;=> ("brown-mouse" "black-duck" "brown-dodo"
;    "black-lory" "brown-eaglet")
