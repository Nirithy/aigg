package luaj;

import java.io.IOException;
import java.io.InputStream;
import java.io.PushbackInputStream;

class d extends PushbackInputStream {
    boolean a;
    static final int b;

    static {
        d.b = 65;
    }

    private d(InputStream inputStream0) {
        super(inputStream0, d.b);
        this.a = false;
    }

    static d a(InputStream inputStream0) {
        return inputStream0 instanceof d ? ((d)inputStream0) : new d(inputStream0);
    }

    public d a(boolean z) {
        this.a = z;
        return this;
    }

    @Override
    public int read() {
        int v1;
        byte[] arr_b = this.buf;
        if(arr_b == null) {
            throw new IOException();
        }
        if(this.pos < d.b) {
            int v = this.pos;
            this.pos = v + 1;
            v1 = arr_b[v] & 0xFF;
        }
        else {
            v1 = this.in.read();
        }
        if(v1 != 0xEF || !this.a) {
            return v1;
        }
        int v2 = super.read();
        if(v2 != 0xBB) {
            this.unread(v2);
            return v1;
        }
        int v3 = super.read();
        if(v3 != 0xBF) {
            this.unread(v3);
            this.unread(0xBB);
            return v1;
        }
        return this.read();
    }
}

