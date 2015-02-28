(ns flippo.evaluate)

(defn evaluate [tree]
  "Evaluates a tree representation like {:operator
   #(+ %1 %2) :left {:value 1} :right {:value 2}}
   to the corresponding value, i.e. 3."
  (if (:operator tree)
    ((:operator tree) (evaluate (:left tree)) (evaluate (:right tree)))
    (:value tree)))
