package android.ext;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Configuration;
import android.fix.FrameLayout;
import android.fix.LinearLayout;
import android.fix.d;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ScrollView;

public class KeyboardLayout extends LinearLayout {
    private ScrollView a;
    private FrameLayout b;
    private InternalKeyboard c;
    private int d;

    public KeyboardLayout(Context context0) {
        super(context0);
    }

    public KeyboardLayout(Context context0, AttributeSet attributeSet0) {
        super(context0, attributeSet0);
    }

    @TargetApi(11)
    public KeyboardLayout(Context context0, AttributeSet attributeSet0, int v) {
        super(context0, attributeSet0, v);
    }

    @TargetApi(21)
    public KeyboardLayout(Context context0, AttributeSet attributeSet0, int v, int v1) {
        super(context0, attributeSet0, v, v1);
    }

    private void a(View view0, int v, int v1) {
        ViewGroup.LayoutParams viewGroup$LayoutParams0 = view0.getLayoutParams();
        viewGroup$LayoutParams0.width = v;
        viewGroup$LayoutParams0.height = v1;
        view0.setLayoutParams(viewGroup$LayoutParams0);
    }

    public void a() {
        Configuration configuration0 = Tools.e().getResources().getConfiguration();
        int v = configuration0.orientation;
        if(v == this.d) {
            return;
        }
        this.d = v;
        if(Build.VERSION.SDK_INT >= 13) {
            la.a(("Screen: " + configuration0.screenWidthDp + "dp x " + configuration0.screenHeightDp + "dp"));
        }
        this.b();
        int[] arr_v = v == 1 ? new int[]{1, -1, 0} : new int[]{0, -1, -2};
        this.setOrientation(arr_v[0]);
        ScrollView scrollView0 = this.a.getVisibility() == 0 ? this.a : this.b;
        this.a(scrollView0, arr_v[1], arr_v[2]);
        this.c.a();
    }

    private void b() {
        if(this.a != null) {
            return;
        }
        this.d = 0;
        this.a = (ScrollView)this.findViewById(0x7F0B0028);  // id:kbd_scroll
        this.b = (FrameLayout)this.findViewById(0x7F0B0029);  // id:kbd_frame
        this.c = (InternalKeyboard)this.findViewById(0x7F0B002A);  // id:keyboard
    }

    @Override  // android.fix.LinearLayout
    protected void onConfigurationChanged(Configuration configuration0) {
        la.a(("KeyboardLayout onConfigurationChanged: " + configuration0));
        Configuration configuration1 = d.a(configuration0);
        super.onConfigurationChanged(configuration1);
        this.a();
        MainService.a(configuration1);
    }
}

