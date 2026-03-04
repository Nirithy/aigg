package android.ext;

import android.fix.i;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;
import java.io.File;

class hb extends BaseAdapter implements Filterable {
    final Filter a;
    final EditTextPath b;
    private File[] c;

    public hb(EditTextPath editTextPath0) {
        this.b = editTextPath0;
        super();
        this.c = null;
        this.a = new hc(this);
    }

    @Override  // android.widget.Adapter
    public int getCount() {
        return this.c == null ? 0 : this.c.length;
    }

    @Override  // android.widget.Filterable
    public Filter getFilter() {
        return this.a;
    }

    @Override  // android.widget.Adapter
    public Object getItem(int v) {
        File[] arr_file = this.c;
        return arr_file == null || v < 0 || v >= arr_file.length ? null : arr_file[v];
    }

    @Override  // android.widget.Adapter
    public long getItemId(int v) {
        return (long)v;
    }

    @Override  // android.widget.Adapter
    public View getView(int v, View view0, ViewGroup viewGroup0) {
        if(view0 == null) {
            view0 = i.a(0x7F040012, viewGroup0, false);  // layout:path_suggestion
        }
        Object object0 = this.getItem(v);
        if(object0 instanceof File) {
            ((TextView)view0.findViewById(0x7F0B0059)).setText(".../" + ((File)object0).getName());  // id:text1
        }
        return view0;
    }
}

