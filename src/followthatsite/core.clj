(ns followthatsite.core
  (:use [org.httpkit.server :only [run-server]])
  (:require [compojure.core :refer :all]
            [compojure.handler :refer [site]]
            [ring.middleware.defaults :refer :all]
            [selmer.parser :refer [render-file]]
            [ring.middleware.reload :refer [wrap-reload]]))

(selmer.parser/set-resource-path! (clojure.java.io/resource "templates"))

(defroutes all-routes
  (GET "/" []
    (render-file "index.html" {:title "Home"})))

(defn -main []
  (let [handler (wrap-reload (site #'all-routes))]
    (run-server handler {:port 5000})))
