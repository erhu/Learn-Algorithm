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

