package zadanie1;

/**
 * Author: Ilya Varlamov aka privr@tnik
 * Date: 03.04.12
 * Time: 12:52
 */

public class TreeSet{

    private Node root;
    private int counterNode;

    public void add(int data) {

        if (!find(data)) {
            Node node = new Node();
            node.setData(data);

            if (root == null) {
                root = node;
            } else {

                Node current = root;
                Node parent = current;

                for (;;) {
                    if (node.getData() < current.getData()) {
                        current = current.getLeftNode();
                        if (current == null) {
                            parent.setLeftNode(node);
                            break;
                        }
                    } else {
                        current = current.getRightNode();
                        if (current == null) {
                            parent.setRightNode(node);
                            break;
                        }
                    }
                    parent = current;
                }
                counterNode++;
            }
        }
    }

    public boolean delete( int data ){

        Node current = root;
        Node parent = root;

        boolean flag = false;

        try{
             while(data != current.getData()){
                 parent = current;
                 if( data < current.getData() ){
                     flag = true;
                     current = current.getLeftNode();
                 }else{
                     flag = false;
                     current = current.getRightNode();
                 }
             }
         }catch (NullPointerException e){
             return false;
         }

         if (current.getLeftNode() == null && current.getRightNode() == null) { // list node

            if (current == root) {
                root = null;
            } else if (flag) {
                parent.setLeftNode(null);
            } else {
                parent.setRightNode(null);
            }

         } else if (current.getLeftNode() == null) { // if not left parent node set left

                if (current == root) {
                    root = current.getRightNode();
                } else if (flag) {
                    parent.setLeftNode(current.getRightNode());
                } else {
                    parent.setRightNode(current.getRightNode());
                }

          } else if (current.getRightNode() == null) { // if not right parent node set right

                if (current == root) {
                    root = current.getLeftNode();
                } else if (flag) {
                    parent.setLeftNode(current.getLeftNode());
                } else {
                    parent.setRightNode(current.getLeftNode());
                }

            } else {  // if two children

                Node next = nextNodeAfterRemove(current);

                if (current == root) {
                    root = next;
                } else if (flag) {
                    parent.setLeftNode(next);
                } else {
                    parent.setRightNode(next);
                }

            }

            counterNode--;

            return true;
        }


    private Node nextNodeAfterRemove( Node nodeRemove ){

        Node nextParent = nodeRemove;
        Node next = nodeRemove;
        Node current = nodeRemove.getLeftNode();

        while ( current != null ){
            nextParent = next;
            next = current;
            current = current.getLeftNode();
        }

        if( next != nodeRemove.getRightNode() ){
            nextParent.setLeftNode( next.getRightNode() );
            next.setRightNode( nodeRemove.getRightNode() );
        }

        return next;
    }

    public boolean find( int data ){

        if( root == null ) return false;

        Node current = root;

            try{
                while( data != current.getData() ){
                    if( data < current.getData() ){
                        current = current.getLeftNode();
                    }else{
                        current = current.getRightNode();
                    }
                }
            }catch (NullPointerException e){
                return false;
            }

        return true;
    }
    
    public boolean find( int data, Node current, Node parent ){

        try {
            while (data != current.getData()) {
                parent = current;
                if (data < current.getData()) {
                    current = current.getLeftNode();
                    return true;
                } else {
                    current = current.getRightNode();
                    return false;
                }
            }
        } catch (NullPointerException e) {
            return false;
        }

        return false;
    }

    public int size(){
        return counterNode;
    }

    public void print(){
        traversalDepth( root );
    }

    private void traversalDepth( Node node ){
        if( node != null ){
            traversalDepth( node.getLeftNode() );
                System.out.println("");
                System.out.print( " " + node.getData() + " Левый потомок " + (node.getLeftNode() != null ? node.getLeftNode().getData() : " нет ") );
                System.out.print( " " + node.getData() + " Правый потомок " + (node.getRightNode() != null ? node.getRightNode().getData() : " нет ") );
                System.out.println("");
            traversalDepth( node.getRightNode() );
        }
    }

    @Override
    public String toString(){
        return "TreeSet {" + "\n" +
                " root = " + root +
                "\n}";
    }

}
