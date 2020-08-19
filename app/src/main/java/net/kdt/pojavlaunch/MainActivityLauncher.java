package net.kdt.pojavlaunch;

import dalvik.system.*;

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
		loader.loadClass("com.android.command.am.Am")
			.getMethod("main", String[].class)
			.invoke(null, amArgs.split(" "));
	}
}

