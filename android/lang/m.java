package android.lang;

import java.io.FileDescriptor;
import java.lang.reflect.Field;
import java.util.Map;

public final class m {
    static final boolean a;

    static {
        m.a = !m.class.desiredAssertionStatus();
    }

    public static int a(FileDescriptor fileDescriptor0) {
        try {
            Field field0 = FileDescriptor.class.getDeclaredField("descriptor");
            field0.setAccessible(true);
            return (int)(((Integer)field0.get(fileDescriptor0)));
        }
        catch(Throwable throwable0) {
            throw new RuntimeException("Failed get fd", throwable0);
        }
    }

    static Process a(String[] arr_s, Map map0, String s, boolean z) {
        if(!m.a && (arr_s == null || arr_s.length <= 0)) {
            throw new AssertionError();
        }
        byte[][] arr2_b = new byte[arr_s.length - 1][];
        int v = arr2_b.length;
        for(int v1 = 0; v1 < arr2_b.length; ++v1) {
            arr2_b[v1] = arr_s[v1 + 1].getBytes();
            v += arr2_b[v1].length;
        }
        byte[] arr_b = new byte[v];
        int v3 = 0;
        for(int v2 = 0; v2 < arr2_b.length; ++v2) {
            byte[] arr_b1 = arr2_b[v2];
            System.arraycopy(arr_b1, 0, arr_b, v3, arr_b1.length);
            v3 += arr_b1.length + 1;
        }
        int[] arr_v = new int[1];
        byte[] arr_b2 = ProcessEnvironment.a(map0, arr_v);
        byte[] arr_b3 = m.a(arr_s[0]);
        int v4 = arr_v[0];
        byte[] arr_b4 = m.a(s);
        return new UNIXProcess(arr_b3, arr_b, arr2_b.length, arr_b2, v4, arr_b4, new int[]{-1, -1, -1}, z);
    }

    private static byte[] a(String s) {
        if(s == null) {
            return null;
        }
        byte[] arr_b = s.getBytes();
        byte[] arr_b1 = new byte[arr_b.length + 1];
        System.arraycopy(arr_b, 0, arr_b1, 0, arr_b.length);
        arr_b1[arr_b1.length - 1] = 0;
        return arr_b1;
    }
}

