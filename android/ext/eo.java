package android.ext;

import android.c.a;
import android.c.e;
import android.content.DialogInterface.OnClickListener;
import android.view.View;

public class eo extends pj {
    public eo() {
        super(0x7F070276, 0x7F020016);  // string:copy_as_search "Copy as a group search"
    }

    private void a(et et0, StringBuilder stringBuilder0, d d0, int v) {
        if(et0 != null) {
            if(et0.c == 0L) {
                et0.c = d0.b;
            }
            int v1 = d0.d();
            long v2 = d0.c;
            for(int v3 = 0; v3 < v1; ++v3) {
                long v4 = d0.b + ((long)v3);
                if(et0.c <= v4) {
                    int v5 = et0.b;
                    et0.b = v5 + 1;
                    et0.a[v5] = (byte)(((int)(0xFFL & v2)));
                    et0.c = v4;
                }
                v2 >>= 8;
            }
            return;
        }
        if(stringBuilder0.length() != 0) {
            stringBuilder0.append(';');
        }
        if((v & 2) != 0) {
            stringBuilder0.append("0000000000000000");
            stringBuilder0.append('r');
        }
        else if((v & 1) == 0) {
            stringBuilder0.append(d0.h());
        }
        else {
            stringBuilder0.append("0000000000000000");
            stringBuilder0.append('h');
        }
        if((v & 4) != 0) {
            stringBuilder0.append(d0.l());
        }
    }

    void a(int v) {
        long v20;
        long v14;
        long v10;
        Object object0 = MainService.instance.C();
        StringBuilder stringBuilder0 = new StringBuilder();
        int v1 = 0;
        int v2 = 0;
        long v3 = 0L;
        long v4 = 0L;
        int v5 = Integer.numberOfTrailingZeros(v & 0x3F0);
        et et0 = v5 == 0x20 ? null : new et();
        if(object0 instanceof a) {
            d d0 = new d();
            int v6 = ((a)object0).b();
            long v8 = 0L;
            int v9 = 0;
            for(int v7 = 0; true; ++v7) {
                if(v7 >= v6) {
                    v10 = v4;
                    v3 = v8;
                    v1 = v9;
                    break;
                }
                if(((a)object0).b(v7)) {
                    if(v9 < 100) {
                        ((a)object0).a(v7, d0);
                        this.a(et0, stringBuilder0, d0, v);
                        v4 = d0.b;
                        if(v9 == 0) {
                            v8 = v4;
                        }
                        ++v9;
                    }
                    ++v2;
                    if(v2 > 100) {
                        v10 = v4;
                        v3 = v8;
                        v1 = v9;
                        break;
                    }
                }
            }
        }
        else if(object0 instanceof e) {
            int v11 = ((e)object0).b();
            int v12 = 0;
            long v13 = 0L;
            while(true) {
                if(v12 >= v11) {
                    v10 = v4;
                    v3 = v13;
                    break;
                }
                if(((e)object0).d(v12)) {
                    qx qx0 = (qx)((e)object0).c(v12);
                    if(qx0 instanceof qx) {
                        if(v1 < 100) {
                            this.a(et0, stringBuilder0, qx0, v);
                            v4 = qx0.b;
                            long v15 = v1 == 0 ? v4 : v13;
                            ++v1;
                            v13 = v15;
                        }
                        ++v2;
                        if(v2 > 100) {
                            v10 = v4;
                            v3 = v13;
                            break;
                        }
                    }
                }
                v14 = v4;
                ++v12;
                v4 = v14;
            }
        }
        else if(object0 instanceof boolean[]) {
            ow ow0 = MainService.instance.K;
            int v16 = ((boolean[])object0).length - 1;
            long v18 = 0L;
            long v19 = 0L;
            for(int v17 = 1; true; ++v17) {
                if(v17 >= v16) {
                    v10 = v18;
                    v3 = v19;
                    break;
                }
                if(((boolean[])object0)[v17]) {
                    if(v1 < 100) {
                        d d1 = (d)ow0.getItem(v17);
                        this.a(et0, stringBuilder0, d1, v);
                        v20 = d1.b;
                        long v21 = v1 == 0 ? v20 : v19;
                        ++v1;
                        v19 = v21;
                    }
                    else {
                        v20 = v18;
                    }
                    ++v2;
                    if(v2 > 100) {
                        v10 = v20;
                        v3 = v19;
                        break;
                    }
                    v18 = v20;
                }
            }
        }
        else {
            v10 = 0L;
        }
        int v22 = et0 == null ? 2 : 1;
        if(v1 < v22) {
            Tools.b(Tools.a(qk.a(0x7F070167), new Object[]{v22}));  // string:need_select_more "Need select __d__ or more items."
            return;
        }
        if(v2 > v1) {
            Tools.b(Tools.a(qk.a(0x7F070166), new Object[]{v1}));  // string:used_only_first "Used only first __d__ items."
        }
        if(et0 != null) {
            switch(v5) {
                case 4: 
                case 5: {
                    stringBuilder0.append(((char)(v5 == 5 ? 58 : 59)));
                    stringBuilder0.append(new String(et0.a, 0, et0.b, ps.a(v5 == 5)));
                    break;
                }
                case 6: {
                    stringBuilder0.append('h');
                    char[] arr_c = iu.a;
                    byte[] arr_b = et0.a;
                    int v24 = et0.b;
                    for(int v23 = 0; v23 < v24; ++v23) {
                        stringBuilder0.append(' ');
                        int v25 = arr_b[v23];
                        stringBuilder0.append(arr_c[(v25 & 0xF0) >> 4]);
                        stringBuilder0.append(arr_c[v25 & 15]);
                    }
                    break;
                }
                default: {
                    stringBuilder0.append('Q');
                    stringBuilder0.append(' ');
                    iu.a(stringBuilder0, 0, et0.a, et0.b, v5 == 7 || v5 == 9, v5 == 8 || v5 == 9, null);
                }
            }
        }
        else if((v & 8) != 0) {
            stringBuilder0.append(':');
            stringBuilder0.append(v10 + 1L - v3);
        }
        String s = stringBuilder0.toString();
        er er0 = new er(this, s);
        if(et0 == null && v10 - v3 >= 0xFFFFL) {
            i.a(i.c().setMessage(Tools.a(qk.a(0x7F070346), new Object[]{((long)(v10 + 1L - v3)), 0xFFFF})).setPositiveButton(qk.a(0x7F07009D), new es(this, s, er0)).setNegativeButton(qk.a(0x7F0700A1), null));  // string:too_far "These values cannot be found through a group search, they are too 
                                                                                                                                                                                                                  // far apart: __d__ bytes. The maximum distance is __d__ bytes."
            return;
        }
        this.a(s, er0);
    }

