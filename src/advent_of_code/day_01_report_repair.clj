(ns advent-of-code.day-01-report-repair
  (:require [clojure.java.io :as io]))

(defn read-file [file-name]
  (io/reader (io/resource file-name)))

(defn file->report [file-name]
  (map #(Long/parseLong %) (line-seq (read-file file-name))))

(defn find-magic-number-part1 [report]
  (first (for [a report
               b report
               :when (= 2020 (+ a b))]
           (* a b))))

(defn find-magic-number-part2 [report]
  (first (for [a report
               b report
               c report
               :when (= 2020 (+ a b c))]
           (* a b c))))

(defn part1 [report-file]
  (let [report (file->report report-file)]
    (find-magic-number-part1 report)))

(defn part2 [report-file]
  (let [report (file->report report-file)]
    (find-magic-number-part2 report)))