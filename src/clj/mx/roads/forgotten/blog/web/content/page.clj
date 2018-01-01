(ns mx.roads.forgotten.blog.web.content.page
  (:require
    [dragon.selmer.core :refer [render]]
    [dragon.util :as util]
    [mx.roads.forgotten.blog.web.content.data :as data]))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;;   Static Pages   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(defn about
  [system posts]
  (render
    "templates/pages/generic.html"
    (data/about system posts)))

(defn community
  [system posts]
  (render
    "templates/pages/generic.html"
    (data/community system posts)))

(defn contact
  [system posts]
  (render
    "templates/pages/generic.html"
    (data/contact system posts)))

(defn powered-by
  [system posts]
  (render
    "templates/pages/generic.html"
    (data/powered-by system posts)))

(defn license
  [system posts]
  (render
    "templates/pages/generic.html"
    (data/license system posts)))

(defn privacy
  [system posts]
  (render
    "templates/pages/generic.html"
    (data/privacy system posts)))

(defn disclosure
  [system posts]
  (render
    "templates/pages/generic.html"
    (data/disclosure system posts)))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;;   Dynamic Pages   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(defn post
  [system posts post-data]
  (render
    "templates/pages/post.html"
    (data/post system posts post-data)))

(defn front-page
  [system posts]
  (let [above-fold 5
        below-fold 5
        headline-posts (->> posts
                            (filter util/headline?)
                            (take (+ above-fold below-fold)))]
    (render
      "templates/pages/home.html"
      (data/front-page
        system
        posts
        headline-posts
        :above-fold-count above-fold
        :below-fold-count below-fold
        :column-count 2))))

(defn maps-index
  [system posts maps-data]
  (render
    "templates/pages/maps.html"
    (data/maps-index
      system posts maps-data)))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;;   Map Pages   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(defn map-fullscreen
  [system map-data]
  (render
    "templates/maps/fullscreen.html"
    (data/map-minimal
      system map-data)))

(defn map-kml-fullscreen
  [system map-data]
  (render
    "templates/maps/kml-fullscreen.html"
    (data/map-minimal
      system map-data)))

(defn map-kml-wide-page
  [system posts map-data]
  (render
    "templates/maps/kml-wide-page.html"
    (data/map-common
      system posts map-data)))

(defn map-kml-content-page
  [system posts map-data]
  (render
    "templates/maps/kml-content-page.html"
    (data/map-common
      system posts map-data)))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;;   Listings Pages   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(defn archives
  [system posts]
  (render
    "templates/listings/archives.html"
    (data/archives system posts)))

(defn categories
  [system posts]
  (render
    "templates/listings/categories.html"
    (data/categories system posts)))

(defn tags
  [system posts]
  (render
    "templates/listings/tags.html"
    (data/tags system posts)))

(defn authors
  [system posts]
  (render
    "templates/listings/authors.html"
    (data/authors system posts)))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;;   Design Pages   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(defn design
  [system posts]
  (render
    "templates/design/main.html"
    (data/design system posts)))

(defn bootstrap-theme
  [system posts]
  (render
    "templates/design/bootstrap-theme.html"
    (data/design system posts)))

(defn front-page-example
  [system posts]
  (render
    "templates/design/front-page-example.html"
    (data/design system posts)))

(defn blog-example
  [system posts]
  (render
    "templates/design/blog-example.html"
    (data/design system posts)))

(defn font-samples
  [system posts]
  (render
    "templates/design/font-samples.html"
    (data/design system posts)))
