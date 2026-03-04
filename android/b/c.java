package android.b;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

public class c extends a implements SubMenu {
    Drawable c;
    Drawable d;
    View e;
    MenuItem f;
    a g;
    private CharSequence h;

    public c(Context context0, a a0, MenuItem menuItem0) {
        super(context0);
        this.h = "";
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = menuItem0;
        this.g = a0;
    }

    @Override  // android.view.SubMenu
    public void clearHeader() {
        this.e = null;
        this.h = "";
        this.c = null;
    }

    @Override  // android.view.SubMenu
    public MenuItem getItem() {
        return this.f;
    }

    @Override  // android.view.SubMenu
    public SubMenu setHeaderIcon(int v) {
        return this.setHeaderIcon(this.b.getDrawable(v));
    }

    @Override  // android.view.SubMenu
    public SubMenu setHeaderIcon(Drawable drawable0) {
        this.c = drawable0;
        return this;
    }

    @Override  // android.view.SubMenu
    public SubMenu setHeaderTitle(int v) {
        return this.setHeaderTitle(this.b.getString(v));
    }

    @Override  // android.view.SubMenu
    public SubMenu setHeaderTitle(CharSequence charSequence0) {
        this.h = charSequence0;
        return this;
    }

    @Override  // android.view.SubMenu
    public SubMenu setHeaderView(View view0) {
        this.e = view0;
        return this;
    }

    @Override  // android.view.SubMenu
    public SubMenu setIcon(int v) {
        return this.setIcon(this.b.getDrawable(v));
    }

    @Override  // android.view.SubMenu
    public SubMenu setIcon(Drawable drawable0) {
        this.d = drawable0;
        return this;
    }
}

