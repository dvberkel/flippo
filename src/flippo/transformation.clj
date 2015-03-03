(ns flippo.transformation)

(defn generator [start]
  "Creates a generator that yields different values each times it is called"
  (let [state (atom start)]
    (fn []
      (let [current @state]
        (do
          (swap! state inc)
          current)))))
