package android.ext;

import java.util.concurrent.Callable;

class ss implements Callable {
    private final Process a;

    ss(Process process0) {
        this.a = process0;
        super();
    }

    public Boolean a() {
        this.a.waitFor();
        return true;
    }

    @Override
    public Object call() {
        return this.a();
    }
}

