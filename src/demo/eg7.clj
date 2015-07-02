(ns ^:core.typed demo.eg7
  (:refer-clojure :exclude [fn])
  (:require [clojure.core.typed :refer [fn]])
  (:import (java.io File)))

(fn [f :- File] (.getParent f))
