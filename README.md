# demo

Code to accompany [Typed Clojure paper](http://samth.github.io/typed-clojure-draft.pdf).

Example 1 is in `src/demo/eg1.clj`, and similarly for other examples.

## Usage

To check all examples, run `make test`.

For a Clojure REPL, run `make repl`. This will take you to the
`clojure.core.typed` namespace, where you can run specific
tests like.

```clojure
clojure.core.typed=> (check-ns 'demo.eg1)
```

## License

Copyright © 2015 Ambrose Bonnaire-Sergeant

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
