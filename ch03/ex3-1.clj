;; 현실 세계의 상태와 병행성 다루기

;; 독립적인 항목에 아톰 사용하기

(def who-atom (atom :caterpillar))


who-atom
;=> #<Atom@ec23c1: :caterpillar>

@who-atom
;=> :caterpillar


(reset! who-atom :chrysalis)
;=> :chrysalis

@who-atom
;=> :chrysalis


(def who-atom (atom :caterpillar))


@who-atom
;=> :caterpillar


(defn change [state]
  (case state
    :caterpillar :chrysalis
    :chrysalis :butterfly
    :butterfly))


(swap! who-atom change)
;=> :chrysalis


@who-atom
;=> :chrysalis


(swap! who-atom change)
;=> :butterfly


@who-atom
;=> :butterfly


(swap! who-atom change)
;=> :butterfly


@who-atom
;=> :butterfly


(def counter (atom 0))

@counter
;=> 0

(dotimes [_ 5] (swap! counter inc))

@counter
;=> 5


(def counter (atom 0))

@counter
;=> 0

(let [n 5]
  (future (dotimes [_ n] (swap! counter inc)))
  (future (dotimes [_ n] (swap! counter inc)))
  (future (dotimes [_ n] (swap! counter inc))))

@counter
;=> 15


(def counter (atom 0))

(defn inc-print [val]
  (println val)
  (inc val))

(swap! counter inc-print)
; 0
;=> 1


(def counter (atom 0))

(let [n 2]
  (future (dotimes [_ n] (swap! counter inc-print)))
  (future (dotimes [_ n] (swap! counter inc-print)))
  (future (dotimes [_ n] (swap! counter inc-print))))
; 0
; 1
; 2
; 2
; 3
; 4
; 5

@counter
;=> 6
