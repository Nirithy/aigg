package android.ext;

import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.fix.i;
import android.view.View.OnClickListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.TextView;
import java.lang.ref.WeakReference;

public class TimersEditor implements DialogInterface.OnClickListener, View.OnClickListener, CompoundButton.OnCheckedChangeListener {
    private static final int[] a;
    private final boolean[] b;
    private final boolean[] c;
    private final boolean[] d;
    private final int e;
    private final String f;
    private final String g;
    private final boolean[] h;
    private final int i;
    private WeakReference j;

    static {
        TimersEditor.a = new int[]{0x7F0B0148, 0x7F0B0149, 0x7F0B014A, 0x7F0B014B};  // id:app
    }

    public TimersEditor(String s, String s1, int v, boolean[] arr_z, int v1) {
        this.j = new WeakReference(null);
        this.f = s;
        this.g = s1;
        this.e = v;
        this.h = arr_z;
        this.i = v1;
        this.b = new boolean[v];
        this.c = new boolean[4];
        this.d = new boolean[v * 12];
        la.a((String.valueOf(s) + ':'));
        this.c();
    }

    View a(int v, View view0, ViewGroup viewGroup0) {
        i i0 = i.a();
        if(view0 == null || view0.getId() != 0x7F04002C) {  // layout:timer_row
            view0 = i0.inflate(0x7F04002C, viewGroup0, false);  // layout:timer_row
            view0.setId(0x7F04002C);  // layout:timer_row
            View[] arr_view = new View[5];
            for(int v1 = 0; v1 < 4; ++v1) {
                CheckBox checkBox0 = (CheckBox)view0.findViewById(TimersEditor.a[v1]);
                checkBox0.setFocusable(true);
                checkBox0.setOnCheckedChangeListener(this);
                arr_view[v1] = checkBox0;
            }
            TextView textView0 = (TextView)view0.findViewById(0x7F0B0051);  // id:name
            textView0.setPaintFlags(textView0.getPaintFlags() | 8);
            textView0.setOnClickListener(this);
            textView0.setFocusable(true);
            arr_view[4] = textView0;
            view0.setTag(arr_view);
        }
        View[] arr_view1 = (View[])view0.getTag();
        for(int v2 = 0; v2 < 4; ++v2) {
            CheckBox checkBox1 = (CheckBox)arr_view1[v2];
            checkBox1.setTag(null);
            checkBox1.setChecked(this.d[-10 + 12 * v + 3 * v2]);
            checkBox1.setTag(((int)((v - 1) * 4 + v2)));
            checkBox1.setBackgroundColor((this.d[-11 + 12 * v + 3 * v2] ? 0xFF005500 : 0xFF550000));
        }
        TextView textView1 = (TextView)arr_view1[4];
        textView1.setTag(((int)(v - 1)));
        textView1.setText(Integer.toString(v));
        return view0;
    }

    View a(View view0, ViewGroup viewGroup0) {
        if(view0 == null || view0.getId() != 0x7F04002B) {  // layout:timer_header
            view0 = i.a(0x7F04002B, viewGroup0, false);  // layout:timer_header
            view0.setId(0x7F04002B);  // layout:timer_header
            for(int v = 0; v < 4; ++v) {
                TextView textView0 = (TextView)view0.findViewById(TimersEditor.a[v]);
                textView0.setTag(v);
                textView0.setOnClickListener(this);
                textView0.setPaintFlags(textView0.getPaintFlags() | 8);
                textView0.setFocusable(true);
            }
        }
        return view0;
    }

    public void a() {
        this.b();
        MainService.instance.k.b(this.i);
        android.ext.i.c(android.ext.i.c().setView(Tools.d(this.d())).setNeutralButton(qk.a(0x7F07023E), this).setNegativeButton(qk.a(0x7F0700A1), null).setPositiveButton(qk.a(0x7F07008C), this).create());  // string:reset_button "Reset"
    }

    public void a(boolean[] arr_z) {
        boolean[] arr_z1 = this.d;
        StringBuilder stringBuilder0 = new StringBuilder();
        for(int v = 0; v < this.e * 4; ++v) {
            if(v % 4 == 0) {
                stringBuilder0.append(' ');
                stringBuilder0.append(v / 4 + 1);
                stringBuilder0.append(':');
            }
            boolean z = arr_z[v];
            arr_z1[v * 3 + 1] = z;
            if(z) {
                stringBuilder0.append('1');
            }
            else {
                stringBuilder0.append('0');
            }
        }
        la.a((this.f + " usage:" + stringBuilder0.toString()));
        this.e();
    }

