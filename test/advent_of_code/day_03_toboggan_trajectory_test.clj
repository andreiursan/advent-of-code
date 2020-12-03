(ns advent-of-code.day-03-toboggan-trajectory-test
  (:require [clojure.test :refer :all]
            [advent-of-code.day-03-toboggan-trajectory :refer :all]))

(def geology-input ["..##......."
                    "#...#...#.."
                    ".#....#..#."
                    "..#.#...#.#"
                    ".#...##..#."
                    "..#.##....."
                    ".#.#.#....#"
                    ".#........#"
                    "#.##...#..."
                    "#...##....#"
                    ".#..#...#.#"])
(deftest test-report
  (testing "Find the number of trees on the way"
    (is (= 7 (toboggan-trees-count geology-input)))))
