package android.ext;

import java.util.Locale;

public class ai {
    static final String[] a;
    static final String[] b;
    static final String[] c;
    static final String[] d;
    am e;
    static final ao f;
    private int g;
    private int h;

    static {
        ai.a = new String[]{"EQ", "NE", "CS", "CC", "MI", "PL", "VS", "VC", "HI", "LS", "GE", "LT", "GT", "LE", "AL", "<UND>", ""};
        ai.b = new String[]{"R0", "R1", "R2", "R3", "R4", "R5", "R6", "R7", "R8", "R9", "R10", "R11", "R12", "SP", "LR", "PC"};
        ai.c = new String[]{"0.0", "1.0", "2.0", "3.0", "4.0", "5.0", "0.5", "10.0"};
        ai.d = new String[]{"LSL", "LSR", "ASR", "ROR"};
        ai.f = new ao();
    }

    static final char a(String s, int v, int v1) {
        return v1 >= v ? '\u0000' : s.charAt(v1);
    }

    static int a(int v, am am0, boolean z) {
        int v1 = am0.a(ai.b);
        if(v1 == -1) {
            throw ai.f;
        }
        int v2 = v1 | v;
        if(am0.b(", ")) {
            if(am0.b("RRX")) {
                return v2 | 0x60;
            }
            if(z) {
                int v3 = am0.a(ai.d);
                if(v3 == -1) {
                    throw ai.f;
                }
                v2 |= v3 << 5;
                if(!am0.a(' ')) {
                    throw ai.f;
                }
            }
            if(am0.a('#')) {
                int v4 = (int)am0.f();
                if(v4 < 0 || v4 > 0x20) {
                    throw ai.f;
                }
                if(v4 == 0x20) {
                    v4 = 0;
                }
                return v2 | v4 << 7;
            }
            int v5 = am0.a(ai.b);
            if(v5 == -1) {
                throw ai.f;
            }
            return v2 | 16 | v5 << 8;
        }
        return v2;
    }

    public static int a(ai ai0, long v, String s) {
        if(ai0 == null) {
            ai0 = new ai();
        }
        int v1 = aj.a(ai0, v, s, -1);
        if(v1 == -1) {
            String s1 = ai.a(ai0, v, ((long)ai0.e.e)).trim();
            ak ak0 = new ak(Tools.a(qk.a(0x7F07034A), new Object[]{"ARM"}).trim() + "\n\'" + s + "\'\n\n" + Tools.a(qk.a(0x7F07034B), new Object[]{"\n\'" + s1 + "\'\n"}).trim());  // string:asm_failed "Failed to recognize __s__ opcode:"
            int v2 = s1.indexOf(59);
            if(v2 != -1) {
                s1 = s1.substring(0, v2).trim();
            }
            ak0.a = s1;
            ak0.b = s;
            throw ak0;
        }
        return v1;
    }

    static int a(am am0) {
        if(am0.b("CPSR")) {
            return 15;
        }
        if(am0.b("R8_USR")) {
            return 0x20;
        }
        if(am0.b("R9_USR")) {
            return 33;
        }
        if(am0.b("R10_USR")) {
            return 34;
        }
        if(am0.b("R11_USR")) {
            return 35;
        }
        if(am0.b("R12_USR")) {
            return 36;
        }
        if(am0.b("SP_USR")) {
            return 37;
        }
        if(am0.b("LR_USR")) {
            return 38;
        }
        if(am0.b("R8_FIQ")) {
            return 40;
        }
        if(!am0.b("R9_FIQ")) {
            if(am0.b("R10_FIQ")) {
                return 42;
            }
            if(am0.b("R11_FIQ")) {
                return 43;
            }
            if(am0.b("R12_FIQ")) {
                return 44;
            }
            if(am0.b("SP_FIQ")) {
                return 45;
            }
            if(am0.b("LR_FIQ")) {
                return 46;
            }
            if(am0.b("LR_IRQ")) {
                return 0x30;
            }
            if(am0.b("SP_IRQ")) {
                return 49;
            }
            if(am0.b("LR_SVC")) {
                return 50;
            }
            if(am0.b("SP_SVC")) {
                return 51;
            }
            if(am0.b("LR_ABT")) {
                return 52;
            }
            if(am0.b("SP_ABT")) {
                return 53;
            }
            if(am0.b("LR_UND")) {
                return 54;
            }
            if(am0.b("SP_UND")) {
                return 55;
            }
            if(am0.b("LR_MON")) {
                return 60;
            }
            if(am0.b("SP_MON")) {
                return 61;
            }
            if(am0.b("ELR_HYP")) {
                return 62;
            }
            if(am0.b("SP_HYP")) {
                return 0x3F;
            }
            if(am0.b("SPSR_FIQ")) {
                return 110;
            }
            if(am0.b("SPSR_IRQ")) {
                return 0x70;
            }
            if(am0.b("SPSR_SVC")) {
                return 0x72;
            }
            if(am0.b("SPSR_ABT")) {
                return 0x74;
            }
            if(am0.b("SPSR_UND")) {
                return 0x76;
            }
            if(am0.b("SPSR_MON")) {
                return 0x7C;
            }
            if(am0.b("SPSR_HYP")) {
                return 0x7E;
            }
            if(am0.b("SPSR")) {
                return 0x4F;
            }
            if(!am0.b("(UNDEF: ")) {
                return -1;
            }
            int v = (int)am0.f();
            if((v & 0xFFFFFF80) != 0) {
                throw ai.f;
            }
            if(!am0.a(')')) {
                throw ai.f;
            }
            return v;
        }
        return 41;
    }

