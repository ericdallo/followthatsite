(ns followthatsite.model.site
  (:use korma.core)
  (:require [followthatsite.entities :as e]))

(defn create [site]
  (insert e/sites
    (values site)))

(defn find-by-url [url]
	(first 
		(select e/sites 
			(where {:url url})
			(limit 1))))