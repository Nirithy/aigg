package android.lang;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

final class ProcessEnvironment {
    private static final HashMap a;
    private static final Map b;

    static {
        byte[][] arr2_b = ProcessEnvironment.environ();
        ProcessEnvironment.a = new HashMap(arr2_b.length / 2 + 3);
        for(int v = arr2_b.length - 1; v > 0; v -= 2) {
            l l0 = l.a(arr2_b[v - 1]);
            k k0 = k.a(arr2_b[v]);
            ProcessEnvironment.a.put(l0, k0);
        }
        ProcessEnvironment.b = Collections.unmodifiableMap(new f(ProcessEnvironment.a));
    }

    static Map a(int v) {
        return new f(new HashMap(v));
    }

    static byte[] a(Map map0, int[] arr_v) {
        return map0 == null ? null : ((f)map0).a(arr_v);
    }

    private static int b(byte[] arr_b) {
        int v = 0;
        int v1;
        for(v1 = 0; v < arr_b.length; v1 = v2) {
            int v2 = v1 * 0x1F + arr_b[v];
            ++v;
        }
        return v1;
    }

    private static int c(byte[] arr_b, byte[] arr_b1) {
        int v = arr_b.length >= arr_b1.length ? arr_b1.length : arr_b.length;
        for(int v1 = 0; true; ++v1) {
            if(v1 >= v) {
                return arr_b.length - arr_b1.length;
            }
            if(arr_b[v1] != arr_b1[v1]) {
                return arr_b[v1] - arr_b1[v1];
            }
        }
    }

    private static void c(String s) {
        if(s.indexOf(61) != -1 || s.indexOf(0) != -1) {
            throw new IllegalArgumentException("Invalid environment variable name: \"" + s + '\"');
        }
    }

    private static void d(String s) {
        if(s.indexOf(0) != -1) {
            throw new IllegalArgumentException("Invalid environment variable value: \"" + s + '\"');
        }
    }

    private static boolean d(byte[] arr_b, byte[] arr_b1) {
        if(arr_b.length == arr_b1.length) {
            for(int v = 0; true; ++v) {
                if(v >= arr_b.length) {
                    return true;
                }
                if(arr_b[v] != arr_b1[v]) {
                    break;
                }
            }
        }
        return false;
    }

    private static native byte[][] environ() {
    }
}

