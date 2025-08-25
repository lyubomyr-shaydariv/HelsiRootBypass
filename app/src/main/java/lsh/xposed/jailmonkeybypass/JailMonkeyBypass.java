package lsh.xposed.jailmonkeybypass;

import java.util.HashMap;
import java.util.Map;

import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

public final class JailMonkeyBypass
		implements IXposedHookLoadPackage {

	@Override
	public void handleLoadPackage(final XC_LoadPackage.LoadPackageParam lpparam) {
		XposedHelpers.findAndHookMethod(
				"com.gantix.JailMonkey.JailMonkeyModule",
				lpparam.classLoader,
				"getConstants",
				new XC_MethodHook() {
					@Override
					protected void afterHookedMethod(final MethodHookParam param) {
						final Object originalResult = param.getResult();
						final Map<String, Object> result;
						if ( originalResult instanceof Map ) {
							@SuppressWarnings("unchecked")
							final Map<String, Object> castResult = (Map<String, Object>) originalResult;
							result = castResult;
						} else {
							result = new HashMap<>();
						}
						result.put("isJailBroken", false);
						result.put("hookDetected", false);
						result.put("canMockLocation", false);
						result.put("AdbEnabled", false);
						param.setResult(result);
					}
				}
		);
	}

}
