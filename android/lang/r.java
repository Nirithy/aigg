package android.lang;

import java.io.IOException;
import java.io.OutputStream;

class r extends OutputStream {
    static final r a;

    static {
        r.a = new r();
    }

    @Override
    public void write(int v) {
        throw new IOException("Stream closed");
    }
}

