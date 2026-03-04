package android.ext;

import android.content.SharedPreferences;
import android.view.View;
import android.widget.EditText;
import java.util.LinkedList;
import java.util.ListIterator;

public class iw {
    static final LinkedList a;
    static int b;

    static {
        iw.a = new LinkedList();
        iw.b = 0;
    }

    private static int a(int v) {
        int v1 = v >> 1 | v;
        int v2 = v1 | v1 >> 2;
        int v3 = v2 | v2 >> 4;
        int v4 = v3 | v3 >> 8;
        return (v4 | v4 >> 16) + 1;
    }

    public static void a() {
        iw.e();
    }

    public static void a(EditText editText0) {
        iy iy0 = new iy(Tools.o(), (editText0 instanceof ha ? ((ha)editText0).getDataType() : -1));
        if(iy0.getCount() == 0) {
            Tools.a(0x7F07011B);  // string:history_empty "History is empty"
            return;
        }
        iy.a = false;
        View view0 = Tools.b(qk.a(0x7F07011A), qk.a(0x7F070285));  // string:history "History"
        view0.setOnClickListener(iy0);
        iy0.b = i.a(Tools.o()).setCustomTitle(view0).setAdapter(iy0, new ix(iy0, editText0)).create();
        i.c(iy0.b);
    }

    public static void a(String s, byte b, int v) {
        int v2;
        if(s == null || s.length() == 0 || "0".equals(s) || "-1".equals(s) || "1".equals(s)) {
            return;
        }
        je je0 = new je(s, v, "...");
        int v1 = 0;
        ListIterator listIterator0 = iw.a.listIterator();
        while(listIterator0.hasNext()) {
            je je1 = (je)listIterator0.next();
            if(je1.equals(je0)) {
                je0.d = je1.d;
                listIterator0.remove();
                if(v1 >= iw.b) {
                    break;
                }
                --iw.b;
                if(b != 0) {
                    break;
                }
                v2 = 1;
                goto label_18;
            }
            ++v1;
        }
        v2 = b;
    label_18:
        if(v2 == 0) {
            v2 = 2;
        }
        if(v2 == 1) {
            iw.a.addFirst(je0);
            ++iw.b;
        }
        else {
            iw.c();
            iw.a.add(iw.b, je0);
        }
        iw.f();
        iw.b();
    }

    public static void a(String s, int v) {
        iw.a(s, 0, v);
    }

    static void b() {
        SharedPreferences sharedPreferences0 = Tools.s();
        if(sharedPreferences0 == null) {
            return;
        }
        qw qw0 = new qw(sharedPreferences0.edit());
        int v = 0;
        for(Object object0: iw.a) {
            qw0.a("history-" + v, ((je)object0).a);
            qw0.a("h-" + v, ((je)object0).b, 1);
            qw0.a("hi-" + v, ((je)object0).d, "...");
            ++v;
        }
        qw0.a("history-size", v, 0);
        qw0.a("history-sticked", iw.b, 0);
        qw0.commit();
    }

    static void c() {
        int v = iw.b;
        if(v < 0) {
            iw.b = 0;
            return;
        }
        int v1 = iw.a.size();
        if(v > v1) {
            iw.b = v1;
        }
    }

    public static void d() {
        iw.a.clear();
        iw.c();
    }

    private static void e() {
        SharedPreferences sharedPreferences0 = Tools.s();
        if(sharedPreferences0 == null) {
            return;
        }
        LinkedList linkedList0 = iw.a;
        int v = sharedPreferences0.getInt("history-size", 0);
        int v1 = v <= Config.x ? v : Config.x;
        boolean[] arr_z = new boolean[iw.a(v1)];
        int v2 = arr_z.length - 1;
        int v3 = 0;
        while(v3 < v) {
            String s = sharedPreferences0.getString("history-" + v3, null);
            if(s != null && s.length() != 0) {
                int v4 = sharedPreferences0.getInt("h-" + v3, 1);
                if(v4 == 0) {
                    v4 = 1;
                }
                je je0 = new je(s, v4, sharedPreferences0.getString("hi-" + v3, "..."));
                int v5 = je0.hashCode() & v2;
                if(!arr_z[v5]) {
                    arr_z[v5] = true;
                label_21:
                    linkedList0.addLast(je0);
                    if(linkedList0.size() < v1) {
                        goto label_23;
                    }
                    break;
                }
                else if(linkedList0.indexOf(je0) == -1) {
                    goto label_21;
                }
            }
        label_23:
            ++v3;
        }
        iw.b = sharedPreferences0.getInt("history-sticked", 0);
        iw.c();
        iw.f();
    }

    private static void f() {
        LinkedList linkedList0 = iw.a;
        int v = Config.x;
        if(linkedList0.size() <= v) {
            return;
        }
        for(int v1 = linkedList0.size() - v; v1 > 0; --v1) {
            linkedList0.removeLast();
        }
        iw.c();
    }
}

