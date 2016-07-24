(ns followthatsite.routes
  (:use [org.httpkit.server :only [run-server]]
        [followthatsite.controller])
  (:require [compojure.core :refer :all]
            [compojure.handler :refer [site]]
            [compojure.route :as route]
            [ring.middleware.reload :refer [wrap-reload]]))

(selmer.parser/set-resource-path! (clojure.java.io/resource "templates"))

(defroutes all-routes
  (GET "/" []
    (show-home))
  (POST "/users" [username]
    (create-user username))
  (GET "/:username" [username]
    (find-user-profile username))
  (POST "/:username" [username site-name site-url]
    (create-site username site-name site-url))
  (DELETE "/:username/sites/:site-id" [username site-id]
    (delete-site-for username site-id))

  (route/resources "/")
  (route/not-found "Not found"))

(defn -main []
  (let [handler (wrap-reload (site #'all-routes))]
    (run-server handler {:port 5000})))
