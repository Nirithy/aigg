package android.ext;

import android.content.Context;
import android.util.AttributeSet;

public class EditTextMulti extends EditText {
    public EditTextMulti(Context context0) {
        super(context0);
        this.setInputType(this.getInputType() | 0x40000);
        this.setHorizontallyScrolling(false);
        this.setMaxLines(0x7FFFFFFF);
    }

    public EditTextMulti(Context context0, AttributeSet attributeSet0) {
        super(context0, attributeSet0);
        this.setInputType(this.getInputType() | 0x40000);
        this.setHorizontallyScrolling(false);
        this.setMaxLines(0x7FFFFFFF);
    }

    public EditTextMulti(Context context0, AttributeSet attributeSet0, int v) {
        super(context0, attributeSet0, v);
        this.setInputType(this.getInputType() | 0x40000);
        this.setHorizontallyScrolling(false);
        this.setMaxLines(0x7FFFFFFF);
    }

    public EditTextMulti(Context context0, AttributeSet attributeSet0, int v, int v1) {
        super(context0, attributeSet0, v, v1);
        this.setInputType(this.getInputType() | 0x40000);
        this.setHorizontallyScrolling(false);
        this.setMaxLines(0x7FFFFFFF);
    }

    @Override  // android.widget.TextView
    public void setHorizontallyScrolling(boolean z) {
        super.setHorizontallyScrolling(false);
    }

    @Override  // android.widget.TextView
    public void setMaxLines(int v) {
        super.setMaxLines(0x7FFFFFFF);
    }
}

