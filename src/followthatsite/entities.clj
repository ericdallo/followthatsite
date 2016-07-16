(ns followthatsite.entities
  (:use korma.core
        followthatsite.db))

(declare users)

(defentity users
  (pk :id)
  (table :user)
  (entity-fields :name))