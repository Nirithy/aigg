package android.ext;

import java.io.InputStream;

class jn extends InputStream {
    private final InputStream a;
    private int b;

    public jn(InputStream inputStream0) {
        this.a = inputStream0;
        this.b = -2017;
    }

    @Override
    public int read() {
        int v = this.b;
        if(v != -2017) {
            this.b = -2017;
            return v;
        }
        InputStream inputStream0 = this.a;
        v = inputStream0.read();
        if(v >= 97 && v <= 0x70) {
            int v1 = inputStream0.read();
            if(v1 >= 97 && v1 <= 0x70) {
                return v + v1 * 16 - 0x671;
            }
            this.b = v1;
            return v;
        }
        return v;
    }

    @Override
    public int read(byte[] arr_b, int v, int v1) {
        int v5;
        int v4;
        int v2 = v + v1;
        int v3 = this.b;
        InputStream inputStream0 = this.a;
        while(v < v2) {
            while(true) {
                if(v3 != -2017) {
                    if(v3 == -1) {
                        v3 = -2017;
                    }
                    else {
                        v4 = v3;
                        v5 = -2017;
                        break;
                    }
                }
                v4 = inputStream0.read();
                if(v4 >= 97 && v4 <= 0x70) {
                    v5 = inputStream0.read();
                    if(v5 >= 97 && v5 <= 0x70) {
                        v4 = v4 + v5 * 16 - 0x671;
                        v5 = -2017;
                    }
                    break;
                }
                if(v4 != -1) {
                    v5 = -2017;
                    break;
                }
            }
            arr_b[v] = (byte)v4;
            ++v;
            v3 = v5;
        }
        this.b = v3;
        return 0;
    }
}

