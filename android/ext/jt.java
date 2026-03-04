package android.ext;

import java.io.ByteArrayOutputStream;

class jt extends ByteArrayOutputStream {
    final jp a;
    private final int b;

    jt(jp jp0, int v, int v1) {
        this.a = jp0;
        this.b = v1;
        super(v);
    }

    @Override
    public void close() {
        super.close();
        byte[][] arr2_b = jp.b;
        if(arr2_b != null) {
            byte[] arr_b = this.toByteArray();
            if(arr_b == null) {
                la.a(new RuntimeException("toByteArray return null"));
            }
            arr2_b[this.b] = arr_b;
        }
    }
}

