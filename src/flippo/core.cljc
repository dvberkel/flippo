(ns flippo.core
  (:gen-class)
  (:use [flippo.solution :only [solve]]
        [flippo.representation :only [infix]]))

(defn -main
  "Print out a solution to the 24 problem given the arguments"
  [& args]
  (println (infix(first (take 1 (solve (vec (map #(Integer/valueOf %) args))))))))
