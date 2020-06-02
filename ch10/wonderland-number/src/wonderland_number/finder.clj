(ns wonderland-number.finder)

(defn wonderland-number []
  (loop [n 100000]
    (if (= n 999999)
      nil
      (if (every?
           #((fn [n1 n2]
               (let [s1 (set (str n1))
                     s2 (set (str n2))]
                 (= s1 s2)))
             n (* % n))
           (range 2 7))
        n
        (recur (+ n 1)))))
  )
