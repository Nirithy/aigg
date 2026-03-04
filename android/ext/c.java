package android.ext;

import android.app.AlertDialog;
import android.c.e;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.DialogInterface.OnShowListener;
import android.content.DialogInterface;
import android.fix.TextView;
import android.fix.i;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View.OnClickListener;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

class c implements DialogInterface.OnClickListener, DialogInterface.OnDismissListener, DialogInterface.OnShowListener, TextWatcher, View.OnClickListener, CompoundButton.OnCheckedChangeListener {
    private static String a;
    private static boolean b;
    private final String c;
    private final int[] d;
    private final int[] e;
    private AlertDialog f;
    private EditText g;
    private CheckBox h;
    private CheckBox i;
    private TextView j;
    private SystemSpinnerType k;

    static {
        c.a = "0";
        c.b = true;
    }

    c(String s) {
        this.d = new int[3];
        this.e = new int[4];
        this.c = s;
    }

    private long a(boolean z) {
        String s = re.c(this.g.getText().toString().trim());
        if(s.length() == 0) {
            s = "0";
        }
        long v = ps.a(s, (this.c != null || this.i.isChecked() ? 16 : 10));
        long v1 = this.c == null ? v : v - ps.a(this.c, 16);
        if(z) {
            iw.a(s, 1);
        }
        return v1;
    }

    private void a() {
        if(this.g == null) {
            return;
        }
        int v = this.k.getSelected();
        int v1 = 1;
        int v2 = 0;
        try {
            long v3 = this.a(false);
            if(v == 0x7F) {
                int[] arr_v1 = this.d;
                for(int v5 = 0; v5 < arr_v1.length; ++v5) {
                    if(arr_v1[v5] != 0 && (((long)((1 << v5) - 1)) & v3) != 0L) {
                        v1 = 1 << v5;
                        v2 += arr_v1[v5];
                    }
                }
            }
            else {
                int[] arr_v = this.e;
                v1 = d.e(v);
                for(int v4 = 0; v4 < arr_v.length; ++v4) {
                    if(arr_v[v4] != 0 && (((long)v4) + v3 & ((long)(v1 - 1))) != 0L) {
                        v2 += arr_v[v4];
                    }
                }
            }
        }
        catch(Throwable unused_ex) {
        }
        this.j.setText(Tools.a(qk.a((v == 0x7F ? 0x7F070069 : 0x7F07006A)), new Object[]{v1, v2}));  // string:align_warn_offset "__bad_offset__\n__correct_types__"
        this.j.setVisibility((v2 <= 0 ? 4 : 0));
    }

    @Override  // android.text.TextWatcher
    public void afterTextChanged(Editable editable0) {
        this.a();
    }

