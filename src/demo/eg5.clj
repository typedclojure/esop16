(ns demo.eg5
  (:refer-clojure :exclude [defn])
  (:require [clojure.core.typed :refer [defalias HMap Int defn ann]]))

(defalias RawKey Int)
(defalias EncKey Int)

(defn encrypt [k :- RawKey] :- EncKey, k)

(defalias RawKeyPair
  (HMap :mandatory {:public-key RawKey,
                    :private-key RawKey}))
(defalias EncKeyPair
  (HMap :mandatory {:public-key RawKey,
                    :enc-private-key EncKey},
        :absent-keys #{:private-key}))

(ann enc-keypair [RawKeyPair -> EncKeyPair])
(defn enc-keypair [{pkey :private-key, :as kp}]
  (assoc (dissoc kp :private-key)
    :enc-private-key (encrypt pkey)))
