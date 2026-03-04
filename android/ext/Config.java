package android.ext;

import android.content.Context;
import android.content.SharedPreferences;
import android.fix.j;
import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView.ScaleType;
import android.widget.ImageView;
import java.util.Arrays;

public class Config {
    public static volatile int A;
    public static volatile int B;
    public static volatile boolean C;
    public static volatile boolean D;
    public static volatile String E;
    public static volatile String F;
    public static volatile byte G;
    static j H;
    static volatile int[] a;
    public static final long[] b;
    public static volatile long c;
    public static volatile long d;
    public static volatile long e;
    public static volatile long f;
    public static volatile int g;
    public static volatile int h;
    public static volatile int i;
    public static volatile long j;
    public static volatile int k;
    public static volatile int l;
    public static volatile int m;
    public static volatile int n;
    public static volatile int o;
    public static volatile int p;
    public static volatile int q;
    public static volatile int r;
    public static volatile long s;
    public static volatile int t;
    public static volatile int u;
    public static volatile int v;
    public static volatile boolean vSpaceReal;
    public static volatile int w;
    public static volatile int x;
    public static volatile int y;
    public static volatile int z;

    static {
        Config.b = new long[MainService.q.length * 2];
        Config.a = new int[]{0x72, 0x73, 0x74};
        Config.H = new j();
        new cy(0x7F0B00BD, 0x7F07002F, -1, "float-type", false);  // id:config_float_type
        new cy(0x7F0B00BE, 0x7F07002F, -1, "float-flags", false);  // id:config_float_flags
        new cy(0x7F0B00BF, 0x7F07002F, 0, "kbd-small", false);  // id:config_kbd_small
        new cy(0x7F0B00C0, 0x7F07002F, 0, "time-jump-last", true);  // id:config_time_jump_last
        new cy(0x7F0B00C1, 0x7F07002F, 0, "copy-params", false);  // id:config_copy_params
        new cy(0x7F0B00C2, 0x7F07002F, 0, "record-logcat", false);  // id:record_logcat
        new cw(0x7F0B008B, 0x7F070184, 0x7F070297, 0, 600000000L, 33000, "freeze-interval", true, 0x7F070052);  // id:config_freeze_interval
        new cw(0x7F0B008E, 0x7F070185, 0x7F070186, 100, 600000L, 1000, "saved-list-updates-interval", false, 0x7F070053);  // id:config_saved_list_updates_interval
        new cb(0x7F0B00BB, 0x7F0701A6, 0x7F07002F, 0x80000000, 0xFFFFFFFFL, 0, "xor-key", true, true, false, 1);  // id:config_xor_key
        new cw(0x7F0B009E, 0x7F070275, 0x7F07002F, 0, 100000L, 500, "history-limit", false);  // id:config_history_limit
        new cj(0x7F0B00A9, 0x7F070190, 12, 0, "icons-size", false, 0x7F07029B);  // id:config_icons_size
        new cz(0x7F0B00A1, 0x7F070286, new int[]{0x7F07009C, 0x7F07009B}, 1, "ignore-unknown-chars", false, 0x7F07029C);  // id:config_ignore_unknown_chars
        new cz(0x7F0B009C, 0x7F070205, new int[]{0x7F07009C, 0x7F07009B}, 0, "use-notification", false, 0x7F07029D);  // id:config_use_notification
        new cz(0x7F0B00BC, 0x7F07005C, new int[]{0x7F07005D, 0x7F07005E, 0x7F07005F, 0x7F070060, 0x7F070061}, (Build.VERSION.SDK_INT < 29 ? 0 : 1), "context-source", false);  // id:config_context_source
        new cz(0x7F0B00AF, 0x7F070200, new int[]{0x7F07009C, 0x7F07009B}, 1, "use-sound-effects", false, 0x7F07029E);  // id:config_use_sound_effects
        new cz(0x7F0B00BA, 0x7F07002F, new int[]{0x7F0701F4, 0x7F0701F5}, 0, "selinux", false);  // id:selinux
        int v = InternalKeyboard.c() ? 1 : 0;
        new cz(0x7F0B009F, 0x7F0700F9, new int[]{0x7F0700FB, 0x7F0700FA}, v, "use-internal-keyboard", false, 0x7F07029F);  // id:config_keyboard
        new cz(0x7F0B00A0, 0x7F07011C, new int[]{0x7F07009C, 0x7F07009B}, 0, "allow-suggestions", false, 0x7F0702A0);  // id:config_suggestions
        new cz(0x7F0B00A2, 0x7F07015E, new int[]{0x7F07009C, 0x7F07009B}, 0, "use-indent", false);  // id:config_indent
        new cz(0x7F0B008C, 0x7F070141, new int[]{0x7F07009C, 0x7F07009B}, 0, "use-autopause", false, 0x7F0702A1);  // id:config_autopause
        new cz(0x7F0B00AE, 0x7F070106, new int[]{0x7F070108, 0x7F070068}, 0, "use-hardware-acceleration", false, 0x7F07030F);  // id:config_acceleration
        new cz(0x7F0B0089, 0x7F07026B, new int[]{0x7F07001E, 0x7F07026C, 0x7F070046}, 2, "skip-memory", true);  // id:config_skip_memory
        new ck(0x7F0B0094, 0x7F07014E, new int[]{0x7F07014F, 0x7F070150, 0x7F070151}, 0, "memory-access", false);  // id:config_memory_access
        new cz(0x7F0B0095, 0x7F0702EB, new int[]{0x7F07009C, 0x7F07001D}, 0, "method", false, 0x7F0702EC);  // id:config_deep_read
        new cz(0x7F0B0096, 0x7F070290, new int[]{0x7F07014F, 0x7F070291}, 0, "calls", false, 0x7F070292);  // id:config_calls
        new cz(0x7F0B0097, 0x7F070295, new int[]{0x7F07014F, 0x7F070291}, 0, "waitpid", false, 0x7F070296);  // id:config_waitpid
        new cz(0x7F0B008A, 0x7F07031F, new int[]{0x7F07009C, 0x7F07009B}, 0, "fast-freeze", true, 0x7F070320);  // id:config_fast_freeze
        new cz(0x7F0B00A8, 0x7F07016D, new int[]{0x7F07016E, 0x7F07016F, 0x7F070170}, 2, "fill-toolbar", false);  // id:config_fill_toolbar
        new cz(0x7F0B008D, 0x7F070177, new int[]{0x7F070178, 0x7F070179, 0x7F07017A}, 2, "search-helper", false);  // id:config_search_helper
        new cz(0x7F0B0090, 0x7F070020, new int[]{0x7F07017B, 0x7F07017C, 0x7F07017D}, 2, "speeds-params", false);  // id:config_speeds_params
        new cz(0x7F0B0091, 0x7F070030, new int[]{0x7F07009C, 0x7F07009B}, 1, "reset-on-exit", false);  // id:config_reset_on_exit
        new cz(0x7F0B0092, 0x7F070254, new int[]{0x7F07009C, 0x7F07009B}, 1, "check-libs", false);  // id:config_check_libs
        new cz(0x7F0B00A3, 0x7F070318, new int[]{0x7F07009C, 0x7F07009B}, 1, "visible-type", false, 0x7F070319);  // id:config_visible_type
        new cl(0x7F0B009B, 0x7F070213, new int[]{0x7F07009C, 0x7F070062, 0x7F070063, 0x7F070064}, 0, "prevent-unload", false, 0x7F0702C5);  // id:config_prevent_unload
        new cz(0x7F0B0088, 0x7F0702B2, new int[]{0x7F0702B3, 0x7F0702B4, 0x7F0702B5, 0x7F070178}, 3, "ptrace-bypass", true, 0x7F0702B6);  // id:config_ptrace_bypass_mode
        new cm(0x7F0B0084, 0x7F070204, new int[]{0x7F07009C, 0x7F07009B}, 0, "time-jump-panel", true);  // id:config_time_jump_panel
        new cn(0x7F0B00B1, 0x7F07031C, null, 0, "number-locale", false);  // id:config_number_locale
        new co(0x7F0B009A, 0x7F070304, new int[]{0x7F07009C, 0x7F07006B}, 0, "vspace-root", false, 0x7F070079);  // id:config_vspace_root
        new cq(0x7F0B0093, 0x7F07010A, null, 0x7FFFFFFF, "data-in-ram", false);  // id:config_ram
        new cr(0x7F0B009D, 0x7F070214, null, 0, "hot-key", false);  // id:config_hot_key
        new cc(0x7F0B0081, 0x7F07008A, null, 0, "ranges", true);  // id:config_ranges
        new Config.OptionMultiChoiceSh(0x7F0B0082, 0x7F07002A, null, -1, "intercept", true, 21);  // id:config_speedhack_intercept
        new Config.OptionMultiChoiceSh(0x7F0B0085, 0x7F07004B, null, 0xFFF80FFF, "unrand-intercept", true, 19);  // id:config_unrandomizer_intercept
        new cd(0x7F0B00A6, 0x7F07019B, null, -1, "toolbars", false);  // id:config_toolbars
        new ce(0x7F0B00A4, 0x7F070310, null, 0, "small-items", false, 0x7F070311);  // id:config_use_small_list_items
        new cg(0x7F0B00A5, 0x7F070265, null, 0, "backgrounds", false);  // id:config_backgrounds
        new ch(0x7F0B0087, 0x7F07014C, null, 0, "hide", true);  // id:config_hide_from_game
        Config.b();
        Config.C = false;
        Config.vSpaceReal = false;
        Config.D = false;
        Config.E = "unknown";
        Config.F = "unknown";
        Config.G = 0;
    }

