(ns followthatsite.entities
  (:use korma.core
        followthatsite.db))

(declare users sites )

(defentity users
  (pk :id)
  (table :user)
  (entity-fields :id :name)
  (has-many sites))

(defentity sites
	(pk :id)
  (belongs-to users)
  (table :site)
  (entity-fields :name :url))