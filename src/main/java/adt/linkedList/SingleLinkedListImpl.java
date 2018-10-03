package adt.linkedList;

import java.util.ArrayList;
import java.util.List;

public class SingleLinkedListImpl<T> implements LinkedList<T> {

    protected SingleLinkedListNode<T> head;

    public SingleLinkedListImpl() {
        this.head = new SingleLinkedListNode<T>();
    }

    /**
     * @return true if the list is empty or false, otherwise
     */
    @Override
    public boolean isEmpty() {
        return this.getHead().isNIL();
    }

    /**
     * @return the number of elements on the list
     */
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

    /**
     * Searches for a given element in the list.
     *
     * @param element the element being searched for
     * @return the element if it is in the list or null, otherwise
     */
    @Override
    public T search(T element) {
        SingleLinkedListNode<T> node = this.getHead();

        while (!node.isNIL() && !node.getData().equals(element)) {
            node = node.getNext();
        }

        return node.getData();
    }

    /**
     * Inserts a new element at the end of the list. Null elements must be
     * ignored.
     *
     * @param element the element to be inserted
     */
    @Override
    public void insert(T element) {
        if(element != null) {
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
    }

    /**
     * Removes an element from the list. If the element does not exist the list
     * is not changed.
     *
     * @param element the element to be removed
     */
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

    /**
     * Returns an array containing all elements in the structure. The array does
     * not contain empty spaces (or null elements). The elements are put into
     * the array from the beginning to the end of the list.
     *
     * @return an array containing all elements in the structure in the order they appear
     */
    @Override
    public T[] toArray() {
        List<T> arrayList = new ArrayList<>();
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
