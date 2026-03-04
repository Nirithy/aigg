package android.ext;

import android.annotation.TargetApi;
import android.os.Build.VERSION;
import java.util.ArrayList;

class st implements Runnable {
    @Override
    @TargetApi(19)
    public void run() {
        RuntimeException runtimeException0;
        int v;
        ArrayList arrayList0 = new ArrayList();
        StringBuilder stringBuilder0 = new StringBuilder();
        stringBuilder0.append("Context info. act - ");
        stringBuilder0.append("Context: null");
        stringBuilder0.append("; app - ");
        stringBuilder0.append("Context: null");
        stringBuilder0.append("; dae - ");
        stringBuilder0.append("Context: null");
        stringBuilder0.append("; bad - ");
        Throwable throwable0 = Tools.b(ar.f);
        if(throwable0 == null) {
            v = 0;
        }
        else {
            v = 1;
            arrayList0.add(throwable0);
        }
        Throwable throwable1 = Tools.b(ar.e);
        if(throwable1 != null) {
            v += 10;
            arrayList0.add(throwable1);
        }
        if(MainService.context != null) {
            Throwable throwable2 = Tools.b(MainService.context);
            if(throwable2 != null) {
                v += 100;
                arrayList0.add(throwable2);
            }
        }
        stringBuilder0.append(v);
        String s = stringBuilder0.toString();
        if(v > 0) {
            if(Build.VERSION.SDK_INT < 19) {
                for(Object object0: arrayList0) {
                    s = s + "\nSupressed: " + la.b(((Throwable)object0));
                }
                runtimeException0 = new RuntimeException(s);
            }
            else {
                RuntimeException runtimeException1 = new RuntimeException(s);
                for(Object object1: arrayList0) {
                    runtimeException1.addSuppressed(((Throwable)object1));
                }
                runtimeException0 = runtimeException1;
            }
            ho.a(Thread.currentThread(), runtimeException0, false);
        }
        la.a(s);
    }
}

