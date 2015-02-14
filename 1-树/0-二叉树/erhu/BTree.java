public class BTree<T> {

    private T value;
    private BTree<T> left;
    private BTree<T> right;

    public BTree(T t) {
        this.value = t;
    }

    public void setLeft(BTree tree) {
        this.left = tree;
    }

    public void setRight(BTree tree) {
        this.right = tree;
    }

    /**
     * 遍历二叉树
     */
    static class BTreeTraverse {

        public static void preOrder(BTree t) {
            printNode(t);
            if (t.left != null) {
                preOrder(t.left);
            }
            if (t.right != null) {
                preOrder(t.right);
            }
        }

        public static void inOrder(BTree t) {
            if (t.left != null) {
                inOrder(t.left);
            }
            printNode(t);
            if (t.right != null) {
                inOrder(t.right);
            }
        }


        public static void postOrder(BTree t) {
            if (t.left != null) {
                postOrder(t.left);
            }
            if (t.right != null) {
                postOrder(t.right);
            }
            printNode(t);
        }


        private static void printNode(BTree t) {
            System.out.println(t.value.toString());
        }
    }
}