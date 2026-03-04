package android.ext;

import android.app.AlertDialog;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnShowListener;
import android.content.DialogInterface;
import android.fix.i;
import android.view.View.OnClickListener;
import android.view.View;

class en implements DialogInterface.OnClickListener, DialogInterface.OnShowListener, View.OnClickListener {
    private EditText a;
    private AlertDialog b;
    private EditText c;
    private EditText d;
    private long e;
    private long f;
    private int g;

    private en() {
        this.e = 0L;
        this.f = 0L;
        this.g = 0;
    }

    en(en en0) {
    }

    private long a(int v) {
        long v1 = MemoryRange.a(v, this.c, "0", this.d, "0");
        if(v == 0) {
            this.e = v1;
            return v1;
        }
        this.f = v1;
        return v1;
    }

    @Override  // android.content.DialogInterface$OnClickListener
    public void onClick(DialogInterface dialogInterface0, int v) {
        EditText editText0 = this.a;
        if(editText0 == null) {
            return;
        }
        else {
            try {
                this.a(0);
                this.a(1);
                String s = re.c(editText0.getText().toString().trim());
                if(s.length() == 0) {
                    s = "0";
                }
                try {
                    this.g = (int)ps.i(s).a;
                    if(this.g != 0) {
                        iw.a(s, 1);
                    }
                }
                catch(NumberFormatException numberFormatException1) {
                    editText0.requestFocus();
                    throw numberFormatException1;
                }
                la.a(("Copy: " + this.g + "; " + Long.toHexString(this.e) + '-' + Long.toHexString(this.f)));
                Tools.a(this.b);
                MainService.instance.k.a(this.e, this.f, this.g);
                qm qm0 = MainService.instance.h;
                if(qm0 != null) {
                    qm0.write("gg.copyMemory(");
                    Script.Consts.a(qm0, this.e);
                    qm0.write(", ");
                    Script.Consts.a(qm0, this.f);
                    qm0.write(", ");
                    qm0.write(Integer.toString(this.g));
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
            View view1 = i.a(0x7F04000B, null);  // layout:memory_copy
            EditText editText0 = (EditText)view1.findViewById(0x7F0B003F);  // id:count_bytes
            this.a = editText0;
            view1.findViewById(0x7F0B0040).setTag(editText0);  // id:bytes_converter
            editText0.setText(gv.a(this.g, 4));
            editText0.setDataType(1);
            EditText editText1 = (EditText)view1.findViewById(0x7F0B0003);  // id:memory_from
            this.c = editText1;
            view1.findViewById(0x7F0B0004).setTag(editText1);  // id:region_from
            EditText editText2 = (EditText)view1.findViewById(0x7F0B003D);  // id:memory_dst
            this.d = editText2;
            view1.findViewById(0x7F0B003E).setTag(editText2);  // id:region_dst
            editText1.setText(d.b(this.e, 4));
            editText1.setDataType(1);
            editText2.setText(d.b(this.f, 4));
            editText2.setDataType(1);
            AlertDialog alertDialog0 = android.ext.i.c().setCustomTitle(Tools.d(0x7F0701B1)).setView(InternalKeyboard.a(view1)).setPositiveButton(qk.a(0x7F07009D), this).setNegativeButton(qk.a(0x7F0700A1), null).create();  // string:copy_memory "Copy memory"
            this.b = alertDialog0;
            android.ext.i.a(alertDialog0, this);
            android.ext.i.a(alertDialog0, editText0);
            return;
        }
        this.onClick(null, -1);
    }

    @Override  // android.content.DialogInterface$OnShowListener
    public void onShow(DialogInterface dialogInterface0) {
        Tools.a(dialogInterface0, -1, null, this);
    }
}

