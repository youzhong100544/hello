package com.hello.data_structures_algorithms.link_list.single_link_list;

public class SingleLinkedList {

    public static void main(String[] args) {

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
    public LinkList() { }
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
        return size == 0;
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

        Link pre = first;
        for(int i=0; i < index; i++) {
            pre = pre.next;
        }


        Link node = new Link(data);
        node.next = pre.next;
        pre.next = node;

        //以上3句等价于这1句：
        //pre.next = new Link(data, pre.next);
        size++;
    }



    public void display() {
        StringBuilder sb=new StringBuilder();
        Link cur = first.next;
        while(cur != null) {
            sb.append(cur+"-->");
            cur = cur.next;
        }
        sb.append("null");
        // return sb.toString();

    }

}