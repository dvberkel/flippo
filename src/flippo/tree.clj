(ns flippo.tree)

(defn create-value [value]
  "Return a value node with its value set"
  {:value value})

(defn create-tree [operator left right]
  "Return a tree with its operator, left subtree and right subtree set"
  {:operator operator :left left :right right})
