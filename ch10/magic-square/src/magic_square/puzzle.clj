(ns magic-square.puzzle
  (:require [clojure.math.combinatorics :as c]))

(def values [1.0 1.5 2.0 2.5 3.0 3.5 4.0 4.5 5.0])

(defn- sum-rows [m]
  (map #(reduce + %) m))

(defn- sum-cols [m]
  [(reduce + (map first m))
   (reduce + (map second m))
   (reduce + (map last m))])

(defn- sum-diagonals [m]
  [(+ (get-in m [0 0]) (get-in m [1 1]) (get-in m [2 2]))
   (+ (get-in m [2 0]) (get-in m [1 1]) (get-in m [0 2]))])


(defn- vec-partition [values]
  (vec (map vec (partition 3 values))))

(defn- check [values]
  (let [r (sum-rows values)
        c (sum-cols values)
        d (sum-diagonals values)
        v (first r)]
    (and (every? #(= v %) r)
         (every? #(= v %) c)
         (every? #(= v %) d))))

(defn magic-square [values]
  (first (filter check (map vec-partition (c/permutations values)))))
