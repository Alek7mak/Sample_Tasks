package Compilation;

// size(), add(), get(), set(), remove(), insert(), find()

public class ParameterList<E> {

    private int size = 0;
    Object[] data;


    public int size() {
        return size;
    }

    public boolean add(E value) {
        if (size == 0) {
            size = 1;
            data = new Object[size];
        } else {
            size++;
            Object[] buff = data;
            data = new Object[size];
            for (int i = 0; i < size - 1; i++) {
                data[i] = buff[i];
            }
        }
        data[size - 1] = value;
        return true;
    }

    public E get(int index) {
        return (E) data[index];
    }

    public E set(int index, E value) {
        E oldValue = (E) data[index];
        data[index] = value;
        return oldValue;
    }

    public E remove(int index) {
        Object[] buff = data;
        E oldValue = (E) buff[index];
        buff[index] = null;
        size--;
        data = new Object[size];

        for (int i = 0, j = 0; i < size; i++, j++) {
            if (buff[j] == null) {
                i--;
            } else {
                data[i] = buff[j];
            }
        }

        return oldValue;
    }

    public void insert(int index, E value) {
        Object[] buff = data;
        data = new Object[++size];

        for (int i = 0, j = 0; i < size; i++, j++) {
            if (i == index) {
                data[i] = value;
                j--;
            } else {
                data[i] = buff[j];
            }
        }
    }

    public int find(E value) {
        for (int i = 0; i < size; i++) {
            if (data[i] == value) {
                return i;
            }
        }
        return -1;
    }
}