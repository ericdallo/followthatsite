(ns followthatsite.model.site
  (:use korma.core)
  (:require [followthatsite.entities :as e]))

(defn create [site]
  (insert e/sites
    (values site)))

(defn find-by-id [id]
  (first 
    (select e/sites 
      (where {:id id})
      (limit 1))))

(defn find-by-url [url]
  (first 
    (select e/sites 
      (where {:url url})
      (limit 1))))

(defn delete-by-id [id]
  (delete e/sites
    (where {:id id})))