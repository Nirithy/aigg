package android.ext;

import android.app.AlertDialog;
import android.c.b;
import android.content.ComponentName;
import android.content.DialogInterface.OnClickListener;
import android.content.SharedPreferences.Editor;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Build;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.util.DisplayMetrics;
import android.view.View.OnClickListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView.LayoutParams;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;
import catch_.me_.if_.you_.can_.ActivityMain;
import catch_.me_.if_.you_.can_.MainActivity;
import java.io.FileInputStream;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Locale;

public class ConfigListAdapter extends BaseAdapter implements AdapterView.OnItemClickListener {
    public static final String DEVS;
    public static long a;
    static final int[] b;
    static final String[] c;
    private View[] d;
    private WeakReference e;
    private WeakReference f;
    private WeakReference g;
    private boolean h;
    private tp i;
    private static boolean j;

    static {
        ConfigListAdapter.DEVS = "\td2dyno - __owner__, __design__, __pm__.\n\tEnyby - __code__, __pm__.\n\tTrasd - __tech__, __pm__.\n\tAqua - __creator__.\n";
        ConfigListAdapter.a = 0L;
        ConfigListAdapter.b = new int[]{0x7F0701B9, 0x7F070032, -1, 0x7F070293, 0x7F070294, -1, 0x7F07017E, 0x7F07017F, 2, 0x7F07012C, 0x7F070067, -1, 0x7F0702CA, 0x7F0702CB, 21, 0x7F07012D, 0x7F070124, -1, 0x7F07012E, 0x7F070125, 1, 0x7F07012F, 0x7F070065, 6, 0x7F07018A, 0x7F07018B, 5, 0x7F0701B7, 0x7F0701B8, 7, 0x7F070101, 0x7F070126, 0, 0x7F0701FE, 0x7F0701FF, 8, 0x7F070209, 0x7F07020A, 9, 0x7F070228, 0x7F07031E, 12, 0x7F070224, 0x7F070225, 11, 0x7F07028D, 0x7F07028E, 20, 0x7F070262, 0x7F070263, 16, 0x7F070130, 0x7F070128, 4, 0x7F070131, 0x7F070129, 3, 0x7F07020E, 0x7F07020F, 10, 0x7F07026E, 0x7F07006D, 14, 0x7F070343, 0x7F070324, 24, 0x7F070132, 0x7F07003B, -1, 0x7F07023F, 0x7F070240, -1, 0x7F070259, 0x7F07025A, 17, 0x7F07030A, 0x7F07030B, 22, 0x7F07030C, 0x7F07030D, 23, 0x7F070252, 0x7F070253, 13, 0x7F07027B, 0x7F07027D, 18, 0x7F070047, 0x7F070281, 15, 0x7F070270, 0x7F07007A, -1, 0x7F070288, 0x7F070289, 19, 0x7F07028A, 0x7F0702BB, -1, 0x7F0702D6, 0x7F070180, -1, 0x7F070341, 0x7F070342, 25};  // string:help_faq_title "Frequently asked questions"
        ConfigListAdapter.c = new String[]{"kwws=22jdphjxdugldq1qhw2iruxp2jdoohu|2lpdjh24950vhdufk0xqnqrz0zlwk0nqrzq0fkdqjhv0jdphjxdugldq2", "kwws=22jdphjxdugldq1qhw2iruxp2jdoohu|2lpdjh25570vshhg0kdfn0dqg0wlph0mxps0jdphjxdugldq2", "kwws=22jdphjxdugldq1qhw2iruxp2jdoohu|2lpdjh248;0krz0xvh0h|h0lfrq0jdphjxdugldq2", "kwws=22jdphjxdugldq1qhw2iruxp2jdoohu|2lpdjh248<0krz0vhdufk0hqfu|swhg0ydoxh0jdphjxdugldq2\r\rkwws=22jdphjxdugldq1qhw2iruxp2jdoohu|2lpdjh24970frpsduh0phwkrgv0jdphjxdugldq2", "kwws=22jdphjxdugldq1qhw2iruxp2jdoohu|2lpdjh24<40klvwru|0xvdjh0jdphjxdugldq2", "kwws=22jdphjxdugldq1qhw2iruxp2jdoohu|2lpdjh25550h{dpsoh0ri0udqjh0vhdufk0jdphjxdugldq2\r\rkwws=22jdphjxdugldq1qhw2iruxp2jdoohu|2lpdjh25590krz0wr0vhdufk0urxqghg0ydoxh0jdphjxdugldq2", "kwws=22jdphjxdugldq1qhw2iruxp2jdoohu|2lpdjh255<0krz0wr0xvh0rughuhg0jurxs0vhdufk0jdphjxdugldq2", "kwws=22jdphjxdugldq1qhw2iruxp2jdoohu|2lpdjh248<0krz0vhdufk0hqfu|swhg0ydoxh0jdphjxdugldq2", "kwws=22jdphjxdugldq1qhw2iruxp2jdoohu|2lpdjh25960h{dpsoh0ri0wkh0pdvn0vhdufk0jdphjxdugldq2", "kwws=22jdphjxdugldq1qhw2iruxp2jdoohu|2lpdjh255:0krz0wr0xvh0iloo0jdphjxdugldq2", "kwws=22jdphjxdugldq1qhw2iruxp2jdoohu|2lpdjh24<50krz0wr0vshhg0xs0vhdufk0jdphjxdugldq2", "kwws=22jdphjxdugldq1qhw2iruxp2jdoohu|2lpdjh25;60{ru0vhdufk0jxlgh0jdphjxdugldq2", "kwws=22jdphjxdugldq1qhw2iruxp2jdoohu|2lpdjh28:80;330wh{w0vwulqj0kh{0dre0vhdufk0jdphjxdugldq2", "kwws=22jdphjxdugldq1qhw2iruxp2jdoohu|2lpdjh26690rswlrq0dgg0wr0ydoxh0gr0qrw0uhsodfh0jdphjxdugldq2", "kwws=22jdphjxdugldq1qhw2iruxp2jdoohu|2lpdjh26860lpsorvlrq0qhyhu0orvh0krsh0kdfn0ohyho0klgh0iurp0wkh0jdph0jdphjxdugldq2\r\rkwws=22jdphjxdugldq1qhw2iruxp2jdoohu|2lpdjh26870lpsorvlrq0qhyhu0orvh0krsh0kdfn0fuhglwv0klgh0iurp0wkh0jdph0jdphjxdugldq2\r\rkwws=22jdphjxdugldq1qhw2iruxp2jdoohu|2lpdjh26930lpsorvlrq0qhyhu0orvh0krsh0kdfn0fuhglwv0uhvwduw0zlwkrxw0surwhfwlrq0jdphjxdugldq2\r\rkwws=22jdphjxdugldq1qhw2iruxp2jdoohu|2lpdjh26950lpsorvlrq0qhyhu0orvh0krsh0kdfn0fuhglwv0glvdeoh0surwhfwlrq0jdphjxdugldq2\r\rkwws=22jdphjxdugldq1qhw2iruxp2jdoohu|2lpdjh28680:530xvh0urrw0iurp0yluwxdo0vsdfh0iru0klgh0jdphjxdugldq0yluwxdo{srvhg0jdphjxdugldq2\r\rkwws=22jdphjxdugldq1qhw2iruxp2jdoohu|2lpdjh28;30iuhh0iluh0dyrlg0ghwhfwlrq0urrw0iurp0yluwxdo0vsdfh0yluwxdo{srvhg0jdphjxdugldq2\r\rkwws=22jdphjxdugldq1qhw2iruxp2jdoohu|2lpdjh28;40dyrlg0ghwhfwlrq0urrw0iurp0yluwxdo0vsdfh0yluwxdo{srvhg0jdphjxdugldq2\r\rkwws=22jdphjxdugldq1qhw2iruxp2wdjv2dss(53klgh2\r\rkwws=22jdphjxdugldq1qhw2iruxp2jdoohu|2lpdjh28;80dyrlg0ghwhfwlrq0urrw0iurp0yluwxdo0vsdfh0pxowlsoh0dffrxqwv0jdphjxdugldq2", "kwws=22jdphjxdugldq1qhw2iruxp2jdoohu|2lpdjh26;80uhvwduw0zlwkrxw0surwhfwlrq0uhsdlu0wkh0uherrw0uxq0jdphjxdugldq0jdphjxdugldq2\r\rkwws=22jdphjxdugldq1qhw2iruxp2jdoohu|2lpdjh26;70uhvwduw0zlwkrxw0surwhfwlrq0uhsdlu0wkh0uherrw0uherrw0ghylfh0jdphjxdugldq2", "kwws=22jdphjxdugldq1qhw2iruxp2jdoohu|2lpdjh267:0krz0wr0vhdufk0ilowhu0lq0wkh0phpru|0hglwru0jdphjxdugldq2", "kwws=22jdphjxdugldq1qhw2iruxp2jdoohu|2lpdjh26770krz0wr0txlfno|0vhdufk0iru0srlqwhuv0jdphjxdugldq2", "kwws=22jdphjxdugldq1qhw2iruxp2jdoohu|2lpdjh26990xqudqgrpl}hu0jdphjxdugldq2\r\rkwws=22jdphjxdugldq1qhw2iruxp2jdoohu|2lpdjh26;40uxvvldq0vorwv0kdfn0vwruh0xqudqgrpl}hu0jdphjxdugldq2", "kwws=22jdphjxdugldq1qhw2qrurrw", "kwws=22jdphjxdugldq1qhw2iruxp2jdoohu|2lpdjh27480ilowhuv0jdphjxdugldq2", "kwws=22jdphjxdugldq1qhw2iruxp2ilohv2fdwhjru|290oxd0vfulswv2\r\rkwws=22jdphjxdugldq1qhw2khos2", "kwws=22jdphjxdugldq1qhw2iruxp2ilohv2iloh2:970xqdoljqhg0vhdufk2", "kwws=22jdphjxdugldq1qhw2iruxp2jdoohu|2lpdjh286:0:630irupxod0fdofxodwru0jdphjxdugldq2\r\rkwws=22jdphjxdugldq1qhw2iruxp2jdoohu|2lpdjh286;0jxq0zdu0vkrrwlqj0jdphv0kdfn0sulfh0irupxod0fdofxodwru0jdphjxdugldq2", "kwws=22jdphjxdugldq1qhw2iruxp2jdoohu|2lpdjh28680:530xvh0urrw0iurp0yluwxdo0vsdfh0iru0klgh0jdphjxdugldq0yluwxdo{srvhg0jdphjxdugldq2\r\rkwws=22jdphjxdugldq1qhw2iruxp2jdoohu|2lpdjh28;30iuhh0iluh0dyrlg0ghwhfwlrq0urrw0iurp0yluwxdo0vsdfh0yluwxdo{srvhg0jdphjxdugldq2\r\rkwws=22jdphjxdugldq1qhw2iruxp2jdoohu|2lpdjh28;40dyrlg0ghwhfwlrq0urrw0iurp0yluwxdo0vsdfh0yluwxdo{srvhg0jdphjxdugldq2\r\rkwws=22jdphjxdugldq1qhw2iruxp2wdjv2dss(53klgh2\r\rkwws=22jdphjxdugldq1qhw2iruxp2jdoohu|2lpdjh28;80dyrlg0ghwhfwlrq0urrw0iurp0yluwxdo0vsdfh0pxowlsoh0dffrxqwv0jdphjxdugldq2", "kwws=22jdphjxdugldq1qhw2iruxp2jdoohu|2lpdjh29470il{lqj0d0vfulsw0xvlqj0dvvhpeohu0jdphjxdugldq2"};
        ConfigListAdapter.j = false;
    }

