(ns advent-of-code.day-03-toboggan-trajectory)

(defn element-on-position [steps locations]
  (let [length (count locations)
        relative-pos (mod (- steps 1) length)
        location (nth locations relative-pos)]
    (case location
      \. \O
      \# \X)))

(defn slide? [{:keys [current-step-down]}]
  (zero? (- current-step-down 1)))

(defn navigate [step-right step-down acc lane]
  (if (slide? acc)
    (let [current-pos (:current-pos acc)
          new-pos (+ current-pos step-right)]
      (-> (assoc acc :current-pos new-pos)
          (assoc :current-step-down step-down)
          (update :path conj (element-on-position new-pos lane))))
    (update acc :current-step-down dec)))

(defn toboggan-trip [lanes step-right step-down]
  (let [start-pos 1
        [_ & lanes-to-travel] lanes]
    (reduce (partial navigate step-right step-down)
            {:current-step-down step-down
             :current-pos start-pos
             :path        []}
            lanes-to-travel)))

(defn toboggan-trees-count [all-lanes step-right step-down]
  (let [lanes (map seq all-lanes)
        trip (toboggan-trip lanes step-right step-down)]
    (->> (:path trip)
         (filter #(= \X %))
         count)))

(defn toboggan-trees-count-part1 [all-lanes]
  (toboggan-trees-count all-lanes 3 1))

(defn toboggan-trees-count-part2 [all-lanes]
  (* (toboggan-trees-count all-lanes 1 1)
     (toboggan-trees-count all-lanes 3 1)
     (toboggan-trees-count all-lanes 5 1)
     (toboggan-trees-count all-lanes 7 1)
     (toboggan-trees-count all-lanes 1 2)))
