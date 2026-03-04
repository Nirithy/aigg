package android.ext;

import android.app.AlertDialog;
import android.content.Context;
import android.fix.ImageButtonView;
import android.util.AttributeSet;
import android.util.SparseIntArray;
import android.view.View.OnClickListener;
import android.view.View;
import android.widget.ListView;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class RegionList extends ImageButtonView implements View.OnClickListener {
    static CharSequence[] a;
    static int[] b;
    private static volatile List c;
    private static volatile qs d;
    private static volatile SparseIntArray e;
    private static int[] f;

    static {
        RegionList.c = new ArrayList();
        RegionList.d = null;
        RegionList.e = new SparseIntArray();
    }

    public RegionList(Context context0) {
        super(context0);
        this.b();
    }

    public RegionList(Context context0, AttributeSet attributeSet0) {
        super(context0, attributeSet0);
        this.b();
    }

    public RegionList(Context context0, AttributeSet attributeSet0, int v) {
        super(context0, attributeSet0, v);
        this.b();
    }

    public RegionList(Context context0, AttributeSet attributeSet0, int v, int v1) {
        super(context0, attributeSet0, v, v1);
        this.b();
    }

    public static int a(String s) {
        int v = 0;
        if(s.length() != 4) {
            return 0;
        }
        if(s.charAt(0) == 0x72) {
            v = 0x100;
        }
        if(s.charAt(1) == 0x77) {
            v |= 0x200;
        }
        if(s.charAt(2) == 120) {
            v |= 0x400;
        }
        return s.charAt(3) == 0x73 ? v | 0x800 : v;
    }

    public static long a(int v) {
        return 0x1000L * ((long)RegionList.e.get(v));
    }

    public static qs a(String s, String s1, long v) {
        String s2 = s.trim();
        String s3 = s1.trim();
        if(s3.length() > 0 && v >= 0L) {
            List list0 = RegionList.c;
            qs[] arr_qs = new qs[6];
            int v1 = 0;
            int v2 = 0;
            int v3 = 0;
            File file0 = new File(s3);
            String s4 = "/" + file0.getName();
            String s5 = file0.getParentFile() == null ? null : "/" + file0.getParentFile().getName() + s4;
            int v4 = RegionList.a(s2);
            for(Object object0: list0) {
                qs qs0 = (qs)object0;
                if(qs0 != null) {
                    String s6 = qs0.d();
                    if(s6.length() != 0 && qs0.c - qs0.b > v) {
                        int v5 = (qs0.a ^ v4) & 0xF00;
                        v5 = v5 == 0 ? (qs0.a ^ v4) & 0xF00 : Integer.bitCount(v5);
                        if(s6.equals(s3)) {
                            if(v5 == 0) {
                                arr_qs[0] = qs0;
                                break;
                            }
                            if(arr_qs[1] == null || v1 > v5) {
                                arr_qs[1] = qs0;
                                v1 = v5;
                            }
                        }
                        if(s5 != null && s6.endsWith(s5)) {
                            if(v5 == 0) {
                                arr_qs[2] = qs0;
                            }
                            else if(arr_qs[3] == null || v2 > v5) {
                                arr_qs[3] = qs0;
                                v2 = v5;
                            }
                        }
                        if(!s6.endsWith(s4)) {
                        }
                        else if(v5 == 0) {
                            arr_qs[4] = qs0;
                        }
                        else if(arr_qs[5] == null || v3 > v5) {
                            arr_qs[5] = qs0;
                            v3 = v5;
                        }
                    }
                }
            }
            int v6 = 0;
            while(v6 < 6) {
                qs qs1 = arr_qs[v6];
                if(qs1 == null) {
                    ++v6;
                    continue;
                }
                return qs1;
            }
        }
        return null;
    }

    public static CharSequence a(long v) {
        qs qs0 = RegionList.b(v);
        return qs0 == null ? "?" : qs0.b();
    }

    private static void a() {
        Config.a(0x7F0B0081).c();  // id:config_ranges
    }

    public static void a(bk bk0) {
        bk0.g();
        ArrayList arrayList0 = new ArrayList();
        SparseIntArray sparseIntArray0 = new SparseIntArray();
        List list0 = RegionList.c;
        if(list0 != null) {
            arrayList0.ensureCapacity(list0.size());
        }
        RegionList.a();
        try {
            int v;
            for(String s = ""; (v = bk0.b()) != 0; s = s1) {
                int v1 = RegionList.b(v);
                long v2 = bk0.d();
                long v3 = bk0.d();
                int v4 = bk0.b() << 8 | v1;
                int v5 = bk0.b();
                if(v5 < 0 || v5 > 0x400) {
                    la.c(("Bad name length: " + v5), new RuntimeException());
                    break;
                }
                qs qs0 = RegionList.b(v2);
                String s1 = bk0.a(v5, (qs0 == null ? null : qs0.d)).trim().intern();
                if(qs0 == null || qs0.a != v4 || qs0.b != v2 || qs0.c != v3) {
                    qs0 = new qs(v4, v2, v3);
                }
                qs0.d = s1;
                qs0.e = (v & 0x810) == 0 ? null : s;
                arrayList0.add(qs0);
                sparseIntArray0.put(v1, ((int)((qs0.c - qs0.b) / 0x1000L >= 0L ? (qs0.c - qs0.b) / 0x1000L : 0L)) + sparseIntArray0.get(v1));
            }
        }
        catch(IOException iOException0) {
            la.c("???", iOException0);
        }
        RegionList.c = arrayList0;
        RegionList.e = sparseIntArray0;
        RegionList.d = null;
        MainService.instance.K.f();
    }

    public static void a(int[] arr_v, CharSequence[] arr_charSequence, int[] arr_v1) {
        RegionList.f = arr_v;
        RegionList.a = arr_charSequence;
        RegionList.b = arr_v1;
    }

    public void a(View view0, int v) {
        long v1;
        Object object0 = this.getTag();
        if(!(object0 instanceof EditText)) {
            return;
        }
        ((EditText)object0).requestFocus();
        if(view0 == null) {
            view0 = this;
        }
        boolean z = view0.getId() == 0x7F0B0009;  // id:region_to
        String s = ((EditText)object0).getText().toString().trim();
        if(s.length() > 0) {
            try {
                v1 = ps.a(s, 16);
            }
            catch(NumberFormatException numberFormatException0) {
                la.b(("RegionList failed parse: " + s), numberFormatException0);
                v1 = 0L;
            }
        }
        else {
            v1 = 0L;
        }
        List list0 = RegionList.c;
        int v2 = -1;
        ArrayList arrayList0 = new ArrayList(list0.size());
        SparseIntArray sparseIntArray0 = new SparseIntArray();
        int v3 = 0;
        while(v3 < list0.size()) {
            qs qs0 = (qs)list0.get(v3);
            if(v == 0) {
            label_26:
                sparseIntArray0.append(arrayList0.size(), v3);
                arrayList0.add(qs0.e());
                if(Tools.b(qs0.b, v1)) {
                    v2 = v3;
                }
            }
            else {
                int v4 = qs0.a & 0xFF;
                if(v4 >= RegionList.f.length || (RegionList.f[v4] & v) != 0) {
                    goto label_26;
                }
            }
            ++v3;
        }
        if(arrayList0.size() == 0) {
            StringBuilder stringBuilder0 = new StringBuilder();
            stringBuilder0.append(qk.a(0x7F070313));  // string:no_regions "No matching regions found."
            if(v != 0) {
                int[] arr_v = RegionList.f;
                CharSequence[] arr_charSequence = RegionList.a;
                boolean z1 = false;
                for(int v5 = 0; v5 < arr_v.length; ++v5) {
                    if((arr_v[v5] & v) != 0) {
                        stringBuilder0.append((z1 ? ", " : "\n["));
                        stringBuilder0.append(arr_charSequence[v5]);
                        z1 = true;
                    }
                }
                if(z1) {
                    stringBuilder0.append(']');
                }
            }
            Tools.b(stringBuilder0.toString());
            return;
        }
        AlertDialog alertDialog0 = i.c().setSingleChoiceItems(((CharSequence[])arrayList0.toArray(new CharSequence[arrayList0.size()])), v2, new qr(this, ((EditText)object0), z, list0, sparseIntArray0)).create();
        ListView listView0 = alertDialog0.getListView();
        if(listView0 != null) {
            Tools.a(listView0, 0x7F090002);  // style:SmallText
            FastScrollerFix.a(listView0, true);
        }
        i.c(alertDialog0);
    }

    private static int b(int v) {
        int v2 = 0;
        for(int v1 = 0; v1 < RegionList.f.length; ++v1) {
            if((RegionList.f[v1] & v) == v) {
                v2 = v1;
            }
        }
        return v2;
    }

    public static qs b(long v) {
        qs qs0 = RegionList.d;
        if(qs0 != null && Tools.b(qs0.b, v) && Tools.a(v, qs0.c)) {
            return qs0;
        }
        List list0 = RegionList.c;
        int v1 = 0;
        int v2 = list0.size() - 1;
        while(true) {
            if(v1 > v2) {
                return null;
            }
            int v3 = v1 + v2 >>> 1;
            qs0 = (qs)list0.get(v3);
            if(Tools.b(qs0.c, v)) {
                v1 = v3 + 1;
            }
            else {
                if(!Tools.a(v, qs0.b)) {
                    break;
                }
                v2 = v3 - 1;
            }
        }
        RegionList.d = qs0;
        return qs0;
    }

    private void b() {
        this.setOnClickListener(this);
        if(!this.isInEditMode()) {
            this.setImageResource(0x7F02000C);  // drawable:ic_arrow_down_drop_circle_white_24dp
            Config.a(this);
        }
    }

    public static List getList() {
        return RegionList.c;
    }

    @Override  // android.view.View$OnClickListener
    public void onClick(View view0) {
        this.a(view0, (this instanceof RegionListFiltered ? Config.i : 0));
    }
}

