# demo

Code to accompany [Typed Clojure paper](http://samth.github.io/typed-clojure-draft.pdf).

Example 1 is in `src/demo/eg1.clj`, and similarly for other examples.

## Usage

To check all examples, run `make test`.

For a Clojure REPL, run `make repl`. The `require` function loads and type checks namespaces.

```clojure
clojure.core.typed=> (require 'demo.eg1)
nil
```

To test that type checking is really happening, change one of the examples to insert a type
error, and use the `:reload` argument to `require`.

```clojure
;; src/demo/eg1.clj
(fn [x :- (U nil Num)]
  (if (number? x) (inc 'ABC) 0))
```

```clojure
clojure.core.typed=> (require 'demo.eg1 :reload)
Type Error (demo/eg1.clj:6:19) Static method clojure.lang.Numbers/inc could not be applied to arguments:


Domains:
        Number

Arguments:
        (clojure.core.typed/Val ABC)

Ranges:
        Number


in: (clojure.lang.Numbers/inc (quote ABC))


ExceptionInfo Type Checker: Found 1 error  clojure.core/ex-info (core.clj:4593)
```

## License

Copyright © 2015 Ambrose Bonnaire-Sergeant

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
