package android.ext;

import android.app.AlertDialog.Builder;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface;
import android.fix.i;
import android.view.View;
import android.widget.TextView;

class dn implements DialogInterface.OnClickListener {
    @Override  // android.content.DialogInterface$OnClickListener
    public void onClick(DialogInterface dialogInterface0, int v) {
        if(v == 0) {
            new be("kwws=22jdphjxdugldq1qhw2iruxp2jdoohu|2fdwhjru|250ylghr0wxwruldov2").onClick(dialogInterface0, 0);
            return;
        }
        String s = qk.a(ConfigListAdapter.b[(v - 1) * 3]) + ":\n" + qk.a(ConfigListAdapter.b[(v - 1) * 3 + 1]);
        int v1 = ConfigListAdapter.b[(v - 1) * 3 + 2];
        if(v1 >= 0) {
            String s1 = s.trim() + "\n\n";
            if(s1.charAt(s1.length() - 3) != 58) {
                s1 = s1 + qk.a(0x7F070199) + ":\n";  // string:video "Videos"
            }
            s = s1 + Tools.removeNewLinesChars(ConfigListAdapter.c[v1]);
        }
        String s2 = ConfigListAdapter.b[(v - 1) * 3] == 0x7F07012C ? s.replace(qk.a(0x7F070005), qk.a(0x7F070001)) + "\nhttps://productforums.google.com/forum/#!topic/translate/1Pywh5vI1kE\n\n" + Tools.c(0x7F0702C7) + ":\n" + "http://gameguardian.net/v-240" : s;  // string:help_floating_icon_title "The floating icon"
        View view0 = i.a(0x7F04000A, null);  // layout:main_new_version
        TextView textView0 = (TextView)view0.findViewById(0x7F0B003C);  // id:changelog
        Tools.a(textView0, s2);
        Tools.a(textView0.getText());
        AlertDialog.Builder alertDialog$Builder0 = android.ext.i.c().setView(view0).setNegativeButton(qk.a(0x7F07009D), ConfigListAdapter.h());  // string:ok "OK"
        if(ConfigListAdapter.b[(v - 1) * 3] == 0x7F070288) {  // string:work_without_root_title "Work without root"
            alertDialog$Builder0.setPositiveButton(0x7F070156, new be("kwws=22jdphjxdugldq1qhw2iruxp2wrslf24<7540yluwxdo0vsdfhv0wr0uxq0jdphjxdugldq0zlwkrxw0urrw2"));  // string:more "More"
        }
        android.ext.i.a(alertDialog$Builder0);
        if(Config.C && ConfigListAdapter.b[(v - 1) * 3] == 0x7F07028A) {  // string:help_game_not_listed_title "Why my game is not in the process list?"
            try {
                if((Tools.j(Config.E).flags & 2) == 0) {
                    android.ext.i.a(android.ext.i.c().setMessage(Tools.a(qk.a(0x7F0702E9), new Object[]{Config.F, Config.F})).setNeutralButton(qk.a(0x7F070164), new be("kwws=22jdphjxdugldq1qhw2iruxp2wrslf24<7540yluwxdo0vsdfhv0wr0uxq0jdphjxdugldq0zlwkrxw0urrw2")).setNegativeButton(qk.a(0x7F07009D), null));  // string:not_optimized2 "You are using a non-optimized version of the virtual space 
                                                                                                                                                                                                                                                                                                                    // (\"__s__\").\nTo fix this error, remove the non-optimized version of \"__s__\" and 
                                                                                                                                                                                                                                                                                                                    // install one of the optimized virtual spaces from the official site __app_name__.\nClick 
                                                                                                                                                                                                                                                                                                                    // \"__fix_it__\" to go to the selection of optimized virtual spaces."
                }
            }
            catch(Throwable throwable0) {
                la.b(("Failed check vSpace: " + Config.E), throwable0);
            }
            byte b = Config.G;
            if(b == 0) {
                b = !ConfigListAdapter.i() || !Config.E.contains("64") ? 2 : 1;
                Config.G = b;
            }
            if(b == 1) {
                try {
                    android.ext.i.a(android.ext.i.c().setMessage(qk.a(0x7F0702D0)).setNegativeButton(qk.a(0x7F07009D), null));  // string:vspace64 "You ran __app_name__ in a virtual space that supports 64-bit processes.\n\n__app_name__ 
                                                                                                                                // will not see 32-bit processes running in this space.\n\nInstall the second copy 
                                                                                                                                // of __app_name__ in the \"__for32__\" mode if you want to work in __app_name__ with 
                                                                                                                                // 32-bit processes."
                }
                catch(Throwable throwable1) {
                    la.b(("Failed check vSpace: " + Config.E), throwable1);
                }
            }
        }
    }
}

