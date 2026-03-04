package android.fix;

import android.content.Context;
import android.ext.Tools;
import android.util.AttributeSet;

public class TextButtonView extends TextView {
    public TextButtonView(Context context0) {
        super(context0);
        Tools.i(this);
    }

    public TextButtonView(Context context0, AttributeSet attributeSet0) {
        super(context0, attributeSet0);
        Tools.i(this);
    }

    public TextButtonView(Context context0, AttributeSet attributeSet0, int v) {
        super(context0, attributeSet0, v);
        Tools.i(this);
    }

    public TextButtonView(Context context0, AttributeSet attributeSet0, int v, int v1) {
        super(context0, attributeSet0, v, v1);
        Tools.i(this);
    }
}

