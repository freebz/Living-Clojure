;; 인라이브를 이용해 정적 HTML 파일을 템플릿으로 사용하기

(require '[net.cgrand.enlive-html :as enlive])

(def my-snippet (enlive/html-snippet
                 "<div id='foo'><p>Buttered Scones</p></div>"))


(enlive/at my-snippet [:div#foo] (enlive/html-content "Marmalade"))
