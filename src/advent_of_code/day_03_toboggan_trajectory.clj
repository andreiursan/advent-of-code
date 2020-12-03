(ns advent-of-code.day-03-toboggan-trajectory)

(def step-increment 3)

(defn element-on-position [steps locations]
  (let [length (count locations)
        relative-pos (mod (- steps 1) length)
        location (nth locations relative-pos)]
    (case location
      \. \O
      \# \X)))

(defn navigate [acc lane]
  (let [current-pos (:current-pos acc)
        new-pos (+ current-pos step-increment)]
    (-> (update acc :current-pos + step-increment)
        (update :path conj (element-on-position new-pos lane)))))

(defn toboggan-trip [lanes]
  (let [start-pos 1
        [_ & lanes-to-travel] lanes]
    (reduce navigate
            {:current-pos start-pos
             :path        []}
            lanes-to-travel)))

(defn toboggan-trees-count [all-lanes]
  (let [lanes (map seq all-lanes)
        trip (toboggan-trip lanes)]
    (->> (:path trip)
         (filter #(= \X %))
         count)))
