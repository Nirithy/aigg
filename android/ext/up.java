package android.ext;

import android.util.Base64;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;

public class up {
    private int[] a;
    private int b;
    private final int c;

    public up(int v) {
        this.b = 0;
        this.c = v;
        this.a = new int[0x20];
    }

    private void a() {
        int v = this.b;
        int[] arr_v = this.a;
        ByteBuffer byteBuffer0 = ByteBuffer.allocate(v * 4);
        byteBuffer0.order(ByteOrder.LITTLE_ENDIAN);
        for(int v1 = 0; v1 < v; ++v1) {
            byteBuffer0.putInt(arr_v[v1]);
        }
        String s = Base64.encodeToString(byteBuffer0.array(), 11);
        new qw().a("used-" + this.c, s).commit();
    }

    public void a(int v) {
        int v1 = this.b;
        int[] arr_v = this.a;
        for(int v2 = 0; true; ++v2) {
            if(v2 >= v1) {
                if(v1 == arr_v.length) {
                    arr_v = Arrays.copyOf(arr_v, arr_v.length + 0x20);
                    this.a = arr_v;
                }
                arr_v[v1] = v;
                this.b = v1 + 1;
                this.a();
                return;
            }
            if(arr_v[v2] == v) {
                break;
            }
        }
    }
}

