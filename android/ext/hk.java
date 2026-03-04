package android.ext;

import android.app.AlertDialog;
import android.c.a;
import android.c.e;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.DialogInterface.OnShowListener;
import android.content.DialogInterface;
import android.text.SpannableString;
import android.util.SparseIntArray;
import android.view.View.OnClickListener;
import android.view.View;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView;
import java.util.ArrayList;
import java.util.List;

class hk implements DialogInterface.OnClickListener, DialogInterface.OnDismissListener, DialogInterface.OnShowListener, View.OnClickListener, AdapterView.OnItemClickListener {
    int a;
    int b;
    final EditorListener c;
    private AlertDialog d;
    private boolean e;
    private boolean f;
    private int g;
    private List h;
    private he i;

    private hk(EditorListener editorListener0) {
        this.c = editorListener0;
        super();
        this.f = false;
        this.g = 0;
        this.h = null;
        this.a = 0;
        this.b = 0;
    }

    hk(EditorListener editorListener0, hk hk0) {
        this(editorListener0);
    }

    private void a(boolean z, boolean z1, String s) {
        String s1;
        if(z) {
            int v = MainService.instance.r();
            if(v == 1 && MainService.instance.aj == 1L) {
                this.g = 1;
                goto label_7;
            }
            else if(v == 2 && MainService.instance.an.getCount() == 1) {
                this.g = 2;
                goto label_7;
            }
        }
        else {
        label_7:
            if(this.g == 1 || this.g == 2) {
                qm qm0 = MainService.instance.h;
                if(qm0 != null) {
                    qx qx0 = this.i.l();
                    if(this.g == 2 || z1) {
                        qm0.write("\nrevert = ");
                        if(this.g == 1) {
                            ek.a(qm0, true);
                        }
                        else {
                            qm0.write("gg.getListItems()\n");
                        }
                        qm0.write("local t = ");
                        if(this.g == 1) {
                            ek.a(qm0, true);
                        }
                        else {
                            qm0.write("gg.getListItems()\n");
                        }
                        qm0.write("for i, v in ipairs(t) do\n");
                        qm0.write("\tif v.flags == ");
                        Script.Consts.a(qm0, qm0.a.b, qx0.d);
                        qm0.write(" then\n");
                        qm0.write("\t\tv.value = ");
                        if((qx0.d & 0x40000000) == 0x40000000) {
                            qx0.d &= 0xBFFFFFFF;
                            qm0.write("v.value + ");
                        }
                        Script.Consts.b(qm0, s);
                        qm0.write("\n");
                        if(this.g == 2 || qx0.f) {
                            qm0.write("\t\tv.freeze = ");
                            qm0.write(Boolean.toString(qx0.f));
                            qm0.write("\n");
                            if(this.g == 2 || qx0.g != 0) {
                                switch(qx0.g) {
                                    case 0: {
                                        s1 = "gg.FREEZE_NORMAL";
                                        break;
                                    }
                                    case 1: {
                                        s1 = "gg.FREEZE_MAY_INCREASE";
                                        break;
                                    }
                                    case 2: {
                                        s1 = "gg.FREEZE_MAY_DECREASE";
                                        break;
                                    }
                                    case 3: {
                                        s1 = "gg.FREEZE_IN_RANGE";
                                        break;
                                    }
                                    default: {
                                        s1 = Integer.toString(qx0.g);
                                    }
                                }
                                qm0.write("\t\tv.freezeType = ");
                                qm0.write(s1);
                                qm0.write("\n");
                                if(qx0.g == 3) {
                                    qm0.write("\t\tv.freezeFrom = ");
                                    Script.Consts.b(qm0, qx0.a(true));
                                    qm0.write("\n");
                                    qm0.write("\t\tv.freezeTo = ");
                                    Script.Consts.b(qm0, qx0.a(false));
                                    qm0.write("\n");
                                }
                            }
                        }
                        qm0.write("\tend\n");
                        qm0.write("end\n");
                        qm0.write("gg.addListItems(t)\n");
                        qm0.write("t = nil\n\n");
                        return;
                    }
                    qm0.write("revert = ");
                    ek.a(qm0, true);
                    if((qx0.d & 0x40000000) == 0x40000000) {
                        qx0.d &= 0xBFFFFFFF;
                        qm0.write("local t = ");
                        ek.a(qm0, true);
                        qm0.write("for i, v in ipairs(t) do\n");
                        qm0.write("\tif v.flags == ");
                        Script.Consts.a(qm0, qm0.a.b, qx0.d);
                        qm0.write(" then\n");
                        qm0.write("\t\tv.value = ");
                        qm0.write("v.value + ");
                        Script.Consts.b(qm0, s);
                        qm0.write("\n");
                        qm0.write("\tend\n");
                        qm0.write("end\n");
                        qm0.write("gg.setValues(t)\n");
                        qm0.write("t = nil\n\n");
                        return;
                    }
                    qm0.write("gg.editAll(");
                    Script.Consts.b(qm0, s);
                    qm0.write(", ");
                    Script.Consts.a(qm0, qm0.a.b, qx0.d);
                    qm0.write(")\n");
                }
            }
        }
    }