    void a(String s, DialogInterface.OnClickListener dialogInterface$OnClickListener0) {
        i.a(i.c().setMessage(s).setPositiveButton(qk.a(0x7F070161), dialogInterface$OnClickListener0).setNeutralButton(qk.a(0x7F07008B), dialogInterface$OnClickListener0).setNegativeButton(qk.a(0x7F0700A1), null));  // string:copy "Copy"
    }

    @Override  // android.ext.pj
    public void onClick(View view0) {
        CharSequence[] arr_charSequence = {qk.a(0x7F070134), qk.a(0x7F070135), qk.a(0x7F070277), qk.a(0x7F070278), "UTF-8", "UTF-16LE", "HEX", "HEX + UTF-8", "HEX + UTF-16LE", "HEX + UTF-8 + UTF-16LE"};  // string:format_hex "Hex (little-endian) notation"
        int v = Config.y;
        boolean[] arr_z = new boolean[10];
        for(int v1 = 0; v1 < 10; ++v1) {
            arr_z[v1] = (1 << v1 & v) != 0;
        }
        ep ep0 = new ep(this, arr_z);
        i.a(i.a(Tools.o()).setCustomTitle(Tools.d(0x7F070276)).setMultiChoiceItems(arr_charSequence, arr_z, new eq(this, arr_z)).setPositiveButton(qk.a(0x7F07009B), ep0).setNegativeButton(qk.a(0x7F07009C), null));  // string:copy_as_search "Copy as a group search"
    }
}

