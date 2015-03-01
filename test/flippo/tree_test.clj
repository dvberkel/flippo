(ns flippo.tree-test
  (:require [clojure.test :refer :all]
            [flippo.tree :refer :all]))

(deftest generate-structure-tree-test
  (testing "generate a structured trees with different number of nodes"
    (is (= [nil] (generate-structure-tree 0)))
    (is (= [{:left nil :right nil}] (generate-structure-tree 1)))
    (is (=
         [{:left {:left nil :right nil} :right nil} {:left nil :right {:left nil :right nil}}]
         (generate-structure-tree 2)))))
