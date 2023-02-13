package Compilation;

// size(), add(value), get(index), set(index, value), remove(index), insert(index, value), find(value)

public class ParameterList<T> {

    private int size;
    private Object[] data;

    ///////////////////////// Methods /////////////////////////

    public int size() {
        return size;
    }

// size(), add(value), get(index), set(index, value), remove(index), insert(index, value), find(value)

    private int checkIndex(int index) {
        if (index >= 0 || index <= size) {
            return index;
        } else {
            throw new ArrayIndexOutOfBoundsException("Wrong index!");
        }
    }

    @SuppressWarnings("unchecked")
    private T data(int index) {
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