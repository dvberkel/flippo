(ns flippo.representation-test
  (:require [clojure.test :refer :all]
            [flippo.representation :refer :all]))

(deftest infix-test
  (testing "infix representation of trees"
    (is (= "1" (infix {:value 1})))
    (is (= "1+2" (infix {:operator + :left {:value 1} :right {:value 2}})))
    (is (= "1*(2+3)" (infix {:operator *
                             :left {:value 1}
                             :right {:operator +
                                     :left {:value 2}
                                     :right {:value 3}}})))))
