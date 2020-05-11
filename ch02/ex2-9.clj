;; 궁극의 reduce

(reduce + [1 2 3 4 5])
;=> 15


(reduce (fn [r x] (+ r (* x x))) [1 2 3])
;=> 14


(reduce (fn [r x] (if (nil? x) r (conj r x)))
        []
        [:mouse nil :duck nil nil :lory])
;=> [:mouse :duck :lory]
