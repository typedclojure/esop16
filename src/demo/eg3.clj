(ns demo.eg3
  (:refer-clojure :exclude [fn defn])
  (:require [clojure.core.typed :refer 
             [defalias Num U fn ann-form defn Kw Any ann]]))

(defalias Expr
  (U '{:op ':if, :test Expr, :then Expr, :else Expr}
     '{:op ':do, :left Expr, :right Expr}
     '{:op ':const, :val Num}))

(defn an-exp [] :- Expr
  (let [v {:op :const, :val 1}]
    {:op :do, :left v, :right v}))
