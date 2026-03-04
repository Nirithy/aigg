package android.lang;

import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

class c extends AbstractSet {
    private final Set a;

    public c(Set set0) {
        this.a = set0;
    }

    private static Map.Entry a(Object object0) {
        return object0 instanceof b ? ((b)object0).a : new e(object0);
    }

    @Override
    public void clear() {
        this.a.clear();
    }

    @Override
    public boolean contains(Object object0) {
        Map.Entry map$Entry0 = c.a(object0);
        return this.a.contains(map$Entry0);
    }

    // 去混淆评级： 低(20)
    @Override
    public boolean equals(Object object0) {
        return object0 instanceof c && this.a.equals(((c)object0).a);
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
        return new d(this);
    }

    @Override
    public boolean remove(Object object0) {
        Map.Entry map$Entry0 = c.a(object0);
        return this.a.remove(map$Entry0);
    }

    @Override
    public int size() {
        return this.a.size();
    }
}

