(ns demo.eg8
  (:refer-clojure :exclude [defn])
  (:require [clojure.core.typed :refer [U defn]])
  (:import (java.io File)))

(defn parent [^File f :- (U nil File)]
  (if f (.getParent f) nil))