    public ConfigListAdapter() {
        this.e = new WeakReference(null);
        this.f = new WeakReference(null);
        this.g = new WeakReference(null);
        this.h = false;
        this.i = null;
        this.d = b.b;
        HotPoint hotPoint0 = MainService.instance.l;
        this.a(hotPoint0.getLayoutAlpha(), hotPoint0.getVanishingTime(), null, null, hotPoint0.getSize());
        this.a();
    }

    private static String a(Configuration configuration0, Locale locale0, AssetManager assetManager0, DisplayMetrics displayMetrics0) {
        Resources resources0;
        Configuration configuration1 = new Configuration(configuration0);
        ConfigListAdapter.a(configuration1, locale0);
        if(Build.VERSION.SDK_INT >= 17) {
            try {
                resources0 = MainService.context.createConfigurationContext(configuration1).getResources();
            }
            catch(Throwable throwable0) {
                la.a(throwable0);
                resources0 = null;
            }
        }
        else {
            resources0 = null;
        }
        if(resources0 == null) {
            new Resources(assetManager0, displayMetrics0, configuration1);
        }
        return "~~~en_US~~~" + String.format(locale0, "%,d;%,d;%e;%e;%e;%e;", 0x499602D2, 0xB669FD2E, 1.234560E+300, -1.234560E+300, 1.234560E-300, -0.0);
    }

