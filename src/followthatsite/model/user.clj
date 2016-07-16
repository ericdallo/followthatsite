(ns followthatsite.model.user
  (:use korma.core)
  (:require [followthatsite.entities :as e]))

(defn create [user]
  (insert e/users
    (values user)))