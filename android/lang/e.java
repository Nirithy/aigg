package android.lang;

import java.util.Map.Entry;

class e implements Map.Entry {
    private final Object a;

    e(Object object0) {
        this.a = object0;
        super();
    }

    public k a(k k0) {
        throw new UnsupportedOperationException();
    }

    public l a() {
        return l.a(((Map.Entry)this.a).getKey());
    }

    public k b() {
        return k.a(((Map.Entry)this.a).getValue());
    }

    @Override
    public Object getKey() {
        return this.a();
    }

    @Override
    public Object getValue() {
        return this.b();
    }

    @Override
    public Object setValue(Object object0) {
        return this.a(((k)object0));
    }
}

