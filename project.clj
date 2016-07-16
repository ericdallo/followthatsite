(defproject followthatsite "1.0.0-SNAPSHOT"
  :description "Follow that site"
  :url "https://github.com/ericdallo/followthatsite"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [
            [org.clojure/clojure "1.8.0"]
            [compojure "1.5.1"]
            [http-kit "2.1.18"]
            [ring/ring-defaults "0.2.1"]
            [ring/ring-devel "1.5.0"]
            [selmer "1.0.7"]
          ]
  :plugins [
  					[lein-sassy "1.0.7"]
  				 ]
  :sass {:src "resources/sass" 
  			 :dst "resources/public/css"
  			 :style :compressed}
  :hooks [leiningen.sass]
  :main followthatsite.core)