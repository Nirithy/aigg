package android.b;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.view.ActionProvider;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem.OnActionExpandListener;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

public class b implements MenuItem {
    private final int a;
    private final int b;
    private final int c;
    private CharSequence d;
    private CharSequence e;
    private Intent f;
    private char g;
    private char h;
    private Drawable i;
    private Context j;
    private MenuItem.OnMenuItemClickListener k;
    private int l;

    public b(Context context0, int v, int v1, int v2, int v3, CharSequence charSequence0) {
        this.l = 16;
        this.j = context0;
        this.a = v1;
        this.b = v;
        this.c = v3;
        this.d = charSequence0;
    }

    public b a(boolean z) {
        this.l = (z ? 4 : 0) | this.l & -5;
        return this;
    }

    public boolean a() {
        if(this.k != null && this.k.onMenuItemClick(this)) {
            return true;
        }
        if(this.f != null) {
            this.j.startActivity(this.f);
            return true;
        }
        return false;
    }

    @Override  // android.view.MenuItem
    public boolean collapseActionView() {
        return false;
    }

    @Override  // android.view.MenuItem
    public boolean expandActionView() {
        return false;
    }

    @Override  // android.view.MenuItem
    public ActionProvider getActionProvider() {
        return null;
    }

    @Override  // android.view.MenuItem
    public View getActionView() {
        return null;
    }

    @Override  // android.view.MenuItem
    public char getAlphabeticShortcut() {
        return this.h;
    }

    @Override  // android.view.MenuItem
    public int getGroupId() {
        return this.b;
    }

    @Override  // android.view.MenuItem
    public Drawable getIcon() {
        return this.i;
    }

    @Override  // android.view.MenuItem
    public Intent getIntent() {
        return this.f;
    }

    @Override  // android.view.MenuItem
    public int getItemId() {
        return this.a;
    }

    @Override  // android.view.MenuItem
    public ContextMenu.ContextMenuInfo getMenuInfo() {
        return null;
    }

    @Override  // android.view.MenuItem
    public char getNumericShortcut() {
        return this.g;
    }

    @Override  // android.view.MenuItem
    public int getOrder() {
        return this.c;
    }

    @Override  // android.view.MenuItem
    public SubMenu getSubMenu() {
        return null;
    }

    @Override  // android.view.MenuItem
    public CharSequence getTitle() {
        return this.d;
    }

    @Override  // android.view.MenuItem
    public CharSequence getTitleCondensed() {
        return this.e;
    }

    @Override  // android.view.MenuItem
    public boolean hasSubMenu() {
        return false;
    }

    @Override  // android.view.MenuItem
    public boolean isActionViewExpanded() {
        return false;
    }

    @Override  // android.view.MenuItem
    public boolean isCheckable() {
        return (this.l & 1) != 0;
    }

    @Override  // android.view.MenuItem
    public boolean isChecked() {
        return (this.l & 2) != 0;
    }

    @Override  // android.view.MenuItem
    public boolean isEnabled() {
        return (this.l & 16) != 0;
    }

    @Override  // android.view.MenuItem
    public boolean isVisible() {
        return (this.l & 8) == 0;
    }

    @Override  // android.view.MenuItem
    public MenuItem setActionProvider(ActionProvider actionProvider0) {
        throw new UnsupportedOperationException();
    }

    @Override  // android.view.MenuItem
    public MenuItem setActionView(int v) {
        throw new UnsupportedOperationException();
    }

    @Override  // android.view.MenuItem
    public MenuItem setActionView(View view0) {
        throw new UnsupportedOperationException();
    }

    @Override  // android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char c) {
        this.h = c;
        return this;
    }

    @Override  // android.view.MenuItem
    public MenuItem setCheckable(boolean z) {
        this.l = (z ? 1 : 0) | this.l & -2;
        return this;
    }

    @Override  // android.view.MenuItem
    public MenuItem setChecked(boolean z) {
        this.l = (z ? 2 : 0) | this.l & -3;
        return this;
    }

    @Override  // android.view.MenuItem
    public MenuItem setEnabled(boolean z) {
        this.l = (z ? 16 : 0) | this.l & -17;
        return this;
    }

    @Override  // android.view.MenuItem
    @TargetApi(21)
    public MenuItem setIcon(int v) {
        try {
            if(Build.VERSION.SDK_INT < 21) {
                this.i = this.j.getResources().getDrawable(v);
                return this;
            }
            this.i = this.j.getDrawable(v);
        }
        catch(Throwable unused_ex) {
        }
        return this;
    }

    @Override  // android.view.MenuItem
    public MenuItem setIcon(Drawable drawable0) {
        this.i = drawable0;
        return this;
    }

    @Override  // android.view.MenuItem
    public MenuItem setIntent(Intent intent0) {
        this.f = intent0;
        return this;
    }

    @Override  // android.view.MenuItem
    public MenuItem setNumericShortcut(char c) {
        this.g = c;
        return this;
    }

    @Override  // android.view.MenuItem
    public MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener menuItem$OnActionExpandListener0) {
        return this;
    }

    @Override  // android.view.MenuItem
    public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener menuItem$OnMenuItemClickListener0) {
        this.k = menuItem$OnMenuItemClickListener0;
        return this;
    }

    @Override  // android.view.MenuItem
    public MenuItem setShortcut(char c, char c1) {
        this.g = c;
        this.h = c1;
        return this;
    }

    @Override  // android.view.MenuItem
    public void setShowAsAction(int v) {
    }

    @Override  // android.view.MenuItem
    public MenuItem setShowAsActionFlags(int v) {
        return this;
    }

    @Override  // android.view.MenuItem
    public MenuItem setTitle(int v) {
        this.d = this.j.getResources().getString(v);
        return this;
    }

    @Override  // android.view.MenuItem
    public MenuItem setTitle(CharSequence charSequence0) {
        this.d = charSequence0;
        return this;
    }

    @Override  // android.view.MenuItem
    public MenuItem setTitleCondensed(CharSequence charSequence0) {
        this.e = charSequence0;
        return this;
    }

    @Override  // android.view.MenuItem
    public MenuItem setVisible(boolean z) {
        this.l = (z ? 0 : 8) | this.l & 8;
        return this;
    }
}

