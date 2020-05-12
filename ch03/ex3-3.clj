;; 비동기적 변경을 관리하기 위해 에이전트 사용하기

(def who-agent (agent :caterpillar))


@who-agent
;=> :caterpillar


(def who-agent (agent :caterpillar))

(defn change [state]
  (case state
    :caterpillar :chrysalis
    :chrysalis :butterfly
    :butterfly))

(send who-agent change)
;=> #<Agent@dad8e5: :caterpillar>


@who-agent
;=> :chrysalis


(send-off who-agent change)
;=> #<Agent@dad8e5: :butterfly>

@who-agent
;=> :butterfly


(def who-agent (agent :caterpillar))

(defn change [state]
  (case state
    :caterpillar :chrysalis
    :chrysalis :butterfly
    :butterfly))

(defn change-error [state]
  (throw (Exception. "Boom!")))

(send who-agent change-error)
;=> #<Agent@42c8e1 FAILED: :caterpillar>

@who-agent
;=> :caterpillar


(send-off who-agent change)
;=> Exception Boom!  user/change-error


(agent-errors who-agent)
;=> (#error {
;    :cause "Boom!"
;    ... })


(restart-agent who-agent :caterpillar)
;=> :caterpillar

(send who-agent change)
;=> #<Agent@42c8e1: :chrysalis>

@who-agent
;=> :chrysalis


(set-error-mode! who-agent :continue)


(defn err-handler-fn [a ex]
  (println "error " ex " value is " @a))

(set-error-handler! who-agent err-handler-fn)


(def who-agent (agent :caterpillar))

(set-error-mode! who-agent :continue)

(set-error-handler! who-agent err-handler-fn)

(send who-agent change-error)
;=> #<Agent@a7270a: :caterpillar>
;; 출력된다
; error  #error {
; :cause Boom!
; ... }  value is  :caterpillar

@who-agent
;=> :caterpillar


(send who-agent change)
;=> #<Agent@a7270a: :chrysalis>

@who-agent
;=> :chrysalis