    static void a(int v) {
        try {
            int v1 = 10;
            int v2 = v == 3 ? Tools.s().getInt("hide-icon", 0) : v;
            if((v2 != 1 || !(ar.d instanceof MainActivity)) && (v2 != 2 || !(ar.d instanceof ActivityMain))) {
                String s = Tools.g();
                PackageManager packageManager0 = Tools.m();
                ComponentName componentName0 = new ComponentName(s, "catch_.me_.if_.you_.can_.ActivityMain");
                ComponentName componentName1 = new ComponentName(s, "catch_.me_.if_.you_.can_.MainActivity");
                la.a(("hide A: " + v2 + "; " + componentName1 + ": " + packageManager0.getComponentEnabledSetting(componentName1) + "; " + componentName0 + ": " + packageManager0.getComponentEnabledSetting(componentName0) + ';'));
                if(v == 3) {
                    int v3 = packageManager0.getComponentEnabledSetting(componentName1) == 2 ? 1 : 0;
                    int v4 = packageManager0.getComponentEnabledSetting(componentName0) == 2 ? 10 : 0;
                    if(v2 == 1) {
                        v1 = 1;
                    }
                    else if(v2 != 2) {
                        v1 = 0;
                    }
                    if(v4 + v3 != v1) {
                        goto label_20;
                    }
                }
                else {
                label_20:
                    if(v2 != 1) {
                        Tools.a(1, componentName1, 1);
                    }
                    if(v2 != 2) {
                        Tools.a(3, componentName0, 1);
                    }
                    if(v2 == 1) {
                        Tools.a(5, componentName1, 2);
                    }
                    if(v2 == 2) {
                        Tools.a(7, componentName0, 2);
                    }
                    if(v2 != 1) {
                        Tools.a(9, componentName1, 1);
                    }
                    if(v2 != 2) {
                        Tools.a(11, componentName0, 1);
                    }
                    la.a(("hide Z: " + v2 + "; " + componentName1 + ": " + packageManager0.getComponentEnabledSetting(componentName1) + "; " + componentName0 + ": " + packageManager0.getComponentEnabledSetting(componentName0) + ';'));
                    if(v != 3) {
                        new qw().a("hide-icon", v2, 0).commit();
                    }
                }
            }
            else if(v != 3) {
                i.a(i.c().setCustomTitle(Tools.d(0x7F07022A)).setMessage(qk.a(0x7F070314)).setNegativeButton(qk.a(0x7F07009D), null));  // string:hide_icons "Hide launcher icons"
            }
        }
        catch(Throwable throwable0) {
            la.c(("Failed disable icon " + v), throwable0);
        }
    }

    private static void a(AlertDialog alertDialog0, View.OnClickListener view$OnClickListener0, EditText editText0) {
        alertDialog0.setButton(-1, qk.a(0x7F0700A0), new ds(view$OnClickListener0, alertDialog0));  // string:confirm "Confirm"
        i.a(alertDialog0, new dt(view$OnClickListener0));
        i.a(alertDialog0, editText0);
    }

    public static void a(Configuration configuration0, Locale locale0) {
        if(Build.VERSION.SDK_INT >= 17) {
            try {
                configuration0.setLocale(locale0);
            }
            catch(Throwable throwable0) {
                la.a(throwable0);
            }
            try {
                configuration0.setLayoutDirection(locale0);
            }
            catch(Throwable throwable1) {
                la.a(throwable1);
            }
        }
        configuration0.locale = locale0;
    }

    private void a(TextView textView0) {
        int v = 0;
        switch(textView0.getId()) {
            case 0x7F0B0013: {  // id:help
                v = 0x7F02002F;  // drawable:ic_help_circle_outline_white_24dp
                break;
            }
            case 0x7F0B0084: {  // id:config_time_jump_panel
                v = 0x7F020021;  // drawable:ic_fast_forward_white_24dp
                break;
            }
            case 0x7F0B0086: {  // id:config_unrandomizer
                v = 0x7F02001C;  // drawable:ic_dice_multiple_white_24dp
                break;
            }
            case 0x7F0B008C: {  // id:config_autopause
                v = 0x7F02003A;  // drawable:ic_pause_white_18dp
                break;
            }
            case 0x7F0B008E: {  // id:config_saved_list_updates_interval
                v = 0x7F020018;  // drawable:ic_content_save_white_24dp
                break;
            }
            case 0x7F0B008F: {  // id:config_speeds
                v = 0x7F02004D;  // drawable:ic_speedometer_white_24dp
                break;
            }
            case 0x7F0B009E: {  // id:config_history_limit
                v = 0x7F020032;  // drawable:ic_history_white_24dp
                break;
            }
            case 0x7F0B00A4: {  // id:config_use_small_list_items
                v = 0x7F020029;  // drawable:ic_format_list_bulleted_white_24dp
                break;
            }
            case 0x7F0B00A9: {  // id:config_icons_size
                v = 0x7F02004F;  // drawable:ic_tooltip_edit_white_24dp
                break;
            }
            case 0x7F0B00B8: {  // id:screenshot
                v = 0x7F020012;  // drawable:ic_cellphone_screenshot_white_24dp
            }
        }
        if(v != 0) {
            Tools.a(textView0, Tools.b(v), Config.d());
        }
    }

