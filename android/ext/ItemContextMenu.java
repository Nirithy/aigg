package android.ext;

import android.view.View;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.AdapterView;
import java.util.ArrayList;

public class ItemContextMenu implements AdapterView.OnItemLongClickListener {
    private static final ThreadLocal a;
    private final int b;
    private final int[] c;
    private final String[] d;
    private final String[] e;
    private final String[] f;

    static {
        ItemContextMenu.a = new ThreadLocal();
    }

    public ItemContextMenu(int v) {
        this.b = v;
        this.c = new int[]{0, 4, 16, 0x40, 2, 1, 0x20, 8};
        this.d = new String[this.c.length];
        this.e = new String[this.c.length];
        this.f = new String[this.c.length];
    }

    public static long a(long v) {
        ItemContextMenu.a.set(v);
        return v;
    }

    @Override  // android.widget.AdapterView$OnItemLongClickListener
    public boolean onItemLongClick(AdapterView adapterView0, View view0, int v, long v1) {
        String s15;
        String s7;
        int v10;
        int v6;
        Object object0 = adapterView0.getItemAtPosition(v);
        if(!(object0 instanceof d)) {
            return false;
        }
        qx qx0 = new qx(((d)object0));
        String s = qx0.g();
        long v2 = qx0.b;
        int v3 = qx0.d & 0x7F;
        long v4 = qx0.c;
        qh qh0 = MainService.instance.ap;
        int v5 = this.b == 3 ? 8 : d.d(v3);
        if((3L & v2) == 0L && v5 >= 4) {
            v6 = qh0 == null || !qh0.n || v5 != 8 || (0xFFFFFFFF00000000L & v4) == 0L ? 1 : 2;
        }
        else {
            v6 = 0;
        }
        boolean z = (v3 & -81) != 0;
        ArrayList arrayList0 = new ArrayList();
        ArrayList arrayList1 = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        arrayList0.add(s);
        arrayList1.add(qk.a(0x7F07016C));  // string:offset_calculator "Offset calculator"
        arrayList2.add(0x7F020010);  // drawable:ic_calculator_white_24dp
        arrayList0.add(s);
        arrayList1.add(qk.a(0x7F070259));  // string:help_pointer_search_title "Pointer search"
        arrayList2.add(0x7F020040);  // drawable:ic_pointer_white_24dp
        arrayList0.add(s);
        arrayList1.add(qk.a(0x7F07034D));  // string:search_nearby "Search nearby"
        arrayList2.add(0x7F020046);  // drawable:ic_search_nearby_white_24dp
        if(adapterView0 != MainService.instance.J) {
            arrayList0.add(s);
            arrayList1.add(qk.a(0x7F070100) + ' ' + s);  // string:goto_address "Go to the address:"
            arrayList2.add(0x7F02002A);  // drawable:ic_forward_white_24dp
        }
        for(int v7 = 0; v7 < v6; ++v7) {
            int v8 = v7 == 0 ? 4 : 0x20;
            String s1 = d.d(v2, v4, v8);
            arrayList0.add(s1);
            arrayList1.add(qk.a(0x7F07016B) + ' ' + s1);  // string:goto_pointer "Go to the pointer:"
            arrayList2.add(0x7F02002A);  // drawable:ic_forward_white_24dp
            if((0xFFFFFFFFFFFFF000L & v4) != 0L && RegionList.b(0xFFFFFFFFFFFFF000L & v4) == null) {
                String s2 = d.d(v2, 0xFFFFFFFFFFFFF000L & v4, v8);
                arrayList0.add(s2);
                arrayList1.add(Tools.c(0x7F0702DD) + ": " + s2);  // string:allocate_page "Allocate memory page"
                arrayList2.add(0x7F020015);  // drawable:ic_code_braces_white_24dp
            }
        }
        if((0xFFFFFFFFFFFFF000L & v2) != 0L && RegionList.b(0xFFFFFFFFFFFFF000L & v2) == null) {
            String s3 = d.b(0xFFFFFFFFFFFFF000L & v2, 4);
            arrayList0.add(s3);
            arrayList1.add(Tools.c(0x7F0702DD) + ": " + s3);  // string:allocate_page "Allocate memory page"
            arrayList2.add(0x7F020015);  // drawable:ic_code_braces_white_24dp
        }
        arrayList0.add(s);
        arrayList1.add(qk.a(0x7F0700FF) + ' ' + s);  // string:copy_address "Copy the address:"
        arrayList2.add(0x7F020016);  // drawable:ic_content_copy_white_24dp
        String s4 = null;
        String s5 = null;
        String s6 = null;
        int v9 = MainService.instance.r();
        if(v9 == 1) {
            v10 = AddressArrayAdapter.a;
        }
        else {
            switch(v9) {
                case 2: {
                    v10 = SavedListAdapter.a;
                    break;
                }
                case 3: {
                    v10 = MainService.instance.K.c;
                    break;
                }
                default: {
                    v10 = 0;
                }
            }
        }
        if(v10 != 0) {
            int v11 = 0;
            while(v11 < 3) {
                if(v11 != 0) {
                    if(v11 == 1) {
                        if((1L & v2) != 0L) {
                            ++v11;
                            continue;
                        }
                        else if((v10 & 0x20) == 0) {
                            s7 = s5;
                            goto label_115;
                        }
                    }
                    if(v11 == 2) {
                        if((3L & v2) != 0L) {
                            s7 = s5;
                            goto label_115;
                        }
                        else if((v10 & 0x40) == 0) {
                            s7 = s5;
                            goto label_115;
                        }
                    }
                    ItemContextMenu.a.set(0L);
                    if(v11 == 0) {
                        s4 = ai.a(null, v2, v4);
                    }
                    s7 = v11 == 1 ? ai.b(null, v2, v4) : s5;
                    String s8 = v11 == 2 ? ag.a(ag.a(), v2, ((int)v4), new StringBuilder()).toString() : s6;
                    String s9 = null;
                    long v12 = (long)(((Long)ItemContextMenu.a.get()));
                    if(v12 != 0L) {
                        if(v11 == 0) {
                            s9 = "ARM (x32)";
                        }
                        if(v11 == 1) {
                            s9 = "Thumb";
                        }
                        if(v11 == 2) {
                            s9 = "ARM (x64)";
                        }
                        String s10 = d.b(v12, 4);
                        arrayList0.add(s10);
                        arrayList1.add(s9 + ": " + qk.a(0x7F070100) + ' ' + s10);  // string:goto_address "Go to the address:"
                        arrayList2.add(0x7F02002A);  // drawable:ic_forward_white_24dp
                        arrayList0.add(s10);
                        arrayList1.add(s9 + ": " + qk.a(0x7F0700FF) + ' ' + s10);  // string:copy_address "Copy the address:"
                        arrayList2.add(0x7F020016);  // drawable:ic_content_copy_white_24dp
                        if((v12 & 0xFFFFFFFFFFFFF000L) != 0L && RegionList.b(v12 & 0xFFFFFFFFFFFFF000L) == null) {
                            String s11 = d.b(v12 & 0xFFFFFFFFFFFFF000L, 4);
                            arrayList0.add(s11);
                            arrayList1.add(s9 + ": " + Tools.c(0x7F0702DD) + ": " + s11);  // string:allocate_page "Allocate memory page"
                            arrayList2.add(0x7F020015);  // drawable:ic_code_braces_white_24dp
                        }
                    }
                    s6 = s8;
                }
                else if((3L & v2) != 0L) {
                    ++v11;
                    continue;
                }
                else if((v10 & 16) == 0) {
                    s7 = s5;
                }
            label_115:
                ++v11;
                s5 = s7;
            }
        }
        int v13 = 0;
        int[] arr_v = this.c;
        String[] arr_s = this.d;
        String[] arr_s1 = this.e;
        String[] arr_s2 = this.f;
        for(int v14 = 0; v14 < arr_v.length; ++v14) {
            int v15 = arr_v[v14];
            if(v15 == 0 || (v3 & v15) != 0) {
                if(v15 == 0) {
                    v15 = v3;
                }
                String s12 = d.a(v2, v4, v15);
                boolean z1 = false;
                for(int v16 = 0; v16 < v13; ++v16) {
                    if(arr_s[v16].equals(s12)) {
                        z1 = true;
                        break;
                    }
                }
                if(!z1) {
                    arr_s[v13] = s12;
                    if(z) {
                        arr_s1[v13] = (v15 & -81) == 0 ? null : d.d(v2, v4, v15);
                        arr_s2[v13] = (v15 & -81) == 0 ? null : d.c(v2, v4, v15);
                    }
                    ++v13;
                }
            }
        }
        if(v13 > 0) {
            for(int v17 = 0; v17 < v13; ++v17) {
                arrayList0.add(arr_s[v17]);
                arrayList1.add(qk.a(0x7F0700FE) + ' ' + arr_s[v17]);  // string:copy_value "Copy the value:"
                arrayList2.add(0x7F020016);  // drawable:ic_content_copy_white_24dp
                if(z && arr_s1[v17] != null) {
                    arrayList0.add(arr_s1[v17]);
                    arrayList1.add(qk.a(0x7F07016A) + ' ' + arr_s1[v17]);  // string:copy_hex_value "Copy the hex value:"
                    arrayList2.add(0x7F020016);  // drawable:ic_content_copy_white_24dp
                    arrayList0.add(arr_s2[v17]);
                    arrayList1.add(qk.a(0x7F070279) + ' ' + arr_s2[v17]);  // string:copy_rhex_value "Copy the reverse hex value:"
                    arrayList2.add(0x7F020016);  // drawable:ic_content_copy_white_24dp
                }
            }
        }
        for(int v18 = 0; v18 < 3; ++v18) {
            String s13 = null;
            String s14 = null;
            if(v18 == 0) {
                s14 = "ARM (x32)";
                s13 = s4;
            }
            if(v18 == 1) {
                s14 = "Thumb";
                s13 = s5;
            }
            if(v18 == 2) {
                s15 = "ARM (x64)";
                s13 = s6;
            }
            else {
                s15 = s14;
            }
            if(s13 != null) {
                String s16 = s13.trim();
                int v19 = s16.indexOf(59);
                if(v19 != -1) {
                    s16 = s16.substring(0, v19).trim();
                }
                if(s16.length() > 0) {
                    arrayList0.add(s16);
                    arrayList1.add(Tools.a(qk.a(0x7F07034C), new Object[]{s15}) + ' ' + s16);  // string:copy_opcode "Copy __s__ opcode:"
                    arrayList2.add(0x7F020016);  // drawable:ic_content_copy_white_24dp
                }
            }
        }
        if(adapterView0 == MainService.instance.I) {
            arrayList0.add(s);
            arrayList1.add(qk.a(0x7F0702F8));  // string:change_address_type "Change address / type"
            arrayList2.add(0x7F020019);  // drawable:ic_cursor_mover_white_24dp
        }
        kv kv0 = new kv(this, MainService.context, arrayList1, arrayList2);
        i.a(i.a(Tools.o()).setAdapter(kv0, new kw(this, arrayList2, arrayList0, ((d)object0))).setNegativeButton(qk.a(0x7F0700A1), null));  // string:cancel "Cancel"
        return true;
    }
}

