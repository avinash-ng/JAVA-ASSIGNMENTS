
/**
 * Create a generic, singly linked list class called SList, which, to keep things simple, does not implement the List interface.

 * Each Link object in the list should contain a reference to the next element in the list, but not the previous one (LinkedList, in contrast, is a doubly linked list, which means it maintains links in both directions).

 * Create your own SListIterator which, again for simplicity, does not implement ListIterator. The only method in SList other than toString( ) should be iterator( ), which produces an SListIterator.

 * The only way to insert and remove elements from an SList is through SListIterator. Write code to demonstrate SList.
*/
import java.util.*;
class Node<T>{
    T data;
    Node<T> next;

    Node() {

    }

    Node (T d){
        data = d;
        next = null;
    }

}

class SList<T> {

    Node<T> head;

    SList(){
        head = null;
    }

    SList(Node<T> h){
        head = h;
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
    SListIterator(Node<T> h){
        head = h;
    }


    public void insertNode(T obj){
        if(head == null){

            head =  new Node<T>(obj);
        }
        else{
            Node<T> curr = head;
            while(curr.next != null){
                curr = curr.next;
            }
            curr.next = new Node<T>(obj);
        }

        size += 1;
    }

    public void deleteNode(T obj){
        if(head == null){
            System.out.println("Empty list");

        }
        else if(head.data == obj){
            head = head.next;
            size -= 1;
        }
        else {
            Node<T> prev = head;
            Node<T> curr = head.next;
            while(curr.data != obj){
                prev = curr;
                curr = curr.next;
            }
            prev.next = curr.next;
            size -= 1;
        }
    }

    public void printList(){
        Node<T> iter = head;
        while (iter != null){
            System.out.println(iter.data);
            iter = iter.next;
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
