(ns advent-2017.day1)


(defn reverse-captcha
  [[h & t :as numbers]]
  (->> (conj numbers h)
       (partition 2 1)
       (filter (partial apply =))
       (map first)
       (reduce + 0)))
