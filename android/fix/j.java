package android.fix;

import android.annotation.TargetApi;
import android.ext.la;
import android.os.Build.VERSION;
import android.util.SparseArray;
import java.lang.reflect.Field;

public class j extends SparseArray {
    private void a() {
        try {
            Field field0 = SparseArray.class.getDeclaredField("mKeys");
            field0.setAccessible(true);
            Field field1 = SparseArray.class.getDeclaredField("mValues");
            field1.setAccessible(true);
            Field field2 = SparseArray.class.getDeclaredField("mSize");
            field2.setAccessible(true);
            int v = field2.getInt(this);
            int v1 = ((int[])field0.get(this)).length;
            int v2 = ((Object[])field1.get(this)).length;
            if(v > v1 || v > v2) {
                field2.setInt(this, Math.min(Math.min(v, v1), v2));
            }
        }
        catch(Throwable throwable0) {
            la.b("Failed fix", throwable0);
        }
    }

    public Object a(int v) {
        synchronized(this) {
            return this.get(v);
        }
    }

    public void a(int v, Object object0) {
        synchronized(this) {
            this.put(v, object0);
        }
    }

    @Override  // android.util.SparseArray
    public void clear() {
        try {
            super.clear();
        }
        catch(ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException0) {
            la.a(arrayIndexOutOfBoundsException0);
            this.a();
            super.clear();
        }
    }

    @Override  // android.util.SparseArray
    public void delete(int v) {
        try {
            super.delete(v);
        }
        catch(ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException0) {
            la.a(arrayIndexOutOfBoundsException0);
            this.a();
            super.delete(v);
        }
    }

    @Override  // android.util.SparseArray
    public Object get(int v, Object object0) {
        try {
            return super.get(v, object0);
        }
        catch(ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException0) {
            la.a(arrayIndexOutOfBoundsException0);
            this.a();
            return super.get(v, object0);
        }
    }

    @Override  // android.util.SparseArray
    public int indexOfKey(int v) {
        try {
            return super.indexOfKey(v);
        }
        catch(ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException0) {
            la.a(arrayIndexOutOfBoundsException0);
            this.a();
            return super.indexOfKey(v);
        }
    }

    @Override  // android.util.SparseArray
    public void put(int v, Object object0) {
        try {
            super.put(v, object0);
        }
        catch(ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException0) {
            la.a(arrayIndexOutOfBoundsException0);
            this.a();
            super.put(v, object0);
        }
    }

    @Override  // android.util.SparseArray
    @TargetApi(11)
    public void removeAt(int v) {
        if(Build.VERSION.SDK_INT > 11) {
            super.removeAt(v);
            return;
        }
        this.remove(this.keyAt(v));
    }

    @Override  // android.util.SparseArray
    public int size() {
        return super.size();
    }
}

