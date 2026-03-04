package lasm;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import luaj.LuaString;
import luaj.LuaValue;
import luaj.a;

public class LasmBase {
    static int a(i i0) {
        return LasmBase.b(i0, 0);
    }

    static int a(i i0, int v) {
        int v1 = LasmBase.b(i0, 0);
        if(v1 > v) {
            throw new c(i0, "\'" + i0.f + "\' parsed as " + v1 + " out of possible range [0; " + v + "]");
        }
        return v1;
    }

    public static String a(Throwable throwable0, String s, boolean z) {
        String s2;
        int v1;
        int v;
        if(throwable0 instanceof c) {
            v = ((c)throwable0).a.b;
            v1 = ((c)throwable0).a.c;
        }
        else if(throwable0 instanceof g) {
            v = ((g)throwable0).a.g.b;
            v1 = ((g)throwable0).a.g.c;
        }
        else if(throwable0 instanceof j) {
            v = ((j)throwable0).b;
            v1 = ((j)throwable0).c;
        }
        else {
            v1 = 0;
            v = 0;
        }
        if(v > 0) {
            BufferedReader bufferedReader0 = new BufferedReader(new InputStreamReader(new FileInputStream(s)));
            int v2 = 0;
            while(true) {
                String s1 = bufferedReader0.readLine();
                if(s1 == null) {
                    s2 = "";
                    break;
                }
                ++v2;
                if(v2 == v) {
                    if(z) {
                        s2 = "\n" + s1.substring(0, v1 - 1) + '⁣' + s1.substring(v1 - 1) + "\n";
                        break;
                    }
                    s2 = "\n" + s1 + "\n" + new String(new char[v1 - 1]).replace("\u0000", "_") + "^\n";
                    break;
                }
            }
            bufferedReader0.close();
            return s2;
        }
        return "";
    }

    static void a(LasmBase.V lasmBase$V0, LasmBase.V lasmBase$V1) {
        if(lasmBase$V0.a != lasmBase$V1.a) {
            throw new c(lasmBase$V1.b, "Register must be " + lasmBase$V0.b.f);
        }
    }

    static void a(LasmBase.V lasmBase$V0, LasmBase.V lasmBase$V1, int v) {
    }

    static int b(i i0) {
        try {
            return (int)Long.parseLong(i0.f.substring(2), 16);
        }
        catch(NumberFormatException numberFormatException0) {
            throw new c(i0, "Failed parse \'" + i0.f + "\' as hex", numberFormatException0);
        }
    }

    static int b(i i0, int v) {
        try {
            return Integer.parseInt(i0.f.substring(v));
        }
        catch(NumberFormatException numberFormatException0) {
            throw new c(i0, "Failed parse \'" + i0.f + "\' as integer", numberFormatException0);
        }
    }

    static long c(i i0) {
        try {
            return Long.parseLong(i0.f);
        }
        catch(NumberFormatException numberFormatException0) {
            throw new c(i0, "Failed parse \'" + i0.f + "\' as long", numberFormatException0);
        }
    }

    static LuaValue d(i i0) {
        try {
            return LuaValue.c(i0.f, LuaValue.y);
        }
        catch(NumberFormatException numberFormatException0) {
            throw new c(i0, "Failed parse \'" + i0.f + "\' as Lua number", numberFormatException0);
        }
    }

