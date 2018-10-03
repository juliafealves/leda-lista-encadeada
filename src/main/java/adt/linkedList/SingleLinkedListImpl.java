package adt.linkedList;

import java.util.ArrayList;
import java.util.List;

public class SingleLinkedListImpl<T> implements LinkedList<T> {

    protected SingleLinkedListNode<T> head;

    public SingleLinkedListImpl() {
        this.head = new SingleLinkedListNode<T>();
    }

    @Override
    public boolean isEmpty() {
        return this.getHead().isNIL();
    }

    @Override
    public int size() {
        int size = 0;
        SingleLinkedListNode<T> node = this.getHead();

        while (!node.isNIL()) {
            size++;
            node = node.getNext();
        }

        return size;
    }

    @Override
    public T search(T element) {
        SingleLinkedListNode<T> node = this.getHead();

        while (!node.isNIL() && !node.getData().equals(element)) {
            node = node.getNext();
        }

        return (T) node.getData();
    }

    @Override
    public void insert(T element) {
        SingleLinkedListNode<T> head = this.getHead();

        if (this.getHead().isNIL()) {
            this.getHead().setData(element);
            this.getHead().setNext(new SingleLinkedListNode<>());
        } else {
            while (!head.getNext().isNIL()) {
                head = head.getNext();
            }

            SingleLinkedListNode<T> node = new SingleLinkedListNode<>(element, head.getNext());
            head.setNext(node);
        }

    }

    @Override
    public void remove(T element) {
        if (this.getHead().getData().equals(element)) {
            this.setHead(this.getHead().getNext());
        } else {
            SingleLinkedListNode<T> node = this.getHead();
            SingleLinkedListNode<T> previous = new SingleLinkedListNode<>();

            while (!node.isNIL() && !node.getData().equals(element)) {
                previous = node;
                node = node.getNext();
            }

            if (!node.isNIL()) {
                previous.setNext(node.getNext());
            }
        }
    }

    @Override
    public T[] toArray() {
        List<Object> arrayList = new ArrayList<>();
        SingleLinkedListNode<T> node = this.getHead();

        while (!node.isNIL()) {
            arrayList.add(node.getData());
            node = node.getNext();
        }

        return (T[]) arrayList.toArray();
    }

    public SingleLinkedListNode<T> getHead() {
        return head;
    }

    public void setHead(SingleLinkedListNode<T> head) {
        this.head = head;
    }

}
