(ns advent-of-code.day-02-password-philosophy)

(defn letter-frequency [letter password]
  (let [pattern (re-pattern letter)]
    (-> (re-seq pattern password)
        count)))

(defn frequency-in-range? [min-freq max-freq freq]
  (<= min-freq freq max-freq))

(defn valid-password? [{:keys [min-freq max-freq letter password]}]
  (->> (letter-frequency letter password)
       (frequency-in-range? min-freq max-freq)))

(defn string->password [password-str]
  (let [pattern (re-pattern "^(\\d+)-(\\d+) (.): (.+)")
        [_ min-freq max-freq letter password]
        (re-matches pattern password-str)]
    {:min-freq (Long/parseLong min-freq)
     :max-freq (Long/parseLong max-freq)
     :letter   letter
     :password password}))

(defn count-valid-passwords [password-strings]
  (->> (map string->password password-strings)
       (map valid-password?)
       (filter identity)
       count))
