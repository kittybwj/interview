package recursion.linkedListCreator;

import common.Node;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 递归创建链表
 */
public class LinkedListCreator {

    //创建一个链表。
    //返回firstNode，且最后一个元素指向null
    public Node creatLinkedList(List<Integer> data){
        if(data.isEmpty()){
            return null;
        }
        Node firstNode = new Node(data.get(0));
        firstNode.setNext(creatLinkedList(data.subList(1,data.size())));
        return firstNode;
    }

    public Node creatLargeLinkedList(int size){
        Node prev = null;//已经建立的链表最后一个节点
        Node head = null;//
        for (int i = 1; i <= size; i++) {
            Node node = new Node(i);
            if (prev != null){
                prev.setNext(node);
            }else {
                head = node;
            }
            prev = node;
        }
        return head;
    }

    public static void main(String[] args) {
        LinkedListCreator linkedListCreator = new LinkedListCreator();
        //data为空
        Node.printLinkedList(linkedListCreator.creatLinkedList(new ArrayList<>()));
        //data只有一个元素
        Node.printLinkedList(linkedListCreator.creatLinkedList(Arrays.asList(1)));
        //data为普通情况
        Node.printLinkedList(linkedListCreator.creatLinkedList(Arrays.asList(1,2,3,4,5)));
    }
}
