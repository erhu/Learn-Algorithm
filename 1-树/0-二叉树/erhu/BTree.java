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
        System.out.println("             Root            ");
        System.out.println("              /\\            ");
        System.out.println("             /  \\           ");
        System.out.println("          1_a    1_b         ");
        System.out.println("           /     /\\         ");
        System.out.println("          /     /  \\        ");
        System.out.println("      2_aa  2_ba    2_bb     ");
        System.out.println("              /\\            ");
        System.out.println("             /  \\           ");
        System.out.println("        3_baa    3_bab       ");
        System.out.println();

        BTree<String> tree = new BTree<String>("Root");
        // left
        tree.left = new BTree<String>("1_a");
        tree.left.left = new BTree<String>("2_aa");

        // right
        tree.right = new BTree<String>("1_b");
        tree.right.left = new BTree<String>("2_ba");
        tree.right.right = new BTree<String>("2_bb");
        {
            tree.right.left.left = new BTree<String>("3_baa");
            tree.right.left.right = new BTree<String>("3_bab");
        }

        // travel
        Op<String> op = new Op<String>() {
            @Override
            public void execute(String t) {
                System.out.println(t);
            }
        };

        System.out.println("preOrder:");
        BTreeTraverse.preOrder(tree, op);
        System.out.println();

        System.out.println("inOrder:");
        BTreeTraverse.inOrder(tree, op);
        System.out.println();

        System.out.println("postOrder:");
        BTreeTraverse.postOrder(tree, op);
        System.out.println();

        System.out.println("levelOrder:");
        BTreeTraverse.levelOrder(tree, op);
        System.out.println();
    }

    /**
     * traverse tool
     */
    private static class BTreeTraverse {

        /**
         * preOrder
         */
        public static <T> void preOrder(BTree<T> t, Op<T> op) {
            op.execute(t.value);
            if (t.left != null) {
                preOrder(t.left, op);
            }
            if (t.right != null) {
                preOrder(t.right, op);
            }
        }

        /**
         * inOrder
         */
        public static <T> void inOrder(BTree<T> t, Op<T> op) {
            if (t.left != null) {
                inOrder(t.left, op);
            }
            op.execute(t.value);
            if (t.right != null) {
                inOrder(t.right, op);
            }
        }

        /**
         * postOrder
         */
        public static <T> void postOrder(BTree<T> t, Op<T> op) {
            if (t.left != null) {
                postOrder(t.left, op);
            }
            if (t.right != null) {
                postOrder(t.right, op);
            }
            op.execute(t.value);
        }

        /**
         * level Order
         */

        public static <T> void levelOrder(BTree<T> t, Op<T> op) {
            if (t != null) {
                if (t.left != null) {
                    op.execute(t.value);
                }
                if (t.right != null) {
                    op.execute(t.value);
                }

                levelOrder(t.left, op);
                levelOrder(t.right, op);
            }
        }
    }

    interface Op<T> {
        void execute(T t);
    }
}

