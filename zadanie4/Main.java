package zadanie4;

/**
 * Author: Ilya Varlamov aka privr@tnik
 * Date: 28.06.12
 * Time: 20:57
 */

public class Main {
    
    public static void main(String... args){
        
        String[] dict = new String[20];
        dict[0] = "apple";
        dict[1] = "pear";
        dict[2] = "plum";
        dict[3] = "cherry";
        dict[4] = "raspberry";
        dict[5] = "gooseberry";
        dict[6] = "blueberries";
        dict[7] = "pineapple";
        dict[8] = "banana";
        dict[9] = "kakos";
        dict[10] = "plum";
        dict[11] = "peas";
        dict[12] = "beans";
        dict[13] = "strawberry";
        dict[14] = "cherry";
        dict[15] = "cabbage";
        dict[16] = "carrots";
        dict[17] = "potato";
        dict[18] = "beet";
        dict[19] = "gooseberry";

        HashSet hashSet = new HashSet(dict.length);
        //hashSet.choiceHash(HashFunction.MODULO);
        
        for(int i = 0; i < dict.length; i++){
            hashSet.add(dict[i]);
        }

        hashSet.print();
    }
}
