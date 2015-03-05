(ns flippo.solution-test
  (:require [clojure.test :refer :all]
            [flippo.solution :refer :all]
            [flippo.evaluate :refer :all]))

(deftest solve-test
  (testing "solve instances of the general problem"
    (is (= (not (empty? (solve 1 [1 2])))))
    (is (= (not (empty? (solve [/] 2 [2 4]))))))
  (testing "solve instances of the 24 problem"
    (is (= (not (empty? (solve [1 2 3 4])))))))
