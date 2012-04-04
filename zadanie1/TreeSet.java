package zadanie1;

import java.util.Iterator;

/**
 * Author: Ilya Varlamov aka privr@tnik
 * Date: 03.04.12
 * Time: 12:52
 */

public class TreeSet{

    private Node root;
    private int counterNode;

    public void add( int data ){

        Node node = new Node();
        node.setData( data );

        if( root == null ){
            root = node;
            counterNode++;
        }else{

            if( !find(data) ){

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
                counterNode++;
            }
        }
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

    public int size(){
        return counterNode;
    }

    public void print(){
        traversalDepth( root );
    }

    private void traversalDepth( Node node ){
        if( node != null ){
            traversalDepth( node.getLeftNode() );
                System.out.print( node.getData() + " " );
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
