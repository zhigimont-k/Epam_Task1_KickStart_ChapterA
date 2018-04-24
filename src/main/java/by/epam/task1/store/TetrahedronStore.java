package by.epam.task1.store;

import by.epam.task1.entity.Tetrahedron;

import java.util.ArrayList;
import java.util.List;

public class TetrahedronStore {
    private List<Tetrahedron> store;

    public TetrahedronStore() {
        store = new ArrayList<>();
    }

    public boolean add(Tetrahedron tetrahedron) {
        return store.add(tetrahedron);
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
        if (arraySize != other.store.size()) {
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
