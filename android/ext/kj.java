package android.ext;

import java.util.zip.ZipEntry;

public class kj {
    public ZipEntry a;
    public String b;
    public String c;

    public kj(ZipEntry zipEntry0, String s) {
        this.a = zipEntry0;
        this.b = s;
    }

    @Override
    public String toString() {
        return "Item [entry=" + this.a + ", extractHash=" + this.b + ", putHash=" + this.c + ']';
    }
}

