import java.util.Arrays;
import java.util.Iterator;

public class MyArrayList<E> implements Iterable<E> {
    // 真正存储数据的底层数组
    private E[] data;
    // 记录当前元素个数
    private int size;
    // 默认初始容量
    private static final int INIT_CAP = 1;

    public MyArrayList() {
        this(INIT_CAP);
    }

    public MyArrayList(int initCapacity) {
        this.data = (E[]) new Object[initCapacity];
        this.size = 0;
    }

    // 增
    public void addLast(E e) {
        if (this.size >= this.data.length) {
            this.resize(this.size << 1);
        }
        this.data[size] = e;
        this.size++;
    }

    public void add(int index, E e) {
        this.checkPositionIndex(index);
        if (this.size + 1 >= this.data.length) {
            this.resize(this.data.length << 1);
        }
        System.arraycopy(this.data, index, this.data, index + 1, this.size - index);
        this.data[index] = e;
        this.size++;
    }

    public void addFirst(E e) {
        this.checkPositionIndex(0);
        if (this.size + 1 >= this.data.length) {
            this.resize(this.data.length << 1);
        }
        System.arraycopy(this.data, 0, this.data, 1, this.size);
        this.data[0] = e;
        this.size++;
    }

    // 删
    public E removeLast() {
        this.checkElementIndex(this.size - 1);
        E temp = this.data[this.size - 1];
        this.data[this.size - 1] = null;
        this.size--;
        return temp;
    }

    public E remove(int index) {
        this.checkElementIndex(index);
        E temp = this.data[index];
        System.arraycopy(this.data, index + 1, this.data, index, this.size - index - 1);
        this.size--;
        return temp;
    }

    public E removeFirst() {
        this.checkElementIndex(0);
        E temp = this.data[0];
        System.arraycopy(this.data, 1, this.data, 0, this.size - 1);
        this.size--;
        return temp;
    }

    // 查
    public E get(int index) {
        this.checkElementIndex(index);
        return this.data[index];
    }

    // 改
    public E set(int index, E element) {
        this.checkElementIndex(index);
        E temp = this.data[index];
        this.data[index] = element;
        return temp;
    }

    // 工具方法
    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    // 将 data 的容量改为 newCap
    private void resize(int newCap) {
        E[] temp = this.data;
        this.data = (E[]) new Object[newCap];
        System.arraycopy(temp, 0, this.data, 0 , this.size);
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

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private int p = 0;

            @Override
            public boolean hasNext() {
                return p != size;
            }

            @Override
            public E next() {
                return data[p++];
            }
        };
    }

    private void display() {
        System.out.println("size = " + size + " cap = " + data.length);
        System.out.println(Arrays.toString(data));
    }


    public static void main(String[] args) {
        // 初始容量设置为 3
        MyArrayList<Integer> arr = new MyArrayList<>(3);

        // 添加 5 个元素
        for (int i = 1; i <= 5; i++) {
            arr.addLast(i);
            System.out.println("i=" + i);
        }

//        arr.remove(2);
//        arr.removeFirst();
//        arr.removeLast();
//        arr.add(0, 9);
//        arr.addFirst(100);
//        arr.set(2, 33);

        for (int i = 0; i < arr.size(); i++) {
            System.out.println(arr.get(i));
        }
    }

}