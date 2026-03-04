package android.ext;

import java.util.concurrent.Callable;

class un implements Callable {
    private final String a;

    un(String s) {
        this.a = s;
        super();
    }

    public Boolean a() {
        return Boolean.valueOf(uk.b(this.a.getBytes()));
    }

    @Override
    public Object call() {
        return this.a();
    }
}

