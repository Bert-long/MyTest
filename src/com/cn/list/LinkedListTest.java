package com.cn.list;

import org.w3c.dom.Node;

public class LinkedListTest<E> {

    private NodeTest first;
    private NodeTest last;
    private int size;

    public static void main(String[] args){
        LinkedListTest<String> linkedListTest = new LinkedListTest<>();
        linkedListTest.add("a");
        linkedListTest.add("b");
        linkedListTest.add("C");
        linkedListTest.add("d");
        linkedListTest.add("e");
        linkedListTest.add("f");
        System.out.println(linkedListTest);
        linkedListTest.add(3, "4");
        System.out.println(linkedListTest);
        linkedListTest.reMove(3);
        System.out.println(linkedListTest);
    }

    public void reMove(int index){
        NodeTest temp = get(index);
        if (temp != null){
            NodeTest up = temp.previous;
            NodeTest down = temp.next;
            if (up != null){
                up.next = down;
            }
            if (down != null){
                down.previous = up;
            }
            if (index == 0){
                first = down;
            }
            if (index == size-1){
                last = up;
            }
            size--;
        }
    }

    public void checkRange(int index){
        if (index<0 || index>size-1){
            throw new RuntimeException("索引不合法" + index);
        }
    }

    public NodeTest get(int index){
        checkRange(index);
        NodeTest temp = null;
        /*for (int i=0; i<index; i++){
            nodeTest = nodeTest.next;
        }*/
        if (index<=(size>>1)){
            temp = first;
            for (int i=0; i<index; i++){
                temp = temp.next;
            }
        }else{
            temp = last;
            for (int i=size-1; i>index; i--){
                temp = temp.previous;
            }
        }
        return temp;
    }

    public void add(int index, E element){
        NodeTest newNode = new NodeTest(element);
        NodeTest temp = get(index);
        if (temp != null){
            NodeTest up = temp.previous;
            up.next = newNode;
            newNode.previous = up;
            newNode.next = temp;
            temp.previous = newNode;
        }
    }

    public void add(E element){
        NodeTest nodeTest = new NodeTest(element);
        if (first == null){
            nodeTest.previous = null;
            nodeTest.next = null;
            first = nodeTest;
            last = nodeTest;
        }
        nodeTest.previous = last;
        nodeTest.next = null;
        last.next = nodeTest;
        last = nodeTest;
        size++;

    }

    @Override
    public String toString(){
        StringBuilder s = new StringBuilder("[");
        NodeTest temp = first;
        while (temp != null){
            s.append(temp.element + ",");
            temp = temp.next;
        }
        s.setCharAt(s.length()-1,']');
        return s.toString();
    }

}

class NodeTest {
    NodeTest previous;      //上一个节点
    NodeTest next;          //下一个节点
    Object element;     //当前节点元素

    public NodeTest(NodeTest previous, NodeTest next, Object element){
        super();
        this.previous = previous;
        this.next = next;
        this.element = element;
    }

    public NodeTest(Object element){
        super();
        this.element = element;
    }

}
