package android.lang;

import java.io.InputStream;

class q extends InputStream {
    static final q a;

    static {
        q.a = new q();
    }

    @Override
    public int available() {
        return 0;
    }

    @Override
    public int read() {
        return -1;
    }
}

