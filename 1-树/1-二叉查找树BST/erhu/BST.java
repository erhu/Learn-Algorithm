public class BST<T extends Comparable<T>> {

    Node root;

    public BST(T... arg) {
        root = create(arg);
    }

    private class Node {
        T value;
        Node left;
        Node right;

        public Node(T v) {
            this.value = v;
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

    Node create(T... args) {
        if (args != null && args.length > 0) {
            Node root = new Node(args[0]);
            for (int i = 1; i < args.length; i++) {
                insert(root, args[i]);
            }
            return root;
        }
        return null;
    }

    void insert(Node t, T v) {
        if (v.compareTo(t.value) < 0) {
            if (t.left == null) {
                t.left = new Node(v);
            } else {
                insert(t.left, v);
            }
        } else if (v.compareTo(t.value) > 0) {
            if (t.right == null) {
                t.right = new Node(v);
            } else {
                insert(t.right, v);
            }
        }
    }

    public Node search(T v) {
        return _search(root, v);
    }

    private Node _search(Node root, T v) {
        if (root.value.equals(v)) {
            return root;
        } else if (root.left != null && v.compareTo(root.value) <= 0) {
            return _search(root.left, v);
        } else if (root.right != null && v.compareTo(root.value) >= 0) {
            return _search(root.right, v);
        }
        return null;
    }


    /**
     * 删除 BST 中的节点 v
     *
     * @param v value
     * @return 删除节点后的树
     */
    public Node delete(T v) {
        return _delete(root, v);
    }

    private Node _delete(Node t, T v) {
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
                Node r_min_node = t.right;
                // 最小节点的父节点
                Node min_node_parent = null;
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
            t.right = _delete(t.right, v);
        } else {
            // 在左子树
            t.left = _delete(t.left, v);
        }
        return t;
    }

    /**
     * 中序遍历
     */
    public void inOrder(Op<T> op) {
        _inOrder(root, op);
    }

    private void _inOrder(Node t, Op<T> op) {
        if (t != null) {
            _inOrder(t.left, op);
            op.execute(t.value);
            _inOrder(t.right, op);
        }
    }

    @Override
    public String toString() {
        return root.toString();
    }
}

