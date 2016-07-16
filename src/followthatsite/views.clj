(ns followthatsite.views
  (:require [followthatsite.model.user :as user]
            [compojure.core :refer :all]
            [ring.util.response :refer [redirect]]))


(defn create-user [username]
  "Creates a user and redirect to his profile"
  (user/create {:name username})
  (redirect (str "/" username)))