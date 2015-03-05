(ns flippo.solution
  (:use [flippo.evaluate :only [evaluate]])
  (:use [clojure.math.combinatorics :only [selections permutations]])
  (:use [flippo.tree :only [generate-structure-tree]])
  (:use [flippo.transformation :only [decorate]]))

(defn solve
  ([a b c d]
   "Returns all trees that use the standard arithmetic operators to form 24"
   (solve 24 a b c d))
  ([target a b c d]
   "Returns all trees that use the standard arithmetic operators to form target"
   (solve [+ - * /] target a b c d))
  ([operators target a b c d]
   "Returns all trees that use operators to form target"
   (filter #(= target (evaluate %))
           (let [values [a b c d] nodes (count values)]
             (for [os (selections operators nodes)
                   vs (permutations values)
                   tree (generator-structure-tree nodes)]
               (decorate os vs tree))))))
