package android.ext;

import java.lang.reflect.Method;

class tn {
    Class a;
    String b;
    Class[] c;
    Object d;
    Object[] e;
    Method f;

    public tn(Class class0, String s, Class[] arr_class, Object object0, Object[] arr_object) {
        this.a = class0;
        this.b = s;
        this.c = arr_class;
        this.d = object0;
        this.e = arr_object;
        this.f = null;
    }

    public tn a() {
        this.f = this.a.getMethod(this.b, this.c);
        return this;
    }

    public Object b() {
        return this.f.invoke(this.d, this.e);
    }
}

