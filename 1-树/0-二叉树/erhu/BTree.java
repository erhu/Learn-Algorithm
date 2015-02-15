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
        System.out.println("              /\\           ");
        System.out.println("             /  \\          ");
        System.out.println("        3_baa    3_bab       ");
        System.out.println();

        BTree<String> tree = new BTree<String>("Root");
        // left
        {
            tree.left = new BTree<String>("1_a");
            tree.left.left = new BTree<String>("2_aa");
        }

        // right
        {
            tree.right = new BTree<String>("1_b");
            tree.right.left = new BTree<String>("2_ba");
            tree.right.right = new BTree<String>("2_bb");
            {
                tree.right.left.left = new BTree<String>("3_baa");
                tree.right.left.right = new BTree<String>("3_bab");
            }
        }

        // travel
        System.out.println("preOrder:");
        BTreeTraverse.preOrder(tree);
        System.out.println();

        System.out.println("inOrder:");
        BTreeTraverse.inOrder(tree);
        System.out.println();

        System.out.println("postOrder:");
        BTreeTraverse.postOrder(tree);
        System.out.println();

        System.out.println("levelOrder:");
        BTreeTraverse.levelOrder(tree);
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

        /**
         * level Order
         */

        public static void levelOrder(BTree t) {
            if (t != null) {
                if (t.left != null) {
                    printNode(t.left);
                }
                if (t.right != null) {
                    printNode(t.right);
                }

                levelOrder(t.left);
                levelOrder(t.right);
            }
        }

        private static void printNode(BTree t) {
            System.out.println(t.value.toString());
        }
    }
}