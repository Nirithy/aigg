package android.ext;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Parcel;
import android.text.SpannableString;
import android.text.style.URLSpan;
import android.util.AndroidRuntimeException;
import android.view.View;
import android.view.WindowManager.BadTokenException;
import android.widget.TextView;

public class DefensiveURLSpan extends URLSpan {
    public DefensiveURLSpan(Parcel parcel0) {
        super(parcel0);
    }

    public DefensiveURLSpan(String s) {
        super(s);
    }

    public static void a(TextView textView0) {
        DefensiveURLSpan.a(textView0.getText());
    }

    public static void a(CharSequence charSequence0) {
        if(charSequence0 instanceof SpannableString) {
            URLSpan[] arr_uRLSpan = (URLSpan[])((SpannableString)charSequence0).getSpans(0, ((SpannableString)charSequence0).length(), URLSpan.class);
            for(int v = 0; v < arr_uRLSpan.length; ++v) {
                URLSpan uRLSpan0 = arr_uRLSpan[v];
                int v1 = ((SpannableString)charSequence0).getSpanStart(uRLSpan0);
                int v2 = ((SpannableString)charSequence0).getSpanEnd(uRLSpan0);
                ((SpannableString)charSequence0).removeSpan(uRLSpan0);
                ((SpannableString)charSequence0).setSpan(new DefensiveURLSpan(uRLSpan0.getURL()), v1, v2, 0);
            }
        }
    }

    @Override  // android.text.style.URLSpan
    public void onClick(View view0) {
        Intent intent0;
        Context context0;
        try {
            androidRuntimeException0 = null;
            super.onClick(view0);
            goto label_3;
        }
        catch(AndroidRuntimeException | WindowManager.BadTokenException | SecurityException androidRuntimeException0) {
        label_3:
            try {
                if(androidRuntimeException0 != null) {
                    la.b(("failed onClick on URLSpan: " + this.getURL()), androidRuntimeException0);
                    Uri uri0 = Uri.parse(this.getURL());
                    context0 = view0.getContext();
                    intent0 = new Intent("android.intent.action.VIEW", uri0);
                    intent0.putExtra("com.android.browser.application_id", Tools.g());
                    intent0.setFlags(0x10000000);
                    goto label_11;
                }
                goto label_14;
            }
            catch(ActivityNotFoundException activityNotFoundException0) {
                la.b("failed call activity", activityNotFoundException0);
                return;
            }
            catch(SecurityException securityException0) {
                la.b(("failed onClick on URLSpan: " + this.getURL()), securityException0);
                return;
            }
            try {
            label_11:
                context0.startActivity(intent0);
                goto label_14;
            }
            catch(Throwable unused_ex) {
                try {
                    la.b(("failed2 onClick on URLSpan: " + this.getURL()), androidRuntimeException0);
                label_14:
                    i.d();
                    return;
                }
                catch(ActivityNotFoundException activityNotFoundException0) {
                    la.b("failed call activity", activityNotFoundException0);
                    return;
                }
                catch(SecurityException securityException0) {
                }
            }
        }
        catch(ActivityNotFoundException activityNotFoundException0) {
            la.b("failed call activity", activityNotFoundException0);
            return;
        }
        la.b(("failed onClick on URLSpan: " + this.getURL()), securityException0);
    }
}

