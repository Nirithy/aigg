package android.lang;

import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;

class i extends AbstractCollection {
    private final Collection a;

    public i(Collection collection0) {
        this.a = collection0;
    }

    @Override
    public void clear() {
        this.a.clear();
    }

    @Override
    public boolean contains(Object object0) {
        k k0 = k.a(object0);
        return this.a.contains(k0);
    }

    // 去混淆评级： 低(20)
    @Override
    public boolean equals(Object object0) {
        return object0 instanceof i && this.a.equals(((i)object0).a);
    }

    @Override
    public int hashCode() {
        return this.a.hashCode();
    }

    @Override
    public boolean isEmpty() {
        return this.a.isEmpty();
    }

    @Override
    public Iterator iterator() {
        return new j(this);
    }

    @Override
    public boolean remove(Object object0) {
        k k0 = k.a(object0);
        return this.a.remove(k0);
    }

    @Override
    public int size() {
        return this.a.size();
    }
}

