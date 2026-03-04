package android.ext;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

class tv extends ArrayAdapter {
    final tu a;

    tv(tu tu0, Context context0, e[] arr_e) {
        this.a = tu0;
        super(context0, arr_e);
    }

    @Override  // android.ext.ArrayAdapter
    public View getView(int v, View view0, ViewGroup viewGroup0) {
        View view1 = super.getView(v, view0, viewGroup0);
        TextView textView0 = (TextView)view1.findViewById(0x1020014);
        if(textView0 != null) {
            Tools.a(textView0, 0x7F090002);  // style:SmallText
            if(v >= 0 && v < this.a.a.length && this.a.a[v] != null) {
                textView0.setTextColor(d.k(this.a.a[v].a));
            }
        }
        return view1;
    }
}

