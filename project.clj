(defproject demo "0.1.0-SNAPSHOT"
  :description "Examples for Typed Clojure paper"
  :url "http://samth.github.io/typed-clojure-draft.pdf"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :repl-options {:nrepl-middleware [clojure.core.typed.repl/wrap-clj-repl]}
  :dependencies [[org.clojure/clojure "1.7.0"]
                 [org.clojure/core.typed "0.3.6-SNAPSHOT"]])
