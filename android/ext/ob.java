package android.ext;

import android.c.a;
import android.c.e;
import android.view.View;
import java.util.Locale;

class ob extends pj {
    final MainService a;

    public ob(MainService mainService0) {
        this.a = mainService0;
        super(0x7F070236, 0x7F020059);  // string:calculate_offset_xor "Calculate offset, XOR"
    }

    private void a() {
        Object object0 = this.a.C();
        long[] arr_v = new long[10];
        long[] arr_v1 = new long[10];
        int v = 0;
        int v1 = 0;
        if(object0 instanceof a) {
            d d0 = new d();
            int v2 = ((a)object0).b();
            int v4 = 0;
            for(int v3 = 0; true; ++v3) {
                if(v3 >= v2) {
                    v = v4;
                    break;
                }
                if(((a)object0).b(v3)) {
                    if(v4 < 10) {
                        ((a)object0).a(v3, d0);
                        arr_v[v4] = d0.b;
                        arr_v1[v4] = d0.c & d.a[d0.d()];
                        ++v4;
                    }
                    ++v1;
                    if(v1 > 10) {
                        v = v4;
                        break;
                    }
                }
            }
        }
        else if(object0 instanceof e) {
            int v5 = ((e)object0).b();
            int v6 = 0;
            int v7 = 0;
            while(true) {
                if(v6 >= v5) {
                    v1 = v7;
                    break;
                }
                if(((e)object0).d(v6)) {
                    qx qx0 = (qx)((e)object0).c(v6);
                    if(qx0 instanceof qx) {
                        if(v < 10) {
                            arr_v[v] = qx0.b;
                            arr_v1[v] = qx0.c & d.a[qx0.d()];
                            ++v;
                        }
                        v1 = v7 + 1;
                        if(v1 <= 10) {
                            goto label_45;
                        }
                        break;
                    }
                    else {
                        v1 = v7;
                    }
                }
                else {
                    v1 = v7;
                }
            label_45:
                ++v6;
                v7 = v1;
            }
        }
        else if(object0 instanceof boolean[]) {
            ow ow0 = this.a.K;
            int v8 = ((boolean[])object0).length - 1;
            int v9 = 1;
            int v10 = 0;
            while(true) {
                if(v9 >= v8) {
                    v1 = v10;
                    break;
                }
                if(((boolean[])object0)[v9]) {
                    if(v < 10) {
                        arr_v[v] = ow0.a(v9);
                        d d1 = (d)ow0.getItem(v9);
                        arr_v1[v] = d1.c & d.a[d1.d()];
                        ++v;
                    }
                    v1 = v10 + 1;
                    if(v1 <= 10) {
                        goto label_66;
                    }
                    break;
                }
                else {
                    v1 = v10;
                }
            label_66:
                ++v9;
                v10 = v1;
            }
        }
        if(v < 2) {
            Tools.b(Tools.a(qk.a(0x7F070167), new Object[]{2}));  // string:need_select_more "Need select __d__ or more items."
            return;
        }
        if(v1 > v) {
            Tools.b(Tools.a(qk.a(0x7F070166), new Object[]{v}));  // string:used_only_first "Used only first __d__ items."
        }
        i.a(i.c().setAdapter(new ArrayAdapter(MainService.context, new String[]{Tools.c(0x7F070168), "XOR"}), new oc(this, arr_v, arr_v1, v)).setNegativeButton(qk.a(0x7F0700A1), null));  // string:offset "Offset:"
    }

    void a(long[] arr_v, long[] arr_v1, int v, int v1) {
        String[] arr_s = new String[(v - 1) * v / 2];
        String[] arr_s1 = new String[(v - 1) * v / 2];
        int v2 = 0;
        for(int v3 = 0; v3 < v - 1; ++v3) {
            for(int v4 = v3 + 1; v4 < v; ++v4) {
                long v5 = arr_v[v3];
                long v6 = arr_v[v4];
                String s = v1 == 0 ? Long.toHexString(v6 - v5).toUpperCase(Locale.US) : Tools.a("%,d", new Object[]{((long)(arr_v1[v3] ^ arr_v1[v4]))});
                arr_s1[v2] = s;
                arr_s[v2] = ts.a(8, v5) + " - " + ts.a(8, v6) + ": " + s;
                ++v2;
            }
        }
        i.a(i.c().setCustomTitle(Tools.d(0x7F070237)).setAdapter(new ArrayAdapter(MainService.context, arr_s), new od(this, arr_s1)).setNegativeButton(qk.a(0x7F0700A1), null));  // string:select_copy_item "Select an item to copy:"
    }

    @Override  // android.ext.pj
    public void onClick(View view0) {
        this.a();
    }
}

