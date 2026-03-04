package android.ext;

import java.io.File;

class hr implements Runnable {
    private final File a;

    hr(File file0) {
        this.a = file0;
        super();
    }

    @Override
    public void run() {
        this.a.delete();
    }
}

