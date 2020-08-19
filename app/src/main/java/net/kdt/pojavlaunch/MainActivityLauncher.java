package net.kdt.pojavlaunch;

import dalvik.system.*;
import java.lang.reflect.*;

public class MainActivityLauncher
{
	/* Arguments
	 *
	 * - Activity at ComponentName
	 * - Optimized directory
	 * - Native search path
	 */
	public static void main(String[] args) throws Throwable {
		String amArgs = "start --user 0 " + args[0];
		System.out.println("Executing ActivityManager arguments: " + amArgs);
		DexClassLoader loader = new DexClassLoader("/system/framework/am.jar", "" /* args[1] */, "" /* System.getProperty("java.library.path") */ , MainActivityLauncher.class.getClassLoader());
		Class cls = loader.loadClass("com.android.commands.am.Am");
		Method method = cls.getMethod("main", String[].class);
		method.invoke(null, new Object[]{amArgs.split(" ")});
	}
}

