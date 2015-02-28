(ns demo.eg12
  (:require [clojure.core.typed :refer [ann]]
            [demo.eg3 :refer [Expr]]))

(ann inc-leaf [Expr -> Expr])
(defmulti inc-leaf :op)
(defmethod inc-leaf :if [{tt :test, t :then, e :else}]
  {:op :if,
   :test (inc-leaf tt),
   :then (inc-leaf t), 
   :else (inc-leaf e)})
(defmethod inc-leaf :do [{l :left, r :right}]
  {:op :do,
   :left  (inc-leaf l),
   :right (inc-leaf r)})
(defmethod inc-leaf :const [{v :val}]
  {:op :const,
   :val (inc v)})

(inc-leaf {:op :if,
           :test {:op :const :val 1}
           :then {:op :do,
                  :left  {:op :const, :val 2} 
                  :right {:op :const, :val 3}}
           :else {:op :const, :val 4}})
;=> {:op :if, 
;    :test {:op :const, :val 2}, 
;    :then {:op :do, 
;           :left {:op :const, :val 3}, 
;           :right {:op :const, :val 4}}, 
;    :else {:op :const, :val 5}}
