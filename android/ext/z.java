package android.ext;

import android.app.ActivityManager;
import android.content.pm.PackageManager;
import java.util.Iterator;
import java.util.List;

class z {
    volatile boolean a;
    volatile Runnable b;
    private qh c;
    private volatile boolean d;
    private boolean e;
    private String f;

    public z(ActivityManager activityManager0, PackageManager packageManager0) {
        this.a = false;
        this.b = null;
        this.d = false;
        this.e = false;
        this.f = null;
        new qf(activityManager0, packageManager0);
    }

    public void a() {
        this.a = false;
    }

    void a(qh qh0) {
        qh0.b();
        qh0.a();
        this.c = qh0;
        la.a(("used: " + qh0.d()));
        MainService.instance.a(qh0);
    }

    public void a(List list0) {
        boolean z;
        int v2;
        if(this.d) {
            int v = 0;
            try {
                if(list0.size() == 0) {
                    la.b("listProcesses empty");
                    if(this.e || this.c == null) {
                        Tools.a(0x7F07009E);  // string:failed_find_package_name "Failed to find the application package name!"
                    }
                }
                else {
                    if(this.c != null) {
                        for(Object object0: list0) {
                            if(((qh)object0).f == this.c.f) {
                                v = 1;
                                break;
                            }
                        }
                    }
                    if(this.f == null) {
                        v2 = v;
                    }
                    else {
                        Iterator iterator1 = list0.iterator();
                        while(true) {
                            if(!iterator1.hasNext()) {
                                v2 = v;
                                z = false;
                                break;
                            }
                            Object object1 = iterator1.next();
                            qh qh0 = (qh)object1;
                            if(qh0.c.equals(this.f)) {
                                this.a(qh0);
                                z = true;
                                v2 = 1;
                                break;
                            }
                        }
                        if(z) {
                            this.e = false;
                        }
                    }
                    if(v2 == 0) {
                        this.a(((qh)list0.get(0)));
                    }
                    if(this.e) {
                        qg qg0 = new qg(1, "stub");
                        qg0.d = qk.a(0x7F07028A);  // string:help_game_not_listed_title "Why my game is not in the process list?"
                        qg0.h = true;
                        qh qh1 = new qh(qg0, 1, 1, "stub", 0, false, 0);
                        qh1.e = Tools.b(0x7F02002F);  // drawable:ic_help_circle_outline_white_24dp
                        list0.add(qh1);
                        ab ab0 = new ab(this, MainService.context, list0, list0);
                        i.a(i.a(Tools.o()).setCustomTitle(Tools.d(0x7F070089)).setAdapter(ab0, new ac(this, list0.size(), list0)));  // string:reset "Select process"
                    }
                }
            }
            finally {
                this.d = false;
            }
        }
    }

    public void a(boolean z) {
        this.a(z, null);
    }

    public void a(boolean z, String s) {
        if(this.d) {
            if(!z || !MainService.instance.k.y()) {
                return;
            }
            Tools.a(0x7F070160, 0);  // string:data_collecting_in_progress "Data collection in progress"
            return;
        }
        this.d = true;
        this.e = z;
        this.f = s;
        if(z) {
            Tools.a(0x7F07015F, 0);  // string:start_collecting_data "Start collecting data"
        }
        z.c();
    }

    public boolean a(boolean z, Runnable runnable0) {
        this.b = null;
        if(!this.a) {
            this.a(true);
            this.b = runnable0;
            return false;
        }
        if(z) {
            this.a(false);
        }
        return true;
    }

    public boolean b() {
        return this.a;
    }

    private static void c() {
        rx.a().post(new aa());
    }
}

