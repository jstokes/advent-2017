(ns advent-2017.day1-test
  (:require
    [advent-2017.day1 :refer :all]
    [clojure.test :refer :all]))


(deftest day-1-examples
  (is (= 3 (reverse-captcha [1 1 2 2])))
  (is (= 4 (reverse-captcha [1 1 1 1])))
  (is (= 0 (reverse-captcha [1 2 3 4])))
  (is (= 9 (reverse-captcha [9 1 2 1 2 1 2 9]))))

