(ns advent-2017.day4-test
  (:require
    [advent-2017.day4 :refer :all]
    [clojure.test :refer :all]))


(deftest day-4-examples
  (is (valid? "aa bb cc dd ee"))
  (is (not (valid? "aa bb cc dd aa")))
  (is (valid? "aa bb cc dd aaa")))

