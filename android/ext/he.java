package android.ext;

import android.fix.i;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

public class he implements TextWatcher, View.OnClickListener, View.OnLongClickListener {
    private final Button A;
    private final View[] B;
    private final int[][] C;
    private final d D;
    private int E;
    private String F;
    final EditText a;
    final CheckBox b;
    final CheckBox c;
    final CheckBox d;
    final View e;
    private static volatile boolean f;
    private final View g;
    private final TextView h;
    private final View i;
    private final CheckBox j;
    private final View k;
    private final TextView l;
    private final EditText m;
    private final View n;
    private final EditText o;
    private final View p;
    private final View q;
    private final View r;
    private final View s;
    private final View t;
    private final View u;
    private final View v;
    private final View w;
    private final SystemSpinner x;
    private final EditText y;
    private final EditText z;

    static {
        he.f = false;
    }

    public he(int v, d d0) {
        this.E = v;
        this.D = d0.a();
        this.g = i.a(0x7F04001E, null);  // layout:service_editor
        this.h = (TextView)this.g.findViewById(0x7F0B000E);  // id:message
        this.i = this.g.findViewById(0x7F0B0108);  // id:name_row
        this.j = (CheckBox)this.g.findViewById(0x7F0B0109);  // id:save_as
        this.k = this.g.findViewById(0x7F0B010A);  // id:name_text
        this.a = (EditText)this.g.findViewById(0x7F0B0051);  // id:name
        this.a.setDataType(3);
        this.l = (TextView)this.g.findViewById(0x7F0B00F2);  // id:type_hint
        this.m = (EditText)this.g.findViewById(0x7F0B004D);  // id:number
        this.m.setDataType(1);
        this.g.findViewById(0x7F0B0042).setTag(new Object[]{this.m, d0.d});  // id:number_converter
        this.n = this.g.findViewById(0x7F0B00F3);  // id:edit_step_row
        this.o = (EditText)this.g.findViewById(0x7F0B00F5);  // id:edit_step
        this.o.setDataType(1);
        this.g.findViewById(0x7F0B00F6).setTag(this.o);  // id:step_converter
        View view0 = this.g.findViewById(0x7F0B00F4);  // id:edit_step_label
        Tools.j(view0);
        view0.setOnClickListener(this);
        this.b = (CheckBox)this.g.findViewById(0x7F0B00F7);  // id:add_not_replace
        Tools.j(this.b);
        this.b.setOnLongClickListener(this);
        this.p = this.g.findViewById(0x7F0B00F8);  // id:fill
        this.q = this.g.findViewById(0x7F0B00F9);  // id:fill_values
        this.r = this.g.findViewById(0x7F0B00FA);  // id:fill_utf8
        this.s = this.g.findViewById(0x7F0B00FB);  // id:fill_utf16le
        this.t = this.g.findViewById(0x7F0B00FC);  // id:fill_hex
        this.u = this.g.findViewById(0x7F0B00FD);  // id:fill_hex_utf8
        this.v = this.g.findViewById(0x7F0B00FE);  // id:fill_hex_utf16le
        this.w = this.g.findViewById(0x7F0B00FF);  // id:fill_hex_utf8_utf16le
        this.c = (CheckBox)this.g.findViewById(0x7F0B00F0);  // id:change_value
        this.d = (CheckBox)this.g.findViewById(0x7F0B0101);  // id:freeze
        this.x = (SystemSpinner)this.g.findViewById(0x7F0B0102);  // id:freeze_spinner
        this.e = this.g.findViewById(0x7F0B0103);  // id:freeze_range
        this.y = (EditText)this.g.findViewById(0x7F0B0104);  // id:freeze_from
        this.y.setDataType(1);
        this.g.findViewById(0x7F0B0105).setTag(this.y);  // id:from_converter
        this.z = (EditText)this.g.findViewById(0x7F0B0106);  // id:freeze_to
        this.z.setDataType(1);
        this.g.findViewById(0x7F0B0107).setTag(this.z);  // id:to_converter
        this.A = (Button)this.g.findViewById(0x7F0B0019);  // id:ext_btn
        hf hf0 = new hf(this);
        for(Object object0: this.g.getFocusables(2)) {
            View view1 = (View)object0;
            if(view1 instanceof EditText) {
                Tools.a(view1, hf0);
            }
        }
        this.B = new View[]{this.i, this.j, this.k, this.n, this.p, this.A, this.c};
        int[][] arr2_v = new int[4][];
        int[] arr_v = new int[7];
        arr_v[0] = 1;
        arr_v[2] = 1;
        arr2_v[0] = arr_v;
        int[] arr_v1 = new int[7];
        arr_v1[0] = 1;
        arr_v1[1] = 1;
        arr2_v[1] = arr_v1;
        arr2_v[2] = new int[]{0, 0, 0, 1, 1, 1, 1};
        int[] arr_v2 = new int[7];
        arr_v2[0] = 1;
        arr_v2[1] = 1;
        arr2_v[3] = arr_v2;
        this.C = arr2_v;
        if(v < 0 || v >= this.C.length) {
            throw new IllegalArgumentException("Type must be between: 0 and " + (this.C.length - 1) + " but got: " + v);
        }
        this.a(v);
        this.F = qk.a(0x7F07003F);  // string:edit_examples "\n\t12345\n\t12BA0h\n\t12BA0r\n\n__help_xor_search_title__:\n\t12345X4\n\t12345X-4\n\t12BA0hX4\n\t12BA0hX-4\n\t12BA0rX4\n\t12BA0rX-4\n__text_examples__\n\n__rtfm__\n 
                                    //    "
        TextView textView0 = (TextView)this.g.findViewById(0x7F0B001B);  // id:value
        if(v == 2) {
            Tools.j(textView0);
            textView0.setOnClickListener(this);
            this.F = qk.a(0x7F07003E);  // string:edit_all_examples "\n\t12345\n\t12BA0h\n\t12BA0r\n\t12;34;56;78;90\n\n__help_xor_search_title__:\n\t12345X4\n\t12345X-4\n\t12BA0hX4\n\t12BA0hX-4\n\t12BA0rX4\n\t12BA0rX-4\n\t12;34;56;78;90X4\n\t12;34;56;78;90X-4\n__text_examples__\n\n__rtfm__\n 
                                        //    "
            this.a(he.f);
        }
        else if(v == 1) {
            Tools.j(textView0);
            textView0.setOnClickListener(this);
        }
        this.A.setOnClickListener(this);
        textView0.setText(Tools.g(textView0.getText().toString()) + ':');
        this.m();
        this.a.addTextChangedListener(this);
    }

