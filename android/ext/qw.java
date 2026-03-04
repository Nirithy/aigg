package android.ext;

import android.content.SharedPreferences.Editor;
import java.util.Set;

public class qw implements SharedPreferences.Editor {
    final SharedPreferences.Editor a;

    public qw() {
        this.a = Tools.s().edit();
    }

    public qw(SharedPreferences.Editor sharedPreferences$Editor0) {
        this.a = sharedPreferences$Editor0;
    }

    public qw a() {
        this.a.clear();
        return this;
    }

    public qw a(String s) {
        this.a.remove(s);
        return this;
    }

    public qw a(String s, float f) {
        this.a.putFloat(s, f);
        return this;
    }

    public qw a(String s, float f, float f1) {
        if(f == f1) {
            this.a.remove(s);
            return this;
        }
        this.a.putFloat(s, f);
        return this;
    }

    public qw a(String s, int v) {
        this.a.putInt(s, v);
        return this;
    }

    public qw a(String s, int v, int v1) {
        if(v == v1) {
            this.a.remove(s);
            return this;
        }
        this.a.putInt(s, v);
        return this;
    }

    public qw a(String s, long v) {
        this.a.putLong(s, v);
        return this;
    }

    public qw a(String s, long v, long v1) {
        if(v == v1) {
            this.a.remove(s);
            return this;
        }
        this.a.putLong(s, v);
        return this;
    }

    public qw a(String s, String s1) {
        this.a.putString(s, s1);
        return this;
    }

    public qw a(String s, String s1, String s2) {
        if(s1.equals(s2)) {
            this.a.remove(s);
            return this;
        }
        this.a.putString(s, s1);
        return this;
    }

    public qw a(String s, Set set0) {
        this.a.putStringSet(s, set0);
        return this;
    }

    public qw a(String s, boolean z) {
        this.a.putBoolean(s, z);
        return this;
    }

    public qw a(String s, boolean z, boolean z1) {
        if(z == z1) {
            this.a.remove(s);
            return this;
        }
        this.a.putBoolean(s, z);
        return this;
    }

    @Override  // android.content.SharedPreferences$Editor
    public void apply() {
        this.a.apply();
    }

    @Override  // android.content.SharedPreferences$Editor
    public SharedPreferences.Editor clear() {
        return this.a();
    }

    @Override  // android.content.SharedPreferences$Editor
    public boolean commit() {
        return this.a.commit();
    }

    @Override  // android.content.SharedPreferences$Editor
    public SharedPreferences.Editor putBoolean(String s, boolean z) {
        return this.a(s, z);
    }

    @Override  // android.content.SharedPreferences$Editor
    public SharedPreferences.Editor putFloat(String s, float f) {
        return this.a(s, f);
    }

    @Override  // android.content.SharedPreferences$Editor
    public SharedPreferences.Editor putInt(String s, int v) {
        return this.a(s, v);
    }

    @Override  // android.content.SharedPreferences$Editor
    public SharedPreferences.Editor putLong(String s, long v) {
        return this.a(s, v);
    }

    @Override  // android.content.SharedPreferences$Editor
    public SharedPreferences.Editor putString(String s, String s1) {
        return this.a(s, s1);
    }

    @Override  // android.content.SharedPreferences$Editor
    public SharedPreferences.Editor putStringSet(String s, Set set0) {
        return this.a(s, set0);
    }

    @Override  // android.content.SharedPreferences$Editor
    public SharedPreferences.Editor remove(String s) {
        return this.a(s);
    }
}

