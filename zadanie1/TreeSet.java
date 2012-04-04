package zadanie1;

import java.util.Iterator;

/**
 * Author: Ilya Varlamov aka privr@tnik
 * Date: 03.04.12
 * Time: 12:52
 */

public class TreeSet implements Iterable {

    private Node root;
    private int counterNode;

    public void add( int data ){

        Node node = new Node();
        node.setData( data );

        if( root == null ){
            root = node;
        }else{

            Node current = root;
            Node parent = current;

            for(;;){
                if( node.getData() < current.getData() ){
                    current = current.getLeftNode();
                    if( current == null ){
                        parent.setLeftNode( node );
                        break;
                    }
                } else {
                    current = current.getRightNode();
                    if( current == null ){
                        parent.setRightNode( node );
                        break;
                    }
                }
                parent = current;
            }

        }

        counterNode++;

    }

    public boolean delete( int data ){

        if( root == null ) return false;
        
        Node current = root;
        Node parent = root;
        boolean flag = false;

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

        if( current.getLeftNode() == null && current.getRightNode() == null ){
            if( current == root ){
                root = null;
            }

        }
        
       return false;
    }

    public Node find( int data ){

        if( root == null ) return null;

        Node current = root;

        while( data != current.getData() ){
            if( data < current.getData() ){
                current = current.getLeftNode();
            }else{
                current = current.getRightNode();
            }
        }

        return current;

    }

    public int size(){
        return counterNode;
    }

    @Override
    public String toString(){
        return "TreeSet {" + "\n" +
                " root = " + root +
                "\n}";
    }

    @Override
    public Iterator iterator(){

        return new Iterator(){

            private Node current = root;
            private Node parent = current;

            private int count = counterNode;

            @Override
            public boolean hasNext(){

                if( count > 0 ){
                    count--;
                    return true;
                }

                return false;
            }

            @Override
            public Object next(){
                if( current.getLeftNode() != null ){

                }

                return null;
            }

            @Override
            public void remove(){}

        };

    }

}
