package android.ext;

import android.app.AlertDialog.Builder;
import android.app.AlertDialog;
import android.content.DialogInterface.OnClickListener;
import android.fix.ScrollView;
import android.fix.i;
import android.text.SpannableString;
import android.text.style.BackgroundColorSpan;
import android.view.View;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.TextView;

class sy implements Runnable {
    private final String a;
    private final int b;
    private final String c;
    private final DialogInterface.OnClickListener d;

    sy(String s, int v, String s1, DialogInterface.OnClickListener dialogInterface$OnClickListener0) {
        this.a = s;
        this.b = v;
        this.c = s1;
        this.d = dialogInterface$OnClickListener0;
        super();
    }

    @Override
    public void run() {
        View view0 = i.a(0x7F040008, null);  // layout:logcat
        TextView textView0 = (TextView)view0.findViewById(0x7F0B002F);  // id:logcat_text
        textView0.setText(this.a);
        if((this.b & 4) != 0) {
            int v = this.a.indexOf(0x2063);
            if(v >= 0) {
                SpannableString spannableString0 = new SpannableString(this.a);
                spannableString0.setSpan(new BackgroundColorSpan(0xFF880000), v, v + 4, 33);
                textView0.setText(spannableString0);
            }
        }
        ScrollView scrollView0 = (ScrollView)view0.findViewById(0x7F0B002E);  // id:logcat_page
        scrollView0.setFastScrollEnabled(true);
        AlertDialog.Builder alertDialog$Builder0 = android.ext.i.c().setPositiveButton(qk.a(0x7F07009D), null).setView(view0);  // string:ok "OK"
        if((this.b & 2) == 0) {
            alertDialog$Builder0.setNegativeButton(0x7F070161, new sz(this, textView0));  // string:copy "Copy"
        }
        if(this.c != null) {
            alertDialog$Builder0.setNeutralButton(this.c, this.d);
        }
        AlertDialog alertDialog0 = alertDialog$Builder0.create();
        if((this.b & 1) != 0) {
            android.ext.i.a(alertDialog0, new ta(this, scrollView0));
        }
        android.ext.i.c(alertDialog0);
        Window window0 = alertDialog0.getWindow();
        WindowManager.LayoutParams windowManager$LayoutParams0 = window0.getAttributes();
        windowManager$LayoutParams0.width = -1;
        window0.setAttributes(windowManager$LayoutParams0);
    }
}

