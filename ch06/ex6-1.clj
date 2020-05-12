;; core.async 채널의 기본

(ns async-tea-party.core
  (:require [clojure.core.async
             :refer [>! <! >!! <!! chan close! go go-loop alts!]]))


(def tea-channel (chan))


(def tea-channel (chan 10))


(>!! tea-channel :cup-of-tea)
;=> true


(<!! tea-channel)
;=> :cup-of-tea


(>!! tea-channel :cup-of-tea-2)
;=> true

(>!! tea-channel :cup-of-tea-3)
;=> true

(>!! tea-channel :cup-of-tea-4)
;=> true

(close! tea-channel)
;=> nil


(>!! tea-channel :cup-of-tea-5)
;=> false


(<!! tea-channel)
;=> :cup-of-tea-2

(<!! tea-channel)
;=> :cup-of-tea-3

(<!! tea-channel)
;=> :cup-of-tea-4


(<!! tea-channel)
;=> nil


(>!! tea-channel nil)
;=> IllegalArgumentException Can't put nil on channel


(let [tea-channel (chan)]
  (go (>! tea-channel :cup-of-tea-1))
  (go (println "Thanks for the" (<! tea-channel))))
;; 화면에 출력된다
; Thanks for the :cup-of-tea-1


(def tea-channel (chan 10))

(go-loop []
  (println "Thanks for the" (<! tea-channel))
  (recur))


(>!! tea-channel :hot-cup-of-tea)
;; 화면에 출력된다
; Thanks for the :hot-cup-of-tea

(>!! tea-channel :tea-with-sugar)
;; 화면에 출력된다
; Thanks for the :tea-with-sugar

(>!! tea-channel :tea-with-milk)
;; 화면에 출력된다
; Thanks for the :tea-with-milk


(def tea-channel (chan 10))
(def milk-channel (chan 10))
(def sugar-channel (chan 10))


(go-loop []
  (let [[v ch] (alts! [tea-channel
                       milk-channel
                       sugar-channel])]
    (println "Got" v "from" ch)
    (recur)))


(>!! sugar-channel :sugar)

;; 화면에 출력된다
; Got :sugar from #object[clojure.core.async.impl.channels.ManyToManyChannel 0x14f04d6 ...]

(>!! milk-channel :milk)
;; 화면에 출력된다
; Got :milk from #object[clojure.core.async.impl.channels.ManyToManyChannel 0x99e559 ...]

(>!! tea-channel :tea)
;; 화면에 출력된다
; Got :tea from #object[clojure.core.async.impl.channels.ManyToManyChannel 0xe685fe ...]
