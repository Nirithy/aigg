package android.ext;

import java.nio.ByteBuffer;

class kh {
    short a;
    short b;
    int c;

    kh(ByteBuffer byteBuffer0) {
        byteBuffer0.position(0);
        this.a = byteBuffer0.getShort();
        this.b = byteBuffer0.getShort();
        this.c = byteBuffer0.getInt();
    }
}

