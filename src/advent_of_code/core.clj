(ns advent-of-code.core
  (:gen-class)
  (:require [advent-of-code.day-01-report-repair :as day-01]
            [advent-of-code.day-02-password-philosophy :as day-02]
            [clojure.java.io :as io]))

(defn file->line-seq [file-name]
  (io/reader (io/resource file-name))
  (-> (io/resource file-name)
      io/reader
      line-seq))

(defn -main
  "Used to dispatch tasks from the command line.
   > lein run d01.p1"
  [part]
  (case part
    "d01.p1" (println "Day 01 part 1 result: "
                      (day-01/find-magic-number-part1 (file->line-seq "day01-input.txt")))
    "d01.p2" (println "Day 01 part 2 result: "
                      (day-01/find-magic-number-part2 (file->line-seq "day01-input.txt")))
    "d02.p1" (println "Day 02 part 1 result: "
                      (day-02/count-valid-passwords (file->line-seq "day02-input.txt")))
    (println "Unknown Argument")))
