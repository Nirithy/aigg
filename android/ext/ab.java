package android.ext;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.List;

class ab extends ArrayAdapter {
    final z a;
    private final List b;

    ab(z z0, Context context0, List list0, List list1) {
        this.a = z0;
        this.b = list1;
        super(context0, list0);
    }

    @Override  // android.ext.ArrayAdapter
    public View getView(int v, View view0, ViewGroup viewGroup0) {
        View view1 = super.getView(v, view0, viewGroup0);
        TextView textView0 = (TextView)view1.findViewById(0x1020014);
        if(textView0 != null) {
            qh qh0 = (qh)this.b.get(v);
            if(qh0 != null) {
                try {
                    textView0.setText(qh0.c());
                }
                catch(Throwable throwable0) {
                    la.a(throwable0);
                }
                textView0.setTag(qh0);
                qh0.a(textView0);
            }
            Tools.a(textView0, 0x7F090007);  // style:ListItemText
        }
        return view1;
    }
}

