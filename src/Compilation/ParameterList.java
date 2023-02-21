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
        if (size == 0) {
            data = new Object[1];
        } else {
            data = Arrays.copyOf(data, size + 1);
        }
        size++;
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
        checkIndex(index);
        T oldValue = data(index);;
        size--;
        Object[] temp = data;
        data = new Object[size];

        for (int i = 0; i < size; i++) {
            if (i < index) {
                data[i] = temp[i];
            } else {
                data[i] = temp[i + 1];
            }
        }
        return oldValue;
    }

    public void insert(int index, T value) {
        checkIndex(index);
        size++;
        Object[] temp = data;
        data = new Object[size];
        data[index] = value;

        for (int i = 0; i < size; i++) {
            if (i < index) {
                data[i] = temp[i];
            } else if (i > index) {
                data[i] = temp[i - 1];
            }
        }
    }

    public int find(T value) {
        for (int i = 0; i < size; i++) {
            if (data[i] == value) return i;
        }
        return -1;
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
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