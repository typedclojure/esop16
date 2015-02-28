(ns demo.eg6
  (:refer-clojure :exclude [fn defn])
  (:require [clojure.core.typed 
             :refer [defalias Num U fn ann-form defn Kw Any ann]]
            [demo.eg3 :refer [Expr]]))

(ann dec-leaf [Expr -> Expr])
(defn dec-leaf [m]
  (if (= (:op m) :if)
    {:op :if, 
     :test (dec-leaf (:test m)),
     :then (dec-leaf (:then m)),
     :else (dec-leaf (:else m))}
    (if (= (:op m) :do)
      {:op :do,
       :left  (dec-leaf (:left m)),
       :right (dec-leaf (:right m))}
      {:op :const,
       :val (dec (:val m))})))
