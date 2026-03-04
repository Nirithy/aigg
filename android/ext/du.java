package android.ext;

import android.app.AlertDialog;
import android.view.View.OnClickListener;
import android.view.View;
import android.widget.CheckBox;

class du implements View.OnClickListener {
    private final EditTextPath a;
    private final CheckBox b;
    private final AlertDialog c;

    du(EditTextPath editTextPath0, CheckBox checkBox0, AlertDialog alertDialog0) {
        this.a = editTextPath0;
        this.b = checkBox0;
        this.c = alertDialog0;
        super();
    }

    void a() {
        rx.a(new dx(this, this.c));
    }

    void a(String s) {
        rx.a(new dy(this, this.c));
        Tools.b((s + "\n\n" + ""), 0);
    }

    void a(String s, boolean z) {
        la.a(("su path: " + s + "; sh: " + z));
        new qw().a("su", s, "").a("sh", z, false).commit();
        if(s.length() != 0) {
            iw.a(s, 4);
        }
        Tools.a(this.c);
        ConfigListAdapter.c();
    }

    @Override  // android.view.View$OnClickListener
    public void onClick(View view0) {
        String s = this.a.getText().toString().trim();
        if(s.length() > 0) {
            new hx(new dv(this, s, this.b), "CheckSu: " + s).start();
            return;
        }
        this.a(s, this.b.isChecked());
    }
}