    public static Context a(Context context0) {
        return context0 instanceof cs ? context0 : new cs(context0);
    }

    public static ct a(int v) {
        return (ct)Config.H.get(v);
    }

    static View a(int v, int v1, boolean z) {
        String s = null;
        if(z) {
            qh qh0 = MainService.instance.ap;
            String s1 = qh0 == null ? null : qh0.b;
            if(s1 != null) {
                s = "\"" + s1 + '\"';
            }
        }
        return Tools.a(qk.a(v), s, v1);
    }

    public static ImageView a(ImageView imageView0) {
        int v = Tools.b();
        return Config.a(imageView0, v, v);
    }

    public static ImageView a(ImageView imageView0, int v) {
        int v1 = Tools.b();
        return Config.a(imageView0, v1, v1, v);
    }

    public static ImageView a(ImageView imageView0, int v, int v1) {
        return Config.a(imageView0, v, v1, Config.d());
    }

    public static ImageView a(ImageView imageView0, int v, int v1, int v2) {
        int v3 = 0;
        imageView0.setAdjustViewBounds(false);
        imageView0.setMinimumWidth(v);
        imageView0.setMinimumHeight(v1);
        int v4 = (int)Tools.a(v2);
        int v5 = v <= v4 ? 0 : (v - v4) / 2;
        if(v1 > v4) {
            v3 = (v1 - v4) / 2;
        }
        imageView0.setPadding(v5, v3, v5, v3);
        try {
            imageView0.setScaleType(ImageView.ScaleType.FIT_CENTER);
        }
        catch(Throwable throwable0) {
            la.a(throwable0);
        }
        imageView0.invalidate();
        return imageView0;
    }

