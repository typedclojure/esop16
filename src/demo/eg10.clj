(ns ^:core.typed demo.eg10
  (:refer-clojure :exclude [fn])
  (:require [clojure.core.typed :refer [fn]])
  (:import (java.io File)))

(fn [s :- String] :- File
  (File. s))
