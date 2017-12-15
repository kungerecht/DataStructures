//  Kevin Ungerecht
//  12/15/2017
//  Circular Doubly Linked List with dummy head tester

package LinkedList;

public class LinkedListTest {
    public static void main(String[] args){
        
        //Our array of data
        Integer[] array = {2,4,8,26,32};
        
        //Create new linked List and fill with data
        LinkedList theList = new LinkedList(array);
        
        System.out.println("Printing the Linked List in order...");
        System.out.println(theList);
        System.out.println("Printing the Linked List in reverse...");
        System.out.println(theList.toReverseString());
        System.out.println("Adding 64 to the Linked List...");
        theList.addNode(64);
        System.out.println(theList);
        System.out.println("The size of the Linked List is "+theList.size());
        System.out.println("Removing 8 from the Linked List...");
        theList.removeNode(8);
        System.out.println(theList);
        System.out.println("Removing 1 from the Linked List...");
        theList.removeNode(1);
        System.out.println("Removing Node at position 0 from the Linked List...");
        theList.removeNodePosition(0);
        System.out.println(theList);
        System.out.println("Clearing the Linked List...");
        theList.clear();
        System.out.println("The size of the Linked List is "+theList.size());
    }
}