    static int a(String s, int v, int v1, int v2, ai ai0) {
        int v8;
        int v3 = 0;
        int v4 = 0;
        do {
            int v5 = ai.a(s, v, v1);
            int v6 = 0;
            int v7 = v1;
            while(v5 >= 0x30 && v5 <= 57) {
                v6 = v6 * 10 + v5 - 0x30;
                ++v7;
                v5 = ai.a(s, v, v7);
            }
            if(v5 == 45) {
                ++v7;
                v5 = ai.a(s, v, v7);
                v8 = 0;
                while(v5 >= 0x30 && v5 <= 57) {
                    v8 = v8 * 10 + v5 - 0x30;
                    ++v7;
                    v5 = ai.a(s, v, v7);
                }
            }
            else {
                v8 = v6;
            }
            int v9 = v8 - v6;
            if(v9 < 0) {
                throw new RuntimeException("140 Bits is negative: " + v9 + "; " + v6 + "; " + v8 + "; \'" + s + "\'; " + v7 + "; " + v + "; 0x" + Integer.toHexString(v2));
            }
            v4 |= (v2 >> v6 & (2 << v9) - 1) << v3;
            v3 += v9 + 1;
            v1 = v7 + 1;
        }
        while(v5 == 44);
        ai0.g = v4;
        ai0.h = v3;
        return v1 - 1;
    }

    static int a(String s, int v, int v1, ai ai0, int v2) {
        int v8;
        int v3 = 0;
        int v4 = ai0.g;
        do {
            int v5 = ai.a(s, v, v1);
            int v6 = 0;
            int v7 = v1;
            while(v5 >= 0x30 && v5 <= 57) {
                v6 = v6 * 10 + v5 - 0x30;
                ++v7;
                v5 = ai.a(s, v, v7);
            }
            if(v5 == 45) {
                ++v7;
                v5 = ai.a(s, v, v7);
                v8 = 0;
                while(v5 >= 0x30 && v5 <= 57) {
                    v8 = v8 * 10 + v5 - 0x30;
                    ++v7;
                    v5 = ai.a(s, v, v7);
                }
            }
            else {
                v8 = v6;
            }
            int v9 = v8 - v6;
            if(v9 < 0) {
                throw new RuntimeException("141 Bits is negative: " + v9 + "; " + v6 + "; " + v8 + "; \'" + s + "\'; " + v7 + "; " + v + "; 0x" + Integer.toHexString(v2));
            }
            int v10 = (2 << v9) - 1;
            int v11 = (v2 >> v3 & v10) << v6;
            v4 |= v11;
            if(((v10 & -1 >> v3) << v6 & v4) != v11) {
                throw ai.f;
            }
            v3 += v9 + 1;
            v1 = v7 + 1;
        }
        while(v5 == 44);
        ai0.g = v4;
        ai0.h = v3;
        return v1 - 1;
    }

