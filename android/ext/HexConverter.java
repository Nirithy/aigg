package android.ext;

import android.content.Context;
import android.fix.ImageButtonView;
import android.text.Editable;
import android.util.AttributeSet;
import android.view.View.OnClickListener;
import android.view.View;
import java.util.ArrayList;
import java.util.Locale;

public class HexConverter extends ImageButtonView implements View.OnClickListener {
    private boolean a;

    public HexConverter(Context context0) {
        super(context0);
        this.a = true;
        this.a();
    }

    public HexConverter(Context context0, AttributeSet attributeSet0) {
        super(context0, attributeSet0);
        this.a = true;
        this.a();
    }

    public HexConverter(Context context0, AttributeSet attributeSet0, int v) {
        super(context0, attributeSet0, v);
        this.a = true;
        this.a();
    }

    public HexConverter(Context context0, AttributeSet attributeSet0, int v, int v1) {
        super(context0, attributeSet0, v, v1);
        this.a = true;
        this.a();
    }

    private String a(String s, char c, boolean z) {
        int v = s.length();
        if(z) {
            int v2 = 0;
            for(int v1 = 0; v1 < v - 2 && s.charAt(v1) == c; ++v1) {
                v2 = v1 + 1 & -2;
            }
            return s.substring(v2, v);
        }
        for(int v3 = v - 1; v3 >= 2 && s.charAt(v3) == c; --v3) {
            v = v3 + 1 & -2;
        }
        return s.substring(0, v);
    }

    private void a() {
        this.setOnClickListener(this);
        if(!this.isInEditMode()) {
            this.setImageResource(0x7F02000C);  // drawable:ic_arrow_down_drop_circle_white_24dp
            Config.a(this);
        }
    }

