package android.ext;

import android.content.Context;

class md implements Runnable {
    private final Context a;

    md(Context context0) {
        this.a = context0;
        super();
    }

    @Override
    public void run() {
        try {
            String s = qk.a("     15. __help_faq_15_q__\r\n        __help_faq_15_a__\r\n\r\n     16. __help_faq_16_q__\r\n        __help_faq_16_a__\r\n\r\n     17. __help_faq_17_q__\r\n        __help_faq_17_a__\r\n\r\n__rtfm__");
            i.c(i.a(this.a).setMessage(s).setNegativeButton(qk.a(0x7F07009D), null).create());  // string:ok "OK"
        }
        catch(Throwable throwable0) {
            la.c("Failed faq alert", throwable0);
        }
    }
}

