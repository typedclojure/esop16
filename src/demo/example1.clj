(ns ^:core.typed demo.example1
  (:import (java.io File)))

(.getParent (new File "a/b"))
;=> "a" :- (U nil Str)
