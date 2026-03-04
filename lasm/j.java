package lasm;

public class j extends Error {
    int a;
    int b;
    int c;

    public j() {
    }

    public j(String s, int v) {
        super(s);
        this.a = v;
    }

    public j(boolean z, int v, int v1, int v2, String s, char c, int v3) {
        this(j.a(z, v, v1, v2, s, c), v3);
        this.b = v1;
        this.c = v2;
    }

    protected static final String a(String s) {
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

    protected static String a(boolean z, int v, int v1, int v2, String s, char c) {
        StringBuilder stringBuilder0 = new StringBuilder("Lexical error at line ").append(v1).append(", column ").append(v2).append(".  Encountered: ");
        return z ? stringBuilder0.append("<EOF> ").append("after : \"").append(j.a(s)).append("\"").toString() : stringBuilder0.append("\"" + j.a(String.valueOf(c)) + "\"" + " (" + ((int)c) + "), ").append("after : \"").append(j.a(s)).append("\"").toString();
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }
}

