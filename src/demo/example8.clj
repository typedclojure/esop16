(ns ^:core.typed demo.example8
  (:require [clojure.core.typed :refer [ann Int]]))

(ann desserts [Order -> Int])
(defmulti desserts :Meal) ; dispatch on :Meal entry
(defmethod desserts :lunch [o] (:desserts o))
(defmethod desserts :dinner [o] (:desserts o))
(defmethod desserts :combo [o]
  (+ (desserts (:meal1 o)) (desserts (:meal2 o))))

(desserts {:Meal :combo, :meal1 {:Meal :lunch :desserts 1},
           :meal2 {:Meal :dinner :desserts 2}}) ;=> 3
