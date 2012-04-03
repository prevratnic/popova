package zadanie1;

/**
 * Author: Ilya Varlamov aka privr@tnik
 * Date: 29.03.12
 * Time: 1:04
 */

public class Main1 {
    public static void main(String... args){
        Tree tree = new Tree();
        tree.add(5);
        tree.add(2);
        tree.add(10);
        tree.add(1);
        tree.add(3);
        tree.add(6);
        tree.add(16);

        int tmp = 0;

        tree.delete(1);

//        for( Object test : tree ){
//            System.out.println( test );
//        }

    }
}
