(ns demo.intro
  {:lang :core.typed}
  (:import (java.io File))
  (:require [clojure.core.typed :refer [ann Str U]]))

(ann pname [(U File String) -> (U nil String)])
(defmulti pname class) ; multimethod dispatching on class of argument
(defmethod pname String [s] (pname (new File s))) ; String case
(defmethod pname File [f] (.getName f)) ; File case, static null check
(pname "STAINS/JELLY") ;=> "JELLY" :- (U nil Str)
