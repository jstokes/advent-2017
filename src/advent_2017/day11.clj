(ns advent-2017.day11
  (:require [clojure.java.io :as io]
            [clojure.string :as str]))


(defn ->hex
  [x y]
  {:x x, :y y :z (- 0 x y)})


(defn step
  [{:keys [x y] :as hex} direction]
  (case direction
    :n  (->hex x (inc y))
    :s  (->hex x (dec y))
    :ne (->hex (inc x) y)
    :nw (->hex (dec x) (inc y))
    :se (->hex (inc x) (dec y))
    :sw (->hex (dec x) y)))


(defn distance
  [steps]
  (let [origin (->hex 0 0)]
    (->>
      (reduce step origin steps)
      (merge-with #(Math/abs (- % %2)) origin)
      (vals)
      (apply max))))


(distance
  (map
    keyword
    (-> (io/resource "day11input.txt") slurp str/trim (str/split #","))))
