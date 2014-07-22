(ns isnot.moe.test.handler
  (:require [clojure.test :refer :all]
            [isnot.moe.handler :refer :all]
            [ring.mock.request :as mock]))

(deftest test-app
  (testing "main domain"
    (let [response (app {:server-name "isnot.moe"})]
      (is (= (:status response) 200))))
  (testing "subdomain matching"
    (let [response (app {:server-name "anon.isnot.moe"})]
      (is (= (:status response) 200))))
  (testing "multi-word subdomains"
    (let [response (app {:server-name "your.mom.isnot.moe"})]
      (is (= (:status response) 200))))
  (testing "4chan board wordfilters"
    (is (= (notmoe-message {:server-name "jp.isnot.moe"}) "/jp/ is not moe ;_;"))
    (is (= (notmoe-message {:server-name "a.isnot.moe"}) "/a/ is not moe ;_;"))
    (is (= (notmoe-message {:server-name "a.and.jp.isnot.moe"}) "/a/ and /jp/ is not moe ;_;"))))
