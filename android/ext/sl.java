package android.ext;

import android.content.ClipData;
import android.os.Build.VERSION;
import android.text.ClipboardManager;

class sl implements Runnable {
    private final String a;
    private final boolean b;

    sl(String s, boolean z) {
        this.a = s;
        this.b = z;
        super();
    }

    @Override
    public void run() {
        String s = this.a.replace(" ", " ");
        if(this.b) {
            iw.a(s, 1);
        }
        try {
            Object object0 = MainService.context.getSystemService("clipboard");
            if(Build.VERSION.SDK_INT < 11) {
                ((ClipboardManager)object0).setText(s);
            }
            else {
                ((android.content.ClipboardManager)object0).setPrimaryClip(ClipData.newPlainText(s, s));
            }
            Tools.a(0x7F0700FD);  // string:copied "Copied"
        }
        catch(Throwable throwable0) {
            la.c("Failed to copy text to the clipboard", throwable0);
            la.a(("Text: " + s));
            Tools.b((qk.a(0x7F0700FC) + ' ' + throwable0.getMessage()));  // string:failed_copy_text "Failed to copy text to the clipboard:"
        }
    }
}

