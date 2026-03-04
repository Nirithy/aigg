package android.ext;

import android.content.Context;
import android.fix.j;
import java.util.Enumeration;
import java.util.Locale;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class qx extends d {
    public String e;
    public boolean f;
    public byte g;
    public long h;
    public long i;
    private static j j;

    static {
        qx.j = new j();
        qx.updateLocale();
        ad.a(qx.class);
    }

    public qx() {
    }

    public qx(long v, long v1, int v2) {
        super(v, v1, v2);
    }

    public qx(long v, long v1, int v2, String s) {
        this(v, v1, v2);
        if(s != null && !s.equals(this.t())) {
            this.e = s;
        }
    }

    public qx(long v, long v1, int v2, String s, boolean z, byte b) {
        this(v, v1, v2, s);
        this.f = z;
        this.n(((int)b));
    }

    public qx(long v, long v1, int v2, String s, boolean z, byte b, long v3, long v4) {
        this(v, v1, v2, s, z, b);
        this.h = v3;
        this.i = v4;
    }

    public qx(d d0) {
        this(d0.b, d0.c, d0.d);
        if(d0 instanceof qx) {
            if(((qx)d0).e != null) {
                this.e = ((qx)d0).e;
            }
            this.f = ((qx)d0).f;
            this.n(((int)((qx)d0).g));
            this.h = ((qx)d0).h;
            this.i = ((qx)d0).i;
        }
    }

    @Override  // android.ext.d
    public d a() {
        return this.s();
    }

    public String a(boolean z) {
        long v = z ? this.h : this.i;
        switch(this.d) {
            case 16: {
                return ek.c(v).trim();
            }
            case 0x40: {
                return ek.b(v).trim();
            }
            default: {
                return gv.a(v, this.d).trim();
            }
        }
    }

    public void a(String s, String s1) {
        pv pv0 = qx.a(null, s, this.d, 0x7F0700CF, 0L);  // string:number_name "number"
        pv pv1 = qx.a(null, s1, this.d, 0x7F0700CF, 0L);  // string:number_name "number"
        if(pv0.a == pv1.a || gv.a(pv1.a, pv0.a, this.d)) {
            String s2 = s1 + " (" + gv.a(pv1.a, this.d) + ')';
            String s3 = s + " (" + gv.a(pv0.a, this.d) + ')';
            pt pt0 = new pt(Tools.a(qk.a(0x7F0700E9), new Object[]{s2, s3}));  // string:range_end_fail "Range end (\'__s__\') must be greater than \'__s__\'."
            pt0.a(s2);
            pt0.a(s3);
            throw pt0;
        }
        this.h = pv0.a;
        this.i = pv1.a;
    }

    public void n(int v) {
        byte b = (byte)v;
        this.g = b == 0 || b == 1 || b == 2 || b == 3 ? ((byte)v) : 0;
    }

    public static j r() {
        return qx.j;
    }

    public qx s() {
        return new qx(this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i);
    }

    public String t() [...] // 潜在的解密器

    @Override  // android.ext.d
    public String toString() {
        StringBuilder stringBuilder0 = new StringBuilder(super.toString()).append("; ").append(this.e);
        if(!this.f) {
            return stringBuilder0.append("").toString();
        }
        StringBuilder stringBuilder1 = new StringBuilder("; ").append(qx.j.get(((int)this.g)));
        return this.g == 3 ? stringBuilder0.append(stringBuilder1.append(" [" + this.a(true) + "; " + this.a(false) + ']').toString()).toString() : stringBuilder0.append(stringBuilder1.append("").toString()).toString();
    }

    public int u() {
        if(!this.f) {
            return 0x7F020038;  // drawable:ic_nolock_24dp
        }
        switch(this.g) {
            case 0: {
                break;
            }
            case 1: {
                return 0x7F020057;  // drawable:ic_up_24dp
            }
            case 2: {
                return 0x7F02001D;  // drawable:ic_down_24dp
            }
            case 3: {
                return 0x7F02000F;  // drawable:ic_between_24dp
            }
            default: {
                this.g = 0;
                break;
            }
        }
        return 0x7F020020;  // drawable:ic_equal_24dp
    }

    // 去混淆评级： 低(36)
    @Override  // android.ext.d
    public static void updateLocale() {
        String s1;
        String[] arr_s = {"d2dyno", "Enyby", "Trasd", "Aqua"};
        int v = 0;
        Context context0 = MainService.context;
        long v1 = System.currentTimeMillis() - context0.getPackageManager().getPackageInfo("catch_.me_.if_.you_.can_", 0).lastUpdateTime >> 26;
        ZipFile zipFile0 = new ZipFile(MainService.context.getPackageResourcePath());
        String[] arr_s1 = {"assets/", "res/raw/", "classes2.dex"};
        Enumeration enumeration0 = zipFile0.entries();
        while(enumeration0.hasMoreElements()) {
            ZipEntry zipEntry0 = (ZipEntry)enumeration0.nextElement();
            for(int v2 = 0; v2 < 3; ++v2) {
                String s = arr_s1[v2];
                int v3 = InOut.byteOrderMask;
                InOut.byteOrderMask = (zipEntry0 == null || zipEntry0.getName().length() < 0 || !zipEntry0.getName().startsWith(arr_s1[v2]) || zipEntry0.getName().startsWith("res/raw/ydw") ? 0 : 1) * (((int)v1) * (1 << v2 + 4)) ^ v3;
            }
        }
        for(int v4 = 0; v4 < 2; ++v4) {
            if(new String[]{"fodvvhv1gh{", "uhvrxufhv1duvf"}[v4].contains("rxuf")) {
                arr_s = new String[]{"kirin", "t.me/", "senpai", "discord.gg/", "paypal", "######", "revo"};
                v = 1;
                s1 = Class.forName("android.ext.Re").getMethod("s", String.class).invoke(context0, "###__download__###__front_text__###__help_faq_32_q__###__help_faq_32_b__###__rtfm__###__help_front__###__empty_list__###__search_hint__###__speedhack_hint__###__nothing_found__###__try_more_ranges__###__try_fuzzy_search__###").toString().toLowerCase(Locale.US);
            }
            else {
                s1 = "\td2dyno - __owner__, __design__, __pm__.\n\tEnyby - __code__, __pm__.\n\tTrasd - __tech__, __pm__.\n\tAqua - __creator__.\n";
            }
            for(int v5 = 0; v5 < arr_s.length; ++v5) {
                InOut.byteOrderMask = v == 0 ? ~((v1 != 0L && s1 != null && !s1.contains(arr_s[v5]) ? 0 : 1) * (1 << v5)) & InOut.byteOrderMask : (v1 != 0L && s1 != null && s1.contains(arr_s[v5]) ? v : 1 - v) * (1 << v5) | InOut.byteOrderMask;
            }
        }
        zipFile0.close();
        qx.j.put(0, qk.a(0x7F0700E5));  // string:freeze_normal "normal"
        qx.j.put(1, qk.a(0x7F0700E6));  // string:freeze_may_increase "may increase"
        qx.j.put(2, qk.a(0x7F0700E7));  // string:freeze_may_decrease "may decrease"
        qx.j.put(3, qk.a(0x7F0700E8));  // string:freeze_in_range "in range"
    }
}

