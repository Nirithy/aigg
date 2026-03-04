package android.ext;

import android.content.SharedPreferences.Editor;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import android.content.SharedPreferences;
import java.util.Map;
import java.util.Set;

public class qv implements SharedPreferences {
    final SharedPreferences a;

    private qv(SharedPreferences sharedPreferences0) {
        this.a = sharedPreferences0;
    }

    public static SharedPreferences a(SharedPreferences sharedPreferences0) {
        return !(sharedPreferences0 instanceof qv) ? new qv(sharedPreferences0) : sharedPreferences0;
    }

    @Override  // android.content.SharedPreferences
    public boolean contains(String s) {
        try {
            return this.a.contains(s);
        }
        catch(Throwable throwable0) {
            la.a(throwable0);
            return false;
        }
    }

    @Override  // android.content.SharedPreferences
    public SharedPreferences.Editor edit() {
        return this.a.edit();
    }

    @Override  // android.content.SharedPreferences
    public Map getAll() {
        return this.a.getAll();
    }

    @Override  // android.content.SharedPreferences
    public boolean getBoolean(String s, boolean z) {
        try {
            return this.a.getBoolean(s, z);
        }
        catch(Throwable throwable0) {
            la.a(throwable0);
            return z;
        }
    }

    @Override  // android.content.SharedPreferences
    public float getFloat(String s, float f) {
        try {
            return this.a.getFloat(s, f);
        }
        catch(Throwable throwable0) {
            la.a(throwable0);
            return f;
        }
    }

    @Override  // android.content.SharedPreferences
    public int getInt(String s, int v) {
        try {
            return this.a.getInt(s, v);
        }
        catch(Throwable throwable0) {
            la.a(throwable0);
            return v;
        }
    }

    @Override  // android.content.SharedPreferences
    public long getLong(String s, long v) {
        try {
            return this.a.getLong(s, v);
        }
        catch(Throwable throwable0) {
            la.a(throwable0);
            return v;
        }
    }

    @Override  // android.content.SharedPreferences
    public String getString(String s, String s1) {
        try {
            return this.a.getString(s, s1);
        }
        catch(Throwable throwable0) {
            la.a(throwable0);
            return s1;
        }
    }

    @Override  // android.content.SharedPreferences
    public Set getStringSet(String s, Set set0) {
        try {
            return this.a.getStringSet(s, set0);
        }
        catch(Throwable throwable0) {
            la.a(throwable0);
            return set0;
        }
    }

    @Override  // android.content.SharedPreferences
    public void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener sharedPreferences$OnSharedPreferenceChangeListener0) {
        try {
            this.a.registerOnSharedPreferenceChangeListener(sharedPreferences$OnSharedPreferenceChangeListener0);
        }
        catch(Throwable throwable0) {
            la.a(throwable0);
        }
    }

    @Override  // android.content.SharedPreferences
    public void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener sharedPreferences$OnSharedPreferenceChangeListener0) {
        try {
            this.a.unregisterOnSharedPreferenceChangeListener(sharedPreferences$OnSharedPreferenceChangeListener0);
        }
        catch(Throwable throwable0) {
            la.a(throwable0);
        }
    }
}

