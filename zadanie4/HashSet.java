package zadanie4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Author: Ilya Varlamov aka privr@tnik
 * Date: 03.07.12
 * Time: 16:48
 */

public class HashSet {
    
    private int size;
    private LinkedList[] tableArray;
    private HashFunction func;
    private int counter;

    public HashSet(int size){
        this.size = size;  
        this.tableArray = new LinkedList[size];
        this.func = HashFunction.NATURAL_NUMBERS;
        this.counter = 0;

        for(int i = 0; i < size; i++){
            tableArray[i] = new LinkedList();
        }
    }
    
    public void add(String data){
        if(data != null){
            int hashValue = (func == HashFunction.NATURAL_NUMBERS) ? hashFunc1(data) : hashFunc2(data);
            if(tableArray[hashValue].find(data) == null){
                tableArray[hashValue].add(data);
                counter++;
            }
        }
    }
    
    public void delete(String data){
        if(data != null){
            int hashValue = (func == HashFunction.NATURAL_NUMBERS) ? hashFunc1(data) : hashFunc2(data);
            tableArray[hashValue].delete(data);
            counter--;
        }            
    }
    
    public ListNode find(String data){
        if(data != null){
            int hashValue = (func == HashFunction.NATURAL_NUMBERS) ? hashFunc1(data) : hashFunc2(data);
            return tableArray[hashValue].find(data);
        }
        return null;
    }    
    
    public int hashFunc1(String data){
        return Math.abs( data.hashCode() % size );
    }
    
    public int hashFunc2(String data){
        int hashValue = data.hashCode();
        
        for(int i = 0; i < data.length(); i++){
            int tmp = data.charAt(i) - 96;
            hashValue = (hashValue * 27 + tmp) % size;
        }
        return Math.abs(hashValue);
    }
    
    public void print(){

        // 1
        int emptyСount = 0;
        for(int i = 0; i < size; i++){
            if(tableArray[i].size() == 0){
                emptyСount++;
            }
        }

        System.out.println("Число пустых ячеек в хеш-таблице " + emptyСount);

        // 2
        int chainCount = 0;
        
        for(int i = 0; i < size; i++){
            if(tableArray[i].size() != 0){
                if(chainCount < tableArray[i].size()){
                    chainCount = tableArray[i].size();
                }
            }
        }

        System.out.println("Длина самой длинной цепочки " + chainCount);

        // 3
        int nCount = 0;
        List<Integer> list = new ArrayList<Integer>();

        for(int i = 0; i < size; i++){
            if(tableArray[i].size() != 0){
                list.add(tableArray[i].size());
            }
        }

        Collections.sort(list);
        Collections.reverse(list);
        
        for(int i = 0; i <= list.size()/4; i++){
            nCount += list.get(i);
        }

        double countAverElements = Math.ceil(((double)list.size()) / 4 );
        nCount = (int)(nCount/countAverElements);

        System.out.println("Cредняя длина n самых длинных цепочек хеш-таблицы " + nCount);
    }

    public int size(){
        return counter;
    }

    public void choiceHash(HashFunction func){
        if(counter == 0){
            this.func = func;
        }else{
            System.out.println("Сan not change the hash function");
        }
    }

}
