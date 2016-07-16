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
            [korma "0.4.2"]
            [mysql/mysql-connector-java "5.1.6"]
            [migratus "0.8.13"]
            [migratus-lein "0.4.0"]
          ]
  :plugins [
  					[lein-sassy "1.0.7"]
  					[migratus-lein "0.3.7"]
  				 ]
  :sass {:src "resources/sass" 
  			 :dst "resources/public/css"
  			 :style :compressed}
  :hooks [leiningen.sass]
  :migratus {:store :database
             :migration-dir "migrations"
             :db {:classname "com.mysql.jdbc.Driver"
                  :subprotocol "mysql"
                  :subname "//localhost/followthatsite"
                  :user "root"
                  :password ""}}
  :main followthatsite.core)