    private boolean a(View view0) {
        d d2;
        int v9;
        d d1;
        int v5;
        d d3;
        int v13;
        StringBuilder stringBuilder0 = null;
    alab2:
        switch(view0.getId()) {
            case 0x7F0B00F9: {  // id:fill_values
                StringBuilder stringBuilder1 = new StringBuilder();
                int v = this.h.size();
                for(int v1 = 0; v1 < v; ++v1) {
                    d d0 = (d)this.h.get(v1);
                    if(v1 != 0) {
                        stringBuilder1.append(';');
                    }
                    stringBuilder1.append(d0.h());
                }
                stringBuilder0 = stringBuilder1;
                break;
            }
            case 0x7F0B00FA:   // id:fill_utf8
            case 0x7F0B00FB: {  // id:fill_utf16le
                StringBuilder stringBuilder2 = new StringBuilder();
                boolean z = view0.getId() == 0x7F0B00FA;  // id:fill_utf8
                stringBuilder2.append(((char)(z ? 58 : 59)));
                if(z) {
                label_57:
                    long v10 = 0L;
                    int v11 = this.h.size();
                    byte[] arr_b = new byte[v11];
                    int v12 = 0;
                    while(true) {
                        if(v12 >= v11) {
                            v13 = v11;
                        }
                        else {
                            d3 = (d)this.h.get(v12);
                            if(v10 == 0L || v10 + 1L == d3.b) {
                                goto label_70;
                            }
                            else {
                                v13 = v12;
                            }
                        }
                        stringBuilder2.append(new String(arr_b, 0, v13, ps.a(!z)));
                        stringBuilder0 = stringBuilder2;
                        break;
                    label_70:
                        v10 = d3.b;
                        arr_b[v12] = (byte)(((int)d3.c));
                        ++v12;
                    }
                }
                else {
                alab1:
                    switch(this.i.i().d) {
                        case 1: {
                            goto label_57;
                        }
                        case 2: {
                            long v2 = 0L;
                            int v3 = this.h.size();
                            char[] arr_c = new char[v3];
                            int v4 = 0;
                            while(true) {
                                if(v4 >= v3) {
                                    v5 = v3;
                                }
                                else {
                                    d1 = (d)this.h.get(v4);
                                    if(v2 == 0L || v2 + 2L == d1.b) {
                                        goto label_35;
                                    }
                                    else {
                                        v5 = v4;
                                    }
                                }
                                stringBuilder2.append(new String(arr_c, 0, v5));
                                stringBuilder0 = stringBuilder2;
                                break alab1;
                            label_35:
                                v2 = d1.b;
                                arr_c[v4] = (char)(((int)d1.c));
                                ++v4;
                            }
                        }
                        case 4: {
                            long v6 = 0L;
                            int v7 = this.h.size();
                            char[] arr_c1 = new char[v7 * 2];
                            int v8 = 0;
                            while(true) {
                                if(v8 >= v7) {
                                    v9 = v7;
                                }
                                else {
                                    d2 = (d)this.h.get(v8);
                                    if(v6 == 0L || v6 + 4L == d2.b) {
                                        goto label_52;
                                    }
                                    else {
                                        v9 = v8;
                                    }
                                }
                                stringBuilder2.append(new String(arr_c1, 0, v9 * 2));
                                stringBuilder0 = stringBuilder2;
                                break alab1;
                            label_52:
                                v6 = d2.b;
                                arr_c1[v8 * 2] = (char)(((int)d2.c));
                                arr_c1[v8 * 2 + 1] = (char)(((int)(d2.c >> 16)));
                                ++v8;
                            }
                        }
                        default: {
                            stringBuilder0 = stringBuilder2;
                        }
                    }
                }
                break;
            }
            case 0x7F0B00FC: {  // id:fill_hex
                StringBuilder stringBuilder3 = new StringBuilder();
                stringBuilder3.append('h');
                long v14 = 0L;
                int v15 = this.h.size();
                char[] arr_c2 = iu.a;
                for(int v16 = 0; true; ++v16) {
                    if(v16 >= v15) {
                        stringBuilder0 = stringBuilder3;
                        break alab2;
                    }
                    d d4 = (d)this.h.get(v16);
                    if(v14 != 0L && v14 + 1L != d4.b) {
                        stringBuilder0 = stringBuilder3;
                        break alab2;
                    }
                    v14 = d4.b;
                    stringBuilder3.append(' ');
                    int v17 = (int)d4.c;
                    stringBuilder3.append(arr_c2[(v17 & 0xF0) >> 4]);
                    stringBuilder3.append(arr_c2[v17 & 15]);
                }
            }
            case 0x7F0B00FD:   // id:fill_hex_utf8
            case 0x7F0B00FE:   // id:fill_hex_utf16le
            case 0x7F0B00FF: {  // id:fill_hex_utf8_utf16le
                stringBuilder0 = new StringBuilder();
                stringBuilder0.append('Q');
                stringBuilder0.append(' ');
                int v18 = view0.getId();
                long v19 = 0L;
                int v20 = this.h.size();
                byte[] arr_b1 = new byte[v20];
                int v21;
                for(v21 = 0; true; ++v21) {
                    if(v21 >= v20) {
                        v21 = v20;
                        break;
                    }
                    d d5 = (d)this.h.get(v21);
                    if(v19 != 0L && v19 + 1L != d5.b) {
                        break;
                    }
                    v19 = d5.b;
                    arr_b1[v21] = (byte)(((int)d5.c));
                }
                iu.a(stringBuilder0, 0, arr_b1, v21, v18 == 0x7F0B00FD || v18 == 0x7F0B00FF, v18 == 0x7F0B00FE || v18 == 0x7F0B00FF, null);  // id:fill_hex_utf8
            }
        }
        if(stringBuilder0 != null) {
            this.i.a(stringBuilder0.toString());
        }
        return stringBuilder0 != null;
    }