    public static String a(ai ai0, long v, long v1) {
        try {
            if(ai0 == null) {
                ai0 = new ai();
            }
            return aj.a(ai0, v, ((int)v1));
        }
        catch(Throwable throwable0) {
            la.a("Failed get OP 2", throwable0);
            return throwable0.toString().replace("java.lang.RuntimeException:", "RE:");
        }
    }

    static final void a(StringBuilder stringBuilder0, char c) {
        if(c != 0) {
            stringBuilder0.append(c);
        }
    }

    static void a(StringBuilder stringBuilder0, int v) {
        String s;
        switch(v) {
            case 15: {
                s = "CPSR";
                break;
            }
            case 0x20: {
                s = "R8_usr";
                break;
            }
            case 33: {
                s = "R9_usr";
                break;
            }
            case 34: {
                s = "R10_usr";
                break;
            }
            case 35: {
                s = "R11_usr";
                break;
            }
            case 36: {
                s = "R12_usr";
                break;
            }
            case 37: {
                s = "SP_usr";
                break;
            }
            case 38: {
                s = "LR_usr";
                break;
            }
            case 40: {
                s = "R8_fiq";
                break;
            }
            case 41: {
                s = "R9_fiq";
                break;
            }
            case 42: {
                s = "R10_fiq";
                break;
            }
            case 43: {
                s = "R11_fiq";
                break;
            }
            case 44: {
                s = "R12_fiq";
                break;
            }
            case 45: {
                s = "SP_fiq";
                break;
            }
            case 46: {
                s = "LR_fiq";
                break;
            }
            case 0x30: {
                s = "LR_irq";
                break;
            }
            case 49: {
                s = "SP_irq";
                break;
            }
            case 50: {
                s = "LR_svc";
                break;
            }
            case 51: {
                s = "SP_svc";
                break;
            }
            case 52: {
                s = "LR_abt";
                break;
            }
            case 53: {
                s = "SP_abt";
                break;
            }
            case 54: {
                s = "LR_und";
                break;
            }
            case 55: {
                s = "SP_und";
                break;
            }
            case 60: {
                s = "LR_mon";
                break;
            }
            case 61: {
                s = "SP_mon";
                break;
            }
            case 62: {
                s = "ELR_hyp";
                break;
            }
            case 0x3F: {
                s = "SP_hyp";
                break;
            }
            case 0x4F: {
                s = "SPSR";
                break;
            }
            case 110: {
                s = "SPSR_fiq";
                break;
            }
            case 0x70: {
                s = "SPSR_irq";
                break;
            }
            case 0x72: {
                s = "SPSR_svc";
                break;
            }
            case 0x74: {
                s = "SPSR_abt";
                break;
            }
            case 0x76: {
                s = "SPSR_und";
                break;
            }
            case 0x7C: {
                s = "SPSR_mon";
                break;
            }
            case 0x7E: {
                s = "SPSR_hyp";
                break;
            }
            default: {
                stringBuilder0.append("(UNDEF: ").append(v).append(')');
                return;
            }
        }
        stringBuilder0.append(s);
    }

    static void a(StringBuilder stringBuilder0, int v, boolean z) {
        stringBuilder0.append(ai.b[v & 15]);
        if((v & 0xFF0) != 0) {
            if((v & 16) == 0) {
                int v1 = (v & 0xF80) >> 7;
                int v2 = (v & 0x60) >> 5;
                if(v1 == 0) {
                    if(v2 == 3) {
                        stringBuilder0.append(", RRX");
                        return;
                    }
                    v1 = 0x20;
                }
                stringBuilder0.append(", ");
                if(z) {
                    stringBuilder0.append(ai.d[v2]).append(' ');
                }
                stringBuilder0.append('#').append(v1);
                return;
            }
            if((v & 0x80) == 0x80) {
                stringBuilder0.append(" <illegal shifter operand>");
                return;
            }
            stringBuilder0.append(", ");
            if(z) {
                stringBuilder0.append(ai.d[(v & 0x60) >> 5]).append(' ');
            }
            stringBuilder0.append(ai.b[(v & 0xF00) >> 8]);
        }
    }

