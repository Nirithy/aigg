package android.ext;

import android.app.AlertDialog;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnShowListener;
import android.content.DialogInterface;
import android.fix.i;
import android.view.View.OnClickListener;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

class ug implements DialogInterface.OnClickListener, DialogInterface.OnShowListener, View.OnClickListener {
    CheckBox a;
    EditText b;
    CheckBox c;
    EditText d;
    CheckBox e;
    EditText f;
    CheckBox g;
    EditText h;
    AlertDialog i;
    final uf j;

    private ug(uf uf0) {
        this.j = uf0;
        super();
    }

    ug(uf uf0, ug ug0) {
        this(uf0);
    }

    private long a(EditText editText0, boolean z) {
        String s = re.c(editText0.getText().toString().trim());
        long v = z ? ps.i(s).a : ps.j(s).a;
        iw.a(s, 1);
        return v;
    }

    private void a(CheckBox checkBox0, CheckBox checkBox1, boolean z, EditText editText0, String s) {
        checkBox1.setChecked(z);
        checkBox1.setText(qk.a(checkBox1.getText().toString()));
        editText0.setDataType(1);
        editText0.setText(s);
        editText0.setTag(checkBox1);
        editText0.addTextChangedListener(new uh(this, checkBox1, checkBox0));
        if(checkBox0 != null) {
            checkBox0.setOnCheckedChangeListener(new ui(this, checkBox1));
            checkBox1.setOnCheckedChangeListener(new uj(this, checkBox0));
        }
    }

    @Override  // android.content.DialogInterface$OnClickListener
    public void onClick(DialogInterface dialogInterface0, int v) {
        try {
            int v1 = 0;
            boolean z = this.a.isChecked();
            boolean z1 = false;
            long v2 = 0L;
            long v3 = 0L;
            if(z) {
                v1 = 2;
                v2 = this.a(this.b, true);
                uf.b = v2;
                z1 = this.c.isChecked();
                if(z1) {
                    v3 = this.a(this.d, true);
                    uf.d = v3;
                }
            }
            uf.a = z;
            uf.c = z1;
            boolean z2 = this.e.isChecked();
            boolean z3 = false;
            double f = 0.0;
            double f1 = 0.0;
            if(z2) {
                v1 |= 4;
                f = Double.longBitsToDouble(this.a(this.f, false));
                uf.h = f;
                z3 = this.g.isChecked();
                if(z3) {
                    f1 = Double.longBitsToDouble(this.a(this.h, false));
                    uf.j = f1;
                }
            }
            uf.g = z2;
            uf.i = z3;
            uf.a(v1, v2, v3, f, f1);
            Tools.a(dialogInterface0);
            qm qm0 = MainService.instance.h;
            if(qm0 != null) {
                qm0.write("gg.unrandomizer(");
                if(z) {
                    qm0.write(Long.toString(v2));
                    qm0.write(", ");
                    qm0.write(Long.toString(v3));
                    qm0.write(", ");
                }
                else {
                    qm0.write("nil, nil, ");
                }
                if(z2) {
                    qm0.write(Double.toString(f));
                    qm0.write(", ");
                    qm0.write(Double.toString(f1));
                }
                else {
                    qm0.write("nil, nil");
                }
                qm0.write(")\n");
            }
        }
        catch(NumberFormatException numberFormatException0) {
            re.a(numberFormatException0, null);
        }
    }

    @Override  // android.view.View$OnClickListener
    public void onClick(View view0) {
        if(view0 == null || view0.getTag() instanceof pj) {
            View view1 = i.a(0x7F04002E, null);  // layout:unrand
            TextView textView0 = (TextView)view1.findViewById(0x7F0B000E);  // id:message
            Tools.j(textView0);
            textView0.setOnClickListener(this);
            this.a = (CheckBox)view1.findViewById(0x7F0B014C);  // id:rd_qword_use
            this.b = (EditText)view1.findViewById(0x7F0B014D);  // id:rd_qword
            this.c = (CheckBox)view1.findViewById(0x7F0B014E);  // id:rd_qword_inc_use
            this.d = (EditText)view1.findViewById(0x7F0B014F);  // id:rd_qword_inc
            this.a(null, this.a, uf.a, this.b, gv.a(uf.b, 0x20));
            this.a(this.a, this.c, uf.c, this.d, gv.a(uf.d, 0x20));
            this.e = (CheckBox)view1.findViewById(0x7F0B0150);  // id:rd_double_use
            this.f = (EditText)view1.findViewById(0x7F0B0151);  // id:rd_double
            this.g = (CheckBox)view1.findViewById(0x7F0B0152);  // id:rd_double_inc_use
            this.h = (EditText)view1.findViewById(0x7F0B0153);  // id:rd_double_inc
            this.a(null, this.e, uf.g, this.f, "0.0");
            this.a(this.e, this.g, uf.i, this.h, Double.toString(uf.j));
            this.i = android.ext.i.c().setView(InternalKeyboard.a(view1)).setPositiveButton(qk.a(0x7F07009D), this).setNegativeButton(qk.a(0x7F0700A1), null).create();  // string:ok "OK"
            android.ext.i.a(this.i, this);
            android.ext.i.a(this.i, this.b);
            return;
        }
        if(view0.getId() != 0x7F0B000E) {  // id:message
            this.onClick(this.i, -1);
            return;
        }
        ConfigListAdapter.b(0x7F07027D);  // string:help_unrandomizer "\nThe unrandomizer is a feature designed to replace certain 
                                          // functions commonly used in games to produce random values. At a very simple level 
                                          // then, for an example, there may be a game that uses a randomizer function to determine 
                                          // the player\'s reward. Enabling the unrandomizer would then cause __app_name__ to 
                                          // try to replace this random value with the specified value in order to change the 
                                          // result (for example, to get a certain reward).\n\nThe unrandomizer won\'t work in 
                                          // all cases. It will only handle functions that it knows about. In most cases and 
                                          // for most users, this will not be used, as it\'s more of an advanced/experimental 
                                          // feature.\n\nSome functions return __type_qword__, some - __type_double__ (rarely 
                                          // used).\n\n__type_double__ values must be in the range from 0 to 1. However, you 
                                          // can specify any values there, because __app_name__ will correct all the incorrect 
                                          // variants automatically.\n\nYou can also specify an increment step. In this case, 
                                          // each subsequent result will increase by this value. For example, for increment 1 
                                          // and the initial value 0, instead of a random value, 0, 1, 2, 3, ... will be returned.\nThis 
                                          // option can be useful for a complete search of all possible random results.\n\nYou 
                                          // can specify which functions to modify in the __app_name__ settings.\n    "
    }

    @Override  // android.content.DialogInterface$OnShowListener
    public void onShow(DialogInterface dialogInterface0) {
        Tools.a(dialogInterface0, -1, null, this);
    }
}

