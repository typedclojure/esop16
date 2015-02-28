(ns demo.eg9
  (:refer-clojure :exclude [defn])
  (:require [clojure.core.typed :refer [ann Str U defn]])
  (:import (java.io File)))

(ann parent [(U nil File) -> (U nil Str)])
(defn parent [^File f]
  (if f (.getParent f) nil))