    public void b() {
        qh qh0 = MainService.instance.ap;
        if(qh0 == null) {
            return;
        }
        boolean[] arr_z = this.d;
        SharedPreferences sharedPreferences0 = Tools.s();
        String s = String.valueOf(this.g) + '-' + qh0.c + '-';
        boolean[] arr_z1 = this.h;
        for(int v = 0; v < this.e * 4; ++v) {
            try {
                arr_z[v * 3] = sharedPreferences0.getBoolean(String.valueOf(s) + v, arr_z1[v]);
            }
            catch(Throwable unused_ex) {
                int v1 = sharedPreferences0.getInt(String.valueOf(s) + v, (arr_z1[v] ? 1 : 0));
                arr_z[v * 3] = v1 == 0 || v1 == 1 ? v1 != 0 : arr_z1[v];
            }
        }
        this.c();
    }

    public boolean[] c() {
        boolean[] arr_z = this.d;
        boolean[] arr_z1 = new boolean[this.e * 4];
        StringBuilder stringBuilder0 = new StringBuilder();
        for(int v = 0; v < this.e * 4; ++v) {
            if(v % 4 == 0) {
                stringBuilder0.append(' ');
                stringBuilder0.append(v / 4 + 1);
                stringBuilder0.append(':');
            }
            if(arr_z[v * 3]) {
                arr_z1[v] = true;
                stringBuilder0.append('1');
            }
            else {
                stringBuilder0.append('0');
            }
        }
        la.a((this.f + " get:" + stringBuilder0.toString()));
        return arr_z1;
    }

    private View d() {
        boolean[] arr_z = this.d;
        for(int v = 0; v < this.e * 4; ++v) {
            arr_z[v * 3 + 2] = arr_z[v * 3];
        }
        View view0 = i.a(0x7F04002D, null);  // layout:timer_table
        new FastScrollerFix(((ListView)view0));
        ((ListView)view0).setItemsCanFocus(true);
        se se0 = new se(this);
        ((ListView)view0).setAdapter(se0);
        this.j = new WeakReference(se0);
        return view0;
    }

    private void e() {
        BaseAdapter baseAdapter0 = (BaseAdapter)this.j.get();
        if(baseAdapter0 != null) {
            baseAdapter0.notifyDataSetChanged();
        }
    }

    private void f() {
        qh qh0 = MainService.instance.ap;
        if(qh0 == null) {
            return;
        }
        boolean[] arr_z = this.d;
        qw qw0 = new qw();
        String s = String.valueOf(this.g) + '-' + qh0.c + '-';
        boolean[] arr_z1 = this.h;
        for(int v = 0; v < this.e * 4; ++v) {
            qw0.a(String.valueOf(s) + v, arr_z[v * 3], arr_z1[v]);
        }
        qw0.commit();
    }

    @Override  // android.widget.CompoundButton$OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton0, boolean z) {
        if(compoundButton0 != null) {
            Object object0 = compoundButton0.getTag();
            if(object0 != null && object0 instanceof Integer) {
                this.d[((int)(((Integer)object0))) * 3 + 2] = z;
            }
        }
    }

    @Override  // android.content.DialogInterface$OnClickListener
    public void onClick(DialogInterface dialogInterface0, int v) {
        boolean[] arr_z = this.d;
        if(v == -3) {
            boolean[] arr_z1 = this.h;
            for(int v2 = 0; v2 < this.e * 4; ++v2) {
                arr_z[v2 * 3 + 2] = arr_z1[v2];
            }
        }
        for(int v1 = 0; v1 < this.e * 4; ++v1) {
            arr_z[v1 * 3] = arr_z[v1 * 3 + 2];
        }
        this.f();
        MainService.instance.k.a(this.i);
    }

    @Override  // android.view.View$OnClickListener
    public void onClick(View view0) {
        boolean z = true;
        int v = 0;
        if(view0.getId() == 0x7F0B0051) {  // id:name
            int v2 = (int)(((Integer)view0.getTag()));
            this.b[v2] = !this.b[v2];
            while(v < 4) {
                this.d[(v2 * 4 + v) * 3 + 2] = this.b[v2];
                ++v;
            }
        }
        else {
            int v1 = (int)(((Integer)view0.getTag()));
            boolean[] arr_z = this.c;
            if(this.c[v1]) {
                z = false;
            }
            arr_z[v1] = z;
            while(v < this.e) {
                this.d[(v * 4 + v1) * 3 + 2] = this.c[v1];
                ++v;
            }
        }
        this.e();
    }
}

