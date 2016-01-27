(ns demo.example8
  {:lang :core.typed}
  (:require [clojure.core.typed :refer [defalias U ann Int]]))

(defalias Order "A meal order, tracking dessert quantities."
  (U '{:Meal ':lunch, :desserts Int} '{:Meal ':dinner :desserts Int}
     '{:Meal ':combo :meal1 Order :meal2 Order}))

(ann desserts [Order -> Int])
(defmulti desserts :Meal) ; dispatch on :Meal entry
(defmethod desserts :lunch [o] (:desserts o))
(defmethod desserts :dinner [o] (:desserts o))
(defmethod desserts :combo [o]
  (+ (desserts (:meal1 o)) (desserts (:meal2 o))))

(desserts {:Meal :combo, :meal1 {:Meal :lunch :desserts 1},
           :meal2 {:Meal :dinner :desserts 2}}) ;=> 3
