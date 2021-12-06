(ns aoc-2021.day-3-test
  (:require [clojure.test :refer :all]
            [aoc-2021.day-3 :refer :all]))

(def test-input (parse-input "00100\n11110\n10110\n10111\n10101\n01111\n00111\n11100\n10000\n11001\n00010\n01010"))

(deftest day-three-part-one
  (testing "gamma rate matches example"
    (is (= 22 (gamma-rate test-input))))

  (testing "epsilon rate matches example"
    (is (= 9 (epsilon-rate test-input)))))

(deftest day-three-part-two
  (testing "oxygen generator rating matches example"
    (is (= 23 (oxygen-generator-rating test-input))))

  (testing "CO2 scrubber rating matches example"
    (is (= 10 (co2-scrubber-rating test-input)))))