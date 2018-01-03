(ns advent-2017.day3-test
  (:require
    [advent-2017.day3 :refer :all]
    [clojure.test :refer :all]))


(deftest day-3-examples
  (is (= 0 (manhatten-distance 1)))
  (is (= 3 (manhatten-distance 12)))
  (is (= 2 (manhatten-distance 23)))
  (is (= 31 (manhatten-distance 1024))))
