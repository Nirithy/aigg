package android.ext;

import java.util.Locale;

class ap {
    static final short[] a;
    static final String[] b;

    static {
        ap.a = new short[]{0xFFFFBF50, -1, 0xFFFFBA80, 0xFFFFFFC0, 0xFFFFBF00, -1, 0xFFFFBF10, -1, 0xFFFFBF20, -1, 0xFFFFBF30, -1, 0xFFFFBF40, -1, 0xFFFFBF00, 0xFFFFFF0F, 0xFFFFB900, 0xFFFFFD00, 0xFFFFB100, 0xFFFFFD00, 0xFFFFBF00, 0xFFFFFF00, 0xFFFFB660, -8, 0xFFFFB670, -8, 0x4600, 0xFFFFFFC0, 0xFFFFBA00, 0xFFFFFFC0, 0xFFFFBA40, 0xFFFFFFC0, 0xFFFFBAC0, 0xFFFFFFC0, 0xFFFFB650, -9, 0xFFFFB200, 0xFFFFFFC0, 0xFFFFB240, 0xFFFFFFC0, 0xFFFFB280, 0xFFFFFFC0, 0xFFFFB2C0, 0xFFFFFFC0, 0xFFFFBE00, 0xFFFFFF00, 0x4780, 0xFFFFFF87, 0x46C0, -1, 0x4000, 0xFFFFFFC0, 0x4040, 0xFFFFFFC0, 0x4080, 0xFFFFFFC0, 0x40C0, 0xFFFFFFC0, 0x4100, 0xFFFFFFC0, 0x4140, 0xFFFFFFC0, 0x4180, 0xFFFFFFC0, 0x41C0, 0xFFFFFFC0, 0x4200, 0xFFFFFFC0, 0x4240, 0xFFFFFFC0, 0x4280, 0xFFFFFFC0, 0x42C0, 0xFFFFFFC0, 0x4300, 0xFFFFFFC0, 0x4340, 0xFFFFFFC0, 0x4380, 0xFFFFFFC0, 0x43C0, 0xFFFFFFC0, 0xFFFFB000, 0xFFFFFF80, 0xFFFFB080, 0xFFFFFF80, 0x4700, 0xFFFFFF80, 0x4400, 0xFFFFFF00, 0x4500, 0xFFFFFF00, 0x4600, 0xFFFFFF00, 0xFFFFB400, 0xFFFFFE00, 0xFFFFBC00, 0xFFFFFE00, 0x1800, 0xFFFFFE00, 0x1A00, 0xFFFFFE00, 0x1C00, 0xFFFFFE00, 0x1E00, 0xFFFFFE00, 0x5200, 0xFFFFFE00, 0x5A00, 0xFFFFFE00, 0x5600, 0xFFFFF600, 0x5000, 0xFFFFFA00, 0x5800, 0xFFFFFA00, 0, 0xFFFFFFC0, 0, 0xFFFFF800, 0x800, 0xFFFFF800, 0x1000, 0xFFFFF800, 0x2000, 0xFFFFF800, 0x2800, 0xFFFFF800, 0x3000, 0xFFFFF800, 0x3800, 0xFFFFF800, 0x4800, 0xFFFFF800, 0x6000, 0xFFFFF800, 0x6800, 0xFFFFF800, 0x7000, 0xFFFFF800, 0x7800, 0xFFFFF800, 0xFFFF8000, 0xFFFFF800, 0xFFFF8800, 0xFFFFF800, 0xFFFF9000, 0xFFFFF800, 0xFFFF9800, 0xFFFFF800, 0xFFFFA000, 0xFFFFF800, 0xFFFFA800, 0xFFFFF800, 0xFFFFC000, 0xFFFFF800, 0xFFFFC800, 0xFFFFF800, 0xFFFFDF00, 0xFFFFFF00, 0xFFFFDE00, 0xFFFFFF00, 0xFFFFDF00, 0xFFFFFF00, 0xFFFFD000, 0xFFFFF000, 0xFFFFE000, 0xFFFFF800, 0, 0};
        ap.b = new String[]{"SEVL%c", "HLT\t %0-5x", "NOP%c", "YIELD%c", "WFE%c", "WFI%c", "SEV%c", "NOP%c\t {%4-7d}", "CBNZ\t %0-2r, %b%X", "CBZ\t %0-2r, %b%X", "IT%I%X", "CPSIE%2\'A%1\'I%0\'F%X", "CPSID%2\'A%1\'I%0\'F%X", "MOV%c\t %0-2r, %3-5r", "REV%c\t %0-2r, %3-5r", "REV16%c\t %0-2r, %3-5r", "REVSH%c\t %0-2r, %3-5r", "SETEND%3?BLE%X", "SXTH%c\t %0-2r, %3-5r", "SXTB%c\t %0-2r, %3-5r", "UXTH%c\t %0-2r, %3-5r", "UXTB%c\t %0-2r, %3-5r", "BKPT\t %0-7x", "BLX%c\t %3-6r%x", "NOP%c\t \t \t ; (MOV R8, R8)", "AND%C\t %0-2r, %3-5r", "EOR%C\t %0-2r, %3-5r", "LSL%C\t %0-2r, %3-5r", "LSR%C\t %0-2r, %3-5r", "ASR%C\t %0-2r, %3-5r", "ADC%C\t %0-2r, %3-5r", "SBC%C\t %0-2r, %3-5r", "ROR%C\t %0-2r, %3-5r", "TST%c\t %0-2r, %3-5r", "NEG%C\t %0-2r, %3-5r", "CMP%c\t %0-2r, %3-5r", "CMN%c\t %0-2r, %3-5r", "ORR%C\t %0-2r, %3-5r", "MUL%C\t %0-2r, %3-5r", "BIC%C\t %0-2r, %3-5r", "MVN%C\t %0-2r, %3-5r", "ADD%c\t SP, #%0-6W", "SUB%c\t SP, #%0-6W", "BX%c\t %S%x", "ADD%c\t %D, %S", "CMP%c\t %D, %S", "MOV%c\t %D, %S", "PUSH%c\t %N", "POP%c\t %O", "ADD%C\t %0-2r, %3-5r, %6-8r", "SUB%C\t %0-2r, %3-5r, %6-8r", "ADD%C\t %0-2r, %3-5r, #%6-8d", "SUB%C\t %0-2r, %3-5r, #%6-8d", "STRH%c\t %0-2r, [%3-5r,%6-8r]", "LDRH%c\t %0-2r, [%3-5r,%6-8r]", "LDRS%11?HB%c\t %0-2r, [%3-5r,%6-8r]", "STR%10\'B%c\t %0-2r, [%3-5r,%6-8r]", "LDR%10\'B%c\t %0-2r, [%3-5r,%6-8r]", "MOV%C\t %0-2r, %3-5r", "LSL%C\t %0-2r, %3-5r, #%6-10d", "LSR%C\t %0-2r, %3-5r, %s", "ASR%C\t %0-2r, %3-5r, %s", "MOV%C\t %8-10r, #%0-7d", "CMP%c\t %8-10r, #%0-7d", "ADD%C\t %8-10r, #%0-7d", "SUB%C\t %8-10r, #%0-7d", "LDR%c\t %8-10r, [PC,#%0-7W]\t ; (%0-7a)", "STR%c\t %0-2r, [%3-5r,#%6-10W]", "LDR%c\t %0-2r, [%3-5r,#%6-10W]", "STRB%c\t %0-2r, [%3-5r,#%6-10d]", "LDRB%c\t %0-2r, [%3-5r,#%6-10d]", "STRH%c\t %0-2r, [%3-5r,#%6-10H]", "LDRH%c\t %0-2r, [%3-5r,#%6-10H]", "STR%c\t %8-10r, [SP,#%0-7W]", "LDR%c\t %8-10r, [SP,#%0-7W]", "ADD%c\t %8-10r, PC, #%0-7W\t ; (ADR %8-10r, %0-7a)", "ADD%c\t %8-10r, SP, #%0-7W", "STMIA%c\t %8-10r!, %M", "LDMIA%c\t %8-10r%W, %M", "SVC%c\t %0-7d", "UDF%c\t #%0-7d", "\t \t ; <UNDEFINED> instruction: %0-31x", "B%8-11c.N\t %0-7B%X", "B%c.N\t %0-10B%x", "\t \t ; <UNDEFINED> instruction: %0-31x"};
    }

