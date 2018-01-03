(ns advent-2017.day11-test
  (:require
    [advent-2017.day11 :refer :all]
    [clojure.test :refer :all]))


(deftest day-11-examples
  (is (= 3 (distance [:ne :ne :ne])))
  (is (= 0 (distance [:ne :ne :sw :sw])))
  (is (= 2 (distance [:ne :ne :s :s])))
  (is (= 3 (distance [:se :sw :se :sw :sw]))))
