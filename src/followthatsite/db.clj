(ns followthatsite.db
  (:use korma.db))

(defdb db (mysql
            { :classname "com.mysql.jdbc.Driver"
              :subprotocol "mysql"
              :subname "//localhost/followthatsite"
              :user "root"
              :password ""}))