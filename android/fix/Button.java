package android.fix;

import android.annotation.TargetApi;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.ext.Tools;
import android.ext.ho;
import android.ext.la;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.DragEvent;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.TextView.BufferType;

public class Button extends android.widget.Button {
    public Button(Context context0) {
        super(context0);
        if(Build.VERSION.SDK_INT < 11) {
            this.setTextColor(-1);
            Tools.a(this, Tools.b(0x7F020002));  // drawable:btn_default_normal_holo_dark
            int v = Tools.b();
            this.setMinHeight(v);
            this.setMinimumHeight(v);
        }
    }

    public Button(Context context0, AttributeSet attributeSet0) {
        super(context0, attributeSet0);
        if(Build.VERSION.SDK_INT < 11) {
            this.setTextColor(-1);
            Tools.a(this, Tools.b(0x7F020002));  // drawable:btn_default_normal_holo_dark
            int v = Tools.b();
            this.setMinHeight(v);
            this.setMinimumHeight(v);
        }
    }

    public Button(Context context0, AttributeSet attributeSet0, int v) {
        super(context0, attributeSet0, v);
        if(Build.VERSION.SDK_INT < 11) {
            this.setTextColor(-1);
            Tools.a(this, Tools.b(0x7F020002));  // drawable:btn_default_normal_holo_dark
            int v1 = Tools.b();
            this.setMinHeight(v1);
            this.setMinimumHeight(v1);
        }
    }

    public Button(Context context0, AttributeSet attributeSet0, int v, int v1) {
        super(context0, attributeSet0, v, v1);
        if(Build.VERSION.SDK_INT < 11) {
            this.setTextColor(-1);
            Tools.a(this, Tools.b(0x7F020002));  // drawable:btn_default_normal_holo_dark
            int v2 = Tools.b();
            this.setMinHeight(v2);
            this.setMinimumHeight(v2);
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
        catch(NullPointerException nullPointerException0) {
            la.a(nullPointerException0);
        }
        catch(ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException0) {
            la.a(arrayIndexOutOfBoundsException0);
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
            ho.a(Thread.currentThread(), throwable0, false);
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
        catch(ActivityNotFoundException activityNotFoundException0) {
            la.a(activityNotFoundException0);
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
        catch(ClassCastException classCastException0) {
            la.a(classCastException0);
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
        catch(SecurityException securityException0) {
            la.a(securityException0);
        }
    }
}

