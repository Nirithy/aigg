package android.ext;

import android.text.method.LinkMovementMethod;
import android.widget.TextView;

class sn implements Runnable {
    private final TextView a;
    private final String b;

    sn(TextView textView0, String s) {
        this.a = textView0;
        this.b = s;
        super();
    }

    @Override
    public void run() {
        int v = 1;
        while(true) {
            try {
                this.a.setLinksClickable(true);
                this.a.setAutoLinkMask(1);
                this.a.setMovementMethod(LinkMovementMethod.getInstance());
                this.a.setText(this.b);
                break;
            }
            catch(Throwable throwable0) {
                la.c(("Failed set clickable text " + v), throwable0);
                ++v;
            }
        }
        DefensiveURLSpan.a(this.a);
    }
}

