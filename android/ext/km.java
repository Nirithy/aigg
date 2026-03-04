package android.ext;

import java.io.OutputStream;
import java.io.RandomAccessFile;

class km extends OutputStream {
    private final RandomAccessFile a;

    private km(RandomAccessFile randomAccessFile0) {
        this.a = randomAccessFile0;
        randomAccessFile0.seek(0L);
        randomAccessFile0.setLength(0L);
    }

    km(RandomAccessFile randomAccessFile0, km km0) {
        this(randomAccessFile0);
    }

    @Override
    public void close() {
    }

    @Override
    public void flush() {
    }

    @Override
    public void write(int v) {
        this.a.write(v);
    }

    @Override
    public void write(byte[] arr_b) {
        this.a.write(arr_b);
    }

    @Override
    public void write(byte[] arr_b, int v, int v1) {
        this.a.write(arr_b, v, v1);
    }
}

