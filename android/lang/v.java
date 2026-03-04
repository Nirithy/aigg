package android.lang;

import java.security.PrivilegedAction;

class v implements PrivilegedAction {
    public ThreadGroup a() {
        ThreadGroup threadGroup0;
        for(threadGroup0 = Thread.currentThread().getThreadGroup(); true; threadGroup0 = threadGroup1) {
            ThreadGroup threadGroup1 = threadGroup0.getParent();
            if(threadGroup1 == null || threadGroup0 == threadGroup1) {
                break;
            }
        }
        return threadGroup0;
    }

    @Override
    public Object run() {
        return this.a();
    }
}

