package android.ext;

import java.io.InputStream;

class ue extends InputStream {
    private final InputStream a;
    private int b;
    private int c;
    private final byte[] d;

    public ue(InputStream inputStream0) {
        this.a = inputStream0;
        this.b = 0;
        this.c = 0;
        this.d = new byte[0x200];
    }

    public String a() {
        String s = "buf[" + this.b + "]: ";
        return this.b > this.d.length ? s + new String(this.d, this.c, this.d.length - this.c) + new String(this.d, 0, this.c) : s + new String(this.d, 0, this.c);
    }

    @Override
    public int available() {
        return this.a.available();
    }

    @Override
    public void close() {
        this.a.close();
    }

    @Override
    public boolean equals(Object object0) {
        return this.a.equals(object0);
    }

    @Override
    public int hashCode() {
        return this.a.hashCode();
    }

    @Override
    public void mark(int v) {
        this.a.mark(v);
    }

    @Override
    public boolean markSupported() {
        return this.a.markSupported();
    }

    @Override
    public int read() {
        int v = this.a.read();
        if(v > 0) {
            ++this.b;
            this.d[this.c] = (byte)v;
            this.c = (this.c + 1) % this.d.length;
        }
        return v;
    }

    @Override
    public void reset() {
        this.a.reset();
    }

    @Override
    public long skip(long v) {
        return this.a.skip(v);
    }

    @Override
    public String toString() {
        return this.a.toString();
    }
}

