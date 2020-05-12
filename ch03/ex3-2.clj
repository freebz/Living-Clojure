;; 조화로운 변경을 위해 ref 사용하기

(def alice-height (ref 3))
(def right-hand-bites (ref 10))


@alice-height
;=> 3

@right-hand-bites
;=> 10


(defn eat-from-right-hand []
  (when (pos? @right-hand-bites)
    (alter right-hand-bites dec)
    (alter alice-height #(+ % 24))))


(eat-from-right-hand)
;=> IllegalStateException No transaction running


(dosync (eat-from-right-hand))
;=> 27

@alice-height
;=> 27

@right-hand-bites
;=> 9


(def alice-height (ref 3));
(def right-hand-bites (ref 10))

(defn eat-from-right-hand []
  (dosync (when (pos? @right-hand-bites)
            (alter right-hand-bites dec)
            (alter alice-height #(+ % 24)))))

(let [n 2]
  (future (dotimes [_ n] (eat-from-right-hand)))
  (future (dotimes [_ n] (eat-from-right-hand)))
  (future (dotimes [_ n] (eat-from-right-hand))))

@alice-height
;=> 147

@right-hand-bites
;=> 4


(def alice-height (ref 3))
(def right-hand-bites (ref 10))

(defn eat-from-right-hand []
  (dosync (when (pos? @right-hand-bites)
            (commute right-hand-bites dec)
            (commute alice-height #(+ % 24)))))

(let [n 2]
  (future (dotimes [_ n] (eat-from-right-hand)))
  (future (dotimes [_ n] (eat-from-right-hand)))
  (future (dotimes [_ n] (eat-from-right-hand))))

@alice-height
;=> 147

@right-hand-bites
;=> 4


(def x (ref 1))
(def y (ref 1))

(defn new-values []
  (dosync
   (alter x inc)
   (ref-set y (+ 2 @x))))

(let [n 2]
  (future (dotimes [_ n] (new-values)))
  (future (dotimes [_ n] (new-values))))

@x
;=> 5

@y
;=> 7
