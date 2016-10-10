(ns flippo.solution
  (:use [flippo.evaluate :only [safe-evaluate]])
  (:use [clojure.math.combinatorics :only [selections permutations]])
  (:use [flippo.tree :only [generate-structure-tree]])
  (:use [flippo.transformation :only [decorate]]))

(defn solve
  ([values]
   "Returns all trees that use the standard arithmetic operators to form 24"
   (solve 24 values))
  ([target values]
   "Returns all trees that use the standard arithmetic operators to form target"
   (solve [+ - * /] target values))
  ([operators target values]
   "Returns all trees that use operators to form target"
   (filter #(= target (safe-evaluate %))
           (let [nodes (dec (count values))]
             (for [os (selections operators nodes)
                   vs (permutations values)
                   tree (generate-structure-tree nodes)]
               (decorate os vs tree))))))
