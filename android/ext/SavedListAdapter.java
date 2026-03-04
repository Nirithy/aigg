package android.ext;

import android.c.e;
import android.fix.i;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SavedListAdapter extends BaseAdapterIndexer implements uu, ListAdapter {
    static volatile int a;
    private final e b;
    private final h c;

    static {
        SavedListAdapter.a = 0;
    }

    public SavedListAdapter() {
        this.c = new h();
        this.b = new e();
        SavedListAdapter.a = Tools.s().getInt("saved-list-format", 0);
    }

    private View a(ViewGroup viewGroup0) {
        View view0 = i.a(0x7F040024, viewGroup0, false);  // layout:service_saved_item
        new qz(view0, this);
        return view0;
    }

    static void a() {
        String s;
        TextView textView0 = MainService.instance.w;
        if(textView0 != null) {
            if(SavedListAdapter.a == 0) {
                s = "   ";
            }
            else {
                s = Integer.bitCount(SavedListAdapter.a) == 1 ? "  " : "";
            }
            textView0.setText(Tools.a(new CharSequence[]{"F: ", ow.c(SavedListAdapter.a), s}));
        }
    }

    static void a(int v) {
        SavedListAdapter.a = v;
        new qw().a("saved-list-format", v, 0).commit();
        SavedListAdapter.a();
        MainService.instance.an.notifyDataSetChanged();
    }

    public static void a(ImageView imageView0, boolean z) {
        ViewGroup.LayoutParams viewGroup$LayoutParams0 = imageView0.getLayoutParams();
        int v = z ? 24 : 0x30;
        int v1 = Config.d();
        if(v1 > v) {
            v = v1;
        }
        int v2 = (int)Tools.a(v);
        viewGroup$LayoutParams0.height = v2;
        Config.a(imageView0, v2, v2, v1);
    }

    public qx a(long v) {
        qx qx0 = (qx)this.b.a(v);
        return qx0 == null ? null : qx0;
    }

    public void a(bk bk0) {
        bk0.g();
        boolean z = false;
        ListView listView0 = MainService.instance.I;
        int v = listView0.getFirstVisiblePosition();
        int v1 = listView0.getLastVisiblePosition();
        e e0 = this.b;
        while(true) {
            try {
            label_6:
                if(bk0.b() == 0) {
                    break;
                }
                long v2 = bk0.c();
                long v3 = bk0.d();
                int v4 = e0.c(v2);
                if(v4 < 0) {
                    goto label_6;
                }
                qx qx0 = (qx)e0.c(v4);
                if(qx0 == null || qx0.c == v3) {
                    goto label_6;
                }
                if(v <= v4 && v4 <= v1) {
                    z = true;
                }
                qx0.c = v3;
            }
            catch(IOException iOException0) {
                la.c("???", iOException0);
                break;
            }
        }
        if(z) {
            this.notifyDataSetChanged();
        }
    }

    public void a(qx qx0) {
        this.a(qx0, 0, true);
    }

    public void a(qx qx0, byte b, boolean z) {
        ex ex0 = MainService.instance.k;
        if((qx0.d & 0x40000000) == 0x40000000) {
            qx0 = qx0.s();
        }
        if(qx0.f) {
            qx0.d &= 0xBFFFFFFF;
            ex0.a(qx0);
        }
        else if((qx0.d & 0x40000000) == 0x40000000) {
            qx0.d &= 0xBFFFFFFF;
        }
        long v = qx0.f();
        qx qx1 = (qx)this.b.a(v, qx0, b);
        if(qx1 != null && qx1.f && !qx0.f) {
            ex0.b(qx0);
        }
        if(z) {
            this.notifyDataSetChanged();
        }
    }

    public void a(List list0) {
        e e0 = this.b;
        ex ex0 = MainService.instance.k;
        for(Object object0: list0) {
            qx qx0 = (qx)object0;
            if(qx0 != null) {
                qx qx1 = (qx)e0.b(qx0.f());
                if(qx1 != null && qx1.f) {
                    ex0.b(qx1);
                }
            }
        }
        ex0.m();
        if(e0.b() == 0) {
            this.e();
        }
        this.notifyDataSetChanged();
    }

    public void a(long[] arr_v, int v) {
        e e0 = this.b;
        ex ex0 = MainService.instance.k;
        for(int v1 = 0; v1 < v; ++v1) {
            qx qx0 = (qx)e0.b(arr_v[v1]);
            if(qx0 != null && qx0.f) {
                ex0.b(qx0);
            }
        }
        ex0.m();
        if(e0.b() == 0) {
            this.e();
        }
        this.notifyDataSetChanged();
    }

    public e b() {
        return this.b;
    }

    public qx b(int v) {
        return (qx)this.b.c(v);
    }

    public void b(long v) {
        int v1 = this.b.c(v);
        if(v1 >= 0) {
            this.c(v1);
        }
    }

    public void b(qx qx0) {
        this.b(qx0.f());
    }

    public void c() {
        MainService.instance.k.r();
        this.e();
        this.notifyDataSetChanged();
    }

    public void c(int v) {
        qx qx0 = (qx)this.b.a(v);
        if(qx0 != null) {
            if(qx0.f) {
                ex ex0 = MainService.instance.k;
                ex0.b(qx0);
                ex0.m();
            }
            if(this.b.b() == 0) {
                this.e();
            }
            this.notifyDataSetChanged();
        }
    }

    public void d() {
        ex ex0 = MainService.instance.k;
        ex0.m();
        e e0 = this.b;
        if(e0.b() == 0) {
            return;
        }
        else {
            try {
                ArrayList arrayList0 = new ArrayList(e0.b());
                for(int v1 = 0; true; ++v1) {
                    if(v1 >= e0.b()) {
                        if(arrayList0.size() == 0) {
                            break;
                        }
                        int v2 = arrayList0.size();
                        int[] arr_v = new int[v2];
                        long[] arr_v1 = new long[v2];
                        for(int v = 0; true; ++v) {
                            if(v >= v2) {
                                ex0.a(arr_v, arr_v1);
                                return;
                            }
                            d d0 = (d)arrayList0.get(v);
                            arr_v[v] = d0.d;
                            arr_v1[v] = d0.b;
                        }
                    }
                    try {
                        qx qx0 = (qx)e0.c(v1);
                        if(qx0 != null) {
                            arrayList0.add(qx0);
                        }
                    }
                    catch(IndexOutOfBoundsException indexOutOfBoundsException0) {
                        la.b("list changed", indexOutOfBoundsException0);
                    }
                }
                return;
            }
            catch(OutOfMemoryError outOfMemoryError0) {
            }
        }
        la.b("OOM in reloadData", outOfMemoryError0);
    }

    private void e() {
        this.b.c();
        MainService.instance.k.e.b();
    }

    @Override  // android.widget.Adapter
    public int getCount() {
        return this.b.b();
    }

    @Override  // android.widget.Adapter
    public Object getItem(int v) {
        return this.b(v);
    }

    @Override  // android.widget.Adapter
    public long getItemId(int v) {
        qx qx0 = (qx)this.b.c(v);
        return qx0 == null ? 0L : qx0.f();
    }

    @Override  // android.widget.Adapter
    public View getView(int v, View view0, ViewGroup viewGroup0) {
        qx qx0;
        boolean z1;
        qz qz1;
        if(view0 == null) {
            view0 = this.a(viewGroup0);
        }
        qz qz0 = (qz)view0.getTag();
        if(qz0.a()) {
            view0 = this.a(viewGroup0);
            qz1 = (qz)view0.getTag();
        }
        else {
            qz1 = qz0;
        }
        boolean z = (Config.q & 1 << Tools.t() + 2) != 0;
        if(v >= this.b.b()) {
            z1 = false;
            qx0 = new qx(0L, 0L, 4, "null for " + v);
        }
        else {
            qx qx1 = (qx)this.b.c(v);
            z1 = this.b.d(v);
            qx0 = qx1;
        }
        qz1.o = v;
        SavedListAdapter.a(qz1.a, z);
        qz1.b.getLayoutParams().width = z ? -2 : -1;
        qz1.q.setOrientation((z ? 0 : 1));
        SavedListAdapter.a(qz1.s, z);
        ViewGroup.LayoutParams viewGroup$LayoutParams0 = qz1.c.getLayoutParams();
        viewGroup$LayoutParams0.height = z ? -2 : Tools.b();
        qz1.a.setTag(qx0);
        if(qz1.c.isChecked() != z1) {
            qz1.c.setOnCheckedChangeListener(null);
            qz1.c.setChecked(z1);
        }
        qz1.c.setOnCheckedChangeListener(this);
        qz1.r.setTag(qx0);
        qz1.s.setTag(qx0);
        qz1.a(z1, -2);
        int v1 = qx0.o();
        qz1.p.setTextColor(v1);
        qz1.r.setTextColor(v1);
        String s = qx0.h();
        h h0 = this.c;
        MainService.instance.ao.a(qx0.b, qx0.d, h0);
        if(h0.b) {
            s = s + " (" + d.b(qx0.b, h0.a, qx0.d) + ')';
        }
        String s1 = qx0.t();
        qz1.b.setText(s1);
        qz1.r.setText(qx0.l());
        qz1.l.setText(RegionList.a(qx0.b));
        qz1.d.setText(qx0.g() + ": ");
        qz1.p.setText(s);
        int v2 = qx0.u();
        qz1.a.setImageResource(v2);
        ow.a(qz1, qx0.b, qx0.c, SavedListAdapter.a, true, qx0.d());
        return view0;
    }

    @Override  // android.widget.Adapter, android.widget.BaseAdapter
    public boolean hasStableIds() {
        return false;
    }

    @Override  // android.widget.CompoundButton$OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton0, boolean z) {
        uq uq0 = (uq)compoundButton0.getTag();
        if(uq0 == null) {
            return;
        }
        try {
            this.b.a(uq0.o, z);
            MainService.instance.E();
        }
        catch(IndexOutOfBoundsException indexOutOfBoundsException0) {
            la.c("ArrayAdapter onCheckedChanged failed", indexOutOfBoundsException0);
        }
        uq0.a(z, -2);
    }

    @Override  // android.view.View$OnClickListener
    public void onClick(View view0) {
        switch(view0.getId()) {
            case 0x7F0B0049: {  // id:address
                uq uq0 = (uq)view0.getTag();
                if(uq0 != null) {
                    Tools.f(uq0.c);
                    return;
                }
                break;
            }
            case 0x7F0B0076: {  // id:addr_item_remove
                qx qx1 = (qx)view0.getTag();
                if(qx1 != null) {
                    try {
                        android.ext.i.a(android.ext.i.c().setCustomTitle(Tools.i(qx1.t())).setMessage(qk.a(0x7F0700B0)).setPositiveButton(qk.a(0x7F07009B), new qy(this, qx1)).setNegativeButton(qk.a(0x7F07009C), null));  // string:delete_prompt "Do you want to remove this item?"
                    }
                    catch(IndexOutOfBoundsException indexOutOfBoundsException0) {
                        la.c("SavedListAdapter onClick Failed", indexOutOfBoundsException0);
                    }
                    return;
                }
                break;
            }
            case 0x7F0B0101: {  // id:freeze
                qx qx0 = ((qx)view0.getTag()).s();
                qx0.f = !qx0.f;
                this.a(qx0);
                if(view0 instanceof ImageButton) {
                    ((ImageButton)view0).setImageResource(qx0.u());
                }
                MainService.instance.k.m();
            }
        }
    }
}

