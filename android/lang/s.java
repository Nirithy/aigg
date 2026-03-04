package android.lang;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

class s extends BufferedInputStream {
    s(int v) {
        super(UNIXProcess.e(v));
    }

    private static byte[] a(InputStream inputStream0) {
        byte[] arr_b = null;
        if(inputStream0 == null) {
            return null;
        }
        int v = 0;
        int v1;
        while((v1 = inputStream0.available()) > 0) {
            arr_b = arr_b == null ? new byte[v1] : Arrays.copyOf(arr_b, v + v1);
            v += inputStream0.read(arr_b, v, v1);
        }
        return arr_b == null || v == arr_b.length ? arr_b : Arrays.copyOf(arr_b, v);
    }

    void a() {
        synchronized(this) {
            InputStream inputStream0 = this.in;
            if(inputStream0 != null) {
                try {
                    byte[] arr_b = s.a(inputStream0);
                    inputStream0.close();
                    q q0 = arr_b == null ? q.a : new ByteArrayInputStream(arr_b);
                    this.in = q0;
                    if(this.buf == null) {
                        this.in = null;
                    }
                }
                catch(IOException unused_ex) {
                }
            }
        }
    }
}

