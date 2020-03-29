
/**
 * Create a generic, singly linked list class called SList, which, to keep things simple, does not implement the List interface.

 * Each Link object in the list should contain a reference to the next element in the list, but not the previous one (LinkedList, in contrast, is a doubly linked list, which means it maintains links in both directions).

 * Create your own SListIterator which, again for simplicity, does not implement ListIterator. The only method in SList other than toString( ) should be iterator( ), which produces an SListIterator.

 * The only way to insert and remove elements from an SList is through SListIterator. Write code to demonstrate SList.
*/
import java.util.*;
import java.util.logging.Logger;
import java.util.logging.Level;

class Node<T>{
    T data;
    Node<T> next;

    Node() {

    }

    Node (T data){
        this.data = data;
        next = null;
    }

}

class SList<T> {

    Node<T> head;

    SList(){
        head = null;
    }

    SList(Node<T> node){
        head = node;
    }

    public String toString(){
        return "SList object";
    }

    public SListIterator iterator(){
        return new SListIterator(head);
    }
}

class SListIterator<T> {
    Node<T> head;
    int size = 0;
    Logger logger = Logger.getLogger(SListIterator.class.getName());
    
    SListIterator(Node<T> head){
        this.head = head;
    }


    public void insertNode(T obj){
        if(head == null){

            head =  new Node<T>(obj);
        }
        else{
            Node<T> current = head;
            while(current.next != null){
                current = current.next;
            }
            current.next = new Node<T>(obj);
        }

        size += 1;
    }

    
    public void deleteNode(T obj){
        if(head == null){
//             System.out.println("Empty list");
            logger.log(Level.INFO, " Empty list ");

        }
        else if(head.data == obj){
            head = head.next;
            size -= 1;
        }
        else {
            Node<T> previous = head;
            Node<T> current = head.next;
            while(current.data != obj){
                previous = current;
                current = current.next;
            }
            previous.next = current.next;
            size -= 1;
        }
    }

    
    public void printList(){
        Node<T> current = head;
        while (current != null){
//             System.out.println(iter.data);
            logger.log(Level.INFO, current.data + "");
            current = current.next;
        }
    }

    public int getSize(){
        return size;
    }

}
public class GenericListDriver {
    public static void main(String args[]){
        SList<Integer> list = new SList<Integer>();
        SListIterator<Integer> Literator = list.iterator();
        Literator.insertNode(1);
        Literator.insertNode(2);
        Literator.insertNode(3);
        Literator.insertNode(6);
        Literator.insertNode(4);
        Literator.deleteNode(1);
        Literator.deleteNode(2);
        Literator.printList();
    }
}
