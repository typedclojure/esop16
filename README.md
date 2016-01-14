# ESOP16 code

Code to accompany [Typed Clojure paper](FIXME).

Example 1 is in `src/demo/example1.clj`, and similarly for other examples.

## Usage

To check all examples, run `make test`.

For a Clojure REPL, run `make repl`. The `require` function loads and type checks namespaces.

```clojure
clojure.core.typed=> (require 'demo.example1)
nil
```

## License

Copyright © 2016 Ambrose Bonnaire-Sergeant

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
