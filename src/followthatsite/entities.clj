(ns followthatsite.entities
  (:use korma.core
        followthatsite.db))

(declare users sites )

(defentity users
  (table :user)
  (entity-fields :id :name)
  (has-many sites))

(defentity sites
  (table :site)
  (entity-fields :id :name :url)
  (belongs-to users))