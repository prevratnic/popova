package zadanie1;

import java.util.Scanner;

/**
 * Author: Ilya Varlamov aka privr@tnik
 * Date: 29.03.12
 * Time: 1:04
 */

public class Main {

    public static void main(String... args){

        TreeSet tree = new TreeSet();

        userInput( tree, "Первая последовательнось чисел:", "Ввод первой последовательности завершен:", false );

        tree.print();

        userInput( tree, "Вторая последовательнось чисел:", "Ввод второй последовательности завершен:", false );

        tree.print();

        userInput( tree, "Третья последовательнось чисел:", "Ввод третьей последовательности завершен:", true );

        tree.print();

        System.out.print( "\n\n" + "Программа завершена" );
    }

    private static void userInput(TreeSet treeSet, String first, String second, boolean deleteMerge){

        Scanner scanner = new Scanner(System.in);

        System.out.print("\n\n" + first + "\n");
        for(;;){
            System.out.print("Введите число: ");
            String value = scanner.next();
            if( value.trim().length() > 0 ){
                if( value.equals("#") )
                    break;
                if( deleteMerge ){
                    treeSet.delete( Integer.valueOf( value ) );
                }else{
                    treeSet.add( Integer.valueOf( value ) );
                }
            }
        }
        System.out.print(second + " ");

    }
}
