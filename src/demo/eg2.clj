(ns demo.eg2
  (:refer-clojure :exclude [fn])
  (:require [clojure.core.typed :refer [fn U Num]]))

(fn [x :- (U nil Num)]
  (do (if (number? x) nil (throw (Exception.)))
      (inc x)))