    public static void a(String s) {
        la.a("mConfigTempPath onClick");
        View view0 = android.fix.i.a(0x7F040028, null);  // layout:temp_path_config
        EditTextPath editTextPath0 = (EditTextPath)view0.findViewById(0x7F0B0144);  // id:temp_file_path
        SharedPreferences sharedPreferences0 = Tools.s();
        if(s == null) {
            s = sharedPreferences0.getString("temp-path", "");
        }
        editTextPath0.setText(s);
        editTextPath0.setDataType(4);
        editTextPath0.setPathType(0);
        ((TextView)view0.findViewById(0x7F0B0143)).setText(qk.a(0x7F07009F) + '\n' + qk.a(0x7F070163));  // id:temp_file_desc
        view0.findViewById(0x7F0B000B).setTag(editTextPath0);  // id:path_selector
        AlertDialog alertDialog0 = i.c().setView(InternalKeyboard.c(view0, false)).setPositiveButton(qk.a(0x7F0700A0), null).setNegativeButton(qk.a(0x7F0700A1), null).create();  // string:confirm "Confirm"
        dr dr0 = new dr(editTextPath0, alertDialog0);
        tw.a(((Button)view0.findViewById(0x7F0B000C)), editTextPath0);  // id:typical_values
        ConfigListAdapter.a(alertDialog0, dr0, editTextPath0);
    }

    public void a() {
        View[] arr_view = this.d;
        for(int v = 0; v < arr_view.length; ++v) {
            View view0 = arr_view[v];
            if(view0 instanceof TextView) {
                int v1 = view0.getId();
                ct ct0 = Config.a(v1);
                boolean z = v1 == 0x7F0B0083 || v1 == 0x7F0B0086;  // id:config_speedhack_functions
                if(ct0 != null) {
                    ((TextView)view0).setText(ct0.toString());
                    z = ct0.g;
                }
                if(z) {
                    ((TextView)view0).setBackgroundColor(0x80949442);
                }
            }
        }
    }

    void a(float f, int v, TextView textView0, ImageView imageView0, int v1) {
        String s1;
        MainService mainService0 = MainService.instance;
        String s = v >= 0 ? Tools.a(qk.a(0x7F0700F7), new Object[]{v}) : qk.a(0x7F0700F8);  // string:icon_hide_after "after __d__ seconds"
        try {
            s1 = Tools.a(qk.a(0x7F0700F6), new Object[]{((int)(100 - ((int)(100.0f * f)))), s});  // string:config_icon_text "Icon: transparency = __d__%%, hide - __s__"
        }
        catch(Throwable throwable0) {
            s1 = "fail";
            la.c("Fail setup string for icon config", throwable0);
        }
        TextView textView1 = (TextView)this.f.get();
        if(textView1 != null) {
            textView1.setText(s1);
        }
        if(textView0 != null) {
            textView0.setText(s1);
        }
        mainService0.l.setSize(v1);
        int v2 = mainService0.l.getSizePx();
        TimeJumpPanel timeJumpPanel0 = mainService0.m;
        if(timeJumpPanel0 != null) {
            timeJumpPanel0.setMinSize(v2);
        }
        ImageView imageView1 = (ImageView)this.g.get();
        if(imageView1 != null) {
            Tools.a(imageView1, f * 255.0f);
            Config.b(imageView1, v2);
        }
        if(imageView0 != null) {
            Tools.a(imageView0, f * 255.0f);
            Config.b(imageView0, v2);
        }
        mainService0.l.setLayoutAlpha(f);
        mainService0.l.setVanishingTime(v);
        mainService0.a(mainService0.S.getAdapter());
    }

    public void a(boolean z) {
        if(z) {
            if(this.d.length <= 0) {
                ViewGroup viewGroup0 = (ViewGroup)android.fix.i.a(0x7F04001A, null);  // layout:service_config
                this.e = new WeakReference(((TextView)viewGroup0.findViewById(0x7F0B0080)));  // id:game_section
                this.f = new WeakReference(((TextView)viewGroup0.findViewById(0x7F0B00AB)));  // id:config_icon_text
                this.g = new WeakReference(((ImageView)viewGroup0.findViewById(0x7F0B00AC)));  // id:config_icon_example
                ArrayList arrayList0 = new ArrayList();
                int v = 0;
                while(v < viewGroup0.getChildCount()) {
                    try {
                        View view0 = viewGroup0.getChildAt(v);
                        if(view0.getVisibility() != 8) {
                            if(view0 instanceof TextView) {
                                ((TextView)view0).setText(qk.a(((TextView)view0).getText().toString().trim()));
                                this.a(((TextView)view0));
                            }
                            view0.setLayoutParams(new AbsListView.LayoutParams(-1, -2, 0));
                            arrayList0.add(view0);
                        }
                        ++v;
                        continue;
                    }
                    catch(ArrayIndexOutOfBoundsException unused_ex) {
                    }
                    ++v;
                }
                for(Object object0: arrayList0) {
                    Tools.d(((View)object0));
                }
                this.d = (View[])arrayList0.toArray(new View[arrayList0.size()]);
                this.notifyDataSetChanged();
                MainService mainService0 = MainService.instance;
                mainService0.S.setAdapter(this);
                HotPoint hotPoint0 = mainService0.l;
                this.b();
                this.a(hotPoint0.getLayoutAlpha(), hotPoint0.getVanishingTime(), null, null, hotPoint0.getSize());
                tp tp0 = this.i;
                if(tp0 != null) {
                    Tools.a(MainService.instance.S, tp0);
                    MainService.instance.S.post(new da(this, tp0));
                }
            }
        }
        else if(this.d.length != 0) {
            ListView listView0 = MainService.instance.S;
            this.i = Tools.a(listView0);
            this.d = b.b;
            this.notifyDataSetChanged();
            listView0.setAdapter(null);
        }
    }

    public static void b(int v) {
        ConfigListAdapter.n();
        String[] arr_s = new String[ConfigListAdapter.b.length / 3 + 1];
        int v2 = 0;
        for(int v1 = 0; v1 < ConfigListAdapter.b.length; ++v1) {
            if(v1 % 3 == 0) {
                int v3 = v1 / 3 + 1;
                if(v == ConfigListAdapter.b[v1] || v == ConfigListAdapter.b[v1 + 1]) {
                    v2 = v3;
                }
                arr_s[v3] = qk.a(ConfigListAdapter.b[v1]);
            }
        }
        arr_s[0] = qk.a(0x7F070197);  // string:video_tutorials "Video tutorials and guides how to hack"
        dn dn0 = new dn();
        if(v2 == 0) {
            i.a(i.c().setItems(arr_s, dn0).setNegativeButton(qk.a(0x7F0700A1), null));  // string:cancel "Cancel"
            return;
        }
        dn0.onClick(null, v2);
    }

