package com.hello.data_structures_algorithms.link_list.double_side_link_list;

import java.util.LinkedList;

public class DoubleSideLinkedList {
}


class Link{

    int data;
    Link next;
    Link prev;

    public Link() {
        this(null, 0, null);
    }

    public Link(int data) {
        this(null, data, null);
    }

    Link(Link prev, int data, Link next) {
        this.data = data;
        this.next = next;
        this.prev = prev;
    }
}
class LinkList{
    int size = 0;

    Link first;

    Link last;

    public LinkList() { }

}