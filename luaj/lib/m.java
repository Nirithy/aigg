package luaj.lib;

import android.ext.MainService;
import android.ext.qh;
import java.nio.ByteBuffer;

final class m {
    final byte a;
    boolean b;
    int c;
    final String d;
    int e;
    char f;
    int g;
    int h;
    int i;
    final byte[] j;
    final ByteBuffer k;

    public m(String s) {
        byte b = 8;
        super();
        this.b = true;
        this.c = 1;
        this.e = 0;
        this.f = '\u0000';
        this.g = 0;
        this.h = 0;
        this.i = 0;
        this.j = new byte[8];
        this.k = ByteBuffer.wrap(this.j);
        this.d = s;
        qh qh0 = MainService.instance.ap;
        if(qh0 == null || !qh0.n) {
            b = 4;
        }
        this.a = b;
    }

    @Override
    public String toString() {
        return "PackState [size_t=" + ((int)this.a) + ", islittle=" + this.b + ", maxalign=" + this.c + ", fmt=" + this.d + ", pos=" + this.e + ", last=" + this.f + ", align=" + this.g + ", ntoalign=" + this.h + ", size=" + this.i + "]";
    }
}