    @Override  // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence0, int v, int v1, int v2) {
    }

    @Override  // android.widget.CompoundButton$OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton0, boolean z) {
        this.a();
    }

    @Override  // android.content.DialogInterface$OnClickListener
    public void onClick(DialogInterface dialogInterface0, int v) {
        this.a();
        if(v == -1) {
            this.onClick(((AlertDialog)dialogInterface0).getButton(-1));
        }
    }

    @Override  // android.view.View$OnClickListener
    public void onClick(View view0) {
        int v3;
        Object object0 = MainService.instance.C();
        if(Tools.a(object0) == 0) {
            Tools.a(0x7F07013C);  // string:nothing_selected "Nothing selected"
            return;
        }
        if(object0 instanceof e) {
            if(view0 == null || view0.getTag() instanceof pj) {
                View view1 = i.a(0x7F040017, null);  // layout:service_address_editor
                EditText editText0 = (EditText)view1.findViewById(0x7F0B0065);  // id:mem_edit_addr
                this.g = editText0;
                this.h = (CheckBox)view1.findViewById(0x7F0B0068);  // id:make_copy
                CheckBox checkBox0 = (CheckBox)view1.findViewById(0x7F0B0066);  // id:hex
                this.i = checkBox0;
                checkBox0.setChecked(c.b);
                checkBox0.setOnCheckedChangeListener(this);
                this.j = (TextView)view1.findViewById(0x7F0B0069);  // id:align_warn
                SystemSpinnerType systemSpinnerType0 = (SystemSpinnerType)view1.findViewById(0x7F0B0067);  // id:type
                this.k = systemSpinnerType0;
                systemSpinnerType0.setData(d.a(0x7F, true));
                systemSpinnerType0.setSelected(0x7F);
                systemSpinnerType0.setOnItemSelectedListener(this);
                int v = ((e)object0).b();
                int[] arr_v = this.d;
                Arrays.fill(arr_v, 0);
                int[] arr_v1 = this.e;
                Arrays.fill(arr_v1, 0);
                for(int v1 = 0; v1 < v; ++v1) {
                    if(((e)object0).d(v1)) {
                        qx qx0 = (qx)((e)object0).c(v1);
                        if(qx0 instanceof qx) {
                            int v2 = qx0.e();
                            if(v2 == 1) {
                                v3 = 0;
                            }
                            else {
                                v3 = v2 == 2 ? 1 : 2;
                            }
                            ++arr_v[v3];
                            int v4 = (int)(qx0.b & 3L);
                            ++arr_v1[v4];
                        }
                    }
                }
                editText0.setDataType(1);
                editText0.addTextChangedListener(this);
                if(this.c == null) {
                    editText0.setText("0");
                }
                else {
                    ((LinearLayout)view1.findViewById(0x7F0B0064)).setOrientation(1);  // id:group
                    ((TextView)view1.findViewById(0x7F0B0051)).setText(Tools.c(0x7F070347) + ":");  // id:name
                    checkBox0.setVisibility(8);
                }
                this.a();
                AlertDialog alertDialog0 = android.ext.i.c().setView(InternalKeyboard.a(view1)).setPositiveButton(qk.a(0x7F07009D), this).setNegativeButton(qk.a(0x7F0700A1), null).create();  // string:ok "OK"
                this.f = alertDialog0;
                android.ext.i.a(alertDialog0, this);
                android.ext.i.a(alertDialog0, this);
                android.ext.i.a(alertDialog0, editText0);
                return;
            }
            try {
                if(this.g != null) {
                    long v5 = this.a(true);
                    ArrayList arrayList0 = new ArrayList();
                    int v6 = ((e)object0).b();
                alab1:
                    for(int v7 = 0; true; ++v7) {
                        if(v7 >= v6) {
                            MainService.instance.d(0);
                            boolean z = this.h.isChecked();
                            SavedListAdapter savedListAdapter0 = MainService.instance.an;
                            if(!z) {
                                savedListAdapter0.a(arrayList0);
                            }
                            int v8 = this.k.getSelected();
                            Iterator iterator0 = arrayList0.iterator();
                            while(true) {
                                if(!iterator0.hasNext()) {
                                    savedListAdapter0.notifyDataSetChanged();
                                    savedListAdapter0.d();
                                    qm qm0 = MainService.instance.h;
                                    if(qm0 == null) {
                                        break alab1;
                                    }
                                    qm0.write("\nlocal copy = ");
                                    qm0.write((z ? "true" : "false"));
                                    qm0.write("\n");
                                    qm0.write("local t = gg.getListItems()\n");
                                    qm0.write("if not copy then gg.removeListItems(t) end\n");
                                    qm0.write("for i, v in ipairs(t) do\n");
                                    qm0.write("\tv.address = v.address + ");
                                    if(this.c == null && !this.i.isChecked()) {
                                        qm0.write(Long.toString(v5));
                                    }
                                    else {
                                        Script.Consts.a(qm0, v5);
                                    }
                                    qm0.write("\n");
                                    qm0.write("\tif copy then v.name = v.name..\' #2\' end\n");
                                    qm0.write("end\n");
                                    qm0.write("gg.addListItems(t)\n");
                                    qm0.write("t = nil\n");
                                    qm0.write("copy = nil\n\n");
                                    break alab1;
                                }
                                Object object1 = iterator0.next();
                                qx qx1 = ((qx)object1).s();
                                if(z) {
                                    qx1.e = "Var #00000000 #2";
                                }
                                if(v8 != 0x7F) {
                                    qx1.d = v8;
                                }
                                qx1.b += v5;
                                if(!qx1.q()) {
                                    qx1.d = d.a(qx1.b, true);
                                }
                                savedListAdapter0.a(qx1, 1, false);
                            }
                        }
                        if(((e)object0).d(v7)) {
                            qx qx2 = (qx)((e)object0).c(v7);
                            if(qx2 instanceof qx) {
                                arrayList0.add(qx2.s());
                            }
                        }
                    }
                }
                Tools.a(this.f);
            }
            catch(NumberFormatException numberFormatException0) {
                re.a(numberFormatException0, this.g);
            }
        }
    }

    @Override  // android.content.DialogInterface$OnDismissListener
    public void onDismiss(DialogInterface dialogInterface0) {
        if(this.c == null) {
            EditText editText0 = this.g;
            if(editText0 != null) {
                c.a = editText0.getText().toString().trim();
                c.b = this.i.isChecked();
            }
        }
    }

    @Override  // android.content.DialogInterface$OnShowListener
    public void onShow(DialogInterface dialogInterface0) {
        Tools.a(dialogInterface0, -1, null, this, this.g);
    }

    @Override  // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence0, int v, int v1, int v2) {
        this.a();
    }
}

