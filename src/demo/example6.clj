(ns demo.example6
  {:lang :core.typed}
  (:require [clojure.core.typed :refer [ann Str]]))

(ann lunch '{:en Str :fr Str})
(def lunch {:en "muffin" :fr "baguette"})
(:bocce lunch) ;=> nil :- Any ; less accurate type
