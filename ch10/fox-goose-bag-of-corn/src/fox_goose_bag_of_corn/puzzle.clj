(ns fox-goose-bag-of-corn.puzzle)

(def start-pos [[[:fox :goose :corn :you] [:boat] []]])

(def end-pos [#{} #{:boat} #{:fox :goose :corn :you}])

(defn moves-from-left [[left boat right]]
  (into
   [[(disj left :you) (conj boat :you) right]]
   (map (fn [animal]
          [(disj left :you animal) (conj boat :you animal) right])
        (disj left :you))))
  
(defn moves-from-right [[left boat right]]
  (into
   [[left (conj boat :you) (disj right :you)]]
   (map (fn [animal]
          [left (conj boat :you animal) (disj right :you animal)])
        (disj right :you))))

(defn moves-from-boat [[left boat right]]
  (let [animal (first (disj boat :boat :you))]
    (if animal
      [[(conj left :you animal) #{:boat} right]
       [left #{:boat} (conj right :you animal)]]
      [[(conj left :you) (disj boat :you) right]
       [left (disj boat :you) (conj right :you)]]
      )))

(defn next-moves' [pos]
  (let [[left _ right] pos]
    (cond (left :you) (moves-from-left pos)
          (right :you) (moves-from-right pos)
          :else (moves-from-boat pos))))

(defn unsafe? [[left _ right]]
  (cond
    (not (left :you)) (or (and (every? left [:goose :fox]))
                          (and (every? left [:goose :corn])))
    (not (right :you)) (or (and (every? right [:goose :fox]))
                           (and (every? right [:goose :corn])))
    :else false))

(defn visited? [path pos]
  (some #(= pos %) path))

(defn next-moves [path]
  (remove #(visited? path %)
          (remove unsafe?
                  (next-moves' (last path)))))

(defn search [path]
  (let [pos (last path)]
    (cond
      (= end-pos pos) [path]
      :else (let [next-moves (next-moves path)]
              (if (seq? next-moves)
                (mapcat #(search (conj path %)) next-moves))))))

(defn convert-to-sets [positions]
  (mapv (partial mapv set) positions))

(defn convert-to-vects [positions]
  (mapv (partial mapv vec) positions))

(defn river-crossing-plan []
  (let [path (convert-to-sets start-pos)
        result (search path)]
    (convert-to-vects (first result))))