    void a(d d0) {
        this.h = null;
        this.a = 0;
        this.b = 0;
        this.g = 0;
        this.b(d0);
    }

    void b(d d0) {
        int v10;
        int v9;
        this.e = false;
        this.f = false;
        if(d0 == null) {
            this.e = true;
            Object object0 = MainService.instance.C();
            if(Tools.a(object0) == 0) {
                Tools.a(0x7F07013C);  // string:nothing_selected "Nothing selected"
                return;
            }
            if(this.h == null) {
                this.h = new ArrayList();
                if(object0 instanceof boolean[]) {
                    this.g = 3;
                    if(this.a == 0) {
                        this.h = null;
                        SparseIntArray sparseIntArray0 = new SparseIntArray();
                        new tu(d.c(MainService.instance.K.a(((boolean[])object0), sparseIntArray0)), sparseIntArray0, "0", qk.a(0x7F0700EF), new hl(this));  // string:type_change_request "Select the data type to change"
                        return;
                    }
                    ow ow0 = MainService.instance.K;
                    int v = ((boolean[])object0).length - 1;
                    for(int v1 = 1; v1 < v; ++v1) {
                        if(((boolean[])object0)[v1]) {
                            d d1 = new d(ow0.a(v1), 0L, this.a);
                            if(d1.q()) {
                                d1.c = MainService.instance.b(d1.b, d1.d);
                                this.h.add(d1);
                            }
                        }
                    }
                    this.a = 0;
                }
                else if(object0 instanceof e) {
                    this.g = 2;
                    int v2 = ((e)object0).b();
                    for(int v3 = 0; v3 < v2; ++v3) {
                        if(((e)object0).d(v3)) {
                            this.h.add(((d)((e)object0).c(v3)));
                        }
                    }
                }
                else {
                    if(!(object0 instanceof a)) {
                        throw new IllegalArgumentException("Obj is unknown: " + object0);
                    }
                    this.g = 1;
                    int v4 = ((a)object0).b();
                    for(int v5 = 0; v5 < v4; ++v5) {
                        if(((a)object0).b(v5)) {
                            this.h.add(((a)object0).a(v5, null));
                        }
                    }
                }
            }
            if(this.h == null) {
                v9 = 0;
            }
            else {
                if(this.h.size() == 0) {
                    Tools.a(0x7F07013C);  // string:nothing_selected "Nothing selected"
                    la.a("It must never happen.");
                    return;
                }
                if(this.b == 0) {
                    SparseIntArray sparseIntArray1 = new SparseIntArray();
                    int v6 = 0;
                    for(Object object1: this.h) {
                        int v7 = ((d)object1).d;
                        sparseIntArray1.put(v7, sparseIntArray1.get(v7) + 1);
                        v6 |= v7;
                    }
                    new tu(d.c(v6), sparseIntArray1, "0", qk.a(0x7F0700EF), new hm(this));  // string:type_change_request "Select the data type to change"
                    return;
                }
                for(int v8 = 0; v8 < this.h.size(); ++v8) {
                    if(((d)this.h.get(v8)).d != this.b) {
                        this.h.remove(v8);
                        --v8;
                    }
                }
                this.b = 0;
                if(this.h.size() == 0) {
                    Tools.a(0x7F07013E);  // string:no_items_for_editing "There are no items to edit."
                    la.a(("It must never happen. " + this.b));
                    return;
                }
                d0 = ((d)this.h.get(0)).a();
                v9 = this.h.size();
                if(v9 == 1) {
                    this.e = false;
                }
            }
            if(d0 == null) {
                throw new NullPointerException("Something going wrong");
            }
        }
        else {
            v9 = 0;
        }
        if(!this.e) {
            qx qx0 = MainService.instance.an.a(d0.b);
            if(qx0 == null || qx0.m() != d0.m()) {
                d0 = new qx(d0);
            }
            else {
                qx qx1 = qx0.s();
                qx1.c = d0.c;
                this.f = true;
                d0 = qx1;
            }
        }
        if(this.e) {
            d0.d = d0.m();
        }
        if(this.e) {
            v10 = 2;
        }
        else {
            v10 = this.f ? 0 : 1;
        }
        this.i = new he(v10, d0);
        if(this.e) {
            String s = ra.a != null && this.g == 1 ? ra.a : d0.h();
            this.i.a(s);
            this.i.a(this);
        }
        else if(this.f) {
            this.i.j();
        }
        CharSequence charSequence0 = d0.n();
        this.i.a(Tools.a(new SpannableString((this.e ? Tools.a(qk.a(0x7F070140), new Object[]{v9, charSequence0}) : Tools.a(qk.a(0x7F07013F), new Object[]{"00000000", charSequence0}))), charSequence0, d0.o()));  // string:edit_all_info "Edit __d__ addresses as __s__"
        AlertDialog alertDialog0 = i.c().setView(this.i.e()).setPositiveButton(qk.a(0x7F07009B), this).setNegativeButton(qk.a(0x7F07009C), null).create();  // string:yes "Yes"
        this.d = alertDialog0;
        if(!this.e) {
            alertDialog0.setButton(-3, qk.a(0x7F07008D), this);  // string:goto1 "Goto"
        }
        i.a(alertDialog0, this);
        i.a(alertDialog0, this);
        i.a(alertDialog0, this.i.h());
    }

