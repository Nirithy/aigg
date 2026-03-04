package android.ext;

import android.content.Context;
import android.fix.i;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.Collection;
import java.util.List;

public class ArrayAdapter extends android.widget.ArrayAdapter {
    private i a;

    public ArrayAdapter(Context context0, int v) {
        super(context0, v);
        this.a = null;
    }

    public ArrayAdapter(Context context0, int v, int v1) {
        super(context0, v, v1);
        this.a = null;
    }

    public ArrayAdapter(Context context0, int v, int v1, List list0) {
        super(context0, v, v1, list0);
        this.a = null;
    }

    public ArrayAdapter(Context context0, int v, int v1, Object[] arr_object) {
        super(context0, v, v1, arr_object);
        this.a = null;
    }

    public ArrayAdapter(Context context0, int v, List list0) {
        super(context0, v, list0);
        this.a = null;
    }

    public ArrayAdapter(Context context0, int v, Object[] arr_object) {
        super(context0, v, arr_object);
        this.a = null;
    }

    public ArrayAdapter(Context context0, List list0) {
        super(context0, 0x1090011, 0x1020014, list0);
        this.a = null;
    }

    public ArrayAdapter(Context context0, Object[] arr_object) {
        super(context0, 0x1090011, 0x1020014, arr_object);
        this.a = null;
    }

    @Override  // android.widget.ArrayAdapter
    public void addAll(Collection collection0) {
        if(Build.VERSION.SDK_INT < 11) {
            for(Object object0: collection0) {
                this.add(object0);
            }
            return;
        }
        super.addAll(collection0);
    }

    @Override  // android.widget.ArrayAdapter
    public View getView(int v, View view0, ViewGroup viewGroup0) {
        TextView textView1;
        Object object0;
        TextView textView0;
        View view1;
        try {
            view1 = super.getView(v, view0, viewGroup0);
            textView0 = null;
            object0 = null;
        }
        catch(Throwable throwable0) {
            la.c("Failed get view for ArrayAdapter", throwable0);
            if(view0 == null) {
                if(this.a == null) {
                    this.a = i.a();
                }
                view1 = this.a.inflate(0x7F040016, viewGroup0, false);  // layout:select_dialog_item
            }
            else {
                view1 = view0;
            }
            textView0 = (TextView)view1;
            Object object1 = this.getItem(v);
            if(object1 instanceof CharSequence) {
                textView0.setText(((CharSequence)object1));
            }
            else {
                textView0.setText(object1.toString());
            }
            object0 = object1;
        }
        if(object0 != null || !(view1 instanceof TextView)) {
            textView1 = textView0;
        }
        else {
            object0 = this.getItem(v);
            textView1 = (TextView)view1;
        }
        if(object0 instanceof pj && textView1 != null) {
            Drawable drawable0 = ((pj)object0).d();
            if(drawable0 != null) {
                Tools.a(textView1, drawable0, 24);
            }
        }
        return view1;
    }
}

