package android.lang;

import java.util.concurrent.ThreadFactory;

class u implements ThreadFactory {
    private static final ThreadGroup a;

    static {
        u.a = u.a();
    }

    private u() {
    }

    u(u u0) {
    }

    private static ThreadGroup a() {
        return (ThreadGroup)UNIXProcess.a(new v());
    }

    @Override
    public Thread newThread(Runnable runnable0) {
        Thread thread0 = new Thread(u.a, runnable0, "process reaper", 0x8000L);
        thread0.setDaemon(true);
        thread0.setPriority(10);
        return thread0;
    }
}

