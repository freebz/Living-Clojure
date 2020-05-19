;; 히컵을 이용해 HTML 만들기

(use 'hiccup.core)

(html
 [:h1 "Hi there"]
 [:div.blue "blue div"
  [:div.yellow "yellow div"
   [:div#bob "id bob"]]])
;=> "<h1>Hi there</h1>
;      <div class=\"blue\">blue div
;        <div class=\"yellow\">yellow div
;          <div id=\"bob\">id bob</div>
;      </div>
;    </div>"
