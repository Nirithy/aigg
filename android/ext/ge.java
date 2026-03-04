package android.ext;

import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface;

class ge implements DialogInterface.OnClickListener {
    final gd a;

    ge(gd gd0) {
        this.a = gd0;
        super();
    }

    @Override  // android.content.DialogInterface$OnClickListener
    public void onClick(DialogInterface dialogInterface0, int v) {
        ConfigListAdapter.b(0x7F070289);  // string:work_without_root "__app_name__ can work without root, through a virtual 
                                          // environment. For example, through __vspace_list__ and many others.\n__app_name__ 
                                          // must be installed in a virtual environment. The game must also be installed there.\nNot 
                                          // all features of the program are supported, but most functions should work.\n\nYou 
                                          // will not be able to crack games that are not installed in a virtual environment.\n\nThe 
                                          // first launch of __app_name__, which performs a reinstallation with a random package 
                                          // name, must not be performed through a virtual environment.\nThen you can add __app_name__ 
                                          // to the virtual environment and use."
    }
}

