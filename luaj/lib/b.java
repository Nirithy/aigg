package luaj.lib;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

public class b extends BufferedInputStream {
    private long a;
    private long b;

    public b(InputStream inputStream0) {
        super(inputStream0);
        this.b = -1L;
    }

    public InputStream a() {
        return this.in;
    }

    public long b() {
        return this.a;
    }

    @Override
    public void mark(int v) {
        synchronized(this) {
            super.mark(v);
            this.b = this.a;
        }
    }

    @Override
    public int read() {
        int v = super.read();
        if(v != -1) {
            ++this.a;
        }
        return v;
    }

    @Override
    public int read(byte[] arr_b, int v, int v1) {
        int v2 = super.read(arr_b, v, v1);
        if(v2 != -1) {
            this.a += (long)v2;
        }
        return v2;
    }

    @Override
    public void reset() {
        synchronized(this) {
            if(!super.markSupported()) {
                throw new IOException("Mark not supported");
            }
            if(this.b == -1L) {
                throw new IOException("Mark not set");
            }
            super.reset();
            this.a = this.b;
        }
    }

    @Override
    public long skip(long v) {
        long v1 = super.skip(v);
        this.a += v1;
        return v1;
    }
}

