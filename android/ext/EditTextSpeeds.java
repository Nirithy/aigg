package android.ext;

import android.content.Context;
import android.util.AttributeSet;

public class EditTextSpeeds extends EditTextMulti {
    private hd a;

    public EditTextSpeeds(Context context0) {
        super(context0);
        this.a = null;
    }

    public EditTextSpeeds(Context context0, AttributeSet attributeSet0) {
        super(context0, attributeSet0);
        this.a = null;
    }

    public EditTextSpeeds(Context context0, AttributeSet attributeSet0, int v) {
        super(context0, attributeSet0, v);
        this.a = null;
    }

    public EditTextSpeeds(Context context0, AttributeSet attributeSet0, int v, int v1) {
        super(context0, attributeSet0, v, v1);
        this.a = null;
    }

    @Override  // android.widget.TextView
    protected void onSelectionChanged(int v, int v1) {
        super.onSelectionChanged(v, v1);
        hd hd0 = this.a;
        if(hd0 != null) {
            hd0.a(this, v, v1);
        }
    }

    @Override  // android.widget.TextView
    protected void onTextChanged(CharSequence charSequence0, int v, int v1, int v2) {
        super.onTextChanged(charSequence0, v, v1, v2);
        hd hd0 = this.a;
        if(hd0 != null) {
            hd0.a(this, charSequence0, v, v1, v2);
        }
    }

    public void setOnChangedListener(hd hd0) {
        this.a = hd0;
    }
}