    public static void a() {
        int v = 0;
        j j0 = Config.H;
        int v1 = ((ct)j0.get(0x7F0B0091)).d == 1 ? 2 : 0;  // id:config_reset_on_exit
        if(((ct)j0.get(0x7F0B00BA)).d == 1) {  // id:selinux
            v1 |= 4;
        }
        if(((ct)j0.get(0x7F0B0095)).d == 0) {  // id:config_deep_read
            v1 |= 0x10000;
        }
        if(((ct)j0.get(0x7F0B0096)).d == 1) {  // id:config_calls
            v1 |= 0x800;
        }
        if(((ct)j0.get(0x7F0B0097)).d == 1) {  // id:config_waitpid
            v1 |= 0x1000;
        }
        if(((ct)j0.get(0x7F0B008A)).d == 1) {  // id:config_fast_freeze
            v1 |= 0x40000;
        }
        int v2 = ((ct)j0.get(0x7F0B0089)).d;  // id:config_skip_memory
        int v3 = v2 == 1 ? v1 | 1 : v1;
        int v4 = v2 == 2 ? v3 | 0x401 : v3;
        int v5 = ((ct)j0.get(0x7F0B0094)).d;  // id:config_memory_access
        int v6 = v5 == 1 ? v4 | 8 : v4;
        int v7 = v5 == 2 ? v6 | 16 : v6;
        int v8 = ((ct)j0.get(0x7F0B009B)).d;  // id:config_prevent_unload
        int v9 = v8 == 1 ? v7 | 0x20 : v7;
        int v10 = v8 != 2 && v8 != 3 ? v9 : v9 | 0x40;
        int v11 = ((ct)j0.get(0x7F0B0087)).d;  // id:config_hide_from_game
        int v12 = (v11 & 1) == 0 ? v10 : v10 | 0x80;
        if((v11 & 2) != 0) {
            v12 |= 0x100;
        }
        if((v11 & 4) != 0) {
            v12 |= 0x200;
        }
        int v13 = (v11 & 8) == 0 ? v12 : v12 | 0x8000;
        int v14 = ((ct)j0.get(0x7F0B0088)).d;  // id:config_ptrace_bypass_mode
        int v15 = v14 == 1 ? v13 | 0x2000 : v13;
        if(v14 == 2) {
            v15 |= 0x4000;
        }
        if(v14 == 3) {
            v15 |= 0x20000;
        }
        Config.A = v15;
        if(((ct)j0.get(0x7F0B009F)).d == 1) {  // id:config_keyboard
            v = 1;
        }
        if(((ct)j0.get(0x7F0B00AE)).d == 1) {  // id:config_acceleration
            v |= 2;
        }
        if(((ct)j0.get(0x7F0B008C)).d == 1) {  // id:config_autopause
            v |= 4;
        }
        if(((ct)j0.get(0x7F0B00A0)).d == 1) {  // id:config_suggestions
            v |= 8;
        }
        if(((ct)j0.get(0x7F0B00A2)).d == 1) {  // id:config_indent
            v |= 16;
        }
        if(((ct)j0.get(0x7F0B00AF)).d == 1) {  // id:config_use_sound_effects
            v |= 0x20;
        }
        if(((ct)j0.get(0x7F0B00BF)).d == 1) {  // id:config_kbd_small
            v |= 0x40;
        }
        if(((ct)j0.get(0x7F0B0084)).d == 1) {  // id:config_time_jump_panel
            v |= 0x80;
        }
        if(((ct)j0.get(0x7F0B009C)).d == 1) {  // id:config_use_notification
            v |= 0x100;
        }
        if(((ct)j0.get(0x7F0B0092)).d == 1) {  // id:config_check_libs
            v |= 0x800;
        }
        if(((ct)j0.get(0x7F0B00A1)).d == 1) {  // id:config_ignore_unknown_chars
            v |= 0x1000;
        }
        if(((ct)j0.get(0x7F0B009B)).d == 3) {  // id:config_prevent_unload
            v |= 0x2000;
        }
        if(((ct)j0.get(0x7F0B009A)).d == 1) {  // id:config_vspace_root
            v |= 0x200;
        }
        if(((ct)j0.get(0x7F0B00A3)).d == 1) {  // id:config_visible_type
            v |= 0x400;
        }
        Config.B = v;
        ((ct)j0.get(0x7F0B00B1)).a();  // id:config_number_locale
        Config.g = ((ct)j0.get(0x7F0B00A8)).d;  // id:config_fill_toolbar
        Config.h = ((ct)j0.get(0x7F0B0093)).d;  // id:config_ram
        Config.i = ((ct)j0.get(0x7F0B0081)).d;  // id:config_ranges
        Config.k = ((ct)j0.get(0x7F0B008D)).d;  // id:config_search_helper
        Config.l = ((ct)j0.get(0x7F0B0090)).d;  // id:config_speeds_params
        Config.m = ((ct)j0.get(0x7F0B008B)).d;  // id:config_freeze_interval
        Config.n = ((ct)j0.get(0x7F0B008E)).d;  // id:config_saved_list_updates_interval
        Config.o = ((ct)j0.get(0x7F0B00A9)).d;  // id:config_icons_size
        Config.p = ((ct)j0.get(0x7F0B00A6)).d;  // id:config_toolbars
        Config.q = ((ct)j0.get(0x7F0B00A4)).d;  // id:config_use_small_list_items
        Config.r = ((ct)j0.get(0x7F0B00A5)).d;  // id:config_backgrounds
        Config.s = ((ct)j0.get(0x7F0B00BB)).e();  // id:config_xor_key
        Config.t = ((ct)j0.get(0x7F0B00BD)).d;  // id:config_float_type
        Config.u = ((ct)j0.get(0x7F0B00BE)).d;  // id:config_float_flags
        Config.v = ((ct)j0.get(0x7F0B00C0)).d;  // id:config_time_jump_last
        Config.w = ((ct)j0.get(0x7F0B009D)).d;  // id:config_hot_key
        Config.x = ((ct)j0.get(0x7F0B009E)).d;  // id:config_history_limit
        Config.y = ((ct)j0.get(0x7F0B00C1)).d;  // id:config_copy_params
        Config.z = ((ct)j0.get(0x7F0B00BC)).d;  // id:config_context_source
        long v16 = 0x1FFFFFL & ((long)((ct)j0.get(0x7F0B0082)).d);  // id:config_speedhack_intercept
        Config.j = ((long)((ct)j0.get(0x7F0B0085)).d) << 21 | v16;  // id:config_unrandomizer_intercept
    }

    private static void a(SharedPreferences sharedPreferences0) {
        Config.c = sharedPreferences0.getLong("ignore", 0L);
        Config.d = sharedPreferences0.getLong("memory-from", 0L);
        Config.e = sharedPreferences0.getLong("memory-to", -1L);
        Config.f = sharedPreferences0.getLong("nearby-distance", 0x200L);
        for(int v = 0; v < Config.b.length; ++v) {
            Config.b[v] = sharedPreferences0.getLong("toolbar-buttons-" + v, -1L);
        }
        if(MainService.c) {
            MainService.instance.s();
        }
    }

    private static void a(qw qw0) {
        qw0.a("ignore", Config.c, 0L);
        qw0.a("memory-from", Config.d, 0L);
        qw0.a("memory-to", Config.e, -1L);
        qw0.a("nearby-distance", Config.f, 0x200L);
        for(int v = 0; v < Config.b.length; ++v) {
            qw0.a("toolbar-buttons-" + v, Config.b[v], -1L);
        }
    }

    public static void a(int[] arr_v) {
        int v3;
        if(arr_v == null || arr_v.length == 0) {
            return;
        }
        int[] arr_v1 = Config.a;
        int v = arr_v1.length + arr_v.length;
        int[] arr_v2 = new int[v];
        System.arraycopy(arr_v1, 0, arr_v2, 0, arr_v1.length);
        System.arraycopy(arr_v, 0, arr_v2, arr_v1.length, arr_v.length);
        Arrays.sort(arr_v2);
        int v1 = 1;
        int v2;
        for(v2 = 1; v1 < v; v2 = v3) {
            if(arr_v2[v1] == arr_v2[v1 - 1]) {
                v3 = v2;
            }
            else {
                v3 = v2 + 1;
                arr_v2[v2] = arr_v2[v1];
            }
            ++v1;
        }
        Config.a = Arrays.copyOf(arr_v2, v2);
    }

    public static int b(int v) [...] // Inlined contents

    public static ImageView b(ImageView imageView0, int v) {
        imageView0.setAdjustViewBounds(false);
        imageView0.setMinimumWidth(v);
        imageView0.setMinimumHeight(v);
        ViewGroup.LayoutParams viewGroup$LayoutParams0 = imageView0.getLayoutParams();
        if(viewGroup$LayoutParams0 != null) {
            viewGroup$LayoutParams0.width = v;
            viewGroup$LayoutParams0.height = v;
            imageView0.setLayoutParams(viewGroup$LayoutParams0);
        }
        imageView0.setScaleType(ImageView.ScaleType.FIT_CENTER);
        imageView0.invalidate();
        return imageView0;
    }

