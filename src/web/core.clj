(ns web.core
  (:require [org.httpkit.server :as s]
            [compojure.core :refer [routes POST GET ANY]]))

(defn app []
  (routes
    (GET "/" [:as req]
        {:status 200
         :headers {"Content-Type" "text/html"}
         :body "<h1> Hello from root route!</h1>"}
        )
     (GET "/:user-name" [user-name :as req]
        {:status 200
          :headers {"Content-Type" "text/html"}
          :body (format "<h1> Hello from %s! </h1>" user-name)}
      )
    ))

(defn create-server []
  (s/run-server (app) {:port 8080}))

(defn stop-server [server]
  (server :timeout 100))
