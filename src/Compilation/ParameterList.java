package Compilation;

// size(), add(value), get(index), set(index, value), remove(index), insert(index, value), find(value)

public class ParameterList<E> {

    private int size = 0;
    Object[] data;


    public int size() {
        return size;
    }

    public void add(E value) {
        size++;
        Object[] buff;
        if (size == 1) {
            buff = new Object[size];
        } else {
            buff = new Object[size];
            System.arraycopy(data, 0, buff, 0, size - 1);
        }
        buff[size - 1] = value;
        data = buff;
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
        E oldValue = (E) data[index];
        size--;
        Object[] buff = new Object[size];

        for (int i = 0, j = 0; i < size; i++, j++) {
            if (i == index) {
                j++;
            }
            buff[i] = data[j];
        }
        data = buff;
        return oldValue;
    }

    public void insert(int index, E value) {
        size++;
        Object[] buff = new Object[size];

        for (int i = 0, j = 0; i < size; i++, j++) {
            if (i == index) {
                buff[i] = value;
                j--;
            }
            else {
                buff[i] = data[j];
            }
        }
        data = buff;
    }

    public int find(E value) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(value)) {
                return i;
            }
        }
        return -1;
    }
}