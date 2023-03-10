package Compilation;

// size(), add(value), get(index), set(index, value), remove(index), insert(index, value), find(value)


import java.lang.reflect.Array;
import java.net.BindException;
import java.util.Arrays;

public class ParameterList<T> {

    private int size = 0;
    private Object[] data;

    ///////////////////////// Methods /////////////////////////
    

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