package android.ext;

import android.app.AlertDialog;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.DialogInterface.OnShowListener;
import android.content.DialogInterface;
import android.fix.i;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

public class OffsetCalculator extends pj implements DialogInterface.OnClickListener, DialogInterface.OnDismissListener, DialogInterface.OnShowListener, TextWatcher, CompoundButton.OnCheckedChangeListener, Runnable {
    long a;
    private final Long b;
    private EditText c;
    private EditText d;
    private TextView g;
    private CheckBox h;
    private ImageView i;
    private TextView j;
    private TextView k;
    private TextView l;
    private TextView m;
    private TextView n;
    private TextView o;
    private TextView p;
    private TextView q;
    private TextView r;
    private TextView s;
    private TextView t;
    private static String u;
    private static String v;
    private static boolean w;

    static {
        OffsetCalculator.u = "";
        OffsetCalculator.v = "";
        OffsetCalculator.w = true;
    }

    public OffsetCalculator() {
        this(null);
    }

    public OffsetCalculator(Long long0) {
        super(0x7F07016C, 0x7F020010);  // string:offset_calculator "Offset calculator"
        this.a = 0L;
        this.c = null;
        this.d = null;
        this.g = null;
        this.h = null;
        this.i = null;
        this.b = long0;
    }

    private int a(long v, long v1, int v2, TextView textView0, int v3, int v4, int v5, boolean z) {
        String s;
        if(z || (((long)(v5 - 1)) & v) != 0L) {
            s = "-";
        }
        else {
            s = d.a(v, v1, v3);
            if(v2 == 0) {
                v2 = v4;
            }
        }
        textView0.setText(String.valueOf(s) + d.g(v3) + ';');
        return v2;
    }

    private void a() {
        SparseIntArray sparseIntArray0 = new SparseIntArray();
        new tu(d.c(d.a(this.a, false, sparseIntArray0)), sparseIntArray0, "0", qk.a(0x7F0700EF), new pq(this));  // string:type_change_request "Select the data type to change"
    }

    void a(long v, long v1, boolean z) {
        String s;
        if(this.g == null) {
            return;
        }
        int v2 = this.a(v, v1, this.a(v, v1, this.a(v, v1, this.a(v, v1, this.a(v, v1, this.a(v, v1, this.a(v, v1, 0, this.p, 0x40, 8, 4, z), this.s, 0x20, 8, 4, z), this.o, 16, 4, 4, z), this.n, 4, 4, 4, z), this.t, 8, 4, 4, z), this.q, 2, 2, 2, z), this.r, 1, 1, 1, z);
        int v3 = v2 == 0 ? 1 : v2;
        if(z) {
            s = "-h;";
        }
        else {
            if(v3 != 8) {
                v1 &= (1L << v3 * 8) - 1L;
            }
            s = ts.a(v3 * 2, v1) + "h;";
        }
        this.j.setText(s);
        String s1 = z ? "-r;" : ts.a(v3 * 2, (v3 == 8 ? Long.reverseBytes(v1) >> 0x40 - v3 * 8 : Long.reverseBytes(v1) >> 0x40 - v3 * 8 & (1L << v3 * 8) - 1L)) + "r;";
        this.k.setText(s1);
        String s2 = z ? "-;" : "\'" + ow.b(v1, v3) + "\';";
        this.l.setText(s2);
        String s3 = z ? "-;" : "\"" + ow.c(v1, v3) + "\";";
        this.m.setText(s3);
    }

    public void a(String s) {
        View view0 = i.a(0x7F040023, null);  // layout:service_offset
        this.c = (EditText)view0.findViewById(0x7F0B0049);  // id:address
        this.d = (EditText)view0.findViewById(0x7F0B012A);  // id:offset
        this.g = (TextView)view0.findViewById(0x7F0B012B);  // id:result
        this.i = Config.a(((ImageView)view0.findViewById(0x7F0B012C)));  // id:save
        this.i.setOnClickListener(this);
        this.h = (CheckBox)view0.findViewById(0x7F0B0066);  // id:hex
        this.h.setChecked(OffsetCalculator.w);
        this.h.setOnCheckedChangeListener(this);
        this.j = (TextView)view0.findViewById(0x7F0B006B);  // id:value_hex
        this.k = (TextView)view0.findViewById(0x7F0B006C);  // id:value_rhex
        this.l = (TextView)view0.findViewById(0x7F0B006D);  // id:value_string
        this.m = (TextView)view0.findViewById(0x7F0B006E);  // id:value_java
        this.n = (TextView)view0.findViewById(0x7F0B0123);  // id:value_dword
        this.o = (TextView)view0.findViewById(0x7F0B0124);  // id:value_float
        this.p = (TextView)view0.findViewById(0x7F0B0125);  // id:value_double
        this.q = (TextView)view0.findViewById(0x7F0B0126);  // id:value_word
        this.r = (TextView)view0.findViewById(0x7F0B0127);  // id:value_byte
        this.s = (TextView)view0.findViewById(0x7F0B0128);  // id:value_qword
        this.t = (TextView)view0.findViewById(0x7F0B0129);  // id:value_xor
        EditText editText0 = this.c;
        if(s == null) {
            s = "";
        }
        editText0.setText(s);
        this.c.setDataType(1);
        this.d.setText("");
        this.d.setDataType(1);
        this.c.addTextChangedListener(this);
        this.d.addTextChangedListener(this);
        this.b();
        AlertDialog alertDialog0 = android.ext.i.c().setView(InternalKeyboard.a(view0)).setPositiveButton(qk.a(0x7F07008D), this).setNegativeButton(qk.a(0x7F0700A1), null).setNeutralButton(qk.a(0x7F070161), this).create();  // string:goto1 "Goto"
        android.ext.i.a(alertDialog0, this);
        android.ext.i.a(alertDialog0, this);
        android.ext.i.a(alertDialog0, this.d);
    }

