;; 심볼과 바인딩의 기술

[1 2 3 4]


(def developer "Alice")
;=> #'user/developer


developer
;=> "Alice"


(def developer "Alice")
;=> #'user/developer

(let [developer "Alice in Wonderland"]
  developer)
;=> "Alice in Wonderland"

developer
;=> "Alice"


(let [developer "Alice in Wonderland"
      rabbit "White Rabbit"]
  [developer rabbit])
;=> ["Alice in Wonderland" "White Rabbit"]

rabbit
;=> CompilerException java.lang.RuntimeException:
;   Unable to resolve symbol: rabbit in this context
