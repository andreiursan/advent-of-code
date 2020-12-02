(ns advent-of-code.day-01-report-repair-test
  (:require [clojure.test :refer :all]
            [advent-of-code.day-01-report-repair :refer :all]))

(def report-lines ["1721"
                   "979"
                   "366"
                   "299"
                   "675"
                   "1456"])

(deftest test-report
  (testing "Find the pair magic number"
    (is (= 514579 (find-magic-number-part1 report-lines))))
  (testing "Find the triplet magic number"
    (is (= 241861950 (find-magic-number-part2 report-lines)))))
