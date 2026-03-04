package android.ext;

import android.content.Context;
import android.fix.i;
import android.util.AttributeSet;
import android.view.View.OnClickListener;
import android.view.View;
import android.widget.Button;

public class TimeJumpPanel extends FloatPanel implements View.OnClickListener {
    Button e;
    Button f;

    public TimeJumpPanel(Context context0) {
        super(context0);
    }

    public TimeJumpPanel(Context context0, AttributeSet attributeSet0) {
        super(context0, attributeSet0);
    }

    public TimeJumpPanel(Context context0, AttributeSet attributeSet0, int v) {
        super(context0, attributeSet0, v);
    }

    public TimeJumpPanel(Context context0, AttributeSet attributeSet0, int v, int v1) {
        super(context0, attributeSet0, v, v1);
    }

    public static void a(boolean z) {
        TimeJumpPanel timeJumpPanel0 = MainService.instance.m;
        boolean z1 = (Config.B & 0x80) != 0;
        if(z && z1) {
            if(timeJumpPanel0 == null) {
                timeJumpPanel0 = (TimeJumpPanel)i.a(0x7F04002A, null);  // layout:time_jump_panel
                timeJumpPanel0.k();
                MainService.instance.m = timeJumpPanel0;
            }
            timeJumpPanel0.d();
            return;
        }
        if(timeJumpPanel0 != null) {
            timeJumpPanel0.f();
            if(!z1) {
                MainService.instance.m = null;
            }
        }
    }

    private static long getLast() [...] // 潜在的解密器

    @Override  // android.ext.FloatPanel
    protected String getPrefName() {
        return "time-jump";
    }

    public void j() {
        this.e.setVisibility(8);
        this.e.setText(Tools.a(0.0));
    }

    private void k() {
        rx.a(new sd(this));
    }

    @Override  // android.view.View$OnClickListener
    public void onClick(View view0) {
        if(view0 != null) {
            switch(view0.getId()) {
                case 0x7F0B0146: {  // id:time_jump
                    rz rz0 = rz.b;
                    if(rz0 != null) {
                        rz0.onClick(null);
                        return;
                    }
                    break;
                }
                case 0x7F0B0147: {  // id:time_jump_last
                    long v = TimeJumpPanel.getLast();
                    rz.a(v);
                    Tools.a((Tools.c(0x7F07014A) + ": " + Tools.a(((double)v) / 1000000000.0) + " (" + Double.toString(((double)v) / 1000000000.0).replaceFirst("\\D?0+$", "") + ')'), 0);  // string:time_jump "Time jump"
                    return;
                }
                default: {
                    la.a(("Unknown id: " + Integer.toHexString(view0.getId())), new RuntimeException());
                }
            }
        }
    }

    public void setMinSize(int v) {
        if(this.e == null) {
            return;
        }
        this.e.setMinWidth(v);
        this.e.setMinHeight(v);
        this.f.setMinWidth(v);
        this.f.setMinHeight(v);
    }
}

