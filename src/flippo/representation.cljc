(ns flippo.representation)

(defn infix [tree]
  (let [operator-representation {+ "+" - "-" * "*" / "/"}
        subtree (fn [sub]
                  (if (nil? (:operator sub))
                    (infix sub)
                    (str "(" (infix sub) ")")))]
    (if (:value tree)
      (str (:value tree))
      (str (subtree (:left tree))
           (operator-representation (:operator tree))
           (subtree (:right tree))))))
