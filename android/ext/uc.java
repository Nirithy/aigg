package android.ext;

import java.io.File;
import java.io.FileInputStream;

class uc extends FileInputStream {
    private final String a;

    uc(String s, String s1) {
        this.a = s1;
        super(s);
    }

    @Override
    public void close() {
        super.close();
        new File(this.a).delete();
    }

    @Override
    protected void finalize() {
        super.finalize();
        new File(this.a).delete();
    }
}

