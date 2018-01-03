(ns advent-2017.day8
  (:require [clojure.string :as str]
            [clojure.java.io :as io]))

;; --- Day 8: I Heard You Like Registers ---
;; You receive a signal directly from the CPU. Because of your recent assistance with jump
;; instructions, it would like you to compute the result of a series of unusual register instructions.

;; Each instruction consists of several parts: the register to modify, whether to increase
;; or decrease that register's value, the amount by which to increase or decrease it, and a
;; condition. If the condition fails, skip the instruction without modifying the register.
;; The registers all start at 0. The instructions look like this:

;; b inc 5 if a > 1
;; a inc 1 if b < 5
;; c dec -10 if a >= 1
;; c inc -20 if c == 10
;; These instructions would be processed as follows:

;; Because a starts at 0, it is not greater than 1, and so b is not modified.
;; a is increased by 1 (to 1) because b is less than 5 (it is 0).
;; c is decreased by -10 (to 10) because a is now greater than or equal to 1 (it is 1).
;; c is increased by -20 (to -10) because c is equal to 10.
;; After this process, the largest value in any register is 1.

;; You might also encounter <= (less than or equal to) or != (not equal to). However, the CPU
;; doesn't have the bandwidth to tell you what all the registers are named, and leaves that
;; to you to determine.

;; What is the largest value in any register after completing the instructions in your puzzle input?


(defn apply-instruction
  [registers instruction]
  (let [[_ register f amount cond]
        (re-find #"(\w+) (\w+) (-?\d+) if (.*)$" instruction)

        [cond-reg cond-p cond-v]
        (str/split cond #" ")

        cond-p (case cond-p
                 ">" >
                 "<" <
                 ">=" >=
                 "<=" <=
                 "==" =
                 "!=" not=)
        cond-v (Integer/parseInt cond-v)
        f (case f
            "inc" +
            "dec" -)
        amount (Integer/parseInt amount)]
    (if (cond-p (get registers cond-reg 0) cond-v)
      (update registers register (fnil f 0) amount)
      registers)))


(->> (io/resource "day8input.txt")
     (slurp)
     (str/split-lines)
     (reduce apply-instruction {})
     (vals)
     (apply max))
