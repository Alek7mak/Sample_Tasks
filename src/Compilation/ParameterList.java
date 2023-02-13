package Compilation;

// size(), add(value), get(index), set(index, value), remove(index), insert(index, value), find(value)

import java.util.Arrays;

public class ParameterList<T> {

    private int size = 0;
    private Object[] data;

    ///////////////////////// Methods /////////////////////////

    public int size() {
        return size;
    }

    public void add(T value) {
        size++;
        if (size == 1) {
            data = new Object[size];
        } else {
            Object[] temp = data;
            data = Arrays.copyOf(temp, size);
        }
        data[size - 1] = value;
    }

    public T get(int index) {
        checkIndex(index);
        return data(index);
    }

    public T set(int index, T value) {
        checkIndex(index);
        T oldValue = data(index);
        data[index] = value;
        return oldValue;
    }

    public T remove(int index) {
        size--;
        checkIndex(index);
        T oldValue = data(index);
        Object[] temp = data;
        data = new Object[size];

        for (int i = 0, j = 0; i < size; i++, j++) {
            if (i == index) {
                j++;
            }
            data[i] = temp[j];
        }
        return oldValue;
    }

    public void insert(int index, T value) {
        checkIndex(index);
        size++;
        Object[] temp = data;
        data = new Object[size];

        for (int i = 0, j = 0; i < size; i++, j++) {
            if (i == index) {
                data[i] = value;
                j--;
            } else {
                data[i] = temp[j];
            }
        }
    }

    public int find(T value) {
        for (int i = 0; i < size; i++) {
            if (data[i] == value) {
                return i;
            }
        }
        return -1;
    }


    private int checkIndex(int index) {
        if (index >= 0 && index <= size) {
            return index;
        } else {
            throw new ArrayIndexOutOfBoundsException("Wrong index!");
        }
    }


    private T data(int index) {
        checkIndex(index);
        return (T) data[index];
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < size; i++) {
            stringBuilder.append(data(i)).append(i == size - 1 ? "" : " ");
        }
        return stringBuilder.toString();
    }
}