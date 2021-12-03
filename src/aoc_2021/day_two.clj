(ns aoc-2021.day-two
  (:require [clojure.string :as str]))

(defn- parse-command [c]
  (let [[direction value] (str/split c #" ")]
    [(keyword direction) (Integer/parseInt value)]))

(defn parse-course [s]
  (map parse-command (str/split-lines s)))

(defn hpos-after [course]
  (->> (filter #(= :forward (first %)) course)
       (map second)
       (reduce +)))

(defn part-one-depth-after [course]
  (->> (filter #(contains? #{:up :down} (first %)) course)
       (map #(if (= :up (first %)) (- (second %)) (second %)))
       (reduce +)))

(defn part-two-depth-after [course]
  (second
    (reduce #(let [[current-aim current-depth] %1
                   [command x] %2]
               (cond
                 (= :up command) [(- current-aim x) current-depth]
                 (= :down command) [(+ current-aim x) current-depth]
                 (= :forward command) [current-aim (+ current-depth (* current-aim x))]))
            [0 0]
            course)))

(defn part-one-answer []
  (let [course (parse-course (slurp "resources/day-two"))]
    (* (part-one-depth-after course) (hpos-after course))))

(defn part-two-answer []
  (let [course (parse-course (slurp "resources/day-two"))]
    (* (part-two-depth-after course) (hpos-after course))))