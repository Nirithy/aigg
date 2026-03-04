package android.ext;

import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface;
import android.fix.i;
import android.fix.j;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.CompoundButton;
import android.widget.TextView;
import java.util.Locale;

public class Searcher implements DialogInterface.OnClickListener, TextWatcher, View.OnClickListener, View.OnFocusChangeListener, CompoundButton.OnCheckedChangeListener, Runnable {
    private final Button A;
    private final View B;
    private final Button C;
    private final Button D;
    private final View[] E;
    private final int[][] F;
    private final int G;
    private int H;
    private String I;
    private boolean J;
    private char K;
    private int L;
    public static final int[] a;
    public static volatile boolean b;
    public volatile boolean c;
    final MemoryRange d;
    final EditText e;
    private final View f;
    private final TextView g;
    private final SystemSpinner h;
    private final TextView i;
    private final EditText j;
    private final View k;
    private final View l;
    private final TextView m;
    private final View n;
    private final EditText o;
    private final TextView p;
    private final View q;
    private final EditText r;
    private final CheckBox s;
    private final View t;
    private final SystemSpinnerType u;
    private final View v;
    private final CheckBox w;
    private final CheckBox x;
    private final Button y;
    private final Button z;

    static {
        Searcher.a = new int[5];
        Searcher.b = false;
    }

