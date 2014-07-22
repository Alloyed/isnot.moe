(defproject isnot.moe "0.1.0"
  :description "Tells you when things aren't moe."
  :url "http://github.com/alloyed/isnot.moe"
  :license {:name "GNU GPLv3"
            :url "https://www.gnu.org/licenses/gpl.txt"}
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [compojure "1.1.8"]
                 [hiccup "1.0.5"]]
  :plugins [[lein-ring "0.8.11"]]
  :ring {:handler isnot.moe.handler/app
         :host "localhost"}
  :profiles
  {:dev {:dependencies [[javax.servlet/servlet-api "2.5"]
                        [ring-mock "0.1.5"]]}})
