package luaj.lib;

import android.ext.la;
import java.io.InputStream;

class a extends InputStream {
    final BaseLib a;
    private int b;
    private final InputStream c;
    private final c d;

    a(BaseLib baseLib0, InputStream inputStream0, c c0) {
        this.a = baseLib0;
        this.c = inputStream0;
        this.d = c0;
        super();
        this.b = 0;
    }

    @Override
    public int read() {
        int v = this.c.read();
        try {
            if(v != -1) {
                this.d.b.write(v);
                ++this.b;
                return v;
            }
            if(this.b > 0) {
                this.d.d.writeInt(this.b);
                return -1;
            }
            return -1;
        }
        catch(Throwable throwable0) {
            la.b("Failed write log file", throwable0);
            return v;
        }
    }
}

