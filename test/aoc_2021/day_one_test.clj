(ns aoc-2021.day-one-test
  (:require [clojure.test :refer :all]
            [aoc-2021.day-one :refer :all]))

(deftest day-one-part-one
  (testing "matches example"
    (is (= 7 (count-increases [199 200 208 210 200 207 240 269 260 263])))))

(deftest day-one-part-two
  (testing "matches example"
    (is (= 5 (count-increases (to-window-sums 3 [199 200 208 210 200 207 240 269 260 263]))))))
