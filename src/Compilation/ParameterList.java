package Compilation;

// size(), add(value), get(index), set(index, value), remove(index), insert(index, value), find(value)

public class ParameterList<E> {

    private int size = 0;
    Object[] data;


    public int size() {
        return size;
    }

    public boolean add(E value) {
        if (size == 0) {
            size++;
            data = new Object[size];
        } else {
            size++;
            Object[] buff = data;
            data = new Object[size];

            for (int i = 0; i < size; i++) {
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

        Object[] buff = data;
        data = new Object[++size];

        for (int i = 0, j = 0; i < size; i++, j++) {
            if (i == index) {
                data[i] = value;
                j--;
            } else {
                data[i] = buff[i];
            }
        }
        return oldValue;
    }

    public E remove(int index) {
        E oldValue = (E) data[index];

        Object[] buff = data;
        data = new Object[--size];

        for (int i = 0, j = 0; i < size; i++, j++) {
            if (i == index) {
                j++;
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
                j++;
            } else {
                data[i] = buff[i];
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