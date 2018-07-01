package com.test.reflect.debug;

import java.lang.annotation.Target;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MainReflect {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		runMain("com.test.reflect.debug.SimpleReflect");
	}
	
	/**
	 * main方法反射调用
	 * @throws InvocationTargetException 
	 * @throws IllegalArgumentException 
	 * @throws IllegalAccessException 
	 * @throws ClassNotFoundException 
	 * @throws SecurityException 
	 * @throws NoSuchMethodException 
	 * @throws InstantiationException 
	 */
	public static void runMain(String className) throws Exception{
		//获取该类的main方法
		Method mainMethod=Class.forName(className).getMethod("main", String[].class);
		//run
		
		/*基本类型的一维数组可以被当做Object类型使用，而不能当做Object[]类型使用；
		 * 非基本类型的一维数组，既可以当做Object类型使用，又可以当做Object[]类型使用
		 * 一个方法中接受可变参数的地方，如果传入数组，就会自动分解为多个参数
		 */
		//这一点特别注意:这里使用new Object[]数组将new String[] 进行打包成一个对象  
		//1
		mainMethod.invoke(null, new Object[]{new String[]{"111","222","333"}});
		//2
		mainMethod.invoke(null, (Object)new String[]{"111","222","333"});
		//
		
		//下面两个个不行,因为java会自动拆包
		//mainMethod.invoke(null, (Object[])new String[]{"111","222","333"});
		//mainMethod.invoke(null, new String[]{"111","222","333"});
		//3
		Object arrayObj =Array.newInstance(String.class, 3);
		Array.set(arrayObj, 0, "111");
		Array.set(arrayObj, 1, "222");
     	Array.set(arrayObj, 2, "333");
		mainMethod.invoke(null, arrayObj);
		
		
		
		
		
	}

}
