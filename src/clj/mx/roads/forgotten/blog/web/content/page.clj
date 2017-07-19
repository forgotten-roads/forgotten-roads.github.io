(ns mx.roads.forgotten.blog.web.content.page
  (:require [mx.roads.forgotten.blog.web.content.data :as data]
            [dragon.web.content :as content]))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;;   Static Pages   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(defn about
  [posts]
  (content/render
    "templates/pages/generic.html"
    (data/about posts)))

(defn community
  [posts]
  (content/render
    "templates/pages/generic.html"
    (data/community posts)))

(defn contact
  [posts]
  (content/render
    "templates/pages/generic.html"
    (data/contact posts)))

(defn powered-by
  [posts]
  (content/render
    "templates/pages/generic.html"
    (data/powered-by posts)))

(defn license
  [posts]
  (content/render
    "templates/pages/generic.html"
    (data/license posts)))

(defn privacy
  [posts]
  (content/render
    "templates/pages/generic.html"
    (data/privacy posts)))

(defn disclosure
  [posts]
  (content/render
    "templates/pages/generic.html"
    (data/disclosure posts)))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;;   Dynamic Pages   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(defn post
  [posts post-data]
  (content/render
    "templates/pages/post.html"
    (data/post posts post-data)))

(defn front-page
  [posts]
  (content/render
    "templates/pages/home.html"
    (data/front-page
      posts
      :post-count 5
      :column-count 2)))

(defn map-fullscreen
  [map-data]
  (content/render
    "templates/pages/map-fullscreen.html"
    (data/map-minimal
      map-data)))

(defn map-wide-page
  [posts map-data]
  (content/render
    "templates/pages/map-wide-page.html"
    (data/map-common
      posts map-data)))

(defn map-content-page
  [posts map-data]
  (content/render
    "templates/pages/map-content-page.html"
    (data/map-common
      posts map-data)))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;;   Listings Pages   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(defn archives
  [posts]
  (content/render
    "templates/listings/archives.html"
    (data/archives posts)))

(defn categories
  [posts]
  (content/render
    "templates/listings/categories.html"
    (data/categories posts)))

(defn tags
  [posts]
  (content/render
    "templates/listings/tags.html"
    (data/tags posts)))

(defn authors
  [posts]
  (content/render
    "templates/listings/authors.html"
    (data/authors posts)))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;;   Design Pages   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(defn design
  [posts]
  (content/render
    "templates/design/main.html"
    (data/design posts)))

(defn bootstrap-theme
  [posts]
  (content/render
    "templates/design/bootstrap-theme.html"
    (data/design posts)))

(defn front-page-example
  [posts]
  (content/render
    "templates/design/front-page-example.html"
    (data/design posts)))

(defn blog-example
  [posts]
  (content/render
    "templates/design/blog-example.html"
    (data/design posts)))

(defn map-simple-example
  [posts]
  (content/render
    "templates/design/map-simple.html"
    (data/design posts)))

(defn map-kml-example
  [posts]
  (content/render
    "templates/design/map-kml-layer.html"
    (data/design posts)))

; (defn post-example
;   [posts]
;   (content/render
;     "templates/design/post-example.html"
;     (data/design posts)))
