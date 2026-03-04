package android.ext;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.view.ActionMode.Callback;
import android.view.ActionMode;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.SearchEvent;
import android.view.View;
import android.view.Window.Callback;
import android.view.WindowManager.LayoutParams;
import android.view.accessibility.AccessibilityEvent;

public class uv implements Window.Callback {
    Window.Callback a;
    private InternalKeyboard b;
    private boolean c;
    private boolean d;
    private boolean e;

    public uv(Window.Callback window$Callback0) {
        this.b = null;
        this.c = false;
        this.d = false;
        this.e = false;
        this.a = window$Callback0;
    }

    public void a(InternalKeyboard internalKeyboard0) {
        this.b = internalKeyboard0;
    }

    @Override  // android.view.Window$Callback
    @TargetApi(12)
    public boolean dispatchGenericMotionEvent(MotionEvent motionEvent0) {
        try {
            return this.a.dispatchGenericMotionEvent(motionEvent0);
        }
        catch(Throwable throwable0) {
            la.a(throwable0);
            return false;
        }
    }

    @Override  // android.view.Window$Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent0) {
        try {
            return this.a.dispatchKeyEvent(keyEvent0);
        }
        catch(Throwable throwable0) {
            la.a(throwable0);
            return false;
        }
    }

    @Override  // android.view.Window$Callback
    @TargetApi(11)
    public boolean dispatchKeyShortcutEvent(KeyEvent keyEvent0) {
        try {
            return this.a.dispatchKeyShortcutEvent(keyEvent0);
        }
        catch(Throwable throwable0) {
            la.a(throwable0);
            return false;
        }
    }

    @Override  // android.view.Window$Callback
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent0) {
        return this.a.dispatchPopulateAccessibilityEvent(accessibilityEvent0);
    }

    @Override  // android.view.Window$Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent0) {
        try {
            return this.a.dispatchTouchEvent(motionEvent0);
        }
        catch(Throwable throwable0) {
            la.a(throwable0);
            return false;
        }
    }

    @Override  // android.view.Window$Callback
    public boolean dispatchTrackballEvent(MotionEvent motionEvent0) {
        return this.a.dispatchTrackballEvent(motionEvent0);
    }

    @Override  // android.view.Window$Callback
    @TargetApi(11)
    public void onActionModeFinished(ActionMode actionMode0) {
        if(this.e) {
            return;
        }
        try {
            this.e = true;
            this.a.onActionModeFinished(actionMode0);
            actionMode0.finish();
            this.e = false;
        }
        catch(Throwable throwable0) {
            this.e = false;
            throw throwable0;
        }
    }

    @Override  // android.view.Window$Callback
    @TargetApi(11)
    public void onActionModeStarted(ActionMode actionMode0) {
        if(this.d) {
            return;
        }
        try {
            this.d = true;
            this.a.onActionModeStarted(actionMode0);
            this.d = false;
        }
        catch(Throwable throwable0) {
            this.d = false;
            throw throwable0;
        }
    }

    @Override  // android.view.Window$Callback
    public void onAttachedToWindow() {
        this.a.onAttachedToWindow();
    }

    @Override  // android.view.Window$Callback
    public void onContentChanged() {
        this.a.onContentChanged();
    }

    @Override  // android.view.Window$Callback
    public boolean onCreatePanelMenu(int v, Menu menu0) {
        return this.a.onCreatePanelMenu(v, menu0);
    }

    @Override  // android.view.Window$Callback
    public View onCreatePanelView(int v) {
        return this.a.onCreatePanelView(v);
    }

    @Override  // android.view.Window$Callback
    @SuppressLint({"MissingSuperCall"})
    public void onDetachedFromWindow() {
        this.a.onDetachedFromWindow();
    }

    @Override  // android.view.Window$Callback
    public boolean onMenuItemSelected(int v, MenuItem menuItem0) {
        return this.a.onMenuItemSelected(v, menuItem0);
    }

    @Override  // android.view.Window$Callback
    public boolean onMenuOpened(int v, Menu menu0) {
        return this.a.onMenuOpened(v, menu0);
    }

    @Override  // android.view.Window$Callback
    public void onPanelClosed(int v, Menu menu0) {
        this.a.onPanelClosed(v, menu0);
    }

    @Override  // android.view.Window$Callback
    public boolean onPreparePanel(int v, View view0, Menu menu0) {
        return this.a.onPreparePanel(v, view0, menu0);
    }

    @Override  // android.view.Window$Callback
    public boolean onSearchRequested() {
        return this.a.onSearchRequested();
    }

    @Override  // android.view.Window$Callback
    @TargetApi(23)
    public boolean onSearchRequested(SearchEvent searchEvent0) {
        return this.a.onSearchRequested(searchEvent0);
    }

    @Override  // android.view.Window$Callback
    public void onWindowAttributesChanged(WindowManager.LayoutParams windowManager$LayoutParams0) {
        try {
            this.a.onWindowAttributesChanged(windowManager$LayoutParams0);
        }
        catch(IllegalArgumentException illegalArgumentException0) {
            la.a(illegalArgumentException0);
        }
    }

    @Override  // android.view.Window$Callback
    public void onWindowFocusChanged(boolean z) {
        try {
            this.a.onWindowFocusChanged(z);
        }
        catch(IllegalArgumentException illegalArgumentException0) {
            la.a(illegalArgumentException0);
        }
        if(this.b != null) {
            this.b.b();
        }
    }

    @Override  // android.view.Window$Callback
    @TargetApi(11)
    public ActionMode onWindowStartingActionMode(ActionMode.Callback actionMode$Callback0) {
        ActionMode actionMode0 = null;
        if(this.c) {
            return null;
        }
        try {
            this.c = true;
            ActionMode actionMode1 = this.a.onWindowStartingActionMode(actionMode$Callback0);
            if(actionMode1 == null) {
                try {
                    actionMode0 = new a(actionMode$Callback0);
                }
                catch(Throwable throwable1) {
                    goto label_19;
                }
                if(actionMode$Callback0.onCreateActionMode(actionMode0, actionMode0.getMenu())) {
                    ((a)actionMode0).invalidate();
                    ((a)actionMode0).a();
                }
            }
            else {
                actionMode0 = actionMode1;
            }
            this.c = false;
            return actionMode0;
        }
        catch(Throwable throwable0) {
            throwable1 = throwable0;
        }
        try {
        label_19:
            la.c("Fail on onWindowStartingActionMode", throwable1);
            this.c = false;
            return actionMode0;
        }
        catch(Throwable throwable2) {
            this.c = false;
            throw throwable2;
        }
    }

    @Override  // android.view.Window$Callback
    @TargetApi(23)
    public ActionMode onWindowStartingActionMode(ActionMode.Callback actionMode$Callback0, int v) {
        ActionMode actionMode0 = null;
        try {
            actionMode0 = this.a.onWindowStartingActionMode(actionMode$Callback0, v);
            return actionMode0 != null || v != 0 ? actionMode0 : this.onWindowStartingActionMode(actionMode$Callback0);
        }
        catch(Throwable throwable0) {
            la.c("Fail on onWindowStartingActionMode", throwable0);
            return actionMode0;
        }
    }
}

