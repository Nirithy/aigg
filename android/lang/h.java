package android.lang;

import java.util.Iterator;

class h implements Iterator {
    Iterator a;
    final g b;

    h(g g0) {
        this.b = g0;
        super();
        this.a = g0.a.iterator();
    }

    public String a() {
        Object object0 = this.a.next();
        return ((l)object0).toString();
    }

    @Override
    public boolean hasNext() {
        return this.a.hasNext();
    }

    @Override
    public Object next() {
        return this.a();
    }

    @Override
    public void remove() {
        this.a.remove();
    }
}

