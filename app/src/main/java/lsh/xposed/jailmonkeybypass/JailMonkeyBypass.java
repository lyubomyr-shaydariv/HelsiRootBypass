package lsh.xposed.jailmonkeybypass;

import java.util.HashMap;

import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

public class JailMonkeyBypass implements IXposedHookLoadPackage {
    @Override
    public void handleLoadPackage(XC_LoadPackage.LoadPackageParam lpparam) throws Throwable {
        XposedHelpers.findAndHookMethod(
                "com.gantix.JailMonkey.JailMonkeyModule",
                lpparam.classLoader,
                "getConstants",
                new XC_MethodHook() {
                    @Override
                    @SuppressWarnings("unchecked")
                    protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                        Object originalResult = param.getResult();
                        HashMap<String, Object> constants = null;

                        if (originalResult instanceof HashMap) {
                            constants = (HashMap<String, Object>) originalResult;
                        } else {
                            constants = new HashMap<>();
                        }

                        constants.put("isJailBroken", false);
                        constants.put("hookDetected", false);
                        constants.put("canMockLocation", false);
                        constants.put("AdbEnabled", false);
                        param.setResult(constants);

                    }
                }
        );
    }
}
