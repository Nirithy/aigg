package android.ext;

import android.content.SharedPreferences;

class lr implements Runnable {
    @Override
    public void run() {
        try {
            SharedPreferences sharedPreferences0 = Tools.s();
            String s = sharedPreferences0.getString("improve-translate", "");
            String s1 = qk.a(0x7F070000) + ':' + qk.a(0x7F070083);  // string:version_number "101.1"
            if(!s1.equals(s)) {
                String s2 = qk.a(0x7F070022);  // string:improve_translation_en "This translation was created by an automatic translator. 
                                               // You can improve it by using our collective translation service."
                if(qk.a(0x7F070084).contains(s2)) {  // string:front_text "If you have any questions about __app_name__ or its use, please 
                                                     // visit our forums at __forum__"
                    rx.a(new lu(this, new lt(this, sharedPreferences0, s1)));
                }
            }
        }
        catch(Throwable throwable0) {
            la.c("checkAutoTranslation", throwable0);
        }
    }
}

