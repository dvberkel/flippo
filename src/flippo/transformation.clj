(ns flippo.transformation)

(defn generator [elements]
  "Creates a generator that loops through the vector elements"
  (let [index (atom 0)]
    (fn []
      (let [current-index @index]
        (do
          (swap! index #(mod (inc %) (count elements)))
          (nth elements current-index))))))
