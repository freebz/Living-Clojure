(ns tiny-maze.solver)

(defn- finish? [maze]
  (not-any? #{:E} (flatten maze)))

(defn- next-position [m w h]
  (let [i (.indexOf m :S)]
    (map #(assoc m % :S i :x)
         (filter #(and (> % 0)
                       (<= % (* w h))
                       (or (= 0 (get m %))
                           (= :E (get m %))))
                 [(+ i 1) (- i 1) (+ i w) (- i w)]))))

(defn- next-maze [m w h]
  (loop [m (next-position m w h)]
    (if (empty? m)
      nil
      (if (finish? (first m))
        (first m)
        (recur (concat (rest m) (next-position (first m) w h)))))))

(defn solve-maze [maze]
  (let [m (vec (flatten maze))
        w (count (get maze 0))
        h (count maze)
        n (next-maze m w h)
        i (.indexOf n :S)]
    (vec (map vec (partition w (assoc n i :x))))))