    static void a(StringBuilder stringBuilder0, long v, long v1) {
        int v2 = 43;
        if(v == 0L) {
            if(v1 < 0L) {
                stringBuilder0.append('-');
                v1 = -v1;
            }
            else {
                stringBuilder0.append('+');
            }
        }
        stringBuilder0.append("0x");
        long v3 = v + v1;
        if(v3 != 0L) {
            ItemContextMenu.a(v3);
        }
        ts.a(stringBuilder0, 8, v3);
        StringBuilder stringBuilder1 = stringBuilder0.append("; ");
        if(v1 <= 0L) {
            v2 = 45;
        }
        stringBuilder1.append(((char)v2)).append("0x").append(Long.toHexString((v1 <= 0L ? -v1 : v1)).toUpperCase(Locale.US)).append(' ').append(((char)(v1 <= 0L ? 8593 : 8595)));
    }

    public static int b(ai ai0, long v, String s) {
        if(ai0 == null) {
            ai0 = new ai();
        }
        int v1 = ap.a(ai0, v, s, -1);
        if(v1 == -1) {
            String s1 = ai.b(ai0, v, ((long)ai0.e.e)).trim();
            ak ak0 = new ak(Tools.a(qk.a(0x7F07034A), new Object[]{"Thumb"}).trim() + "\n\'" + s + "\'\n\n" + Tools.a(qk.a(0x7F07034B), new Object[]{"\n\'" + s1 + "\'\n"}).trim());  // string:asm_failed "Failed to recognize __s__ opcode:"
            int v2 = s1.indexOf(59);
            if(v2 != -1) {
                s1 = s1.substring(0, v2).trim();
            }
            ak0.a = s1;
            ak0.b = s;
            throw ak0;
        }
        return v1 & 0xFFFF;
    }

    static int b(am am0) {
        if(am0.b("OSHLD")) {
            return 1;
        }
        if(am0.b("OSHST")) {
            return 2;
        }
        if(am0.b("OSH")) {
            return 3;
        }
        if(am0.b("NSHLD")) {
            return 5;
        }
        if(am0.b("UNST")) {
            return 6;
        }
        if(am0.b("UN")) {
            return 7;
        }
        if(am0.b("ISHLD")) {
            return 9;
        }
        if(am0.b("ISHST")) {
            return 10;
        }
        if(am0.b("ISH")) {
            return 11;
        }
        if(am0.b("LD")) {
            return 13;
        }
        if(am0.b("ST")) {
            return 14;
        }
        if(am0.b("SY")) {
            return 15;
        }
        if(!am0.a('#')) {
            return -1;
        }
        int v = (int)am0.f();
        if((v & -16) != 0) {
            throw ai.f;
        }
        return v;
    }

    public static String b(ai ai0, long v, long v1) {
        try {
            if((v1 & 0xF800L) == 0xF800L || (v1 & 0xF800L) == 0xF000L || (v1 & 0xF800L) == 0xE800L) {
                if(ai0 == null) {
                    ai0 = new ai();
                }
                return aq.a(ai0, v, ((int)((v1 & 0xFFFFL) << 16 | (0xFFFFFFFFFFFF0000L & v1) >> 16 & 0xFFFFL)));
            }
            return ap.a(v, ((int)v1));
        }
        catch(Throwable throwable0) {
            la.a("Failed get OP 1", throwable0);
            return throwable0.toString().replace("java.lang.RuntimeException:", "RE:");
        }
    }

    static void b(StringBuilder stringBuilder0, int v) {
        String s;
        switch(v & 15) {
            case 1: {
                s = "oshld";
                break;
            }
            case 2: {
                s = "oshst";
                break;
            }
            case 3: {
                s = "osh";
                break;
            }
            case 5: {
                s = "nshld";
                break;
            }
            case 6: {
                s = "unst";
                break;
            }
            case 7: {
                s = "un";
                break;
            }
            case 9: {
                s = "ishld";
                break;
            }
            case 10: {
                s = "ishst";
                break;
            }
            case 11: {
                s = "ish";
                break;
            }
            case 13: {
                s = "ld";
                break;
            }
            case 14: {
                s = "st";
                break;
            }
            case 15: {
                s = "sy";
                break;
            }
            default: {
                stringBuilder0.append('#').append(v & 15);
                return;
            }
        }
        stringBuilder0.append(s);
    }
}

