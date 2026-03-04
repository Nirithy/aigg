package android.fix;

import android.c.b;
import android.content.Context;
import android.content.res.Configuration;
import android.ext.la;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup;

public class WrapLayout extends ViewGroup {
    private int[] a;
    private int b;

    public WrapLayout(Context context0) {
        super(context0);
        this.a = b.d;
        this.b = -1;
    }

    public WrapLayout(Context context0, AttributeSet attributeSet0) {
        super(context0, attributeSet0);
        this.a = b.d;
        this.b = -1;
    }

    public WrapLayout(Context context0, AttributeSet attributeSet0, int v) {
        super(context0, attributeSet0, v);
        this.a = b.d;
        this.b = -1;
    }

    public WrapLayout(Context context0, AttributeSet attributeSet0, int v, int v1) {
        super(context0, attributeSet0, v, v1);
        this.a = b.d;
        this.b = -1;
    }

    private int a(boolean z, int v, int v1) {
        int v20;
        int v17;
        int v16;
        int v15;
        int v14;
        View view0;
        int v4;
        int v3;
        int v2 = this.getChildCount();
        if(!z && this.a.length == v2 * 2) {
            return 0;
        }
        boolean z1 = this.b == 0;
        boolean z2 = this.b > 0;
        int[] arr_v = new int[v2 * 2];
        int[] arr_v1 = new int[v2];
        int[] arr_v2 = z2 ? new int[v2] : null;
        if(z2) {
            v3 = this.getPaddingLeft();
            v4 = this.getPaddingRight();
        }
        else {
            v3 = this.getPaddingRight();
            v4 = this.getPaddingLeft();
        }
        int v5 = v - v3 - v4;
        int v6 = this.getPaddingTop();
        int v7 = 0;
        int v8 = 0;
        int v9 = 0;
        int v10 = 0;
        int v11 = 0;
        int v12 = 0;
        int v13 = v4;
        while(v12 < v2) {
            try {
                view0 = this.getChildAt(v12);
            }
            catch(ArrayIndexOutOfBoundsException unused_ex) {
                view0 = null;
            }
            if(view0 == null) {
                v14 = v11;
                v15 = v10;
                v16 = v9;
            }
            else if(view0.getVisibility() == 8) {
                if(view0 instanceof ToolbarButton) {
                    ((ToolbarButton)view0).setIcon(false);
                }
                v14 = v11;
                v15 = v10;
                v16 = v9;
            }
            else {
                ViewGroup.LayoutParams viewGroup$LayoutParams0 = view0.getLayoutParams();
                if(viewGroup$LayoutParams0.width == -1) {
                    v17 = View.MeasureSpec.makeMeasureSpec(v5, 0x40000000);
                }
                else {
                    v17 = viewGroup$LayoutParams0.width <= 0 ? View.MeasureSpec.makeMeasureSpec(v5, 0x80000000) : View.MeasureSpec.makeMeasureSpec(viewGroup$LayoutParams0.width, 0x40000000);
                }
                view0.measure(v17, (viewGroup$LayoutParams0.height <= 0 ? View.MeasureSpec.makeMeasureSpec(v1, 0) : View.MeasureSpec.makeMeasureSpec(viewGroup$LayoutParams0.height, 0x40000000)));
                int v18 = view0.getMeasuredWidth();
                int v19 = view0.getMeasuredHeight();
                if(v13 > v4 && v13 + v18 > v - v3) {
                    while(v8 < v12) {
                        arr_v[v2 + v8] += (v7 - arr_v1[v8]) / 2;
                        if(z1) {
                            arr_v[v8] += (v5 - v13) / 2 + v4 - v9;
                        }
                        ++v8;
                    }
                    v6 += v7;
                    v20 = v11 + 1;
                    v15 = 0;
                    v16 = 0;
                    v8 = v12;
                    v7 = v19;
                    v13 = v4;
                }
                else if(v7 < v19) {
                    v20 = v11;
                    v15 = v10;
                    v16 = v9;
                    v7 = v19;
                }
                else {
                    v20 = v11;
                    v15 = v10;
                    v16 = v9;
                }
                if(!z1) {
                    arr_v[v12] = v13;
                }
                else if((v12 - v8) % 2 == 0) {
                    v16 -= v18;
                    arr_v[v12] = v16;
                }
                else {
                    arr_v[v12] = v15;
                    v15 += v18;
                }
                arr_v[v2 + v12] = v6;
                arr_v1[v12] = v19;
                if(z2) {
                    arr_v2[v12] = v18;
                }
                if(view0 instanceof ToolbarButton) {
                    ((ToolbarButton)view0).setIcon(v20 == 0);
                }
                v14 = v20;
                v13 += v18;
            }
            ++v12;
            v11 = v14;
            v10 = v15;
            v9 = v16;
        }
        while(v8 < v2) {
            arr_v[v2 + v8] += (v7 - arr_v1[v8]) / 2;
            if(z1) {
                arr_v[v8] += (v5 - v13) / 2 + v4 - v9;
            }
            ++v8;
        }
        if(z2) {
            for(int v21 = 0; v21 < v2; ++v21) {
                arr_v[v21] = v - arr_v[v21] - arr_v2[v21];
            }
        }
        this.a = arr_v;
        return v6 + v7 + this.getPaddingBottom();
    }

