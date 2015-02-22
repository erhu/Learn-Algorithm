public class BST<T extends Comparable> {
    T value;
    BST<T> left;
    BST<T> right;

    BST(T v) {
        value = v;
    }

    static <T extends Comparable<T>> BST create(T... args) {
        if (args != null && args.length > 0) {
            BST<T> root = new BST<T>(args[0]);
            for (int i = 1; i < args.length; i++) {
                insert(root, args[i]);
            }
            return root;
        }
        return null;
    }

    static <T extends Comparable<T>> void insert(BST<T> t, T v) {
        if (v.compareTo(t.value) < 0) {
            if (t.left == null) {
                t.left = new BST<T>(v);
            } else {
                insert(t.left, v);
            }
        } else if (v.compareTo(t.value) > 0) {
            if (t.right == null) {
                t.right = new BST<T>(v);
            } else {
                insert(t.right, v);
            }
        }
    }

    static <T extends Comparable<T>> BST<T> search(BST<T> t, T v) {
        if (t.value.equals(v)) {
            return t;
        } else if (t.left != null && v.compareTo(t.value) <= 0) {
            return search(t.left, v);
        } else if (t.right != null && v.compareTo(t.value) >= 0) {
            return search(t.right, v);
        }
        return null;
    }

    static <T extends Comparable<T>> BST<T> delete(BST<T> t, T v) {
        if (t == null) {
            return null;
        }
        // 找到此节点t, 删除t
        if (t.value.compareTo(v) == 0) {
            // 左子树为空，用右子树替换被删除的节点
            if (t.left == null) {
                t = t.right;
            } else if (t.right == null) {
                // 右子树为空，用左子树替换被删除的节点
                t = t.left;
            } else {
                /* 右右均不为空，用右子树中最小的节点替换 */
                BST<T> r_min_node = t.right;
                // 最小节点的父节点
                BST<T> min_node_parent = null;
                while (r_min_node.left != null) {
                    min_node_parent = r_min_node;
                    r_min_node = r_min_node.left;
                }

                // 将t原来的左右结点，赋给新的t节点
                r_min_node.left = t.left;
                r_min_node.right = t.right;
                // 移除t的引用
                t.left = null;
                t.right = null;
                // 移除新t节点原父节点的
                if (min_node_parent != null) {
                    min_node_parent.left = null;
                }
                t = r_min_node;
            }
        } else if (v.compareTo(t.value) > 0) {
            // 在右子树
            t.right = delete(t.right, v);
        } else {
            // 在左子树
            t.left = delete(t.left, v);
        }
        return t;
    }

    public String toString() {
        StringBuilder buffer = new StringBuilder();
        buffer.append("(").append(value).append("");
        if (left != null) {
            buffer.append(" L:").append(left.toString());
        }
        if (right != null) {
            buffer.append(" R:").append(right.toString());
        }
        buffer.append(")");
        return buffer.toString();
    }
}

