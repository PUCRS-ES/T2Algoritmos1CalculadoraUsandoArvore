package source;

import java.util.ArrayList;

public class Queue<E> {

    private ArrayList<E> fila;

    public Queue() {
        fila = new ArrayList();
    }

    public int size() {
        return fila.size();
    }

    public boolean isEmpty() {
        return fila.isEmpty();
    }

    public E head() throws Exception {
        if (fila.isEmpty()) {
            throw new Exception("A fila esta vazia");
        } else {
            E elem = fila.get(0);
            return elem;
        }
    }

    public void enqueue(E element) {
        fila.add(element);
    }

    public E dequeue() throws Exception {
        if (fila.isEmpty()) {
            throw new Exception("Fila esta vazia!");
        } else {
            E elem = fila.remove(0);
            if (elem != null) {
                return elem;
            } else {
                throw new Exception("Fila esta vazia!");
            }
        }
    }

    public void clear() {
        fila.clear();
    }
}
