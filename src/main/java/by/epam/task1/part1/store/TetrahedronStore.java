package by.epam.task1.part1.store;

import by.epam.task1.part1.entity.Tetrahedron;

import java.util.ArrayList;
import java.util.Collection;

public class TetrahedronStore {
    private ArrayList<Tetrahedron> store = new ArrayList<>();

    public int size() {
        return store.size();
    }

    public boolean isEmpty() {
        return store.isEmpty();
    }

    public Tetrahedron get(int index) {
        return store.get(index);
    }

    public Tetrahedron set(int index, Tetrahedron element) {
        return store.set(index, element);
    }

    public boolean add(Tetrahedron tetrahedron) {
        return store.add(tetrahedron);
    }

    public Tetrahedron remove(int index) {
        return store.remove(index);
    }

    public void clear() {
        store.clear();
    }

    public boolean addAll(Collection<? extends Tetrahedron> c) {
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
        TetrahedronStore other = (TetrahedronStore) o;
        int arraySize = store.size();
        if (store.size() != other.store.size()){
            return false;
        }
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
        for (Tetrahedron tetrahedron : store) {
            hash += hash * 31 + tetrahedron.hashCode();
        }
        return hash;
    }

    @Override
    public String toString() {
        return "TetrahedronStore{" + store + '}';
    }
}