    public Searcher(int v, int v1) {
        this.c = true;
        this.J = false;
        this.K = '\u0000';
        this.L = 0;
        this.H = v;
        this.G = v1;
        this.f = i.a(0x7F040025, null);  // layout:service_searcher
        this.g = (TextView)this.f.findViewById(0x7F0B000E);  // id:message
        this.h = (SystemSpinner)this.f.findViewById(0x7F0B012D);  // id:sign_spinner
        this.h.setOnItemSelectedListener(this);
        this.i = (TextView)this.f.findViewById(0x7F0B00F2);  // id:type_hint
        this.j = (EditText)this.f.findViewById(0x7F0B004D);  // id:number
        this.j.setDataType(1);
        this.k = this.f.findViewById(0x7F0B0042);  // id:number_converter
        this.l = this.f.findViewById(0x7F0B00F1);  // id:value_row
        this.n = this.f.findViewById(0x7F0B012E);  // id:edit_mask_row
        this.o = (EditText)this.f.findViewById(0x7F0B012F);  // id:edit_mask
        this.p = (TextView)this.f.findViewById(0x7F0B0130);  // id:mask_view
        rg rg0 = new rg(this);
        this.o.addTextChangedListener(rg0);
        this.q = this.f.findViewById(0x7F0B0131);  // id:offset_row
        this.r = (EditText)this.f.findViewById(0x7F0B012A);  // id:offset
        this.s = (CheckBox)this.f.findViewById(0x7F0B0066);  // id:hex
        this.t = this.f.findViewById(0x7F0B0133);  // id:type_row
        this.u = (SystemSpinnerType)this.f.findViewById(0x7F0B0067);  // id:type
        this.k.setTag(new Object[]{this.j, this.u});
        this.u.setOnItemSelectedListener(this);
        this.v = this.f.findViewById(0x7F0B0134);  // id:mode_hacking_row
        this.w = (CheckBox)this.f.findViewById(0x7F0B0135);  // id:mode_hacking
        this.w.setOnCheckedChangeListener(this);
        this.x = (CheckBox)this.f.findViewById(0x7F0B0136);  // id:ordered
        this.x.setOnCheckedChangeListener(this);
        this.y = (Button)this.f.findViewById(0x7F0B0138);  // id:hex1
        this.y.setOnClickListener(this);
        this.z = (Button)this.f.findViewById(0x7F0B0139);  // id:hex2
        this.z.setOnClickListener(this);
        this.A = (Button)this.f.findViewById(0x7F0B0137);  // id:min_group_size
        this.A.setTag(2);
        this.A.setOnClickListener(this);
        this.B = this.f.findViewById(0x7F0B013A);  // id:fuzzy_row
        this.e = (EditText)this.f.findViewById(0x7F0B0140);  // id:limit
        this.e.setDataType(1);
        this.d = (MemoryRange)this.f.findViewById(0x7F0B0141);  // id:memory_range
        this.d.a();
        this.C = (Button)this.f.findViewById(0x7F0B0019);  // id:ext_btn
        this.D = (Button)this.f.findViewById(0x7F0B0142);  // id:cancel
        for(Object object0: this.f.getFocusables(2)) {
            View view0 = (View)object0;
            if(view0 instanceof EditText) {
                Tools.a(view0, this);
            }
        }
        this.d.setType(Searcher.a[v]);
        this.d.setTypeChangeListener(this);
        this.E = new View[]{this.h, this.l, this.t, this.v, this.B, this.C, this.D, this.n, this.i, this.k, this.q};
        int[][] arr2_v = new int[5][];
        arr2_v[0] = new int[]{1, 1, 1, 1, 0, 0, 0, 0, 1, 1, 0};
        int[] arr_v = new int[11];
        arr_v[2] = 1;
        arr_v[8] = 1;
        arr_v[9] = 1;
        arr2_v[1] = arr_v;
        arr2_v[2] = new int[]{0, 1, 1, 0, 1, 1, 1, 0, 1, 1, 0};
        int[] arr_v1 = new int[11];
        arr_v1[0] = 1;
        arr_v1[1] = 1;
        arr_v1[2] = 1;
        arr_v1[7] = 1;
        arr2_v[3] = arr_v1;
        int[] arr_v2 = new int[11];
        arr_v2[1] = 1;
        arr_v2[2] = 1;
        arr_v2[10] = 1;
        arr2_v[4] = arr_v2;
        this.F = arr2_v;
        if(v < 0 || v >= this.F.length) {
            throw new IllegalArgumentException("Type must be between: 0 and " + (this.F.length - 1) + " but got: " + v);
        }
        this.e(v);
        this.I = qk.a(0x7F070027);  // string:examples_search "\n__help_exact_search_title__:\n\t-340\n\n__help_xor_search_title__:\n\t-340__mode_xor__16\n\n__help_range_search_title__: 
                                    // \n\t298__tilde__764\n\n__help_xor_search_title__ + __help_range_search_title__: 
                                    // \n\t298__tilde__764__mode_xor__32\n\n__help_group_search_title__: \n\t895__semicolon__438__semicolon__-83__colon__300\n\t895D__semicolon__438F__semicolon__-83B__colon__300\n\t800__tilde__900__semicolon__438__semicolon__-90__tilde__-60__colon__300\n\t800D__tilde__900D__semicolon__438E__semicolon__-90B__tilde__-60B__colon__300\n\t800__tilde____tilde__900__semicolon__438__semicolon__-90__tilde__-60__colon__300\n\t800D__tilde__900D__semicolon__438E__semicolon__-90B__tilde____tilde__-60B__colon__300\n\n__ordered_group_search__: 
                                    // \n\t895__semicolon__438__semicolon__-83__colon____colon__300\n\t895D__semicolon__438F__semicolon__-83B__colon____colon__300\n\t800__tilde__900__semicolon__438__semicolon__-90__tilde__-60__colon____colon__300\n\t800D__tilde__900D__semicolon__438E__semicolon__-90B__tilde__-60B__colon____colon__300\n\t800__tilde__900__semicolon__438__semicolon__-90__tilde____tilde__-60__colon____colon__300\n\t800D__tilde____tilde__900D__semicolon__438E__semicolon__-90B__tilde__-60B__colon____colon__300\n\t123__semicolon____any____semicolon__456__colon____colon__9\n\n\t\t__any__ 
                                    // = __any_value__\n\n__format_hex__: \n\tBAFE56DE__hex__\n\n__format_rhex__: \n\tDE56FEBA__rhex__\n__text_examples__\n\n__rtfm__\n 
                                    //    "
        this.m = (TextView)this.f.findViewById(0x7F0B001B);  // id:value
        if(v == 2) {
            this.m.setText(0x7F070114);  // string:difference "Difference"
            ((TextView)this.f.findViewById(0x7F0B013B)).setText(qk.a("N - __new_value__; O - __old_value__; D - __difference__;"));  // id:fuzzy_text
            Tools.j(this.m);
            this.m.setOnClickListener(this);
            this.I = qk.a(0x7F070040);  // string:diff_examples "\n123\n123__tilde__456\n123__tilde____tilde__456\n\n__rtfm__\n 
                                        //    "
            this.c(Searcher.b);
        }
        else if(v == 0) {
            Tools.j(this.m);
            this.m.setOnClickListener(this);
        }
        else if(v == 3) {
            Tools.j(this.m);
            this.m.setOnClickListener(this);
            this.m.setText(0x7F07008E);  // string:address "Address:"
            this.I = qk.a(0x7F070038);  // string:mask_examples "\n__address__ = A20\n__mask__ FFFFFFFF\n\n__address__ != B20\n__mask__ 
                                        // FF0\n\n__address__ = 0B?0\n__mask__ FFF\n\n__address__ != ??F??\n__mask__ BA0\n\n__rtfm__\n 
                                        //    "
            this.j.addTextChangedListener(rg0);
            this.c();
        }
        else if(v == 4) {
            this.m.setText(0x7F07008E);  // string:address "Address:"
            TextView textView0 = (TextView)this.f.findViewById(0x7F0B0132);  // id:offset_text
            Tools.j(textView0);
            textView0.setOnClickListener(this);
        }
        this.C.setOnClickListener(this);
        String s = Tools.g(this.m.getText().toString());
        TextView textView1 = this.m;
        if(this.h.getVisibility() != 0) {
            s = String.valueOf(s) + ':';
        }
        textView1.setText(s);
        this.q();
    }

