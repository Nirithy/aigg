package android.lang;

import java.util.Iterator;

class j implements Iterator {
    Iterator a;
    final i b;

    j(i i0) {
        this.b = i0;
        super();
        this.a = i0.a.iterator();
    }

    public String a() {
        Object object0 = this.a.next();
        return ((k)object0).toString();
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

