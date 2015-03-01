(ns demo.intro
  (:require [clojure.core.typed :refer [ann Str U]])
  (:import (java.io File)))

(ann parent ['{:file (U nil File)} -> (U nil Str)])
(defn parent [{^File f :file}]
  (if f (.getParent f) nil))
