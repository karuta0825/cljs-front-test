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
               {:transition "background-color 3s"})


;; (def style-with-modes
;;   {:background-color "white"
;;    ::stylefy/mode [[:before {:content "'CSS generated content'"}]
;;                    [:hover {:background-color "#ffedcf"}]
;;                    [:active {:background-color "blue" :color "white"}]]})

(def title-style
  {:font-size "3em"
   ::stylefy/mode {:hover {:background-color "red"}}})


(defn- Button
  [text]
  [:div (use-style button-style {:on-click #(.log js/console "Click")
                                 :class "somehitng"})
   text])


(defn app
  []
  [:div
   [:div (use-style title-style {:class "background-transition"}) "やぁ"]])


(defn stop
  []
  (js/console.log "Stopping..."))


(defn start
  []
  (js/console.log "Starting...")
  (stylefy/init)
  (r/render [app]
            (.getElementById js/document "app")))


(defn ^:export init
  []
  (start))

;
(init)
