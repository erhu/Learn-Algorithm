/**
 * #本文件的功能说明#
 *
 * @author hujunjie
 * @version 1.0
 * @since 15-2-22 上午11:55
 */
public class BSTTest {

    public static void main(String[] args) {

        BST<Integer> bst = new BST(4, 3, 6, 2, 11, 5, 7, 9, 0);
        System.out.println(bst);

        System.out.println(bst.search(9));
        System.out.println(bst.delete(44));
        bst.inOrder(new Op<Integer>() {
            @Override
            public void execute(Integer v) {
                System.out.print(v + " ");
            }
        });
    }
}

interface Op<T> {
    void execute(T t);
}

