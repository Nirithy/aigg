package android.b;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import java.util.ArrayList;
import java.util.List;

public class a implements Menu {
    protected Context a;
    protected Resources b;
    private boolean c;
    private ArrayList d;

    public a(Context context0) {
        this.a = context0;
        this.d = new ArrayList();
        this.b = this.a.getResources();
    }

    private int a(int v) {
        ArrayList arrayList0 = this.d;
        int v1 = arrayList0.size();
        for(int v2 = 0; true; ++v2) {
            if(v2 >= v1) {
                return -1;
            }
            if(((b)arrayList0.get(v2)).getItemId() == v) {
                return v2;
            }
        }
    }

    private b a(int v, KeyEvent keyEvent0) {
        b b0;
        boolean z = this.c;
        ArrayList arrayList0 = this.d;
        int v1 = arrayList0.size();
        for(int v2 = 0; true; ++v2) {
            if(v2 >= v1) {
                return null;
            }
            b0 = (b)arrayList0.get(v2);
            if(v == (z ? b0.getAlphabeticShortcut() : b0.getNumericShortcut())) {
                break;
            }
        }
        return b0;
    }

    public Context a() {
        return this.a;
    }

    @Override  // android.view.Menu
    public MenuItem add(int v) {
        return this.add(0, 0, 0, v);
    }

    @Override  // android.view.Menu
    public MenuItem add(int v, int v1, int v2, int v3) {
        return this.add(v, v1, v2, this.b.getString(v3));
    }

    @Override  // android.view.Menu
    public MenuItem add(int v, int v1, int v2, CharSequence charSequence0) {
        MenuItem menuItem0 = new b(this.a(), v, v1, 0, v2, charSequence0);
        this.d.add(v2, menuItem0);
        return menuItem0;
    }

    @Override  // android.view.Menu
    public MenuItem add(CharSequence charSequence0) {
        return this.add(0, 0, 0, charSequence0);
    }

    @Override  // android.view.Menu
    public int addIntentOptions(int v, int v1, int v2, ComponentName componentName0, Intent[] arr_intent, Intent intent0, int v3, MenuItem[] arr_menuItem) {
        PackageManager packageManager0 = this.a.getPackageManager();
        List list0 = packageManager0.queryIntentActivityOptions(componentName0, arr_intent, intent0, 0);
        int v4 = list0 == null ? 0 : list0.size();
        if((v3 & 1) == 0) {
            this.removeGroup(v);
        }
        for(int v5 = 0; v5 < v4; ++v5) {
            ResolveInfo resolveInfo0 = (ResolveInfo)list0.get(v5);
            Intent intent1 = new Intent((resolveInfo0.specificIndex >= 0 ? arr_intent[resolveInfo0.specificIndex] : intent0));
            intent1.setComponent(new ComponentName(resolveInfo0.activityInfo.applicationInfo.packageName, resolveInfo0.activityInfo.name));
            MenuItem menuItem0 = this.add(v, v1, v2, resolveInfo0.loadLabel(packageManager0)).setIcon(resolveInfo0.loadIcon(packageManager0)).setIntent(intent1);
            if(arr_menuItem != null && resolveInfo0.specificIndex >= 0) {
                arr_menuItem[resolveInfo0.specificIndex] = menuItem0;
            }
        }
        return v4;
    }

    @Override  // android.view.Menu
    public SubMenu addSubMenu(int v) {
        return this.addSubMenu(0, 0, 0, this.b.getString(v));
    }

    @Override  // android.view.Menu
    public SubMenu addSubMenu(int v, int v1, int v2, int v3) {
        return this.addSubMenu(v, v1, v2, this.b.getString(v3));
    }

    @Override  // android.view.Menu
    public SubMenu addSubMenu(int v, int v1, int v2, CharSequence charSequence0) {
        MenuItem menuItem0 = this.add(v, v1, v2, charSequence0);
        return new c(this.a, this, menuItem0);
    }

    @Override  // android.view.Menu
    public SubMenu addSubMenu(CharSequence charSequence0) {
        return this.addSubMenu(0, 0, 0, charSequence0);
    }

    @Override  // android.view.Menu
    public void clear() {
        this.d.clear();
        this.d.trimToSize();
    }

    @Override  // android.view.Menu
    public void close() {
    }

    @Override  // android.view.Menu
    public MenuItem findItem(int v) {
        int v1 = this.a(v);
        return v1 < 0 ? null : ((b)this.d.get(v1));
    }

    @Override  // android.view.Menu
    public MenuItem getItem(int v) {
        return (MenuItem)this.d.get(v);
    }

    @Override  // android.view.Menu
    public boolean hasVisibleItems() {
        ArrayList arrayList0 = this.d;
        int v = arrayList0.size();
        for(int v1 = 0; true; ++v1) {
            if(v1 >= v) {
                return false;
            }
            if(((b)arrayList0.get(v1)).isVisible()) {
                return true;
            }
        }
    }

    @Override  // android.view.Menu
    public boolean isShortcutKey(int v, KeyEvent keyEvent0) {
        return this.a(v, keyEvent0) != null;
    }

    @Override  // android.view.Menu
    public boolean performIdentifierAction(int v, int v1) {
        int v2 = this.a(v);
        return v2 >= 0 ? ((b)this.d.get(v2)).a() : false;
    }

    @Override  // android.view.Menu
    public boolean performShortcut(int v, KeyEvent keyEvent0, int v1) {
        b b0 = this.a(v, keyEvent0);
        return b0 == null ? false : b0.a();
    }

    @Override  // android.view.Menu
    public void removeGroup(int v) {
        ArrayList arrayList0 = this.d;
        int v1 = arrayList0.size();
        int v2 = 0;
        while(v2 < v1) {
            if(((b)arrayList0.get(v2)).getGroupId() == v) {
                arrayList0.remove(v2);
                --v1;
            }
            else {
                ++v2;
            }
        }
    }

    @Override  // android.view.Menu
    public void removeItem(int v) {
        this.d.remove(this.a(v));
    }

    @Override  // android.view.Menu
    public void setGroupCheckable(int v, boolean z, boolean z1) {
        ArrayList arrayList0 = this.d;
        int v1 = arrayList0.size();
        for(int v2 = 0; v2 < v1; ++v2) {
            b b0 = (b)arrayList0.get(v2);
            if(b0.getGroupId() == v) {
                b0.setCheckable(z);
                b0.a(z1);
            }
        }
    }

    @Override  // android.view.Menu
    public void setGroupEnabled(int v, boolean z) {
        ArrayList arrayList0 = this.d;
        int v1 = arrayList0.size();
        for(int v2 = 0; v2 < v1; ++v2) {
            b b0 = (b)arrayList0.get(v2);
            if(b0.getGroupId() == v) {
                b0.setEnabled(z);
            }
        }
    }

    @Override  // android.view.Menu
    public void setGroupVisible(int v, boolean z) {
        ArrayList arrayList0 = this.d;
        int v1 = arrayList0.size();
        for(int v2 = 0; v2 < v1; ++v2) {
            b b0 = (b)arrayList0.get(v2);
            if(b0.getGroupId() == v) {
                b0.setVisible(z);
            }
        }
    }

    @Override  // android.view.Menu
    public void setQwertyMode(boolean z) {
        this.c = z;
    }

    @Override  // android.view.Menu
    public int size() {
        return this.d.size();
    }
}

