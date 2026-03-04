package android.ext;

import android.app.AlertDialog;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnShowListener;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.fix.i;
import android.fix.j;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;

class id implements DialogInterface.OnClickListener, DialogInterface.OnShowListener, View.OnClickListener, View.OnLongClickListener {
    final ic a;
    private View b;
    private EditText c;
    private CheckBox d;
    private EditText e;
    private CheckBox f;
    private EditText g;
    private CheckBox h;
    private EditText i;
    private CheckBox j;
    private EditText k;
    private CheckBox l;
    private SystemSpinner m;
    private CheckBox n;
    private SystemSpinner o;
    private EditText p;
    private CheckBox q;
    private SystemSpinner r;
    private final int[] s;
    private final CheckBox[] t;
    private SharedPreferences u;
    private AlertDialog v;

    private id(ic ic0) {
        this.a = ic0;
        super();
        this.s = new int[]{1, 2, 4, 8, 16, 0x20, 0x40};
        this.t = new CheckBox[this.s.length];
    }

    id(ic ic0, id id0) {
        this(ic0);
    }

    private void a() {
        if(this.b != null) {
            return;
        }
        this.b = i.a(0x7F04001F, null);  // layout:service_filter_search
        this.u = Tools.s();
        this.c = (EditText)this.b.findViewById(0x7F0B010B);  // id:eMaxShow
        this.d = (CheckBox)this.b.findViewById(0x7F0B010C);  // id:cAddrGreat
        this.e = (EditText)this.b.findViewById(0x7F0B010D);  // id:eAddrGreat
        this.f = (CheckBox)this.b.findViewById(0x7F0B010E);  // id:cAddrLess
        this.g = (EditText)this.b.findViewById(0x7F0B010F);  // id:eAddrLess
        this.h = (CheckBox)this.b.findViewById(0x7F0B0110);  // id:cValGreat
        this.i = (EditText)this.b.findViewById(0x7F0B0111);  // id:eValGreat
        this.j = (CheckBox)this.b.findViewById(0x7F0B0112);  // id:cValLess
        this.k = (EditText)this.b.findViewById(0x7F0B0113);  // id:eValLess
        this.l = (CheckBox)this.b.findViewById(0x7F0B0114);  // id:cType
        this.m = (SystemSpinner)this.b.findViewById(0x7F0B0115);  // id:sType
        this.n = (CheckBox)this.b.findViewById(0x7F0B0116);  // id:cFractional
        this.o = (SystemSpinner)this.b.findViewById(0x7F0B0117);  // id:sFractional
        this.p = (EditText)this.b.findViewById(0x7F0B0118);  // id:eFractional
        this.q = (CheckBox)this.b.findViewById(0x7F0B0119);  // id:cPointer
        this.r = (SystemSpinner)this.b.findViewById(0x7F0B011A);  // id:sPointer
        CharSequence[] arr_charSequence = ow.i();
        int[] arr_v = ow.h();
        for(int v = 0; v < this.s.length; ++v) {
            CheckBox checkBox0 = (CheckBox)this.b.findViewById(new int[]{0x7F0B006B, 0x7F0B006C, 0x7F0B006D, 0x7F0B006E, 0x7F0B006F, 0x7F0B0070, 0x7F0B0071}[v]);  // id:value_hex
            checkBox0.setTextColor(arr_v[v]);
            checkBox0.setText(arr_charSequence[v]);
            checkBox0.setChecked((AddressArrayAdapter.a & this.s[v]) != 0);
            checkBox0.setId(-1);
            this.t[v] = checkBox0;
        }
        this.d.setText(Tools.c(0x7F07008E) + " ≥");  // string:address "Address:"
        this.f.setText(Tools.c(0x7F07008E) + " ≤");  // string:address "Address:"
        this.h.setText(Tools.c(0x7F070086) + " ≥");  // string:number "Number:"
        this.j.setText(Tools.c(0x7F070086) + " ≤");  // string:number "Number:"
        this.m.setData(d.c(-1));
        Tools.j(this.n);
        this.n.setOnLongClickListener(this);
        this.o.setData(d.c());
        j j0 = new j();
        j0.put(4, Tools.a(("-: " + qk.a(0x7F07009C)), Tools.e(0x7F0A000C)));  // string:no "No"
        j0.put(8, Tools.a(("R: " + qk.a(0x7F070243)), Tools.e(0x7F0A0010)));  // string:read_only "read-only"
        j0.put(16, Tools.a(("W: " + qk.a(0x7F070242)), Tools.e(0x7F0A000F)));  // string:writable "writable"
        j0.put(2, Tools.a(("X: " + qk.a(0x7F070241)), Tools.e(0x7F0A000E)));  // string:executable "executable"
        j0.put(1, Tools.a(("WX: " + qk.a(0x7F070244)), Tools.e(0x7F0A000D)));  // string:writable_and_executable "writable and executable"
        this.r.setData(j0);
        this.a(null, this.b);
        this.a(this.e, this.d);
        this.a(this.g, this.f);
        this.a(this.i, this.h);
        this.a(this.k, this.j);
        this.a(this.m, this.l);
        this.a(this.o, this.n);
        this.a(this.p, this.n);
        this.a(this.r, this.q);
    }

