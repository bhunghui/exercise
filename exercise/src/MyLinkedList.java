import java.rmi.UnexpectedException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyLinkedList<E> implements Iterable<E> {
    // 虚拟头尾节点
    private final Node<E> head;
    private final Node<E> tail;
    private int size;

    // 双链表节点
    private static class Node<E> {
        public Node<E> next;
        public Node<E> prev;
        public E val;
        Node(E val) {
            this.val = val;
        }
    }

    // 构造函数初始化头尾节点
    public MyLinkedList() {
        this.head = new Node<>(null);
        this.tail = new Node<>(null);
        this.head.next = this.tail;
        this.tail.prev = this.head;
        this.size = 0;
    }


    /***** 增 *****/

    public void addLast(E e) {
        Node<E> temp = this.tail.prev;
        Node<E> newnode = new Node<>(e);
        temp.next = newnode;
        newnode.prev = temp;
        newnode.next = this.tail;
        this.tail.prev = newnode;
        this.size++;
    }

    public void addFirst(E e) {
        Node<E> newnode = new Node<>(e);
        Node<E> temp = this.head.next;
        newnode.prev = this.head;
        newnode.next = temp;
        temp.prev = newnode;
        this.head.next = newnode;
        this.size++;
      }

    public void add(int index, E element) {
        this.checkElementIndex(index);
        Node<E> newnode = new Node<>(element);
        Node<E> temp = this.getNode(index);
        temp.prev.next = newnode;
        newnode.prev = temp.prev;
        temp.prev = newnode;
        newnode.next = temp;
        this.size++;
    }

    /***** 删 *****/

    public E removeFirst() {
        Node<E> temp = this.getNode(0);
        this.head.next = temp.next;
        temp.next.prev = this.head;
        temp.next = null;
        temp.prev = null;
        this.size--;
        return temp.val;
    }

    public E removeLast() {
        Node<E> temp = this.getNode(this.size - 1);
        this.tail.prev = temp.prev;
        temp.prev.next = this.tail;
        temp.next = null;
        temp.prev = null;
        this.size--;
        return temp.val;
    }

    public E remove(int index) {
        Node<E> temp = this.getNode(index);
        temp.prev.next = temp.next;
        temp.next.prev = temp.prev;
        temp.prev = null;
        temp.next = null;
        this.size--;
        return temp.val;
    }

    /***** 查 *****/

    public E get(int index) {
        return this.getNode(index).val;
        }

    public E getFirst() {
        return this.getNode(0).val;
    }

    public E getLast() {
        return this.getNode(this.size - 1).val;
    }

    /***** 改 *****/

    public E set(int index, E val) {
        Node<E> temp = this.getNode(index);
        E rsval = temp.val;
        temp.val = val;
        return rsval;
    }

    /***** 其他工具函数 *****/

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    private Node<E> getNode(int index) {
        checkElementIndex(index);
        Node<E> p = head.next;
        // TODO: 可以优化，通过 index 判断从 head 还是 tail 开始遍历
        for (int i = 0; i < index; i++) {
            p = p.next;
        }
        return p;
    }

    private boolean isElementIndex(int index) {
        return index >= 0 && index < size;
    }

    private boolean isPositionIndex(int index) {
        return index >= 0 && index <= size;
    }

    /**
     * 检查 index 索引位置是否可以存在元素
     */
    private void checkElementIndex(int index) {
        if (!isElementIndex(index))
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
    }

    /**
     * 检查 index 索引位置是否可以添加元素
     */
    private void checkPositionIndex(int index) {
        if (!isPositionIndex(index))
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
    }

    private void display() {
        System.out.println("size = " + size);
        for (Node<E> p = head.next; p != tail; p = p.next) {
            System.out.print(p.val + " -> ");
        }
        System.out.println("null");
        System.out.println();
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<>() {
            Node<E> p = head.next;

            @Override
            public boolean hasNext() {
                return p != tail;
            }

            @Override
            public E next() {
                E val = p.val;
                p = p.next;
                return val;
            }
        };
    }
    public static void main(String[] args) {
       MyLinkedList<Integer> list = new MyLinkedList<>();
        for (int i = 0; i < 7; i++) {
            list.addLast(i);
        }
        list.display();
    }

}