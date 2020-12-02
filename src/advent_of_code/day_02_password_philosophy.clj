(ns advent-of-code.day-02-password-philosophy)

(defn string->password [password-str]
  (let [pattern (re-pattern "^(\\d+)-(\\d+) (.): (.+)")
        [_ min-freq max-freq letter password]
        (re-matches pattern password-str)]
    [(Long/parseLong min-freq)
     (Long/parseLong max-freq)
     letter
     password]))

(defn letter-frequency [letter password]
  (let [pattern (re-pattern letter)]
    (-> (re-seq pattern password)
        count)))

(defn frequency-in-range? [min-freq max-freq freq]
  (<= min-freq freq max-freq))

(defn valid-password-part1? [[min-freq max-freq letter password]]
  (->> (letter-frequency letter password)
       (frequency-in-range? min-freq max-freq)))

(defn valid-password-part2? [[pos1 pos2 letter password]]
  (let [password-chars (->> (seq password) (map str))
        char-pos1 (nth password-chars (- pos1 1))
        char-pos2 (nth password-chars (- pos2 1))]
    (case [(= char-pos1 letter) (= char-pos2 letter)]
      [true false] true
      [false true] true
      false)))

(defn count-valid-passwords-part1 [password-strings]
  (->> (map string->password password-strings)
       (map valid-password-part1?)
       (filter identity)
       count))

(defn count-valid-passwords-part2 [password-strings]
  (->> (map string->password password-strings)
       (map valid-password-part2?)
       (filter identity)
       count))
