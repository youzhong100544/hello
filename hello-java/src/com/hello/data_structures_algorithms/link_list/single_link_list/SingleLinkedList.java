package com.hello.data_structures_algorithms.link_list.single_link_list;

public class SingleLinkedList {

    public static void main(String[] args) {
        LinkList linkList = new LinkList();

        linkList.display();

        linkList.addLast(2);
        linkList.display();

        linkList.addLast(4);
        linkList.display();

        linkList.addLast(7);
        linkList.display();

        linkList.addFirst(5);
        linkList.display();

        linkList.addLast(7);
        linkList.display();


        linkList.addFirst(50);
        linkList.display();

        linkList.addFirst(53);
        linkList.display();

        linkList.addFirst(54);
        linkList.display();

        linkList.addLast(71);
        linkList.display();

    }

}


class Link{

    /* 这里为了省略 get set 方法 所以字段的权限写成 public */
    public int data;        //数据域
    public Link next;        //指针域



    public Link() {
        this(0, null);
    }

    public Link(int data) {
        this(data, null);
    }

    public Link(int data, Link next) {
        this.data = data;
        this.next = next;

    }

}

class LinkList{

    public int size = 0;        //链表大小

    public Link first;


    /**
     * 无参构造函数，初始化一个虚拟头结点，数据域、指针域都为null。
     */
    public LinkList() {
        // first = null;
    }
    /**
     * 获取链表中元素个数
     */
    public int getSize() {
        return size;
    }

    /**
     * 判断链表是否为空
     */
    public boolean isEmpty() {
        return first == null;
        // or
        // return size == 0;
    }

    /**
     * 在链表头部添加元素
     * @param data
     */
    public void addFirst(int data) {
        add(0, data);
    }
    /**
     * 在链表尾部添加元素
     * @param data
     */
    public void addLast(int data) {
        add(size, data);
    }

    /**
     * 在链表的指定位置添加元素
     * （不是常用操作，练习用）
     * pre的作用：找到要插入索引位置的前一个Node节点
     *
     * @param index
     *          索引位置
     * @param data
     *          数据
     */
    public void add(int index, int data) {
        if(index < 0 || index > size) {
            throw new IllegalArgumentException("添加失败，不合法的索引值");
        }

        Link node = new Link(data);

        if (first == null) {
            this.first = node;
        } else {
            Link before = first;
            if (index == 0){
                node.next = before;
                this.first = node;
            } else {
                for (int i = 1; i < index; i++) {
                    before = before.next;
                }

                if(before.next != null){
                    node.next = before.next;
                }
                before.next = node;

            }
        }

        size++;
    }

    public void reversal() {

    }

    public void display() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");

        if (first != null){
            Link current = first;
            sb.append(first.data);
            while(current.next != null){
                current = current.next;
                sb.append(", " + current.data);
            }
        }
        sb.append("]");
        System.out.println(sb.toString());
    }

}