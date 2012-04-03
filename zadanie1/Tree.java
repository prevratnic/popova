package zadanie1;

import java.util.Iterator;

/**
 * Author: Ilya Varlamov aka privr@tnik
 * Date: 03.04.12
 * Time: 12:52
 */

public class Tree implements Iterable {

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

    public void delete( int data ){
        recursionTree( root );
    }

    public void find( int data ){

    }

    public int size(){
        return counterNode;
    }

    public void recursionTree( Node root ){
        if( root != null ){
            recursionTree( root.getLeftNode() );
            System.out.println( root.getData() );
            //recursionTree( root.getRightNode() );
        }

        //return null;
    }

    @Override
    public String toString(){
        return "Tree {" + "\n" +
                " root = " + root +
                "\n}";
    }

    @Override
    public Iterator iterator(){

        return new Iterator(){

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

                Node current = root;
                Node parent = current;

                if( root != null ){
                    for(;;){
                        if( current.getLeftNode() == null ){
                            return parent;
                        }
                        parent = current;
                    }
                }

                return null;
            }

            @Override
            public void remove() {

            }
        };

    }

}