    @Override  // android.text.TextWatcher
    public void afterTextChanged(Editable editable0) {
        this.b();
    }

    private void b() {
        long v1;
        int v = 16;
        if(this.d == null || this.g == null) {
            return;
        }
        StringBuilder stringBuilder0 = new StringBuilder();
        try {
            v1 = ps.a(this.c.getText().toString().trim(), 16);
        }
        catch(Throwable throwable0) {
            la.a("Failed parse", throwable0);
            if(stringBuilder0.length() != 0) {
                stringBuilder0.append("; ");
            }
            stringBuilder0.append(qk.a(0x7F07008E));  // string:address "Address:"
            stringBuilder0.append(' ');
            stringBuilder0.append(throwable0.getMessage());
            v1 = 0L;
        }
        String s = this.d.getText().toString().trim();
        try {
            if(!this.h.isChecked()) {
                v = 10;
            }
            this.a = v1 + ps.a(s, v);
        }
        catch(Throwable throwable1) {
            la.a("Failed parse", throwable1);
            if(stringBuilder0.length() != 0) {
                stringBuilder0.append("; ");
            }
            stringBuilder0.append(qk.a(0x7F070168));  // string:offset "Offset:"
            stringBuilder0.append(' ');
            stringBuilder0.append(throwable1.getMessage());
            this.a = 0L;
        }
        if(stringBuilder0.length() == 0) {
            stringBuilder0.append(d.b(this.a, 4));
            Handler handler0 = rx.b();
            handler0.removeCallbacks(this);
            handler0.post(this);
        }
        else {
            this.a(0L, 0L, true);
        }
        this.g.setText(stringBuilder0.toString());
    }

    @Override  // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence0, int v, int v1, int v2) {
    }

    @Override  // android.widget.CompoundButton$OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton0, boolean z) {
        this.b();
    }

    @Override  // android.content.DialogInterface$OnClickListener
    public void onClick(DialogInterface dialogInterface0, int v) {
        String s = d.b(this.a, 4);
        switch(v) {
            case -3: {
                iw.a(this.d.getText().toString().trim(), 1);
                Tools.a(s);
                return;
            }
            case -1: {
                iw.a(this.d.getText().toString().trim(), 1);
                MainService mainService0 = MainService.instance;
                String s1 = Tools.c(0x7F070251) + ": (" + this.c.getText().toString().trim() + " + " + this.d.getText().toString().trim() + ')';  // string:from_calc "From the offset calculator:"
                mainService0.a(this.b, s, s1);
            }
        }
    }

    @Override  // android.ext.pj
    public void onClick(View view0) {
        if(view0 != null && view0.getId() == 0x7F0B012C) {  // id:save
            this.a();
            return;
        }
        new OffsetCalculator().a(null);
    }

    @Override  // android.content.DialogInterface$OnDismissListener
    public void onDismiss(DialogInterface dialogInterface0) {
        if(this.c != null) {
            OffsetCalculator.w = this.h.isChecked();
            OffsetCalculator.v = this.d.getText().toString().trim();
            OffsetCalculator.u = this.c.getText().toString().trim();
        }
    }

    @Override  // android.content.DialogInterface$OnShowListener
    public void onShow(DialogInterface dialogInterface0) {
        if(this.c.getText().length() > 0) {
            this.d.requestFocus();
        }
        else {
            this.c.requestFocus();
        }
        Tools.a(this.d);
        this.b();
    }

    @Override  // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence0, int v, int v1, int v2) {
        this.b();
    }

    @Override
    public void run() {
        long v;
        try {
            v = this.a;
            int v1 = d.a(v, true);
            rx.a(new pr(this, v, MainService.instance.k.a(v, v1)));
        }
        catch(Throwable throwable0) {
            la.b(("Failed update value: " + v), throwable0);
        }
    }
}

