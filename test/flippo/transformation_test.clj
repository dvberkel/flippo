(ns flippo.transformation-test
  (:require [clojure.test :refer :all]
            [flippo.transformation :refer :all]))

(deftest transform-structured-trees
  (testing "transforming structured trees into trees ready for evaluation"
    (is (= {:value 1} (decorate [+] [1] nil)))
    (is (= {:value 2} (decorate [+] [2] nil)))
    (is (= {:operator +
            :left  {:value 1}
            :right {:value 2}} (decorate [+] [1 2] {:left nil :right nil})))
    (is (= {:operator +
            :left  {:operator + :left {:value 1} :right {:value 2}}
            :right {:value 1}} (decorate [+] [1 2] {:left {:left nil :right nil} :right nil})))
    (is (= {:operator -
            :left  {:value 1}
            :right {:operator + :left {:value 2} :right {:value 1}}}
           (decorate [+ -] [1 2] {:left nil :right {:left nil :right nil}})))))
