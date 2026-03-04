package android.lang;

import java.util.Map.Entry;

class b implements Map.Entry {
    private final Map.Entry a;

    public b(Map.Entry map$Entry0) {
        this.a = map$Entry0;
    }

    public String a() {
        return ((l)this.a.getKey()).toString();
    }

    public String a(String s) {
        k k0 = k.b(s);
        return ((k)this.a.setValue(k0)).toString();
    }

    public String b() {
        return ((k)this.a.getValue()).toString();
    }

    // 去混淆评级： 低(20)
    @Override
    public boolean equals(Object object0) {
        return object0 instanceof b && this.a.equals(((b)object0).a);
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
    public int hashCode() {
        return this.a.hashCode();
    }

    @Override
    public Object setValue(Object object0) {
        return this.a(((String)object0));
    }

    @Override
    public String toString() {
        return this.a() + '=' + this.b();
    }
}