    @Override  // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams viewGroup$LayoutParams0) {
        return viewGroup$LayoutParams0 instanceof ViewGroup.LayoutParams;
    }

    @Override  // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new ViewGroup.LayoutParams(-2, -2);
    }

    @Override  // android.view.View
    protected void onConfigurationChanged(Configuration configuration0) {
        int v3;
        View view0;
        super.onConfigurationChanged(configuration0);
        int v = this.getChildCount();
        int v1 = 0;
        int v2;
        for(v2 = 0; v1 < v; v2 = v3) {
            try {
                view0 = this.getChildAt(v1);
            }
            catch(ArrayIndexOutOfBoundsException unused_ex) {
                view0 = null;
            }
            if(view0 == null) {
                v3 = v2;
            }
            else if(view0 instanceof ToolbarButton) {
                ((ToolbarButton)view0).setIcon(false);
                v3 = 1;
            }
            else {
                v3 = v2;
            }
            ++v1;
        }
        if(v2 != 0) {
            this.requestLayout();
        }
    }

    @Override  // android.view.ViewGroup
    protected void onLayout(boolean z, int v, int v1, int v2, int v3) {
        int v4 = 0;
        int v5 = this.getChildCount();
        this.a(false, v2 - v, v3 - v1);
        int[] arr_v = this.a;
        while(v4 < v5) {
            try {
                View view0 = this.getChildAt(v4);
                if(view0 != null && view0.getVisibility() != 8) {
                    int v6 = view0.getMeasuredWidth();
                    int v7 = view0.getMeasuredHeight();
                    int v8 = arr_v[v4];
                    int v9 = arr_v[v5 + v4];
                    view0.layout(v8, v9, v6 + v8, v7 + v9);
                }
                ++v4;
                continue;
            }
            catch(ArrayIndexOutOfBoundsException unused_ex) {
            }
            ++v4;
        }
    }

    @Override  // android.view.View
    protected void onMeasure(int v, int v1) {
        int v2 = View.MeasureSpec.getSize(v);
        int v3 = View.MeasureSpec.getSize(v1);
        int v4 = this.a(true, v2, v3);
        if(View.MeasureSpec.getMode(v1) != 0 && (View.MeasureSpec.getMode(v1) != 0x80000000 || v4 > v3)) {
            v4 = v3;
        }
        this.setMeasuredDimension(v2, v4);
    }

    @Override  // android.view.View
    public void playSoundEffect(int v) {
        try {
            super.playSoundEffect(v);
        }
        catch(Throwable throwable0) {
            la.a(throwable0);
        }
    }

    @Override  // android.view.View
    public void sendAccessibilityEvent(int v) {
        try {
            super.sendAccessibilityEvent(v);
        }
        catch(Throwable throwable0) {
            la.a(throwable0);
        }
    }

    public void setFill(int v) {
        int v1 = this.b;
        this.b = v;
        if(v1 != v) {
            this.requestLayout();
            this.postInvalidate();
        }
    }
}

