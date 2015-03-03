(ns flippo.transformation
  (:use [flippo.tree :only [map-tree]]))

(defn generator [elements]
  "Creates a generator that loops through the vector elements"
  (let [index (atom 0)]
    (fn []
      (let [current-index @index]
        (do
          (swap! index #(mod (inc %) (count elements)))
          (nth elements current-index))))))

(defn decorate [operators values tree]
  "Transforms a structured tree into a tree ready for evaluation. It walks the tree
   and transform nil nodes into value-nodes, and non-nil nodes into operator nodes.
   This is done in a cyclic fashion, both for the operators and the values."
  (let [
        operator-generator (generator operators)
        value-generator    (generator values)
        transformer        (fn [tree left right]
                             (if (nil? tree)
                               {:value (value-generator)}
                               {:operator (operator-generator) :left left :right right}))]
    (map-tree transformer tree)))