    void b() {
        TextView textView0 = (TextView)this.e.get();
        if(textView0 == null) {
            return;
        }
        String s = qk.a(0x7F070267);  // string:game_settings "Settings for the game:"
        qh qh0 = MainService.instance.ap;
        String s1 = qh0 == null ? null : qh0.b;
        if(s1 != null) {
            s = Tools.g(s) + " \"" + s1 + "\":";
        }
        textView0.setText(s);
    }

    static void c() {
        i.a(i.c().setCustomTitle(Tools.d(0x7F070001)).setMessage(qk.a(0x7F0700DE)).setPositiveButton(qk.a(0x7F0700F2), new ib(200, true)).setNegativeButton(qk.a(0x7F0700B9), null));  // string:app_name "GameGuardian"
    }

    public static String d() {
        SharedPreferences sharedPreferences0 = Tools.s();
        SharedPreferences.Editor sharedPreferences$Editor0 = sharedPreferences0.edit();
        StringBuilder stringBuilder0 = new StringBuilder();
        long v = sharedPreferences0.getLong("mc", 0L);
        sharedPreferences$Editor0.remove("mc");
        if(v != 0L) {
            stringBuilder0.append("&mc=");
            stringBuilder0.append('=');
            stringBuilder0.append(Long.toHexString(v));
        }
        sharedPreferences$Editor0.commit();
        return stringBuilder0.toString();
    }

    static void e() {
        i.a(i.c().setCustomTitle(Tools.d(0x7F070315)).setMessage(Tools.a(qk.a(0x7F070316), new Object[]{8})).setNegativeButton(qk.a(0x7F0700A1), null).setPositiveButton(qk.a(0x7F07009D), new dh()));  // string:screenshot "Take a screenshot"
    }

    static void f() {
        String[] arr_s = new String[MainService.q.length * 2];
        arr_s[0] = qk.a(0x7F07008B) + ", " + qk.a(0x7F070239);  // string:search "Search"
        arr_s[1] = qk.a(0x7F07008B) + ", " + qk.a(0x7F070238);  // string:search "Search"
        arr_s[2] = qk.a(0x7F07019C) + ", " + qk.a(0x7F070239);  // string:saved_list "Saved list"
        arr_s[3] = qk.a(0x7F07019C) + ", " + qk.a(0x7F070238);  // string:saved_list "Saved list"
        arr_s[4] = qk.a(0x7F07019D) + ", " + qk.a(0x7F070239);  // string:memory_editor "Memory editor"
        arr_s[5] = qk.a(0x7F07019D) + ", " + qk.a(0x7F070238);  // string:memory_editor "Memory editor"
        i.a(i.c().setItems(arr_s, new dk(arr_s)).setNegativeButton(qk.a(0x7F0700A1), null));  // string:cancel "Cancel"
    }

    // 检测为 Lambda 实现
    public static void g() [...]

    @Override  // android.widget.Adapter
    public int getCount() {
        return this.d.length;
    }

    @Override  // android.widget.Adapter
    public Object getItem(int v) {
        return null;
    }

    @Override  // android.widget.Adapter
    public long getItemId(int v) {
        return (long)v;
    }

    @Override  // android.widget.Adapter
    public View getView(int v, View view0, ViewGroup viewGroup0) {
        return v < this.d.length ? this.d[v] : new View(Tools.e());
    }

    public static DialogInterface.OnClickListener h() {
        return (/* 缺少LAMBDA参数 */, /* 缺少LAMBDA参数 */) -> ConfigListAdapter.b(0);
    }

    public static boolean i() {
        boolean z;
        if(Build.VERSION.SDK_INT >= 21) {
            if(Build.SUPPORTED_64_BIT_ABIS == null || Build.SUPPORTED_64_BIT_ABIS.length <= 0) {
                try {
                    z = false;
                label_5:
                    FileInputStream fileInputStream0 = new FileInputStream("/proc/self/auxv");
                    byte[] arr_b = new byte[0x1000];
                    int v = fileInputStream0.read(arr_b);
                    fileInputStream0.close();
                    if(v > 0) {
                        if(v % 16 != 8) {
                            for(int v1 = 0; true; v1 += 16) {
                                if(v1 >= v) {
                                    return true;
                                }
                                if(arr_b[v1 + 4] != 0 || arr_b[v1 + 5] != 0 || arr_b[v1 + 6] != 0 || arr_b[v1 + 7] != 0) {
                                    break;
                                }
                            }
                        }
                        return false;
                    }
                }
                catch(Throwable throwable0) {
                    la.b(("Failed check 64 client. Used: " + z), throwable0);
                }
                return z;
            }
            else {
                z = true;
            }
            goto label_5;
        }
        return false;
    }

    public static void j() {
        if(!lh.g()) {
            return;
        }
        View view0 = android.fix.i.a(0x7F040028, null);  // layout:temp_path_config
        EditTextPath editTextPath0 = (EditTextPath)view0.findViewById(0x7F0B0144);  // id:temp_file_path
        SharedPreferences sharedPreferences0 = Tools.s();
        editTextPath0.setText(sharedPreferences0.getString("su", ""));
        editTextPath0.setDataType(4);
        editTextPath0.setPathType(1);
        editTextPath0.setHint("su");
        ((TextView)view0.findViewById(0x7F0B0143)).setText(qk.a(0x7F07025E));  // id:temp_file_desc
        CheckBox checkBox0 = (CheckBox)view0.findViewById(0x7F0B0145);  // id:use_sh
        checkBox0.setChecked(sharedPreferences0.getBoolean("sh", false));
        checkBox0.setVisibility(0);
        view0.findViewById(0x7F0B000B).setTag(editTextPath0);  // id:path_selector
        AlertDialog alertDialog0 = i.c().setView(InternalKeyboard.c(view0, false)).setPositiveButton(qk.a(0x7F0700A0), null).setNegativeButton(qk.a(0x7F0700A1), null).create();  // string:confirm "Confirm"
        du du0 = new du(editTextPath0, checkBox0, alertDialog0);
        Button button0 = (Button)view0.findViewById(0x7F0B000C);  // id:typical_values
        String[] arr_s = {"su", "ku.sud", "/system/bin/su", "/system/xbin/su", "/su/bin/su", "/system/xbin/bstk/su", "/sbin/su", "/magisk/.core/bin/su", "/magisk/phh/bin/su"};
        button0.setOnClickListener(new tw(arr_s, arr_s));
        button0.setTag(editTextPath0);
        ConfigListAdapter.a(alertDialog0, du0, editTextPath0);
    }

