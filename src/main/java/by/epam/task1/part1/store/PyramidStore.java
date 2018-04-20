package by.epam.task1.part1.store;

import by.epam.task1.part1.entity.Pyramid;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class PyramidStore {
    private ArrayList<Pyramid> store;

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
}
