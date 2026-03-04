package android.ext;

import java.io.InputStream;
import java.io.RandomAccessFile;

class kl extends InputStream {
    private final RandomAccessFile a;

    private kl(RandomAccessFile randomAccessFile0) {
        this.a = randomAccessFile0;
        randomAccessFile0.seek(0L);
    }

    kl(RandomAccessFile randomAccessFile0, kl kl0) {
        this(randomAccessFile0);
    }

    @Override
    public int available() {
        int v = (int)(this.a.length() - this.a.getFilePointer());
        return v <= 0 ? 0 : v;
    }

    @Override
    public void close() {
    }

    @Override
    public void mark(int v) {
        synchronized(this) {
        }
    }

    @Override
    public boolean markSupported() {
        return false;
    }

    @Override
    public int read() {
        return this.a.read();
    }

    @Override
    public int read(byte[] arr_b) {
        return this.a.read(arr_b);
    }

    @Override
    public int read(byte[] arr_b, int v, int v1) {
        return this.a.read(arr_b, v, v1);
    }

    @Override
    public void reset() {
        synchronized(this) {
        }
    }

    @Override
    public long skip(long v) {
        long v1 = this.a.getFilePointer();
        this.a.seek(v1 + v);
        return v;
    }
}

