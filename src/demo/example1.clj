(ns demo.example1
  {:lang :core.typed}
  (:import (java.io File)))

(.getParent (new File "a/b"))
;=> "a" :- (U nil Str)
