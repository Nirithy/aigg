package lasm;

public class g extends Exception {
    public i a;
    public int[][] b;
    public String[] c;
    protected String d;

    public g() {
        this.d = System.getProperty("line.separator", "\n");
    }

    public g(String s) {
        super(s);
        this.d = "\n";
    }

    public g(String s, Throwable throwable0) {
        super(s, throwable0);
        this.d = "\n";
    }

    public g(i i0, int[][] arr2_v, String[] arr_s) {
        super(g.a(i0, arr2_v, arr_s));
        this.d = System.getProperty("line.separator", "\n");
        this.a = i0;
        this.b = arr2_v;
        this.c = arr_s;
    }

    static String a(String s) {
        StringBuffer stringBuffer0 = new StringBuffer();
        for(int v = 0; v < s.length(); ++v) {
            switch(s.charAt(v)) {
                case 0: {
                    break;
                }
                case 8: {
                    stringBuffer0.append("\\b");
                    break;
                }
                case 9: {
                    stringBuffer0.append("\\t");
                    break;
                }
                case 10: {
                    stringBuffer0.append("\\n");
                    break;
                }
                case 12: {
                    stringBuffer0.append("\\f");
                    break;
                }
                case 13: {
                    stringBuffer0.append("\\r");
                    break;
                }
                case 34: {
                    stringBuffer0.append("\\\"");
                    break;
                }
                case 39: {
                    stringBuffer0.append("\\\'");
                    break;
                }
                case 92: {
                    stringBuffer0.append("\\\\");
                    break;
                }
                default: {
                    int v1 = s.charAt(v);
                    if(v1 >= 0x20 && v1 <= 0x7E) {
                        stringBuffer0.append(((char)v1));
                    }
                    else {
                        String s1 = "0000" + Integer.toString(v1, 16);
                        stringBuffer0.append("\\u" + s1.substring(s1.length() - 4, s1.length()));
                    }
                }
            }
        }
        return stringBuffer0.toString();
    }

    private static String a(i i0, int[][] arr2_v, String[] arr_s) {
        String s = System.getProperty("line.separator", "\n");
        StringBuffer stringBuffer0 = new StringBuffer();
        int v1 = 0;
        for(int v = 0; v < arr2_v.length; ++v) {
            if(v1 < arr2_v[v].length) {
                v1 = arr2_v[v].length;
            }
            for(int v2 = 0; v2 < arr2_v[v].length; ++v2) {
                stringBuffer0.append(arr_s[arr2_v[v][v2]]).append(' ');
            }
            if(arr2_v[v][arr2_v[v].length - 1] != 0) {
                stringBuffer0.append("...");
            }
            stringBuffer0.append(s).append("    ");
        }
        String s1 = "Encountered \"";
        i i1 = i0.g;
        for(int v3 = 0; v3 < v1; ++v3) {
            if(v3 != 0) {
                s1 = s1 + " ";
            }
            if(i1.a == 0) {
                s1 = s1 + arr_s[0];
                break;
            }
            s1 = s1 + " " + arr_s[i1.a] + " \"" + g.a(i1.f) + " \"";
            i1 = i1.g;
        }
        String s2 = s1 + "\" at line " + i0.g.b + ", column " + i0.g.c + "." + s;
        return arr2_v.length == 1 ? s2 + "Was expecting:" + s + "    " + stringBuffer0.toString() : s2 + "Was expecting one of:" + s + "    " + stringBuffer0.toString();
    }
}

