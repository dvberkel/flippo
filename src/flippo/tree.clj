(ns flippo.tree)

(defn adjoin [tree part]
  "Returns a sequence of structured trees where part is adjoined to
   all the free locations in tree"
  (if (nil? tree)
    (seq [part])
    (concat
     (map (fn [t] {:left t :right (:right tree)}) (adjoin (:left tree) part))
     (map (fn [t] {:left (:left tree) :right t}) (adjoin (:right tree) part)))))

(defn generate-structure-tree [n]
  "Returns a sequence of trees with n nodes"
  (if (= n 0)
    (seq [nil])
    (mapcat (fn [t] (adjoin t {:left nil :right nil})) (generate-structure-tree (dec n)))))

(defn map-tree [f tree]
  "Let f operate on all the nodes of the tree"
  (if (nil? tree)
    (f tree nil nil)
    (f tree (map-tree f (:left tree)) (map-tree f (:right tree)))))
