(ns flippo.tree)

(defn create-value [value]
  "Return a value node with its value set"
  {:value value})

(defn create-tree [operator left right]
  "Return a tree with its operator, left subtree and right subtree set"
  {:operator operator :left left :right right})

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
