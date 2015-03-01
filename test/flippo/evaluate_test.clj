(ns flippo.evaluate-test
  (:require [clojure.test :refer :all]
            [flippo.evaluate :refer :all]))

(deftest evaluate-value-test
  (testing "evaluate a value"
    (is (= 1 (evaluate {:value 1})))))

(deftest evaluate-shallow-tree-test
  (testing "evaluate a shallow tree"
    (is (= 3 (evaluate {:operator #(+ %1 %2) :left {:value 1} :right {:value 2}})))))

(deftest evaluate-deep-tree-test
  (testing "evaluate a deep tree"
    (is (= 7 (evaluate
              {:operator #(+ %1 %2)
               :left {:value 1}
               :right {:operator #(* %1 %2)
                       :left  {:value 2}
                       :right {:value 3}}})))))
