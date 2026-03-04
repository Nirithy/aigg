package android.lang;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;

class t extends BufferedOutputStream {
    t(int v) {
        super(UNIXProcess.f(v));
    }

    void a() {
        synchronized(this) {
            OutputStream outputStream0 = this.out;
            if(outputStream0 != null) {
                try {
                    outputStream0.close();
                }
                catch(IOException unused_ex) {
                }
                this.out = r.a;
            }
        }
    }
}

