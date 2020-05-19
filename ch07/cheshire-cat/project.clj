(defproject cheshire-cat "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :min-lein-version "2.0.0"
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [compojure "1.4.0"]
                 [ring/ring-defaults "0.1.5"]
                 [ring/ring-json "0.4.0"]
                 [org.clojure/clojurescript "1.7.228"]
                 [cljs-http "0.1.39"]
                 [org.clojure/core.async "0.2.374"]
                 [enfocus "2.1.1"]
                 [enlive "1.1.6"]
                 [liberator "0.15.3"]
                 [com.cognitect/transit-clj "1.0.324"]
                 [com.cognitect/transit-cljs "0.8.264"]]
  :plugins [[lein-ring "0.9.7"]
            [lein-cljsbuild "1.1.1"]]
  :ring {:handler cheshire-cat.handler/app}
  :profiles
  {:dev {:dependencies [[javax.servlet/servlet-api "2.5"]
                        [ring/ring-mock "0.3.0"]]}}
  :cljsbuild {
      :builds [{
          :source-paths ["src-cljs"]
          :compiler {
            :output-to "resources/public/main.js"
            :optimizations :whitespace
            :pretty-print true}}]})
