package android.c;

public class f implements Cloneable {
    private long[] a;
    private long[] b;
    private int c;

    public f() {
        this(16);
    }

    public f(int v) {
        if(v == 0) {
            this.a = b.e;
            this.b = b.e;
        }
        else {
            int v1 = b.a(v);
            this.a = new long[v1];
            this.b = new long[v1];
        }
        this.c = 0;
    }

    public int a(long v) {
        return b.a(this.a, this.c, v);
    }

    public long a(int v) {
        return this.a[v];
    }

    public f a() {
        f f0;
        try {
            f0 = (f)super.clone();
        }
        catch(CloneNotSupportedException unused_ex) {
            return null;
        }
        try {
            f0.a = (long[])this.a.clone();
            f0.b = (long[])this.b.clone();
        }
        catch(CloneNotSupportedException unused_ex) {
        }
        return f0;
    }

    public boolean a(long v, long v1) {
        int v2 = b.a(this.a, this.c, v);
        if(v2 >= 0) {
            long[] arr_v = this.b;
            if(arr_v[v2] == v1) {
                return false;
            }
            arr_v[v2] = v1;
            return true;
        }
        this.a = d.a(this.a, this.c, ~v2, v);
        this.b = d.a(this.b, this.c, ~v2, v1);
        ++this.c;
        return true;
    }

    public int b() {
        return this.c;
    }

    public long b(int v) {
        return this.b[v];
    }

    public void c() {
        this.a = new long[16];
        this.b = new long[16];
        this.c = 0;
    }

    @Override
    public Object clone() {
        return this.a();
    }

    @Override
    public String toString() {
        if(this.b() <= 0) {
            return "{}";
        }
        StringBuilder stringBuilder0 = new StringBuilder(this.c * 28);
        stringBuilder0.append('{');
        for(int v = 0; v < this.c; ++v) {
            if(v > 0) {
                stringBuilder0.append(", ");
            }
            stringBuilder0.append(this.a(v));
            stringBuilder0.append('=');
            stringBuilder0.append(this.b(v));
        }
        stringBuilder0.append('}');
        return stringBuilder0.toString();
    }
}

