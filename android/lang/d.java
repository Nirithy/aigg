package android.lang;

import java.util.Iterator;
import java.util.Map.Entry;

class d implements Iterator {
    Iterator a;
    final c b;

    d(c c0) {
        this.b = c0;
        super();
        this.a = c0.a.iterator();
    }

    public Map.Entry a() {
        Object object0 = this.a.next();
        return new b(((Map.Entry)object0));
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

