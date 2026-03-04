package android.a;

import java.io.OutputStream;

class b extends OutputStream {
    @Override
    public void write(int v) {
        throw new AssertionError();
    }
}

