package android.ext;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class bk {
    private final ByteBuffer a;
    private final byte[] b;

    public bk(byte[] arr_b) {
        this.b = arr_b;
        this.a = ByteBuffer.wrap(arr_b);
        this.a.order(ByteOrder.LITTLE_ENDIAN);
    }

    public byte a() {
        return this.a.get();
    }

    public String a(int v, String s) {
        boolean z = false;
        if(v == 0) {
            return "";
        }
        int v1 = this.a.position();
        String s1 = null;
        byte[] arr_b = this.b;
        if(s != null && s.length() == v) {
            for(int v2 = 0; true; ++v2) {
                if(v2 >= v) {
                    z = true;
                    break;
                }
                if(s.charAt(v2) != arr_b[v1 + v2]) {
                    break;
                }
            }
            if(z) {
                s1 = s;
            }
        }
        if(s1 == null) {
            s1 = new String(arr_b, v1, v);
        }
        this.a.position(v1 + v);
        return s1;
    }

    public void a(int v) {
        this.a.position(this.a.position() + v);
    }

    public void a(byte[] arr_b) {
        this.a.get(arr_b);
    }

    public void a(byte[] arr_b, int v, int v1) {
        this.a.get(arr_b, v, v1);
    }

    public int b() {
        return this.a.getInt();
    }

    // 去混淆评级： 低(20)
    public long c() {
        return InOut.a ? this.a.getLong() : ((long)this.b()) & 0xFFFFFFFFL;
    }

    public long d() {
        return this.a.getLong();
    }

    public int e() {
        return this.a.capacity();
    }

    public int f() {
        return this.a.position();
    }

    public void g() {
        this.a.position(2);
    }

    public byte h() {
        int v = this.a.position();
        this.a.position(1);
        byte b = -1;
        try {
            b = this.a();
        }
        catch(IOException iOException0) {
            la.c("getSeq fail", iOException0);
        }
        this.a.position(v);
        return b;
    }
}