    static int a(ai ai0, long v, String s, int v1) {
        int v34;
        int v21;
        int v19;
        int v17;
        int v13;
        am am0 = new am(s);
        ai0.e = am0;
        short[] arr_v = ap.a;
        String[] arr_s = ap.b;
        int v2 = 0;
    alab1:
        while(true) {
            if(v2 >= arr_s.length) {
                return -1;
            }
            int v3 = arr_v[v2 * 2];
            am0.a();
            try {
                String s1 = arr_s[v2];
                int v4 = arr_v[v2 * 2 + 1];
                if(v4 != 0) {
                    int v5 = -1;
                    int v6 = 0;
                    int v7 = s1.length();
                    while(v6 < v7) {
                        int v8 = ai.a(s1, v7, v6);
                        if(v8 <= 0x20) {
                            v8 = 0x20;
                            while(v6 < v7 && ai.a(s1, v7, v6 + 1) <= 0x20) {
                                ++v6;
                            }
                        }
                        if(v8 == 37) {
                        label_28:
                            ++v6;
                            int v9 = ai.a(s1, v7, v6);
                            switch(v9) {
                                case 37: {
                                    if(am0.a('%')) {
                                        v13 = v6;
                                        goto label_215;
                                    }
                                    else {
                                        goto label_231;
                                    }
                                    goto label_34;
                                }
                                case 0x30: 
                                case 49: 
                                case 50: 
                                case 51: 
                                case 52: 
                                case 53: 
                                case 54: 
                                case 55: 
                                case 56: 
                                case 57: {
                                label_34:
                                    int v10 = v6 + 1;
                                    int v11 = v9 - 0x30;
                                    int v12;
                                    for(v12 = ai.a(s1, v7, v10); v12 >= 0x30 && v12 <= 57; v12 = ai.a(s1, v7, v10)) {
                                        ++v10;
                                        v11 = v11 * 10 + v12 - 0x30;
                                    }
                                    switch(v12) {
                                        case 39: {
                                            v6 = v10 + 1;
                                            if(am0.a(ai.a(s1, v7, v6))) {
                                                v13 = v6;
                                                v3 |= 1 << v11;
                                            }
                                            else {
                                                v13 = v6;
                                            }
                                            goto label_215;
                                        }
                                        case 45: {
                                            v6 = v10 + 1;
                                            int v14 = ai.a(s1, v7, v6);
                                            int v15;
                                            for(v15 = 0; v14 >= 0x30 && v14 <= 57; v15 = v16) {
                                                int v16 = v15 * 10 + v14 - 0x30;
                                                ++v6;
                                                v14 = ai.a(s1, v7, v6);
                                            }
                                            if(v15 == 0) {
                                                throw new RuntimeException("181 Zero bitend; " + v2 + "; " + v6 + "; " + s1);
                                            }
                                            switch(v14) {
                                                case 66: {
                                                    if(am0.a('+')) {
                                                        v17 = 1;
                                                    }
                                                    else if(am0.a('-')) {
                                                        v17 = -1;
                                                    }
                                                    else {
                                                        v17 = 0;
                                                    }
                                                    if(am0.b("0X")) {
                                                        long v18 = am0.e();
                                                        if(v17 != 0) {
                                                            v18 = v18 * ((long)v17) + v;
                                                        }
                                                        v19 = (((int)(v18 - v)) - 4 >> 1) + (1 << v15) ^ 1 << v15;
                                                        break;
                                                    }
                                                    else {
                                                        goto label_231;
                                                    }
                                                    goto label_75;
                                                }
                                                case 99: {
                                                    int v20 = am0.a(ai.a);
                                                    if(v20 == -1) {
                                                        goto label_231;
                                                    }
                                                    else {
                                                        v19 = v20;
                                                        break;
                                                    }
                                                    goto label_89;
                                                }
                                                case 72: 
                                                case 87: 
                                                case 100: {
                                                label_75:
                                                    v19 = (int)am0.f();
                                                    if(v14 == 72) {
                                                        if((v19 & 1) != 0) {
                                                            v5 = v6;
                                                        }
                                                        v19 >>= 1;
                                                    }
                                                    if(v14 == 87) {
                                                        if((v19 & 3) != 0) {
                                                            v5 = v6;
                                                        }
                                                        v19 >>= 2;
                                                    }
                                                    break;
                                                }
                                                case 0x72: {
                                                label_89:
                                                    v19 = am0.a(ai.b);
                                                    if(v19 == -1) {
                                                        goto label_231;
                                                    }
                                                    else {
                                                        break;
                                                    }
                                                    goto label_92;
                                                }
                                                case 120: {
                                                label_92:
                                                    if(am0.b("0X")) {
                                                        v19 = (int)am0.e();
                                                    }
                                                    else {
                                                        goto label_231;
                                                    }
                                                    break;
                                                }
                                                default: {
                                                    throw new RuntimeException("91 Invalid format char \'" + ((char)v14) + "\'; " + v2 + "; " + v6 + "; \'" + s1 + "\'");
                                                }
                                            }
                                            v21 = ((2 << v15 - v11) - 1 & v19) << v11 | v3;
                                            if((v19 & ~((2 << v15 - v11) - 1)) != 0) {
                                                v13 = v6;
                                                v5 = v6;
                                                v3 = v21;
                                                goto label_215;
                                            }
                                            v13 = v6;
                                            v3 = v21;
                                            goto label_215;
                                        }
                                        case 0x3F: {
                                            if(am0.a(ai.a(s1, v7, v10 + 1))) {
                                                v13 = v10 + 2;
                                                v3 |= 1 << v11;
                                                goto label_215;
                                            }
                                            else if(am0.a(ai.a(s1, v7, v10 + 2))) {
                                                v6 = v10 + 2;
                                                v13 = v6;
                                                goto label_215;
                                            }
                                            else {
                                                goto label_231;
                                            }
                                            goto label_108;
                                        }
                                        default: {
                                            throw new RuntimeException("101 Invalid format char \'" + ((char)v12) + "\'; " + v2 + "; " + v10 + "; \'" + s1 + "\'");
                                        }
                                    }
                                }
                                case 67: {
                                label_108:
                                    if(!am0.a('S')) {
                                        goto label_231;
                                    }
                                    v13 = v6;
                                    goto label_215;
                                }
                                case 68: {
                                    int v22 = am0.a(ai.b);
                                    if(v22 == -1) {
                                        goto label_231;
                                    }
                                    else {
                                        v13 = v6;
                                        v3 |= (v22 & 8) << 4 | v22 & 7;
                                        goto label_215;
                                    }
                                    goto label_116;
                                }
                                case 73: {
                                label_116:
                                    int v23 = 0;
                                    int v24 = 0;
                                    int v25 = 0;
                                    int v26 = 8;
                                    while(!am0.a(' ')) {
                                        if(am0.a('E')) {
                                            v23 |= v26;
                                        }
                                        else if(!am0.a('T')) {
                                            goto label_231;
                                        }
                                        if(v26 == 1) {
                                            goto label_231;
                                        }
                                        v24 = v26 >> 1;
                                        v25 |= v26;
                                        v26 >>= 1;
                                    }
                                    int v27 = am0.a(ai.a);
                                    int v28 = v27 != -1 && (v27 & -16) == 0 ? v5 : v6;
                                    int v29 = (v27 & 1) == 0 || (v23 | v24) == 0 ? v23 : v23 ^ v25;
                                    v3 = v3 | v27 << 4 | ((v29 | v24) == 0 ? 8 : v29 | v24);
                                    v13 = v6;
                                    v5 = v28;
                                    goto label_215;
                                }
                                case 77: 
                                case 78: 
                                case 0x4F: {
                                    if(am0.a('{')) {
                                        int v30 = -1;
                                        while(true) {
                                            int v31 = am0.a(ai.b);
                                            int v32 = am0.c();
                                            if(v31 >= 8) {
                                                goto label_162;
                                            }
                                            if(v31 == -1) {
                                                break;
                                            }
                                            if(v30 == -1) {
                                                v30 = v31;
                                            }
                                            v21 = v3 | (2 << v31 - v30) - 1 << v30;
                                            if(v32 == 45) {
                                                v30 = v31;
                                            }
                                            else {
                                                if(v32 != 44) {
                                                    goto label_164;
                                                }
                                                v30 = -1;
                                            }
                                            v3 = v21;
                                        }
                                        v21 = v3;
                                        goto label_164;
                                    label_162:
                                        if((v9 != 78 || v31 != 14) && (v9 != 0x4F || v31 != 15)) {
                                            goto label_231;
                                        }
                                        else {
                                            v21 = v3 | 0x100;
                                        }
                                    label_164:
                                        if(v32 != 0x7D) {
                                            v3 = v21;
                                            goto label_231;
                                        }
                                    }
                                    else {
                                        goto label_231;
                                    }
                                    v13 = v6;
                                    v3 = v21;
                                    goto label_215;
                                }
                                case 83: {
                                    int v33 = am0.a(ai.b);
                                    if(v33 == -1) {
                                        goto label_231;
                                    }
                                    else {
                                        v13 = v6;
                                        v3 |= (v33 & 8) << 3 | (v33 & 7) << 3;
                                        goto label_215;
                                    }
                                    goto label_175;
                                }
                                case 87: {
                                label_175:
                                    if(am0.a('!')) {
                                        v13 = v6;
                                    }
                                    else {
                                        v13 = v6;
                                        v3 |= 1 << ((v3 & 0x700) >> 8);
                                    }
                                    goto label_215;
                                }
                                case 88: {
                                    v13 = v6;
                                    goto label_215;
                                }
                                case 98: {
                                    if(am0.a('+')) {
                                        v34 = 1;
                                    }
                                    else if(am0.a('-')) {
                                        v34 = -1;
                                    }
                                    else {
                                        v34 = 0;
                                    }
                                    if(am0.b("0X")) {
                                        long v35 = am0.e();
                                        if(v34 != 0) {
                                            v35 = v35 * ((long)v34) + v;
                                        }
                                        int v36 = ((int)(v35 - v)) - 4;
                                        v21 = v36 << 2 & 0xF8 | v36 << 3 & 0x200 | v3;
                                        if((v36 & 0xFFFFFF81) == 0) {
                                            v13 = v6;
                                        }
                                        else {
                                            v13 = v6;
                                            v5 = v6;
                                        }
                                        v3 = v21;
                                        goto label_215;
                                    }
                                    else {
                                        goto label_231;
                                    }
                                    v13 = v6;
                                    goto label_215;
                                }
                                case 99: {
                                    v13 = v6;
                                    goto label_215;
                                }
                                case 0x73: {
                                    if(am0.a('#')) {
                                        int v37 = (int)am0.f();
                                        if(v37 == 0x20) {
                                            v37 = 0;
                                        }
                                        if((v37 & 0xFFFFFFE0) != 0) {
                                            v5 = v6;
                                        }
                                        v13 = v6;
                                        v3 |= (v37 & 0x1F) << 6;
                                    }
                                    else {
                                        goto label_231;
                                    }
                                label_215:
                                    v6 = v13 + 1;
                                    continue;
                                }
                                case 120: {
                                    ++v6;
                                    continue;
                                }
                                default: {
                                    throw new RuntimeException("111 Invalid format char \'" + ((char)v9) + "\'; " + v2 + "; " + v6 + "; \'" + s1 + "\'");
                                }
                            }
                        }
                        else {
                            if(v8 == 59) {
                                break;
                            }
                            else {
                                if(97 <= v8 && v8 <= 0x7A) {
                                    v8 = (char)(v8 - 0x20);
                                }
                                if(am0.a(((char)v8))) {
                                    v13 = v6;
                                    goto label_215;
                                }
                                else {
                                    goto label_231;
                                }
                            }
                            goto label_28;
                        }
                        ++v2;
                        continue alab1;
                    }
                    am0.a(' ');
                    if(v5 == -1) {
                        int v38 = am0.b();
                        if(v38 > 0x20 && v38 != 59 || (v3 & v4) != arr_v[v2 * 2]) {
                            goto label_231;
                        }
                        else {
                            int v39 = 0;
                            while(v39 < v2) {
                                if((arr_v[v39 * 2 + 1] & v3) == arr_v[v39 * 2]) {
                                    goto label_231;
                                }
                                ++v39;
                            }
                            return v3;
                        }
                    }
                    else {
                        goto label_231;
                    }
                }
                while(true) {
                    ++v2;
                    continue alab1;
                label_231:
                    if(am0.c <= am0.d) {
                        break;
                    }
                    am0.d = am0.c;
                    am0.e = v3;
                }
                ++v2;
            }
            catch(ao unused_ex) {
                goto label_231;
            }
        }
    }

