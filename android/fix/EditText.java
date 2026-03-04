package android.fix;

import android.annotation.TargetApi;
import android.content.Context;
import android.ext.ho;
import android.ext.la;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.DragEvent;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.TextView.BufferType;

public class EditText extends android.widget.EditText {
    public EditText(Context context0) {
        super(context0);
    }

    public EditText(Context context0, AttributeSet attributeSet0) {
        super(context0, attributeSet0);
    }

    public EditText(Context context0, AttributeSet attributeSet0, int v) {
        super(context0, attributeSet0, v);
    }

    public EditText(Context context0, AttributeSet attributeSet0, int v, int v1) {
        super(context0, attributeSet0, v, v1);
    }

    @Override  // android.view.View
    public void dispatchWindowFocusChanged(boolean z) {
        try {
            super.dispatchWindowFocusChanged(z);
        }
        catch(Throwable throwable0) {
            la.a(throwable0);
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

    @Override  // android.widget.TextView
    public boolean onDragEvent(DragEvent dragEvent0) {
        try {
            return super.onDragEvent(dragEvent0);
        }
        catch(Throwable throwable0) {
            la.a(throwable0);
            return false;
        }
    }

    @Override  // android.widget.TextView
    protected void onDraw(Canvas canvas0) {
        try {
            super.onDraw(canvas0);
        }
        catch(NullPointerException nullPointerException0) {
            la.a(nullPointerException0);
        }
        catch(ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException0) {
            la.a(arrayIndexOutOfBoundsException0);
        }
    }

    @Override  // android.widget.TextView
    protected void onFocusChanged(boolean z, int v, Rect rect0) {
        try {
            int v1 = super.getImeOptions();
            if((v1 & 0x72000000) != 0x72000000) {
                super.setImeOptions(v1 | 0x72000000);
            }
        }
        catch(Throwable throwable0) {
            la.a(throwable0);
        }
        try {
            super.onFocusChanged(z, v, rect0);
        }
        catch(Throwable throwable1) {
            la.a(throwable1);
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

    @Override  // android.widget.EditText
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
            ho.a(Thread.currentThread(), throwable0, false);
        }
    }

    @Override  // android.widget.EditText
    public boolean onTextContextMenuItem(int v) {
        try {
            return super.onTextContextMenuItem(v);
        }
        catch(Throwable throwable0) {
            la.a(throwable0);
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
        catch(Throwable throwable0) {
            la.a(throwable0);
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
    public void setImeOptions(int v) {
        try {
            super.setImeOptions(0x72000000 | v);
        }
        catch(Throwable throwable0) {
            la.a(throwable0);
        }
    }

    @Override  // android.widget.EditText
    public void setText(CharSequence charSequence0, TextView.BufferType textView$BufferType0) {
        try {
            super.setText(charSequence0, textView$BufferType0);
        }
        catch(SecurityException | NullPointerException securityException0) {
            la.a(securityException0);
        }
    }
}

