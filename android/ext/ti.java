package android.ext;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup.OnHierarchyChangeListener;
import android.widget.TextView;

class ti implements ViewGroup.OnHierarchyChangeListener {
    private final int a;
    private final CharSequence[] b;
    private final Drawable[] c;
    private final int d;

    ti(int v, CharSequence[] arr_charSequence, Drawable[] arr_drawable, int v1) {
        this.a = v;
        this.b = arr_charSequence;
        this.c = arr_drawable;
        this.d = v1;
        super();
    }

    @Override  // android.view.ViewGroup$OnHierarchyChangeListener
    public void onChildViewAdded(View view0, View view1) {
        try {
            View view2 = view1.findViewById(0x1020014);
            if(view2 instanceof TextView) {
                if(this.a != 0) {
                    Tools.a(((TextView)view2), this.a);
                }
                if(((TextView)view2).getTag() == null) {
                    tj tj0 = new tj(this, this.b, ((TextView)view2), this.c, this.d);
                    ((TextView)view2).addTextChangedListener(tj0);
                    ((TextView)view2).setTag(tj0);
                    tj0.onTextChanged(((TextView)view2).getText(), 0, 0, 0);
                }
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

