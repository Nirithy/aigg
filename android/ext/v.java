package android.ext;

import java.io.OutputStream;

class v extends OutputStream {
    int a;
    static v b;
    private OutputStream c;

    public v(OutputStream outputStream0) {
        this.a = 0;
        this.c = outputStream0;
        v.b = this;
    }

    @Override
    public void close() {
        this.c.close();
    }

    @Override
    public boolean equals(Object object0) {
        return this.c.equals(object0);
    }

    @Override
    public void flush() {
        this.c.flush();
    }

    @Override
    public int hashCode() {
        return this.c.hashCode();
    }

    @Override
    public String toString() {
        return this.c.toString();
    }

    @Override
    public void write(int v) {
        this.c.write(v);
        ++this.a;
    }

    @Override
    public void write(byte[] arr_b) {
        this.c.write(arr_b);
        this.a += arr_b.length;
    }

    @Override
    public void write(byte[] arr_b, int v, int v1) {
        this.c.write(arr_b, v, v1);
        this.a += v1;
    }
}

