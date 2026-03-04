package android.ext;

import android.content.ComponentName;
import android.os.Process;

class lx implements Runnable {
    final lw a;

    lx(lw lw0) {
        this.a = lw0;
        super();
    }

    @Override
    public void run() {
        boolean z1;
        try {
            boolean z = false;
            if(Config.z == 0) {
                ComponentName componentName0 = lh.m();
                if(componentName0 == null) {
                    z1 = false;
                }
                else {
                    la.a(("Try instr: " + Process.myUid()));
                    lh.a(((byte)0));
                    try {
                        z1 = ar.f.startInstrumentation(componentName0, null, ar.a());
                        lh.a(((byte)1));
                    }
                    catch(Throwable throwable0) {
                        z = true;
                        goto label_20;
                    }
                    la.a(("Fail instr: " + Process.myUid()));
                }
            }
            else {
                lh.f();
                z1 = false;
                lh.a(3, z1 + ' ' + Config.z);
                goto label_21;
            }
            lh.a(3, z1 + ' ' + Config.z);
            goto label_21;
        }
        catch(Throwable throwable0) {
        }
    label_20:
        la.c("Failed load Instrumentation", throwable0);
    label_21:
        if(z) {
            lh.a(((byte)1));
        }
        lh.a(6, null);
        lh.d();
    }
}

