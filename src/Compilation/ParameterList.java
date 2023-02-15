package Compilation;

// size(), add(value), get(index), set(index, value), remove(index), insert(index, value), find(value)

import java.util.Arrays;

public class ParameterList<T> {

    private int size = 0;
    private Object[] data;

    ///////////////////////// Methods /////////////////////////



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