;; 이름공간에서 심볼을 관리하기

(ns alice.favfoods)
;=> nil


*ns*
;=> #namespace[alice.favfoods]


(def fav-food "strawberry jam")
;=> #'alice.favfoods/fav-food

fav-food
;=> "strawberry jam"


alice.favfoods/fav-food
;=> "strawberry jam"


(ns rabbit.favfoods)
;=> nil

fav-food
;=> CompilerException java.lang.RuntimeException:
;   Unable to resolve symbol: fav-food in this context


(ns rabbit.favfoods)

(def fav-food "lettuce soup")
;=> #'rabbit.favfoods/fav-food

fav-food
;=> "lettuce soup"


;; 합집합 구하기
(clojure.set/union #{:r :b :w} #{:w :p :y})
;=> #{:y :r :w :b :p}


(require 'clojure.set)


(ns wonderland)
;=> nil

;; 별칭 사용하기
(require '[alice.favfoods :as af])
;=> nil

af/fav-food
;=> "strawberry jam"


(ns wonderland
  (:require [alice.favfoods :as af]))

af/fav-food
;=> "strawberry jam"


(ns wonderland
  (:require [alice.favfoods :refer :all]
            [rabbit.favfoods :refer :all]))
;=> IllegalStateException fav-food already refers to:
;   #'alice.favfoods/fav-food in namespace: wonderland


(ns wonderland
  (:require [clojure.set :as s]))

(defn common-fav-foods [foods1 foods2]
  (let [food-set1 (set foods1)
        food-set2 (set foods2)
        common-foods (s/intersection food-set1 food-set2)]
    (str "Common Foods: " common-foods)))

(common-fav-foods [:jam :brownies :toast]
                  [:lettuce :carrots :jam])
;=> "Common Foods: #{:jam}"
