package android.ext;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

class se extends BaseAdapter {
    final TimersEditor a;

    se(TimersEditor timersEditor0) {
        this.a = timersEditor0;
        super();
    }

    @Override  // android.widget.Adapter
    public int getCount() {
        return this.a.e + 1;
    }

    @Override  // android.widget.Adapter
    public Object getItem(int v) {
        return v;
    }

    @Override  // android.widget.Adapter
    public long getItemId(int v) {
        return (long)v;
    }

    @Override  // android.widget.Adapter
    public View getView(int v, View view0, ViewGroup viewGroup0) {
        return v == 0 ? this.a.a(view0, viewGroup0) : this.a.a(v, view0, viewGroup0);
    }
}