    static LuaString e(i i0) {
        int v6;
        if(i0.a == 56) {
            return null;
        }
        byte[] arr_b = i0.f.getBytes();
        a a0 = new a(arr_b.length - 2);
        int v = arr_b.length - 1;
        int v1 = 1;
        int v2 = 0;
        int v3 = 0;
        int v4 = 0;
        while(true) {
            if(v1 >= v) {
                if(v4 == 3) {
                    a0.a(((byte)v3));
                }
                if(v4 == 2 || v4 == 6) {
                    i0.c += arr_b.length - 1;
                    throw new c(i0, "Unfinished " + (v4 == 6 ? "unicode" : "hex") + " escape sequence");
                }
                return a0.b();
            }
            int v5 = arr_b[v1];
        alab1:
            switch(v4) {
                case 0: {
                    if(v5 == 92) {
                        v4 = 1;
                    }
                    else {
                        a0.a(((byte)v5));
                    }
                    break;
                }
                case 1: {
                    if(0x30 > v5 || v5 > 57) {
                        switch(v5) {
                            case 97: {
                                v5 = 7;
                                v4 = 0;
                                a0.a(((byte)v5));
                                break alab1;
                            }
                            case 98: {
                                v5 = 8;
                                v4 = 0;
                                a0.a(((byte)v5));
                                break alab1;
                            }
                            case 102: {
                                v5 = 12;
                                v4 = 0;
                                a0.a(((byte)v5));
                                break alab1;
                            }
                            case 110: {
                                v5 = 10;
                                v4 = 0;
                                a0.a(((byte)v5));
                                break alab1;
                            }
                            case 0x72: {
                                v5 = 13;
                                v4 = 0;
                                a0.a(((byte)v5));
                                break alab1;
                            }
                            case 0x74: {
                                v5 = 9;
                                v4 = 0;
                                a0.a(((byte)v5));
                                break alab1;
                            }
                            case 0x76: {
                                v5 = 11;
                                v4 = 0;
                                a0.a(((byte)v5));
                                break alab1;
                            }
                            case 0x75: 
                            case 120: {
                                v2 = v5 == 0x75 ? -1 : 0;
                                v3 = 0;
                                v4 = v5 == 0x75 ? 6 : 2;
                                break alab1;
                            }
                            case 0x7A: {
                                v4 = 4;
                                break alab1;
                            }
                            default: {
                                v4 = 0;
                                a0.a(((byte)v5));
                                break alab1;
                            }
                        }
                    }
                    else {
                        v3 = v5 - 0x30;
                        v2 = 1;
                        v4 = 3;
                        break;
                    }
                    goto label_52;
                }
                case 3: {
                    if(0x30 > v5 || v5 > 57) {
                        v6 = v1 - 1;
                    label_89:
                        v4 = 0;
                        a0.a(((byte)v3));
                        v1 = v6;
                    }
                    else {
                        v3 = v3 * 10 + (v5 - 0x30);
                        ++v2;
                        if(v2 >= 3) {
                            v6 = v1;
                            goto label_89;
                        }
                    }
                    break;
                }
                case 4: {
                    switch(v5) {
                        case 9: 
                        case 10: 
                        case 11: 
                        case 12: 
                        case 13: 
                        case 0x20: {
                            break alab1;
                        }
                        default: {
                            v4 = 0;
                            a0.a(((byte)v5));
                            break alab1;
                        }
                    }
                }
                case 2: 
                case 6: {
                label_52:
                    v3 *= 16;
                    if(v2 != -1) {
                        if(v4 == 6 && v5 == 0x7D) {
                            v3 /= 16;
                            if(v3 > 0x10FFFF) {
                                throw new c(i0, "UTF-8 value too large: 0x" + Integer.toHexString(v3) + " (max allowed = 0x" + "10ffff" + ")");
                            }
                            a0.a(v3);
                            v4 = 0;
                            break;
                        }
                        else if(0x30 <= v5 && v5 <= 57) {
                            v3 += v5 - 0x30;
                        }
                        else if(97 <= v5 && v5 <= 102) {
                            v3 += v5 - 87;
                        }
                        else if(65 > v5 || v5 > 70) {
                            v2 += 100;
                        }
                        else {
                            v3 += v5 - 55;
                        }
                    }
                    else if(v5 != 0x7B) {
                        v2 = 99;
                    }
                    ++v2;
                    if(v2 >= v4) {
                        if(v2 == 2) {
                            v4 = 0;
                            a0.a(((byte)v3));
                            break;
                        }
                        i0.c += v1;
                        throw new c(i0, "Invalid char \'" + v5 + "\' (code 0x" + Integer.toHexString(v5) + ") in " + (v4 == 6 ? "unicode" : "hex") + " escape sequence, must be " + (v4 == 6 ? "\\u{XXX}" : "\\xXX"));
                    }
                    break;
                }
                default: {
                    a0.a(((byte)v5));
                }
            }
            ++v1;
        }
    }
}

