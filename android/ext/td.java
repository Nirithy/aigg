package android.ext;

import android.view.View;
import android.view.WindowManager.BadTokenException;
import android.view.WindowManager.LayoutParams;

class td implements Runnable {
    private final boolean a;
    private final WindowManager.LayoutParams b;
    private final View c;

    td(boolean z, WindowManager.LayoutParams windowManager$LayoutParams0, View view0) {
        this.a = z;
        this.b = windowManager$LayoutParams0;
        this.c = view0;
        super();
    }

    @Override
    public void run() {
        int v;
        Tools.a();
        try {
            if(this.a) {
                MainService.instance.n.addView(this.c, this.b);
            }
            else {
                MainService.instance.n.updateViewLayout(this.c, this.b);
            }
        }
        catch(WindowManager.BadTokenException windowManager$BadTokenException0) {
            String s = windowManager$BadTokenException0.getMessage();
            if(rv.a && s != null && s.contains("permission denied") && this.b.type != 0x7F6) {
                try {
                    v = this.b.type;
                    this.b.type = 0x7F6;
                    if(this.a) {
                        MainService.instance.n.addView(this.c, this.b);
                    }
                    else {
                        MainService.instance.n.updateViewLayout(this.c, this.b);
                    }
                    goto label_28;
                }
                catch(WindowManager.BadTokenException windowManager$BadTokenException1) {
                    this.b.type = v;
                    throw windowManager$BadTokenException1;
                }
            }
            throw windowManager$BadTokenException0;
        }
        catch(IllegalArgumentException illegalArgumentException0) {
            la.b("Fail", illegalArgumentException0);
        }
        catch(NullPointerException nullPointerException0) {
            la.a(nullPointerException0);
        }
        catch(Throwable throwable0) {
            la.b("Fail", throwable0);
        }
    label_28:
        if(this.a) {
            Tools.l(this.c);
        }
    }
}

