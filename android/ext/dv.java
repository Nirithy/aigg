package android.ext;

import android.widget.CheckBox;

class dv implements Runnable {
    final du a;
    private final String b;
    private final CheckBox c;

    dv(du du0, String s, CheckBox checkBox0) {
        this.a = du0;
        this.b = s;
        this.c = checkBox0;
        super();
    }

    @Override
    public void run() {
        this.a.a();
        try {
            String s = qt.a("exec id", 10, this.b);
            if(s.contains("uid=0")) {
                rx.a(new dw(this, this.b, this.c));
            }
            else {
                this.a.a(s);
            }
        }
        catch(Throwable throwable0) {
            this.a.a(throwable0.getMessage());
        }
        qt.a = "";
    }
}

