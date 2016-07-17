(ns followthatsite.model.user
  (:use korma.core)
  (:require [followthatsite.entities :as e]))

(defn create [user]
  (insert e/users
    (values user)))

(defn find-by-name [name]
	(first 
		(select e/users 
			(where {:name name})
			(limit 1))))