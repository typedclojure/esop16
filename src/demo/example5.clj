(ns demo.example5
  {:lang :core.typed})

(def breakfast {:en "waffles" :fr "croissants"})
(:en breakfast)
;=> "waffles" :- Str
(:bocce breakfast) 
;=> nil :- nil
