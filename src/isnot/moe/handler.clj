(ns isnot.moe.handler
  (:require [clojure.string :as s]
            [hiccup.util :as h]))

;; TODO read this from an external file
(def wordfilter {"3" "/3/"
                 "a" "/a/"
                 "adv" "/adv/"
                 "an" "/an/"
                 "asp" "/asp/"
                 "b" "/b/"
                 "biz" "/biz/"
                 "c" "/c/"
                 "cgl" "/cgl/"
                 "ck" "/ck/"
                 "cm" "/cm/"
                 "co" "/co/"
                 "d" "/d/"
                 "diy" "/diy/"
                 "e" "/e/"
                 "f" "/f/"
                 "fa" "/fa/"
                 "fit" "/fit/"
                 "g" "/g/"
                 "gd" "/gd/"
                 "gif" "/gif/"
                 "h" "/h/"
                 "hc" "/hc/"
                 "hm" "/hm/"
                 "hr" "/hr/"
                 "i" "/i/"
                 "ic" "/ic/"
                 "int" "/int/"
                 "jp" "/jp/"
                 "k" "/k/"
                 "lgbt" "/lgbt/"
                 "lit" "/lit/"
                 "m" "/m/"
                 "mlp" "/mlp/"
                 "mu" "/mu/"
                 "n" "/n/"
                 "o" "/o/"
                 "out" "/out/"
                 "p" "/p/"
                 "po" "/po/"
                 "pol" "/pol/"
                 "r" "/r/"
                 "r9k" "/r9k/"
                 "s" "/s/"
                 "s4s" "/s4s/"
                 "sci" "/sci/"
                 "soc" "/soc/"
                 "sp" "/sp/"
                 "t" "/t/"
                 "tg" "/tg/"
                 "toy" "/toy/"
                 "trv" "/trv/"
                 "tv" "/tv/"
                 "u" "/u/"
                 "v" "/v/"
                 "vg" "/vg/"
                 "vp" "/vp/"
                 "vr" "/vr/"
                 "w" "/w/"
                 "wg" "/wg/"
                 "wsg" "/wsg/"
                 "x" "/x/"
                 "y" "/y/"
                 "and" "and"
                 "waifu" "waifu"
                 "youre" "Your are"
                 "yourwaifu" "Your Waifu"
                 "yoursite" "Your Web Sight"})

(defn subdomains [{full-domain :server-name}]
  (try (->> full-domain
            (re-find #"^(.*)\.isnot\.moe.*$")
            (drop 1)
            (first)
            (re-seq #"[^.]+"))
       (catch Exception e "Your Waifu")))

(defn notmoe-message [req]
  (->> (subdomains req)
       (map #(or (wordfilter %) (s/capitalize %)))
       (s/join " ")
       (h/escape-html)
       (format "%s is not moe ;_;")))

(defn app [req]
  (let [notmoe (notmoe-message req)]
   {:status 200
    :headers {"Content-type" "text/html"}
    :body (str "<head><title>" notmoe "</title></head>"
               "<body><h1>" notmoe "</h1></body>")}))
