package zadanie4;

/**
 * Author: Ilya Varlamov aka privr@tnik
 * Date: 03.07.12
 * Time: 17:10
 */

public class ListNode {
    
    private String data;
    private ListNode nextNode;

    public ListNode(){
        super();
    }
    
    public ListNode(String data, ListNode nextNode){
        this.data = data;
        this.nextNode= nextNode;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public ListNode getNextNode() {
        return nextNode;
    }

    public void setNextNode(ListNode nextNode) {
        this.nextNode = nextNode;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "data='" + data + '\'' +
                '}';
    }
}
