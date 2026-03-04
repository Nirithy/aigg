package android.lang;

import java.security.PrivilegedAction;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

class n implements PrivilegedAction {
    public Executor a() {
        return Executors.newCachedThreadPool(new u(null));
    }

    @Override
    public Object run() {
        return this.a();
    }
}

