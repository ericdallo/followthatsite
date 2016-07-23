(ns followthatsite.model.user
  (:use korma.core)
  (:require [followthatsite.entities :as e]))

(defn create [user]
  (insert e/users
    (values user)))

(defn find-by-name [name]
	(first 
		(select e/users
			(with e/sites)
			(where {:name name})
			(limit 1))))