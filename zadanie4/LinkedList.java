package zadanie4;

/**
 * Author: Ilya Varlamov aka privr@tnik
 * Date: 03.07.12
 * Time: 16:50
 */

public class LinkedList {
    
    private ListNode rootNode;
    private int counter;
    
    public LinkedList(){
        super();    
    }
        
    public void add(String data){

        if( data != null ){
            ListNode listNode = new ListNode();
            listNode.setData(data);

                if(rootNode == null){
                    rootNode = listNode;
                    counter++;
                }else{
                    ListNode current = rootNode;

                    while ( current != null ){

                        if(current.getNextNode() == null){
                            current.setNextNode( listNode );
                            counter++;
                            break;
                        }else{
                            current = current.getNextNode();
                        }
                    }
                }
        }
    }

    public void delete(String data) {

        if (data != null) {
            ListNode current = rootNode;
            ListNode parent = null;

            try {
                while ((current != null) && (!current.getData().equals(data))) {
                    parent = current;
                    current = current.getNextNode();
                }

                if (parent == null) {
                    rootNode = rootNode.getNextNode();
                } else {
                    parent.setNextNode(current.getNextNode());
                }
                counter--;

            } catch (NullPointerException e) {
                return;
            }
        }
    }

    public ListNode find(String data){

        ListNode current = rootNode;

        while (current != null){

            if(current.getData().equals(data)){
                return current;
            }

            current = current.getNextNode();
        }

        return null;
    }
    
    public int size(){
        return counter;
    }
    
    public void print(){

        ListNode current = rootNode;

        while (current != null){
            System.out.println( current );
            current = current.getNextNode();
        }

    }

}
