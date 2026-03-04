package android.ext;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.List;

class kv extends ArrayAdapter {
    final ItemContextMenu a;
    private final List b;

    kv(ItemContextMenu itemContextMenu0, Context context0, List list0, List list1) {
        this.a = itemContextMenu0;
        this.b = list1;
        super(context0, list0);
    }

    @Override  // android.ext.ArrayAdapter
    public View getView(int v, View view0, ViewGroup viewGroup0) {
        View view1 = super.getView(v, view0, viewGroup0);
        Drawable drawable0 = Tools.b(((int)(((Integer)this.b.get(v)))));
        TextView textView0 = (TextView)view1.findViewById(0x1020014);
        if(textView0 != null) {
            Tools.a(textView0, 0x7F090007);  // style:ListItemText
            Tools.a(textView0, drawable0, Config.d());
        }
        return view1;
    }
}