    private void a(qw qw0, View view0) {
        int v = 0;
        if(view0 != null) {
            if(view0 instanceof ViewGroup) {
                ViewGroup viewGroup0 = (ViewGroup)view0;
                int v1 = viewGroup0.getChildCount();
                while(v < v1) {
                    try {
                        View view1 = viewGroup0.getChildAt(v);
                        if(view1 != null) {
                            this.a(qw0, view1);
                        }
                        ++v;
                        continue;
                    }
                    catch(ArrayIndexOutOfBoundsException unused_ex) {
                    }
                    ++v;
                }
            }
            else {
                int v2 = view0.getId();
                if(v2 != -1) {
                    if(view0 instanceof EditText) {
                        if(qw0 == null) {
                            ((EditText)view0).setText(this.u.getString(qk.b(v2), (v2 == 0x7F0B010B ? "100" : "")));  // id:eMaxShow
                            ((EditText)view0).setDataType(1);
                            return;
                        }
                        String s = ((EditText)view0).getText().toString().trim();
                        iw.a(s, 1);
                        qw0.a(qk.b(v2), s, "");
                        return;
                    }
                    if(view0 instanceof SystemSpinner) {
                        if(v2 == 0x7F0B0117) {  // id:sFractional
                            v = 0x20000000;
                        }
                        if(qw0 == null) {
                            ((SystemSpinner)view0).setSelected(this.u.getInt(qk.b(v2), v));
                            return;
                        }
                        qw0.a(qk.b(v2), ((SystemSpinner)view0).getSelected(), v);
                        return;
                    }
                    if(view0 instanceof CheckBox) {
                        if(qw0 == null) {
                            ((CheckBox)view0).setChecked(ic.a.get(v2, false));
                            return;
                        }
                        boolean z = ((CheckBox)view0).isChecked();
                        ic.a.put(v2, z);
                    }
                }
            }
        }
    }

    private void a(View view0, CheckBox checkBox0) {
        if(view0 instanceof EditText) {
            ((EditText)view0).addTextChangedListener(new ie(this, checkBox0));
            return;
        }
        if(view0 instanceof SystemSpinner) {
            ((SystemSpinner)view0).setOnItemSelectedListener(new if(this, checkBox0));
        }
    }

    @Override  // android.content.DialogInterface$OnClickListener
    public void onClick(DialogInterface dialogInterface0, int v) {
        this.onClick(((AlertDialog)dialogInterface0).getButton(v));
    }

