(ns aoc-2021.day-2-test
  (:require [clojure.test :refer :all]
            [aoc-2021.day-2 :refer :all]))

(deftest day-two-part-one
  (let [example (parse-course "forward 5\ndown 5\nforward 8\nup 3\ndown 8\nforward 2")]
    (testing "example depth matches"
      (is (= 10 (part-one-depth-after example))))
    (testing "example horizontal position matches"
      (is (= 15 (hpos-after example))))))

(deftest day-two-part-two
  (testing "example depth matches"
    (is (= 60 (part-two-depth-after (parse-course "forward 5\ndown 5\nforward 8\nup 3\ndown 8\nforward 2"))))))