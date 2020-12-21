(ns starter.core
  (:require
    [reagent.core :as r]
    [stylefy.core :as stylefy :refer [use-style]]))


(defonce greeting "やぁ,")
(def hi "やぁ。")
(def who "Reagent")


(def button-style
  {:padding "10px"
   :background-color "#BBBBBB"
   :border "1px solid black"})


(def style-with-modes
  {:background-color "rgb(88, 121, 193)"
   ::stylefy/mode {:hover {:background-color "rgb(98, 131, 213)"}
                   :before {:content "'CSS generated content'"}
                   "::-webkit-progress-bar" {:-webkit-appearance "none"}}})


(stylefy/class "background-transition"
               {:transition "background-color 10s"})


;; (def style-with-modes
;;   {:background-color "white"
;;    ::stylefy/mode [[:before {:content "'CSS generated content'"}]
;;                    [:hover {:background-color "#ffedcf"}]
;;                    [:active {:background-color "blue" :color "white"}]]})


(defn- Button
  [text]
  [:div (use-style button-style {:on-click #(.log js/console "Click")
                                 :class "somehitng"})
   text])


(defn app
  []
  [:div
   [:div (use-style style-with-modes) "test"]
   [:div.background-transition  "test3"]
   [Button "aafei"]])


(defn stop
  []
  (js/console.log "Stopping..."))


(defn start
  []
  (js/console.log "Starting...")
  (r/render [app]
            (.getElementById js/document "app"))
  (stylefy/init))


(defn ^:export init
  []
  (start))


(init)
