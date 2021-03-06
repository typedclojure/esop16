(ns demo.example9
  {:lang :core.typed}
  (:refer-clojure :exclude [fn])
  (:require [clojure.core.typed :refer [ann Int fn]]
            [demo.example8 :refer [Order]]))

(ann desserts' [Order -> Int])
(defmulti desserts'
  (fn [o :- Order] (class (:desserts o))))
(defmethod desserts' Long [o]
  ;o :- (U '{:Meal (U ':dinner ':lunch), :desserts Int}
  ;        '{:Meal ':combo, :desserts Int, :meal1 Order, :meal2 Order})
  (:desserts o))

(defmethod desserts' nil [o]
  ; o :- '{:Meal ':combo, :meal1 Order, :meal2 Order}
  (+ (desserts' (:meal1 o)) (desserts' (:meal2 o))))