    static void k() {
        Tools.a(0x7F0700C8, 0);  // string:loading "Loading..."
        rx.b(() -> {
            MainService mainService0 = MainService.instance;
            if(mainService0 == null) {
                return;
            }
            ArrayList arrayList0 = new ArrayList();
            ArrayList arrayList1 = new ArrayList();
            HashMap hashMap0 = new HashMap();
            DisplayMetrics displayMetrics0 = new DisplayMetrics();
            mainService0.n.getDefaultDisplay().getMetrics(displayMetrics0);
            Resources resources0 = MainService.context.getResources();
            Configuration configuration0 = resources0.getConfiguration();
            AssetManager assetManager0 = resources0.getAssets();
            String[] arr_s = ad.e();
            Arrays.sort(arr_s, new ea());
            String s = qk.a(0x7F070083);  // string:lang_code "~~~en_US~~~"
            int v = -1;
            long v1 = System.currentTimeMillis();
            int v2 = 0;
            for(int v3 = 0; v2 < arr_s.length; ++v3) {
                String s1 = arr_s[v2];
                if(s1 != null) {
                    try {
                        long v4 = System.currentTimeMillis();
                        if(v4 - v1 > 2000L) {
                            v1 = v4;
                            Tools.a(((v3 + 1) * 100 / arr_s.length + "%"), 0);
                            v1 = v4;
                        }
                        if(s1.length() == 0) {
                            s1 = "en_US";
                        }
                        Locale locale0 = ad.a(s1);
                        String s2 = ConfigListAdapter.a(configuration0, locale0, assetManager0, displayMetrics0);
                        if(hashMap0.get(s2) == null) {
                            if(s2.startsWith(s) && v == -1) {
                                v = arrayList0.size();
                            }
                            String s3 = String.format(locale0, "\n[%,.1f | %.2e]", -1234.0, -0.0);
                            hashMap0.put(s2, s1);
                            arrayList0.add(s1);
                            try {
                                SpannableStringBuilder spannableStringBuilder0 = new SpannableStringBuilder();
                                spannableStringBuilder0.append(locale0.getDisplayName(locale0));
                                spannableStringBuilder0.setSpan(new ForegroundColorSpan(qh.q), 0, spannableStringBuilder0.length(), 33);
                                int v5 = spannableStringBuilder0.length();
                                spannableStringBuilder0.append(" (");
                                spannableStringBuilder0.append(s1);
                                spannableStringBuilder0.append(')');
                                spannableStringBuilder0.setSpan(new ForegroundColorSpan(qh.p), v5, spannableStringBuilder0.length(), 33);
                                int v6 = spannableStringBuilder0.length();
                                spannableStringBuilder0.append(s3);
                                spannableStringBuilder0.setSpan(new RelativeSizeSpan(0.6f), v6, spannableStringBuilder0.length(), 33);
                                spannableStringBuilder0.setSpan(new ForegroundColorSpan(qh.r), v6, spannableStringBuilder0.length(), 33);
                                arrayList1.add(spannableStringBuilder0);
                            }
                            catch(Throwable throwable1) {
                                la.a(throwable1);
                                arrayList1.add(locale0.getDisplayName(locale0) + " (" + s1 + ')' + s3);
                            }
                        }
                    }
                    catch(Throwable throwable0) {
                        la.c(("Failed check locale: " + s1), throwable0);
                    }
                }
                ++v2;
            }
            ConfigListAdapter.a(configuration0, ad.a(ad.c()), assetManager0, displayMetrics0);
            ad.d();
            rx.a(new eb(new ArrayAdapter(MainService.context, arrayList1), v, arrayList0));
        });
    }

    // 检测为 Lambda 实现
    static void l() [...]

    private static void m() {
        new qw().a("mc", ConfigListAdapter.a, 0L).commit();
    }

    private static void n() {
        if(!Config.C || ConfigListAdapter.j) {
            return;
        }
        for(int v = 0; v < ConfigListAdapter.b.length; ++v) {
            if(ConfigListAdapter.b[v] == 0x7F0702BB) {  // string:help_game_not_listed_root "The game must be running to select it.\n\nIf the 
                                                        // game is running, but still it is not in the list, then maybe you have problems with 
                                                        // the root, or firmware.\nTry another root or other firmware."
                ConfigListAdapter.b[v] = 0x7F0702BC;  // string:help_game_not_listed_noroot "The game must be launched in the virtual space 
                                                      // so that it can be selected.\n\nYou can not select a game if it is not running in 
                                                      // the virtual space.\n\nIf the game is running in the virtual space, but still it 
                                                      // is not in the list, try another virtual space, another firmware, another device 
                                                      // or get a root."
            }
        }
        ConfigListAdapter.j = true;
    }

    @Override  // android.widget.BaseAdapter
    public void notifyDataSetChanged() {
        if(!this.h) {
            this.h = true;
            this.a();
            this.h = false;
        }
        super.notifyDataSetChanged();
    }

    private void o() {
        new dp(this, "loadLogcat").start();
    }