    @Override  // android.content.DialogInterface$OnClickListener
    public void onClick(DialogInterface dialogInterface0, int v) {
        if(v == -3 && !this.e) {
            d d0 = this.i.i();
            MainService.instance.a((this.c.a ? d0.b : null), d0.g(), Tools.c(0x7F07024D) + ": (" + d0 + ')');  // string:from_item "From the item:"
        }
    }

    @Override  // android.view.View$OnClickListener
    public void onClick(View view0) {
        f f1;
        int v16;
        long v15;
        long v14;
        int v13;
        long v11;
        int v10;
        String s4;
        long v20;
        int v19;
        String[] arr_s;
        byte[] arr_b;
        char[] arr_c;
        if(view0 == null || view0.getTag() instanceof pj) {
            this.a(null);
            return;
        }
        try {
            if(!this.e) {
                String s = re.c(this.i.b());
                rd rd0 = ra.a(s, false);
                int v = rd0 == null ? 0 : rd0.b;
                if(rd0 != null) {
                    s = rd0.a;
                }
                qx qx0 = this.i.l();
                qx0.a(s);
                qx0.m(v);
                boolean z = this.i.k();
                if(z || this.f) {
                    MainService.instance.an.a(qx0);
                }
                Tools.a(this.d);
                this.a(true, z, s);
                MainService.instance.L();
                return;
            }
            if(!this.a(view0)) {
                try {
                    String s1 = re.c(this.i.b());
                    rd rd1 = ra.a(s1, false);
                    int v1 = rd1 == null ? 0 : rd1.b;
                    String s2 = rd1 == null ? s1 : rd1.a;
                    boolean z1 = this.i.k();
                    String s3 = re.c(this.i.c());
                    int v2 = this.h.size();
                    boolean z2 = this.i.d();
                    int v3 = this.i.i().d;
                    if(v3 == 1 && ps.d(s2)) {
                        arr_c = null;
                        arr_b = ps.a(s2);
                        arr_s = null;
                    }
                    else if((v3 & 6) != 0 && (ps.d(s2) && s2.charAt(0) == 59)) {
                        arr_c = s2.substring(1).toCharArray();
                        arr_b = null;
                        arr_s = null;
                    }
                    else if(s2.indexOf(59) == -1) {
                        arr_c = null;
                        arr_b = null;
                        arr_s = null;
                    }
                    else {
                        String[] arr_s1 = s2.split(";");
                        if(arr_s1.length == 0) {
                            arr_c = null;
                            arr_b = null;
                            arr_s = null;
                        }
                        else {
                            arr_c = null;
                            arr_b = null;
                            arr_s = arr_s1;
                        }
                    }
                    SavedListAdapter savedListAdapter0 = MainService.instance.an;
                    pv pv0 = null;
                    pv[] arr_pv = arr_s == null ? null : new pv[arr_s.length];
                    int v4 = 0;
                    int v5 = 0;
                    long v6 = 0L;
                    f f0 = null;
                    int v7 = 0;
                    while(true) {
                        if(v5 >= v2) {
                            savedListAdapter0.notifyDataSetChanged();
                            MainService.instance.L();
                            Tools.a(this.d);
                            if(ra.a != null && this.g == 1 && (arr_b != null || arr_c != null)) {
                                ra.a = s1;
                            }
                            this.a(false, z1, s1);
                            return;
                        }
                        d d0 = (d)this.h.get(v5);
                        qx qx1 = MainService.instance.an.a(d0.b);
                        boolean z3 = qx1 != null && qx1.m() == d0.m();
                        qx qx2 = this.i.a(d0);
                        if(z2) {
                            if(arr_b != null) {
                                int v17 = v6 + 1L == d0.b ? v4 : 0;
                                long v18 = d0.b;
                                if(v17 < arr_b.length) {
                                    v19 = v17 + 1;
                                    v20 = 0xFFL & ((long)arr_b[v17]);
                                }
                                else {
                                    v20 = 0L;
                                    v19 = v17;
                                }
                                qx2.c = v20;
                                v15 = v18;
                                v4 = v19;
                                v16 = v7;
                            }
                            else if(arr_c == null) {
                                if(arr_s != null) {
                                    v4 = v5 % arr_s.length;
                                    s2 = arr_s[v4];
                                    pv pv1 = arr_pv[v4];
                                    if(pv1 == null) {
                                        pv0 = d.a(null, s2, qx2.d, 0x7F0700CF, d0.b);  // string:number_name "number"
                                        arr_pv[v4] = pv0;
                                    }
                                    else {
                                        pv0 = pv1;
                                    }
                                }
                                else if(pv0 == null) {
                                    pv0 = d.a(null, s2, qx2.d, 0x7F0700CF, d0.b);  // string:number_name "number"
                                    s4 = s2;
                                    goto label_117;
                                }
                                s4 = s2;
                            label_117:
                                v16 = v7 + 1;
                                f0 = qx2.a(f0, pv0, s4, d0.b, s3, v16);
                                v15 = v6;
                                s2 = s4;
                            }
                            else {
                                boolean z4 = d0.d == 2;
                                int v8 = ((long)(z4 ? 2 : 4)) + v6 == d0.b ? v4 : 0;
                                long v9 = d0.b;
                                if(v8 < arr_c.length) {
                                    v10 = v8 + 1;
                                    v11 = 0xFFFFL & ((long)arr_c[v8]);
                                }
                                else {
                                    v11 = 0L;
                                    v10 = v8;
                                }
                                qx2.c = v11;
                                if(z4) {
                                    v15 = v9;
                                    v4 = v10;
                                }
                                else {
                                    long v12 = qx2.c;
                                    if(v10 < arr_c.length) {
                                        v13 = v10 + 1;
                                        v14 = (0xFFFFL & ((long)arr_c[v10])) << 16;
                                    }
                                    else {
                                        v14 = 0L;
                                        v13 = v10;
                                    }
                                    qx2.c = v14 | v12;
                                    v15 = v9;
                                    v4 = v13;
                                }
                                v16 = v7;
                            }
                            qx2.m(v1);
                            f1 = f0;
                        }
                        else {
                            v15 = v6;
                            f1 = f0;
                            v16 = v7;
                        }
                        if(z1 || z3) {
                            savedListAdapter0.a(qx2, 0, false);
                        }
                        ++v5;
                        v6 = v15;
                        f0 = f1;
                        v7 = v16;
                    }
                }
                catch(NumberFormatException numberFormatException1) {
                    re.a(numberFormatException1, this.i.h());
                }
                catch(Throwable throwable1) {
                    la.c("Exception in EditorListener", throwable1);
                }
            }
        }
        catch(NumberFormatException numberFormatException0) {
            re.a(numberFormatException0, this.i.h());
        }
        catch(Throwable throwable0) {
            la.c("Exception in EditorListener", throwable0);
        }
    }

