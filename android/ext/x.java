package android.ext;

import android.app.AlertDialog;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnShowListener;
import android.content.DialogInterface;
import android.fix.i;
import android.view.View.OnClickListener;
import android.view.View;
import android.widget.CheckBox;

class x implements DialogInterface.OnClickListener, DialogInterface.OnShowListener, View.OnClickListener {
    private CheckBox a;
    private CheckBox b;
    private CheckBox c;
    private EditText d;
    private AlertDialog e;

    private x() {
        this.a = null;
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = null;
    }

    x(x x0) {
    }

    public void a(String s) {
        View view0 = i.a(0x7F040000, null);  // layout:alloc
        EditText editText0 = (EditText)view0.findViewById(0x7F0B0003);  // id:memory_from
        this.d = editText0;
        view0.findViewById(0x7F0B0004).setTag(editText0);  // id:region_from
        if(s != null) {
            editText0.setText(s);
        }
        editText0.setDataType(1);
        this.a = (CheckBox)view0.findViewById(0x7F0B0000);  // id:read
        this.b = (CheckBox)view0.findViewById(0x7F0B0001);  // id:write
        this.c = (CheckBox)view0.findViewById(0x7F0B0002);  // id:exec
        AlertDialog alertDialog0 = android.ext.i.c().setCustomTitle(Tools.d(0x7F0702DD)).setView(InternalKeyboard.a(view0)).setPositiveButton(qk.a(0x7F07009D), this).setNegativeButton(qk.a(0x7F0700A1), null).create();  // string:allocate_page "Allocate memory page"
        this.e = alertDialog0;
        android.ext.i.a(alertDialog0, this);
        android.ext.i.a(alertDialog0, editText0);
    }

    @Override  // android.content.DialogInterface$OnClickListener
    public void onClick(DialogInterface dialogInterface0, int v) {
        long v1;
        EditText editText0 = this.d;
        if(editText0 == null) {
            return;
        }
        else {
            try {
                String s = re.c(editText0.getText().toString().trim());
                if(s.endsWith("h")) {
                    s = s.substring(0, s.length() - 1);
                }
                if(s.length() == 0) {
                    s = "0";
                }
                try {
                    v1 = ps.a(s, 16);
                    if(v1 != 0L) {
                        iw.a(s, 1);
                    }
                }
                catch(NumberFormatException numberFormatException1) {
                    editText0.requestFocus();
                    throw numberFormatException1;
                }
                int v2 = this.a.isChecked() ? 2 : 0;
                if(this.b.isChecked()) {
                    v2 |= 1;
                }
                if(this.c.isChecked()) {
                    v2 |= 4;
                }
                la.a(("Allocate: " + v2 + "; " + v1));
                Tools.a(this.e);
                MainService.instance.k.b(v1, v2);
                qm qm0 = MainService.instance.h;
                if(qm0 != null) {
                    qm0.write("gg.allocatePage(");
                    Script.Consts.a(qm0, qm0.a.g, v2);
                    qm0.write(", ");
                    Script.Consts.a(qm0, v1);
                    qm0.write(")\n");
                    return;
                }
                return;
            }
            catch(NumberFormatException numberFormatException0) {
            }
        }
        re.a(numberFormatException0, editText0);
    }

    @Override  // android.view.View$OnClickListener
    public void onClick(View view0) {
        if(view0 == null || view0.getTag() instanceof pj) {
            this.a(null);
            return;
        }
        this.onClick(null, -1);
    }

    @Override  // android.content.DialogInterface$OnShowListener
    public void onShow(DialogInterface dialogInterface0) {
        Tools.a(this.e, -1, null, this);
    }
}

