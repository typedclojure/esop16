(ns demo.eg13
  (:import (java.io File))
  (:require [clojure.core.typed :refer [defalias ann U]]))

(defalias FS (U File String))

(ann open [FS FS -> File])
(defmulti open (fn [l r]
                 [(class l) (class r)]))
(defmethod open [File File] [^File f1, ^File f2]
  (let [s (.getPath f2)]
    (do (if (string? s) nil (throw (Exception.)))
        (File. f1 s))))
(defmethod open [String String] [s1 s2]
  (File. (str s1 "/" s2)))
(defmethod open [File String] [^File s1, ^String s2]
  (File. s1 s2))

(open (File. "dir") "a")         ;=> #<File dir/a>
(open "dir" "a/b")               ;=> #<File dir/a/b>
(open (File. "a/b") (File. "c")) ;=> #<File a/b/c>
