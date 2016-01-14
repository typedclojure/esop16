(ns ^:core.typed demo.example7
  (:require [clojure.core.typed :refer [ann defalias Str]]))

;; Placeholders
(defalias RawKey Str)
(defalias EncKey Str)

(ann encrypt [RawKey -> EncKey])
(defn encrypt [k] k)

(defalias RawKeyPair ; extra keys disallowed
  (HMap :mandatory {:pub RawKey, :priv RawKey},
        :complete? true))
(defalias EncKeyPair ; extra keys disallowed
  (HMap :mandatory {:pub RawKey, :enc-priv EncKey}, :complete? true))

(ann enc-keypair [RawKeyPair -> EncKeyPair])
(defn enc-keypair [kp]
  (assoc (dissoc kp :priv) :enc-priv (encrypt (:priv kp))))
