package android.ext;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

class mt extends ArrayAdapter {
    final ms a;

    mt(ms ms0, Context context0, pj[] arr_pj) {
        this.a = ms0;
        super(context0, arr_pj);
    }

    @Override  // android.ext.ArrayAdapter
    public View getView(int v, View view0, ViewGroup viewGroup0) {
        View view1 = super.getView(v, view0, viewGroup0);
        TextView textView0 = (TextView)view1.findViewById(0x1020014);
        if(textView0 != null) {
            Tools.a(textView0, 0x7F090002);  // style:SmallText
        }
        return view1;
    }
}

