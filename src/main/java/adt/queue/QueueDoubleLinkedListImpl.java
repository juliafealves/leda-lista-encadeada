package adt.queue;

import adt.linkedList.DoubleLinkedList;
import adt.linkedList.DoubleLinkedListImpl;

public class QueueDoubleLinkedListImpl<T> implements Queue<T> {

    protected DoubleLinkedList<T> list;
    protected int size;

    public QueueDoubleLinkedListImpl(int size) {
        this.size = size;
        this.list = new DoubleLinkedListImpl<>();
    }

    @Override
    public void enqueue(T element) throws QueueOverflowException {
        if (this.isFull()) {
            throw new QueueOverflowException();
        }

        this.list.insert(element);
    }

    @Override
    public T dequeue() throws QueueUnderflowException {
        if (this.isEmpty()) {
            throw new QueueUnderflowException();
        }

        T element = this.head();
        this.list.removeFirst();

        return element;
    }

    @Override
    public T head() {
        T head = null;

        if (!this.isEmpty()) {
            head = this.list.toArray()[0];
        }

        return head;
    }

    @Override
    public boolean isEmpty() {
        return this.list.size() == 0;
    }

    @Override
    public boolean isFull() {
        return this.size == this.list.size();
    }

}
