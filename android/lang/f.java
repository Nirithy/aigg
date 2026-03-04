package android.lang;

import java.util.AbstractMap;
import java.util.Collection;
import java.util.Map.Entry;
import java.util.Map;
import java.util.Set;

class f extends AbstractMap {
    private Map a;

    public f(Map map0) {
        this.a = map0;
    }

    private static String a(k k0) {
        return k0 == null ? null : k0.toString();
    }

    public String a(Object object0) {
        return f.a(((k)this.a.get(l.a(object0))));
    }

    public String a(String s, String s1) {
        return f.a(((k)this.a.put(l.b(s), k.b(s1))));
    }

    public byte[] a(int[] arr_v) {
        int v = this.a.size() * 2;
        for(Object object0: this.a.entrySet()) {
            byte[] arr_b = ((l)((Map.Entry)object0).getKey()).a();
            v = ((k)((Map.Entry)object0).getValue()).a().length + (arr_b.length + v);
        }
        byte[] arr_b1 = new byte[v];
        int v1 = 0;
        for(Object object1: this.a.entrySet()) {
            byte[] arr_b2 = ((l)((Map.Entry)object1).getKey()).a();
            byte[] arr_b3 = ((k)((Map.Entry)object1).getValue()).a();
            System.arraycopy(arr_b2, 0, arr_b1, v1, arr_b2.length);
            int v2 = arr_b2.length + v1;
            arr_b1[v2] = 61;
            System.arraycopy(arr_b3, 0, arr_b1, v2 + 1, arr_b3.length);
            v1 = arr_b3.length + 1 + (v2 + 1);
        }
        arr_v[0] = this.a.size();
        return arr_b1;
    }

    public String b(Object object0) {
        return f.a(((k)this.a.remove(l.a(object0))));
    }

    @Override
    public void clear() {
        this.a.clear();
    }

    @Override
    public boolean containsKey(Object object0) {
        return this.a.containsKey(l.a(object0));
    }

    @Override
    public boolean containsValue(Object object0) {
        return this.a.containsValue(k.a(object0));
    }

    @Override
    public Set entrySet() {
        return new c(this.a.entrySet());
    }

    @Override
    public Object get(Object object0) {
        return this.a(object0);
    }

    @Override
    public boolean isEmpty() {
        return this.a.isEmpty();
    }

    @Override
    public Set keySet() {
        return new g(this.a.keySet());
    }

    @Override
    public Object put(Object object0, Object object1) {
        return this.a(((String)object0), ((String)object1));
    }

    @Override
    public Object remove(Object object0) {
        return this.b(object0);
    }

    @Override
    public int size() {
        return this.a.size();
    }

    @Override
    public Collection values() {
        return new i(this.a.values());
    }
}