    @Override  // android.content.DialogInterface$OnDismissListener
    public void onDismiss(DialogInterface dialogInterface0) {
        try {
            this.i.f();
        }
        catch(Throwable throwable0) {
            la.a(throwable0);
        }
    }

    @Override  // android.widget.AdapterView$OnItemClickListener
    public void onItemClick(AdapterView adapterView0, View view0, int v, long v1) {
        Object object0 = adapterView0.getItemAtPosition(v);
        if(object0 instanceof iq) {
            MainService.instance.a(((iq)object0).b(), ((iq)object0).a(), Tools.c(0x7F07024F));  // string:from_boundary "From the boundary"
            return;
        }
        d d0 = object0 instanceof d ? ((d)object0) : null;
        if(d0 != null) {
            if(adapterView0.getId() == 0x7F0B00E8 && ((Config.B & 0x400) == 0 || Integer.bitCount(d0.d) != 1)) {  // id:mem_listview
                new tu(d.a(0x7F, d0.b), "0", qk.a(0x7F0700EF), new hn(this, d0));  // string:type_change_request "Select the data type to change"
                return;
            }
            this.a(d0);
        }
    }

    @Override  // android.content.DialogInterface$OnShowListener
    public void onShow(DialogInterface dialogInterface0) {
        Tools.a(dialogInterface0, -1, null, this, this.i.h());
    }
}

