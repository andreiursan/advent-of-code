(ns advent-of-code.day-02-password-philosophy-test
  (:require [clojure.test :refer :all]
            [advent-of-code.day-02-password-philosophy :refer :all]))

(def password-strings ["1-3 a: abcde"
                       "1-3 b: cdefg"
                       "2-9 c: ccccccccc"])

(deftest test-password-validation
  (testing "Find the number of valid passwords"
    (is (= 2 (count-valid-passwords-part1 password-strings)))
    (is (= 1 (count-valid-passwords-part2 password-strings)))))
