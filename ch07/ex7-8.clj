;; 내용 협상과 몇 가지 유용한 기능을 가진 리버레이터 사용하기

(ns liberator-tutorial.core
  (:require [liberator.core :refer [resource defresource]]
            [ring.middleware.params :refer [wrap-params]]
                        [compojure.core :refer [defroutes ANY]]))


(ANY "/cat" []
     (resource :available-media-types ["text/plain"
                                       "text/html"
                                       "application/json"]
               :handle-ok
               #(let [media-type
                      (get-in % [:representation :media-type])]
                  (case media-type
                    "text/plain" "Cat"
                    "text/html" "<html><h2>Cat</h2></html>"
                    "application/json" {:cat true}))
               :handle-not-acceptable "No Cats Here!"))
