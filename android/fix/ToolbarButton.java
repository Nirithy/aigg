package android.fix;

import android.content.Context;
import android.ext.Config;
import android.ext.Tools;
import android.ext.la;
import android.util.AttributeSet;

public class ToolbarButton extends ImageButtonView {
    private int a;
    private boolean b;

    public ToolbarButton(Context context0) {
        super(context0);
        this.a = 0;
        this.b = false;
    }

    public ToolbarButton(Context context0, AttributeSet attributeSet0) {
        super(context0, attributeSet0);
        this.a = 0;
        this.b = false;
    }

    public ToolbarButton(Context context0, AttributeSet attributeSet0, int v) {
        super(context0, attributeSet0, v);
        this.a = 0;
        this.b = false;
    }

    public ToolbarButton(Context context0, AttributeSet attributeSet0, int v, int v1) {
        super(context0, attributeSet0, v, v1);
        this.a = 0;
        this.b = false;
    }

    public void setIcon(int v) {
        this.a = v;
        this.setMinimumWidth(((int)Tools.a(45.0f)));
        this.setMinimumHeight(Tools.b());
    }

    public void setIcon(boolean z) {
        if(this.b != z) {
            this.b = z;
            if(z) {
                try {
                    this.setImageResource(this.a);
                    Config.a(this, ((int)Tools.a(45.0f)), Tools.b());
                }
                catch(Throwable throwable0) {
                    la.a(throwable0);
                }
                return;
            }
            try {
                this.setImageDrawable(null);
            }
            catch(Throwable throwable1) {
                la.a(throwable1);
            }
        }
    }

    @Override  // android.view.View
    public String toString() {
        return super.toString() + " " + this.a + "; " + this.b;
    }
}

