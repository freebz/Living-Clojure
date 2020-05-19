(ns cheshire-cat.handler
  (:require [ring.util.response :as rr]))

(rr/response {:name "Cheshire Cat" :status :grinning})
;=> {:status 200,
;    :headers {},
;    :body {:name "Cheshire Cat", :status :grinning}}
