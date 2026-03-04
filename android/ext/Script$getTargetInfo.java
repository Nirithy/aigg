package android.ext;

import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.PackageManager;
import luaj.LuaTable;
import luaj.LuaValue;
import luaj.ap;

final class Script.getTargetInfo extends Script.ApiFunction {
    @Override  // android.ext.Script$ApiFunction
    String a() {
        return "gg.getTargetInfo() -> table || nil";
    }

    @Override  // android.ext.Script$ApiFunction
    public ap b(ap ap0) {
        Throwable throwable1;
        LuaTable luaTable2;
        String s;
        int v = 1;
        LuaValue luaValue0 = LuaValue.u;
        qh qh0 = MainService.instance.ap;
        if(qh0 != null) {
            try {
                s = qh0.c;
                PackageInfo packageInfo0 = Tools.d(s, 1);
                if(packageInfo0 != null) {
                    LuaTable luaTable0 = new LuaTable();
                    luaTable0.d("packageName", qh0.c);
                    luaTable0.d("cmdLine", qh0.a);
                    luaTable0.d("name", qh0.b);
                    luaTable0.d("nativeLibraryDir", qh0.d);
                    luaTable0.b("pid", qh0.f);
                    luaTable0.b("uid", qh0.g);
                    luaTable0.b("x64", (qh0.n ? LuaValue.v : LuaValue.w));
                    luaTable0.b("RSS", qh0.o);
                    luaTable0.b("firstInstallTime", ((double)packageInfo0.firstInstallTime));
                    luaTable0.b("lastUpdateTime", ((double)packageInfo0.lastUpdateTime));
                    if(packageInfo0.packageName != null) {
                        luaTable0.d("packageName", packageInfo0.packageName);
                    }
                    if(packageInfo0.sharedUserId != null) {
                        luaTable0.d("sharedUserId", packageInfo0.sharedUserId);
                    }
                    luaTable0.b("sharedUserLabel", packageInfo0.sharedUserLabel);
                    luaTable0.b("versionCode", packageInfo0.versionCode);
                    if(packageInfo0.versionName != null) {
                        luaTable0.d("versionName", packageInfo0.versionName);
                    }
                    PackageManager packageManager0 = Tools.m();
                    if(packageInfo0.activities != null && packageManager0 != null) {
                        LuaTable luaTable1 = new LuaTable();
                        ActivityInfo[] arr_activityInfo = packageInfo0.activities;
                        int v1 = 0;
                        while(true) {
                            if(v1 >= arr_activityInfo.length) {
                                luaTable0.b("activities", luaTable1);
                                break;
                            }
                            ActivityInfo activityInfo0 = arr_activityInfo[v1];
                            if(activityInfo0 != null) {
                                try {
                                    luaTable2 = new LuaTable();
                                    if(activityInfo0.name != null) {
                                        luaTable2.c("name", activityInfo0.name);
                                    }
                                    luaTable2.c("label", activityInfo0.loadLabel(packageManager0).toString());
                                }
                                catch(Throwable throwable0) {
                                    throwable1 = throwable0;
                                    goto label_49;
                                }
                                try {
                                    luaTable1.a(v, luaTable2);
                                    ++v;
                                    goto label_50;
                                }
                                catch(Throwable throwable1) {
                                    ++v;
                                }
                            label_49:
                                la.b("Failed get activity info", throwable1);
                            }
                        label_50:
                            ++v1;
                        }
                    }
                    if(packageManager0 != null) {
                        try {
                            luaTable0.d("installer", packageManager0.getInstallerPackageName(s));
                        }
                        catch(Throwable throwable2) {
                            la.b("Failed get installer", throwable2);
                        }
                        try {
                            luaTable0.b("enabledSetting", packageManager0.getApplicationEnabledSetting(s));
                        }
                        catch(Throwable throwable3) {
                            la.b("Failed get enabledSetting", throwable3);
                        }
                    }
                    ApplicationInfo applicationInfo0 = packageInfo0.applicationInfo;
                    if(applicationInfo0 != null) {
                        if(applicationInfo0.backupAgentName != null) {
                            luaTable0.d("backupAgentName", applicationInfo0.backupAgentName);
                        }
                        if(applicationInfo0.className != null) {
                            luaTable0.d("className", applicationInfo0.className);
                        }
                        if(applicationInfo0.dataDir != null) {
                            luaTable0.d("dataDir", applicationInfo0.dataDir);
                        }
                        luaTable0.b("descriptionRes", applicationInfo0.descriptionRes);
                        luaTable0.b("flags", applicationInfo0.flags);
                        luaTable0.b("icon", applicationInfo0.icon);
                        luaTable0.b("labelRes", applicationInfo0.labelRes);
                        luaTable0.b("logo", applicationInfo0.logo);
                        if(applicationInfo0.manageSpaceActivityName != null) {
                            luaTable0.d("manageSpaceActivityName", applicationInfo0.manageSpaceActivityName);
                        }
                        if(applicationInfo0.name != null) {
                            luaTable0.d("name", applicationInfo0.name);
                        }
                        if(applicationInfo0.nativeLibraryDir != null) {
                            luaTable0.d("nativeLibraryDir", applicationInfo0.nativeLibraryDir);
                        }
                        if(applicationInfo0.packageName != null) {
                            luaTable0.d("packageName", applicationInfo0.packageName);
                        }
                        if(applicationInfo0.permission != null) {
                            luaTable0.d("permission", applicationInfo0.permission);
                        }
                        if(applicationInfo0.processName != null) {
                            luaTable0.d("processName", applicationInfo0.processName);
                        }
                        if(applicationInfo0.publicSourceDir != null) {
                            luaTable0.d("publicSourceDir", applicationInfo0.publicSourceDir);
                        }
                        if(applicationInfo0.sourceDir != null) {
                            luaTable0.d("sourceDir", applicationInfo0.sourceDir);
                        }
                        luaTable0.b("targetSdkVersion", 22);
                        if(applicationInfo0.taskAffinity != null) {
                            luaTable0.d("taskAffinity", applicationInfo0.taskAffinity);
                        }
                        luaTable0.b("theme", applicationInfo0.theme);
                        luaTable0.b("uid", applicationInfo0.uid);
                        String s1 = Tools.a(applicationInfo0);
                        if(s1 != null) {
                            luaTable0.d("label", s1);
                        }
                    }
                    return luaTable0;
                }
            }
            catch(PackageManager.NameNotFoundException packageManager$NameNotFoundException0) {
                la.b(("Pkg not found: " + s), packageManager$NameNotFoundException0);
            }
        }
        return luaValue0;
    }

    @Override  // android.ext.Script$ApiFunction
    protected int m_() {
        return 0;
    }
}

