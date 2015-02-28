(ns demo.eg10
  (:refer-clojure :exclude [fn])
  (:require [clojure.core.typed :refer [fn]])
  (:import (java.io File)))

(fn [^String s :- String] :- File
  (File. s))
