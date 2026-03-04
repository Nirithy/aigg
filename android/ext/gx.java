package android.ext;

import android.app.AlertDialog;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.DialogInterface.OnShowListener;
import android.content.DialogInterface;
import android.fix.i;
import android.view.View.OnClickListener;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

class gx implements DialogInterface.OnClickListener, DialogInterface.OnDismissListener, DialogInterface.OnShowListener, View.OnClickListener {
    private EditText a;
    private AlertDialog b;
    private android.ext.EditText c;
    private android.ext.EditText d;
    private CheckBox e;
    private long f;
    private long g;

    private gx() {
        this.f = 0L;
        this.g = -1L;
    }

    gx(gx gx0) {
    }

    private long a(int v) {
        long v1 = MemoryRange.a(v, this.c, "0", this.d, "-1");
        if(v == 0) {
            this.f = v1;
            return v1;
        }
        this.g = v1;
        return v1;
    }

    private String a() {
        return Tools.r() + "/dump";
    }

    @Override  // android.content.DialogInterface$OnClickListener
    public void onClick(DialogInterface dialogInterface0, int v) {
        int v1 = 1;
        EditText editText0 = this.a;
        if(editText0 == null) {
            return;
        }
        else {
            try {
                this.a(0);
                this.a(1);
                String s = Tools.c(editText0.getText().toString().trim());
                if(Tools.o(s)) {
                    iw.a(s, 4);
                    if(!this.e.isChecked()) {
                        v1 = 0;
                    }
                    la.a(("Dump: " + s + "; " + Long.toHexString(this.f) + '-' + Long.toHexString(this.g) + "; " + Integer.toHexString(v1)));
                    Tools.a(this.b);
                    qh qh0 = MainService.instance.ap;
                    String s1 = qh0 == null ? "unknown" : qh0.c;
                    if(MainService.instance.S()) {
                        MainService.instance.k.a(this.f, this.g, v1, s, s1);
                        qm qm0 = MainService.instance.h;
                        if(qm0 != null) {
                            qm0.write("gg.dumpMemory(");
                            Script.Consts.a(qm0, this.f);
                            qm0.write(", ");
                            Script.Consts.a(qm0, this.g);
                            qm0.write(", ");
                            Script.Consts.a(qm0, s);
                            qm0.write(", ");
                            Script.Consts.a(qm0, qm0.a.i, v1);
                            qm0.write(")\n");
                            return;
                        }
                    }
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
            View view1 = i.a(0x7F040002, null);  // layout:dump
            EditTextPath editTextPath0 = (EditTextPath)view1.findViewById(0x7F0B000A);  // id:path
            this.a = editTextPath0;
            editTextPath0.setText(Tools.s().getString("dump-path", this.a()));
            editTextPath0.setDataType(4);
            editTextPath0.setPathType(0);
            view1.findViewById(0x7F0B000B).setTag(editTextPath0);  // id:path_selector
            tw.a(((Button)view1.findViewById(0x7F0B000C)), editTextPath0);  // id:typical_values
            android.ext.EditText editText0 = (android.ext.EditText)view1.findViewById(0x7F0B0003);  // id:memory_from
            this.c = editText0;
            view1.findViewById(0x7F0B0004).setTag(editText0);  // id:region_from
            android.ext.EditText editText1 = (android.ext.EditText)view1.findViewById(0x7F0B0008);  // id:memory_to
            this.d = editText1;
            view1.findViewById(0x7F0B0009).setTag(editText1);  // id:region_to
            editText0.setText(d.b(this.f, 4));
            editText0.setDataType(1);
            InternalKeyboard.a(editText0, 1);
            editText1.setText(d.b(this.g, 4));
            editText1.setDataType(1);
            this.e = (CheckBox)view1.findViewById(0x7F0B000D);  // id:skip_system_libs
            gy gy0 = new gy(this, editTextPath0);
            for(Object object0: view1.getFocusables(2)) {
                View view2 = (View)object0;
                if(view2 instanceof android.ext.EditText) {
                    Tools.a(view2, gy0);
                }
            }
            AlertDialog alertDialog0 = android.ext.i.c().setView(InternalKeyboard.a(view1)).setPositiveButton(qk.a(0x7F07008C), this).setNegativeButton(qk.a(0x7F0700A1), null).create();  // string:save "Save"
            this.b = alertDialog0;
            android.ext.i.a(alertDialog0, this);
            android.ext.i.a(alertDialog0, this);
            android.ext.i.a(alertDialog0, editTextPath0);
            return;
        }
        this.onClick(null, -1);
    }

    @Override  // android.content.DialogInterface$OnDismissListener
    public void onDismiss(DialogInterface dialogInterface0) {
        EditText editText0 = this.a;
        if(editText0 == null) {
            return;
        }
        new qw().a("dump-path", editText0.getText().toString().trim(), this.a()).commit();
    }

    @Override  // android.content.DialogInterface$OnShowListener
    public void onShow(DialogInterface dialogInterface0) {
        Tools.a(dialogInterface0, -1, null, this);
    }
}

