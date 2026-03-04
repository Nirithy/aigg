package android.ext;

import android.app.AlertDialog;
import android.view.View.OnClickListener;
import android.view.View;

class dr implements View.OnClickListener {
    private final EditTextPath a;
    private final AlertDialog b;

    dr(EditTextPath editTextPath0, AlertDialog alertDialog0) {
        this.a = editTextPath0;
        this.b = alertDialog0;
        super();
    }

    @Override  // android.view.View$OnClickListener
    public void onClick(View view0) {
        String s = Tools.c(this.a.getText().toString().trim());
        if(s.length() > 0) {
            if(!Tools.o(s)) {
                return;
            }
            iw.a(s, 4);
        }
        la.a(("save path: " + s));
        new qw().a("temp-path", s, "").commit();
        MainService mainService0 = MainService.instance;
        mainService0.k.c(mainService0.B());
        mainService0.d(true);
        Tools.a(this.b);
    }
}

