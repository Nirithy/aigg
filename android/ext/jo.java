package android.ext;

import java.io.OutputStream;

class jo extends OutputStream {
    private final OutputStream a;

    public jo(OutputStream outputStream0) {
        this.a = outputStream0;
    }

    private int a(int v) {
        return v < 0 || v > 15 ? v : v + 97;
    }

    private byte[] a(byte[] arr_b, int v, int v1) {
        byte[] arr_b1 = new byte[v1 * 2 + 4];
        arr_b1[0] = 59;
        arr_b1[1] = 59;
        for(int v2 = 0; v2 < v1; ++v2) {
            int v3 = arr_b[v + v2];
            arr_b1[v2 * 2 + 2] = (byte)this.a(v3 & 15);
            arr_b1[v2 * 2 + 3] = (byte)this.a((v3 & 0xF0) >> 4);
        }
        arr_b1[v1 * 2 + 2] = 10;
        arr_b1[v1 * 2 + 3] = 10;
        return arr_b1;
    }

    @Override
    public void flush() {
        this.a.flush();
    }

    @Override
    public void write(int v) {
        this.a.write(this.a(v & 15));
        this.a.write(this.a((v & 0xF0) >> 4));
    }

    @Override
    public void write(byte[] arr_b) {
        byte[] arr_b1 = this.a(arr_b, 0, arr_b.length);
        this.a.write(arr_b1);
    }

    @Override
    public void write(byte[] arr_b, int v, int v1) {
        byte[] arr_b1 = this.a(arr_b, v, v1);
        this.a.write(arr_b1);
    }
}

