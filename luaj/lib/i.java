package luaj.lib;

import java.io.FileOutputStream;

class i extends FileOutputStream {
    final GgLib.saveVariable a;

    i(GgLib.saveVariable ggLib$saveVariable0, String s) {
        this.a = ggLib$saveVariable0;
        super(s);
    }

    @Override
    public void write(int v) {
        this.a.a.a(1L);
        super.write(v);
    }

    @Override
    public void write(byte[] arr_b) {
        this.a.a.a(((long)arr_b.length));
        super.write(arr_b);
    }

    @Override
    public void write(byte[] arr_b, int v, int v1) {
        this.a.a.a(((long)v1));
        super.write(arr_b, v, v1);
    }
}

