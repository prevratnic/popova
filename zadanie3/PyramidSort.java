package zadanie3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Author: Ilya Varlamov aka privr@tnik
 * Date: 05.04.12
 * Time: 16:15
 */

public class PyramidSort {

    private List<Integer> listTest;

    public PyramidSort(){

        listTest = new ArrayList<Integer>();

    }

    public void userInput(){

        System.out.println("Ввод неупорядоченной последовательности чисел:");

        Scanner scanner = new Scanner(System.in);

        for(;;){

            String value = scanner.next();

            if( value.trim().length() > 0 ){
                if( value.equals("#") ) break;
                listTest.add( Integer.valueOf(value) );
            }
        }

        System.out.println("Ввод закончен:" + "\n");
    }

    public void print(){

        System.out.println("Вывод результата сортировки:");

        for( Integer val : listTest ){
            System.out.println( val );
        }
    }

}

