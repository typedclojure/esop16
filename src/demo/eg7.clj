(ns demo.eg7
  (:refer-clojure :exclude [fn])
  (:require [clojure.core.typed :refer [fn]])
  (:import (java.io File)))

(fn [^File f :- File] (.getParent f))