    private void a(char c, int v) {
        if(this.L != v || this.K != c) {
            String s = this.H != 0 || c == 0 ? d.l(v) : Tools.c(0x7F07018E) + ": " + ps.c(this.j.getText().toString());  // string:examples "Examples"
            this.i.setText(s);
            this.K = c;
            this.L = v;
        }
    }

    public static void a(String s) {
        android.ext.i.a(android.ext.i.c().setMessage(qk.a(0x7F07018E) + ":\n" + s).setPositiveButton(qk.a(0x7F07012B), ConfigListAdapter.h()).setNegativeButton(qk.a(0x7F0700A1), null));  // string:examples "Examples"
    }

    public static long[] a(String s, long v) {
        long v1 = ps.a(s.replace("?", "0"), 16);
        long v2 = ps.a(Searcher.e(s), 16) & v;
        return new long[]{v1 & v2, v2};
    }

    public void a() {
        EditText editText0 = null;
        switch(this.H) {
            case 1: {
                break;
            }
            case 2: {
                if(Searcher.b) {
                    editText0 = this.j;
                }
                break;
            }
            case 3: {
                editText0 = this.c ? this.j : this.o;
                break;
            }
            case 4: {
                editText0 = this.c ? this.j : this.r;
                break;
            }
            default: {
                editText0 = this.j;
            }
        }
        if(editText0 != null) {
            editText0.requestFocus();
            Tools.a(editText0);
            return;
        }
        this.onFocusChange(this.f, false);
    }

    public void a(int v) {
        this.u.setSelected(v);
        this.r();
    }

    public void a(j j0, int v) {
        if(this.H == 0) {
            String s = qk.a(0x7F0702B8);  // string:text "Text"
            j0.put(-100, s + " UTF-8");
            j0.put(-200, s + " UTF-16LE");
            j0.put(-300, "HEX");
            j0.put(-400, "HEX + UTF-8 + UTF-16LE");
            j0.put(-500, "ARM (x32)");
            j0.put(-600, "Thumb");
            j0.put(-700, "ARM (x64)");
        }
        this.u.setData(j0);
        this.a(v);
    }

