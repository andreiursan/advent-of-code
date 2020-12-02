(ns advent-of-code.day-01-report-repair)

(defn report-line->number [report-line]
  (Long/parseLong report-line))

(defn find-magic-number-part1 [report-lines]
  (let [report (map report-line->number report-lines)]
    (first (for [a report
                 b report
                 :when (= 2020 (+ a b))]
             (* a b)))))

(defn find-magic-number-part2 [report-lines]
  (let [report (map report-line->number report-lines)]
    (first (for [a report
                 b report
                 c report
                 :when (= 2020 (+ a b c))]
             (* a b c)))))
