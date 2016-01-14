(ns ^:core.typed demo.example2
  (:import (java.io File))
  (:require [clojure.core.typed :refer [ann Str]]))

(ann parent [(U nil File) -> (U nil Str)])
(defn parent [f] (if f (.getParent f) nil))
