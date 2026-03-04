package android.ext;

import java.io.RandomAccessFile;
import java.nio.ByteBuffer;

class kn {
    final jp a;
    private RandomAccessFile b;
    private ByteBuffer c;
    private final boolean d;

    private kn(jp jp0, int v) {
        this.a = jp0;
        super();
        this.b = null;
        this.c = null;
        this.d = jp.c[v];
        if(this.d) {
            if(jp.b == null || jp.b[v] == null) {
                throw new ki("memCache is null 3: " + v + ' ' + jp.b);
            }
            this.c = ByteBuffer.wrap(jp.b[v]);
            return;
        }
        this.b = jp0.a(v);
    }

    kn(jp jp0, int v, kn kn0) {
        this(jp0, v);
    }

    public int a(byte[] arr_b, int v, int v1) {
        if(this.d) {
            int v2 = Math.min(v1, this.c.remaining());
            if(v2 != 0) {
                this.c.get(arr_b, v, v2);
                return v2;
            }
            return -1;
        }
        return this.b.read(arr_b, v, v1);
    }

    public void a() {
    }

    public void a(int v) {
        if(this.d) {
            this.c.position(this.c.position() + v);
            return;
        }
        this.b.skipBytes(v);
    }

    public void a(long v) {
        if(this.d) {
            this.c.position(((int)v));
            return;
        }
        this.b.seek(v);
    }

    public void a(byte[] arr_b) {
        if(this.d) {
            this.c.put(arr_b);
            return;
        }
        this.b.write(arr_b);
    }

    public int b(byte[] arr_b) {
        return this.a(arr_b, 0, arr_b.length);
    }

    public void b(byte[] arr_b, int v, int v1) {
        if(this.d) {
            this.c.put(arr_b, v, v1);
            return;
        }
        this.b.write(arr_b, v, v1);
    }
}

