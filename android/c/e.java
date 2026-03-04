package android.c;

public class e implements Cloneable {
    private static final Object a;
    private boolean b;
    private long[] c;
    private Object[] d;
    private boolean[] e;
    private int f;

    static {
        e.a = new Object();
    }

    public e() {
        this(16);
    }

    public e(int v) {
        this.b = false;
        if(v == 0) {
            this.c = b.e;
            this.d = b.f;
            this.e = b.g;
        }
        else {
            int v1 = b.a(v);
            this.c = new long[v1];
            this.d = new Object[v1];
            this.e = new boolean[v1];
        }
        this.f = 0;
    }

    public e a() {
        e e0;
        try {
            e0 = (e)super.clone();
        }
        catch(CloneNotSupportedException unused_ex) {
            return null;
        }
        try {
            e0.c = (long[])this.c.clone();
            e0.d = (Object[])this.d.clone();
            e0.e = (boolean[])this.e.clone();
        }
        catch(CloneNotSupportedException unused_ex) {
        }
        return e0;
    }

    public Object a(int v) {
        Object object0 = this.d[v];
        if(object0 != e.a) {
            this.d[v] = e.a;
            this.b = true;
            return object0;
        }
        return null;
    }

    public Object a(long v) {
        return this.a(v, null);
    }

    public Object a(long v, Object object0) {
        int v1 = b.a(this.c, this.f, v);
        return v1 >= 0 && this.d[v1] != e.a ? this.d[v1] : object0;
    }

    public Object a(long v, Object object0, byte b) {
        boolean z = true;
        int v1 = b.a(this.c, this.f, v);
        if(v1 >= 0) {
            Object object1 = this.d[v1];
            this.d[v1] = object0;
            if(b != 0) {
                boolean[] arr_z = this.e;
                if(b != 1) {
                    z = false;
                }
                arr_z[v1] = z;
            }
            return object1;
        }
        int v2 = ~v1;
        if(v2 < this.f && this.d[v2] == e.a) {
            this.c[v2] = v;
            this.d[v2] = object0;
            if(b != 0) {
                boolean[] arr_z1 = this.e;
                if(b != 1) {
                    z = false;
                }
                arr_z1[v2] = z;
            }
            return null;
        }
        if(this.b && this.f >= this.c.length) {
            this.d();
            v2 = ~b.a(this.c, this.f, v);
        }
        this.c = d.a(this.c, this.f, v2, v);
        this.d = d.a(this.d, this.f, v2, object0);
        boolean[] arr_z2 = this.e;
        int v3 = this.f;
        if(b != 1) {
            z = false;
        }
        this.e = d.a(arr_z2, v3, v2, z);
        ++this.f;
        return null;
    }

    public void a(int v, boolean z) {
        if(this.b) {
            this.d();
        }
        this.e[v] = z;
    }

    public int b() {
        if(this.b) {
            this.d();
        }
        return this.f;
    }

    public long b(int v) {
        if(this.b) {
            this.d();
        }
        return this.c[v];
    }

    public Object b(long v) {
        int v1 = b.a(this.c, this.f, v);
        if(v1 >= 0) {
            Object object0 = this.d[v1];
            if(object0 != e.a) {
                this.d[v1] = e.a;
                this.b = true;
                return object0;
            }
        }
        return null;
    }

    public int c(long v) {
        if(this.b) {
            this.d();
        }
        return b.a(this.c, this.f, v);
    }

    public Object c(int v) {
        if(this.b) {
            this.d();
        }
        return this.d[v];
    }

    public void c() {
        this.c = new long[16];
        this.d = new Object[16];
        this.e = new boolean[16];
        this.f = 0;
        this.b = false;
    }

    @Override
    public Object clone() {
        return this.a();
    }

    private void d() {
        int v = this.f;
        long[] arr_v = this.c;
        Object[] arr_object = this.d;
        boolean[] arr_z = this.e;
        int v2 = 0;
        for(int v1 = 0; v1 < v; ++v1) {
            Object object0 = arr_object[v1];
            if(object0 != e.a) {
                if(v1 != v2) {
                    arr_v[v2] = arr_v[v1];
                    arr_object[v2] = object0;
                    arr_z[v2] = arr_z[v1];
                    arr_object[v1] = null;
                }
                ++v2;
            }
        }
        this.b = false;
        this.f = v2;
    }

    public boolean d(int v) {
        if(this.b) {
            this.d();
        }
        return this.e[v];
    }

    @Override
    public String toString() {
        if(this.b() <= 0) {
            return "{}";
        }
        StringBuilder stringBuilder0 = new StringBuilder(this.f * 28);
        stringBuilder0.append('{');
        for(int v = 0; v < this.f; ++v) {
            if(v > 0) {
                stringBuilder0.append(", ");
            }
            stringBuilder0.append(this.b(v));
            stringBuilder0.append('=');
            Object object0 = this.c(v);
            if(object0 == this) {
                stringBuilder0.append("(this Map)");
            }
            else {
                stringBuilder0.append(object0);
            }
            stringBuilder0.append(" [");
            stringBuilder0.append(this.d(v));
            stringBuilder0.append("]");
        }
        stringBuilder0.append('}');
        return stringBuilder0.toString();
    }
}

