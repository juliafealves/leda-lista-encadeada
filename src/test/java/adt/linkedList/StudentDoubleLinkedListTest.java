package adt.linkedList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class StudentDoubleLinkedListTest extends StudentLinkedListTest {

    private DoubleLinkedList<Integer> lista3;

    @Before
    public void setUp() throws Exception {
        getImplementations();

        // Lista com 3 elementos.
        lista1.insert(3);
        lista1.insert(2);
        lista1.insert(1);
    }

    private void getImplementations() {
        lista1 = new DoubleLinkedListImpl<>();
        lista2 = new DoubleLinkedListImpl<>();
        lista3 = new DoubleLinkedListImpl<>();
    }

    // Métodos de DoubleLinkedList

    @Test
    public void testInsertFirst() {
        ((DoubleLinkedList<Integer>) lista1).insertFirst(4);
        Assert.assertArrayEquals(new Integer[]{4, 3, 2, 1}, lista1.toArray());
    }

    @Test
    public void testInsertFirstNull() {
        ((DoubleLinkedList<Integer>) lista1).insertFirst(null);
        Assert.assertArrayEquals(new Integer[]{3, 2, 1}, lista1.toArray());
    }

    @Test
    public void testInsertNull() {
        lista1.insert(null);
        Assert.assertArrayEquals(new Integer[]{3, 2, 1}, lista1.toArray());
    }

    @Test
    public void testInsertFirstListEmpty() {
        ((DoubleLinkedList<Integer>) lista2).insertFirst(4);
        Assert.assertArrayEquals(new Integer[]{4}, lista2.toArray());

        ((DoubleLinkedList<Integer>) lista2).insertFirst(3);
        ((DoubleLinkedList<Integer>) lista2).insertFirst(2);
        Assert.assertArrayEquals(new Integer[]{2, 3, 4}, lista2.toArray());
    }

    @Test
    public void testGetHead() {
        Integer head = ((DoubleLinkedListImpl<Integer>) lista1).getHead().getData();
        Assert.assertEquals(3, head, 0);
    }

    @Test
    public void testGetLast() {
        lista3.insertFirst(2);
        Integer last = ((DoubleLinkedListImpl<Integer>) lista3).getLast().getData();
        Assert.assertEquals(2, last, 0);
    }

    @Test
    public void testGetPreviousHead() {
        lista3.insertFirst(2);
        DoubleLinkedListNode<Integer> head = (DoubleLinkedListNode<Integer>) ((DoubleLinkedListImpl<Integer>) lista3).getHead();
        DoubleLinkedListNode previous = head.getPrevious();
        Assert.assertEquals(new DoubleLinkedListNode(), previous);
    }

    @Test
    public void testGetNextHead() {
        lista3.insertFirst(2);
        lista3.insertFirst(3);
        DoubleLinkedListNode<Integer> head = (DoubleLinkedListNode<Integer>) ((DoubleLinkedListImpl<Integer>) lista3).getHead();
        SingleLinkedListNode<Integer> next = head.getNext();
        Assert.assertEquals(2, next.getData(), 0);
    }

    @Test
    public void testGetNextLast() {
        lista3.insertFirst(3);
        DoubleLinkedListNode<Integer> head = (DoubleLinkedListNode<Integer>) ((DoubleLinkedListImpl<Integer>) lista3).getHead();
        SingleLinkedListNode<Integer> next = head.getNext();
        Assert.assertEquals(new SingleLinkedListNode<>(), next);
    }

    @Test
    public void testGetPreviousNext() {
        lista3.insertFirst(2);
        lista3.insertFirst(3);
        DoubleLinkedListNode<Integer> next = (DoubleLinkedListNode<Integer>) ((DoubleLinkedListImpl<Integer>) lista3).getHead().getNext();
        DoubleLinkedListNode<Integer> previous = next.getPrevious();
        Assert.assertEquals(3, previous.getData(), 0);
    }

    @Test
    public void testRemoveFirst() {
        ((DoubleLinkedList<Integer>) lista1).removeFirst();
        Assert.assertArrayEquals(new Integer[]{2, 1}, lista1.toArray());
    }

    @Test
    public void testRemoveLast() {
        ((DoubleLinkedList<Integer>) lista1).removeLast();
        Assert.assertArrayEquals(new Integer[]{3, 2}, lista1.toArray());
    }

    @Test
    public void testRemove() {
        Assert.assertEquals(3, lista1.size());
        lista1.remove(2);
        lista1.remove(1);
        Assert.assertEquals(1, lista1.size());

    }

    @Test
    public void testSearch() {
        Assert.assertTrue(2 == lista1.search(2));
        Assert.assertNull(lista1.search(4));
        Assert.assertNull(lista1.search(null));
        Assert.assertFalse(3 == lista1.search(2));
    }
}