(ns ^:core.typed demo.eg4
  (:refer-clojure :exclude [defn])
  (:require [clojure.core.typed :refer [defalias HMap Int defn ann]]))

(defalias RawKey Int)
(defalias EncKey Int)

(defn encrypt [k :- RawKey] :- EncKey, k)

(defalias RawKeyPair
  (HMap :mandatory {:public-key RawKey,
                    :private-key RawKey},
        :complete? true))
(defalias EncKeyPair
  (HMap :mandatory {:public-key RawKey,
                    :enc-private-key EncKey},
        :complete? true))

(ann enc-keypair [RawKeyPair -> EncKeyPair])
(defn enc-keypair [kp]
  (assoc (dissoc kp :private-key)
    :enc-private-key (encrypt (:private-key kp))))
