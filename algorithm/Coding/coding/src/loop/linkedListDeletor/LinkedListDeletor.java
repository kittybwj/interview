package loop.linkedListDeletor;

import common.Node;
import recursion.linkedListCreator.LinkedListCreator;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 删除链表中值为x的节点
 * eg: 1->2->3->5->2->7->null 删除值为2的节点： 1->3->5->7->null
 */
public class LinkedListDeletor {
    public Node deleteIfEquals(Node head,int value){
        while (head != null && head.getValue() == value){
            head = head.getNext();
        }
        if (head == null){
            return null;
        }
        Node prev = head;
        while (prev.getNext() != null){
            Node next = prev.getNext();
            if (next.getValue() == value){
                prev.setNext(next.getNext());
            }else {
                prev = prev.getNext();
            }
        }
        return head;
    }

    public static void main(String[] args) {
        LinkedListCreator linkedListCreator = new LinkedListCreator();
        LinkedListDeletor linkedListDeletor = new LinkedListDeletor();
        Node.printLinkedList(linkedListDeletor.deleteIfEquals(
                linkedListCreator.creatLinkedList(Arrays.asList(1,2,3,2,5)),2));
        Node.printLinkedList(linkedListDeletor.deleteIfEquals(
                linkedListCreator.creatLinkedList(Arrays.asList(1,2,3,2,2)),2));
        Node.printLinkedList(linkedListDeletor.deleteIfEquals(
                linkedListCreator.creatLinkedList(Arrays.asList(1,2,3,2,2)),1));
        Node.printLinkedList(linkedListDeletor.deleteIfEquals(
                linkedListCreator.creatLinkedList(Arrays.asList(2,2,3,2,2)),2));
        Node.printLinkedList(linkedListDeletor.deleteIfEquals(
                linkedListCreator.creatLinkedList(Arrays.asList(2,2,2,2,2)),2));
        Node.printLinkedList(linkedListDeletor.deleteIfEquals(
                linkedListCreator.creatLinkedList(Arrays.asList(2)),2));
        Node.printLinkedList(linkedListDeletor.deleteIfEquals(
                linkedListCreator.creatLinkedList(Arrays.asList(2)),1));
        Node.printLinkedList(linkedListDeletor.deleteIfEquals(
                linkedListCreator.creatLinkedList(new ArrayList<>()),2));
    }


}
