package android.fix;

import android.annotation.TargetApi;
import android.content.Context;
import android.ext.Tools;
import android.ext.ho;
import android.ext.la;
import android.graphics.Canvas;
import android.graphics.Paint.FontMetricsInt;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.DragEvent;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View.MeasureSpec;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.TextView.BufferType;

public class TextView extends android.widget.TextView {
    private Rect a;
    private Paint.FontMetricsInt b;

    public TextView(Context context0) {
        super(context0);
    }

    public TextView(Context context0, AttributeSet attributeSet0) {
        super(context0, attributeSet0);
    }

    public TextView(Context context0, AttributeSet attributeSet0, int v) {
        super(context0, attributeSet0, v);
    }

    @TargetApi(21)
    public TextView(Context context0, AttributeSet attributeSet0, int v, int v1) {
        super(context0, attributeSet0, v, v1);
    }

    private static int a(int v, int v1) {
        int v2 = View.MeasureSpec.getMode(v1);
        int v3 = View.MeasureSpec.getSize(v1);
        switch(v2) {
            case 0x80000000: {
                return Math.min(v, v3);
            }
            case 0x40000000: {
                return v3;
            }
            default: {
                return v;
            }
        }
    }

    @Override  // android.widget.TextView
    protected void drawableStateChanged() {
        try {
            super.drawableStateChanged();
        }
        catch(ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException0) {
            la.a(arrayIndexOutOfBoundsException0);
        }
    }

    public boolean getSecClipboardEnabled() {
        return false;
    }

    @Override  // android.widget.TextView
    public void invalidateDrawable(Drawable drawable0) {
        try {
            super.invalidateDrawable(drawable0);
        }
        catch(NoSuchFieldError noSuchFieldError0) {
            la.a(noSuchFieldError0);
        }
    }

    @Override  // android.view.View
    protected void onDetachedFromWindow() {
        Tools.a(this);
        super.onDetachedFromWindow();
    }

    @Override  // android.widget.TextView
    public boolean onDragEvent(DragEvent dragEvent0) {
        try {
            return super.onDragEvent(dragEvent0);
        }
        catch(ClassCastException classCastException0) {
            la.a(classCastException0);
            return false;
        }
    }

    @Override  // android.widget.TextView
    protected void onDraw(Canvas canvas0) {
        try {
            super.onDraw(canvas0);
        }
        catch(Throwable throwable0) {
            la.a(throwable0);
        }
    }

    @Override  // android.view.View
    @TargetApi(14)
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo0) {
        try {
            super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo0);
        }
        catch(NullPointerException nullPointerException0) {
            la.a(nullPointerException0);
        }
    }

    @Override  // android.widget.TextView
    public boolean onKeyShortcut(int v, KeyEvent keyEvent0) {
        try {
            return super.onKeyShortcut(v, keyEvent0);
        }
        catch(NullPointerException nullPointerException0) {
            la.a(nullPointerException0);
            return false;
        }
    }

    @Override  // android.widget.TextView
    protected void onMeasure(int v, int v1) {
        try {
            super.onMeasure(v, v1);
        }
        catch(Throwable throwable0) {
            la.a(throwable0);
            try {
                int v2 = this.getSuggestedMinimumWidth();
                int v3 = this.getSuggestedMinimumHeight();
                int v4 = View.MeasureSpec.getMode(v) == 0x80000000 ? View.MeasureSpec.getSize(v) : 0x7FFFFFFF;
                TextPaint textPaint0 = this.getPaint();
                CharSequence charSequence0 = this.getText();
                int v5 = 0;
                int v6 = (int)(((double)Tools.a(1.0f)) + 0.99);
                int v7 = 0;
                int v9 = charSequence0.length();
                for(int v8 = 0; true; ++v8) {
                    if(v8 > v9) {
                        if(this.a == null) {
                            this.a = new Rect();
                        }
                        if(this.b == null) {
                            this.b = new Paint.FontMetricsInt();
                        }
                        textPaint0.getTextBounds("!\"#$%&\'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\]^_`abcdefghijklmnopqrstuvwxyz{|}~", 0, 94, this.a);
                        int v10 = Math.max(this.a.bottom - this.a.top + 1, textPaint0.getFontMetricsInt(this.b));
                        if(v10 <= 5) {
                            v10 = Math.max(v10, ((int)(((double)this.getTextSize()) * 1.5 + 0.99)));
                        }
                        int v11 = Math.max(v2, v6 + this.getCompoundPaddingLeft() + this.getCompoundPaddingRight());
                        int v12 = Math.max(v3, v5 * v10 + this.getCompoundPaddingTop() + this.getCompoundPaddingBottom() + (this.b.bottom - this.b.top - (this.b.descent - this.b.ascent)));
                        this.setMeasuredDimension(TextView.a(v11, v), TextView.a(v12, v1));
                        return;
                    }
                    if(v8 == v9 || charSequence0.charAt(v8) == 10) {
                        ++v5;
                        if(v8 > v7) {
                            int v13 = (int)(((double)textPaint0.measureText(charSequence0, v7, v8)) + 0.99);
                            if(v6 < v13) {
                                v6 = v13;
                            }
                            v5 += v13 / (v4 == 0 ? 0x7FFFFFFF : v4);
                        }
                        v7 = v8 + 1;
                    }
                }
            }
            catch(Throwable throwable1) {
                la.a(throwable1);
                ho.a(Thread.currentThread(), throwable0, false);
                ho.a(Thread.currentThread(), throwable1, false);
            }
        }
    }

    @Override  // android.widget.TextView
    public boolean onTextContextMenuItem(int v) {
        try {
            return super.onTextContextMenuItem(v);
        }
        catch(NullPointerException nullPointerException0) {
            la.a(nullPointerException0);
            return false;
        }
    }

    @Override  // android.widget.TextView
    public boolean onTouchEvent(MotionEvent motionEvent0) {
        try {
            return super.onTouchEvent(motionEvent0);
        }
        catch(Throwable throwable0) {
            la.a(throwable0);
            return false;
        }
    }

    @Override  // android.widget.TextView
    public void onWindowFocusChanged(boolean z) {
        try {
            super.onWindowFocusChanged(z);
        }
        catch(NullPointerException nullPointerException0) {
            la.a(nullPointerException0);
        }
    }

    @Override  // android.widget.TextView
    public boolean performLongClick() {
        try {
            return super.performLongClick();
        }
        catch(Throwable throwable0) {
            la.a(throwable0);
            return false;
        }
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
    public void refreshDrawableState() {
        try {
            super.refreshDrawableState();
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

    @Override  // android.widget.TextView
    public void setCompoundDrawables(Drawable drawable0, Drawable drawable1, Drawable drawable2, Drawable drawable3) {
        try {
            super.setCompoundDrawables(drawable0, drawable1, drawable2, drawable3);
        }
        catch(StringIndexOutOfBoundsException stringIndexOutOfBoundsException0) {
            la.a(stringIndexOutOfBoundsException0);
        }
    }

    @Override  // android.widget.TextView
    public void setText(CharSequence charSequence0, TextView.BufferType textView$BufferType0) {
        try {
            super.setText(charSequence0, textView$BufferType0);
        }
        catch(Throwable throwable0) {
            la.a(throwable0);
        }
    }

    @Override  // android.view.View
    public void setVisibility(int v) {
        try {
            super.setVisibility(v);
        }
        catch(StackOverflowError stackOverflowError0) {
            la.a(stackOverflowError0);
        }
    }
}

