package zadanie1;

/**
 * Author: Ilya Varlamov aka privr@tnik
 * Date: 03.04.12
 * Time: 13:49
 */
public class Node {

    private Node leftNode;
    private Node rightNode;
    private int data;

    public Node(){
        super();
    }

    public Node getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(Node leftNode) {
        this.leftNode = leftNode;
    }

    public Node getRightNode() {
        return rightNode;
    }

    public void setRightNode(Node rightNode) {
        this.rightNode = rightNode;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "" + data; /** "Node { " +
                " data = " + data  +
                " leftNode = " + leftNode +
                " RightNode = " + rightNode +
                "  }";*/
    }

}
