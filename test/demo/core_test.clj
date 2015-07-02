(ns demo.core-test
  (:require [clojure.test :refer :all]
            [clojure.core.typed :refer [check-ns]]))

(def typed-namespaces
  '[demo.intro
    demo.eg1
    demo.eg2
    demo.eg3
    demo.eg4
    demo.eg5
    demo.eg6
    demo.eg7
    demo.eg8
    demo.eg9
    demo.eg10
    demo.eg11
    demo.eg12
    demo.eg13
    demo.eg14])

(deftest check-examples
  (is (mapv #(require % :reload) typed-namespaces)))
