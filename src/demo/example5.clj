(ns ^:core.typed demo.example5)

(def breakfast {:en "waffles" :fr "croissants"})
(:en breakfast)
;=> "waffles" :- Str
(:bocce breakfast) 
;=> nil :- nil
