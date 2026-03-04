package android.app;

import android.os.IBinder;

class ANRManagerProxy {
    private IBinder a;

    public ANRManagerProxy(IBinder iBinder0) {
        this.a = iBinder0;
    }

    public IBinder asBinder() {
        return this.a;
    }

    public void informMessageDump(String s) {
    }

    public void notifyLightWeightANR(int v, String s, int v1) {
    }

    public boolean notifyWNR(int v, String s) {
        return true;
    }
}