    public static void b() {
        String s2;
        SharedPreferences sharedPreferences0 = Tools.s();
        Config.a(sharedPreferences0);
        String s = Config.e();
        int v = 0;
        boolean z = false;
        while(v < Config.H.size()) {
            ct ct0 = (ct)Config.H.valueAt(v);
            String s1 = ct0.c;
            if(!ct0.g) {
                s2 = s1;
                try {
                label_13:
                    ct0.d = sharedPreferences0.getInt(s2, ct0.b);
                }
                catch(ClassCastException unused_ex) {
                    try {
                        ct0.d = sharedPreferences0.getBoolean(ct0.c, ct0.b == 1) ? 1 : 0;
                        z = true;
                    }
                    catch(ClassCastException classCastException0) {
                        la.c(("Failed load data for " + ct0.c), classCastException0);
                    }
                }
                if(ct0.e) {
                    try {
                        ct0.f = sharedPreferences0.getInt(s2 + "-2", 0);
                    }
                    catch(ClassCastException classCastException1) {
                        la.c(("Failed load data2 for " + ct0.c), classCastException1);
                    }
                }
            }
            else if(s != null) {
                s2 = String.valueOf(s) + '-' + s1;
                goto label_13;
            }
            ++v;
        }
        if(z) {
            Config.c();
            return;
        }
        Config.f();
    }