    @Override  // android.view.View$OnClickListener
    public void onClick(View view0) {
        if(view0 == null || view0.getTag() instanceof pj) {
            this.a();
            AlertDialog alertDialog0 = android.ext.i.c().setView(InternalKeyboard.a(Tools.d(this.b))).setPositiveButton(qk.a(0x7F0700AD), this).setNeutralButton(qk.a(0x7F07023E), this).setNegativeButton(qk.a(0x7F0700A1), null).create();  // string:apply "Apply"
            this.v = alertDialog0;
            android.ext.i.a(alertDialog0, this);
            android.ext.i.a(alertDialog0, this.c);
            return;
        }
        if(view0.getTag() instanceof Boolean) {
            this.d.setChecked(false);
            this.f.setChecked(false);
            this.h.setChecked(false);
            this.j.setChecked(false);
            this.l.setChecked(false);
            this.n.setChecked(false);
            this.q.setChecked(false);
            for(int v = 0; v < this.s.length; ++v) {
                this.t[v].setChecked(false);
            }
        }
        try {
            int v1 = ek.a(this.c.getText().toString().trim());
            if(v1 < 1) {
                throw new NumberFormatException(Tools.a(qk.a(0x7F0700D1), new Object[]{qk.a(0x7F070092), 1}));  // string:number_less "Number \'__s__\' is less than minimum value (__d__) for this 
                                                                                                                // type."
            }
            if(v1 > 100000) {
                throw new NumberFormatException(Tools.a(qk.a(0x7F0700D2), new Object[]{qk.a(0x7F070092), 100000}));  // string:number_greater "Number \'__s__\' is greater than maximum value (__d__) for 
                                                                                                                     // this type."
            }
            ek.a((this.d.isChecked() ? this.e.getText().toString() : null), (this.f.isChecked() ? this.g.getText().toString() : null), (this.h.isChecked() ? this.i.getText().toString() : null), (this.j.isChecked() ? this.k.getText().toString() : null), (this.l.isChecked() ? this.m.getSelected() : 0), (this.n.isChecked() ? (this.o.getSelected() == 0x10000000 ? "!" : "") + this.p.getText().toString() : null), (this.q.isChecked() ? this.r.getSelected() : 0));
            ek.a(v1);
            int v3 = 0;
            for(int v2 = 0; true; ++v2) {
                if(v2 >= this.s.length) {
                    AddressArrayAdapter.a(v3);
                    qw qw0 = new qw(this.u.edit());
                    this.a(qw0, this.b);
                    qw0.commit();
                    Tools.a(this.v);
                    MainService.instance.j(false);
                    return;
                }
                if(this.t[v2].isChecked()) {
                    v3 |= this.s[v2];
                }
            }
        }
        catch(NumberFormatException numberFormatException0) {
            la.b("Error", numberFormatException0);
            android.ext.i.a(android.ext.i.c().setCustomTitle(Tools.d(0x7F0700AE)).setMessage(numberFormatException0.getMessage()).setPositiveButton(qk.a(0x7F07009D), null));  // string:error "Error"
        }
    }

    @Override  // android.view.View$OnLongClickListener
    public boolean onLongClick(View view0) {
        if(view0 != null && view0.getId() == 0x7F0B0116) {  // id:cFractional
            android.ext.i.a(android.ext.i.c().setMessage(qk.a(0x7F07004D)).setNegativeButton(qk.a(0x7F07009D), null));  // string:fractional_hint_ "__fractional_hint__\nx = 123__decimal__456; {x} = 0__decimal__456\nx 
                                                                                                                        // = -123__decimal__456; {x} = -0__decimal__456"
            return true;
        }
        return false;
    }

    @Override  // android.content.DialogInterface$OnShowListener
    public void onShow(DialogInterface dialogInterface0) {
        Tools.a(dialogInterface0, -1, null, this, this.c);
        Tools.a(dialogInterface0, -3, Boolean.TRUE, this);
    }
}

