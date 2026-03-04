package android.c;

import java.lang.reflect.Array;

public final class d {
    static final boolean a;

    static {
        d.a = !d.class.desiredAssertionStatus();
    }

    public static int a(int v) {
        return v > 4 ? v * 2 : 8;
    }

    public static int[] a(int[] arr_v, int v, int v1) {
        if(!d.a && v > arr_v.length) {
            throw new AssertionError();
        }
        if(v + 1 > arr_v.length) {
            int[] arr_v1 = new int[d.a(v)];
            System.arraycopy(arr_v, 0, arr_v1, 0, v);
            arr_v = arr_v1;
        }
        arr_v[v] = v1;
        return arr_v;
    }

    public static long[] a(long[] arr_v, int v, int v1, long v2) {
        if(!d.a && v > arr_v.length) {
            throw new AssertionError();
        }
        if(v + 1 <= arr_v.length) {
            System.arraycopy(arr_v, v1, arr_v, v1 + 1, v - v1);
            arr_v[v1] = v2;
            return arr_v;
        }
        long[] arr_v1 = new long[d.a(v)];
        System.arraycopy(arr_v, 0, arr_v1, 0, v1);
        arr_v1[v1] = v2;
        System.arraycopy(arr_v, v1, arr_v1, v1 + 1, arr_v.length - v1);
        return arr_v1;
    }

    public static Object[] a(Object[] arr_object, int v, int v1, Object object0) {
        if(!d.a && v > arr_object.length) {
            throw new AssertionError();
        }
        if(v + 1 <= arr_object.length) {
            System.arraycopy(arr_object, v1, arr_object, v1 + 1, v - v1);
            arr_object[v1] = object0;
            return arr_object;
        }
        Object[] arr_object1 = (Object[])Array.newInstance(arr_object.getClass().getComponentType(), d.a(v));
        System.arraycopy(arr_object, 0, arr_object1, 0, v1);
        arr_object1[v1] = object0;
        System.arraycopy(arr_object, v1, arr_object1, v1 + 1, arr_object.length - v1);
        return arr_object1;
    }

    public static Object[] a(Object[] arr_object, int v, Object object0) {
        Object[] arr_object1;
        if(!d.a && v > arr_object.length) {
            throw new AssertionError();
        }
        if(v + 1 > arr_object.length) {
            arr_object1 = (Object[])Array.newInstance(arr_object.getClass().getComponentType(), d.a(v));
            System.arraycopy(arr_object, 0, arr_object1, 0, v);
        }
        else {
            arr_object1 = arr_object;
        }
        arr_object1[v] = object0;
        return arr_object1;
    }

    public static boolean[] a(boolean[] arr_z, int v, int v1, boolean z) {
        if(!d.a && v > arr_z.length) {
            throw new AssertionError();
        }
        if(v + 1 <= arr_z.length) {
            System.arraycopy(arr_z, v1, arr_z, v1 + 1, v - v1);
            arr_z[v1] = z;
            return arr_z;
        }
        boolean[] arr_z1 = new boolean[d.a(v)];
        System.arraycopy(arr_z, 0, arr_z1, 0, v1);
        arr_z1[v1] = z;
        System.arraycopy(arr_z, v1, arr_z1, v1 + 1, arr_z.length - v1);
        return arr_z1;
    }
}

