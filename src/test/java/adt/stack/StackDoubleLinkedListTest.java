package adt.stack;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class StackDoubleLinkedListTest {
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;
    private Stack<Integer> stack3;
    private Stack<Integer> stack;

    @Before
    public void setUp() throws StackOverflowException {
        getImplementations();
        this.stack = new StackDoubleLinkedListImpl<>(7);

        // Pilha com 3 elementos não cheia.
        stack1.push(1);
        stack1.push(2);
        stack1.push(3);

        // Pilha com 2 elementos de tamanho 2, pilha cheia.
        stack2.push(1);
        stack2.push(2);

    }

    private void getImplementations() {
        // TODO O aluno deve ajustar aqui para instanciar sua implementação
        stack1 = new StackDoubleLinkedListImpl<>(5);
        stack2 = new StackDoubleLinkedListImpl<>(2);
        stack3 = new StackDoubleLinkedListImpl<>(10);
    }

    // MÉTODOS DE TESTE
    @Test
    public void testTop() {
        Assert.assertEquals(new Integer(3), stack1.top());
    }

    @Test
    public void testIsEmpty() {
        Assert.assertFalse(stack1.isEmpty());
    }

    @Test
    public void testIsFull() {
        Assert.assertFalse(stack1.isFull());
    }

    @Test
    public void testPush() {
        try {
            stack1.push(5);
        } catch (StackOverflowException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testPop() {
        try {
            Assert.assertEquals(new Integer(3), stack1.pop());
        } catch (StackUnderflowException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testInsertElement() throws StackOverflowException {
        this.stack.push(1);
        this.stack.push(2);
        Assert.assertEquals(2, this.stack.top(), 0);
    }

    @Test (expected = StackOverflowException.class)
    public void testInsertElementFull() throws StackOverflowException {
        this.stack.push(1);
        this.stack.push(2);
        this.stack.push(3);
        this.stack.push(4);
        this.stack.push(5);
        this.stack.push(6);
        this.stack.push(7);
        this.stack.push(8);
    }

    @Test
    public void testRemoveElement() throws StackOverflowException, StackUnderflowException {
        this.stack.push(1);
        this.stack.push(2);
        this.stack.push(3);
        Assert.assertEquals(3, this.stack.pop(), 0);
    }

    @Test (expected = StackUnderflowException.class)
    public void testRemoveElementStackEmpty() throws StackUnderflowException {
        this.stack.pop();
    }

    @Test (expected = StackUnderflowException.class)
    public void testRemoveElementStackEmpty2() throws StackUnderflowException, StackOverflowException {
        this.stack.pop();
        this.stack.push(2);
        Assert.assertEquals(2, this.stack.top(), 0);
    }

    @Test
    public void testTopElement() throws StackOverflowException, StackUnderflowException {
        this.stack.push(1);
        this.stack.push(2);
        this.stack.push(3);
        this.stack.pop();
        Assert.assertEquals(2, this.stack.top(), 0);
    }

    @Test
    public void testTopElementIsEmpty() throws StackOverflowException, StackUnderflowException {
        Assert.assertNull(this.stack.top());
    }

    @Test
    public void testTopElementIsFull() throws StackOverflowException {
        Stack<Integer> stack = new StackDoubleLinkedListImpl<>(3);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        Assert.assertEquals(3, stack.top(), 0);
    }

    @Test
    public void testStackIsEmpty() {
        Assert.assertTrue(this.stack.isEmpty());
    }

    @Test
    public void testStackIsNotEmpty() throws StackOverflowException {
        this.stack.push(2);
        Assert.assertFalse(this.stack.isEmpty());
    }

    @Test
    public void testStackIsNotFull() throws StackOverflowException {
        this.stack.push(2);
        Assert.assertFalse(this.stack.isFull());
    }

    @Test
    public void testStackIsFull() throws StackOverflowException {
        Stack<Integer> stack = new StackDoubleLinkedListImpl<>(3);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        Assert.assertTrue(stack.isFull());
    }
}
