package android.ext;

public class pp {
    public static int a(Object object0, Object object1) {
        String s = object0.toString();
        String s1 = object1.toString();
        int v = 0;
        int v2 = s.length();
        int v3 = s1.length();
        for(int v1 = 0; true; ++v1) {
            int v4 = v1 < v3 ? s1.charAt(v1) : 0;
            int v5 = v < v2 ? s.charAt(v) : 0;
            int v6 = 0;
            int v7 = v;
            while(v5 == 0x20 || v5 == 0x30) {
                int v8 = v5 == 0x30 ? v6 + 1 : 0;
                ++v7;
                v5 = v7 < v2 ? s.charAt(v7) : 0;
                v6 = v8;
            }
            int v9 = v4;
            int v10 = 0;
            while(v9 == 0x20 || v9 == 0x30) {
                v10 = v9 == 0x30 ? v10 + 1 : 0;
                v9 = v1 + 1 < v3 ? s1.charAt(v1 + 1) : 0;
                ++v1;
            }
            if(v5 <= 57 && v9 <= 57 && 0x30 <= v5 && 0x30 <= v9) {
                int v11 = pp.a(s.substring(v7), s1.substring(v1));
                if(v11 != 0) {
                    return v11;
                }
            }
            if(v5 == 0 && v9 == 0) {
                return v6 - v10;
            }
            if(v5 < v9) {
                return -1;
            }
            if(v5 > v9) {
                return 1;
            }
            v = v7 + 1;
        }
    }

    private static int a(String s, String s1) {
        int v = s.length();
        int v1 = s1.length();
        int v2 = 0;
        int v4 = 0;
        for(int v3 = 0; true; ++v3) {
            int v5 = v3 < v ? s.charAt(v3) : 0;
            int v6 = v2 < v1 ? s1.charAt(v2) : 0;
            boolean z = v5 > 57 || 0x30 > v5;
            boolean z1 = v6 > 57 || 0x30 > v6;
            if(z && z1) {
                break;
            }
            if(z) {
                return -1;
            }
            if(z1) {
                return 1;
            }
            if(v5 == 0 && v6 == 0) {
                break;
            }
            if(v4 == 0) {
                if(v5 < v6) {
                    v4 = -1;
                }
                else if(v5 > v6) {
                    v4 = 1;
                }
            }
            ++v2;
        }
        return v4;
    }
}

