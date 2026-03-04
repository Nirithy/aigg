package android.ext;

import android.annotation.TargetApi;
import android.b.b;
import android.content.Context;
import android.fix.Button;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.ActionMode.Callback;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View.OnClickListener;
import android.view.View;
import android.view.WindowManager.LayoutParams;
import android.widget.LinearLayout;

@TargetApi(11)
public class a extends ActionMode implements View.OnClickListener {
    private CharSequence a;
    private CharSequence b;
    private View c;
    private LinearLayout d;
    private android.b.a e;
    private Context f;
    private boolean g;
    private boolean h;
    private WindowManager.LayoutParams i;
    private ActionMode.Callback j;

    public a(ActionMode.Callback actionMode$Callback0) {
        this.a = null;
        this.b = null;
        this.c = null;
        this.d = null;
        this.g = false;
        this.h = false;
        this.f = MainService.context;
        this.e = new android.b.a(this.f);
        this.d = new android.fix.LinearLayout(this.f);
        this.d.setAlpha(1.0f);
        Drawable drawable0 = this.d.getBackground();
        int v = drawable0 instanceof ColorDrawable ? ((ColorDrawable)drawable0).getColor() : 0;
        this.d.setBackgroundColor(v | 0xFF000000);
        this.i = new WindowManager.LayoutParams();
        this.i.type = 0x7F6;
        this.i.width = -1;
        this.i.height = -2;
        this.i.format = -2;
        this.i.flags = 0;
        this.i.gravity = 55;
        this.i.y = 0;
        this.i.alpha = 1.0f;
        this.j = actionMode$Callback0;
    }

    public void a() {
        if(this.g) {
            return;
        }
        try {
            Tools.b(this.d, this.i);
            this.g = true;
        }
        catch(Throwable throwable0) {
            la.c("addView failed", throwable0);
        }
    }

    public void b() {
        try {
            if(!this.g) {
                return;
            }
            Tools.b(this.d);
        }
        catch(Throwable throwable0) {
            la.c("removeView failed", throwable0);
        }
        this.g = false;
    }

    @Override  // android.view.ActionMode
    public void finish() {
        if(this.h) {
            return;
        }
        this.h = true;
        this.b();
        this.j.onDestroyActionMode(this);
    }

    @Override  // android.view.ActionMode
    public View getCustomView() {
        return this.c;
    }

    @Override  // android.view.ActionMode
    public Menu getMenu() {
        return this.e;
    }

    @Override  // android.view.ActionMode
    public MenuInflater getMenuInflater() {
        return new MenuInflater(this.f);
    }

    @Override  // android.view.ActionMode
    public CharSequence getSubtitle() {
        return this.b;
    }

    @Override  // android.view.ActionMode
    public CharSequence getTitle() {
        return this.a;
    }

    @Override  // android.view.ActionMode
    @TargetApi(16)
    public void invalidate() {
        try {
            this.j.onPrepareActionMode(this, this.e);
        }
        finally {
            this.d.removeAllViews();
            int v1 = this.e.size();
            for(int v2 = 0; v2 < v1; ++v2) {
                MenuItem menuItem0 = this.e.getItem(v2);
                Button button0 = new Button(this.f);
                button0.setAlpha(1.0f);
                button0.setFocusable(false);
                Drawable drawable0 = menuItem0.getIcon();
                Tools.a(button0, drawable0, 0x20);
                if(drawable0 == null) {
                    button0.setText(menuItem0.getTitle());
                }
                button0.setTag(menuItem0);
                button0.setOnClickListener(this);
                this.d.addView(button0);
            }
            if(this.c != null) {
                this.d.addView(this.c);
            }
            this.d.invalidate();
            la.a("invalidate");
        }
    }

    @Override  // android.view.View$OnClickListener
    public void onClick(View view0) {
        MenuItem menuItem0 = (MenuItem)view0.getTag();
        if(menuItem0 instanceof b) {
            ((b)menuItem0).a();
        }
        this.j.onActionItemClicked(this, menuItem0);
    }

    @Override  // android.view.ActionMode
    public void setCustomView(View view0) {
        this.c = view0;
        this.invalidate();
    }

    @Override  // android.view.ActionMode
    public void setSubtitle(int v) {
        this.b = qk.a(v);
    }

    @Override  // android.view.ActionMode
    public void setSubtitle(CharSequence charSequence0) {
        this.b = charSequence0;
    }

    @Override  // android.view.ActionMode
    public void setTitle(int v) {
        this.a = qk.a(v);
    }

    @Override  // android.view.ActionMode
    public void setTitle(CharSequence charSequence0) {
        this.a = charSequence0;
    }
}

