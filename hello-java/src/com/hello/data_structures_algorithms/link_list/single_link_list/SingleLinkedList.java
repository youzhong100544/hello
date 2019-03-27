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

        linkList.add(2, 24);
        linkList.display();

        linkList.addLast(71);
        linkList.display();

        linkList.addLast(63);
        linkList.display();

        linkList.addLast(24);
        linkList.display();

        linkList.add(2, 24);
        linkList.display();

        linkList.reversal();
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
     * 无参构造函数,初始化一个虚拟头结点,数据域、指针域都为null。
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
     * （不是常用操作,练习用）
     * pre的作用：找到要插入索引位置的前一个Node节点
     *
     * @param index
     *          索引位置
     * @param data
     *          数据
     */
    public void add(int index, int data) {
        if(index < 0 || index > size) {
            throw new IllegalArgumentException("添加失败,不合法的索引值");
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
        // this.first = reversal_1(first);

        this.first = reversal_2_1(first, null);

        // this.first = reversal_2_2(first);
    }

    /**
     * 迭代法
     *      先将下一节点纪录下来,
     *      然后让当前节点指向上一节点,
     *      再将当前节点纪录下来,
     *      再让下一节点变为当前节点
     *
     * @param node
     * @return
     */
    public Link reversal_1(Link node) {
        if (node == null || node.next == null){
            return node;
        }
        // 上一结点
        Link previous = null;
        // 当前节点
        Link current = node;
        // 用于存储下一节点
        Link next;

        // current==null 即尾结点
        while (current != null) {
            // 下一节点存入临时结点
            next = current.next;
            // 将当前结点指针指向上一节点
            current.next = previous;
            // 移动指针
            previous = current;
            current = next;

        }

        return previous;
    }

    /**
     *  递归方法1
     *      先找到最后一个节点,
     *      然后从最后一个开始反转,
     *      然后当前节点反转时其后面的节点已经进行反转了,不需要管。
     *
     *      最后返回原来的最后一个节点
     * @param node
     * @return
     */
    public Link reversal_2_1(Link node, Link previous) {
        if (node == null ) {
            return node;
        }
        if (node.next == null) {
            node.next = previous;
            return node;
        } else {
            Link last = reversal_2_1(node.next, node);
            node.next = previous;
            return last;
        }

    }

    /**
     * 递归方法2
     *      先找到最后一个节点,
     *      然后从最后一个节点之前的那个节点的方法体中开始将下一个指向当前一个,
     *      然后当前节点反转时其后面的节点已经进行反转了,不需要管。
     *
     *      最后返回原来的最后一个节点。
     * 
     * @param node
     * @return
     */
    public Link reversal_2_2(Link node) {
        if (node == null || node.next == null){
            return node;
        }

        Link next = node.next;

        node.next = null;

        Link last = reversal_2_2(next);

        next.next = node;

        return last;
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