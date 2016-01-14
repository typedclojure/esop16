(ns demo.core-test
  (:require [clojure.test :refer :all]))

(def typed-namespaces
  '[demo.intro
    demo.example1
    demo.example2
    demo.example3
    demo.example4
    demo.example5
    demo.example6
    demo.example7
    demo.example8
    demo.example9])

(deftest check-examples
  (is (mapv #(require % :reload) typed-namespaces)))
