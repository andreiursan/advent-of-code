(ns advent-of-code.day-03-toboggan-trajectory)

(defn element-on-position [steps locations]
  (let [length (count locations)
        relative-pos (mod (- steps 1) length)
        location (nth locations relative-pos)]
    (case location
      \. \O
      \# \X)))

(defn navigate [acc lane]
  (let [current-pos (:current-pos acc)
        step-right (:step-right acc)
        current-step-down (- (:current-step-down acc) 1)
        new-pos (+ current-pos step-right)]
    (if (zero? current-step-down)
      (-> (assoc acc :current-pos new-pos)
          (assoc :current-step-down (:step-down acc))
          (update :path conj (element-on-position new-pos lane)))
      (assoc acc :current-step-down current-step-down))))

(defn toboggan-trip [lanes step-right step-down]
  (let [start-pos 1
        [_ & lanes-to-travel] lanes]
    (reduce navigate
            {:step-right step-right
             :step-down step-down
             :current-step-down step-down
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