package android.ext;

import android.view.View;
import android.view.ViewGroup.OnHierarchyChangeListener;
import android.widget.TextView;

class th implements ViewGroup.OnHierarchyChangeListener {
    private final int a;

    th(int v) {
        this.a = v;
        super();
    }

    @Override  // android.view.ViewGroup$OnHierarchyChangeListener
    public void onChildViewAdded(View view0, View view1) {
        try {
            View view2 = view1.findViewById(0x1020014);
            if(view2 instanceof TextView && this.a != 0) {
                Tools.a(((TextView)view2), this.a);
            }
        }
        catch(Throwable throwable0) {
            la.a(throwable0);
        }
    }

    @Override  // android.view.ViewGroup$OnHierarchyChangeListener
    public void onChildViewRemoved(View view0, View view1) {
    }
}

