(defproject flippo "0.1.0-SNAPSHOT"
  :description "Solve 24 number problems"
  :url "https://github.com/dvberkel/flippo"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [org.clojure/math.combinatorics "0.1.3"]]
  :main ^:skip-aot flippo.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
