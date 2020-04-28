;; 함수 만들기

(defn follow-the-rabbit [] "Off we go!")
;=> #'user/follow-the-rabbit

(follow-the-rabbit)
;=> "Off we go!"


(defn shop-for-jams [jam1 jam2]
  {:name "jam-basket"
   :jam1 jam1
   :jam2 jam2})
;=> #'user/shop-for-jams

(shop-for-jams "strawberry" "marmalade")
;=> {:name "jam-basket", :jam1 "strawberry", :jam2 "marmalade"}


;; 함수를 반환한다
(fn [] (str "Off we go" "!"))
;=> #function[user/eval4599/fn--4600]

;; 괄호를 감싸서 호출한다
((fn [] (str "Off we go" "!")))
;=> "Off we go!"


(def follow-again (fn [] (str "Off we go" "!")))
;=> #'user/follow-again

(follow-again)
;=> "Off we go!"


(#(str "Off we go" "!"))
;=> "Off we go!"


(#(str "Off we go" "!" " - " %) "again")
;=> "Off we go! - again"


(#(str "Off we go" "1" " - " %1 %2) "again" "?")
;=> "Off we go1 - again?"
