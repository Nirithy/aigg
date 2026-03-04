package android.lang;

import java.security.PrivilegedExceptionAction;

class o implements PrivilegedExceptionAction {
    final UNIXProcess a;
    private final int[] b;

    o(UNIXProcess uNIXProcess0, int[] arr_v) {
        this.a = uNIXProcess0;
        this.b = arr_v;
        super();
    }

    public Void a() {
        this.a.a(this.b);
        return null;
    }

    @Override
    public Object run() {
        return this.a();
    }
}

