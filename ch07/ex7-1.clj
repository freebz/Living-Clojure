;; 체셔 라이브러리와 링을 이용하여 JSON으로 응답하기

(ns cheshire-cat.handler
  (:require [cheshire.core :as json]))


(json/generate-string {:name "Cheshire Cat" :state :grinning})
;=> "{\"name\":\"Cheshire Cat\",\"state\":\"grinning\"}"


(json/parse-string
 "{\"name\":\"Cheshire Cat\",\"state\":\"grinning\"}")
;=> {"name" "Cheshire Cat", "state" "grinning"}


(json/parse-string
 "{\"name\":\"Cheshire Cat\",\"state\":\"grinning\"}" true)
;=> {:name "Cheshire Cat", :state "grinning"}