    static String a(long v, int v1) {
        int v7;
        int v2;
        for(v2 = 0; true; ++v2) {
            if(v2 >= ap.b.length) {
                throw new RuntimeException("190 No Thumb match for " + Integer.toHexString(v1).toUpperCase(Locale.US) + "; " + Integer.toHexString(Integer.reverseBytes(v1)).toUpperCase(Locale.US));
            }
            if((ap.a[v2 * 2 + 1] & ((short)v1)) == ap.a[v2 * 2]) {
                break;
            }
        }
        StringBuilder stringBuilder0 = new StringBuilder();
        int v3 = 0;
        String s = ap.b[v2];
        int v4 = 0;
        int v5 = s.length();
        while(true) {
            if(v4 >= v5) {
                if(v3 > 0x20 || v3 < -16) {
                    stringBuilder0.append("\t ; 0x").append(Integer.toHexString(v3).toUpperCase(Locale.US));
                }
                return stringBuilder0.toString();
            }
            int v6 = ai.a(s, v5, v4);
            boolean z = false;
            boolean z1 = false;
            if(v6 == 37) {
                int v8 = ai.a(s, v5, v4 + 1);
                switch(v8) {
                    case 37: {
                        stringBuilder0.append('%');
                        v7 = v4 + 1;
                        break;
                    }
                    case 0x30: 
                    case 49: 
                    case 50: 
                    case 51: 
                    case 52: 
                    case 53: 
                    case 54: 
                    case 55: 
                    case 56: 
                    case 57: {
                        int v9 = v4 + 2;
                        int v10 = ai.a(s, v5, v9);
                        int v11;
                        for(v11 = v8 - 0x30; v10 >= 0x30 && v10 <= 57; v11 = v12) {
                            int v12 = v11 * 10 + v10 - 0x30;
                            ++v9;
                            v10 = ai.a(s, v5, v9);
                        }
                        switch(v10) {
                            case 39: {
                                int v13 = ai.a(s, v5, v9 + 1);
                                if((1 << v11 & v1) != 0) {
                                    ai.a(stringBuilder0, ((char)v13));
                                }
                                v7 = v9 + 1;
                                break;
                            }
                            case 45: {
                                v7 = v9 + 1;
                                int v14 = ai.a(s, v5, v7);
                                int v15;
                                for(v15 = 0; v14 >= 0x30 && v14 <= 57; v15 = v16) {
                                    int v16 = v15 * 10 + v14 - 0x30;
                                    ++v7;
                                    v14 = ai.a(s, v5, v7);
                                }
                                if(v15 == 0) {
                                    throw new RuntimeException("180 Zero bitend; " + v2 + "; " + v7 + "; " + s);
                                }
                                int v17 = v1 >> v11 & (2 << v15 - v11) - 1;
                                switch(v14) {
                                    case 66: {
                                        ai.a(stringBuilder0, v, ((long)(((v17 ^ 1 << v15) - (1 << v15)) * 2 + 4)));
                                        v3 = 0;
                                        break;
                                    }
                                    case 97: {
                                        ai.a(stringBuilder0, -4L & v, ((long)((v17 << 2) + 4)));
                                        v3 = 0;
                                        break;
                                    }
                                    case 99: {
                                        stringBuilder0.append(ai.a[v17]);
                                        break;
                                    }
                                    case 72: 
                                    case 87: 
                                    case 100: {
                                        if(v14 == 72) {
                                            v17 <<= 1;
                                        }
                                        if(v14 == 87) {
                                            v17 <<= 2;
                                        }
                                        stringBuilder0.append(v17);
                                        v3 = v17;
                                        break;
                                    }
                                    case 0x72: {
                                        stringBuilder0.append(ai.b[v17]);
                                        break;
                                    }
                                    case 120: {
                                        stringBuilder0.append("0x");
                                        ts.a(stringBuilder0, 4, v17);
                                        break;
                                    }
                                    default: {
                                        throw new RuntimeException("90 Invalid format char \'" + ((char)v14) + "\'; " + v2 + "; " + v7 + "; \'" + s + "\'");
                                    }
                                }
                                break;
                            }
                            case 0x3F: {
                                int v18 = ai.a(s, v5, v9 + 1);
                                if((1 << v11 & v1) == 0) {
                                    ai.a(stringBuilder0, ai.a(s, v5, v9 + 2));
                                }
                                else {
                                    ai.a(stringBuilder0, ((char)v18));
                                }
                                v7 = v9 + 2;
                                break;
                            }
                            default: {
                                throw new RuntimeException("100 Invalid format char \'" + ((char)v10) + "\'; " + v2 + "; " + v9 + "; \'" + s + "\'");
                            }
                        }
                        break;
                    }
                    case 67: {
                        stringBuilder0.append('S');
                        v7 = v4 + 1;
                        break;
                    }
                    case 68: {
                        stringBuilder0.append(ai.b[((v1 & 0x80) == 0 ? v1 & 7 : (v1 & 7) + 8)]);
                        v7 = v4 + 1;
                        break;
                    }
                    case 73: {
                        for(int v19 = v1 << 1; (v19 & 15) != 0; v19 <<= 1) {
                            stringBuilder0.append(((char)(((v1 ^ v19) & 16) == 0 ? 84 : 69)));
                        }
                        stringBuilder0.append("\t ").append(ai.a[v1 >> 4 & 15]);
                        v7 = v4 + 1;
                        break;
                    }
                    case 77: {
                    label_108:
                        boolean z2 = false;
                        stringBuilder0.append('{');
                        for(int v20 = 0; v20 < 8; ++v20) {
                            if((1 << v20 & v1) != 0) {
                                if(v20 >= 2 && v20 <= 12 && (1 << v20 - 2 & v1) != 0 && (1 << v20 - 1 & v1) != 0) {
                                    stringBuilder0.setLength(stringBuilder0.length() - 1 - ai.b[v20 - 1].length());
                                    stringBuilder0.append('-');
                                }
                                else if(z2) {
                                    stringBuilder0.append(',');
                                }
                                z2 = true;
                                stringBuilder0.append(ai.b[v20]);
                            }
                        }
                        if(z1) {
                            if(z2) {
                                stringBuilder0.append(',');
                            }
                            z2 = true;
                            stringBuilder0.append("LR");
                        }
                        if(z) {
                            if(z2) {
                                stringBuilder0.append(',');
                            }
                            stringBuilder0.append("PC");
                        }
                        stringBuilder0.append('}');
                        v7 = v4 + 1;
                        break;
                    }
                    case 78: {
                        if((v1 & 0x100) != 0) {
                            z1 = true;
                        }
                        goto label_106;
                    }
                    case 0x4F: {
                    label_106:
                        if(v8 == 0x4F && (v1 & 0x100) != 0) {
                            z = true;
                        }
                        goto label_108;
                    }
                    case 83: {
                        stringBuilder0.append(ai.b[((v1 & 0x40) == 0 ? v1 >> 3 & 7 : (v1 >> 3 & 7) + 8)]);
                        v7 = v4 + 1;
                        break;
                    }
                    case 87: {
                        if((1 << ((v1 & 0x700) >> 8) & v1) == 0) {
                            stringBuilder0.append('!');
                        }
                        v7 = v4 + 1;
                        break;
                    }
                    case 88: {
                        v7 = v4 + 1;
                        break;
                    }
                    case 98: {
                        ai.a(stringBuilder0, v, ((long)(((v1 & 0xF8) >> 2) + 4 + ((v1 & 0x200) >> 3))));
                        v7 = v4 + 1;
                        break;
                    }
                    case 99: {
                        v7 = v4 + 1;
                        break;
                    }
                    case 0x73: {
                        stringBuilder0.append('#').append(((v1 & 0x7C0) >> 6 == 0 ? 0x20 : (v1 & 0x7C0) >> 6));
                        v7 = v4 + 1;
                        break;
                    }
                    case 120: {
                        v7 = v4 + 1;
                        break;
                    }
                    default: {
                        throw new RuntimeException("110 Invalid format char \'" + ((char)v8) + "\'; " + v2 + "; " + (v4 + 1) + "; \'" + s + "\'");
                    }
                }
            }
            else {
                ai.a(stringBuilder0, ((char)v6));
                v7 = v4;
            }
            v4 = v7 + 1;
        }
    }
}