    @Override  // android.widget.AdapterView$OnItemClickListener
    public void onItemClick(AdapterView adapterView0, View view0, int v, long v1) {
        View view3;
        if(view0 != null) {
            int v2 = view0.getId();
            if(v2 != -1) {
                long v3 = 1L << v % 0x3F;
                if((ConfigListAdapter.a & v3) == 0L) {
                    ConfigListAdapter.a |= v3;
                    ConfigListAdapter.m();
                }
                MainService mainService0 = MainService.instance;
                ct ct0 = Config.a(v2);
                if(ct0 != null) {
                    switch(v2) {
                        case 0x7F0B009F: {  // id:config_keyboard
                            ct0.a(new dq(this));
                            break;
                        }
                        case 0x7F0B00A9: {  // id:config_icons_size
                            ct0.a(new ed(this));
                        }
                    }
                    ct0.d();
                    return;
                }
                switch(v2) {
                    case 0x7F0B0013: {  // id:help
                        ConfigListAdapter.g();
                        return;
                    }
                    case 0x7F0B003C: {  // id:changelog
                        new db(this, "changelog").start();
                        return;
                    }
                    case 0x7F0B007C: {  // id:donate
                        new be("kwws=22jdphjxdugldq1qhw2grqdwh").onClick(null, 0);
                        return;
                    }
                    case 0x7F0B007D: {  // id:config_reset
                        mainService0.a(true);
                        return;
                    }
                    case 0x7F0B007E: {  // id:config_exit
                        i.a(i.c().setCustomTitle(Tools.d(0x7F0700B8)).setPositiveButton(qk.a(0x7F07009B), new ib(300)).setNegativeButton(qk.a(0x7F07009C), null));  // string:exit "Exit"
                        return;
                    }
                    case 0x7F0B007F: {  // id:config_kill_game
                        i.a(i.c().setCustomTitle(Tools.d(0x7F0701AE)).setMessage(qk.a(0x7F070031)).setPositiveButton(qk.a(0x7F07009B), new ef(this, mainService0)).setNegativeButton(qk.a(0x7F07009C), null));  // string:kill_game "Kill the game"
                        return;
                    }
                    case 0x7F0B0083: {  // id:config_speedhack_functions
                        MainService.instance.ae.a();
                        return;
                    }
                    case 0x7F0B0086: {  // id:config_unrandomizer
                        MainService.instance.ag.a();
                        return;
                    }
                    case 0x7F0B008F: {  // id:config_speeds
                        try {
                            view3 = android.fix.i.a(0x7F040007, null);  // layout:list_speeds_config
                        }
                        catch(IndexOutOfBoundsException indexOutOfBoundsException0) {
                            la.a(indexOutOfBoundsException0);
                            view3 = null;
                            MainService.H();
                        }
                        if(view3 != null) {
                            TextView textView1 = (TextView)view3.findViewById(0x7F0B002C);  // id:hint
                            TextView textView2 = (TextView)view3.findViewById(0x7F0B000E);  // id:message
                            textView2.setText(qk.a(textView2.getText().toString().trim()));
                            EditTextSpeeds editTextSpeeds0 = (EditTextSpeeds)view3.findViewById(0x7F0B002B);  // id:speeds
                            TextView textView3 = (TextView)view3.findViewById(0x7F0B002D);  // id:default_
                            textView3.setText(Tools.c(0x7F07023D) + ": " + "0.000000001;0.00000001;0.0000001;0.000001;0.00001;0.0001;0.001;0.002;0.005;0.01;0.02;0.05;0.1;0.2;0.5;0.6;0.75;0.9;1;1.2;1.3;1.5;2;3;4;5;6;9;12;15;20;30;60;120;180;300;600;1200;2400;3600");  // string:default_ "Default:"
                            textView3.setOnClickListener(new eh(this, editTextSpeeds0));
                            editTextSpeeds0.setText(MainService.instance.ab.f());
                            editTextSpeeds0.setDataType(16);
                            editTextSpeeds0.setOnChangedListener(new ei(this, editTextSpeeds0, textView1));
                            i.a(i.c().setView(InternalKeyboard.a(view3)).setPositiveButton(qk.a(0x7F0700A0), new ej(this, editTextSpeeds0)).setNegativeButton(qk.a(0x7F0700A1), null), editTextSpeeds0);  // string:confirm "Confirm"
                            return;
                        }
                        break;
                    }
                    case 0x7F0B0098: {  // id:config_path
                        ConfigListAdapter.a(null);
                        return;
                    }
                    case 0x7F0B0099: {  // id:config_su
                        ConfigListAdapter.j();
                        return;
                    }
                    case 0x7F0B00A7: {  // id:config_toolbar_buttons
                        ConfigListAdapter.f();
                        return;
                    }
                    case 0x7F0B00AA: {  // id:config_icon
                        View view1 = android.fix.i.a(0x7F04001C, null);  // layout:service_config_icon
                        SeekBar seekBar0 = (SeekBar)view1.findViewById(0x7F0B00C3);  // id:transparency
                        SeekBar seekBar1 = (SeekBar)view1.findViewById(0x7F0B00C4);  // id:hide
                        SeekBar seekBar2 = (SeekBar)view1.findViewById(0x7F0B0053);  // id:size
                        TextView textView0 = (TextView)view1.findViewById(0x7F0B00AB);  // id:config_icon_text
                        ImageView imageView0 = (ImageView)view1.findViewById(0x7F0B00AC);  // id:config_icon_example
                        float f = mainService0.l.getLayoutAlpha();
                        int v4 = mainService0.l.getVanishingTime();
                        int v5 = mainService0.l.getSize();
                        seekBar0.setProgress(10 - ((int)(10.0f * f)));
                        seekBar1.setProgress((v4 >= 0 ? v4 : seekBar1.getMax()));
                        seekBar2.setMax(12);
                        seekBar2.setProgress(v5);
                        this.a(f, v4, textView0, imageView0, v5);
                        ee ee0 = new ee(this, seekBar0, seekBar1, seekBar2, textView0, imageView0);
                        seekBar0.setOnSeekBarChangeListener(ee0);
                        seekBar1.setOnSeekBarChangeListener(ee0);
                        seekBar2.setOnSeekBarChangeListener(ee0);
                        i.a(i.c().setPositiveButton(qk.a(0x7F07009D), null).setView(view1));  // string:ok "OK"
                        return;
                    }
                    case 0x7F0B00AD: {  // id:hide_icons
                        CharSequence[] arr_charSequence = {qk.a(0x7F07017B) + " (" + qk.a(0x7F07023C) + ')', qk.a(0x7F070003), qk.a(0x7F070002)};  // string:nothing "Nothing"
                        AlertDialog alertDialog0 = i.c().setCustomTitle(Tools.d(0x7F07022A)).setItems(arr_charSequence, new de(this)).create();  // string:hide_icons "Hide launcher icons"
                        ListView listView0 = alertDialog0.getListView();
                        if(listView0 != null) {
                            Drawable[] arr_drawable = new Drawable[3];
                            arr_drawable[1] = Tools.b(0x7F030007);  // mipmap:ic_sw_48dp
                            arr_drawable[2] = Tools.b(0x7F030004);  // mipmap:ic_hw_48dp
                            Tools.a(listView0, arr_charSequence, arr_drawable, 0x30, 0);
                        }
                        i.c(alertDialog0);
                        return;
                    }
                    case 0x7F0B00B0: {  // id:config_language
                        ConfigListAdapter.k();
                        return;
                    }
                    case 0x7F0B00B2: {  // id:config_disable_protection
                        if(lh.g()) {
                            i.a(i.c().setCustomTitle(Tools.d(0x7F070270)).setMessage(qk.a(0x7F07007A)).setPositiveButton(qk.a(0x7F07009D), new df(this, mainService0)).setNegativeButton(qk.a(0x7F0700A1), null));  // string:disable_protection "Disable protection for all applications (until reboot)"
                            return;
                        }
                        break;
                    }
                    case 0x7F0B00B3: {  // id:config_clear_history
                        i.a(i.c().setCustomTitle(Tools.d(0x7F070283)).setMessage(qk.a(0x7F070284)).setPositiveButton(qk.a(0x7F07009D), new dg(this)).setNegativeButton(qk.a(0x7F0700A1), null));  // string:clear_history "Clear input history"
                        return;
                    }
                    case 0x7F0B00B4: {  // id:config_clear_defaults
                        i.a(i.c().setMessage(qk.a(0x7F0702DA)).setPositiveButton(qk.a(0x7F0700A0), new dd(this)).setNegativeButton(qk.a(0x7F0700A1), null));  // string:reset_ignore "Reset all ignore for all dialogs"
                        return;
                    }
                    case 0x7F0B00B5: {  // id:config_last_stats
                        View view2 = android.fix.i.a(0x7F04000A, null);  // layout:main_new_version
                        ((TextView)view2.findViewById(0x7F0B003C)).setText("- none -");  // id:changelog
                        i.a(i.c().setCustomTitle(Tools.d(0x7F07014D)).setView(view2).setNegativeButton(qk.a(0x7F07009D), null));  // string:last_stats "Stats for your last search"
                        return;
                    }
                    case 0x7F0B00B6: {  // id:show_logcat
                        this.o();
                        return;
                    }
                    case 0x7F0B00B7: {  // id:config_region_log
                        gs.a();
                        return;
                    }
                    case 0x7F0B00B8: {  // id:screenshot
                        ConfigListAdapter.e();
                        return;
                    }
                    case 0x7F0B00B9: {  // id:about
                        i.a(i.c().setCustomTitle(Tools.d(0x7F0700D3)).setMessage(qk.a(("__version__ " + 101.099998f + " (" + 0x3F0E + ")\n\n__developers__\n" + "\td2dyno - __owner__, __design__, __pm__.\n\tEnyby - __code__, __pm__.\n\tTrasd - __tech__, __pm__.\n\tAqua - __creator__.\n" + "\n__special_thanks__\n\tdanilo_scala,\n\tYoungBai,\n\tKorean L,\n\tiAndroHacker,\n\tMobile46,\n\treduxpl,\n\tjan.eike.kottlarz,\n\ttimo.szillat,\n\tSubZero5,\n\tZuiXan,\n\tAlex,\n\tGanjar Sukmara,\n\tdd09david,\n\tvenomx961,\n\tchatzopoulosapostolos,\n\tWanderMax,\n\tIvan Maldonado,\n\tvesper7dd,\n\tSelfDestruct68,\n\tmallachri,\n\tAzhar Dripana,\n\tIlya Kushnir,\n\twasao0807,\n\tAlex NG,\n\tjeroen.wilmink,\n\tpodluka,\n\tAnty0,\n\tkiilerman496,\n\tthex3only,\n\tmustafayasir6,\n\tHavergal Samosir Jr.,\n\timpykid,\n\t28ado1,\n\tElectroz,\n\tvincensius.august,\n\tRuan Carlos,\n\tNurMarvin,\n\tSkullboyq,\n\tYakiaaa,\n\tag2s20150609,\n\tanitamoellerga,\n\tcoolapk_ooops,\n\tpandecheng,\n\tpkjisoo32,\n\tLeam19999,\n\tminecraft172zzz,\n\tTodd Justin York,\n\tGedablo,\n\trootddos511,\n\t\u694A\u842C\u6797,\n\tchetraclr,\n\tcub.madrax,\n\tntnhiu,\n\tbuivanxia10,\n\twl02082201,\n\tBacklift,\n\tvonxom,\n\tPeter Cuevas H,\n\talg1.66336611,\n\tHoangthinh99hp,\n\tJackH4L,\n\tspacemaker2906,\n\tva3kama3eredeti,\n\tAustin Andrews,\n\tsaqibpiash,\n\tsuuyout,\n\tsljivics,\n\tDartel,\n\tdoungvichetra2,\n\t0968688218channa,\n\tCaptainTF,\n\tdbinkv1,\n\tronaldmoura,\n\tlafrite.cassee,\n\tJazeks,\n\tNightMareNivek,\n\tprefix309,\n\tmilad19s,\n\tliato.games,\n\tCmP,\n\t1701silentspawn,\n\tgood7773good7773good7773,\n\tATAA SY,\n\tkhiemhocrot.98,\n\ta0193143,\n\tYaroslav,\n\tzam5355,\n\tlonglix,\n\tsssidiki4,\n\tGeorge,\n\t\u51B0\u934A,\n\tFloatKey."))).setNeutralButton(qk.a(0x7F070161), new eg(this)).setPositiveButton(qk.a(0x7F070223), new be(null)).setNegativeButton(qk.a(0x7F07009D), null));  // string:about "About"
                        return;
                    }
                    default: {
                        la.b(("Unknown id in config: " + v2));
                    }
                }
            }
        }
    }
}

