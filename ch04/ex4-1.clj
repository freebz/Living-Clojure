;; 자바 코드 가져다 쓰기

(class "caterpillar")
;=> java.lang.String


;; String cString = new String("caterpillar");
;; cString.toUpperCase();


(. "caterpillar" toUpperCase)
;=> "CATERPILLAR"


(.toUpperCase "caterpillar")
;=> "CATERPILLAR"


;; String c1String = new String("caterpillar");
;; String c2String = new String("pillar");
;; c1String.indexOf(c2String);


(.indexOf "caterpillar" "pillar")
;=> 5


(new String "Hi!!")
;=> "Hi!!"


(String. "Hi!!")
;=> "Hi!!"


(ns caterpillar.network
  (:import (java.net InetAddress)))


(InetAddress/getByName "localhost")
;=> #object[java.net.Inet4Address 0x1fb9878 "localhost/127.0.0.1"]


(.getHostName (InetAddress/getByName "localhost"))
;=> "localhost"


(java.net.InetAddress/getByName "localhost")
;=> #object[java.net.Inet4Address 0x1e49dc7 "localhost/127.0.0.1"]


(def sb (doto (StringBuffer. "Who ")
          (.append "are ")
          (.append "you?")))

(.toString sb)
;=> "Who are you?"


(def sb
  (.append
   (.append
    (StringBuffer. "Who ")
    "are ")
   "you?"))
(.toString sb)

;=> "Who are you?"


(import 'java.util.UUID)

(UUID/randomUUID)
;=> #uuid "cc7fa2df-57e5-4d8b-ae5d-3e470e2b61b1"