    public void a(View.OnClickListener view$OnClickListener0) {
        this.D.setOnClickListener(view$OnClickListener0);
    }

    public void a(CharSequence charSequence0) {
        this.g.setText(charSequence0);
    }

    public void a(boolean z) {
        this.s.setChecked(z);
    }

    @Override  // android.text.TextWatcher
    public void afterTextChanged(Editable editable0) {
    }

    j b(int v) {
        j j0 = d.a(v, true);
        int v1 = MainService.b();
        if(v1 == 0 || j0.get(v1) != null) {
            v = v1;
        }
        this.a(j0, v);
        return j0;
    }

    public void b(String s) {
        this.j.setText(s.trim());
    }

    public void b(boolean z) {
        this.c = z;
    }

    public long[] b() {
        return Searcher.a(this.f(), this.h());
    }

    @Override  // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence0, int v, int v1, int v2) {
    }

    private void c(boolean z) {
        int v = 0;
        Searcher.b = z;
        String s = z ? qk.a(0x7F070157) : qk.a(0x7F070156);  // string:less "Less"
        this.C.setText(s);
        this.l.setVisibility((z ? 0 : 8));
        this.t.setVisibility((z ? 0 : 8));
        View view0 = this.f.findViewById(0x7F0B013B);  // id:fuzzy_text
        if(!z) {
            v = 8;
        }
        view0.setVisibility(v);
        ((TextView)this.f.findViewById(0x7F0B013C)).setText((z ? "N = O+D" : qk.a(0x7F070093)));  // id:equal_btn
        ((TextView)this.f.findViewById(0x7F0B013D)).setText((z ? "N ≠ O+D" : qk.a(0x7F070094)));  // id:not_equal_btn
        ((TextView)this.f.findViewById(0x7F0B013E)).setText((z ? "N > O+D" : qk.a(0x7F070095)));  // id:larger_btn
        ((TextView)this.f.findViewById(0x7F0B013F)).setText((z ? "N < O+D" : qk.a(0x7F070096)));  // id:smaller_btn
    }

    void c() {
        String s;
        if(this.H == 3) {
            try {
                s = "???";
                s = Long.toHexString(this.b()[1]).toUpperCase(Locale.US);
            }
            catch(Throwable unused_ex) {
            }
            String s1 = Tools.c(0x7F070203) + ": " + s;  // string:resultant_mask "Resultant mask:"
            this.p.setText(s1);
        }
    }

    public void c(int v) {
        this.h.setSelected(v);
        if(this.k() && v != 0x20000000) {
            this.w.setChecked(false);
        }
    }

    public void c(String s) {
        this.o.setText(s.trim());
    }

    private void d(boolean z) {
        boolean z1 = true;
        if(this.H == 0) {
            String s = this.j.getText().toString();
            boolean z2 = ps.d(s);
            boolean z3 = ps.e(s) != 0;
            boolean z4 = !z2 && this.s();
            boolean z5 = ps.g(s);
            int v = !z2 || !z5 ? 0 : 1;
            if((this.x.getTag() == null ? 0 : 1) != v) {
                String s1 = v == 0 ? qk.a(0x7F07019A) : "UTF-16LE";  // string:ordered "Ordered"
                this.x.setText(s1);
                this.x.setTag((v == 0 ? null : this.x));
            }
            if((Config.B & 1) != 0) {
                boolean z6 = z5 && this.j.isFocused();
                if(this.J != z6 && (!z6 || !z)) {
                    this.J = z6;
                    InternalKeyboard.a(this.j, z6);
                }
            }
            this.a(((char)(z2 ? s.charAt(0) : 0)), this.u.getSelected());
            this.t.setVisibility((!z2 && !z3 ? 0 : 8));
            this.h.setVisibility((z2 ? 8 : 0));
            j j0 = z4 ? d.c() : d.b();
            if(this.h.getTag() != j0) {
                this.h.setTag(j0);
                int v1 = this.e();
                if(j0.get(v1) == null) {
                    v1 = 0x20000000;
                }
                this.h.setData(j0);
                this.c(v1);
            }
            this.w.setVisibility((!z2 && !z3 && !z4 ? 0 : 8));
            this.x.setVisibility((v == 0 && !z4 ? 8 : 0));
            this.A.setVisibility((!z2 && !z4 ? 8 : 0));
            this.y.setVisibility((z2 ? 0 : 8));
            this.z.setVisibility(8);
            if(z2 || z4) {
                if(this.w.isChecked()) {
                    this.w.setChecked(false);
                }
                if(z2 && this.e() != 0x20000000) {
                    this.c(0x20000000);
                }
                if(z4) {
                    String s2 = s.trim();
                    boolean z7 = s2.contains("::");
                    int v2 = this.d();
                    if(v2 == 0) {
                        v2 = 4;
                    }
                    int v3 = ra.a(s2, v2, z7);
                    this.x.setChecked(z7);
                    this.A.setTag(v3);
                    this.A.setText(String.valueOf((z7 ? "::" : ":")) + v3);
                    return;
                }
                this.x.setChecked(ps.f(s) == 39 || ps.f(s) == 58);
                int v4 = s.charAt(0);
                if(v4 != 72 && v4 != 104) {
                    z1 = false;
                }
                this.A.setText((z1 ? "HEX+U8" : "HEX"));
                this.y.setText((!z1 && v4 != 59 ? "HEX+U8" : "HEX+U16"));
                if(z1 || (v4 == 81 || v4 == 0x71)) {
                    this.z.setVisibility(0);
                }
                this.z.setText((z1 ? "HEX+U8+U16" : "HEX+U16"));
            }
        }
    }

    public int d() {
        if(this.H == 0) {
            String s = this.j.getText().toString();
            if(ps.d(s)) {
                return s.charAt(0) == 59 ? 2 : 1;
            }
            int v = ps.e(s);
            return v == 0 ? this.u.getSelected() : v;
        }
        return this.u.getSelected();
    }

    public long d(int v) {
        return this.d.a(v);
    }

    public void d(String s) {
        this.r.setText(s.trim());
    }

    private static String e(String s) {
        StringBuilder stringBuilder0 = new StringBuilder();
        for(int v = 0; v < s.length(); ++v) {
            stringBuilder0.append((s.charAt(v) == 0x3F ? "0" : "F"));
        }
        return stringBuilder0.toString();
    }

    private void e(int v) {
        for(int v1 = 0; v1 < this.F[v].length; ++v1) {
            this.E[v1].setVisibility((this.F[v][v1] == 1 ? 0 : 8));
        }
    }

    public int e() {
        return this.h.getSelected();
    }

    public String f() {
        if(this.H == 2 && !Searcher.b) {
            return "0";
        }
        String s = this.j.getText().toString().trim();
        iw.a(s, 1);
        return s;
    }

    public String g() {
        String s = this.o.getText().toString().trim();
        iw.a(s, 1);
        return s;
    }

    public long h() {
        return ps.a(this.g(), 16);
    }

    public String i() {
        String s = this.r.getText().toString().trim();
        iw.a(s, 1);
        return s;
    }

    public boolean j() {
        return this.s.isChecked();
    }

    public boolean k() {
        return this.w.isChecked();
    }

    public View l() {
        return InternalKeyboard.a(this.m());
    }

    public View m() {
        return Tools.d(this.n());
    }

    public View n() {
        return this.f;
    }

    public EditText o() {
        return this.j;
    }

    @Override  // android.widget.CompoundButton$OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton0, boolean z) {
        int v7;
        int v = 39;
        switch(compoundButton0.getId()) {
            case 0x7F0B0135: {  // id:mode_hacking
                if(z && this.e() != 0x20000000) {
                    this.c(0x20000000);
                    return;
                }
                break;
            }
            case 0x7F0B0136: {  // id:ordered
                if(this.H == 0) {
                    String s = this.j.getText().toString();
                    if(ps.d(s)) {
                        int v1 = ps.f(s);
                        if((v1 == 39 || v1 == 58) != z) {
                            if(v1 == 34 || v1 == 39) {
                                if(!z) {
                                    v = 34;
                                }
                                String s1 = String.valueOf(((char)v1));
                                Editable editable0 = this.j.getText();
                                int v2 = s.length();
                                for(int v3 = 1; v3 < v2; ++v3) {
                                    if(s.charAt(v3) == v) {
                                        editable0.replace(v3, v3 + 1, s1);
                                    }
                                }
                                return;
                            }
                            this.j.getText().replace(0, 1, String.valueOf(((char)v1)));
                            return;
                        }
                    }
                    else {
                        goto label_26;
                    }
                }
                else {
                label_26:
                    if(this.s()) {
                        String s2 = this.j.getText().toString();
                        if(s2.contains("::") != z) {
                            int v4 = s2.indexOf((z ? ":" : "::"));
                            int v5 = (z ? ":" : "::").length() + v4;
                            if(v4 == -1) {
                                int v6 = s2.length();
                                v5 = v6;
                                v7 = v6;
                            }
                            else {
                                v7 = v4;
                            }
                            this.j.getText().replace(v7, v5, (z ? "::" : ":"));
                            return;
                        }
                    }
                }
                break;
            }
        }
    }

    @Override  // android.content.DialogInterface$OnClickListener
    public void onClick(DialogInterface dialogInterface0, int v) {
        int v1 = 1;
        if(v <= -100) {
            String s = null;
            switch(v) {
                case -700: {
                    v1 = 4;
                    s = "~A8 ";
                    break;
                }
                case -600: {
                    v1 = 2;
                    s = "~T ";
                    break;
                }
                case -500: {
                    v1 = 4;
                    s = "~A ";
                    break;
                }
                case -400: {
                    s = "Q";
                    break;
                }
                case -300: {
                    s = "h";
                    break;
                }
                case -200: {
                    v1 = 2;
                    s = ";";
                    break;
                }
                case -100: {
                    s = ":";
                    break;
                }
                default: {
                    v1 = 0;
                }
            }
            if(s != null) {
                this.j.getText().insert(0, s);
                this.a(v1);
            }
        }
        this.r();
        if(this.k() && this.e() != 0x20000000) {
            this.w.setChecked(false);
        }
    }

    @Override  // android.view.View$OnClickListener
    public void onClick(View view0) {
        Editable editable0;
        int v = 39;
        boolean z = false;
        if(view0 != null) {
            switch(view0.getId()) {
                case 0x7F0B0019: {  // id:ext_btn
                    if(this.H == 2) {
                        this.c(!Searcher.b);
                    }
                    if(this.j.getVisibility() == 0 && this.l.getVisibility() == 0) {
                        this.j.requestFocus();
                        return;
                    }
                    break;
                }
                case 0x7F0B001B: {  // id:value
                    Searcher.a(this.I);
                    return;
                }
                case 0x7F0B0132: {  // id:offset_text
                    android.ext.i.a(android.ext.i.c().setMessage(qk.a(0x7F07025C)).setNegativeButton(qk.a(0x7F07009D), null));  // string:offset_help "The maximum limit for a possible offset."
                    return;
                }
                case 0x7F0B0137:   // id:min_group_size
                case 0x7F0B0138:   // id:hex1
                case 0x7F0B0139: {  // id:hex2
                    if(this.s()) {
                        Object object0 = view0.getTag();
                        if(object0 instanceof Integer) {
                            int v1 = (int)(((Integer)object0));
                            String s = this.j.getText().toString();
                            String s1 = s.contains("::") ? "::" : ":";
                            int v2 = s.indexOf(s1);
                            int v3 = s.length();
                            if(v2 == -1) {
                                v2 = v3;
                            }
                            this.j.getText().replace(v2, v3, String.valueOf(s1) + v1);
                            return;
                        }
                    }
                    else {
                        editable0 = this.j.getText();
                        try {
                            if(editable0.length() > 0) {
                                int v4 = view0.getId();
                                int v5 = editable0.charAt(0);
                                boolean z1 = v5 == 72 || v5 == 104;
                                if(v4 == 0x7F0B0137 && !z1) {  // id:min_group_size
                                    ps.a(editable0);
                                    editable0.replace(0, 1, "h");
                                    return;
                                }
                                if(v4 == 0x7F0B0138 && v5 == 58) {  // id:hex1
                                    editable0.replace(0, editable0.length(), "Q \'" + editable0.toString().substring(1).replace("\'", "\' 27 \'") + '\'');
                                    return;
                                }
                                if(v4 == 0x7F0B0138 && v5 == 59) {  // id:hex1
                                    editable0.replace(0, editable0.length(), "Q \"" + editable0.toString().substring(1).replace("\"", "\" 22 \"") + '\"');
                                    return;
                                }
                                if(z1) {
                                    byte[] arr_b = ps.a(editable0.toString());
                                    if(v4 == 0x7F0B0138 || v4 == 0x7F0B0139) {  // id:hex1
                                        z = true;
                                    }
                                    iu.a(null, 0, arr_b, arr_b.length, v4 == 0x7F0B0137 || v4 == 0x7F0B0139, z, editable0);  // id:min_group_size
                                    editable0.replace(0, 1, "Q");
                                    return;
                                }
                                if(v4 == 0x7F0B0138) {  // id:hex1
                                    v = 34;
                                }
                                int v7 = 0;
                                for(int v6 = 1; v6 < editable0.length(); ++v6) {
                                    if(editable0.charAt(v6) == v) {
                                        if(v7 == 0) {
                                            v7 = v6 + 1;
                                        }
                                        else {
                                            byte[] arr_b1 = editable0.toString().substring(v7, v6).getBytes(ps.a(v == 34));
                                            String s2 = InOut.b(arr_b1, 0, arr_b1.length).trim();
                                            editable0.replace(v7 - 1, v6 + 1, s2);
                                            v6 = v7 + s2.length() - 2;
                                            v7 = 0;
                                        }
                                    }
                                }
                            }
                        }
                        catch(Throwable throwable0) {
                            la.a(("Failed convert \'" + editable0 + "\'"), throwable0);
                        }
                        return;
                    }
                    break;
                }
            }
        }
    }

    @Override  // android.view.View$OnFocusChangeListener
    public void onFocusChange(View view0, boolean z) {
        if((Config.B & 1) != 0) {
            InternalKeyboard internalKeyboard0 = (InternalKeyboard)view0.getRootView().findViewById(0x7F0B002A);  // id:keyboard
            if(internalKeyboard0 != null) {
                if(this.H == 0 && ps.g(this.j.getText().toString())) {
                    boolean z1 = this.j.isFocused();
                    InternalKeyboard.a(this.j, z1);
                    return;
                }
                internalKeyboard0.setHideKeyboard(false);
                Tools.e(view0);
            }
        }
    }

    @Override  // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence0, int v, int v1, int v2) {
        this.d(v == 0 && v1 == 1 && v2 == 0);
    }

    public long p() {
        String s = this.e.getText().toString().trim();
        if(s.length() > 0) {
            String s1 = re.c(s);
            try {
                long v = ps.a(s1, 10);
                iw.a(s1, 1);
                return v;
            }
            catch(NumberFormatException numberFormatException0) {
                this.e.requestFocus();
                throw numberFormatException0;
            }
        }
        return 0L;
    }

    private void q() {
        this.a(this.K, this.G);
        this.h.setData((this.H == 3 ? d.c() : d.b()));
        this.a(d.a(this.G, true), this.G);
        this.j.addTextChangedListener(this);
    }

    private void r() {
        this.a(this.K, this.u.getSelected());
        this.d(false);
    }

    @Override
    public void run() {
        Searcher.a[this.H] = this.d.getType();
    }

    private boolean s() {
        if(this.H != 0) {
            return false;
        }
        String s = this.j.getText().toString().trim();
        return s.length() >= 1 && s.charAt(0) != 61 && s.indexOf(59) > 0;
    }
}

