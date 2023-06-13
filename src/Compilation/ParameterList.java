package Compilation;


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
            data = new Object[1];
        } else {
            data = Arrays.copyOf(data, size);
        }
        data[size - 1] = value;
    }

    public T get(int index) {
        return data(index); // checked index
    }

    public T set(int index, T value) {
        T oldValue = data(index);
        data[index] = value;
        return oldValue;
    }

    public T remove(int index) {
        size--;
        T oldValue = data(index); // checked index

        for (int i = 0; i < size; i++) {
            if (i >= index) {
                data[i] = data[i + 1];
            }
        }
        data = Arrays.copyOf(data, size);
        return oldValue;
    }

    public void insert(int index, T value) {
        size++;
        checkIndex(index);
        data = Arrays.copyOf(data, size);

        for (int i = size - 1; i >= 0; i--) {
            if (i >= index) {
                data[i] = data[i - 1];
            }
        }
        data[index] = value;
    }


// size(), add(value), get(index), set(index, value), remove(index), insert(index, value), find(value)

    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException("Array index out of bounds!");
        }
    }

    @SuppressWarnings("unchecked")
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