package lasm;

import java.io.IOException;
import java.io.PrintStream;

public class f implements b {
    public PrintStream a;
    static final long[] b;
    static final long[] c;
    static final int[] d;
    public static final String[] f;
    public static final String[] g;
    public static final int[] h;
    static final long[] i;
    static final long[] j;
    static final long[] k;
    protected h l;
    protected char m;
    int n;
    int o;
    int p;
    int q;
    int r;
    int s;
    private final int[] t;
    private final int[] u;

    static {
        f.b = new long[]{-2L, -1L, -1L, -1L};
        f.c = new long[]{0L, 0L, -1L, -1L};
        f.d = new int[]{3, 0, 5, 49, 33, 34, 39, 40, 44, 45, 1, 2, 1, 2, 0, 5, 46, 3, 0, 5, 27, 0x20, 22, 24, 25, 17, 19, 20, 33, 34, 39, 40, 30, 0x1F, 37, 38, 41, 42, 50, 0x1F, 0x20, 37, 38, 42, 43, 1, 2, 44, 3, 0, 5, 25, 30, 20, 22, 23, 15, 17, 18, 0x1F, 0x20, 37, 38, 0x2F, 0x30, 28, 29, 35, 36, 39, 40, 37, 50, 39, 40, 45, 46, 0x20, 33, 1, 2, 37, 26, 38, 34, 3, 0, 5, 39, 40, 45, 46, 29, 30, 43, 44, 51, 35, 36, 41, 42, 46, 0x2F, 3, 4, 3, 4, 2, 7, 0x30, 5, 2, 7, 29, 34, 24, 26, 27, 19, 21, 22, 5, 2, 7, 35, 36, 41, 42, 0x20, 33};
        f.f = new String[]{"", null, null, null, null, "MOVE", "LOADK", "LOADBOOL", "LOADNIL", "GETUPVAL", "GETTABUP", "GETTABLE", "SETTABUP", "SETUPVAL", "SETTABLE", "NEWTABLE", "SELF", "ADD", "SUB", "MUL", "DIV", "MOD", "POW", "UNM", "NOT", "LEN", "CONCAT", "JMP", "EQ", "LT", "LE", "TEST", "TESTSET", "CALL", "TAILCALL", "RETURN", "FORLOOP", "FORPREP", "TFORCALL", "TFORLOOP", "SETLIST", "CLOSURE", "VARARG", "IDIV", "BNOT", "BAND", "BOR", "BXOR", "SHL", "SHR", "CONST", "FUNC[", "GOTO[", "OP", "SET_TOP", "SKIP_NEXT", "nil", "true", "false", null, null, null, ".source", ".linedefined", ".lastlinedefined", ".numparams", ".is_vararg", ".maxstacksize", ".upval", ".line", ".local", ".end local", ".func", ".end", null, "..", null, null, null, null, null, null, null, null, null, null, null, null, "[", "]"};
        f.g = new String[]{"STATE_NAME", "STATE_SINT", "STATE_V_NAME", "DEFAULT"};
        f.h = new int[]{-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 2, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 1, -1, -1, -1, -1, -1, -1, 0, 3, 3, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 0, -1, 3, -1, -1, -1, -1, 3, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
        f.i = new long[]{0xFFFFFFFFFFFFFFE1L, 0x313FFFFL};
        f.j = new long[]{30L, 0L};
        f.k = new long[]{16L, 0L};
    }

    public f(h h0) {
        this.a = System.out;
        this.t = new int[52];
        this.u = new int[104];
        this.n = 3;
        this.o = 3;
        this.l = h0;
    }

    private int A(long v, long v1, long v2, long v3) {
        long v4 = v1 & v;
        long v5 = v3 & v2;
        if((v4 | v5) == 0L) {
            return this.f(4, v, v2);
        }
        try {
            this.m = this.l.c();
            switch(this.m) {
                case 65: {
                    return this.B(v4, 0x2200L, v5, 0L);
                }
                case 69: {
                    return (0x20000000000L & v4) == 0L ? this.B(v4, 0x80000000000000L, v5, 0L) : this.a(6, 41);
                }
                case 76: {
                    return (0x100L & v4) == 0L ? this.B(v4, 0x440000C800L, v5, 0L) : this.a(6, 8);
                }
                case 0x4F: {
                    return this.B(v4, 0x8000000080L, v5, 0L);
                }
                case 80: {
                    goto label_13;
                }
                case 84: {
                    goto label_18;
                }
                case 85: {
                    return this.B(v4, 0x1400L, v5, 0L);
                }
                case 97: {
                    return this.B(v4, 0L, v5, 8L);
                }
                case 101: {
                    return (0x4000000000000000L & v4) == 0L ? this.B(v4, 0x8000000000000000L, v5, 0L) : this.a(6, 62);
                }
                case 105: {
                    return this.B(v4, 0L, v5, 1L);
                }
                case 0x6F: {
                    return this.B(v4, 0L, v5, 0x80L);
                }
                case 0x72: {
                    return this.B(v4, 0L, v5, 6L);
                }
            }
        }
        catch(IOException unused_ex) {
            return 6;
        }
        return this.f(5, v4, v5);
    label_13:
        if((0x1000000000L & v4) != 0L) {
            return this.a(6, 36);
        }
        if((0x2000000000L & v4) != 0L) {
            return this.a(6, 37);
        }
        return (0x40000000000000L & v4) == 0L ? this.f(5, v4, v5) : this.a(6, 54);
    label_18:
        if((0x100000000L & v4) != 0L) {
            return this.a(6, 0x20);
        }
        return (0x10000000000L & v4) == 0L ? this.f(5, v4, v5) : this.a(6, 40);
    }

    private int B(long v, long v1, long v2, long v3) {
        long v4 = v1 & v;
        long v5 = v3 & v2;
        if((v4 | v5) == 0L) {
            return this.f(5, v, v2);
        }
        try {
            this.m = this.l.c();
            switch(this.m) {
                case 69: {
                    goto label_9;
                }
                case 76: {
                    goto label_14;
                }
                case 80: {
                    goto label_23;
                }
                case 88: {
                    return this.C(v4, 0x80000000000000L, v5, 0L);
                }
                case 97: {
                    return this.C(v4, 0L, v5, 6L);
                }
                case 99: {
                    return this.C(v4, 0L, v5, 0x88L);
                }
                case 102: {
                    return this.C(v4, 0x8000000000000000L, v5, 0L);
                }
                case 110: {
                    return this.C(v4, 0L, v5, 1L);
                }
            }
        }
        catch(IOException unused_ex) {
            return 7;
        }
        return this.f(6, v4, v5);
    label_9:
        if((0x800L & v4) != 0L) {
            return this.a(7, 11);
        }
        if((0x4000L & v4) != 0L) {
            return this.a(7, 14);
        }
        return (0x8000L & v4) == 0L ? this.f(6, v4, v5) : this.a(7, 15);
    label_14:
        if((0x80L & v4) != 0L) {
            return this.a(7, 7);
        }
        if((0x200L & v4) != 0L) {
            return this.a(7, 9);
        }
        if((0x2000L & v4) != 0L) {
            return this.a(7, 13);
        }
        if((0x400000000L & v4) != 0L) {
            return this.a(7, 34);
        }
        return (0x4000000000L & v4) == 0L ? this.f(6, v4, v5) : this.a(7, 38);
    label_23:
        if((0x400L & v4) != 0L) {
            return this.a(7, 10);
        }
        if((0x1000L & v4) != 0L) {
            return this.a(7, 12);
        }
        return (0x8000000000L & v4) == 0L ? this.f(6, v4, v5) : this.a(7, 39);
    }

    private int C(long v, long v1, long v2, long v3) {
        long v4 = v1 & v;
        long v5 = v3 & v2;
        if((v4 | v5) == 0L) {
            return this.f(6, v, v2);
        }
        try {
            this.m = this.l.c();
            switch(this.m) {
                case 84: {
                    return (0x80000000000000L & v4) == 0L ? this.f(7, v4, v5) : this.a(8, 55);
                }
                case 97: {
                    return this.D(v4, 0L, v5, 0x80L);
                }
                case 101: {
                    return this.D(v4, 0L, v5, 1L);
                }
                case 105: {
                    return this.D(v4, 0x8000000000000000L, v5, 0L);
                }
                case 107: {
                    return this.D(v4, 0L, v5, 8L);
                }
                case 109: {
                    return this.D(v4, 0L, v5, 2L);
                }
                case 0x72: {
                    return this.D(v4, 0L, v5, 4L);
                }
            }
        }
        catch(IOException unused_ex) {
            return 8;
        }
        return this.f(7, v4, v5);
    }

    private int D(long v, long v1, long v2, long v3) {
        long v4 = v1 & v;
        long v5 = v3 & v2;
        if((v4 | v5) == 0L) {
            return this.f(7, v, v2);
        }
        try {
            this.m = this.l.c();
            switch(this.m) {
                case 100: {
                    return this.E(v4, 0L, v5, 1L);
                }
                case 103: {
                    return (4L & v5) == 0L ? this.f(8, v4, v5) : this.a(9, 66);
                }
                case 108: {
                    return (0x80L & v5) == 0L ? this.f(8, v4, v5) : this.a(9, 71);
                }
                case 110: {
                    return this.E(v4, 0x8000000000000000L, v5, 0L);
                }
                case 0x73: {
                    return (2L & v5) == 0L ? this.E(v4, 0L, v5, 8L) : this.a(9, 65);
                }
            }
        }
        catch(IOException unused_ex) {
            return 9;
        }
        return this.f(8, v4, v5);
    }

    private int E(long v, long v1, long v2, long v3) {
        long v4 = v1 & v;
        long v5 = v3 & v2;
        if((v4 | v5) == 0L) {
            return this.f(8, v, v2);
        }
        try {
            this.m = this.l.c();
            switch(this.m) {
                case 101: {
                    return this.F(v4, 0x8000000000000000L, v5, 1L);
                }
                case 105: {
                    return this.F(v4, 0L, v5, 8L);
                }
            }
        }
        catch(IOException unused_ex) {
            return 10;
        }
        return this.f(9, v4, v5);
    }

    private int F(long v, long v1, long v2, long v3) {
        long v4 = v1 & v;
        long v5 = v3 & v2;
        if((v4 | v5) == 0L) {
            return this.f(9, v, v2);
        }
        try {
            this.m = this.l.c();
            switch(this.m) {
                case 100: {
                    return (0x8000000000000000L & v4) == 0L ? this.f(10, v4, v5) : this.a(11, 0x3F);
                }
                case 102: {
                    return this.G(v4, 0L, v5, 1L);
                }
                case 0x7A: {
                    return this.G(v4, 0L, v5, 8L);
                }
            }
        }
        catch(IOException unused_ex) {
            return 11;
        }
        return this.f(10, v4, v5);
    }

    private int G(long v, long v1, long v2, long v3) {
        long v4 = v3 & v2;
        if((v1 & v | v4) == 0L) {
            return this.f(10, v, v2);
        }
        try {
            this.m = this.l.c();
            switch(this.m) {
                case 101: {
                    return (8L & v4) == 0L ? this.f(11, 0L, v4) : this.a(12, 67);
                }
                case 105: {
                    return this.j(v4, 1L);
                }
            }
        }
        catch(IOException unused_ex) {
            return 12;
        }
        return this.f(11, 0L, v4);
    }

    private int H(long v, long v1, long v2, long v3) {
        long v4 = v1 & v;
        long v5 = v3 & v2;
        if((v4 | v5) == 0L) {
            return this.h(0, v, v2);
        }
        try {
            this.m = this.l.c();
            switch(this.m) {
                case 65: {
                    return this.I(v4, 0x1C0L, v5, 0L);
                }
                case 66: {
                    return (0x40000L & v4) == 0L ? this.h(1, v4, v5) : this.d(2, 18, 1);
                }
                case 68: {
                    goto label_12;
                }
                case 73: {
                    return this.I(v4, 0x80080400000000L, v5, 0L);
                }
                case 76: {
                    goto label_16;
                }
                case 77: {
                    return (0x800000L & v4) == 0L ? this.h(1, v4, v5) : this.d(2, 23, 1);
                }
                case 78: {
                    return (0x2000000L & v4) == 0L ? this.I(v4, 0xC200004000000L, v5, 0L) : this.d(2, 25, 1);
                }
                case 0x4F: {
                    return this.I(v4, 0x92C000000000L, v5, 0L);
                }
                case 80: {
                    return (0x8000000L & v4) == 0L ? this.h(1, v4, v5) : this.d(2, 27, 1);
                }
                case 82: {
                    goto label_23;
                }
                case 83: {
                    return this.I(v4, 0x180000000L, v5, 0L);
                }
                case 84: {
                    return (0x1000000L & v4) == 0L ? this.I(v4, 0x50010800007E00L, v5, 0L) : this.d(2, 24, 1);
                }
                case 86: {
                    return (0x100000L & v4) == 0L ? this.I(v4, 0x20L, v5, 0L) : this.d(2, 20, 1);
                }
                case 87: {
                    return (0x400000L & v4) == 0L ? this.I(v4, 0x8000L, v5, 0L) : this.d(2, 22, 1);
                }
                case 97: {
                    return this.I(v4, 0L, v5, 9L);
                }
                case 105: {
                    return this.I(v4, 0x8000000000000000L, v5, 0x20L);
                }
                case 108: {
                    return (0x100000000000000L & v4) == 0L ? this.I(v4, 0x400000000000000L, v5, 0L) : this.d(2, 56, 1);
                }
                case 110: {
                    return this.I(v4, 0L, v5, 640L);
                }
                case 0x6F: {
                    return this.I(v4, 0x4000000000000000L, v5, 0x40L);
                }
                case 0x70: {
                    return this.I(v4, 0L, v5, 16L);
                }
                case 0x73: {
                    return this.I(v4, 0L, v5, 4L);
                }
                case 0x75: {
                    return this.I(v4, 0x200000000000000L, v5, 0x102L);
                }
            }
        }
        catch(IOException unused_ex) {
            this.g(1, v4, v5);
            return 2;
        }
        return this.h(1, v4, v5);
    label_12:
        if((0x20000L & v4) != 0L) {
            return this.d(2, 17, 1);
        }
        return (0x200000L & v4) == 0L ? this.h(1, v4, v5) : this.d(2, 21, 1);
    label_16:
        if((0x80000L & v4) != 0L) {
            return this.d(2, 19, 1);
        }
        return (0x1000000000000L & v4) == 0L ? this.I(v4, 0x200010000L, v5, 0L) : this.d(2, 0x30, 1);
    label_23:
        if((0x400000000000L & v4) != 0L) {
            return this.d(2, 46, 1);
        }
        return (0x2000000000000L & v4) == 0L ? this.I(v4, 0x43000000000L, v5, 0L) : this.d(2, 49, 1);
    }

    private int I(long v, long v1, long v2, long v3) {
        long v4 = v1 & v;
        long v5 = v3 & v2;
        if((v4 | v5) == 0L) {
            return this.h(1, v, v2);
        }
        try {
            this.m = this.l.c();
            switch(this.m) {
                case 65: {
                    return this.J(v4, 0x40000000000L, v5, 0L);
                }
                case 67: {
                    return this.J(v4, 0x8000004000000L, v5, 0L);
                }
                case 68: {
                    return (0x200000000000L & v4) == 0L ? this.J(v4, 0x1C0L, v5, 0L) : this.d(3, 45, 1);
                }
                case 69: {
                    return (0x20L & v4) == 0L ? this.h(2, v4, v5) : this.d(3, 5, 1);
                }
                case 70: {
                    return (0x10000L & v4) == 0L ? this.h(2, v4, v5) : this.d(3, 16, 1);
                }
                case 76: {
                    return (0x200000000L & v4) == 0L ? this.J(v4, 0x11400000000L, v5, 0L) : this.d(3, 33, 1);
                }
                case 0x4F: {
                    return this.J(v4, 0x10000000000000L, v5, 0L);
                }
                case 80: {
                    return this.J(v4, 0x80002000000000L, v5, 0L);
                }
                case 82: {
                    return (0x800000000000L & v4) == 0L ? this.J(v4, 0xC000000000L, v5, 0L) : this.d(3, 0x2F, 1);
                }
                case 83: {
                    return this.J(v4, 0x4020000000000L, v5, 0L);
                }
                case 84: {
                    goto label_20;
                }
                case 85: {
                    return this.J(v4, 0x800002200L, v5, 0L);
                }
                case 86: {
                    return (0x80000000000L & v4) == 0L ? this.h(2, v4, v5) : this.d(3, 43, 1);
                }
                case 0x5F: {
                    return this.J(v4, 0x40000000000000L, v5, 4L);
                }
                case 99: {
                    return this.J(v4, 0L, v5, 0x40L);
                }
                case 100: {
                    goto label_29;
                }
                case 101: {
                    return (0x200000000000000L & v4) == 0L ? this.h(2, v4, v5) : this.d(3, 57, 1);
                }
                case 109: {
                    return this.J(v4, 0L, v5, 2L);
                }
                case 110: {
                    return this.J(v4, 0x8000000000000000L, v5, 0x120L);
                }
                case 0x73: {
                    return this.J(v4, 0x400000000000000L, v5, 1L);
                }
                case 0x75: {
                    return this.J(v4, 0x4000000000000000L, v5, 0L);
                }
                case 0x76: {
                    return this.J(v4, 0L, v5, 16L);
                }
                case 120: {
                    return this.J(v4, 0L, v5, 8L);
                }
            }
        }
        catch(IOException unused_ex) {
            this.g(2, v4, v5);
            return 3;
        }
        return this.h(2, v4, v5);
    label_20:
        if((0x80000000L & v4) != 0L) {
            this.s = 0x1F;
            this.r = 3;
            return this.J(v4, 0x10000DC00L, v5, 0L);
        }
        return (0x100000000000L & v4) == 0L ? this.J(v4, 0x10000DC00L, v5, 0L) : this.d(3, 44, 1);
    label_29:
        if((0x200L & v5) != 0L) {
            this.s = 73;
            this.r = 3;
        }
        return this.J(v4, 0L, v5, 0x80L);
    }

    private int J(long v, long v1, long v2, long v3) {
        long v4 = v1 & v;
        long v5 = v3 & v2;
        if((v4 | v5) == 0L) {
            return this.h(2, v, v2);
        }
        try {
            this.m = this.l.c();
            switch(this.m) {
                case 0x20: {
                    return this.K(v4, 0L, v5, 0x80L);
                }
                case 65: {
                    return this.K(v4, 0x400DC00L, v5, 0L);
                }
                case 66: {
                    return this.K(v4, 0x80L, v5, 0L);
                }
                case 67: {
                    return this.K(v4, 0x4400000000L, v5, 0L);
                }
                case 73: {
                    return this.K(v4, 0x10000000000L, v5, 0L);
                }
                case 75: {
                    return (0x40L & v4) == 0L ? this.h(3, v4, v5) : this.d(4, 6, 1);
                }
                case 76: {
                    return this.K(v4, 0x8000000000L, v5, 0L);
                }
                case 78: {
                    return this.K(v4, 0x100L, v5, 0L);
                }
                case 0x4F: {
                    return this.K(v4, 0x1000000000L, v5, 0L);
                }
                case 80: {
                    return this.K(v4, 0x2200L, v5, 0L);
                }
                case 82: {
                    return this.K(v4, 0x42800000000L, v5, 0L);
                }
                case 83: {
                    return this.K(v4, 0x100000000L, v5, 0L);
                }
                case 84: {
                    return (0x4000000000000L & v4) == 0L ? this.K(v4, 0x40000000000000L, v5, 0L) : this.d(4, 50, 1);
                }
                case 85: {
                    return this.K(v4, 0x20000000000L, v5, 0L);
                }
                case 91: {
                    goto label_24;
                }
                case 0x5F: {
                    return this.K(v4, 0x80000000000000L, v5, 0L);
                }
                case 97: {
                    return this.K(v4, 0L, v5, 80L);
                }
                case 99: {
                    return (0x100L & v5) == 0L ? this.h(3, v4, v5) : this.a(4, 72);
                }
                case 101: {
                    goto label_30;
                }
                case 0x70: {
                    return this.K(v4, 0L, v5, 2L);
                }
                case 0x72: {
                    return this.K(v4, 0x4000000000000000L, v5, 0L);
                }
                case 0x73: {
                    return this.K(v4, 0L, v5, 8L);
                }
                case 0x74: {
                    return this.K(v4, 0L, v5, 1L);
                }
                case 0x76: {
                    return this.K(v4, 0L, v5, 4L);
                }
            }
        }
        catch(IOException unused_ex) {
            this.g(3, v4, v5);
            return 4;
        }
        return this.h(3, v4, v5);
    label_24:
        if((0x8000000000000L & v4) != 0L) {
            return this.a(4, 51);
        }
        return (0x10000000000000L & v4) == 0L ? this.h(3, v4, v5) : this.a(4, 52);
    label_30:
        if((0x400000000000000L & v4) != 0L) {
            return this.d(4, 58, 1);
        }
        if((0x20L & v5) != 0L) {
            this.s = 69;
            this.r = 4;
        }
        return this.K(v4, 0x8000000000000000L, v5, 0L);
    }

    private int K(long v, long v1, long v2, long v3) {
        long v4 = v1 & v;
        long v5 = v3 & v2;
        if((v4 | v5) == 0L) {
            return this.h(3, v, v2);
        }
        try {
            this.m = this.l.c();
            switch(this.m) {
                case 65: {
                    return this.L(v4, 0x4400000000L, v5, 0L);
                }
                case 66: {
                    return this.L(v4, 0xDC00L, v5, 0L);
                }
                case 69: {
                    return this.L(v4, 0x2100000000L, v5, 0L);
                }
                case 71: {
                    return (0x40000000000L & v4) == 0L ? this.h(4, v4, v5) : this.d(5, 42, 1);
                }
                case 73: {
                    return this.L(v4, 0x100L, v5, 0L);
                }
                case 78: {
                    return (0x800000000L & v4) == 0L ? this.L(v4, 0x80000000000000L, v5, 0L) : this.d(5, 35, 1);
                }
                case 0x4F: {
                    return this.L(v4, 0x40009000000080L, v5, 0L);
                }
                case 82: {
                    return this.L(v4, 0x20000000000L, v5, 0L);
                }
                case 83: {
                    return this.L(v4, 0x10000000000L, v5, 0L);
                }
                case 84: {
                    return (0x4000000L & v4) == 0L ? this.h(4, v4, v5) : this.d(5, 26, 1);
                }
                case 86: {
                    return this.L(v4, 0x2200L, v5, 0L);
                }
                case 97: {
                    return this.L(v4, 0L, v5, 6L);
                }
                case 99: {
                    return this.L(v4, 0x4000000000000000L, v5, 0L);
                }
                case 100: {
                    return this.L(v4, 0x8000000000000000L, v5, 0L);
                }
                case 108: {
                    goto label_24;
                }
                case 0x74: {
                    return this.L(v4, 0L, v5, 8L);
                }
            }
        }
        catch(IOException unused_ex) {
            this.g(4, v4, v5);
            return 5;
        }
        return this.h(4, v4, v5);
    label_24:
        if((16L & v5) != 0L) {
            return this.a(5, 68);
        }
        return (0x40L & v5) == 0L ? this.L(v4, 0L, v5, 0x81L) : this.a(5, 70);
    }

    private int L(long v, long v1, long v2, long v3) {
        long v4 = v1 & v;
        long v5 = v3 & v2;
        if((v4 | v5) == 0L) {
            return this.h(4, v, v2);
        }
        try {
            this.m = this.l.c();
            switch(this.m) {
                case 65: {
                    return this.M(v4, 0x2200L, v5, 0L);
                }
                case 69: {
                    return (0x20000000000L & v4) == 0L ? this.M(v4, 0x80000000000000L, v5, 0L) : this.d(6, 41, 1);
                }
                case 76: {
                    return (0x100L & v4) == 0L ? this.M(v4, 0x440000C800L, v5, 0L) : this.d(6, 8, 1);
                }
                case 0x4F: {
                    return this.M(v4, 0x8000000080L, v5, 0L);
                }
                case 80: {
                    goto label_14;
                }
                case 84: {
                    goto label_19;
                }
                case 85: {
                    return this.M(v4, 0x1400L, v5, 0L);
                }
                case 97: {
                    return this.M(v4, 0L, v5, 8L);
                }
                case 101: {
                    return (0x4000000000000000L & v4) == 0L ? this.M(v4, 0x8000000000000000L, v5, 0L) : this.a(6, 62);
                }
                case 105: {
                    return this.M(v4, 0L, v5, 1L);
                }
                case 0x6F: {
                    return this.M(v4, 0L, v5, 0x80L);
                }
                case 0x72: {
                    return this.M(v4, 0L, v5, 6L);
                }
            }
        }
        catch(IOException unused_ex) {
            this.g(5, v4, v5);
            return 6;
        }
        return this.h(5, v4, v5);
    label_14:
        if((0x1000000000L & v4) != 0L) {
            return this.d(6, 36, 1);
        }
        if((0x2000000000L & v4) != 0L) {
            return this.d(6, 37, 1);
        }
        return (0x40000000000000L & v4) == 0L ? this.h(5, v4, v5) : this.d(6, 54, 1);
    label_19:
        if((0x100000000L & v4) != 0L) {
            return this.d(6, 0x20, 1);
        }
        return (0x10000000000L & v4) == 0L ? this.h(5, v4, v5) : this.d(6, 40, 1);
    }

    private int M(long v, long v1, long v2, long v3) {
        long v4 = v1 & v;
        long v5 = v3 & v2;
        if((v4 | v5) == 0L) {
            return this.h(5, v, v2);
        }
        try {
            this.m = this.l.c();
            switch(this.m) {
                case 69: {
                    goto label_10;
                }
                case 76: {
                    goto label_15;
                }
                case 80: {
                    goto label_24;
                }
                case 88: {
                    return this.N(v4, 0x80000000000000L, v5, 0L);
                }
                case 97: {
                    return this.N(v4, 0L, v5, 6L);
                }
                case 99: {
                    return this.N(v4, 0L, v5, 0x88L);
                }
                case 102: {
                    return this.N(v4, 0x8000000000000000L, v5, 0L);
                }
                case 110: {
                    return this.N(v4, 0L, v5, 1L);
                }
            }
        }
        catch(IOException unused_ex) {
            this.g(6, v4, v5);
            return 7;
        }
        return this.h(6, v4, v5);
    label_10:
        if((0x800L & v4) != 0L) {
            return this.d(7, 11, 1);
        }
        if((0x4000L & v4) != 0L) {
            return this.d(7, 14, 1);
        }
        return (0x8000L & v4) == 0L ? this.h(6, v4, v5) : this.d(7, 15, 1);
    label_15:
        if((0x80L & v4) != 0L) {
            return this.d(7, 7, 1);
        }
        if((0x200L & v4) != 0L) {
            return this.d(7, 9, 1);
        }
        if((0x2000L & v4) != 0L) {
            return this.d(7, 13, 1);
        }
        if((0x400000000L & v4) != 0L) {
            return this.d(7, 34, 1);
        }
        return (0x4000000000L & v4) == 0L ? this.h(6, v4, v5) : this.d(7, 38, 1);
    label_24:
        if((0x400L & v4) != 0L) {
            return this.d(7, 10, 1);
        }
        if((0x1000L & v4) != 0L) {
            return this.d(7, 12, 1);
        }
        return (0x8000000000L & v4) == 0L ? this.h(6, v4, v5) : this.d(7, 39, 1);
    }

    private int N(long v, long v1, long v2, long v3) {
        long v4 = v1 & v;
        long v5 = v3 & v2;
        if((v4 | v5) == 0L) {
            return this.h(6, v, v2);
        }
        try {
            this.m = this.l.c();
            switch(this.m) {
                case 84: {
                    return (0x80000000000000L & v4) == 0L ? this.h(7, v4, v5) : this.d(8, 55, 1);
                }
                case 97: {
                    return this.O(v4, 0L, v5, 0x80L);
                }
                case 101: {
                    return this.O(v4, 0L, v5, 1L);
                }
                case 105: {
                    return this.O(v4, 0x8000000000000000L, v5, 0L);
                }
                case 107: {
                    return this.O(v4, 0L, v5, 8L);
                }
                case 109: {
                    return this.O(v4, 0L, v5, 2L);
                }
                case 0x72: {
                    return this.O(v4, 0L, v5, 4L);
                }
            }
        }
        catch(IOException unused_ex) {
            this.g(7, v4, v5);
            return 8;
        }
        return this.h(7, v4, v5);
    }

    private int O(long v, long v1, long v2, long v3) {
        long v4 = v1 & v;
        long v5 = v3 & v2;
        if((v4 | v5) == 0L) {
            return this.h(7, v, v2);
        }
        try {
            this.m = this.l.c();
            switch(this.m) {
                case 100: {
                    return this.P(v4, 0L, v5, 1L);
                }
                case 103: {
                    return (4L & v5) == 0L ? this.h(8, v4, v5) : this.a(9, 66);
                }
                case 108: {
                    return (0x80L & v5) == 0L ? this.h(8, v4, v5) : this.a(9, 71);
                }
                case 110: {
                    return this.P(v4, 0x8000000000000000L, v5, 0L);
                }
                case 0x73: {
                    return (2L & v5) == 0L ? this.P(v4, 0L, v5, 8L) : this.a(9, 65);
                }
            }
        }
        catch(IOException unused_ex) {
            this.g(8, v4, v5);
            return 9;
        }
        return this.h(8, v4, v5);
    }

    private int P(long v, long v1, long v2, long v3) {
        long v4 = v1 & v;
        long v5 = v3 & v2;
        if((v4 | v5) == 0L) {
            return this.h(8, v, v2);
        }
        try {
            this.m = this.l.c();
            switch(this.m) {
                case 101: {
                    return this.Q(v4, 0x8000000000000000L, v5, 1L);
                }
                case 105: {
                    return this.Q(v4, 0L, v5, 8L);
                }
            }
        }
        catch(IOException unused_ex) {
            this.g(9, v4, v5);
            return 10;
        }
        return this.h(9, v4, v5);
    }

    private int Q(long v, long v1, long v2, long v3) {
        long v4 = v1 & v;
        long v5 = v3 & v2;
        if((v4 | v5) == 0L) {
            return this.h(9, v, v2);
        }
        try {
            this.m = this.l.c();
            switch(this.m) {
                case 100: {
                    return (0x8000000000000000L & v4) == 0L ? this.h(10, v4, v5) : this.a(11, 0x3F);
                }
                case 102: {
                    return this.R(v4, 0L, v5, 1L);
                }
                case 0x7A: {
                    return this.R(v4, 0L, v5, 8L);
                }
            }
        }
        catch(IOException unused_ex) {
            this.g(10, v4, v5);
            return 11;
        }
        return this.h(10, v4, v5);
    }

    private int R(long v, long v1, long v2, long v3) {
        long v4 = v3 & v2;
        if((v1 & v | v4) == 0L) {
            return this.h(10, v, v2);
        }
        try {
            this.m = this.l.c();
            switch(this.m) {
                case 101: {
                    return (8L & v4) == 0L ? this.h(11, 0L, v4) : this.a(12, 67);
                }
                case 105: {
                    return this.n(v4, 1L);
                }
            }
        }
        catch(IOException unused_ex) {
            this.g(11, 0L, v4);
            return 12;
        }
        return this.h(11, 0L, v4);
    }

    private int a(int v, int v1) {
        this.s = v1;
        this.r = v;
        return v + 1;
    }

    private int a(int v, int v1, int v2) {
        try {
            this.s = v1;
            this.r = v;
            this.m = this.l.c();
            return this.b(v2, v + 1);
        }
        catch(IOException unused_ex) {
            return v + 1;
        }
    }

    private final int a(int v, long v1, long v2) {
        if(v != 0) {
            return -1;
        }
        if((0xC000000000000000L & v1) != 0L || (0xBFFL & v2) != 0L) {
            return 28;
        }
        return (14L & v1) == 0L ? -1 : 50;
    }

    private int a(long v, long v1) {
        try {
            this.m = this.l.c();
            switch(this.m) {
                case 46: {
                    return (0x800L & v1) == 0L ? this.b(0, v, v1) : this.a(1, 75);
                }
                case 65: {
                    return this.a(v, 0x240600000000L, v1, 0L);
                }
                case 68: {
                    return this.a(v, 0x80000020000L, v1, 0L);
                }
                case 69: {
                    goto label_8;
                }
                case 70: {
                    return this.a(v, 0xC000000000L, v1, 0L);
                }
                case 72: {
                    return this.a(v, 0x3000000000000L, v1, 0L);
                }
                case 73: {
                    return this.a(v, 0x100000L, v1, 0L);
                }
                case 75: {
                    return this.a(v, 0x80000000000000L, v1, 0L);
                }
                case 76: {
                    return this.a(v, 0x20000000000L, v1, 0L);
                }
                case 77: {
                    return this.a(v, 0x8000000L, v1, 0L);
                }
                case 78: {
                    return this.a(v, 0x100000800000L, v1, 0L);
                }
                case 0x4F: {
                    return this.a(v, 0x144030056001E0L, v1, 0L);
                }
                case 80: {
                    return (0x20000000000000L & v) == 0L ? this.b(0, v, v1) : this.a(1, 53);
                }
                case 81: {
                    return (0x10000000L & v) == 0L ? this.b(0, v, v1) : this.a(1, 28);
                }
                case 84: {
                    return (0x20000000L & v) == 0L ? this.b(0, v, v1) : this.a(1, 29);
                }
                case 85: {
                    return this.a(v, 0x80000000C0000L, v1, 0L);
                }
                case 88: {
                    return this.a(v, 0x800000000000L, v1, 0L);
                }
                case 97: {
                    return this.a(v, 0x400000000000000L, v1, 0L);
                }
                case 101: {
                    return this.a(v, 0L, v1, 640L);
                }
                case 102: {
                    return this.a(v, 0L, v1, 0x100L);
                }
                case 105: {
                    return this.a(v, 0x100000000000000L, v1, 4L);
                }
                case 108: {
                    return this.a(v, 0x8000000000000000L, v1, 97L);
                }
                case 109: {
                    return this.a(v, 0L, v1, 8L);
                }
                case 110: {
                    return this.a(v, 0L, v1, 2L);
                }
                case 0x72: {
                    return this.a(v, 0x200000000000000L, v1, 0L);
                }
                case 0x73: {
                    return this.a(v, 0x4000000000000000L, v1, 0L);
                }
                case 0x75: {
                    return this.a(v, 0L, v1, 16L);
                }
            }
        }
        catch(IOException unused_ex) {
            return 1;
        }
        return this.b(0, v, v1);
    label_8:
        if((0x40000000L & v) != 0L) {
            this.s = 30;
            this.r = 1;
        }
        return this.a(v, 0x4001098201FE00L, v1, 0L);
    }

    private int a(long v, long v1, long v2, long v3) {
        long v4 = v1 & v;
        long v5 = v3 & v2;
        if((v4 | v5) == 0L) {
            return this.b(0, v, v2);
        }
        try {
            this.m = this.l.c();
            switch(this.m) {
                case 65: {
                    return this.b(v4, 0x1C0L, v5, 0L);
                }
                case 66: {
                    return (0x40000L & v4) == 0L ? this.b(1, v4, v5) : this.a(2, 18);
                }
                case 68: {
                    goto label_11;
                }
                case 73: {
                    return this.b(v4, 0x80080400000000L, v5, 0L);
                }
                case 76: {
                    goto label_15;
                }
                case 77: {
                    return (0x800000L & v4) == 0L ? this.b(1, v4, v5) : this.a(2, 23);
                }
                case 78: {
                    return (0x2000000L & v4) == 0L ? this.b(v4, 0xC200004000000L, v5, 0L) : this.a(2, 25);
                }
                case 0x4F: {
                    return this.b(v4, 0x92C000000000L, v5, 0L);
                }
                case 80: {
                    return (0x8000000L & v4) == 0L ? this.b(1, v4, v5) : this.a(2, 27);
                }
                case 82: {
                    goto label_22;
                }
                case 83: {
                    return this.b(v4, 0x180000000L, v5, 0L);
                }
                case 84: {
                    return (0x1000000L & v4) == 0L ? this.b(v4, 0x50010800007E00L, v5, 0L) : this.a(2, 24);
                }
                case 86: {
                    return (0x100000L & v4) == 0L ? this.b(v4, 0x20L, v5, 0L) : this.a(2, 20);
                }
                case 87: {
                    return (0x400000L & v4) == 0L ? this.b(v4, 0x8000L, v5, 0L) : this.a(2, 22);
                }
                case 97: {
                    return this.b(v4, 0L, v5, 9L);
                }
                case 105: {
                    return this.b(v4, 0x8000000000000000L, v5, 0x20L);
                }
                case 108: {
                    return (0x100000000000000L & v4) == 0L ? this.b(v4, 0x400000000000000L, v5, 0L) : this.a(2, 56);
                }
                case 110: {
                    return this.b(v4, 0L, v5, 640L);
                }
                case 0x6F: {
                    return this.b(v4, 0x4000000000000000L, v5, 0x40L);
                }
                case 0x70: {
                    return this.b(v4, 0L, v5, 16L);
                }
                case 0x73: {
                    return this.b(v4, 0L, v5, 4L);
                }
                case 0x75: {
                    return this.b(v4, 0x200000000000000L, v5, 0x102L);
                }
            }
        }
        catch(IOException unused_ex) {
            return 2;
        }
        return this.b(1, v4, v5);
    label_11:
        if((0x20000L & v4) != 0L) {
            return this.a(2, 17);
        }
        return (0x200000L & v4) == 0L ? this.b(1, v4, v5) : this.a(2, 21);
    label_15:
        if((0x80000L & v4) != 0L) {
            return this.a(2, 19);
        }
        return (0x1000000000000L & v4) == 0L ? this.b(v4, 0x200010000L, v5, 0L) : this.a(2, 0x30);
    label_22:
        if((0x400000000000L & v4) != 0L) {
            return this.a(2, 46);
        }
        return (0x2000000000000L & v4) == 0L ? this.b(v4, 0x43000000000L, v5, 0L) : this.a(2, 49);
    }

    private void a(int v) {
        if(this.t[v] != this.q) {
            int v1 = this.p;
            this.p = v1 + 1;
            this.u[v1] = v;
            this.t[v] = this.q;
        }
    }

    private static final boolean a(int v, int v1, int v2, long v3, long v4) {
        return v == 0 ? (f.c[v2] & v4) != 0L : (f.b[v1] & v3) != 0L;
    }

    protected i a() {
        String s = f.f[this.s];
        if(s == null) {
            s = this.l.h();
        }
        int v = this.l.g();
        int v1 = this.l.f();
        int v2 = this.l.e();
        int v3 = this.l.d();
        i i0 = i.a(this.s, s);
        i0.b = v;
        i0.d = v2;
        i0.c = v1;
        i0.e = v3;
        return i0;
    }

    private int b(int v, int v1) {
        this.p = 50;
        this.u[0] = v;
        int v2 = 0x7FFFFFFF;
        int v3 = 1;
        int v4 = 0;
        while(true) {
            int v5 = this.q + 1;
            this.q = v5;
            if(v5 == 0x7FFFFFFF) {
                this.g();
            }
            if(this.m < 0x40) {
                long v6 = 1L << this.m;
                do {
                    --v3;
                    switch(this.u[v3]) {
                        case 0: {
                            if((0x2400L & v6) != 0L) {
                                if(v2 > 74) {
                                    v2 = 74;
                                }
                                this.h(12, 15);
                            }
                            break;
                        }
                        case 1: {
                            if((0x100001200L & v6) != 0L) {
                                this.g(1, 2);
                            }
                            break;
                        }
                        case 2: {
                            if(this.m == 59) {
                                this.h(0, 2);
                            }
                            break;
                        }
                        case 3: {
                            if((0xFFFFFFFFFFFFDBFFL & v6) != 0L) {
                                this.h(0, 2);
                            }
                            break;
                        }
                        case 4: {
                            if(this.m == 10) {
                                if(v2 > 74) {
                                    v2 = 74;
                                }
                                this.h(12, 15);
                            }
                            break;
                        }
                        case 5: {
                            if(this.m == 13) {
                                int v7 = this.p;
                                this.p = v7 + 1;
                                this.u[v7] = 4;
                            }
                            break;
                        }
                        case 6: {
                            if((0x3FF000000000000L & v6) != 0L) {
                                if(v2 > 0x4F) {
                                    v2 = 0x4F;
                                }
                                this.h(3, 7);
                            }
                            else if((0x100001200L & v6) != 0L) {
                                this.h(8, 11);
                            }
                            else if((0x2400L & v6) == 0L) {
                                switch(this.m) {
                                    case 34: {
                                        this.h(25, 27);
                                        break;
                                    }
                                    case 39: {
                                        this.h(22, 24);
                                        break;
                                    }
                                    case 45: {
                                        this.f(20, 21);
                                        break;
                                    }
                                    case 46: {
                                        this.a(28);
                                        break;
                                    }
                                    case 58: {
                                        int v8 = this.p;
                                        this.p = v8 + 1;
                                        this.u[v8] = 7;
                                        break;
                                    }
                                    case 59: {
                                        if(v2 > 4) {
                                            v2 = 4;
                                        }
                                        this.h(16, 19);
                                    }
                                }
                            }
                            else {
                                if(v2 > 74) {
                                    v2 = 74;
                                }
                                this.h(12, 15);
                            }
                            switch(this.m) {
                                case 13: {
                                    int v9 = this.p;
                                    this.p = v9 + 1;
                                    this.u[v9] = 4;
                                    break;
                                }
                                case 0x30: {
                                    int v10 = this.p;
                                    this.p = v10 + 1;
                                    this.u[v10] = 14;
                                }
                            }
                            break;
                        }
                        case 8: {
                            if((0x3FF000000000000L & v6) != 0L) {
                                if(v2 > 76) {
                                    v2 = 76;
                                }
                                int v11 = this.p;
                                this.p = v11 + 1;
                                this.u[v11] = 8;
                            }
                            break;
                        }
                        case 10: {
                            if((0x3FF000000000000L & v6) != 0L) {
                                if(v2 > 77) {
                                    v2 = 77;
                                }
                                int v12 = this.p;
                                this.p = v12 + 1;
                                this.u[v12] = 10;
                            }
                            break;
                        }
                        case 12: {
                            if((0x3FF000000000000L & v6) != 0L) {
                                if(v2 > 78) {
                                    v2 = 78;
                                }
                                int v13 = this.p;
                                this.p = v13 + 1;
                                this.u[v13] = 12;
                            }
                            break;
                        }
                        case 13: {
                            if(this.m == 0x30) {
                                int v14 = this.p;
                                this.p = v14 + 1;
                                this.u[v14] = 14;
                            }
                            break;
                        }
                        case 15: {
                            if((0x3FF000000000000L & v6) != 0L) {
                                if(v2 > 80) {
                                    v2 = 80;
                                }
                                int v15 = this.p;
                                this.p = v15 + 1;
                                this.u[v15] = 15;
                            }
                            break;
                        }
                        case 16: {
                            if(this.m == 34) {
                                this.h(25, 27);
                            }
                            break;
                        }
                        case 18: {
                            this.h(25, 27);
                            break;
                        }
                        case 19: {
                            if((0xFFFFFFFBFFFFFFFFL & v6) != 0L) {
                                this.h(25, 27);
                            }
                            break;
                        }
                        case 20: {
                            if(this.m == 34 && v2 > 81) {
                                v2 = 81;
                            }
                            break;
                        }
                        case 21: {
                            if(this.m == 39) {
                                this.h(22, 24);
                            }
                            break;
                        }
                        case 23: {
                            this.h(22, 24);
                            break;
                        }
                        case 24: {
                            if((0xFFFFFF7FFFFFFFFFL & v6) != 0L) {
                                this.h(22, 24);
                            }
                            break;
                        }
                        case 25: {
                            if(this.m == 39 && v2 > 81) {
                                v2 = 81;
                            }
                            break;
                        }
                        case 26: {
                            if(this.m == 45) {
                                this.f(20, 21);
                            }
                            break;
                        }
                        case 27: {
                            if(this.m == 46) {
                                this.a(28);
                            }
                            break;
                        }
                        case 28: {
                            if((0x3FF000000000000L & v6) != 0L) {
                                if(v2 > 84) {
                                    v2 = 84;
                                }
                                this.g(28, 29);
                            }
                            break;
                        }
                        case 30: {
                            if((0x280000000000L & v6) != 0L) {
                                this.a(0x1F);
                            }
                            break;
                        }
                        case 0x1F: {
                            if((0x3FF000000000000L & v6) != 0L) {
                                if(v2 > 84) {
                                    v2 = 84;
                                }
                                this.a(0x1F);
                            }
                            break;
                        }
                        case 0x20: {
                            if((0x3FF000000000000L & v6) != 0L) {
                                if(v2 > 84) {
                                    v2 = 84;
                                }
                                this.h(28, 0x1F);
                            }
                            break;
                        }
                        case 33: {
                            if((0x3FF000000000000L & v6) != 0L) {
                                this.g(33, 34);
                            }
                            break;
                        }
                        case 34: {
                            if(this.m == 46) {
                                if(v2 > 84) {
                                    v2 = 84;
                                }
                                this.g(35, 36);
                            }
                            break;
                        }
                        case 35: {
                            if((0x3FF000000000000L & v6) != 0L) {
                                if(v2 > 84) {
                                    v2 = 84;
                                }
                                this.g(35, 36);
                            }
                            break;
                        }
                        case 37: {
                            if((0x280000000000L & v6) != 0L) {
                                this.a(38);
                            }
                            break;
                        }
                        case 38: {
                            if((0x3FF000000000000L & v6) != 0L) {
                                if(v2 > 84) {
                                    v2 = 84;
                                }
                                this.a(38);
                            }
                            break;
                        }
                        case 39: {
                            if((0x3FF000000000000L & v6) != 0L) {
                                if(v2 > 84) {
                                    v2 = 84;
                                }
                                this.g(39, 40);
                            }
                            break;
                        }
                        case 41: {
                            if((0x280000000000L & v6) != 0L) {
                                this.a(42);
                            }
                            break;
                        }
                        case 42: {
                            if((0x3FF000000000000L & v6) != 0L) {
                                if(v2 > 84) {
                                    v2 = 84;
                                }
                                this.a(42);
                            }
                            break;
                        }
                        case 43: {
                            if((0x100001200L & v6) != 0L) {
                                this.h(8, 11);
                            }
                            break;
                        }
                        case 44: {
                            if((0x100001200L & v6) != 0L) {
                                this.g(44, 45);
                            }
                            break;
                        }
                        case 45: {
                            if(this.m == 59) {
                                if(v2 > 4) {
                                    v2 = 4;
                                }
                                this.a(46);
                            }
                            break;
                        }
                        case 46: {
                            if((0xFFFFFFFFFFFFDBFFL & v6) != 0L) {
                                if(v2 > 4) {
                                    v2 = 4;
                                }
                                this.a(46);
                            }
                            break;
                        }
                        case 0x2F: {
                            if(this.m == 59) {
                                if(v2 > 4) {
                                    v2 = 4;
                                }
                                this.h(16, 19);
                            }
                            break;
                        }
                        case 0x30: {
                            if((0x3FF000000000000L & v6) != 0L) {
                                if(v2 > 0x4F) {
                                    v2 = 0x4F;
                                }
                                this.h(3, 7);
                            }
                            break;
                        }
                        case 49: {
                            if((0x3FF000000000000L & v6) != 0L) {
                                if(v2 > 0x4F) {
                                    v2 = 0x4F;
                                }
                                this.a(49);
                            }
                            break;
                        }
                        case 50: {
                            if((0x100001200L & v6) != 0L) {
                                this.g(1, 2);
                            }
                            else if(this.m == 59) {
                                this.h(0, 2);
                            }
                            if((0x100001200L & v6) != 0L) {
                                this.g(44, 45);
                            }
                            else if(this.m == 59) {
                                if(v2 > 4) {
                                    v2 = 4;
                                }
                                this.a(46);
                            }
                        }
                    }
                }
                while(v3 != v4);
            }
            else if(this.m < 0x80) {
                long v16 = 1L << (this.m & 0x3F);
                do {
                    --v3;
                    switch(this.u[v3]) {
                        case 3: {
                            this.f(0, 2);
                            break;
                        }
                        case 6: {
                            switch(this.m) {
                                case 0x75: {
                                    int v17 = this.p;
                                    this.p = v17 + 1;
                                    this.u[v17] = 12;
                                    break;
                                }
                                case 0x76: {
                                    int v18 = this.p;
                                    this.p = v18 + 1;
                                    this.u[v18] = 10;
                                }
                            }
                            break;
                        }
                        case 7: 
                        case 8: {
                            if((0x7FFFFFE87FFFFFEL & v16) != 0L) {
                                if(v2 > 76) {
                                    v2 = 76;
                                }
                                this.a(8);
                            }
                            break;
                        }
                        case 9: {
                            if(this.m == 0x76) {
                                int v19 = this.p;
                                this.p = v19 + 1;
                                this.u[v19] = 10;
                            }
                            break;
                        }
                        case 11: {
                            if(this.m == 0x75) {
                                int v20 = this.p;
                                this.p = v20 + 1;
                                this.u[v20] = 12;
                            }
                            break;
                        }
                        case 14: {
                            if((0x100000001000000L & v16) != 0L) {
                                this.a(15);
                            }
                            break;
                        }
                        case 15: {
                            if((0x7E0000007EL & v16) != 0L) {
                                if(v2 > 80) {
                                    v2 = 80;
                                }
                                this.a(15);
                            }
                            break;
                        }
                        case 17: {
                            if(this.m == 92) {
                                int v21 = this.p;
                                this.p = v21 + 1;
                                this.u[v21] = 18;
                            }
                            break;
                        }
                        case 18: {
                            this.h(25, 27);
                            break;
                        }
                        case 19: {
                            if((0xFFFFFFFFEFFFFFFFL & v16) != 0L) {
                                this.h(25, 27);
                            }
                            break;
                        }
                        case 22: {
                            if(this.m == 92) {
                                int v22 = this.p;
                                this.p = v22 + 1;
                                this.u[v22] = 23;
                            }
                            break;
                        }
                        case 23: {
                            this.h(22, 24);
                            break;
                        }
                        case 24: {
                            if((0xFFFFFFFFEFFFFFFFL & v16) != 0L) {
                                this.h(22, 24);
                            }
                            break;
                        }
                        case 29: {
                            if((0x2000000020L & v16) != 0L) {
                                this.f(0x20, 33);
                            }
                            break;
                        }
                        case 36: {
                            if((0x2000000020L & v16) != 0L) {
                                this.f(34, 35);
                            }
                            break;
                        }
                        case 40: {
                            if((0x2000000020L & v16) != 0L) {
                                this.f(36, 37);
                            }
                            break;
                        }
                        case 46: {
                            if(v2 > 4) {
                                v2 = 4;
                            }
                            int v23 = this.p;
                            this.p = v23 + 1;
                            this.u[v23] = 46;
                        }
                    }
                }
                while(v3 != v4);
            }
            else {
                int v24 = this.m >> 8;
                int v25 = v24 >> 6;
                long v26 = 1L << (v24 & 0x3F);
                int v27 = (this.m & 0xFF) >> 6;
                long v28 = 1L << (this.m & 0x3F);
                while(true) {
                    --v3;
                    switch(this.u[v3]) {
                        case 3: {
                            if(f.a(v24, v25, v27, v26, v28)) {
                                this.f(0, 2);
                            }
                            break;
                        }
                        case 18: 
                        case 19: {
                            if(f.a(v24, v25, v27, v26, v28)) {
                                this.h(25, 27);
                            }
                            break;
                        }
                        case 23: 
                        case 24: {
                            if(f.a(v24, v25, v27, v26, v28)) {
                                this.h(22, 24);
                            }
                            break;
                        }
                        case 46: {
                            if(f.a(v24, v25, v27, v26, v28)) {
                                if(v2 > 4) {
                                    v2 = 4;
                                }
                                int v29 = this.p;
                                this.p = v29 + 1;
                                this.u[v29] = 46;
                            }
                        }
                    }
                    if(v3 == v4) {
                        break;
                    }
                }
            }
            if(v2 != 0x7FFFFFFF) {
                this.s = v2;
                this.r = v1;
                v2 = 0x7FFFFFFF;
            }
            ++v1;
            int v30 = this.p;
            this.p = v4;
            if(v30 == 50 - v4) {
                return v1;
            }
            try {
                this.m = this.l.c();
                v3 = v30;
                v4 = 50 - v4;
                continue;
            }
            catch(IOException unused_ex) {
            }
            break;
        }
        return v1;
    }

    private int b(int v, int v1, int v2) {
        try {
            this.s = v1;
            this.r = v;
            this.m = this.l.c();
            return this.c(v2, v + 1);
        }
        catch(IOException unused_ex) {
            return v + 1;
        }
    }

    private final int b(int v, long v1, long v2) {
        return this.b(this.a(v, v1, v2), v + 1);
    }

    private int b(long v, long v1) {
        long v2 = v1 & v;
        if(v2 == 0L) {
            return this.b(11, 0L, v);
        }
        try {
            this.m = this.l.c();
            return this.m == 'n' ? this.c(v2, 1L) : this.b(12, 0L, v2);
        }
        catch(IOException unused_ex) {
            return 13;
        }
    }

    private int b(long v, long v1, long v2, long v3) {
        long v4 = v1 & v;
        long v5 = v3 & v2;
        if((v4 | v5) == 0L) {
            return this.b(1, v, v2);
        }
        try {
            this.m = this.l.c();
            switch(this.m) {
                case 65: {
                    return this.c(v4, 0x40000000000L, v5, 0L);
                }
                case 67: {
                    return this.c(v4, 0x8000004000000L, v5, 0L);
                }
                case 68: {
                    return (0x200000000000L & v4) == 0L ? this.c(v4, 0x1C0L, v5, 0L) : this.a(3, 45);
                }
                case 69: {
                    return (0x20L & v4) == 0L ? this.b(2, v4, v5) : this.a(3, 5);
                }
                case 70: {
                    return (0x10000L & v4) == 0L ? this.b(2, v4, v5) : this.a(3, 16);
                }
                case 76: {
                    return (0x200000000L & v4) == 0L ? this.c(v4, 0x11400000000L, v5, 0L) : this.a(3, 33);
                }
                case 0x4F: {
                    return this.c(v4, 0x10000000000000L, v5, 0L);
                }
                case 80: {
                    return this.c(v4, 0x80002000000000L, v5, 0L);
                }
                case 82: {
                    return (0x800000000000L & v4) == 0L ? this.c(v4, 0xC000000000L, v5, 0L) : this.a(3, 0x2F);
                }
                case 83: {
                    return this.c(v4, 0x4020000000000L, v5, 0L);
                }
                case 84: {
                    goto label_19;
                }
                case 85: {
                    return this.c(v4, 0x800002200L, v5, 0L);
                }
                case 86: {
                    return (0x80000000000L & v4) == 0L ? this.b(2, v4, v5) : this.a(3, 43);
                }
                case 0x5F: {
                    return this.c(v4, 0x40000000000000L, v5, 4L);
                }
                case 99: {
                    return this.c(v4, 0L, v5, 0x40L);
                }
                case 100: {
                    goto label_28;
                }
                case 101: {
                    return (0x200000000000000L & v4) == 0L ? this.b(2, v4, v5) : this.a(3, 57);
                }
                case 109: {
                    return this.c(v4, 0L, v5, 2L);
                }
                case 110: {
                    return this.c(v4, 0x8000000000000000L, v5, 0x120L);
                }
                case 0x73: {
                    return this.c(v4, 0x400000000000000L, v5, 1L);
                }
                case 0x75: {
                    return this.c(v4, 0x4000000000000000L, v5, 0L);
                }
                case 0x76: {
                    return this.c(v4, 0L, v5, 16L);
                }
                case 120: {
                    return this.c(v4, 0L, v5, 8L);
                }
            }
        }
        catch(IOException unused_ex) {
            return 3;
        }
        return this.b(2, v4, v5);
    label_19:
        if((0x80000000L & v4) != 0L) {
            this.s = 0x1F;
            this.r = 3;
            return this.c(v4, 0x10000DC00L, v5, 0L);
        }
        return (0x100000000000L & v4) == 0L ? this.c(v4, 0x10000DC00L, v5, 0L) : this.a(3, 44);
    label_28:
        if((0x200L & v5) != 0L) {
            this.s = 73;
            this.r = 3;
        }
        return this.c(v4, 0L, v5, 0x80L);
    }

    public i b() {
        boolean z;
        i i2;
        i i1;
        String s = null;
        int v = 0;
        i i0 = null;
        while(true) {
            try {
            label_3:
                this.m = this.l.b();
                switch(this.n) {
                    case 0: {
                        break;
                    }
                    case 1: {
                        this.s = 0x7FFFFFFF;
                        this.r = 0;
                        v = this.e();
                        goto label_25;
                    }
                    case 2: {
                        this.s = 0x7FFFFFFF;
                        this.r = 0;
                        v = this.d();
                        goto label_25;
                    }
                    case 3: {
                        goto label_22;
                    }
                    default: {
                        goto label_25;
                    }
                }
            }
            catch(IOException unused_ex) {
                this.s = 0;
                i1 = this.a();
                i1.h = i0;
                return i1;
            }
            this.s = 0x7FFFFFFF;
            this.r = 0;
            v = this.f();
            goto label_25;
        label_22:
            this.s = 0x7FFFFFFF;
            this.r = 0;
            v = this.c();
        label_25:
            if(this.s == 0x7FFFFFFF) {
                break;
            }
            if(this.r + 1 < v) {
                this.l.a(v - this.r - 1);
            }
            if((f.i[this.s >> 6] & 1L << (this.s & 0x3F)) != 0L) {
                i1 = this.a();
                i1.h = i0;
                if(f.h[this.s] != -1) {
                    this.n = f.h[this.s];
                }
                return i1;
            }
            if((f.k[this.s >> 6] & 1L << (this.s & 0x3F)) == 0L) {
                i2 = i0;
            }
            else {
                i2 = this.a();
                if(i0 != null) {
                    i2.h = i0;
                    i0.g = i2;
                }
            }
            if(f.h[this.s] != -1) {
                this.n = f.h[this.s];
                i0 = i2;
                goto label_3;
            }
            i0 = i2;
        }
        int v1 = this.l.e();
        int v2 = this.l.d();
        try {
            this.l.c();
            this.l.a(1);
            z = false;
        }
        catch(IOException unused_ex) {
            String s1 = v > 1 ? this.l.h() : "";
            if(this.m != 10 && this.m != 13) {
                ++v2;
                z = true;
                s = s1;
            }
            else {
                ++v1;
                z = true;
                s = s1;
                v2 = 0;
            }
        }
        if(!z) {
            this.l.a(1);
            s = v > 1 ? this.l.h() : "";
        }
        throw new j(z, this.n, v1, v2, s, this.m, 0);
    }

    private int c() {
        switch(this.m) {
            case 9: {
                return this.a(0, 2, 50);
            }
            case 12: {
                return this.a(0, 3, 50);
            }
            case 0x20: {
                return this.a(0, 1, 50);
            }
            case 46: {
                return this.a(0xC000000000000000L, 0xBFFL);
            }
            case 65: {
                return this.a(0x20000L, 0L);
            }
            case 66: {
                return this.a(0xF00000000000L, 0L);
            }
            case 67: {
                return this.a(0x4020204000000L, 0L);
            }
            case 68: {
                return this.a(0x100000L, 0L);
            }
            case 69: {
                return this.a(0x10000000L, 0L);
            }
            case 70: {
                return this.a(0x8003000000000L, 0L);
            }
            case 71: {
                return this.a(0x10000000000E00L, 0L);
            }
            case 73: {
                return this.a(0x80000000000L, 0L);
            }
            case 74: {
                return this.a(0x8000000L, 0L);
            }
            case 76: {
                return this.a(0x620001C0L, 0L);
            }
            case 77: {
                return this.a(0x280020L, 0L);
            }
            case 78: {
                return this.a(0x1008000L, 0L);
            }
            case 0x4F: {
                return this.a(0x20000000000000L, 0L);
            }
            case 80: {
                return this.a(0x400000L, 0L);
            }
            case 82: {
                return this.a(0x800000000L, 0L);
            }
            case 83: {
                return this.a(0xC3010000057000L, 0L);
            }
            case 84: {
                return this.a(0xC580000000L, 0L);
            }
            case 85: {
                return this.a(0x800000L, 0L);
            }
            case 86: {
                return this.a(0x40000000000L, 0L);
            }
            case 91: {
                return this.a(0, 88);
            }
            case 93: {
                return this.a(0, 89);
            }
            case 102: {
                return this.a(0x400000000000000L, 0L);
            }
            case 110: {
                return this.a(0x100000000000000L, 0L);
            }
            case 0x74: {
                return this.a(0x200000000000000L, 0L);
            }
            default: {
                return this.b(6, 0);
            }
        }
    }

    private int c(int v, int v1) {
        this.p = 51;
        this.u[0] = v;
        int v2 = 0x7FFFFFFF;
        int v3 = 1;
        int v4 = 0;
        while(true) {
            int v5 = this.q + 1;
            this.q = v5;
            if(v5 == 0x7FFFFFFF) {
                this.g();
            }
            if(this.m < 0x40) {
                long v6 = 1L << this.m;
                do {
                    --v3;
                    switch(this.u[v3]) {
                        case 0: {
                            if((0x2400L & v6) != 0L) {
                                if(v2 > 74) {
                                    v2 = 74;
                                }
                                this.h(12, 15);
                            }
                            break;
                        }
                        case 1: {
                            if((0x100001200L & v6) != 0L) {
                                this.g(1, 2);
                            }
                            break;
                        }
                        case 2: {
                            if(this.m == 59) {
                                this.h(0, 2);
                            }
                            break;
                        }
                        case 3: {
                            if((0xFFFFFFFFFFFFDBFFL & v6) != 0L) {
                                this.h(0, 2);
                            }
                            break;
                        }
                        case 4: {
                            if(this.m == 10) {
                                if(v2 > 74) {
                                    v2 = 74;
                                }
                                this.h(12, 15);
                            }
                            break;
                        }
                        case 5: {
                            if(this.m == 13) {
                                int v7 = this.p;
                                this.p = v7 + 1;
                                this.u[v7] = 4;
                            }
                            break;
                        }
                        case 6: {
                            if((0x3FF000000000000L & v6) != 0L) {
                                if(v2 > 0x4F) {
                                    v2 = 0x4F;
                                }
                                this.h(38, 42);
                            }
                            else if((0x100001200L & v6) != 0L) {
                                this.h(43, 46);
                            }
                            else if((0x2400L & v6) == 0L) {
                                switch(this.m) {
                                    case 34: {
                                        this.h(56, 58);
                                        break;
                                    }
                                    case 39: {
                                        this.h(53, 55);
                                        break;
                                    }
                                    case 45: {
                                        this.f(51, 52);
                                        break;
                                    }
                                    case 46: {
                                        this.a(26);
                                        break;
                                    }
                                    case 58: {
                                        int v8 = this.p;
                                        this.p = v8 + 1;
                                        this.u[v8] = 7;
                                        break;
                                    }
                                    case 59: {
                                        if(v2 > 4) {
                                            v2 = 4;
                                        }
                                        this.h(0x2F, 50);
                                    }
                                }
                            }
                            else {
                                if(v2 > 74) {
                                    v2 = 74;
                                }
                                this.h(12, 15);
                            }
                            switch(this.m) {
                                case 13: {
                                    int v9 = this.p;
                                    this.p = v9 + 1;
                                    this.u[v9] = 4;
                                    break;
                                }
                                case 0x30: {
                                    int v10 = this.p;
                                    this.p = v10 + 1;
                                    this.u[v10] = 12;
                                }
                            }
                            break;
                        }
                        case 8: {
                            if((0x3FF000000000000L & v6) != 0L) {
                                if(v2 > 76) {
                                    v2 = 76;
                                }
                                int v11 = this.p;
                                this.p = v11 + 1;
                                this.u[v11] = 8;
                            }
                            break;
                        }
                        case 10: {
                            if((0x3FF000000000000L & v6) != 0L) {
                                if(v2 > 78) {
                                    v2 = 78;
                                }
                                int v12 = this.p;
                                this.p = v12 + 1;
                                this.u[v12] = 10;
                            }
                            break;
                        }
                        case 11: {
                            if(this.m == 0x30) {
                                int v13 = this.p;
                                this.p = v13 + 1;
                                this.u[v13] = 12;
                            }
                            break;
                        }
                        case 13: {
                            if((0x3FF000000000000L & v6) != 0L) {
                                if(v2 > 80) {
                                    v2 = 80;
                                }
                                int v14 = this.p;
                                this.p = v14 + 1;
                                this.u[v14] = 13;
                            }
                            break;
                        }
                        case 14: {
                            if(this.m == 34) {
                                this.h(56, 58);
                            }
                            break;
                        }
                        case 16: {
                            this.h(56, 58);
                            break;
                        }
                        case 17: {
                            if((0xFFFFFFFBFFFFFFFFL & v6) != 0L) {
                                this.h(56, 58);
                            }
                            break;
                        }
                        case 18: {
                            if(this.m == 34 && v2 > 81) {
                                v2 = 81;
                            }
                            break;
                        }
                        case 19: {
                            if(this.m == 39) {
                                this.h(53, 55);
                            }
                            break;
                        }
                        case 21: {
                            this.h(53, 55);
                            break;
                        }
                        case 22: {
                            if((0xFFFFFF7FFFFFFFFFL & v6) != 0L) {
                                this.h(53, 55);
                            }
                            break;
                        }
                        case 23: {
                            if(this.m == 39 && v2 > 81) {
                                v2 = 81;
                            }
                            break;
                        }
                        case 24: {
                            if(this.m == 45) {
                                this.f(51, 52);
                            }
                            break;
                        }
                        case 25: {
                            if(this.m == 46) {
                                this.a(26);
                            }
                            break;
                        }
                        case 26: {
                            if((0x3FF000000000000L & v6) != 0L) {
                                if(v2 > 84) {
                                    v2 = 84;
                                }
                                this.g(26, 27);
                            }
                            break;
                        }
                        case 28: {
                            if((0x280000000000L & v6) != 0L) {
                                this.a(29);
                            }
                            break;
                        }
                        case 29: {
                            if((0x3FF000000000000L & v6) != 0L) {
                                if(v2 > 84) {
                                    v2 = 84;
                                }
                                this.a(29);
                            }
                            break;
                        }
                        case 30: {
                            if((0x3FF000000000000L & v6) != 0L) {
                                if(v2 > 84) {
                                    v2 = 84;
                                }
                                this.h(59, 62);
                            }
                            break;
                        }
                        case 0x1F: {
                            if((0x3FF000000000000L & v6) != 0L) {
                                this.g(0x1F, 0x20);
                            }
                            break;
                        }
                        case 0x20: {
                            if(this.m == 46) {
                                if(v2 > 84) {
                                    v2 = 84;
                                }
                                this.g(33, 34);
                            }
                            break;
                        }
                        case 33: {
                            if((0x3FF000000000000L & v6) != 0L) {
                                if(v2 > 84) {
                                    v2 = 84;
                                }
                                this.g(33, 34);
                            }
                            break;
                        }
                        case 35: {
                            if((0x280000000000L & v6) != 0L) {
                                this.a(36);
                            }
                            break;
                        }
                        case 36: {
                            if((0x3FF000000000000L & v6) != 0L) {
                                if(v2 > 84) {
                                    v2 = 84;
                                }
                                this.a(36);
                            }
                            break;
                        }
                        case 37: {
                            if((0x3FF000000000000L & v6) != 0L) {
                                if(v2 > 84) {
                                    v2 = 84;
                                }
                                this.g(37, 38);
                            }
                            break;
                        }
                        case 39: {
                            if((0x280000000000L & v6) != 0L) {
                                this.a(40);
                            }
                            break;
                        }
                        case 40: {
                            if((0x3FF000000000000L & v6) != 0L) {
                                if(v2 > 84) {
                                    v2 = 84;
                                }
                                this.a(40);
                            }
                            break;
                        }
                        case 41: {
                            if((0x100001200L & v6) != 0L) {
                                this.h(43, 46);
                            }
                            break;
                        }
                        case 42: {
                            if((0x100001200L & v6) != 0L) {
                                this.g(42, 43);
                            }
                            break;
                        }
                        case 43: {
                            if(this.m == 59) {
                                if(v2 > 4) {
                                    v2 = 4;
                                }
                                this.a(44);
                            }
                            break;
                        }
                        case 44: {
                            if((0xFFFFFFFFFFFFDBFFL & v6) != 0L) {
                                if(v2 > 4) {
                                    v2 = 4;
                                }
                                this.a(44);
                            }
                            break;
                        }
                        case 45: {
                            if(this.m == 59) {
                                if(v2 > 4) {
                                    v2 = 4;
                                }
                                this.h(0x2F, 50);
                            }
                            break;
                        }
                        case 0x2F: {
                            if((0x3FF000000000000L & v6) != 0L) {
                                if(v2 > 59) {
                                    v2 = 59;
                                }
                                int v15 = this.p;
                                this.p = v15 + 1;
                                this.u[v15] = 0x2F;
                            }
                            break;
                        }
                        case 0x30: {
                            if((0x3FF000000000000L & v6) != 0L) {
                                if(v2 > 77) {
                                    v2 = 77;
                                }
                                int v16 = this.p;
                                this.p = v16 + 1;
                                this.u[v16] = 0x30;
                            }
                            break;
                        }
                        case 49: {
                            if((0x3FF000000000000L & v6) != 0L) {
                                if(v2 > 0x4F) {
                                    v2 = 0x4F;
                                }
                                this.h(38, 42);
                            }
                            break;
                        }
                        case 50: {
                            if((0x3FF000000000000L & v6) != 0L) {
                                if(v2 > 0x4F) {
                                    v2 = 0x4F;
                                }
                                this.a(50);
                            }
                            break;
                        }
                        case 51: {
                            if((0x100001200L & v6) != 0L) {
                                this.g(1, 2);
                            }
                            else if(this.m == 59) {
                                this.h(0, 2);
                            }
                            if((0x100001200L & v6) != 0L) {
                                this.g(42, 43);
                            }
                            else if(this.m == 59) {
                                if(v2 > 4) {
                                    v2 = 4;
                                }
                                this.a(44);
                            }
                        }
                    }
                }
                while(v3 != v4);
            }
            else if(this.m < 0x80) {
                long v17 = 1L << (this.m & 0x3F);
                do {
                    --v3;
                    switch(this.u[v3]) {
                        case 3: {
                            this.f(0, 2);
                            break;
                        }
                        case 6: {
                            switch(this.m) {
                                case 0x75: {
                                    int v18 = this.p;
                                    this.p = v18 + 1;
                                    this.u[v18] = 10;
                                    break;
                                }
                                case 0x76: {
                                    this.f(0x3F, 0x40);
                                }
                            }
                            break;
                        }
                        case 7: 
                        case 8: {
                            if((0x7FFFFFE87FFFFFEL & v17) != 0L) {
                                if(v2 > 76) {
                                    v2 = 76;
                                }
                                this.a(8);
                            }
                            break;
                        }
                        case 9: {
                            if(this.m == 0x75) {
                                int v19 = this.p;
                                this.p = v19 + 1;
                                this.u[v19] = 10;
                            }
                            break;
                        }
                        case 12: {
                            if((0x100000001000000L & v17) != 0L) {
                                this.a(13);
                            }
                            break;
                        }
                        case 13: {
                            if((0x7E0000007EL & v17) != 0L) {
                                if(v2 > 80) {
                                    v2 = 80;
                                }
                                this.a(13);
                            }
                            break;
                        }
                        case 15: {
                            if(this.m == 92) {
                                int v20 = this.p;
                                this.p = v20 + 1;
                                this.u[v20] = 16;
                            }
                            break;
                        }
                        case 16: {
                            this.h(56, 58);
                            break;
                        }
                        case 17: {
                            if((0xFFFFFFFFEFFFFFFFL & v17) != 0L) {
                                this.h(56, 58);
                            }
                            break;
                        }
                        case 20: {
                            if(this.m == 92) {
                                int v21 = this.p;
                                this.p = v21 + 1;
                                this.u[v21] = 21;
                            }
                            break;
                        }
                        case 21: {
                            this.h(53, 55);
                            break;
                        }
                        case 22: {
                            if((0xFFFFFFFFEFFFFFFFL & v17) != 0L) {
                                this.h(53, 55);
                            }
                            break;
                        }
                        case 27: {
                            if((0x2000000020L & v17) != 0L) {
                                this.f(65, 66);
                            }
                            break;
                        }
                        case 34: {
                            if((0x2000000020L & v17) != 0L) {
                                this.f(67, 68);
                            }
                            break;
                        }
                        case 38: {
                            if((0x2000000020L & v17) != 0L) {
                                this.f(69, 70);
                            }
                            break;
                        }
                        case 44: {
                            if(v2 > 4) {
                                v2 = 4;
                            }
                            int v22 = this.p;
                            this.p = v22 + 1;
                            this.u[v22] = 44;
                            break;
                        }
                        case 46: {
                            if(this.m == 0x76) {
                                this.f(0x3F, 0x40);
                            }
                        }
                    }
                }
                while(v3 != v4);
            }
            else {
                int v23 = this.m >> 8;
                int v24 = v23 >> 6;
                long v25 = 1L << (v23 & 0x3F);
                int v26 = (this.m & 0xFF) >> 6;
                long v27 = 1L << (this.m & 0x3F);
                while(true) {
                    --v3;
                    switch(this.u[v3]) {
                        case 3: {
                            if(f.a(v23, v24, v26, v25, v27)) {
                                this.f(0, 2);
                            }
                            break;
                        }
                        case 16: 
                        case 17: {
                            if(f.a(v23, v24, v26, v25, v27)) {
                                this.h(56, 58);
                            }
                            break;
                        }
                        case 21: 
                        case 22: {
                            if(f.a(v23, v24, v26, v25, v27)) {
                                this.h(53, 55);
                            }
                            break;
                        }
                        case 44: {
                            if(f.a(v23, v24, v26, v25, v27)) {
                                if(v2 > 4) {
                                    v2 = 4;
                                }
                                int v28 = this.p;
                                this.p = v28 + 1;
                                this.u[v28] = 44;
                            }
                        }
                    }
                    if(v3 == v4) {
                        break;
                    }
                }
            }
            if(v2 != 0x7FFFFFFF) {
                this.s = v2;
                this.r = v1;
                v2 = 0x7FFFFFFF;
            }
            ++v1;
            int v29 = this.p;
            this.p = v4;
            if(v29 == 51 - v4) {
                return v1;
            }
            try {
                this.m = this.l.c();
                v3 = v29;
                v4 = 51 - v4;
                continue;
            }
            catch(IOException unused_ex) {
            }
            break;
        }
        return v1;
    }

    private int c(int v, int v1, int v2) {
        try {
            this.s = v1;
            this.r = v;
            this.m = this.l.c();
            return this.d(v2, v + 1);
        }
        catch(IOException unused_ex) {
            return v + 1;
        }
    }

    private final int c(int v, long v1, long v2) {
        if(v != 0) {
            return -1;
        }
        if((0xC000000000000000L & v1) != 0L || (0xBFFL & v2) != 0L) {
            return 26;
        }
        return (14L & v1) == 0L ? -1 : 51;
    }

    private int c(long v, long v1) {
        long v2 = v1 & v;
        if(v2 == 0L) {
            return this.b(12, 0L, v);
        }
        try {
            this.m = this.l.c();
            return this.m == 'e' ? this.d(v2, 1L) : this.b(13, 0L, v2);
        }
        catch(IOException unused_ex) {
            return 14;
        }
    }

    private int c(long v, long v1, long v2, long v3) {
        long v4 = v1 & v;
        long v5 = v3 & v2;
        if((v4 | v5) == 0L) {
            return this.b(2, v, v2);
        }
        try {
            this.m = this.l.c();
            switch(this.m) {
                case 0x20: {
                    return this.d(v4, 0L, v5, 0x80L);
                }
                case 65: {
                    return this.d(v4, 0x400DC00L, v5, 0L);
                }
                case 66: {
                    return this.d(v4, 0x80L, v5, 0L);
                }
                case 67: {
                    return this.d(v4, 0x4400000000L, v5, 0L);
                }
                case 73: {
                    return this.d(v4, 0x10000000000L, v5, 0L);
                }
                case 75: {
                    return (0x40L & v4) == 0L ? this.b(3, v4, v5) : this.a(4, 6);
                }
                case 76: {
                    return this.d(v4, 0x8000000000L, v5, 0L);
                }
                case 78: {
                    return this.d(v4, 0x100L, v5, 0L);
                }
                case 0x4F: {
                    return this.d(v4, 0x1000000000L, v5, 0L);
                }
                case 80: {
                    return this.d(v4, 0x2200L, v5, 0L);
                }
                case 82: {
                    return this.d(v4, 0x42800000000L, v5, 0L);
                }
                case 83: {
                    return this.d(v4, 0x100000000L, v5, 0L);
                }
                case 84: {
                    return (0x4000000000000L & v4) == 0L ? this.d(v4, 0x40000000000000L, v5, 0L) : this.a(4, 50);
                }
                case 85: {
                    return this.d(v4, 0x20000000000L, v5, 0L);
                }
                case 91: {
                    goto label_23;
                }
                case 0x5F: {
                    return this.d(v4, 0x80000000000000L, v5, 0L);
                }
                case 97: {
                    return this.d(v4, 0L, v5, 80L);
                }
                case 99: {
                    return (0x100L & v5) == 0L ? this.b(3, v4, v5) : this.a(4, 72);
                }
                case 101: {
                    goto label_29;
                }
                case 0x70: {
                    return this.d(v4, 0L, v5, 2L);
                }
                case 0x72: {
                    return this.d(v4, 0x4000000000000000L, v5, 0L);
                }
                case 0x73: {
                    return this.d(v4, 0L, v5, 8L);
                }
                case 0x74: {
                    return this.d(v4, 0L, v5, 1L);
                }
                case 0x76: {
                    return this.d(v4, 0L, v5, 4L);
                }
            }
        }
        catch(IOException unused_ex) {
            return 4;
        }
        return this.b(3, v4, v5);
    label_23:
        if((0x8000000000000L & v4) != 0L) {
            return this.a(4, 51);
        }
        return (0x10000000000000L & v4) == 0L ? this.b(3, v4, v5) : this.a(4, 52);
    label_29:
        if((0x400000000000000L & v4) != 0L) {
            return this.a(4, 58);
        }
        if((0x20L & v5) != 0L) {
            this.s = 69;
            this.r = 4;
        }
        return this.d(v4, 0x8000000000000000L, v5, 0L);
    }

    private int d() {
        switch(this.m) {
            case 9: {
                return this.b(0, 2, 51);
            }
            case 12: {
                return this.b(0, 3, 51);
            }
            case 0x20: {
                return this.b(0, 1, 51);
            }
            case 46: {
                return this.e(0xC000000000000000L, 0xBFFL);
            }
            case 65: {
                return this.e(0x20000L, 0L);
            }
            case 66: {
                return this.e(0xF00000000000L, 0L);
            }
            case 67: {
                return this.e(0x4020204000000L, 0L);
            }
            case 68: {
                return this.e(0x100000L, 0L);
            }
            case 69: {
                return this.e(0x10000000L, 0L);
            }
            case 70: {
                return this.e(0x8003000000000L, 0L);
            }
            case 71: {
                return this.e(0x10000000000E00L, 0L);
            }
            case 73: {
                return this.e(0x80000000000L, 0L);
            }
            case 74: {
                return this.e(0x8000000L, 0L);
            }
            case 76: {
                return this.e(0x620001C0L, 0L);
            }
            case 77: {
                return this.e(0x280020L, 0L);
            }
            case 78: {
                return this.e(0x1008000L, 0L);
            }
            case 0x4F: {
                return this.e(0x20000000000000L, 0L);
            }
            case 80: {
                return this.e(0x400000L, 0L);
            }
            case 82: {
                return this.e(0x800000000L, 0L);
            }
            case 83: {
                return this.e(0xC3010000057000L, 0L);
            }
            case 84: {
                return this.e(0xC580000000L, 0L);
            }
            case 85: {
                return this.e(0x800000L, 0L);
            }
            case 86: {
                return this.e(0x40000000000L, 0L);
            }
            case 102: {
                return this.e(0x400000000000000L, 0L);
            }
            case 110: {
                return this.e(0x100000000000000L, 0L);
            }
            case 0x74: {
                return this.e(0x200000000000000L, 0L);
            }
            default: {
                return this.c(6, 0);
            }
        }
    }

    private int d(int v, int v1) {
        this.p = 51;
        this.u[0] = v;
        int v2 = 0x7FFFFFFF;
        int v3 = 1;
        int v4 = 0;
        while(true) {
            int v5 = this.q + 1;
            this.q = v5;
            if(v5 == 0x7FFFFFFF) {
                this.g();
            }
            if(this.m < 0x40) {
                long v6 = 1L << this.m;
                do {
                    --v3;
                    switch(this.u[v3]) {
                        case 0: {
                            if((0x2400L & v6) != 0L) {
                                if(v2 > 74) {
                                    v2 = 74;
                                }
                                this.h(12, 15);
                            }
                            break;
                        }
                        case 1: {
                            if((0x100001200L & v6) != 0L) {
                                this.g(1, 2);
                            }
                            break;
                        }
                        case 2: {
                            if(this.m == 59) {
                                this.h(0, 2);
                            }
                            break;
                        }
                        case 3: {
                            if((0xFFFFFFFFFFFFDBFFL & v6) != 0L) {
                                this.h(0, 2);
                            }
                            break;
                        }
                        case 4: {
                            if(this.m == 10) {
                                if(v2 > 74) {
                                    v2 = 74;
                                }
                                this.h(12, 15);
                            }
                            break;
                        }
                        case 5: {
                            if(this.m == 13) {
                                int v7 = this.p;
                                this.p = v7 + 1;
                                this.u[v7] = 4;
                            }
                            break;
                        }
                        case 6: {
                            if((0x3FF000000000000L & v6) != 0L) {
                                if(v2 > 60) {
                                    v2 = 60;
                                }
                                this.h(71, 76);
                            }
                            else if((0x100001200L & v6) != 0L) {
                                this.h(77, 80);
                            }
                            else if((0x2400L & v6) == 0L) {
                                switch(this.m) {
                                    case 34: {
                                        this.h(25, 27);
                                        break;
                                    }
                                    case 39: {
                                        this.h(22, 24);
                                        break;
                                    }
                                    case 45: {
                                        this.h(81, 83);
                                        break;
                                    }
                                    case 46: {
                                        this.a(27);
                                        break;
                                    }
                                    case 58: {
                                        int v8 = this.p;
                                        this.p = v8 + 1;
                                        this.u[v8] = 7;
                                        break;
                                    }
                                    case 59: {
                                        if(v2 > 4) {
                                            v2 = 4;
                                        }
                                        this.h(84, 87);
                                    }
                                }
                            }
                            else {
                                if(v2 > 74) {
                                    v2 = 74;
                                }
                                this.h(12, 15);
                            }
                            switch(this.m) {
                                case 13: {
                                    int v9 = this.p;
                                    this.p = v9 + 1;
                                    this.u[v9] = 4;
                                    break;
                                }
                                case 0x30: {
                                    int v10 = this.p;
                                    this.p = v10 + 1;
                                    this.u[v10] = 14;
                                }
                            }
                            break;
                        }
                        case 8: {
                            if((0x3FF000000000000L & v6) != 0L) {
                                if(v2 > 76) {
                                    v2 = 76;
                                }
                                int v11 = this.p;
                                this.p = v11 + 1;
                                this.u[v11] = 8;
                            }
                            break;
                        }
                        case 10: {
                            if((0x3FF000000000000L & v6) != 0L) {
                                if(v2 > 77) {
                                    v2 = 77;
                                }
                                int v12 = this.p;
                                this.p = v12 + 1;
                                this.u[v12] = 10;
                            }
                            break;
                        }
                        case 12: {
                            if((0x3FF000000000000L & v6) != 0L) {
                                if(v2 > 78) {
                                    v2 = 78;
                                }
                                int v13 = this.p;
                                this.p = v13 + 1;
                                this.u[v13] = 12;
                            }
                            break;
                        }
                        case 13: {
                            if(this.m == 0x30) {
                                int v14 = this.p;
                                this.p = v14 + 1;
                                this.u[v14] = 14;
                            }
                            break;
                        }
                        case 15: {
                            if((0x3FF000000000000L & v6) != 0L) {
                                if(v2 > 80) {
                                    v2 = 80;
                                }
                                int v15 = this.p;
                                this.p = v15 + 1;
                                this.u[v15] = 15;
                            }
                            break;
                        }
                        case 16: {
                            if(this.m == 34) {
                                this.h(25, 27);
                            }
                            break;
                        }
                        case 18: {
                            this.h(25, 27);
                            break;
                        }
                        case 19: {
                            if((0xFFFFFFFBFFFFFFFFL & v6) != 0L) {
                                this.h(25, 27);
                            }
                            break;
                        }
                        case 20: {
                            if(this.m == 34 && v2 > 81) {
                                v2 = 81;
                            }
                            break;
                        }
                        case 21: {
                            if(this.m == 39) {
                                this.h(22, 24);
                            }
                            break;
                        }
                        case 23: {
                            this.h(22, 24);
                            break;
                        }
                        case 24: {
                            if((0xFFFFFF7FFFFFFFFFL & v6) != 0L) {
                                this.h(22, 24);
                            }
                            break;
                        }
                        case 25: {
                            if(this.m == 39 && v2 > 81) {
                                v2 = 81;
                            }
                            break;
                        }
                        case 26: {
                            if(this.m == 46) {
                                this.a(27);
                            }
                            break;
                        }
                        case 27: {
                            if((0x3FF000000000000L & v6) != 0L) {
                                if(v2 > 84) {
                                    v2 = 84;
                                }
                                this.g(27, 28);
                            }
                            break;
                        }
                        case 29: {
                            if((0x280000000000L & v6) != 0L) {
                                this.a(30);
                            }
                            break;
                        }
                        case 30: {
                            if((0x3FF000000000000L & v6) != 0L) {
                                if(v2 > 84) {
                                    v2 = 84;
                                }
                                this.a(30);
                            }
                            break;
                        }
                        case 0x1F: {
                            if((0x100001200L & v6) != 0L) {
                                this.h(77, 80);
                            }
                            break;
                        }
                        case 0x20: {
                            if((0x100001200L & v6) != 0L) {
                                this.g(0x20, 33);
                            }
                            break;
                        }
                        case 33: {
                            if(this.m == 59) {
                                if(v2 > 4) {
                                    v2 = 4;
                                }
                                this.a(34);
                            }
                            break;
                        }
                        case 34: {
                            if((0xFFFFFFFFFFFFDBFFL & v6) != 0L) {
                                if(v2 > 4) {
                                    v2 = 4;
                                }
                                this.a(34);
                            }
                            break;
                        }
                        case 35: {
                            if(this.m == 59) {
                                if(v2 > 4) {
                                    v2 = 4;
                                }
                                this.h(84, 87);
                            }
                            break;
                        }
                        case 36: {
                            if(this.m == 45) {
                                this.h(81, 83);
                            }
                            break;
                        }
                        case 37: {
                            if((0x3FF000000000000L & v6) != 0L) {
                                if(v2 > 60) {
                                    v2 = 60;
                                }
                                this.a(37);
                            }
                            break;
                        }
                        case 38: {
                            if((0x3FF000000000000L & v6) != 0L) {
                                if(v2 > 84) {
                                    v2 = 84;
                                }
                                this.h(88, 91);
                            }
                            break;
                        }
                        case 39: {
                            if((0x3FF000000000000L & v6) != 0L) {
                                this.g(39, 40);
                            }
                            break;
                        }
                        case 40: {
                            if(this.m == 46) {
                                if(v2 > 84) {
                                    v2 = 84;
                                }
                                this.g(41, 42);
                            }
                            break;
                        }
                        case 41: {
                            if((0x3FF000000000000L & v6) != 0L) {
                                if(v2 > 84) {
                                    v2 = 84;
                                }
                                this.g(41, 42);
                            }
                            break;
                        }
                        case 43: {
                            if((0x280000000000L & v6) != 0L) {
                                this.a(44);
                            }
                            break;
                        }
                        case 44: {
                            if((0x3FF000000000000L & v6) != 0L) {
                                if(v2 > 84) {
                                    v2 = 84;
                                }
                                this.a(44);
                            }
                            break;
                        }
                        case 45: {
                            if((0x3FF000000000000L & v6) != 0L) {
                                if(v2 > 84) {
                                    v2 = 84;
                                }
                                this.g(45, 46);
                            }
                            break;
                        }
                        case 0x2F: {
                            if((0x280000000000L & v6) != 0L) {
                                this.a(0x30);
                            }
                            break;
                        }
                        case 0x30: {
                            if((0x3FF000000000000L & v6) != 0L) {
                                if(v2 > 84) {
                                    v2 = 84;
                                }
                                this.a(0x30);
                            }
                            break;
                        }
                        case 49: {
                            if((0x3FF000000000000L & v6) != 0L) {
                                if(v2 > 60) {
                                    v2 = 60;
                                }
                                this.h(71, 76);
                            }
                            break;
                        }
                        case 50: {
                            if((0x3FF000000000000L & v6) != 0L) {
                                if(v2 > 0x4F) {
                                    v2 = 0x4F;
                                }
                                this.a(50);
                            }
                            break;
                        }
                        case 51: {
                            if((0x100001200L & v6) != 0L) {
                                this.g(1, 2);
                            }
                            else if(this.m == 59) {
                                this.h(0, 2);
                            }
                            if((0x100001200L & v6) != 0L) {
                                this.g(0x20, 33);
                            }
                            else if(this.m == 59) {
                                if(v2 > 4) {
                                    v2 = 4;
                                }
                                this.a(34);
                            }
                        }
                    }
                }
                while(v3 != v4);
            }
            else if(this.m < 0x80) {
                long v16 = 1L << (this.m & 0x3F);
                do {
                    --v3;
                    switch(this.u[v3]) {
                        case 3: {
                            this.f(0, 2);
                            break;
                        }
                        case 6: {
                            switch(this.m) {
                                case 0x75: {
                                    int v17 = this.p;
                                    this.p = v17 + 1;
                                    this.u[v17] = 12;
                                    break;
                                }
                                case 0x76: {
                                    int v18 = this.p;
                                    this.p = v18 + 1;
                                    this.u[v18] = 10;
                                }
                            }
                            break;
                        }
                        case 7: 
                        case 8: {
                            if((0x7FFFFFE87FFFFFEL & v16) != 0L) {
                                if(v2 > 76) {
                                    v2 = 76;
                                }
                                this.a(8);
                            }
                            break;
                        }
                        case 9: {
                            if(this.m == 0x76) {
                                int v19 = this.p;
                                this.p = v19 + 1;
                                this.u[v19] = 10;
                            }
                            break;
                        }
                        case 11: {
                            if(this.m == 0x75) {
                                int v20 = this.p;
                                this.p = v20 + 1;
                                this.u[v20] = 12;
                            }
                            break;
                        }
                        case 14: {
                            if((0x100000001000000L & v16) != 0L) {
                                this.a(15);
                            }
                            break;
                        }
                        case 15: {
                            if((0x7E0000007EL & v16) != 0L) {
                                if(v2 > 80) {
                                    v2 = 80;
                                }
                                this.a(15);
                            }
                            break;
                        }
                        case 17: {
                            if(this.m == 92) {
                                int v21 = this.p;
                                this.p = v21 + 1;
                                this.u[v21] = 18;
                            }
                            break;
                        }
                        case 18: {
                            this.h(25, 27);
                            break;
                        }
                        case 19: {
                            if((0xFFFFFFFFEFFFFFFFL & v16) != 0L) {
                                this.h(25, 27);
                            }
                            break;
                        }
                        case 22: {
                            if(this.m == 92) {
                                int v22 = this.p;
                                this.p = v22 + 1;
                                this.u[v22] = 23;
                            }
                            break;
                        }
                        case 23: {
                            this.h(22, 24);
                            break;
                        }
                        case 24: {
                            if((0xFFFFFFFFEFFFFFFFL & v16) != 0L) {
                                this.h(22, 24);
                            }
                            break;
                        }
                        case 28: {
                            if((0x2000000020L & v16) != 0L) {
                                this.f(92, 93);
                            }
                            break;
                        }
                        case 34: {
                            if(v2 > 4) {
                                v2 = 4;
                            }
                            int v23 = this.p;
                            this.p = v23 + 1;
                            this.u[v23] = 34;
                            break;
                        }
                        case 42: {
                            if((0x2000000020L & v16) != 0L) {
                                this.f(94, 0x5F);
                            }
                            break;
                        }
                        case 46: {
                            if((0x2000000020L & v16) != 0L) {
                                this.f(0x3F, 0x40);
                            }
                        }
                    }
                }
                while(v3 != v4);
            }
            else {
                int v24 = this.m >> 8;
                int v25 = v24 >> 6;
                long v26 = 1L << (v24 & 0x3F);
                int v27 = (this.m & 0xFF) >> 6;
                long v28 = 1L << (this.m & 0x3F);
                while(true) {
                    --v3;
                    switch(this.u[v3]) {
                        case 3: {
                            if(f.a(v24, v25, v27, v26, v28)) {
                                this.f(0, 2);
                            }
                            break;
                        }
                        case 18: 
                        case 19: {
                            if(f.a(v24, v25, v27, v26, v28)) {
                                this.h(25, 27);
                            }
                            break;
                        }
                        case 23: 
                        case 24: {
                            if(f.a(v24, v25, v27, v26, v28)) {
                                this.h(22, 24);
                            }
                            break;
                        }
                        case 34: {
                            if(f.a(v24, v25, v27, v26, v28)) {
                                if(v2 > 4) {
                                    v2 = 4;
                                }
                                int v29 = this.p;
                                this.p = v29 + 1;
                                this.u[v29] = 34;
                            }
                        }
                    }
                    if(v3 == v4) {
                        break;
                    }
                }
            }
            if(v2 != 0x7FFFFFFF) {
                this.s = v2;
                this.r = v1;
                v2 = 0x7FFFFFFF;
            }
            ++v1;
            int v30 = this.p;
            this.p = v4;
            if(v30 == 51 - v4) {
                return v1;
            }
            try {
                this.m = this.l.c();
                v3 = v30;
                v4 = 51 - v4;
                continue;
            }
            catch(IOException unused_ex) {
            }
            break;
        }
        return v1;
    }

    private int d(int v, int v1, int v2) {
        try {
            this.s = v1;
            this.r = v;
            this.m = this.l.c();
            return this.e(v2, v + 1);
        }
        catch(IOException unused_ex) {
            return v + 1;
        }
    }

    private final int d(int v, long v1, long v2) {
        return this.c(this.c(v, v1, v2), v + 1);
    }

    private int d(long v, long v1) {
        long v2 = v1 & v;
        if(v2 == 0L) {
            return this.b(13, 0L, v);
        }
        try {
            this.m = this.l.c();
        }
        catch(IOException unused_ex) {
            return 15;
        }
        if(this.m != 'd') {
            return this.b(14, 0L, v2);
        }
        return (1L & v2) == 0L ? this.b(14, 0L, v2) : this.a(15, 0x40);
    }

    private int d(long v, long v1, long v2, long v3) {
        long v4 = v1 & v;
        long v5 = v3 & v2;
        if((v4 | v5) == 0L) {
            return this.b(3, v, v2);
        }
        try {
            this.m = this.l.c();
            switch(this.m) {
                case 65: {
                    return this.e(v4, 0x4400000000L, v5, 0L);
                }
                case 66: {
                    return this.e(v4, 0xDC00L, v5, 0L);
                }
                case 69: {
                    return this.e(v4, 0x2100000000L, v5, 0L);
                }
                case 71: {
                    return (0x40000000000L & v4) == 0L ? this.b(4, v4, v5) : this.a(5, 42);
                }
                case 73: {
                    return this.e(v4, 0x100L, v5, 0L);
                }
                case 78: {
                    return (0x800000000L & v4) == 0L ? this.e(v4, 0x80000000000000L, v5, 0L) : this.a(5, 35);
                }
                case 0x4F: {
                    return this.e(v4, 0x40009000000080L, v5, 0L);
                }
                case 82: {
                    return this.e(v4, 0x20000000000L, v5, 0L);
                }
                case 83: {
                    return this.e(v4, 0x10000000000L, v5, 0L);
                }
                case 84: {
                    return (0x4000000L & v4) == 0L ? this.b(4, v4, v5) : this.a(5, 26);
                }
                case 86: {
                    return this.e(v4, 0x2200L, v5, 0L);
                }
                case 97: {
                    return this.e(v4, 0L, v5, 6L);
                }
                case 99: {
                    return this.e(v4, 0x4000000000000000L, v5, 0L);
                }
                case 100: {
                    return this.e(v4, 0x8000000000000000L, v5, 0L);
                }
                case 108: {
                    goto label_23;
                }
                case 0x74: {
                    return this.e(v4, 0L, v5, 8L);
                }
            }
        }
        catch(IOException unused_ex) {
            return 5;
        }
        return this.b(4, v4, v5);
    label_23:
        if((16L & v5) != 0L) {
            return this.a(5, 68);
        }
        return (0x40L & v5) == 0L ? this.e(v4, 0L, v5, 0x81L) : this.a(5, 70);
    }

    private int e() {
        switch(this.m) {
            case 9: {
                return this.c(0, 2, 51);
            }
            case 12: {
                return this.c(0, 3, 51);
            }
            case 0x20: {
                return this.c(0, 1, 51);
            }
            case 46: {
                return this.i(0xC000000000000000L, 0xBFFL);
            }
            case 65: {
                return this.i(0x20000L, 0L);
            }
            case 66: {
                return this.i(0xF00000000000L, 0L);
            }
            case 67: {
                return this.i(0x4020204000000L, 0L);
            }
            case 68: {
                return this.i(0x100000L, 0L);
            }
            case 69: {
                return this.i(0x10000000L, 0L);
            }
            case 70: {
                return this.i(0x8003000000000L, 0L);
            }
            case 71: {
                return this.i(0x10000000000E00L, 0L);
            }
            case 73: {
                return this.i(0x80000000000L, 0L);
            }
            case 74: {
                return this.i(0x8000000L, 0L);
            }
            case 76: {
                return this.i(0x620001C0L, 0L);
            }
            case 77: {
                return this.i(0x280020L, 0L);
            }
            case 78: {
                return this.i(0x1008000L, 0L);
            }
            case 0x4F: {
                return this.i(0x20000000000000L, 0L);
            }
            case 80: {
                return this.i(0x400000L, 0L);
            }
            case 82: {
                return this.i(0x800000000L, 0L);
            }
            case 83: {
                return this.i(0xC3010000057000L, 0L);
            }
            case 84: {
                return this.i(0xC580000000L, 0L);
            }
            case 85: {
                return this.i(0x800000L, 0L);
            }
            case 86: {
                return this.i(0x40000000000L, 0L);
            }
            case 102: {
                return this.i(0x400000000000000L, 0L);
            }
            case 110: {
                return this.i(0x100000000000000L, 0L);
            }
            case 0x74: {
                return this.i(0x200000000000000L, 0L);
            }
            default: {
                return this.d(6, 0);
            }
        }
    }

    private int e(int v, int v1) {
        this.p = 52;
        this.u[0] = v;
        int v2 = 0x7FFFFFFF;
        int v3 = 1;
        int v4 = 0;
        while(true) {
            int v5 = this.q + 1;
            this.q = v5;
            if(v5 == 0x7FFFFFFF) {
                this.g();
            }
            if(this.m < 0x40) {
                long v6 = 1L << this.m;
                do {
                    --v3;
                    switch(this.u[v3]) {
                        case 0: {
                            if((0x3FF000000000000L & v6) != 0L) {
                                if(v2 > 0x4F) {
                                    v2 = 0x4F;
                                }
                                this.h(0x60, 100);
                            }
                            else if((0x100001200L & v6) != 0L) {
                                this.h(101, 104);
                            }
                            else if((0x2400L & v6) == 0L) {
                                switch(this.m) {
                                    case 34: {
                                        this.h(0x76, 120);
                                        break;
                                    }
                                    case 39: {
                                        this.h(0x73, 0x75);
                                        break;
                                    }
                                    case 45: {
                                        this.f(0x71, 0x72);
                                        break;
                                    }
                                    case 46: {
                                        this.a(30);
                                        break;
                                    }
                                    case 58: {
                                        int v7 = this.p;
                                        this.p = v7 + 1;
                                        this.u[v7] = 9;
                                        break;
                                    }
                                    case 59: {
                                        if(v2 > 4) {
                                            v2 = 4;
                                        }
                                        this.h(109, 0x70);
                                    }
                                }
                            }
                            else {
                                if(v2 > 74) {
                                    v2 = 74;
                                }
                                this.h(105, 108);
                            }
                            switch(this.m) {
                                case 13: {
                                    int v8 = this.p;
                                    this.p = v8 + 1;
                                    this.u[v8] = 6;
                                    break;
                                }
                                case 0x30: {
                                    int v9 = this.p;
                                    this.p = v9 + 1;
                                    this.u[v9] = 16;
                                }
                            }
                            break;
                        }
                        case 1: {
                            if((0x3FF000000000000L & v6) != 0L) {
                                if(v2 > 61) {
                                    v2 = 61;
                                }
                                int v10 = this.p;
                                this.p = v10 + 1;
                                this.u[v10] = 1;
                            }
                            break;
                        }
                        case 2: {
                            if((0x2400L & v6) != 0L) {
                                if(v2 > 74) {
                                    v2 = 74;
                                }
                                this.h(105, 108);
                            }
                            break;
                        }
                        case 3: {
                            if((0x100001200L & v6) != 0L) {
                                this.g(3, 4);
                            }
                            break;
                        }
                        case 4: {
                            if(this.m == 59) {
                                this.h(0x79, 0x7B);
                            }
                            break;
                        }
                        case 5: {
                            if((0xFFFFFFFFFFFFDBFFL & v6) != 0L) {
                                this.h(0x79, 0x7B);
                            }
                            break;
                        }
                        case 6: {
                            if(this.m == 10) {
                                if(v2 > 74) {
                                    v2 = 74;
                                }
                                this.h(105, 108);
                            }
                            break;
                        }
                        case 7: {
                            if(this.m == 13) {
                                int v11 = this.p;
                                this.p = v11 + 1;
                                this.u[v11] = 6;
                            }
                            break;
                        }
                        case 8: {
                            if(this.m == 58) {
                                int v12 = this.p;
                                this.p = v12 + 1;
                                this.u[v12] = 9;
                            }
                            break;
                        }
                        case 10: {
                            if((0x3FF000000000000L & v6) != 0L) {
                                if(v2 > 76) {
                                    v2 = 76;
                                }
                                int v13 = this.p;
                                this.p = v13 + 1;
                                this.u[v13] = 10;
                            }
                            break;
                        }
                        case 12: {
                            if((0x3FF000000000000L & v6) != 0L) {
                                if(v2 > 77) {
                                    v2 = 77;
                                }
                                int v14 = this.p;
                                this.p = v14 + 1;
                                this.u[v14] = 12;
                            }
                            break;
                        }
                        case 14: {
                            if((0x3FF000000000000L & v6) != 0L) {
                                if(v2 > 78) {
                                    v2 = 78;
                                }
                                int v15 = this.p;
                                this.p = v15 + 1;
                                this.u[v15] = 14;
                            }
                            break;
                        }
                        case 15: {
                            if(this.m == 0x30) {
                                int v16 = this.p;
                                this.p = v16 + 1;
                                this.u[v16] = 16;
                            }
                            break;
                        }
                        case 17: {
                            if((0x3FF000000000000L & v6) != 0L) {
                                if(v2 > 80) {
                                    v2 = 80;
                                }
                                int v17 = this.p;
                                this.p = v17 + 1;
                                this.u[v17] = 17;
                            }
                            break;
                        }
                        case 18: {
                            if(this.m == 34) {
                                this.h(0x76, 120);
                            }
                            break;
                        }
                        case 20: {
                            this.h(0x76, 120);
                            break;
                        }
                        case 21: {
                            if((0xFFFFFFFBFFFFFFFFL & v6) != 0L) {
                                this.h(0x76, 120);
                            }
                            break;
                        }
                        case 22: {
                            if(this.m == 34 && v2 > 81) {
                                v2 = 81;
                            }
                            break;
                        }
                        case 23: {
                            if(this.m == 39) {
                                this.h(0x73, 0x75);
                            }
                            break;
                        }
                        case 25: {
                            this.h(0x73, 0x75);
                            break;
                        }
                        case 26: {
                            if((0xFFFFFF7FFFFFFFFFL & v6) != 0L) {
                                this.h(0x73, 0x75);
                            }
                            break;
                        }
                        case 27: {
                            if(this.m == 39 && v2 > 81) {
                                v2 = 81;
                            }
                            break;
                        }
                        case 28: {
                            if(this.m == 45) {
                                this.f(0x71, 0x72);
                            }
                            break;
                        }
                        case 29: {
                            if(this.m == 46) {
                                this.a(30);
                            }
                            break;
                        }
                        case 30: {
                            if((0x3FF000000000000L & v6) != 0L) {
                                if(v2 > 84) {
                                    v2 = 84;
                                }
                                this.g(30, 0x1F);
                            }
                            break;
                        }
                        case 0x20: {
                            if((0x280000000000L & v6) != 0L) {
                                this.a(33);
                            }
                            break;
                        }
                        case 33: {
                            if((0x3FF000000000000L & v6) != 0L) {
                                if(v2 > 84) {
                                    v2 = 84;
                                }
                                this.a(33);
                            }
                            break;
                        }
                        case 34: {
                            if((0x3FF000000000000L & v6) != 0L) {
                                if(v2 > 84) {
                                    v2 = 84;
                                }
                                this.h(0x7C, 0x7F);
                            }
                            break;
                        }
                        case 35: {
                            if((0x3FF000000000000L & v6) != 0L) {
                                this.g(35, 36);
                            }
                            break;
                        }
                        case 36: {
                            if(this.m == 46) {
                                if(v2 > 84) {
                                    v2 = 84;
                                }
                                this.g(37, 38);
                            }
                            break;
                        }
                        case 37: {
                            if((0x3FF000000000000L & v6) != 0L) {
                                if(v2 > 84) {
                                    v2 = 84;
                                }
                                this.g(37, 38);
                            }
                            break;
                        }
                        case 39: {
                            if((0x280000000000L & v6) != 0L) {
                                this.a(40);
                            }
                            break;
                        }
                        case 40: {
                            if((0x3FF000000000000L & v6) != 0L) {
                                if(v2 > 84) {
                                    v2 = 84;
                                }
                                this.a(40);
                            }
                            break;
                        }
                        case 41: {
                            if((0x3FF000000000000L & v6) != 0L) {
                                if(v2 > 84) {
                                    v2 = 84;
                                }
                                this.g(41, 42);
                            }
                            break;
                        }
                        case 43: {
                            if((0x280000000000L & v6) != 0L) {
                                this.a(44);
                            }
                            break;
                        }
                        case 44: {
                            if((0x3FF000000000000L & v6) != 0L) {
                                if(v2 > 84) {
                                    v2 = 84;
                                }
                                this.a(44);
                            }
                            break;
                        }
                        case 45: {
                            if((0x100001200L & v6) != 0L) {
                                this.h(101, 104);
                            }
                            break;
                        }
                        case 46: {
                            if((0x100001200L & v6) != 0L) {
                                this.g(46, 0x2F);
                            }
                            break;
                        }
                        case 0x2F: {
                            if(this.m == 59) {
                                if(v2 > 4) {
                                    v2 = 4;
                                }
                                this.a(0x30);
                            }
                            break;
                        }
                        case 0x30: {
                            if((0xFFFFFFFFFFFFDBFFL & v6) != 0L) {
                                if(v2 > 4) {
                                    v2 = 4;
                                }
                                this.a(0x30);
                            }
                            break;
                        }
                        case 49: {
                            if(this.m == 59) {
                                if(v2 > 4) {
                                    v2 = 4;
                                }
                                this.h(109, 0x70);
                            }
                            break;
                        }
                        case 50: {
                            if((0x3FF000000000000L & v6) != 0L) {
                                if(v2 > 0x4F) {
                                    v2 = 0x4F;
                                }
                                this.h(0x60, 100);
                            }
                            break;
                        }
                        case 51: {
                            if((0x3FF000000000000L & v6) != 0L) {
                                if(v2 > 0x4F) {
                                    v2 = 0x4F;
                                }
                                this.a(51);
                            }
                            break;
                        }
                        case 52: {
                            if((0x100001200L & v6) != 0L) {
                                this.g(3, 4);
                            }
                            else if(this.m == 59) {
                                this.h(0x79, 0x7B);
                            }
                            if((0x100001200L & v6) != 0L) {
                                this.g(46, 0x2F);
                            }
                            else if(this.m == 59) {
                                if(v2 > 4) {
                                    v2 = 4;
                                }
                                this.a(0x30);
                            }
                        }
                    }
                }
                while(v3 != v4);
            }
            else if(this.m < 0x80) {
                long v18 = 1L << (this.m & 0x3F);
                do {
                    --v3;
                    switch(this.u[v3]) {
                        case 0: {
                            if((0x7FFFFFE87FFFFFEL & v18) != 0L) {
                                if(v2 > 61) {
                                    v2 = 61;
                                }
                                this.a(1);
                            }
                            switch(this.m) {
                                case 0x75: {
                                    int v19 = this.p;
                                    this.p = v19 + 1;
                                    this.u[v19] = 14;
                                    break;
                                }
                                case 0x76: {
                                    int v20 = this.p;
                                    this.p = v20 + 1;
                                    this.u[v20] = 12;
                                }
                            }
                            break;
                        }
                        case 1: {
                            if((0x7FFFFFE87FFFFFEL & v18) != 0L) {
                                if(v2 > 61) {
                                    v2 = 61;
                                }
                                this.a(1);
                            }
                            break;
                        }
                        case 5: {
                            this.f(0x79, 0x7B);
                            break;
                        }
                        case 9: 
                        case 10: {
                            if((0x7FFFFFE87FFFFFEL & v18) != 0L) {
                                if(v2 > 76) {
                                    v2 = 76;
                                }
                                this.a(10);
                            }
                            break;
                        }
                        case 11: {
                            if(this.m == 0x76) {
                                int v21 = this.p;
                                this.p = v21 + 1;
                                this.u[v21] = 12;
                            }
                            break;
                        }
                        case 13: {
                            if(this.m == 0x75) {
                                int v22 = this.p;
                                this.p = v22 + 1;
                                this.u[v22] = 14;
                            }
                            break;
                        }
                        case 16: {
                            if((0x100000001000000L & v18) != 0L) {
                                this.a(17);
                            }
                            break;
                        }
                        case 17: {
                            if((0x7E0000007EL & v18) != 0L) {
                                if(v2 > 80) {
                                    v2 = 80;
                                }
                                this.a(17);
                            }
                            break;
                        }
                        case 19: {
                            if(this.m == 92) {
                                int v23 = this.p;
                                this.p = v23 + 1;
                                this.u[v23] = 20;
                            }
                            break;
                        }
                        case 20: {
                            this.h(0x76, 120);
                            break;
                        }
                        case 21: {
                            if((0xFFFFFFFFEFFFFFFFL & v18) != 0L) {
                                this.h(0x76, 120);
                            }
                            break;
                        }
                        case 24: {
                            if(this.m == 92) {
                                int v24 = this.p;
                                this.p = v24 + 1;
                                this.u[v24] = 25;
                            }
                            break;
                        }
                        case 25: {
                            this.h(0x73, 0x75);
                            break;
                        }
                        case 26: {
                            if((0xFFFFFFFFEFFFFFFFL & v18) != 0L) {
                                this.h(0x73, 0x75);
                            }
                            break;
                        }
                        case 0x1F: {
                            if((0x2000000020L & v18) != 0L) {
                                this.f(0x80, 0x81);
                            }
                            break;
                        }
                        case 38: {
                            if((0x2000000020L & v18) != 0L) {
                                this.f(69, 70);
                            }
                            break;
                        }
                        case 42: {
                            if((0x2000000020L & v18) != 0L) {
                                this.f(94, 0x5F);
                            }
                            break;
                        }
                        case 0x30: {
                            if(v2 > 4) {
                                v2 = 4;
                            }
                            int v25 = this.p;
                            this.p = v25 + 1;
                            this.u[v25] = 0x30;
                        }
                    }
                }
                while(v3 != v4);
            }
            else {
                int v26 = this.m >> 8;
                int v27 = v26 >> 6;
                long v28 = 1L << (v26 & 0x3F);
                int v29 = (this.m & 0xFF) >> 6;
                long v30 = 1L << (this.m & 0x3F);
                while(true) {
                    --v3;
                    switch(this.u[v3]) {
                        case 5: {
                            if(f.a(v26, v27, v29, v28, v30)) {
                                this.f(0x79, 0x7B);
                            }
                            break;
                        }
                        case 20: 
                        case 21: {
                            if(f.a(v26, v27, v29, v28, v30)) {
                                this.h(0x76, 120);
                            }
                            break;
                        }
                        case 25: 
                        case 26: {
                            if(f.a(v26, v27, v29, v28, v30)) {
                                this.h(0x73, 0x75);
                            }
                            break;
                        }
                        case 0x30: {
                            if(f.a(v26, v27, v29, v28, v30)) {
                                if(v2 > 4) {
                                    v2 = 4;
                                }
                                int v31 = this.p;
                                this.p = v31 + 1;
                                this.u[v31] = 0x30;
                            }
                        }
                    }
                    if(v3 == v4) {
                        break;
                    }
                }
            }
            if(v2 != 0x7FFFFFFF) {
                this.s = v2;
                this.r = v1;
                v2 = 0x7FFFFFFF;
            }
            ++v1;
            int v32 = this.p;
            this.p = v4;
            if(v32 == 52 - v4) {
                return v1;
            }
            try {
                this.m = this.l.c();
                v3 = v32;
                v4 = 52 - v4;
                continue;
            }
            catch(IOException unused_ex) {
            }
            break;
        }
        return v1;
    }

    private final int e(int v, long v1, long v2) {
        if(v != 0) {
            return -1;
        }
        if((14L & v1) != 0L) {
            return 51;
        }
        return (0xC000000000000000L & v1) == 0L && (0xBFFL & v2) == 0L ? -1 : 27;
    }

    private int e(long v, long v1) {
        try {
            this.m = this.l.c();
            switch(this.m) {
                case 46: {
                    return (0x800L & v1) == 0L ? this.d(0, v, v1) : this.a(1, 75);
                }
                case 65: {
                    return this.l(v, 0x240600000000L, v1, 0L);
                }
                case 68: {
                    return this.l(v, 0x80000020000L, v1, 0L);
                }
                case 69: {
                    goto label_8;
                }
                case 70: {
                    return this.l(v, 0xC000000000L, v1, 0L);
                }
                case 72: {
                    return this.l(v, 0x3000000000000L, v1, 0L);
                }
                case 73: {
                    return this.l(v, 0x100000L, v1, 0L);
                }
                case 75: {
                    return this.l(v, 0x80000000000000L, v1, 0L);
                }
                case 76: {
                    return this.l(v, 0x20000000000L, v1, 0L);
                }
                case 77: {
                    return this.l(v, 0x8000000L, v1, 0L);
                }
                case 78: {
                    return this.l(v, 0x100000800000L, v1, 0L);
                }
                case 0x4F: {
                    return this.l(v, 0x144030056001E0L, v1, 0L);
                }
                case 80: {
                    return (0x20000000000000L & v) == 0L ? this.d(0, v, v1) : this.a(1, 53);
                }
                case 81: {
                    return (0x10000000L & v) == 0L ? this.d(0, v, v1) : this.a(1, 28);
                }
                case 84: {
                    return (0x20000000L & v) == 0L ? this.d(0, v, v1) : this.a(1, 29);
                }
                case 85: {
                    return this.l(v, 0x80000000C0000L, v1, 0L);
                }
                case 88: {
                    return this.l(v, 0x800000000000L, v1, 0L);
                }
                case 97: {
                    return this.l(v, 0x400000000000000L, v1, 0L);
                }
                case 101: {
                    return this.l(v, 0L, v1, 640L);
                }
                case 102: {
                    return this.l(v, 0L, v1, 0x100L);
                }
                case 105: {
                    return this.l(v, 0x100000000000000L, v1, 4L);
                }
                case 108: {
                    return this.l(v, 0x8000000000000000L, v1, 97L);
                }
                case 109: {
                    return this.l(v, 0L, v1, 8L);
                }
                case 110: {
                    return this.l(v, 0L, v1, 2L);
                }
                case 0x72: {
                    return this.l(v, 0x200000000000000L, v1, 0L);
                }
                case 0x73: {
                    return this.l(v, 0x4000000000000000L, v1, 0L);
                }
                case 0x75: {
                    return this.l(v, 0L, v1, 16L);
                }
            }
        }
        catch(IOException unused_ex) {
            return 1;
        }
        return this.d(0, v, v1);
    label_8:
        if((0x40000000L & v) != 0L) {
            this.s = 30;
            this.r = 1;
        }
        return this.l(v, 0x4001098201FE00L, v1, 0L);
    }

    private int e(long v, long v1, long v2, long v3) {
        long v4 = v1 & v;
        long v5 = v3 & v2;
        if((v4 | v5) == 0L) {
            return this.b(4, v, v2);
        }
        try {
            this.m = this.l.c();
            switch(this.m) {
                case 65: {
                    return this.f(v4, 0x2200L, v5, 0L);
                }
                case 69: {
                    return (0x20000000000L & v4) == 0L ? this.f(v4, 0x80000000000000L, v5, 0L) : this.a(6, 41);
                }
                case 76: {
                    return (0x100L & v4) == 0L ? this.f(v4, 0x440000C800L, v5, 0L) : this.a(6, 8);
                }
                case 0x4F: {
                    return this.f(v4, 0x8000000080L, v5, 0L);
                }
                case 80: {
                    goto label_13;
                }
                case 84: {
                    goto label_18;
                }
                case 85: {
                    return this.f(v4, 0x1400L, v5, 0L);
                }
                case 97: {
                    return this.f(v4, 0L, v5, 8L);
                }
                case 101: {
                    return (0x4000000000000000L & v4) == 0L ? this.f(v4, 0x8000000000000000L, v5, 0L) : this.a(6, 62);
                }
                case 105: {
                    return this.f(v4, 0L, v5, 1L);
                }
                case 0x6F: {
                    return this.f(v4, 0L, v5, 0x80L);
                }
                case 0x72: {
                    return this.f(v4, 0L, v5, 6L);
                }
            }
        }
        catch(IOException unused_ex) {
            return 6;
        }
        return this.b(5, v4, v5);
    label_13:
        if((0x1000000000L & v4) != 0L) {
            return this.a(6, 36);
        }
        if((0x2000000000L & v4) != 0L) {
            return this.a(6, 37);
        }
        return (0x40000000000000L & v4) == 0L ? this.b(5, v4, v5) : this.a(6, 54);
    label_18:
        if((0x100000000L & v4) != 0L) {
            return this.a(6, 0x20);
        }
        return (0x10000000000L & v4) == 0L ? this.b(5, v4, v5) : this.a(6, 40);
    }

    private int f() {
        switch(this.m) {
            case 9: {
                return this.d(0, 2, 52);
            }
            case 12: {
                return this.d(0, 3, 52);
            }
            case 0x20: {
                return this.d(0, 1, 52);
            }
            case 46: {
                return this.m(0xC000000000000000L, 0xBFFL);
            }
            case 65: {
                return this.m(0x20000L, 0L);
            }
            case 66: {
                return this.m(0xF00000000000L, 0L);
            }
            case 67: {
                return this.m(0x4020204000000L, 0L);
            }
            case 68: {
                return this.m(0x100000L, 0L);
            }
            case 69: {
                return this.m(0x10000000L, 0L);
            }
            case 70: {
                return this.m(0x8003000000000L, 0L);
            }
            case 71: {
                return this.m(0x10000000000E00L, 0L);
            }
            case 73: {
                return this.m(0x80000000000L, 0L);
            }
            case 74: {
                return this.m(0x8000000L, 0L);
            }
            case 76: {
                return this.m(0x620001C0L, 0L);
            }
            case 77: {
                return this.m(0x280020L, 0L);
            }
            case 78: {
                return this.m(0x1008000L, 0L);
            }
            case 0x4F: {
                return this.m(0x20000000000000L, 0L);
            }
            case 80: {
                return this.m(0x400000L, 0L);
            }
            case 82: {
                return this.m(0x800000000L, 0L);
            }
            case 83: {
                return this.m(0xC3010000057000L, 0L);
            }
            case 84: {
                return this.m(0xC580000000L, 0L);
            }
            case 85: {
                return this.m(0x800000L, 0L);
            }
            case 86: {
                return this.m(0x40000000000L, 0L);
            }
            case 102: {
                return this.m(0x400000000000000L, 0L);
            }
            case 110: {
                return this.m(0x100000000000000L, 0L);
            }
            case 0x74: {
                return this.m(0x200000000000000L, 0L);
            }
            default: {
                return this.e(0, 0);
            }
        }
    }

    private final int f(int v, long v1, long v2) {
        return this.d(this.e(v, v1, v2), v + 1);
    }

    private int f(long v, long v1) {
        long v2 = v1 & v;
        if(v2 == 0L) {
            return this.d(11, 0L, v);
        }
        try {
            this.m = this.l.c();
            return this.m == 'n' ? this.g(v2, 1L) : this.d(12, 0L, v2);
        }
        catch(IOException unused_ex) {
            return 13;
        }
    }

    private int f(long v, long v1, long v2, long v3) {
        long v4 = v1 & v;
        long v5 = v3 & v2;
        if((v4 | v5) == 0L) {
            return this.b(5, v, v2);
        }
        try {
            this.m = this.l.c();
            switch(this.m) {
                case 69: {
                    goto label_9;
                }
                case 76: {
                    goto label_14;
                }
                case 80: {
                    goto label_23;
                }
                case 88: {
                    return this.g(v4, 0x80000000000000L, v5, 0L);
                }
                case 97: {
                    return this.g(v4, 0L, v5, 6L);
                }
                case 99: {
                    return this.g(v4, 0L, v5, 0x88L);
                }
                case 102: {
                    return this.g(v4, 0x8000000000000000L, v5, 0L);
                }
                case 110: {
                    return this.g(v4, 0L, v5, 1L);
                }
            }
        }
        catch(IOException unused_ex) {
            return 7;
        }
        return this.b(6, v4, v5);
    label_9:
        if((0x800L & v4) != 0L) {
            return this.a(7, 11);
        }
        if((0x4000L & v4) != 0L) {
            return this.a(7, 14);
        }
        return (0x8000L & v4) == 0L ? this.b(6, v4, v5) : this.a(7, 15);
    label_14:
        if((0x80L & v4) != 0L) {
            return this.a(7, 7);
        }
        if((0x200L & v4) != 0L) {
            return this.a(7, 9);
        }
        if((0x2000L & v4) != 0L) {
            return this.a(7, 13);
        }
        if((0x400000000L & v4) != 0L) {
            return this.a(7, 34);
        }
        return (0x4000000000L & v4) == 0L ? this.b(6, v4, v5) : this.a(7, 38);
    label_23:
        if((0x400L & v4) != 0L) {
            return this.a(7, 10);
        }
        if((0x1000L & v4) != 0L) {
            return this.a(7, 12);
        }
        return (0x8000000000L & v4) == 0L ? this.b(6, v4, v5) : this.a(7, 39);
    }

    private void f(int v, int v1) {
        while(true) {
            int v2 = this.p;
            this.p = v2 + 1;
            this.u[v2] = f.d[v];
            if(v == v1) {
                break;
            }
            ++v;
        }
    }

    private final int g(int v, long v1, long v2) {
        switch(v) {
            case 0: {
                if((0x7FFFFFFFFFFFFE0L & v1) != 0L) {
                    this.s = 61;
                    return 1;
                }
                if((14L & v1) != 0L) {
                    return 52;
                }
                return (0xC000000000000000L & v1) == 0L && (0xBFFL & v2) == 0L ? -1 : 30;
            }
            case 1: {
                if((0x20000072000000L & v1) == 0L) {
                    if((0x7DFFFFF8DFFFFE0L & v1) == 0L) {
                        return -1;
                    }
                    if(this.r != 1) {
                        this.s = 61;
                        this.r = 1;
                        return 1;
                    }
                }
                break;
            }
            case 2: {
                if((0x10340000BFE0000L & v1) == 0L) {
                    if((0x6DCBFFF8401FFE0L & v1) != 0L) {
                        this.s = 61;
                        this.r = 2;
                        return 1;
                    }
                    return -1;
                }
                break;
            }
            case 3: {
                if((0x200B80380010020L & v1) == 0L) {
                    if((0x4DC07FC0400FFC0L & v1) == 0L) {
                        return -1;
                    }
                    if(this.r != 3) {
                        this.s = 61;
                        this.r = 3;
                        return 1;
                    }
                }
                break;
            }
            case 4: {
                if((0x404000000000040L & v1) == 0L) {
                    if((0xC007FD0400FF80L & v1) == 0L) {
                        return -1;
                    }
                    if(this.r != 4) {
                        this.s = 61;
                        this.r = 4;
                        return 1;
                    }
                }
                break;
            }
            case 5: {
                if((0x40804000000L & v1) == 0L) {
                    if((0xC003F50000FF80L & v1) != 0L) {
                        this.s = 61;
                        this.r = 5;
                        return 1;
                    }
                    return -1;
                }
                break;
            }
            case 6: {
                if((0x8000C40000FE80L & v1) != 0L) {
                    this.s = 61;
                    this.r = 6;
                    return 1;
                }
                return (0x40033100000100L & v1) == 0L ? -1 : 1;
            }
            case 7: {
                if((0x80000000000000L & v1) != 0L) {
                    this.s = 61;
                    this.r = 7;
                    return 1;
                }
                return (0xC40000FE80L & v1) == 0L ? -1 : 1;
            }
            case 8: {
                return (0x80000000000000L & v1) == 0L ? -1 : 1;
            }
            default: {
                return -1;
            }
        }
        return 1;
    }

    private int g(long v, long v1) {
        long v2 = v1 & v;
        if(v2 == 0L) {
            return this.d(12, 0L, v);
        }
        try {
            this.m = this.l.c();
            return this.m == 'e' ? this.h(v2, 1L) : this.d(13, 0L, v2);
        }
        catch(IOException unused_ex) {
            return 14;
        }
    }

    private int g(long v, long v1, long v2, long v3) {
        long v4 = v1 & v;
        long v5 = v3 & v2;
        if((v4 | v5) == 0L) {
            return this.b(6, v, v2);
        }
        try {
            this.m = this.l.c();
            switch(this.m) {
                case 84: {
                    return (0x80000000000000L & v4) == 0L ? this.b(7, v4, v5) : this.a(8, 55);
                }
                case 97: {
                    return this.h(v4, 0L, v5, 0x80L);
                }
                case 101: {
                    return this.h(v4, 0L, v5, 1L);
                }
                case 105: {
                    return this.h(v4, 0x8000000000000000L, v5, 0L);
                }
                case 107: {
                    return this.h(v4, 0L, v5, 8L);
                }
                case 109: {
                    return this.h(v4, 0L, v5, 2L);
                }
                case 0x72: {
                    return this.h(v4, 0L, v5, 4L);
                }
            }
        }
        catch(IOException unused_ex) {
            return 8;
        }
        return this.b(7, v4, v5);
    }

    private void g() {
        this.q = 0x80000001;
        for(int v = 52; v > 0; --v) {
            this.t[v - 1] = 0x80000000;
        }
    }

    private void g(int v, int v1) {
        this.a(v);
        this.a(v1);
    }

    private final int h(int v, long v1, long v2) {
        return this.e(this.g(v, v1, v2), v + 1);
    }

    private int h(long v, long v1) {
        long v2 = v1 & v;
        if(v2 == 0L) {
            return this.d(13, 0L, v);
        }
        try {
            this.m = this.l.c();
        }
        catch(IOException unused_ex) {
            return 15;
        }
        if(this.m != 'd') {
            return this.d(14, 0L, v2);
        }
        return (1L & v2) == 0L ? this.d(14, 0L, v2) : this.a(15, 0x40);
    }

    private int h(long v, long v1, long v2, long v3) {
        long v4 = v1 & v;
        long v5 = v3 & v2;
        if((v4 | v5) == 0L) {
            return this.b(7, v, v2);
        }
        try {
            this.m = this.l.c();
            switch(this.m) {
                case 100: {
                    return this.i(v4, 0L, v5, 1L);
                }
                case 103: {
                    return (4L & v5) == 0L ? this.b(8, v4, v5) : this.a(9, 66);
                }
                case 108: {
                    return (0x80L & v5) == 0L ? this.b(8, v4, v5) : this.a(9, 71);
                }
                case 110: {
                    return this.i(v4, 0x8000000000000000L, v5, 0L);
                }
                case 0x73: {
                    return (2L & v5) == 0L ? this.i(v4, 0L, v5, 8L) : this.a(9, 65);
                }
            }
        }
        catch(IOException unused_ex) {
            return 9;
        }
        return this.b(8, v4, v5);
    }

    private void h(int v, int v1) {
        while(true) {
            this.a(f.d[v]);
            if(v == v1) {
                break;
            }
            ++v;
        }
    }

    private int i(long v, long v1) {
        try {
            this.m = this.l.c();
            switch(this.m) {
                case 46: {
                    return (0x800L & v1) == 0L ? this.f(0, v, v1) : this.a(1, 75);
                }
                case 65: {
                    return this.w(v, 0x240600000000L, v1, 0L);
                }
                case 68: {
                    return this.w(v, 0x80000020000L, v1, 0L);
                }
                case 69: {
                    goto label_8;
                }
                case 70: {
                    return this.w(v, 0xC000000000L, v1, 0L);
                }
                case 72: {
                    return this.w(v, 0x3000000000000L, v1, 0L);
                }
                case 73: {
                    return this.w(v, 0x100000L, v1, 0L);
                }
                case 75: {
                    return this.w(v, 0x80000000000000L, v1, 0L);
                }
                case 76: {
                    return this.w(v, 0x20000000000L, v1, 0L);
                }
                case 77: {
                    return this.w(v, 0x8000000L, v1, 0L);
                }
                case 78: {
                    return this.w(v, 0x100000800000L, v1, 0L);
                }
                case 0x4F: {
                    return this.w(v, 0x144030056001E0L, v1, 0L);
                }
                case 80: {
                    return (0x20000000000000L & v) == 0L ? this.f(0, v, v1) : this.a(1, 53);
                }
                case 81: {
                    return (0x10000000L & v) == 0L ? this.f(0, v, v1) : this.a(1, 28);
                }
                case 84: {
                    return (0x20000000L & v) == 0L ? this.f(0, v, v1) : this.a(1, 29);
                }
                case 85: {
                    return this.w(v, 0x80000000C0000L, v1, 0L);
                }
                case 88: {
                    return this.w(v, 0x800000000000L, v1, 0L);
                }
                case 97: {
                    return this.w(v, 0x400000000000000L, v1, 0L);
                }
                case 101: {
                    return this.w(v, 0L, v1, 640L);
                }
                case 102: {
                    return this.w(v, 0L, v1, 0x100L);
                }
                case 105: {
                    return this.w(v, 0x100000000000000L, v1, 4L);
                }
                case 108: {
                    return this.w(v, 0x8000000000000000L, v1, 97L);
                }
                case 109: {
                    return this.w(v, 0L, v1, 8L);
                }
                case 110: {
                    return this.w(v, 0L, v1, 2L);
                }
                case 0x72: {
                    return this.w(v, 0x200000000000000L, v1, 0L);
                }
                case 0x73: {
                    return this.w(v, 0x4000000000000000L, v1, 0L);
                }
                case 0x75: {
                    return this.w(v, 0L, v1, 16L);
                }
            }
        }
        catch(IOException unused_ex) {
            return 1;
        }
        return this.f(0, v, v1);
    label_8:
        if((0x40000000L & v) != 0L) {
            this.s = 30;
            this.r = 1;
        }
        return this.w(v, 0x4001098201FE00L, v1, 0L);
    }

    private int i(long v, long v1, long v2, long v3) {
        long v4 = v1 & v;
        long v5 = v3 & v2;
        if((v4 | v5) == 0L) {
            return this.b(8, v, v2);
        }
        try {
            this.m = this.l.c();
            switch(this.m) {
                case 101: {
                    return this.j(v4, 0x8000000000000000L, v5, 1L);
                }
                case 105: {
                    return this.j(v4, 0L, v5, 8L);
                }
            }
        }
        catch(IOException unused_ex) {
            return 10;
        }
        return this.b(9, v4, v5);
    }

    private int j(long v, long v1) {
        long v2 = v1 & v;
        if(v2 == 0L) {
            return this.f(11, 0L, v);
        }
        try {
            this.m = this.l.c();
            return this.m == 'n' ? this.k(v2, 1L) : this.f(12, 0L, v2);
        }
        catch(IOException unused_ex) {
            return 13;
        }
    }

    private int j(long v, long v1, long v2, long v3) {
        long v4 = v1 & v;
        long v5 = v3 & v2;
        if((v4 | v5) == 0L) {
            return this.b(9, v, v2);
        }
        try {
            this.m = this.l.c();
            switch(this.m) {
                case 100: {
                    return (0x8000000000000000L & v4) == 0L ? this.b(10, v4, v5) : this.a(11, 0x3F);
                }
                case 102: {
                    return this.k(v4, 0L, v5, 1L);
                }
                case 0x7A: {
                    return this.k(v4, 0L, v5, 8L);
                }
            }
        }
        catch(IOException unused_ex) {
            return 11;
        }
        return this.b(10, v4, v5);
    }

    private int k(long v, long v1) {
        long v2 = v1 & v;
        if(v2 == 0L) {
            return this.f(12, 0L, v);
        }
        try {
            this.m = this.l.c();
            return this.m == 'e' ? this.l(v2, 1L) : this.f(13, 0L, v2);
        }
        catch(IOException unused_ex) {
            return 14;
        }
    }

    private int k(long v, long v1, long v2, long v3) {
        long v4 = v3 & v2;
        if((v1 & v | v4) == 0L) {
            return this.b(10, v, v2);
        }
        try {
            this.m = this.l.c();
            switch(this.m) {
                case 101: {
                    return (8L & v4) == 0L ? this.b(11, 0L, v4) : this.a(12, 67);
                }
                case 105: {
                    return this.b(v4, 1L);
                }
            }
        }
        catch(IOException unused_ex) {
            return 12;
        }
        return this.b(11, 0L, v4);
    }

    private int l(long v, long v1) {
        long v2 = v1 & v;
        if(v2 == 0L) {
            return this.f(13, 0L, v);
        }
        try {
            this.m = this.l.c();
        }
        catch(IOException unused_ex) {
            return 15;
        }
        if(this.m != 'd') {
            return this.f(14, 0L, v2);
        }
        return (1L & v2) == 0L ? this.f(14, 0L, v2) : this.a(15, 0x40);
    }

    private int l(long v, long v1, long v2, long v3) {
        long v4 = v1 & v;
        long v5 = v3 & v2;
        if((v4 | v5) == 0L) {
            return this.d(0, v, v2);
        }
        try {
            this.m = this.l.c();
            switch(this.m) {
                case 65: {
                    return this.m(v4, 0x1C0L, v5, 0L);
                }
                case 66: {
                    return (0x40000L & v4) == 0L ? this.d(1, v4, v5) : this.a(2, 18);
                }
                case 68: {
                    goto label_11;
                }
                case 73: {
                    return this.m(v4, 0x80080400000000L, v5, 0L);
                }
                case 76: {
                    goto label_15;
                }
                case 77: {
                    return (0x800000L & v4) == 0L ? this.d(1, v4, v5) : this.a(2, 23);
                }
                case 78: {
                    return (0x2000000L & v4) == 0L ? this.m(v4, 0xC200004000000L, v5, 0L) : this.a(2, 25);
                }
                case 0x4F: {
                    return this.m(v4, 0x92C000000000L, v5, 0L);
                }
                case 80: {
                    return (0x8000000L & v4) == 0L ? this.d(1, v4, v5) : this.a(2, 27);
                }
                case 82: {
                    goto label_22;
                }
                case 83: {
                    return this.m(v4, 0x180000000L, v5, 0L);
                }
                case 84: {
                    return (0x1000000L & v4) == 0L ? this.m(v4, 0x50010800007E00L, v5, 0L) : this.a(2, 24);
                }
                case 86: {
                    return (0x100000L & v4) == 0L ? this.m(v4, 0x20L, v5, 0L) : this.a(2, 20);
                }
                case 87: {
                    return (0x400000L & v4) == 0L ? this.m(v4, 0x8000L, v5, 0L) : this.a(2, 22);
                }
                case 97: {
                    return this.m(v4, 0L, v5, 9L);
                }
                case 105: {
                    return this.m(v4, 0x8000000000000000L, v5, 0x20L);
                }
                case 108: {
                    return (0x100000000000000L & v4) == 0L ? this.m(v4, 0x400000000000000L, v5, 0L) : this.a(2, 56);
                }
                case 110: {
                    return this.m(v4, 0L, v5, 640L);
                }
                case 0x6F: {
                    return this.m(v4, 0x4000000000000000L, v5, 0x40L);
                }
                case 0x70: {
                    return this.m(v4, 0L, v5, 16L);
                }
                case 0x73: {
                    return this.m(v4, 0L, v5, 4L);
                }
                case 0x75: {
                    return this.m(v4, 0x200000000000000L, v5, 0x102L);
                }
            }
        }
        catch(IOException unused_ex) {
            return 2;
        }
        return this.d(1, v4, v5);
    label_11:
        if((0x20000L & v4) != 0L) {
            return this.a(2, 17);
        }
        return (0x200000L & v4) == 0L ? this.d(1, v4, v5) : this.a(2, 21);
    label_15:
        if((0x80000L & v4) != 0L) {
            return this.a(2, 19);
        }
        return (0x1000000000000L & v4) == 0L ? this.m(v4, 0x200010000L, v5, 0L) : this.a(2, 0x30);
    label_22:
        if((0x400000000000L & v4) != 0L) {
            return this.a(2, 46);
        }
        return (0x2000000000000L & v4) == 0L ? this.m(v4, 0x43000000000L, v5, 0L) : this.a(2, 49);
    }

    private int m(long v, long v1) {
        try {
            this.m = this.l.c();
            switch(this.m) {
                case 46: {
                    return (0x800L & v1) == 0L ? this.h(0, v, v1) : this.a(1, 75);
                }
                case 65: {
                    return this.H(v, 0x240600000000L, v1, 0L);
                }
                case 68: {
                    return this.H(v, 0x80000020000L, v1, 0L);
                }
                case 69: {
                    goto label_9;
                }
                case 70: {
                    return this.H(v, 0xC000000000L, v1, 0L);
                }
                case 72: {
                    return this.H(v, 0x3000000000000L, v1, 0L);
                }
                case 73: {
                    return this.H(v, 0x100000L, v1, 0L);
                }
                case 75: {
                    return this.H(v, 0x80000000000000L, v1, 0L);
                }
                case 76: {
                    return this.H(v, 0x20000000000L, v1, 0L);
                }
                case 77: {
                    return this.H(v, 0x8000000L, v1, 0L);
                }
                case 78: {
                    return this.H(v, 0x100000800000L, v1, 0L);
                }
                case 0x4F: {
                    return this.H(v, 0x144030056001E0L, v1, 0L);
                }
                case 80: {
                    return (0x20000000000000L & v) == 0L ? this.h(0, v, v1) : this.d(1, 53, 1);
                }
                case 81: {
                    return (0x10000000L & v) == 0L ? this.h(0, v, v1) : this.d(1, 28, 1);
                }
                case 84: {
                    return (0x20000000L & v) == 0L ? this.h(0, v, v1) : this.d(1, 29, 1);
                }
                case 85: {
                    return this.H(v, 0x80000000C0000L, v1, 0L);
                }
                case 88: {
                    return this.H(v, 0x800000000000L, v1, 0L);
                }
                case 97: {
                    return this.H(v, 0x400000000000000L, v1, 0L);
                }
                case 101: {
                    return this.H(v, 0L, v1, 640L);
                }
                case 102: {
                    return this.H(v, 0L, v1, 0x100L);
                }
                case 105: {
                    return this.H(v, 0x100000000000000L, v1, 4L);
                }
                case 108: {
                    return this.H(v, 0x8000000000000000L, v1, 97L);
                }
                case 109: {
                    return this.H(v, 0L, v1, 8L);
                }
                case 110: {
                    return this.H(v, 0L, v1, 2L);
                }
                case 0x72: {
                    return this.H(v, 0x200000000000000L, v1, 0L);
                }
                case 0x73: {
                    return this.H(v, 0x4000000000000000L, v1, 0L);
                }
                case 0x75: {
                    return this.H(v, 0L, v1, 16L);
                }
            }
        }
        catch(IOException unused_ex) {
            this.g(0, v, v1);
            return 1;
        }
        return this.h(0, v, v1);
    label_9:
        if((0x40000000L & v) != 0L) {
            this.s = 30;
            this.r = 1;
        }
        return this.H(v, 0x4001098201FE00L, v1, 0L);
    }

    private int m(long v, long v1, long v2, long v3) {
        long v4 = v1 & v;
        long v5 = v3 & v2;
        if((v4 | v5) == 0L) {
            return this.d(1, v, v2);
        }
        try {
            this.m = this.l.c();
            switch(this.m) {
                case 65: {
                    return this.n(v4, 0x40000000000L, v5, 0L);
                }
                case 67: {
                    return this.n(v4, 0x8000004000000L, v5, 0L);
                }
                case 68: {
                    return (0x200000000000L & v4) == 0L ? this.n(v4, 0x1C0L, v5, 0L) : this.a(3, 45);
                }
                case 69: {
                    return (0x20L & v4) == 0L ? this.d(2, v4, v5) : this.a(3, 5);
                }
                case 70: {
                    return (0x10000L & v4) == 0L ? this.d(2, v4, v5) : this.a(3, 16);
                }
                case 76: {
                    return (0x200000000L & v4) == 0L ? this.n(v4, 0x11400000000L, v5, 0L) : this.a(3, 33);
                }
                case 0x4F: {
                    return this.n(v4, 0x10000000000000L, v5, 0L);
                }
                case 80: {
                    return this.n(v4, 0x80002000000000L, v5, 0L);
                }
                case 82: {
                    return (0x800000000000L & v4) == 0L ? this.n(v4, 0xC000000000L, v5, 0L) : this.a(3, 0x2F);
                }
                case 83: {
                    return this.n(v4, 0x4020000000000L, v5, 0L);
                }
                case 84: {
                    goto label_19;
                }
                case 85: {
                    return this.n(v4, 0x800002200L, v5, 0L);
                }
                case 86: {
                    return (0x80000000000L & v4) == 0L ? this.d(2, v4, v5) : this.a(3, 43);
                }
                case 0x5F: {
                    return this.n(v4, 0x40000000000000L, v5, 4L);
                }
                case 99: {
                    return this.n(v4, 0L, v5, 0x40L);
                }
                case 100: {
                    goto label_28;
                }
                case 101: {
                    return (0x200000000000000L & v4) == 0L ? this.d(2, v4, v5) : this.a(3, 57);
                }
                case 109: {
                    return this.n(v4, 0L, v5, 2L);
                }
                case 110: {
                    return this.n(v4, 0x8000000000000000L, v5, 0x120L);
                }
                case 0x73: {
                    return this.n(v4, 0x400000000000000L, v5, 1L);
                }
                case 0x75: {
                    return this.n(v4, 0x4000000000000000L, v5, 0L);
                }
                case 0x76: {
                    return this.n(v4, 0L, v5, 16L);
                }
                case 120: {
                    return this.n(v4, 0L, v5, 8L);
                }
            }
        }
        catch(IOException unused_ex) {
            return 3;
        }
        return this.d(2, v4, v5);
    label_19:
        if((0x80000000L & v4) != 0L) {
            this.s = 0x1F;
            this.r = 3;
            return this.n(v4, 0x10000DC00L, v5, 0L);
        }
        return (0x100000000000L & v4) == 0L ? this.n(v4, 0x10000DC00L, v5, 0L) : this.a(3, 44);
    label_28:
        if((0x200L & v5) != 0L) {
            this.s = 73;
            this.r = 3;
        }
        return this.n(v4, 0L, v5, 0x80L);
    }

    private int n(long v, long v1) {
        long v2 = v1 & v;
        if(v2 == 0L) {
            return this.h(11, 0L, v);
        }
        try {
            this.m = this.l.c();
            return this.m == 'n' ? this.o(v2, 1L) : this.h(12, 0L, v2);
        }
        catch(IOException unused_ex) {
            this.g(12, 0L, v2);
            return 13;
        }
    }

    private int n(long v, long v1, long v2, long v3) {
        long v4 = v1 & v;
        long v5 = v3 & v2;
        if((v4 | v5) == 0L) {
            return this.d(2, v, v2);
        }
        try {
            this.m = this.l.c();
            switch(this.m) {
                case 0x20: {
                    return this.o(v4, 0L, v5, 0x80L);
                }
                case 65: {
                    return this.o(v4, 0x400DC00L, v5, 0L);
                }
                case 66: {
                    return this.o(v4, 0x80L, v5, 0L);
                }
                case 67: {
                    return this.o(v4, 0x4400000000L, v5, 0L);
                }
                case 73: {
                    return this.o(v4, 0x10000000000L, v5, 0L);
                }
                case 75: {
                    return (0x40L & v4) == 0L ? this.d(3, v4, v5) : this.a(4, 6);
                }
                case 76: {
                    return this.o(v4, 0x8000000000L, v5, 0L);
                }
                case 78: {
                    return this.o(v4, 0x100L, v5, 0L);
                }
                case 0x4F: {
                    return this.o(v4, 0x1000000000L, v5, 0L);
                }
                case 80: {
                    return this.o(v4, 0x2200L, v5, 0L);
                }
                case 82: {
                    return this.o(v4, 0x42800000000L, v5, 0L);
                }
                case 83: {
                    return this.o(v4, 0x100000000L, v5, 0L);
                }
                case 84: {
                    return (0x4000000000000L & v4) == 0L ? this.o(v4, 0x40000000000000L, v5, 0L) : this.a(4, 50);
                }
                case 85: {
                    return this.o(v4, 0x20000000000L, v5, 0L);
                }
                case 91: {
                    goto label_23;
                }
                case 0x5F: {
                    return this.o(v4, 0x80000000000000L, v5, 0L);
                }
                case 97: {
                    return this.o(v4, 0L, v5, 80L);
                }
                case 99: {
                    return (0x100L & v5) == 0L ? this.d(3, v4, v5) : this.a(4, 72);
                }
                case 101: {
                    goto label_29;
                }
                case 0x70: {
                    return this.o(v4, 0L, v5, 2L);
                }
                case 0x72: {
                    return this.o(v4, 0x4000000000000000L, v5, 0L);
                }
                case 0x73: {
                    return this.o(v4, 0L, v5, 8L);
                }
                case 0x74: {
                    return this.o(v4, 0L, v5, 1L);
                }
                case 0x76: {
                    return this.o(v4, 0L, v5, 4L);
                }
            }
        }
        catch(IOException unused_ex) {
            return 4;
        }
        return this.d(3, v4, v5);
    label_23:
        if((0x8000000000000L & v4) != 0L) {
            return this.a(4, 51);
        }
        return (0x10000000000000L & v4) == 0L ? this.d(3, v4, v5) : this.a(4, 52);
    label_29:
        if((0x400000000000000L & v4) != 0L) {
            return this.a(4, 58);
        }
        if((0x20L & v5) != 0L) {
            this.s = 69;
            this.r = 4;
        }
        return this.o(v4, 0x8000000000000000L, v5, 0L);
    }

    private int o(long v, long v1) {
        long v2 = v1 & v;
        if(v2 == 0L) {
            return this.h(12, 0L, v);
        }
        try {
            this.m = this.l.c();
            return this.m == 'e' ? this.p(v2, 1L) : this.h(13, 0L, v2);
        }
        catch(IOException unused_ex) {
            this.g(13, 0L, v2);
            return 14;
        }
    }

    private int o(long v, long v1, long v2, long v3) {
        long v4 = v1 & v;
        long v5 = v3 & v2;
        if((v4 | v5) == 0L) {
            return this.d(3, v, v2);
        }
        try {
            this.m = this.l.c();
            switch(this.m) {
                case 65: {
                    return this.p(v4, 0x4400000000L, v5, 0L);
                }
                case 66: {
                    return this.p(v4, 0xDC00L, v5, 0L);
                }
                case 69: {
                    return this.p(v4, 0x2100000000L, v5, 0L);
                }
                case 71: {
                    return (0x40000000000L & v4) == 0L ? this.d(4, v4, v5) : this.a(5, 42);
                }
                case 73: {
                    return this.p(v4, 0x100L, v5, 0L);
                }
                case 78: {
                    return (0x800000000L & v4) == 0L ? this.p(v4, 0x80000000000000L, v5, 0L) : this.a(5, 35);
                }
                case 0x4F: {
                    return this.p(v4, 0x40009000000080L, v5, 0L);
                }
                case 82: {
                    return this.p(v4, 0x20000000000L, v5, 0L);
                }
                case 83: {
                    return this.p(v4, 0x10000000000L, v5, 0L);
                }
                case 84: {
                    return (0x4000000L & v4) == 0L ? this.d(4, v4, v5) : this.a(5, 26);
                }
                case 86: {
                    return this.p(v4, 0x2200L, v5, 0L);
                }
                case 97: {
                    return this.p(v4, 0L, v5, 6L);
                }
                case 99: {
                    return this.p(v4, 0x4000000000000000L, v5, 0L);
                }
                case 100: {
                    return this.p(v4, 0x8000000000000000L, v5, 0L);
                }
                case 108: {
                    goto label_23;
                }
                case 0x74: {
                    return this.p(v4, 0L, v5, 8L);
                }
            }
        }
        catch(IOException unused_ex) {
            return 5;
        }
        return this.d(4, v4, v5);
    label_23:
        if((16L & v5) != 0L) {
            return this.a(5, 68);
        }
        return (0x40L & v5) == 0L ? this.p(v4, 0L, v5, 0x81L) : this.a(5, 70);
    }

    private int p(long v, long v1) {
        long v2 = v1 & v;
        if(v2 == 0L) {
            return this.h(13, 0L, v);
        }
        try {
            this.m = this.l.c();
        }
        catch(IOException unused_ex) {
            this.g(14, 0L, v2);
            return 15;
        }
        if(this.m != 'd') {
            return this.h(14, 0L, v2);
        }
        return (1L & v2) == 0L ? this.h(14, 0L, v2) : this.a(15, 0x40);
    }

    private int p(long v, long v1, long v2, long v3) {
        long v4 = v1 & v;
        long v5 = v3 & v2;
        if((v4 | v5) == 0L) {
            return this.d(4, v, v2);
        }
        try {
            this.m = this.l.c();
            switch(this.m) {
                case 65: {
                    return this.q(v4, 0x2200L, v5, 0L);
                }
                case 69: {
                    return (0x20000000000L & v4) == 0L ? this.q(v4, 0x80000000000000L, v5, 0L) : this.a(6, 41);
                }
                case 76: {
                    return (0x100L & v4) == 0L ? this.q(v4, 0x440000C800L, v5, 0L) : this.a(6, 8);
                }
                case 0x4F: {
                    return this.q(v4, 0x8000000080L, v5, 0L);
                }
                case 80: {
                    goto label_13;
                }
                case 84: {
                    goto label_18;
                }
                case 85: {
                    return this.q(v4, 0x1400L, v5, 0L);
                }
                case 97: {
                    return this.q(v4, 0L, v5, 8L);
                }
                case 101: {
                    return (0x4000000000000000L & v4) == 0L ? this.q(v4, 0x8000000000000000L, v5, 0L) : this.a(6, 62);
                }
                case 105: {
                    return this.q(v4, 0L, v5, 1L);
                }
                case 0x6F: {
                    return this.q(v4, 0L, v5, 0x80L);
                }
                case 0x72: {
                    return this.q(v4, 0L, v5, 6L);
                }
            }
        }
        catch(IOException unused_ex) {
            return 6;
        }
        return this.d(5, v4, v5);
    label_13:
        if((0x1000000000L & v4) != 0L) {
            return this.a(6, 36);
        }
        if((0x2000000000L & v4) != 0L) {
            return this.a(6, 37);
        }
        return (0x40000000000000L & v4) == 0L ? this.d(5, v4, v5) : this.a(6, 54);
    label_18:
        if((0x100000000L & v4) != 0L) {
            return this.a(6, 0x20);
        }
        return (0x10000000000L & v4) == 0L ? this.d(5, v4, v5) : this.a(6, 40);
    }

    private int q(long v, long v1, long v2, long v3) {
        long v4 = v1 & v;
        long v5 = v3 & v2;
        if((v4 | v5) == 0L) {
            return this.d(5, v, v2);
        }
        try {
            this.m = this.l.c();
            switch(this.m) {
                case 69: {
                    goto label_9;
                }
                case 76: {
                    goto label_14;
                }
                case 80: {
                    goto label_23;
                }
                case 88: {
                    return this.r(v4, 0x80000000000000L, v5, 0L);
                }
                case 97: {
                    return this.r(v4, 0L, v5, 6L);
                }
                case 99: {
                    return this.r(v4, 0L, v5, 0x88L);
                }
                case 102: {
                    return this.r(v4, 0x8000000000000000L, v5, 0L);
                }
                case 110: {
                    return this.r(v4, 0L, v5, 1L);
                }
            }
        }
        catch(IOException unused_ex) {
            return 7;
        }
        return this.d(6, v4, v5);
    label_9:
        if((0x800L & v4) != 0L) {
            return this.a(7, 11);
        }
        if((0x4000L & v4) != 0L) {
            return this.a(7, 14);
        }
        return (0x8000L & v4) == 0L ? this.d(6, v4, v5) : this.a(7, 15);
    label_14:
        if((0x80L & v4) != 0L) {
            return this.a(7, 7);
        }
        if((0x200L & v4) != 0L) {
            return this.a(7, 9);
        }
        if((0x2000L & v4) != 0L) {
            return this.a(7, 13);
        }
        if((0x400000000L & v4) != 0L) {
            return this.a(7, 34);
        }
        return (0x4000000000L & v4) == 0L ? this.d(6, v4, v5) : this.a(7, 38);
    label_23:
        if((0x400L & v4) != 0L) {
            return this.a(7, 10);
        }
        if((0x1000L & v4) != 0L) {
            return this.a(7, 12);
        }
        return (0x8000000000L & v4) == 0L ? this.d(6, v4, v5) : this.a(7, 39);
    }

    private int r(long v, long v1, long v2, long v3) {
        long v4 = v1 & v;
        long v5 = v3 & v2;
        if((v4 | v5) == 0L) {
            return this.d(6, v, v2);
        }
        try {
            this.m = this.l.c();
            switch(this.m) {
                case 84: {
                    return (0x80000000000000L & v4) == 0L ? this.d(7, v4, v5) : this.a(8, 55);
                }
                case 97: {
                    return this.s(v4, 0L, v5, 0x80L);
                }
                case 101: {
                    return this.s(v4, 0L, v5, 1L);
                }
                case 105: {
                    return this.s(v4, 0x8000000000000000L, v5, 0L);
                }
                case 107: {
                    return this.s(v4, 0L, v5, 8L);
                }
                case 109: {
                    return this.s(v4, 0L, v5, 2L);
                }
                case 0x72: {
                    return this.s(v4, 0L, v5, 4L);
                }
            }
        }
        catch(IOException unused_ex) {
            return 8;
        }
        return this.d(7, v4, v5);
    }

    private int s(long v, long v1, long v2, long v3) {
        long v4 = v1 & v;
        long v5 = v3 & v2;
        if((v4 | v5) == 0L) {
            return this.d(7, v, v2);
        }
        try {
            this.m = this.l.c();
            switch(this.m) {
                case 100: {
                    return this.t(v4, 0L, v5, 1L);
                }
                case 103: {
                    return (4L & v5) == 0L ? this.d(8, v4, v5) : this.a(9, 66);
                }
                case 108: {
                    return (0x80L & v5) == 0L ? this.d(8, v4, v5) : this.a(9, 71);
                }
                case 110: {
                    return this.t(v4, 0x8000000000000000L, v5, 0L);
                }
                case 0x73: {
                    return (2L & v5) == 0L ? this.t(v4, 0L, v5, 8L) : this.a(9, 65);
                }
            }
        }
        catch(IOException unused_ex) {
            return 9;
        }
        return this.d(8, v4, v5);
    }

    private int t(long v, long v1, long v2, long v3) {
        long v4 = v1 & v;
        long v5 = v3 & v2;
        if((v4 | v5) == 0L) {
            return this.d(8, v, v2);
        }
        try {
            this.m = this.l.c();
            switch(this.m) {
                case 101: {
                    return this.u(v4, 0x8000000000000000L, v5, 1L);
                }
                case 105: {
                    return this.u(v4, 0L, v5, 8L);
                }
            }
        }
        catch(IOException unused_ex) {
            return 10;
        }
        return this.d(9, v4, v5);
    }

    private int u(long v, long v1, long v2, long v3) {
        long v4 = v1 & v;
        long v5 = v3 & v2;
        if((v4 | v5) == 0L) {
            return this.d(9, v, v2);
        }
        try {
            this.m = this.l.c();
            switch(this.m) {
                case 100: {
                    return (0x8000000000000000L & v4) == 0L ? this.d(10, v4, v5) : this.a(11, 0x3F);
                }
                case 102: {
                    return this.v(v4, 0L, v5, 1L);
                }
                case 0x7A: {
                    return this.v(v4, 0L, v5, 8L);
                }
            }
        }
        catch(IOException unused_ex) {
            return 11;
        }
        return this.d(10, v4, v5);
    }

    private int v(long v, long v1, long v2, long v3) {
        long v4 = v3 & v2;
        if((v1 & v | v4) == 0L) {
            return this.d(10, v, v2);
        }
        try {
            this.m = this.l.c();
            switch(this.m) {
                case 101: {
                    return (8L & v4) == 0L ? this.d(11, 0L, v4) : this.a(12, 67);
                }
                case 105: {
                    return this.f(v4, 1L);
                }
            }
        }
        catch(IOException unused_ex) {
            return 12;
        }
        return this.d(11, 0L, v4);
    }

    private int w(long v, long v1, long v2, long v3) {
        long v4 = v1 & v;
        long v5 = v3 & v2;
        if((v4 | v5) == 0L) {
            return this.f(0, v, v2);
        }
        try {
            this.m = this.l.c();
            switch(this.m) {
                case 65: {
                    return this.x(v4, 0x1C0L, v5, 0L);
                }
                case 66: {
                    return (0x40000L & v4) == 0L ? this.f(1, v4, v5) : this.a(2, 18);
                }
                case 68: {
                    goto label_11;
                }
                case 73: {
                    return this.x(v4, 0x80080400000000L, v5, 0L);
                }
                case 76: {
                    goto label_15;
                }
                case 77: {
                    return (0x800000L & v4) == 0L ? this.f(1, v4, v5) : this.a(2, 23);
                }
                case 78: {
                    return (0x2000000L & v4) == 0L ? this.x(v4, 0xC200004000000L, v5, 0L) : this.a(2, 25);
                }
                case 0x4F: {
                    return this.x(v4, 0x92C000000000L, v5, 0L);
                }
                case 80: {
                    return (0x8000000L & v4) == 0L ? this.f(1, v4, v5) : this.a(2, 27);
                }
                case 82: {
                    goto label_22;
                }
                case 83: {
                    return this.x(v4, 0x180000000L, v5, 0L);
                }
                case 84: {
                    return (0x1000000L & v4) == 0L ? this.x(v4, 0x50010800007E00L, v5, 0L) : this.a(2, 24);
                }
                case 86: {
                    return (0x100000L & v4) == 0L ? this.x(v4, 0x20L, v5, 0L) : this.a(2, 20);
                }
                case 87: {
                    return (0x400000L & v4) == 0L ? this.x(v4, 0x8000L, v5, 0L) : this.a(2, 22);
                }
                case 97: {
                    return this.x(v4, 0L, v5, 9L);
                }
                case 105: {
                    return this.x(v4, 0x8000000000000000L, v5, 0x20L);
                }
                case 108: {
                    return (0x100000000000000L & v4) == 0L ? this.x(v4, 0x400000000000000L, v5, 0L) : this.a(2, 56);
                }
                case 110: {
                    return this.x(v4, 0L, v5, 640L);
                }
                case 0x6F: {
                    return this.x(v4, 0x4000000000000000L, v5, 0x40L);
                }
                case 0x70: {
                    return this.x(v4, 0L, v5, 16L);
                }
                case 0x73: {
                    return this.x(v4, 0L, v5, 4L);
                }
                case 0x75: {
                    return this.x(v4, 0x200000000000000L, v5, 0x102L);
                }
            }
        }
        catch(IOException unused_ex) {
            return 2;
        }
        return this.f(1, v4, v5);
    label_11:
        if((0x20000L & v4) != 0L) {
            return this.a(2, 17);
        }
        return (0x200000L & v4) == 0L ? this.f(1, v4, v5) : this.a(2, 21);
    label_15:
        if((0x80000L & v4) != 0L) {
            return this.a(2, 19);
        }
        return (0x1000000000000L & v4) == 0L ? this.x(v4, 0x200010000L, v5, 0L) : this.a(2, 0x30);
    label_22:
        if((0x400000000000L & v4) != 0L) {
            return this.a(2, 46);
        }
        return (0x2000000000000L & v4) == 0L ? this.x(v4, 0x43000000000L, v5, 0L) : this.a(2, 49);
    }

    private int x(long v, long v1, long v2, long v3) {
        long v4 = v1 & v;
        long v5 = v3 & v2;
        if((v4 | v5) == 0L) {
            return this.f(1, v, v2);
        }
        try {
            this.m = this.l.c();
            switch(this.m) {
                case 65: {
                    return this.y(v4, 0x40000000000L, v5, 0L);
                }
                case 67: {
                    return this.y(v4, 0x8000004000000L, v5, 0L);
                }
                case 68: {
                    return (0x200000000000L & v4) == 0L ? this.y(v4, 0x1C0L, v5, 0L) : this.a(3, 45);
                }
                case 69: {
                    return (0x20L & v4) == 0L ? this.f(2, v4, v5) : this.a(3, 5);
                }
                case 70: {
                    return (0x10000L & v4) == 0L ? this.f(2, v4, v5) : this.a(3, 16);
                }
                case 76: {
                    return (0x200000000L & v4) == 0L ? this.y(v4, 0x11400000000L, v5, 0L) : this.a(3, 33);
                }
                case 0x4F: {
                    return this.y(v4, 0x10000000000000L, v5, 0L);
                }
                case 80: {
                    return this.y(v4, 0x80002000000000L, v5, 0L);
                }
                case 82: {
                    return (0x800000000000L & v4) == 0L ? this.y(v4, 0xC000000000L, v5, 0L) : this.a(3, 0x2F);
                }
                case 83: {
                    return this.y(v4, 0x4020000000000L, v5, 0L);
                }
                case 84: {
                    goto label_19;
                }
                case 85: {
                    return this.y(v4, 0x800002200L, v5, 0L);
                }
                case 86: {
                    return (0x80000000000L & v4) == 0L ? this.f(2, v4, v5) : this.a(3, 43);
                }
                case 0x5F: {
                    return this.y(v4, 0x40000000000000L, v5, 4L);
                }
                case 99: {
                    return this.y(v4, 0L, v5, 0x40L);
                }
                case 100: {
                    goto label_28;
                }
                case 101: {
                    return (0x200000000000000L & v4) == 0L ? this.f(2, v4, v5) : this.a(3, 57);
                }
                case 109: {
                    return this.y(v4, 0L, v5, 2L);
                }
                case 110: {
                    return this.y(v4, 0x8000000000000000L, v5, 0x120L);
                }
                case 0x73: {
                    return this.y(v4, 0x400000000000000L, v5, 1L);
                }
                case 0x75: {
                    return this.y(v4, 0x4000000000000000L, v5, 0L);
                }
                case 0x76: {
                    return this.y(v4, 0L, v5, 16L);
                }
                case 120: {
                    return this.y(v4, 0L, v5, 8L);
                }
            }
        }
        catch(IOException unused_ex) {
            return 3;
        }
        return this.f(2, v4, v5);
    label_19:
        if((0x80000000L & v4) != 0L) {
            this.s = 0x1F;
            this.r = 3;
            return this.y(v4, 0x10000DC00L, v5, 0L);
        }
        return (0x100000000000L & v4) == 0L ? this.y(v4, 0x10000DC00L, v5, 0L) : this.a(3, 44);
    label_28:
        if((0x200L & v5) != 0L) {
            this.s = 73;
            this.r = 3;
        }
        return this.y(v4, 0L, v5, 0x80L);
    }

    private int y(long v, long v1, long v2, long v3) {
        long v4 = v1 & v;
        long v5 = v3 & v2;
        if((v4 | v5) == 0L) {
            return this.f(2, v, v2);
        }
        try {
            this.m = this.l.c();
            switch(this.m) {
                case 0x20: {
                    return this.z(v4, 0L, v5, 0x80L);
                }
                case 65: {
                    return this.z(v4, 0x400DC00L, v5, 0L);
                }
                case 66: {
                    return this.z(v4, 0x80L, v5, 0L);
                }
                case 67: {
                    return this.z(v4, 0x4400000000L, v5, 0L);
                }
                case 73: {
                    return this.z(v4, 0x10000000000L, v5, 0L);
                }
                case 75: {
                    return (0x40L & v4) == 0L ? this.f(3, v4, v5) : this.a(4, 6);
                }
                case 76: {
                    return this.z(v4, 0x8000000000L, v5, 0L);
                }
                case 78: {
                    return this.z(v4, 0x100L, v5, 0L);
                }
                case 0x4F: {
                    return this.z(v4, 0x1000000000L, v5, 0L);
                }
                case 80: {
                    return this.z(v4, 0x2200L, v5, 0L);
                }
                case 82: {
                    return this.z(v4, 0x42800000000L, v5, 0L);
                }
                case 83: {
                    return this.z(v4, 0x100000000L, v5, 0L);
                }
                case 84: {
                    return (0x4000000000000L & v4) == 0L ? this.z(v4, 0x40000000000000L, v5, 0L) : this.a(4, 50);
                }
                case 85: {
                    return this.z(v4, 0x20000000000L, v5, 0L);
                }
                case 91: {
                    goto label_23;
                }
                case 0x5F: {
                    return this.z(v4, 0x80000000000000L, v5, 0L);
                }
                case 97: {
                    return this.z(v4, 0L, v5, 80L);
                }
                case 99: {
                    return (0x100L & v5) == 0L ? this.f(3, v4, v5) : this.a(4, 72);
                }
                case 101: {
                    goto label_29;
                }
                case 0x70: {
                    return this.z(v4, 0L, v5, 2L);
                }
                case 0x72: {
                    return this.z(v4, 0x4000000000000000L, v5, 0L);
                }
                case 0x73: {
                    return this.z(v4, 0L, v5, 8L);
                }
                case 0x74: {
                    return this.z(v4, 0L, v5, 1L);
                }
                case 0x76: {
                    return this.z(v4, 0L, v5, 4L);
                }
            }
        }
        catch(IOException unused_ex) {
            return 4;
        }
        return this.f(3, v4, v5);
    label_23:
        if((0x8000000000000L & v4) != 0L) {
            return this.a(4, 51);
        }
        return (0x10000000000000L & v4) == 0L ? this.f(3, v4, v5) : this.a(4, 52);
    label_29:
        if((0x400000000000000L & v4) != 0L) {
            return this.a(4, 58);
        }
        if((0x20L & v5) != 0L) {
            this.s = 69;
            this.r = 4;
        }
        return this.z(v4, 0x8000000000000000L, v5, 0L);
    }

    private int z(long v, long v1, long v2, long v3) {
        long v4 = v1 & v;
        long v5 = v3 & v2;
        if((v4 | v5) == 0L) {
            return this.f(3, v, v2);
        }
        try {
            this.m = this.l.c();
            switch(this.m) {
                case 65: {
                    return this.A(v4, 0x4400000000L, v5, 0L);
                }
                case 66: {
                    return this.A(v4, 0xDC00L, v5, 0L);
                }
                case 69: {
                    return this.A(v4, 0x2100000000L, v5, 0L);
                }
                case 71: {
                    return (0x40000000000L & v4) == 0L ? this.f(4, v4, v5) : this.a(5, 42);
                }
                case 73: {
                    return this.A(v4, 0x100L, v5, 0L);
                }
                case 78: {
                    return (0x800000000L & v4) == 0L ? this.A(v4, 0x80000000000000L, v5, 0L) : this.a(5, 35);
                }
                case 0x4F: {
                    return this.A(v4, 0x40009000000080L, v5, 0L);
                }
                case 82: {
                    return this.A(v4, 0x20000000000L, v5, 0L);
                }
                case 83: {
                    return this.A(v4, 0x10000000000L, v5, 0L);
                }
                case 84: {
                    return (0x4000000L & v4) == 0L ? this.f(4, v4, v5) : this.a(5, 26);
                }
                case 86: {
                    return this.A(v4, 0x2200L, v5, 0L);
                }
                case 97: {
                    return this.A(v4, 0L, v5, 6L);
                }
                case 99: {
                    return this.A(v4, 0x4000000000000000L, v5, 0L);
                }
                case 100: {
                    return this.A(v4, 0x8000000000000000L, v5, 0L);
                }
                case 108: {
                    goto label_23;
                }
                case 0x74: {
                    return this.A(v4, 0L, v5, 8L);
                }
            }
        }
        catch(IOException unused_ex) {
            return 5;
        }
        return this.f(4, v4, v5);
    label_23:
        if((16L & v5) != 0L) {
            return this.a(5, 68);
        }
        return (0x40L & v5) == 0L ? this.A(v4, 0L, v5, 0x81L) : this.a(5, 70);
    }
}

