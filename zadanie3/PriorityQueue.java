package zadanie3;

/**
 * Author: Ilya Varlamov aka privr@tnik
 * Date: 25.06.12
 * Time: 22:00
 */

public class PriorityQueue {
    
    private int maxSize;
    private long[] queArray;
    private int countItem;
    
    public PriorityQueue(int size){
        this.maxSize = size;
        this.queArray = new long[size];
        this.countItem = 0;        
    }
    
    public void insert(long item){
        int tmp = 0;
        if(countItem == 0){
            queArray[countItem++] = item;
        }else{
            for(tmp = (countItem - 1); tmp >= 0; tmp--){
                if(item > queArray[tmp]){
                    queArray[tmp + 1] = queArray[tmp];
                }else{
                    break;
                }
            }
            queArray[tmp + 1] = item;
            countItem++;
        }
    }
    
    public boolean isEmpty(){
        return countItem == 0; 
    }

    @Override
    public String toString() {
        StringBuilder stringBuffer = new StringBuilder(countItem);
        for(int i = 0; i < countItem; i++){
            stringBuffer.append(queArray[i]);
            stringBuffer.append(" ");
        }
        return stringBuffer.toString();
    }
}
