(ns aoc-2021.day-1
  (:require [clojure.string :as str]))

(defn load-input [path]
  (map #(Integer/parseInt %)
       (-> (slurp path)
           (str/split #"\n"))))

(defn count-increases [xs]
  (->> (into [Integer/MAX_VALUE] xs)
       (map vector xs)
       (filter (partial apply >))
       count))

(defn to-window-sums [n xs]
  (map (partial apply +) (partition n 1 xs)))

(defn part-one-answer [] (count-increases (load-input "resources/day-1")))

(defn part-two-answer [] (count-increases (to-window-sums 3 (load-input "resources/day-1"))))