    static String c(int v) {
        switch(v) {
            case 0: {
                return qk.a(0x7F07009C);  // string:no "No"
            }
            case 1: {
                return "KEY_ESC";
            }
            case 2: {
                return "KEY_1";
            }
            case 3: {
                return "KEY_2";
            }
            case 4: {
                return "KEY_3";
            }
            case 5: {
                return "KEY_4";
            }
            case 6: {
                return "KEY_5";
            }
            case 7: {
                return "KEY_6";
            }
            case 8: {
                return "KEY_7";
            }
            case 9: {
                return "KEY_8";
            }
            case 10: {
                return "KEY_9";
            }
            case 11: {
                return "KEY_0";
            }
            case 12: {
                return "KEY_MINUS";
            }
            case 13: {
                return "KEY_EQUAL";
            }
            case 14: {
                return "KEY_BACKSPACE";
            }
            case 15: {
                return "KEY_TAB";
            }
            case 16: {
                return "KEY_Q";
            }
            case 17: {
                return "KEY_W";
            }
            case 18: {
                return "KEY_E";
            }
            case 19: {
                return "KEY_R";
            }
            case 20: {
                return "KEY_T";
            }
            case 21: {
                return "KEY_Y";
            }
            case 22: {
                return "KEY_U";
            }
            case 23: {
                return "KEY_I";
            }
            case 24: {
                return "KEY_O";
            }
            case 25: {
                return "KEY_P";
            }
            case 26: {
                return "KEY_LEFTBRACE";
            }
            case 27: {
                return "KEY_RIGHTBRACE";
            }
            case 28: {
                return "KEY_ENTER";
            }
            case 29: {
                return "KEY_LEFTCTRL";
            }
            case 30: {
                return "KEY_A";
            }
            case 0x1F: {
                return "KEY_S";
            }
            case 0x20: {
                return "KEY_D";
            }
            case 33: {
                return "KEY_F";
            }
            case 34: {
                return "KEY_G";
            }
            case 35: {
                return "KEY_H";
            }
            case 36: {
                return "KEY_J";
            }
            case 37: {
                return "KEY_K";
            }
            case 38: {
                return "KEY_L";
            }
            case 39: {
                return "KEY_SEMICOLON";
            }
            case 40: {
                return "KEY_APOSTROPHE";
            }
            case 41: {
                return "KEY_GRAVE";
            }
            case 42: {
                return "KEY_LEFTSHIFT";
            }
            case 43: {
                return "KEY_BACKSLASH";
            }
            case 44: {
                return "KEY_Z";
            }
            case 45: {
                return "KEY_X";
            }
            case 46: {
                return "KEY_C";
            }
            case 0x2F: {
                return "KEY_V";
            }
            case 0x30: {
                return "KEY_B";
            }
            case 49: {
                return "KEY_N";
            }
            case 50: {
                return "KEY_M";
            }
            case 51: {
                return "KEY_COMMA";
            }
            case 52: {
                return "KEY_DOT";
            }
            case 53: {
                return "KEY_SLASH";
            }
            case 54: {
                return "KEY_RIGHTSHIFT";
            }
            case 55: {
                return "KEY_KPASTERISK";
            }
            case 56: {
                return "KEY_LEFTALT";
            }
            case 57: {
                return "KEY_SPACE";
            }
            case 58: {
                return "KEY_CAPSLOCK";
            }
            case 59: {
                return "KEY_F1";
            }
            case 60: {
                return "KEY_F2";
            }
            case 61: {
                return "KEY_F3";
            }
            case 62: {
                return "KEY_F4";
            }
            case 0x3F: {
                return "KEY_F5";
            }
            case 0x40: {
                return "KEY_F6";
            }
            case 65: {
                return "KEY_F7";
            }
            case 66: {
                return "KEY_F8";
            }
            case 67: {
                return "KEY_F9";
            }
            case 68: {
                return "KEY_F10";
            }
            case 69: {
                return "KEY_NUMLOCK";
            }
            case 70: {
                return "KEY_SCROLLLOCK";
            }
            case 71: {
                return "KEY_KP7";
            }
            case 72: {
                return "KEY_KP8";
            }
            case 73: {
                return "KEY_KP9";
            }
            case 74: {
                return "KEY_KPMINUS";
            }
            case 75: {
                return "KEY_KP4";
            }
            case 76: {
                return "KEY_KP5";
            }
            case 77: {
                return "KEY_KP6";
            }
            case 78: {
                return "KEY_KPPLUS";
            }
            case 0x4F: {
                return "KEY_KP1";
            }
            case 80: {
                return "KEY_KP2";
            }
            case 81: {
                return "KEY_KP3";
            }
            case 82: {
                return "KEY_KP0";
            }
            case 83: {
                return "KEY_KPDOT";
            }
            case 85: {
                return "KEY_ZENKAKUHANKAKU";
            }
            case 86: {
                return "KEY_102ND";
            }
            case 87: {
                return "KEY_F11";
            }
            case 88: {
                return "KEY_F12";
            }
            case 89: {
                return "KEY_RO";
            }
            case 90: {
                return "KEY_KATAKANA";
            }
            case 91: {
                return "KEY_HIRAGANA";
            }
            case 92: {
                return "KEY_HENKAN";
            }
            case 93: {
                return "KEY_KATAKANAHIRAGANA";
            }
            case 94: {
                return "KEY_MUHENKAN";
            }
            case 0x5F: {
                return "KEY_KPJPCOMMA";
            }
            case 0x60: {
                return "KEY_KPENTER";
            }
            case 97: {
                return "KEY_RIGHTCTRL";
            }
            case 98: {
                return "KEY_KPSLASH";
            }
            case 99: {
                return "KEY_SYSRQ";
            }
            case 100: {
                return "KEY_RIGHTALT";
            }
            case 101: {
                return "KEY_LINEFEED";
            }
            case 102: {
                return "KEY_HOME";
            }
            case 103: {
                return "KEY_UP";
            }
            case 104: {
                return "KEY_PAGEUP";
            }
            case 105: {
                return "KEY_LEFT";
            }
            case 106: {
                return "KEY_RIGHT";
            }
            case 107: {
                return "KEY_END";
            }
            case 108: {
                return "KEY_DOWN";
            }
            case 109: {
                return "KEY_PAGEDOWN";
            }
            case 110: {
                return "KEY_INSERT";
            }
            case 0x6F: {
                return "KEY_DELETE";
            }
            case 0x70: {
                return "KEY_MACRO";
            }
            case 0x71: {
                return "KEY_MUTE";
            }
            case 0x72: {
                return "KEY_VOLUMEDOWN";
            }
            case 0x73: {
                return "KEY_VOLUMEUP";
            }
            case 0x74: {
                return "KEY_POWER";
            }
            case 0x75: {
                return "KEY_KPEQUAL";
            }
            case 0x76: {
                return "KEY_KPPLUSMINUS";
            }
            case 0x77: {
                return "KEY_PAUSE";
            }
            case 120: {
                return "KEY_SCALE";
            }
            case 0x79: {
                return "KEY_KPCOMMA";
            }
            case 0x7A: {
                return "KEY_HANGEUL";
            }
            case 0x7B: {
                return "KEY_HANJA";
            }
            case 0x7C: {
                return "KEY_YEN";
            }
            case 0x7D: {
                return "KEY_LEFTMETA";
            }
            case 0x7E: {
                return "KEY_RIGHTMETA";
            }
            case 0x7F: {
                return "KEY_COMPOSE";
            }
            case 0x80: {
                return "KEY_STOP";
            }
            case 0x81: {
                return "KEY_AGAIN";
            }
            case 130: {
                return "KEY_PROPS";
            }
            case 0x83: {
                return "KEY_UNDO";
            }
            case 0x84: {
                return "KEY_FRONT";
            }
            case 0x85: {
                return "KEY_COPY";
            }
            case 0x86: {
                return "KEY_OPEN";
            }
            case 0x87: {
                return "KEY_PASTE";
            }
            case 0x88: {
                return "KEY_FIND";
            }
            case 0x89: {
                return "KEY_CUT";
            }
            case 0x8A: {
                return "KEY_HELP";
            }
            case 0x8B: {
                return "KEY_MENU";
            }
            case 140: {
                return "KEY_CALC";
            }
            case 0x8D: {
                return "KEY_SETUP";
            }
            case 0x8E: {
                return "KEY_SLEEP";
            }
            case 0x8F: {
                return "KEY_WAKEUP";
            }
            case 0x90: {
                return "KEY_FILE";
            }
            case 0x91: {
                return "KEY_SENDFILE";
            }
            case 0x92: {
                return "KEY_DELETEFILE";
            }
            case 0x93: {
                return "KEY_XFER";
            }
            case 0x94: {
                return "KEY_PROG1";
            }
            case 0x95: {
                return "KEY_PROG2";
            }
            case 150: {
                return "KEY_WWW";
            }
            case 0x97: {
                return "KEY_MSDOS";
            }
            case 0x98: {
                return "KEY_SCREENLOCK";
            }
            case 0x99: {
                return "KEY_DIRECTION";
            }
            case 0x9A: {
                return "KEY_CYCLEWINDOWS";
            }
            case 0x9B: {
                return "KEY_MAIL";
            }
            case 0x9C: {
                return "KEY_BOOKMARKS";
            }
            case 0x9D: {
                return "KEY_COMPUTER";
            }
            case 0x9E: {
                return "KEY_BACK";
            }
            case 0x9F: {
                return "KEY_FORWARD";
            }
            case 0xA0: {
                return "KEY_CLOSECD";
            }
            case 0xA1: {
                return "KEY_EJECTCD";
            }
            case 0xA2: {
                return "KEY_EJECTCLOSECD";
            }
            case 0xA3: {
                return "KEY_NEXTSONG";
            }
            case 0xA4: {
                return "KEY_PLAYPAUSE";
            }
            case 0xA5: {
                return "KEY_PREVIOUSSONG";
            }
            case 0xA6: {
                return "KEY_STOPCD";
            }
            case 0xA7: {
                return "KEY_RECORD";
            }
            case 0xA8: {
                return "KEY_REWIND";
            }
            case 0xA9: {
                return "KEY_PHONE";
            }
            case 170: {
                return "KEY_ISO";
            }
            case 0xAB: {
                return "KEY_CONFIG";
            }
            case 0xAC: {
                return "KEY_HOMEPAGE";
            }
            case 0xAD: {
                return "KEY_REFRESH";
            }
            case 0xAE: {
                return "KEY_EXIT";
            }
            case 0xAF: {
                return "KEY_MOVE";
            }
            case 0xB0: {
                return "KEY_EDIT";
            }
            case 0xB1: {
                return "KEY_SCROLLUP";
            }
            case 0xB2: {
                return "KEY_SCROLLDOWN";
            }
            case 0xB3: {
                return "KEY_KPLEFTPAREN";
            }
            case 180: {
                return "KEY_KPRIGHTPAREN";
            }
            case 0xB5: {
                return "KEY_NEW";
            }
            case 0xB6: {
                return "KEY_REDO";
            }
            case 0xB7: {
                return "KEY_F13";
            }
            case 0xB8: {
                return "KEY_F14";
            }
            case 0xB9: {
                return "KEY_F15";
            }
            case 0xBA: {
                return "KEY_F16";
            }
            case 0xBB: {
                return "KEY_F17";
            }
            case 0xBC: {
                return "KEY_F18";
            }
            case 0xBD: {
                return "KEY_F19";
            }
            case 190: {
                return "KEY_F20";
            }
            case 0xBF: {
                return "KEY_F21";
            }
            case 0xC0: {
                return "KEY_F22";
            }
            case 0xC1: {
                return "KEY_F23";
            }
            case 0xC2: {
                return "KEY_F24";
            }
            case 200: {
                return "KEY_PLAYCD";
            }
            case 201: {
                return "KEY_PAUSECD";
            }
            case 202: {
                return "KEY_PROG3";
            }
            case 203: {
                return "KEY_PROG4";
            }
            case 204: {
                return "KEY_DASHBOARD";
            }
            case 205: {
                return "KEY_SUSPEND";
            }
            case 206: {
                return "KEY_CLOSE";
            }
            case 0xCF: {
                return "KEY_PLAY";
            }
            case 0xD0: {
                return "KEY_FASTFORWARD";
            }
            case 209: {
                return "KEY_BASSBOOST";
            }
            case 210: {
                return "KEY_PRINT";
            }
            case 0xD3: {
                return "KEY_HP";
            }
            case 0xD4: {
                return "KEY_CAMERA";
            }
            case 0xD5: {
                return "KEY_SOUND";
            }
            case 0xD6: {
                return "KEY_QUESTION";
            }
            case 0xD7: {
                return "KEY_EMAIL";
            }
            case 0xD8: {
                return "KEY_CHAT";
            }
            case 0xD9: {
                return "KEY_SEARCH";
            }
            case 0xDA: {
                return "KEY_CONNECT";
            }
            case 0xDB: {
                return "KEY_FINANCE";
            }
            case 220: {
                return "KEY_SPORT";
            }
            case 0xDD: {
                return "KEY_SHOP";
            }
            case 0xDE: {
                return "KEY_ALTERASE";
            }
            case 0xDF: {
                return "KEY_CANCEL";
            }
            case 0xE0: {
                return "KEY_BRIGHTNESSDOWN";
            }
            case 0xE1: {
                return "KEY_BRIGHTNESSUP";
            }
            case 0xE2: {
                return "KEY_MEDIA";
            }
            case 0xE3: {
                return "KEY_SWITCHVIDEOMODE";
            }
            case 0xE4: {
                return "KEY_KBDILLUMTOGGLE";
            }
            case 0xE5: {
                return "KEY_KBDILLUMDOWN";
            }
            case 230: {
                return "KEY_KBDILLUMUP";
            }
            case 0xE7: {
                return "KEY_SEND";
            }
            case 0xE8: {
                return "KEY_REPLY";
            }
            case 0xE9: {
                return "KEY_FORWARDMAIL";
            }
            case 0xEA: {
                return "KEY_SAVE";
            }
            case 0xEB: {
                return "KEY_DOCUMENTS";
            }
            case 0xEC: {
                return "KEY_BATTERY";
            }
            case 0xED: {
                return "KEY_BLUETOOTH";
            }
            case 0xEE: {
                return "KEY_WLAN";
            }
            case 0xEF: {
                return "KEY_UWB";
            }
            case 0xF0: {
                return "KEY_UNKNOWN";
            }
            case 0xF1: {
                return "KEY_VIDEO_NEXT";
            }
            case 0xF2: {
                return "KEY_VIDEO_PREV";
            }
            case 0xF3: {
                return "KEY_BRIGHTNESS_CYCLE";
            }
            case 0xF4: {
                return "KEY_BRIGHTNESS_AUTO";
            }
            case 0xF5: {
                return "KEY_DISPLAY_OFF";
            }
            case 0xF6: {
                return "KEY_WWAN";
            }
            case 0xF7: {
                return "KEY_RFKILL";
            }
            case 0xF8: {
                return "KEY_MICMUTE";
            }
            case 0x100: {
                return "BTN_0";
            }
            case 0x101: {
                return "BTN_1";
            }
            case 0x102: {
                return "BTN_2";
            }
            case 0x103: {
                return "BTN_3";
            }
            case 260: {
                return "BTN_4";
            }
            case 0x105: {
                return "BTN_5";
            }
            case 0x106: {
                return "BTN_6";
            }
            case 0x107: {
                return "BTN_7";
            }
            case 0x108: {
                return "BTN_8";
            }
            case 0x109: {
                return "BTN_9";
            }
            case 0x110: {
                return "BTN_LEFT";
            }
            case 273: {
                return "BTN_RIGHT";
            }
            case 274: {
                return "BTN_MIDDLE";
            }
            case 275: {
                return "BTN_SIDE";
            }
            case 276: {
                return "BTN_EXTRA";
            }
            case 277: {
                return "BTN_FORWARD";
            }
            case 278: {
                return "BTN_BACK";
            }
            case 279: {
                return "BTN_TASK";
            }
            case 0x120: {
                return "BTN_TRIGGER";
            }
            case 289: {
                return "BTN_THUMB";
            }
            case 290: {
                return "BTN_THUMB2";
            }
            case 291: {
                return "BTN_TOP";
            }
            case 292: {
                return "BTN_TOP2";
            }
            case 293: {
                return "BTN_PINKIE";
            }
            case 294: {
                return "BTN_BASE";
            }
            case 295: {
                return "BTN_BASE2";
            }
            case 296: {
                return "BTN_BASE3";
            }
            case 297: {
                return "BTN_BASE4";
            }
            case 298: {
                return "BTN_BASE5";
            }
            case 299: {
                return "BTN_BASE6";
            }
            case 303: {
                return "BTN_DEAD";
            }
            case 304: {
                return "BTN_A";
            }
            case 305: {
                return "BTN_B";
            }
            case 306: {
                return "BTN_C";
            }
            case 307: {
                return "BTN_X";
            }
            case 308: {
                return "BTN_Y";
            }
            case 309: {
                return "BTN_Z";
            }
            case 310: {
                return "BTN_TL";
            }
            case 311: {
                return "BTN_TR";
            }
            case 312: {
                return "BTN_TL2";
            }
            case 313: {
                return "BTN_TR2";
            }
            case 314: {
                return "BTN_SELECT";
            }
            case 315: {
                return "BTN_START";
            }
            case 316: {
                return "BTN_MODE";
            }
            case 317: {
                return "BTN_THUMBL";
            }
            case 318: {
                return "BTN_THUMBR";
            }
            case 320: {
                return "BTN_TOOL_PEN";
            }
            case 321: {
                return "BTN_TOOL_RUBBER";
            }
            case 322: {
                return "BTN_TOOL_BRUSH";
            }
            case 323: {
                return "BTN_TOOL_PENCIL";
            }
            case 324: {
                return "BTN_TOOL_AIRBRUSH";
            }
            case 325: {
                return "BTN_TOOL_FINGER";
            }
            case 326: {
                return "BTN_TOOL_MOUSE";
            }
            case 327: {
                return "BTN_TOOL_LENS";
            }
            case 328: {
                return "BTN_TOOL_QUINTTAP";
            }
            case 330: {
                return "BTN_TOUCH";
            }
            case 331: {
                return "BTN_STYLUS";
            }
            case 332: {
                return "BTN_STYLUS2";
            }
            case 333: {
                return "BTN_TOOL_DOUBLETAP";
            }
            case 334: {
                return "BTN_TOOL_TRIPLETAP";
            }
            case 0x14F: {
                return "BTN_TOOL_QUADTAP";
            }
            case 0x150: {
                return "BTN_WHEEL";
            }
            case 337: {
                return "BTN_GEAR_UP";
            }
            case 0x160: {
                return "KEY_OK";
            }
            case 353: {
                return "KEY_SELECT";
            }
            case 354: {
                return "KEY_GOTO";
            }
            case 355: {
                return "KEY_CLEAR";
            }
            case 356: {
                return "KEY_POWER2";
            }
            case 357: {
                return "KEY_OPTION";
            }
            case 358: {
                return "KEY_INFO";
            }
            case 359: {
                return "KEY_TIME";
            }
            case 360: {
                return "KEY_VENDOR";
            }
            case 361: {
                return "KEY_ARCHIVE";
            }
            case 362: {
                return "KEY_PROGRAM";
            }
            case 363: {
                return "KEY_CHANNEL";
            }
            case 364: {
                return "KEY_FAVORITES";
            }
            case 365: {
                return "KEY_EPG";
            }
            case 366: {
                return "KEY_PVR";
            }
            case 0x16F: {
                return "KEY_MHP";
            }
            case 0x170: {
                return "KEY_LANGUAGE";
            }
            case 369: {
                return "KEY_TITLE";
            }
            case 370: {
                return "KEY_SUBTITLE";
            }
            case 371: {
                return "KEY_ANGLE";
            }
            case 372: {
                return "KEY_ZOOM";
            }
            case 373: {
                return "KEY_MODE";
            }
            case 374: {
                return "KEY_KEYBOARD";
            }
            case 375: {
                return "KEY_SCREEN";
            }
            case 376: {
                return "KEY_PC";
            }
            case 377: {
                return "KEY_TV";
            }
            case 378: {
                return "KEY_TV2";
            }
            case 379: {
                return "KEY_VCR";
            }
            case 380: {
                return "KEY_VCR2";
            }
            case 381: {
                return "KEY_SAT";
            }
            case 382: {
                return "KEY_SAT2";
            }
            case 0x17F: {
                return "KEY_CD";
            }
            case 0x180: {
                return "KEY_TAPE";
            }
            case 385: {
                return "KEY_RADIO";
            }
            case 386: {
                return "KEY_TUNER";
            }
            case 387: {
                return "KEY_PLAYER";
            }
            case 388: {
                return "KEY_TEXT";
            }
            case 389: {
                return "KEY_DVD";
            }
            case 390: {
                return "KEY_AUX";
            }
            case 391: {
                return "KEY_MP3";
            }
            case 392: {
                return "KEY_AUDIO";
            }
            case 393: {
                return "KEY_VIDEO";
            }
            case 394: {
                return "KEY_DIRECTORY";
            }
            case 395: {
                return "KEY_LIST";
            }
            case 396: {
                return "KEY_MEMO";
            }
            case 397: {
                return "KEY_CALENDAR";
            }
            case 398: {
                return "KEY_RED";
            }
            case 0x18F: {
                return "KEY_GREEN";
            }
            case 400: {
                return "KEY_YELLOW";
            }
            case 401: {
                return "KEY_BLUE";
            }
            case 402: {
                return "KEY_CHANNELUP";
            }
            case 403: {
                return "KEY_CHANNELDOWN";
            }
            case 404: {
                return "KEY_FIRST";
            }
            case 405: {
                return "KEY_LAST";
            }
            case 406: {
                return "KEY_AB";
            }
            case 407: {
                return "KEY_NEXT";
            }
            case 408: {
                return "KEY_RESTART";
            }
            case 409: {
                return "KEY_SLOW";
            }
            case 410: {
                return "KEY_SHUFFLE";
            }
            case 411: {
                return "KEY_BREAK";
            }
            case 412: {
                return "KEY_PREVIOUS";
            }
            case 413: {
                return "KEY_DIGITS";
            }
            case 414: {
                return "KEY_TEEN";
            }
            case 0x19F: {
                return "KEY_TWEN";
            }
            case 0x1A0: {
                return "KEY_VIDEOPHONE";
            }
            case 417: {
                return "KEY_GAMES";
            }
            case 418: {
                return "KEY_ZOOMIN";
            }
            case 419: {
                return "KEY_ZOOMOUT";
            }
            case 420: {
                return "KEY_ZOOMRESET";
            }
            case 421: {
                return "KEY_WORDPROCESSOR";
            }
            case 422: {
                return "KEY_EDITOR";
            }
            case 423: {
                return "KEY_SPREADSHEET";
            }
            case 424: {
                return "KEY_GRAPHICSEDITOR";
            }
            case 425: {
                return "KEY_PRESENTATION";
            }
            case 426: {
                return "KEY_DATABASE";
            }
            case 427: {
                return "KEY_NEWS";
            }
            case 428: {
                return "KEY_VOICEMAIL";
            }
            case 429: {
                return "KEY_ADDRESSBOOK";
            }
            case 430: {
                return "KEY_MESSENGER";
            }
            case 0x1AF: {
                return "KEY_DISPLAYTOGGLE";
            }
            case 0x1B0: {
                return "KEY_SPELLCHECK";
            }
            case 433: {
                return "KEY_LOGOFF";
            }
            case 434: {
                return "KEY_DOLLAR";
            }
            case 435: {
                return "KEY_EURO";
            }
            case 436: {
                return "KEY_FRAMEBACK";
            }
            case 437: {
                return "KEY_FRAMEFORWARD";
            }
            case 438: {
                return "KEY_CONTEXT_MENU";
            }
            case 439: {
                return "KEY_MEDIA_REPEAT";
            }
            case 440: {
                return "KEY_10CHANNELSUP";
            }
            case 441: {
                return "KEY_10CHANNELSDOWN";
            }
            case 442: {
                return "KEY_IMAGES";
            }
            case 0x1C0: {
                return "KEY_DEL_EOL";
            }
            case 449: {
                return "KEY_DEL_EOS";
            }
            case 450: {
                return "KEY_INS_LINE";
            }
            case 451: {
                return "KEY_DEL_LINE";
            }
            case 0x1D0: {
                return "KEY_FN";
            }
            case 465: {
                return "KEY_FN_ESC";
            }
            case 466: {
                return "KEY_FN_F1";
            }
            case 467: {
                return "KEY_FN_F2";
            }
            case 468: {
                return "KEY_FN_F3";
            }
            case 469: {
                return "KEY_FN_F4";
            }
            case 470: {
                return "KEY_FN_F5";
            }
            case 471: {
                return "KEY_FN_F6";
            }
            case 472: {
                return "KEY_FN_F7";
            }
            case 473: {
                return "KEY_FN_F8";
            }
            case 474: {
                return "KEY_FN_F9";
            }
            case 475: {
                return "KEY_FN_F10";
            }
            case 476: {
                return "KEY_FN_F11";
            }
            case 477: {
                return "KEY_FN_F12";
            }
            case 478: {
                return "KEY_FN_1";
            }
            case 0x1DF: {
                return "KEY_FN_2";
            }
            case 480: {
                return "KEY_FN_D";
            }
            case 481: {
                return "KEY_FN_E";
            }
            case 482: {
                return "KEY_FN_F";
            }
            case 483: {
                return "KEY_FN_S";
            }
            case 484: {
                return "KEY_FN_B";
            }
            case 0x1F1: {
                return "KEY_BRL_DOT1";
            }
            case 0x1F2: {
                return "KEY_BRL_DOT2";
            }
            case 0x1F3: {
                return "KEY_BRL_DOT3";
            }
            case 500: {
                return "KEY_BRL_DOT4";
            }
            case 501: {
                return "KEY_BRL_DOT5";
            }
            case 502: {
                return "KEY_BRL_DOT6";
            }
            case 503: {
                return "KEY_BRL_DOT7";
            }
            case 504: {
                return "KEY_BRL_DOT8";
            }
            case 505: {
                return "KEY_BRL_DOT9";
            }
            case 506: {
                return "KEY_BRL_DOT10";
            }
            case 0x200: {
                return "KEY_NUMERIC_0";
            }
            case 0x201: {
                return "KEY_NUMERIC_1";
            }
            case 0x202: {
                return "KEY_NUMERIC_2";
            }
            case 0x203: {
                return "KEY_NUMERIC_3";
            }
            case 0x204: {
                return "KEY_NUMERIC_4";
            }
            case 0x205: {
                return "KEY_NUMERIC_5";
            }
            case 0x206: {
                return "KEY_NUMERIC_6";
            }
            case 0x207: {
                return "KEY_NUMERIC_7";
            }
            case 520: {
                return "KEY_NUMERIC_8";
            }
            case 0x209: {
                return "KEY_NUMERIC_9";
            }
            case 0x20A: {
                return "KEY_NUMERIC_STAR";
            }
            case 0x20B: {
                return "KEY_NUMERIC_POUND";
            }
            case 0x210: {
                return "KEY_CAMERA_FOCUS";
            }
            case 529: {
                return "KEY_WPS_BUTTON";
            }
            case 530: {
                return "KEY_TOUCHPAD_TOGGLE";
            }
            case 531: {
                return "KEY_TOUCHPAD_ON";
            }
            case 532: {
                return "KEY_TOUCHPAD_OFF";
            }
            case 533: {
                return "KEY_CAMERA_ZOOMIN";
            }
            case 534: {
                return "KEY_CAMERA_ZOOMOUT";
            }
            case 535: {
                return "KEY_CAMERA_UP";
            }
            case 536: {
                return "KEY_CAMERA_DOWN";
            }
            case 537: {
                return "KEY_CAMERA_LEFT";
            }
            case 538: {
                return "KEY_CAMERA_RIGHT";
            }
            case 539: {
                return "KEY_ATTENDANT_ON";
            }
            case 540: {
                return "KEY_ATTENDANT_OFF";
            }
            case 541: {
                return "KEY_ATTENDANT_TOGGLE";
            }
            case 542: {
                return "KEY_LIGHTS_TOGGLE";
            }
            case 0x220: {
                return "BTN_DPAD_UP";
            }
            case 545: {
                return "BTN_DPAD_DOWN";
            }
            case 546: {
                return "BTN_DPAD_LEFT";
            }
            case 547: {
                return "BTN_DPAD_RIGHT";
            }
            case 560: {
                return "KEY_ALS_TOGGLE";
            }
            case 0x240: {
                return "KEY_BUTTONCONFIG";
            }
            case 577: {
                return "KEY_TASKMANAGER";
            }
            case 578: {
                return "KEY_JOURNAL";
            }
            case 579: {
                return "KEY_CONTROLPANEL";
            }
            case 580: {
                return "KEY_APPSELECT";
            }
            case 581: {
                return "KEY_SCREENSAVER";
            }
            case 582: {
                return "KEY_VOICECOMMAND";
            }
            case 0x250: {
                return "KEY_BRIGHTNESS_MIN";
            }
            case 593: {
                return "KEY_BRIGHTNESS_MAX";
            }
            case 704: {
                return "BTN_TRIGGER_HAPPY1";
            }
            case 705: {
                return "BTN_TRIGGER_HAPPY2";
            }
            case 706: {
                return "BTN_TRIGGER_HAPPY3";
            }
            case 707: {
                return "BTN_TRIGGER_HAPPY4";
            }
            case 708: {
                return "BTN_TRIGGER_HAPPY5";
            }
            case 709: {
                return "BTN_TRIGGER_HAPPY6";
            }
            case 710: {
                return "BTN_TRIGGER_HAPPY7";
            }
            case 711: {
                return "BTN_TRIGGER_HAPPY8";
            }
            case 712: {
                return "BTN_TRIGGER_HAPPY9";
            }
            case 713: {
                return "BTN_TRIGGER_HAPPY10";
            }
            case 714: {
                return "BTN_TRIGGER_HAPPY11";
            }
            case 715: {
                return "BTN_TRIGGER_HAPPY12";
            }
            case 716: {
                return "BTN_TRIGGER_HAPPY13";
            }
            case 717: {
                return "BTN_TRIGGER_HAPPY14";
            }
            case 718: {
                return "BTN_TRIGGER_HAPPY15";
            }
            case 0x2CF: {
                return "BTN_TRIGGER_HAPPY16";
            }
            case 720: {
                return "BTN_TRIGGER_HAPPY17";
            }
            case 721: {
                return "BTN_TRIGGER_HAPPY18";
            }
            case 722: {
                return "BTN_TRIGGER_HAPPY19";
            }
            case 723: {
                return "BTN_TRIGGER_HAPPY20";
            }
            case 724: {
                return "BTN_TRIGGER_HAPPY21";
            }
            case 725: {
                return "BTN_TRIGGER_HAPPY22";
            }
            case 726: {
                return "BTN_TRIGGER_HAPPY23";
            }
            case 727: {
                return "BTN_TRIGGER_HAPPY24";
            }
            case 728: {
                return "BTN_TRIGGER_HAPPY25";
            }
            case 729: {
                return "BTN_TRIGGER_HAPPY26";
            }
            case 730: {
                return "BTN_TRIGGER_HAPPY27";
            }
            case 731: {
                return "BTN_TRIGGER_HAPPY28";
            }
            case 732: {
                return "BTN_TRIGGER_HAPPY29";
            }
            case 733: {
                return "BTN_TRIGGER_HAPPY30";
            }
            case 734: {
                return "BTN_TRIGGER_HAPPY31";
            }
            case 0x2DF: {
                return "BTN_TRIGGER_HAPPY32";
            }
            case 0x2E0: {
                return "BTN_TRIGGER_HAPPY33";
            }
            case 737: {
                return "BTN_TRIGGER_HAPPY34";
            }
            case 738: {
                return "BTN_TRIGGER_HAPPY35";
            }
            case 739: {
                return "BTN_TRIGGER_HAPPY36";
            }
            case 740: {
                return "BTN_TRIGGER_HAPPY37";
            }
            case 741: {
                return "BTN_TRIGGER_HAPPY38";
            }
            case 742: {
                return "BTN_TRIGGER_HAPPY39";
            }
            case 743: {
                return "BTN_TRIGGER_HAPPY40";
            }
            default: {
                return "UNKNOWN_" + v;
            }
        }
    }

    public static void c() {
        qw qw0 = new qw();
        Config.a(qw0);
        String s = Config.e();
        int v = 0;
        while(v < Config.H.size()) {
            ct ct0 = (ct)Config.H.valueAt(v);
            String s1 = ct0.c;
            if(!ct0.g) {
            label_10:
                qw0.a(s1, ct0.d, ct0.b);
                if(ct0.e) {
                    qw0.a(s1 + "-2", ct0.f, 0);
                }
            }
            else if(s != null) {
                s1 = String.valueOf(s) + '-' + s1;
                goto label_10;
            }
            ++v;
        }
        qw0.commit();
        Config.f();
    }

    public static int d() [...] // 潜在的解密器

    private static String e() {
        qh qh0 = MainService.instance.ap;
        return qh0 == null ? null : qh0.c;
    }

    private static void f() {
        Config.a();
        if(MainService.instance != null) {
            if(MainService.instance.S != null) {
                MainService.instance.a(MainService.instance.S.getAdapter());
                MainService.instance.w();
            }
            MainService.instance.k.t();
            MainService.instance.E();
        }
    }
}

