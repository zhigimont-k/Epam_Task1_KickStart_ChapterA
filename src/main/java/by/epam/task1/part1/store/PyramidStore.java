package by.epam.task1.part1.store;

import by.epam.task1.part1.entity.Pyramid;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Objects;

public class PyramidStore {
    private ArrayList<Pyramid> store = new ArrayList<>();

    public int size() {
        return store.size();
    }

    public boolean isEmpty() {
        return store.isEmpty();
    }

    public Pyramid get(int index) {
        return store.get(index);
    }

    public Pyramid set(int index, Pyramid element) {
        return store.set(index, element);
    }

    public boolean add(Pyramid pyramid) {
        return store.add(pyramid);
    }

    public Pyramid remove(int index) {
        return store.remove(index);
    }

    public void clear() {
        store.clear();
    }

    public boolean addAll(Collection<? extends Pyramid> c) {
        return store.addAll(c);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        PyramidStore other = (PyramidStore) o;
        int arraySize = store.size();
        for (int i = 0; i < arraySize; i++) {
            if (!store.get(i).equals(other.store.get(i))) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 1;
        for (Pyramid pyramid : store) {
            hash += hash * 31 + pyramid.hashCode();
        }
        return hash;
    }

    @Override
    public String toString() {
        return "PyramidStore{" + store + '}';
    }
}
