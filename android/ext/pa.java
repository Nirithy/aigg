package android.ext;

import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View.OnFocusChangeListener;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.CompoundButton;
import android.widget.TextView;
import java.lang.ref.WeakReference;

class pa extends pj implements DialogInterface.OnClickListener, TextWatcher, CompoundButton.OnCheckedChangeListener {
    boolean a;
    final ow b;
    private WeakReference c;
    private WeakReference d;
    private WeakReference g;

    public pa(ow ow0) {
        this.b = ow0;
        super(0x7F070090, 0x7F020024);  // string:filter "Filter"
        this.c = new WeakReference(null);
        this.d = new WeakReference(null);
        this.g = new WeakReference(null);
        this.a = false;
    }

    @Override  // android.text.TextWatcher
    public void afterTextChanged(Editable editable0) {
        boolean z = true;
        String s = editable0.toString();
        CheckBox checkBox0 = (CheckBox)this.d.get();
        if(checkBox0 != null) {
            checkBox0.setChecked(s.indexOf(94) != -1);
            CheckBox checkBox1 = (CheckBox)this.g.get();
            if(checkBox1 != null) {
                if(s.indexOf(36) == -1) {
                    z = false;
                }
                checkBox1.setChecked(z);
            }
        }
    }

    @Override  // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence0, int v, int v1, int v2) {
    }

    @Override  // android.widget.CompoundButton$OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton0, boolean z) {
        if(compoundButton0 != null) {
            EditText editText0 = (EditText)this.c.get();
            if(editText0 != null) {
                switch(compoundButton0.getId()) {
                    case 0x7F0B0043: {  // id:starts
                        String s = editText0.getText().toString();
                        if(s.contains("^") != z) {
                            if(z) {
                                editText0.getText().replace(0, 0, "^");
                                return;
                            }
                            int v = s.indexOf("^");
                            editText0.getText().replace(v, v + 1, "");
                            return;
                        }
                        break;
                    }
                    case 0x7F0B0044: {  // id:ends
                        String s1 = editText0.getText().toString();
                        if(s1.contains("$") != z) {
                            if(z) {
                                editText0.getText().replace(s1.length(), s1.length(), "$");
                                return;
                            }
                            int v1 = s1.indexOf("$");
                            editText0.getText().replace(v1, v1 + 1, "");
                            return;
                        }
                        break;
                    }
                    case 0x7F0B0045: {  // id:external
                        this.a = z;
                        View.OnFocusChangeListener view$OnFocusChangeListener0 = editText0.getOnFocusChangeListener();
                        if(view$OnFocusChangeListener0 != null) {
                            view$OnFocusChangeListener0.onFocusChange(editText0, true);
                            return;
                        }
                        break;
                    }
                }
            }
        }
    }

    @Override  // android.content.DialogInterface$OnClickListener
    public void onClick(DialogInterface dialogInterface0, int v) {
        String s1;
        if(v == -1) {
            EditText editText0 = (EditText)this.c.get();
            if(editText0 == null) {
                return;
            }
            String s = editText0.getText().toString();
            if(s.length() > 0) {
                iw.a(s, (this.a ? 2 : 1));
            }
            s1 = s;
        }
        else {
            s1 = "";
        }
        this.b.a = s1;
        MainService.instance.t.setText((s1.length() <= 0 ? qk.a(0x7F070261) : Tools.c(0x7F070090) + ": " + s1));  // string:no_filter "No filter."
        this.b.notifyDataSetChanged();
    }

    @Override  // android.ext.pj
    public void onClick(View view0) {
        if(view0 != null && view0.getId() == 0x7F0B000E) {  // id:message
            i.a(i.c().setMessage(qk.a(0x7F07018E) + ":\n" + qk.a(0x7F070042)).setPositiveButton(qk.a(0x7F07012B), new pb(this)).setNegativeButton(qk.a(0x7F0700A1), null));  // string:examples "Examples"
            return;
        }
        View view1 = android.fix.i.a(0x7F04000C, null);  // layout:memory_filter
        TextView textView0 = (TextView)view1.findViewById(0x7F0B000E);  // id:message
        Tools.j(textView0);
        textView0.setOnClickListener(this);
        CheckBox checkBox0 = (CheckBox)view1.findViewById(0x7F0B0045);  // id:external
        checkBox0.setChecked(this.a);
        checkBox0.setText(qk.a(0x7F070041));  // string:keyboard_external "__keyboard__ __external__"
        checkBox0.setOnCheckedChangeListener(this);
        CheckBox checkBox1 = (CheckBox)view1.findViewById(0x7F0B0043);  // id:starts
        checkBox1.setOnCheckedChangeListener(this);
        this.d = new WeakReference(checkBox1);
        CheckBox checkBox2 = (CheckBox)view1.findViewById(0x7F0B0044);  // id:ends
        checkBox2.setOnCheckedChangeListener(this);
        this.g = new WeakReference(checkBox2);
        String s = this.b.a;
        pc pc0 = new pc(this);
        EditText editText0 = (EditText)view1.findViewById(0x7F0B0041);  // id:filter
        editText0.setText((s == null ? "" : s));
        editText0.setDataType(3);
        Tools.a(editText0, pc0);
        editText0.addTextChangedListener(this);
        this.c = new WeakReference(editText0);
        this.afterTextChanged(editText0.getText());
        ((HexConverter)view1.findViewById(0x7F0B0042)).setTag(editText0);  // id:number_converter
        view1.setTag(new kt(15));
        i.a(i.c().setView(InternalKeyboard.a(view1)).setPositiveButton(0x7F07009D, this).setNegativeButton(0x7F0700A1, null).setNeutralButton(0x7F070091, this).create(), editText0);  // string:ok "OK"
    }

    @Override  // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence0, int v, int v1, int v2) {
    }
}

