package android.ext;

import java.io.File;
import lasm.a;
import luaj.o;
import luaj.p;

class Script.ScriptThread extends Thread {
    final Script a;

    public Script.ScriptThread(Script script0) {
        this.a = script0;
        super("Script thread");
        ho.a(this);
    }

    @Override
    public void run() {
        Script.ScriptThread.1 script$ScriptThread$10;
        String s10;
        String s5;
        Throwable throwable1;
        MainService mainService0;
        try {
            int v = 0;
            mainService0 = MainService.instance;
            mainService0.a(this.a);
            lh.a.booleanValue();
            this.a.a_();
            try {
                throwable1 = throwable2;
                this.a.d();
                throwable1 = null;
            }
            catch(Script.OsExit script$OsExit0) {
                la.c(("Script interrupted by self: " + script$OsExit0.getMessage()));
                StringBuilder stringBuilder0 = new StringBuilder(qk.a(0x7F070327));  // string:script_exit "Exit"
                this.a.c(stringBuilder0.append((script$OsExit0.a == 0 ? "." : ": " + script$OsExit0.a)).toString());
                throwable1 = null;
            }
            catch(o o0) {
                Throwable throwable3 = o0.getCause();
                if(!(throwable3 instanceof InterruptedException) || this.a.h == 0) {
                    if(o0 instanceof p) {
                        ho.a(Thread.currentThread(), o0, false);
                    }
                    throwable1 = o0;
                }
                else {
                    la.c(("Script thread interrupted: " + this.a.h), throwable3);
                    String s = qk.a(0x7F070328) + " [" + this.a.h + "]";  // string:script_interrupted "The script interrupted."
                    this.a.c(s);
                    throwable1 = null;
                }
            }
            catch(Throwable unused_ex) {
            }
            if(throwable1 != null) {
                try {
                    la.c("Script error", throwable1);
                    String s1 = la.b(throwable1);
                    String s2 = throwable1.getMessage();
                    if(s2 != null && !s1.contains(s2)) {
                        s1 = String.valueOf(s2) + '\n' + s1;
                    }
                    if(throwable1 instanceof o) {
                        int v1 = !(this.a.b instanceof File) || !this.a.b(((File)this.a.b)) ? (s2 == null || !s2.contains("<!DOCTYPE") && !s2.contains("<html") ? 0 : 0x7F07032C) : 0x7F07032D;  // string:script_web "a web page"
                        if(v1 != 0) {
                            String s3 = Tools.a(qk.a(0x7F07032B), new Object[]{qk.a(v1)});  // string:script_possible "It looks like you are trying to execute __s__ as a script."
                            this.a.c(s3);
                        }
                    }
                    if(this.a.b instanceof File) {
                        String s4 = a.a(throwable1, ((File)this.a.b).getAbsolutePath(), true);
                        if(s4 == null || s4.length() <= 0) {
                            s5 = s1;
                        }
                        else {
                            s5 = s4 + s1;
                            v = 4;
                        }
                    }
                    else {
                        s5 = s1;
                    }
                    goto label_49;
                }
                catch(OutOfMemoryError outOfMemoryError0) {
                    try {
                        s5 = outOfMemoryError0.toString() + '\n';
                    label_49:
                        if(lh.a.booleanValue()) {
                            String s6 = qk.a(0x7F070227);  // string:try_latest "Perhaps this script needs the latest version of __app_name__. 
                                                           // Try to update to the latest version."
                            this.a.c(s6);
                        }
                        String s7 = Tools.c(0x7F070329) + ": " + s5;  // string:script_error "Script error"
                        this.a.c(s7);
                        goto label_58;
                    }
                    catch(OutOfMemoryError outOfMemoryError1) {
                    }
                }
                String s8 = Tools.c(0x7F07032A) + ": " + outOfMemoryError1.toString();  // string:script_oom "Out of memory"
                this.a.c(s8);
            }
        label_58:
            if(this.a.a.b != 0 || this.a.a.c != 0L) {
                String s9 = Tools.a(qk.a(0x7F070326), new Object[]{Tools.a(Tools.e(), this.a.a.c), this.a.a.b});  // string:script_wrote "The script wrote __s__ to __d__ files."
                this.a.c(s9);
            }
            this.a.b_();
            if(this.a.b instanceof File) {
                s10 = qk.a(0x7F0700F2);  // string:restart "Restart"
                script$ScriptThread$10 = new Script.ScriptThread.1(this);
            }
            else {
                script$ScriptThread$10 = null;
                s10 = null;
            }
            mainService0.a(new Script.ScriptThread.2(this, Tools.c(0x7F07021B) + ":\n" + this.a.d.toString().trim(), v, s10, script$ScriptThread$10));  // string:script_ended "Script ended:"
        }
        catch(Throwable throwable0) {
            la.c("Script run exception", throwable0);
        }
        mainService0.b(this.a);
    }
}