    private void a(int v) {
        for(int v1 = 0; v1 < this.C[v].length; ++v1) {
            this.B[v1].setVisibility((this.C[v][v1] == 1 ? 0 : 8));
        }
    }

    private void a(boolean z) {
        int v = 0;
        he.f = z;
        String s = z ? qk.a(0x7F070157) : qk.a(0x7F070156);  // string:less "Less"
        this.A.setText(s);
        this.n.setVisibility((z ? 0 : 8));
        this.p.setVisibility((z ? 0 : 8));
        this.r.setVisibility((!z || this.D.d != 1 ? 8 : 0));
        this.s.setVisibility((!z || (this.D.d & 7) == 0 ? 8 : 0));
        if(!z || this.D.d != 1) {
            v = 8;
        }
        this.t.setVisibility(v);
        this.u.setVisibility(v);
        this.v.setVisibility(v);
        this.w.setVisibility(v);
    }

    public qx a(d d0) {
        qx qx0 = new qx(d0);
        qx0.f = this.d.isChecked();
        qx0.n(this.x.getSelected());
        if(qx0.g == 3) {
            qx0.a(re.c(this.y.getText().toString().trim()), re.c(this.z.getText().toString().trim()));
        }
        if(!qx0.f && this.b.isChecked()) {
            qx0.d |= 0x40000000;
        }
        if(this.j.getVisibility() == 0 && this.j.isChecked() || this.k.getVisibility() == 0) {
            String s = this.a();
            if(!qx0.t().equals(s)) {
                qx0.e = s;
            }
        }
        return qx0;
    }

    public String a() {
        String s = this.a.getText().toString().trim();
        iw.a(s, 2);
        return s;
    }

    public void a(View.OnClickListener view$OnClickListener0) {
        this.q.setOnClickListener(view$OnClickListener0);
        this.r.setOnClickListener(view$OnClickListener0);
        this.s.setOnClickListener(view$OnClickListener0);
        this.t.setOnClickListener(view$OnClickListener0);
        this.u.setOnClickListener(view$OnClickListener0);
        this.v.setOnClickListener(view$OnClickListener0);
        this.w.setOnClickListener(view$OnClickListener0);
    }

    public void a(CharSequence charSequence0) {
        this.h.setText(charSequence0);
    }

    public void a(String s) {
        this.m.setText(s.trim());
    }

    @Override  // android.text.TextWatcher
    public void afterTextChanged(Editable editable0) {
        this.j.setChecked(true);
    }

    public String b() {
        String s = this.m.getText().toString().trim();
        iw.a(s, 1);
        return s;
    }

