(ns alphabet-cipher.coder)

(defn encode [keyword message]
  (apply str
         (map (fn [msg key]
                (let [a (int \a)
                      z (int \z)
                      m (int msg)
                      k (int key)
                      len (- z a -1)]
                  (char (+ (mod
                            (+ (- m a) (- k a))
                            len)
                           a)
                        )
                  )
                )
              message (cycle keyword))))

(defn decode [keyword message]
  (apply str
         (map (fn [msg key]
                (let [a (int \a)
                      z (int \z)
                      m (int msg)
                      k (int key)
                      len (- z a -1)]
                  (char (+ (mod
                            (- (- m a) (- k a))
                            len)
                           a)
                        )
                  )
                )
              message (cycle keyword))))


(defn decipher [cipher message]
  (apply str ((fn [cipher]
                (loop [acc []
                       c cipher]
                  (let [cip (conj acc (first c))
                        chk (every? true? (map #(= %1 %2) (cycle cip) cipher))]
                    (if chk cip
                        (recur cip (rest c))))))
              (map (fn [msg cipher]
                     (let [a (int \a)
                           z (int \z)
                           m (int msg)
                           c (int cipher)
                           len (- z a -1)]
                       (char (+ (mod
                                 (- (- c a) (- m a))
                                 len)
                                a)
                             )
                       )
                     )
                   message cipher))))
