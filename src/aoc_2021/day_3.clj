(ns aoc-2021.day-3
  (:require [clojure.string :as str]))

(defn parse-input [s]

  (->> (str/split s #"\n")
       (map #(str/split % #""))
       (map (partial map (partial = "1"))))
  )

(defn filter-by-nth-bit [xs n match]
  (filter #(= match (nth % n)) xs))

(defn nth-most-common-bit [input n]
  (-> (filter-by-nth-bit input n true)
      count
      (/ (count input))
      (>= 1/2)))

(defn to-number [bs]
  (reduce #(bit-or (bit-shift-left %1 1) ({false 0 true 1} %2)) 0 bs))

(defn bitwise-most-common [input]
  (map (partial nth-most-common-bit input)
       (range (count (first input)))))

(def gamma-rate (comp to-number bitwise-most-common))

(def epsilon-rate (comp to-number (partial map not) bitwise-most-common))

(defn oxygen-generator-rating [input]
  (loop [xs input n 0]
    (let [numbers (filter-by-nth-bit xs n (nth-most-common-bit xs n))]
      (if (= 1 (count numbers))
        (to-number (first numbers))
        (recur numbers (+ 1 n))))))

(defn co2-scrubber-rating [input]
  (loop [xs input n 0]
    (let [numbers (filter-by-nth-bit xs n (not (nth-most-common-bit xs n)))]
      (if (= 1 (count numbers))
        (to-number (first numbers))
        (recur numbers (+ 1 n))))))

(defn part-one-answer []
  (let [input (parse-input (slurp "resources/day-3"))]
    (* (gamma-rate input) (epsilon-rate input))))

(defn part-two-answer []
  (let [input (parse-input (slurp "resources/day-3"))]
    (* (oxygen-generator-rating input) (co2-scrubber-rating input))))