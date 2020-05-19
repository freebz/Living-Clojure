;; JSON의 대안으로 작고 빠른 트랜싯 사용하기

(require '[cognitect.transit :as transit])
(import [java.io ByteArrayInputStream ByteArrayOutputStream])

(def out (ByteArrayOutputStream. 4096))
(def writer (transit/writer out :json))


(transit/write writer "cat")


(.toString out)
;=> "[\"~#'\",\"cat\"]"


(def in (ByteArrayInputStream. (.toByteArray out)))
(def reader (transit/reader in :json))


(transit/read reader)
;=> "cat"
