public class BTree<T> {

    private T value;
    private BTree<T> left;
    private BTree<T> right;

    public BTree(T t) {
        this.value = t;
    }

    public void setLeft(BTree<T> tree) {
        this.left = tree;
    }

    public void setRight(BTree<T> tree) {
        this.right = tree;
    }

    /**
     * main
     */
    public static void main(String[] args) {

        System.out.println("         Root              ");
        System.out.println("         / \\              ");
        System.out.println("        /   \\             ");
        System.out.println("    1_left 1_right         ");
        System.out.println("             / \\          ");
        System.out.println("            /   \\         ");
        System.out.println("       2_left  2_right\n\n");


        BTree<String> tree = new BTree<String>("Root");
        // left
        tree.left = new BTree<String>("1_left");
        // right
        BTree<String> lvl1_right = new BTree<String>("1_right");
        tree.right = lvl1_right;

        lvl1_right.left = new BTree<String>("2_left");
        lvl1_right.right = new BTree<String>("2_right");

        System.out.println("preOrder:");
        BTreeTraverse.preOrder(tree);
        System.out.println();

        System.out.println("inOrder:");
        BTreeTraverse.inOrder(tree);
        System.out.println();

        System.out.println("postOrder:");
        BTreeTraverse.postOrder(tree);
        System.out.println();
    }

    /**
     * traverse tool
     */
    private static class BTreeTraverse {

        /**
         * preOrder
         */
        public static void preOrder(BTree t) {
            printNode(t);
            if (t.left != null) {
                preOrder(t.left);
            }
            if (t.right != null) {
                preOrder(t.right);
            }
        }

        /**
         * inOrder
         */
        public static void inOrder(BTree t) {
            if (t.left != null) {
                inOrder(t.left);
            }
            printNode(t);
            if (t.right != null) {
                inOrder(t.right);
            }
        }

        /**
         * postOrder
         */
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