    @Override  // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence0, int v, int v1, int v2) {
    }

    public String c() {
        if(this.n.getVisibility() == 0) {
            String s = this.o.getText().toString().trim();
            iw.a(s, 1);
            return s;
        }
        return "0";
    }

    public boolean d() {
        return this.c.isChecked();
    }

    public View e() {
        return InternalKeyboard.a(this.f());
    }

    public View f() {
        return Tools.d(this.g());
    }

    public View g() {
        return this.g;
    }

    public EditText h() {
        return this.m;
    }

    public d i() {
        return this.D;
    }

    public void j() {
        this.j.setChecked(true);
    }

    // 去混淆评级： 中等(50)
    public boolean k() {
        return this.d.isChecked() ? true : this.i.getVisibility() == 0 && (this.j.getVisibility() == 0 && this.j.isChecked() || this.k.getVisibility() == 0);
    }

    public qx l() {
        return this.a(this.D);
    }

    private void m() {
        String s = d.l(this.D.d);
        this.l.setText(s);
        String s1 = this.D.h();
        this.m.setText(s1);
        this.o.setText("0");
        this.c.setChecked(true);
        hg hg0 = new hg(this);
        this.m.addTextChangedListener(hg0);
        this.o.addTextChangedListener(hg0);
        hh hh0 = new hh(this);
        this.b.setOnCheckedChangeListener(hh0);
        hi hi0 = new hi(this);
        this.d.setOnCheckedChangeListener(hi0);
        this.x.setData(qx.r());
        hj hj0 = new hj(this);
        this.x.setOnItemSelectedListener(hj0);
        if(this.D instanceof qx) {
            String s2 = ((qx)this.D).t();
            this.a.setText(s2);
            this.d.setChecked(((qx)this.D).f);
            this.x.setSelected(((int)((qx)this.D).g));
            String s3 = ((qx)this.D).a(true);
            this.y.setText(s3);
            String s4 = ((qx)this.D).a(false);
            this.z.setText(s4);
            return;
        }
        this.d.setChecked(false);
        this.x.setSelected(0);
        this.y.setText("0");
        this.z.setText("0");
    }

    private boolean n() {
        boolean z = false;
        if((Config.B & 1) == 0) {
            return false;
        }
        if(this.m.isFocused() && ps.g(this.m.getText().toString())) {
            z = true;
        }
        InternalKeyboard.a(this.m, z);
        return z;
    }

    @Override  // android.view.View$OnClickListener
    public void onClick(View view0) {
        if(view0 == null) {
            return;
        }
        switch(view0.getId()) {
            case 0x7F0B0019: {  // id:ext_btn
                if(this.E == 2) {
                    this.a(!he.f);
                }
                this.m.requestFocus();
                return;
            }
            case 0x7F0B001B: {  // id:value
                Searcher.a(this.F);
                return;
            }
            case 0x7F0B00F4: {  // id:edit_step_label
                ConfigListAdapter.b(0x7F07020A);  // string:help_fill "* Fill (increment) values:\n\tIt often happens that too many values 
                                                  // are found, but they can not be changed from the game.\n\tIn this case, the fill 
                                                  // comes to the rescue.\n\n\tA typical example of use is the search for the price of 
                                                  // an item, with a subsequent replacement by a negative one.\n\n\t1. Select the desired 
                                                  // items.\n\t2. Select \"__edit_selected__\".\n\t3. Press the button \"__more__\" to 
                                                  // display \"__increments__\" field, if this field is not present.\n\t4. In \"__increments__\" 
                                                  // field, enter the increment value. Usually this is 1. And click \"__yes__\".\n\t5. 
                                                  // The selected items will receive new values.\n\t6. Go to the game and see how the 
                                                  // desired value has changed, moving across game screens.\n\t7. If the value has not 
                                                  // changed, then the desired element not among selected. Return to __app_name__ and 
                                                  // using the \"__delete_selected__\" -> \"__revert_and_remove__\", remove the selected 
                                                  // items, returning them the previous value. Now you can try everything from the beginning 
                                                  // with other elements, if there are any.\n\t8. If the value has changed, then the 
                                                  // desired element is one of the selected elements. Remember the new value and return 
                                                  // to __app_name__.\n\t9. In the list of selected items, search for the desired value. 
                                                  // Unselect it. Delete all other values, using \"__delete_selected__\" -> \"__revert_and_remove__\", 
                                                  // returning them the previous value.\n\t10. Modify the desired element value as you 
                                                  // need.\n\n\tTypical errors are removal without revert. After that, the game can crash.\n\n\tIf 
                                                  // you find a lot of values, try to do fill in small portions to avoid crashes.\n  
                                                  //   "
            }
        }
    }

    @Override  // android.view.View$OnLongClickListener
    public boolean onLongClick(View view0) {
        if(view0 != null && view0.getId() == 0x7F0B00F7) {  // id:add_not_replace
            ConfigListAdapter.b(0x7F070253);  // string:help_add_to_value "* __help_add_to_value_title__:\nIf this option is checked, 
                                              // the entered value will be added to the existing value, and not replace it. For example, 
                                              // the element has a value of 5, and you entered 7, in the value field. If this option 
                                              // is checked, the element will get a new value of 5 + 7, equal to 12. If not checked, 
                                              // then 7.\nYou can enter both positive and negative values.\nThis option is incompatible 
                                              // with the freezing of the value."
            return true;
        }
        return false;
    }

    @Override  // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence0, int v, int v1, int v2) {
        this.j.setChecked(true);
    }
}

