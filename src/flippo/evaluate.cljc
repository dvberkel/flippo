(ns flippo.evaluate)

(defn evaluate [tree]
  "Evaluates a tree representation like {:operator + :left {:value 1} :right {:value 2}}
   to the corresponding value, i.e. 3."
  (if (:operator tree)
    ((:operator tree) (evaluate (:left tree)) (evaluate (:right tree)))
    (:value tree)))

(defn safe-evaluate [tree]
  "Evaluates a tree representation like {:operator + :left {:value 1} :right {:value 2}}
   to the corresponding value, i.e. 3. Returns nil on ArithmiticException"
  (try
    (evaluate tree)
    (catch ArithmeticException e nil)))
