(ns advent-of-code.core
  (:gen-class)
  (:require [advent-of-code.day-01-report-repair :as day-01]))


(defn -main
  "Used to dispatch tasks from the command line.
   > lein run d01.p1"
  [part]
  (case part
    "d01.p1" (println "Part 1 result: " (day-01/part1 "day01-input.txt"))
    "d01.p2" (println "Part 2 result: " (day-01/part2 "day01-input.txt"))
    (println "Unknown Argument")))
