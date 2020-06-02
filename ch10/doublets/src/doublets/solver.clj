(ns doublets.solver
  (:require [clojure.java.io :as io]
            [clojure.edn :as edn]))

(def words (-> "words.edn"
               (io/resource)
               (slurp)
               (read-string)))

(defn- get-distance [word1 word2]
  (count (filter false? (map = word1 word2))))

(defn- sort-by-distance [word words]
  (sort-by #(get-distance word %) words))

(defn- remove-visited [visited doublets]
  (remove #(some #{%} visited) doublets))

(defn- get-doublets [word1 word2 visited]
  (->> (filter (fn [w] (and (= (count word1) (count w))
                            (= 1 (get-distance word1 w)))) words)
       (remove-visited visited) (sort-by-distance word2)))

(defn doublets [word1 word2]
  (if-not (= (count word1) (count word2))
    []
    (loop [word1 word1
           word2 word2
           visited []]
      (let [word-turn (first (get-doublets word1 word2 visited))]
        (if (= word-turn word2)
          (concat visited [word1 word2])
          (recur word-turn word2 (concat visited [word1])))))))
