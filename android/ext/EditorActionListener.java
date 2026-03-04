package android.ext;

import android.app.AlertDialog;
import android.content.DialogInterface.OnClickListener;
import android.view.KeyEvent;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView.OnEditorActionListener;
import android.widget.TextView;
import java.lang.ref.WeakReference;

public class EditorActionListener implements TextView.OnEditorActionListener {
    private WeakReference a;

    public EditorActionListener(AlertDialog alertDialog0) {
        new WeakReference(null);
        this.a = new WeakReference(alertDialog0);
    }

    @Override  // android.widget.TextView$OnEditorActionListener
    public boolean onEditorAction(TextView textView0, int v, KeyEvent keyEvent0) {
        boolean z = false;
        if(v == 2 || v == 3 || v == 4 || v == 6) {
            AlertDialog alertDialog0 = (AlertDialog)this.a.get();
            if(alertDialog0 instanceof AlertDialog) {
                Button button0 = alertDialog0.getButton(-1);
                if(button0 != null && button0.getVisibility() == 0) {
                    Tools.f(button0);
                    z = true;
                }
            }
            if(!z && alertDialog0 instanceof DialogInterface.OnClickListener) {
                ((DialogInterface.OnClickListener)alertDialog0).onClick(null, -1);
                z = true;
            }
            if(!z && alertDialog0 instanceof View.OnClickListener) {
                ((View.OnClickListener)alertDialog0).onClick(textView0);
                return true;
            }
        }
        return z;
    }
}

