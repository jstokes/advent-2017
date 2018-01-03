(ns advent-2017.day2-test
  (:require
    [advent-2017.day2 :refer :all]
    [clojure.test :refer :all]))


(deftest checksum-test
  (is (= 18
         (checksum [[5 1 9 5]
                    [7 5 3]
                    [2 4 6 8]]))))