    @Override  // android.view.View$OnClickListener
    public void onClick(View view0) {
        int v10;
        int v8;
        byte[] arr_b;
        ArrayList arrayList1;
        ArrayList arrayList0;
        long v7;
        String s3;
        String s2;
        int v6;
        char[] arr_c;
        String s1;
        String s;
        EditText editText0;
        Object object0 = this.getTag();
        int v = 0;
        if(object0 instanceof EditText) {
            editText0 = (EditText)object0;
        }
        else if(!(object0 instanceof Object[]) || ((Object[])object0).length != 2 || !(((Object[])object0)[0] instanceof EditText)) {
            editText0 = null;
        }
        else {
            EditText editText1 = (EditText)((Object[])object0)[0];
            if(((Object[])object0)[1] instanceof Integer) {
                v = (int)(((Integer)((Object[])object0)[1]));
            }
            else if(((Object[])object0)[1] instanceof SystemSpinnerType) {
                v = ((SystemSpinnerType)((Object[])object0)[1]).getSelected();
            }
            editText0 = editText1;
        }
        int v1 = v == 0 ? 0x20 : v;
        if(editText0 == null) {
            return;
        }
        editText0.requestFocus();
        Editable editable0 = editText0.getText();
        int v2 = editText0.getSelectionStart();
        int v3 = editText0.getSelectionEnd();
        boolean z = v2 < 0 || v3 < 0 || v2 == v3;
        if(z) {
            v2 = 0;
            v3 = editable0.length();
        }
        try {
            s = editable0.subSequence(v2, v3).toString().trim();
        }
        catch(StringIndexOutOfBoundsException stringIndexOutOfBoundsException0) {
            la.b(("subSequence fail for " + v2 + ", " + v3 + "; " + editable0.length()), stringIndexOutOfBoundsException0);
            v2 = 0;
            v3 = editable0.length();
            s = editable0.toString();
            z = true;
        }
        if(s.length() == 0) {
            Tools.b(qk.a(0x7F0702FD));  // string:empty_field "Empty input field: no number to convert"
            return;
        }
        try {
            if(ps.e(s) == 0) {
                goto label_55;
            }
            else {
                z = false;
                switch(s.charAt(1)) {
                    case 65: {
                        if(s.charAt(2) == 56) {
                            s1 = s.substring(3).trim();
                            s1 = Integer.toHexString(ag.a(null, null, 0L, s1)).toUpperCase(Locale.US) + 'h';
                        }
                        else {
                            goto label_49;
                        }
                        break;
                    }
                    case 84: {
                        goto label_52;
                    }
                    default: {
                        s1 = s;
                    }
                }
            }
            goto label_56;
        }
        catch(Throwable throwable0) {
            s3 = s;
            Tools.b((qk.a(0x7F0702FE) + "\n\n" + throwable0.getMessage()));  // string:need_integer "You must select an integer to convert."
            la.a(("HexConverter: " + s3), throwable0);
            return;
        }
        try {
            s1 = Integer.toHexString(ag.a(null, null, 0L, s1)).toUpperCase(Locale.US) + 'h';
            goto label_56;
        }
        catch(Throwable throwable1) {
            goto label_76;
        }
        try {
        label_49:
            s1 = s.substring(2).trim();
        }
        catch(Throwable throwable0) {
            s3 = s;
            Tools.b((qk.a(0x7F0702FE) + "\n\n" + throwable0.getMessage()));  // string:need_integer "You must select an integer to convert."
            la.a(("HexConverter: " + s3), throwable0);
            return;
        }
        try {
            s1 = Integer.toHexString(ai.a(null, 0L, s1)).toUpperCase(Locale.US) + 'h';
            goto label_56;
        }
        catch(Throwable throwable1) {
            goto label_76;
        }
        try {
        label_52:
            s1 = s.substring(2).trim();
        }
        catch(Throwable throwable0) {
            s3 = s;
            Tools.b((qk.a(0x7F0702FE) + "\n\n" + throwable0.getMessage()));  // string:need_integer "You must select an integer to convert."
            la.a(("HexConverter: " + s3), throwable0);
            return;
        }
        try {
            s1 = Integer.toHexString(ai.b(null, 0L, s1)).toUpperCase(Locale.US) + 'h';
            goto label_56;
        }
        catch(Throwable throwable1) {
            goto label_76;
        }
        try {
        label_55:
            s1 = s;
        }
        catch(Throwable throwable0) {
            s3 = s;
            Tools.b((qk.a(0x7F0702FE) + "\n\n" + throwable0.getMessage()));  // string:need_integer "You must select an integer to convert."
            la.a(("HexConverter: " + s3), throwable0);
            return;
        }
        try {
        label_56:
            if(z) {
                arr_c = new char[]{ps.b, ':', ';', '~', 'X', 'W', 'Q'};
                s = s1;
                goto label_60;
            }
            else {
                goto label_72;
            }
            goto label_79;
        }
        catch(Throwable throwable1) {
            goto label_76;
        }
        try {
        label_60:
            for(int v4 = 0; v4 < 7; ++v4) {
                int v5 = s.indexOf(((int)arr_c[v4]));
                if(v5 > 0) {
                    s = s.substring(0, v5);
                }
            }
            v6 = s.length();
            s2 = s;
            goto label_79;
        }
        catch(Throwable throwable0) {
            s3 = s;
            Tools.b((qk.a(0x7F0702FE) + "\n\n" + throwable0.getMessage()));  // string:need_integer "You must select an integer to convert."
            la.a(("HexConverter: " + s3), throwable0);
            return;
        }
        try {
        label_72:
            s2 = s1;
            v6 = v3;
        }
        catch(Throwable throwable1) {
        label_76:
            throwable0 = throwable1;
            s3 = s1;
            Tools.b((qk.a(0x7F0702FE) + "\n\n" + throwable0.getMessage()));  // string:need_integer "You must select an integer to convert."
            la.a(("HexConverter: " + s3), throwable0);
            return;
        }
        try {
        label_79:
            v7 = ps.i(s2).a;
            arrayList0 = new ArrayList();
            arrayList1 = new ArrayList();
            String s4 = Tools.a("%,d", new Object[]{v7});
            arrayList0.add(s4);
            arrayList1.add(s4);
            String s5 = this.a(d.d(0L, v7, v1), '0', true) + 'h';
            arrayList0.add(s5);
            arrayList1.add(s5);
            String s6 = this.a(d.c(0L, v7, v1), '0', false) + 'r';
            arrayList0.add(s6);
            arrayList1.add(s6);
            if(this.a) {
                String s7 = Tools.a("%,d", new Object[]{((long)(Config.s ^ v7))});
                arrayList0.add(Tools.a("XOR %,d = %s", new Object[]{Config.s, s7}));
                arrayList1.add(s7);
                arrayList0.add("XOR ... = ???");
                arrayList1.add(null);
            }
            if(v7 != 0L) {
                arr_b = ps.a(v7);
                v8 = arr_b[8];
                if(v8 != -1) {
                    goto label_101;
                }
            }
            goto label_113;
        }
        catch(Throwable throwable2) {
            goto label_158;
        }
        try {
        label_101:
            String s8 = ":" + new String(arr_b, 0, v8 + 1, "UTF-8");
            arrayList0.add("UTF-8: " + s8);
            arrayList1.add(s8);
        }
        catch(Throwable throwable3) {
            try {
                la.a(("HexConverter: " + s2), throwable3);
            }
            catch(Throwable throwable2) {
                goto label_158;
            }
        }
        try {
            String s9 = ";" + new String(arr_b, 0, ((v8 & 1) == 0 ? v8 + 1 : v8) + 1, "UTF-16LE");
            arrayList0.add("UTF-16LE: " + s9);
            arrayList1.add(s9);
            goto label_113;
        }
        catch(Throwable throwable4) {
            try {
                la.a(("HexConverter: " + s2), throwable4);
            label_113:
                int v9 = MainService.instance.r();
                if(v9 == 1) {
                    v10 = AddressArrayAdapter.a;
                }
                else {
                    switch(v9) {
                        case 2: {
                            v10 = SavedListAdapter.a;
                            goto label_123;
                        }
                        case 3: {
                            goto label_122;
                        }
                    }
                    v10 = 0;
                    goto label_123;
                label_122:
                    v10 = MainService.instance.K.c;
                }
            label_123:
                if(v10 != 0) {
                    for(int v11 = 0; true; ++v11) {
                        String s10 = null;
                        if(v11 >= 3) {
                            break;
                        }
                        if((v11 != 0 || (v10 & 16) != 0) && ((v11 != 1 || (v10 & 0x20) != 0) && (v11 != 2 || (v10 & 0x40) != 0))) {
                            if(v11 == 0) {
                                s10 = ai.a(null, 0L, v7);
                            }
                            if(v11 == 1) {
                                s10 = ai.b(null, 0L, v7);
                            }
                            if(v11 == 2) {
                                s10 = ag.a(ag.a(), 0L, ((int)v7), new StringBuilder()).toString();
                            }
                            if(s10 != null) {
                                String s11 = s10.trim();
                                int v12 = s11.indexOf(59);
                                if(v12 != -1) {
                                    s11 = s11.substring(0, v12).trim();
                                }
                                String s12 = null;
                                if(s11.length() > 0) {
                                    if(v11 == 0) {
                                        s12 = "ARM (x32)";
                                        s11 = "~A " + s11;
                                    }
                                    if(v11 == 1) {
                                        s12 = "Thumb";
                                        s11 = "~T " + s11;
                                    }
                                    if(v11 == 2) {
                                        s12 = "ARM (x64)";
                                        s11 = "~A8 " + s11;
                                    }
                                    arrayList0.add(s12 + ": " + s11);
                                    arrayList1.add(s11);
                                }
                            }
                        }
                    }
                }
                is is0 = new is(this, arrayList1, editText0, v2, v6, editable0, v7);
                i.c(i.c().setCustomTitle(Tools.i((s2 + " →"))).setItems(((CharSequence[])arrayList0.toArray(new String[arrayList0.size()])), is0).setNegativeButton(qk.a(0x7F0700A1), is0).create());  // string:cancel "Cancel"
                return;
            }
            catch(Throwable throwable2) {
            }
        }
    label_158:
        throwable0 = throwable2;
        s3 = s2;
        Tools.b((qk.a(0x7F0702FE) + "\n\n" + throwable0.getMessage()));  // string:need_integer "You must select an integer to convert."
        la.a(("HexConverter: " + s3), throwable0);
    }

    public void setUseXor(boolean z) {
        this.a = z;
    }
}

