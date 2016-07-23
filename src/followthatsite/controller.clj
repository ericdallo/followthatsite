(ns followthatsite.controller
  (:require [followthatsite.model.user :as user]
            [followthatsite.model.site :as site]
            [compojure.core :refer :all]
            [selmer.parser :refer [render-file]]
            [ring.util.response :refer [redirect]]))

(defn show-home []
  (render-file "index.html" {}))

(defn create-user [username]
  "Creates a user and redirect to his profile"
  (if (empty? (user/find-by-name username))
    (user/create {:name username}))
  (redirect (str "/" username)))

(defn find-user [username]
  "Find the user by name and show his profile"
  (let [user (user/find-by-name username)]
    (if (empty? user)
      (redirect "/")
      (render-file "profile.html" user))))

(defn create-site [username name url]
  "Creates a site for a user and redirect to his profile"
  (let [user (user/find-by-name username)]
    (if (and (not (empty? user)) (empty? (site/find-by-url url)))
      (site/create {:url url, 
                    :name name, 
                    :user_id (get user :id)})))
  (redirect (str "/" username)))
