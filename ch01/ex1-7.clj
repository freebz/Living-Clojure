;; 집합을 사용해 유일한 데이터의 컬렉션 표현하기

#{:red :blue :white :pink}
;=> #{:white :red :blue :pink}


;; 집합을 생성할 때 중복은 허용되지 않는다.
#{:red :blue :white :pink :pink}
;=> IllegalArgumentException Duplicate key: :pink


(clojure.set/union #{:r :b :w} #{:w :p :y})
;=> #{:y :r :w :b :p}


(clojure.set/difference #{:r :b :w} #{:w :p :y})
;=> #{:r :b}


(clojure.set/intersection #{:r :b :w} #{:w :p :y})
;=> #{:w}


(set [:rabbit :rabbit :watch :door])
;=> #{:door :watch :rabbit}

(set {:a 1 :b 2 :c 3})
;=> #{[:c 3] [:b 2] [:a 1]}


(get #{:rabbit :door :watch} :rabbit)
;=> :rabbit

(get #{:rabbit :door :watch} :jar)
;=> nil


(:rabbit #{:rabbit :door :watch})
;=> :rabbit


(#{:rabbit :door :watch} :rabbit)
;=> :rabbit


(contains? #{:rabbit :door :watch} :rabbit)
;=> true

(contains? #{:rabbit :door :watch} :jam)
;=> false


(conj #{:rabbit :door} :jam)
;=> #{:door :rabbit :jam}


(disj #{:rabbit :door} :door)
;=> #{:rabbit}
