(ns followthatsite.core
  (:require [compojure.core :refer :all]
  			[ring.middleware.defaults :refer :all]
            [org.httpkit.server :refer [run-server]]
            [selmer.parser :refer [render-file]]))

(defroutes followthatsite
  (GET "/" [] 
  	(render-file "templates/index.html" {:name "Greg"})))

(defn -main []
  (run-server followthatsite {:port 5000}))
