package android.ext;

import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface;

class pb implements DialogInterface.OnClickListener {
    final pa a;

    pb(pa pa0) {
        this.a = pa0;
        super();
    }

    @Override  // android.content.DialogInterface$OnClickListener
    public void onClick(DialogInterface dialogInterface0, int v) {
        ConfigListAdapter.b(0x7F070263);  // string:help_memory_filter "* __help_memory_filter_title__:\nYou can specify a filter 
                                          // in the memory editor. Only those results that match the filter will be displayed.\nThe 
                                          // filter supports wildcards:\n\t__caret__ - the start of the data,\n\t__dollar__ - 
                                          // the end of the data,\n\t__asterisk__ - any number of any characters,\n\t__question__ 
                                          // - the one any character.\nFor example, to find the number 42, you need to enter 
                                          // __caret__42__dollar__."
    }
}

