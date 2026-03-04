package android.lang;

import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Set;

class g extends AbstractSet {
    private final Set a;

    public g(Set set0) {
        this.a = set0;
    }

    @Override
    public void clear() {
        this.a.clear();
    }

    @Override
    public boolean contains(Object object0) {
        l l0 = l.a(object0);
        return this.a.contains(l0);
    }

    @Override
    public boolean isEmpty() {
        return this.a.isEmpty();
    }

    @Override
    public Iterator iterator() {
        return new h(this);
    }

    @Override
    public boolean remove(Object object0) {
        l l0 = l.a(object0);
        return this.a.remove(l0);
    }

    @Override
    public int size() {
        return this.a.size();
    }
}

