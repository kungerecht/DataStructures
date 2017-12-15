//  Kevin Ungerecht
//  12/15/2017
//  Circular Doubly Linked List with dummy head

package LinkedList;

public class LinkedList {
    
    private Node dummy;
    private int size;
    
    //~~~~~~~Constructors~~~~~~~~
    
    public LinkedList(){
        dummy = new Node();
        size = 0;
    }
    
    public LinkedList(Object[] dataArray){
        dummy = new Node();
        size = 0;
        initialize(dataArray);
    }
    
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    
    private void initialize(Object[] dAra){ //Fills the Linked List with data from array
        int num = dAra.length;
        for(int i=0; i<num; i++){
            addNode(dAra[i]);
        }
    }
    
    public void addNode(Object data){ //Adds Node with data at end of the Linked List
        Node newNode;
        if(this.size == 0){ //empty list
            newNode = new Node(data, dummy, dummy);
            dummy.next = newNode;
            dummy.prev = newNode;
            this.size++;
        }else{
            newNode = new Node(data, dummy, dummy.prev);
            dummy.prev.next = newNode;
            dummy.prev = newNode;
            this.size++;
        }
    }
    
    public boolean removeNode(Object data){ //Removes Node with data from the Linked List
       
        if(this.size == 0){ //empty list
            System.out.println("Cannot remove Node from an empty list.");
            return false;
        }
        else{
            Node pointer = dummy.next;
            while(!pointer.equals(dummy)){
                if(pointer.data.equals(data)){
                    pointer.prev.next = pointer.next;
                    pointer.next.prev = pointer.prev;
                    this.size--;
                    System.out.println("Node with data: " + data + " successfully removed.");
                    return true;
                }
                pointer = pointer.next;
            }
            System.out.println("No Node found with data: " + data + ".");
            return false;
        }
    }
    
    public boolean removeNodePosition(int pos){ //Removes Node at a position from the Linked List (0 index is first node after dummy)
        
        if(this.size == 0){ //empty list
            System.out.println("Cannot remove Node from an empty list.");
            return false;
        }
        else if(pos == 0){ //position is first Node
            dummy.next = dummy.next.next;
            dummy.next.prev = dummy;
            this.size--;
            System.out.println("Node at position: " + pos + " successfully removed.");
            return true;
        }
        else if(pos < 0 || pos > this.size - 1){  //position is out of range
            System.out.println("There is no Node at that position.");
            return false;
        }
        else{
            Node pointer = dummy.next;
            for(int i=0;i<=pos;i++){pointer = pointer.next;}
            pointer.prev.next = pointer.next;
            pointer.next.prev = pointer.prev;
            this.size--;
            System.out.println("Node at position: " + pos + " successfully removed.");
            return true;
        }
    }
    
    public void clear(){ //Empties the Linked List
        this.size = 0;
        dummy.next = dummy;
        dummy.prev = dummy;
        System.out.println("Cleared.");
    }
    
    public int size(){ //Gets the size of the Linked List
        return this.size;
    }
    
    public String toString(){ //Creates printable String in regular order
        if(this.size == 0){
            return "empty";
        }
        String s = "";
        Node pointer = dummy.next;
        while(!pointer.equals(dummy)){
            s += "[ " + pointer.data + " ]";
            pointer = pointer.next;
        }
        return s;
    }
    
    public String toReverseString(){ //Creates printable String in reverse order
        if(this.size == 0){
            return "empty";
        }
        String s = "";
        Node pointer = dummy.prev;
        while(!pointer.equals(dummy)){
            s += "[ " + pointer.data + " ]";
            pointer = pointer.prev;
        }
        return s;
    }
    
    //~~~~~~~Nested Node~~~~~~~~
    private class Node {
        
        private Object data;
        private Node next, prev;
        
        //~~~~~~~Constructors~~~~~~~~
        
        private Node(){ //No argument for dummy node
            data = 0;
            next = this;
            prev = this;
        }

        private Node(Object d, Node n, Node p){ //Node with initial data and pointers
            data = d;
            next = n;
            prev = p;
        }

        //~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    
    
    }
    
}
