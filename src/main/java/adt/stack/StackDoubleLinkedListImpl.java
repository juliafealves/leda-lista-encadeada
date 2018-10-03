package adt.stack;

import adt.linkedList.DoubleLinkedList;
import adt.linkedList.DoubleLinkedListImpl;

public class StackDoubleLinkedListImpl<T> implements Stack<T> {

    protected DoubleLinkedList<T> top;
    protected int size;

    public StackDoubleLinkedListImpl(int size) {
        this.size = size;
        this.top = new DoubleLinkedListImpl<T>();
    }

    @Override
    public void push(T element) throws StackOverflowException {
        if (this.isFull()) {
            throw new StackOverflowException();
        }

        this.top.insertFirst(element);
    }

    @Override
    public T pop() throws StackUnderflowException {
        if (this.isEmpty()) {
            throw new StackUnderflowException();
        }

        T element = this.top();
        this.top.removeFirst();

        return element;
    }

    @Override
    public T top() {
        T element = null;

        if (!this.isEmpty()) {
            element = this.top.toArray()[0];
        }

        return element;
    }

    @Override
    public boolean isEmpty() {
        return this.top.size() == 0;
    }

    @Override
    public boolean isFull() {
        return this.size == this.top.size();
    }

}
