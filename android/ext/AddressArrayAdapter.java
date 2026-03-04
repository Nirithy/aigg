package android.ext;

import android.c.a;
import android.fix.i;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import java.util.ArrayList;

public class AddressArrayAdapter extends BaseAdapterIndexer implements uu {
    static volatile int a;
    private a b;
    private final h c;
    private d d;

    static {
        AddressArrayAdapter.a = 0;
    }

    public AddressArrayAdapter(a a0) {
        this.c = new h();
        this.d = new d();
        this.b = a0;
        AddressArrayAdapter.a = Tools.s().getInt("search-results-format", 0);
    }

    private View a(ViewGroup viewGroup0) {
        View view0 = i.a(0x7F040018, viewGroup0, false);  // layout:service_address_item
        new ut(view0, this);
        return view0;
    }

    static void a(int v) {
        AddressArrayAdapter.a = v;
        new qw().a("search-results-format", v, 0).commit();
    }

    @Override  // android.widget.Adapter
    public int getCount() {
        return this.b.b();
    }

    @Override  // android.widget.Adapter
    public Object getItem(int v) {
        try {
            return this.b.a(v, null);
        }
        catch(IndexOutOfBoundsException indexOutOfBoundsException0) {
            la.b("Failed get item in memory list", indexOutOfBoundsException0);
            return null;
        }
    }

    @Override  // android.widget.Adapter
    public long getItemId(int v) {
        return (long)v;
    }

    @Override  // android.widget.Adapter
    public View getView(int v, View view0, ViewGroup viewGroup0) {
        boolean z1;
        ut ut1;
        d d0 = null;
        if(view0 == null || view0.getTag() == null) {
            view0 = this.a(viewGroup0);
        }
        boolean z = (Config.q & 1 << Tools.t()) != 0;
        ut ut0 = (ut)view0.getTag();
        if(ut0.a()) {
            view0 = this.a(viewGroup0);
            ut1 = (ut)view0.getTag();
        }
        else {
            ut1 = ut0;
        }
        ut1.o = v;
        ut1.s.setTag(v);
        ut1.r.setTag(v);
        a a0 = this.b;
        if(a0.b() > v) {
            try {
                d d1 = a0.a(v, this.d);
                z1 = a0.b(v);
                d0 = d1;
            }
            catch(IndexOutOfBoundsException unused_ex) {
                z1 = false;
            }
        }
        else {
            z1 = false;
        }
        ut1.q.setOrientation((z ? 0 : 1));
        SavedListAdapter.a(ut1.s, z);
        ut1.c.setChecked(z1);
        ViewGroup.LayoutParams viewGroup$LayoutParams0 = ut1.c.getLayoutParams();
        viewGroup$LayoutParams0.height = z ? -2 : Tools.b();
        ut1.a(z1, -2);
        if(d0 != null) {
            int v1 = d0.o();
            ut1.p.setTextColor(v1);
            ut1.r.setTextColor(v1);
            String s = d0.i();
            h h0 = this.c;
            MainService.instance.ao.a(d0.b, d0.d, h0);
            if(h0.b) {
                s = s + " (" + d.b(d0.b, h0.a, d0.d) + ')';
            }
            ut1.d.setText("00000000");
            ut1.p.setText(s);
            CharSequence charSequence0 = d0.l();
            ut1.r.setText(charSequence0);
            ut1.l.setText(RegionList.a(d0.b));
            ow.a(ut1, d0.b, d0.c, AddressArrayAdapter.a, true, d0.d());
            return view0;
        }
        ut1.d.setText("null");
        ut1.p.setText("null");
        ut1.r.setText("null");
        ut1.l.setText("null");
        ow.a(ut1, 0L, 0L, 0, false, 0);
        return view0;
    }

    @Override  // android.widget.BaseAdapter
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
        Integer integer0 = (Integer)view0.getTag();
        if(integer0 == null) {
            return;
        }
        try {
            d d0 = this.b.a(((int)integer0), this.d);
            ArrayList arrayList0 = new ArrayList();
            arrayList0.add(d0);
            MainService.instance.k.a(arrayList0);
        }
        catch(IndexOutOfBoundsException indexOutOfBoundsException0) {
            la.c("ArrayAdapter onClick Failed", indexOutOfBoundsException0);
        }
        MainService.instance.j(false);
    }
}

