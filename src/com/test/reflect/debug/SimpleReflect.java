package com.test.reflect.debug;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import com.test.reflect.pojo.Person;

public class SimpleReflect {

	public static void main(String[] args) throws Exception {
		System.out.println("----遍历args------"+args.length);
		for(String s:args){
			System.out.println(s);
		}
	/*	System.out.println("-----construtorTestOne()------");
		construtorTestOne();
		System.out.println("-----construtorTestTwo()------");
		construtorTestTwo();
		System.out.println("-----fieldTestOne()------");
		fieldTestOne();
		System.out.println("-----methodTestOne()------");
		methodTestOne();
		System.out.println("-----runMain(String className)------");*/

	}

	/**
	 * 关于构造方法的反射
	 */
	public static void construtorTestOne() throws Exception {
		// 访问控制符为public,参数为String类型的构造函数，测试
		Person person1 = new Person("114.2354", "30.2136");
		Constructor cons1 = Person.class.getConstructor(String.class, String.class);
		Person person2 = (Person) cons1.newInstance("114.2354", "30.2136");
		System.out.println("-----------------");
		// 输出字符串的一些信息
		System.out.println("person1对象的lng属性为：" + person1.getLng());
		System.out.println("person2对象的lng属性为：" + person2.getLng());
		System.out.println("-----------------");
	}
	/**
	 * 关于构造方法的反射
	 */
	public static void construtorTestTwo() throws Exception {
		// 防伪控制符为privat，参数为int类型的构造函数，测试
		Constructor cons1 = Person.class.getDeclaredConstructor(int.class, int.class);
		cons1.setAccessible(true);
		Person person2 = (Person) cons1.newInstance(114, 30);
		System.out.println("-----------------");
		// 输出字符串的一些信息
		System.out.println("person2对象的X属性为：" + person2.getX());
		System.out.println("-----------------");
	}
	/**
	 * 关于字段的反射
	 */
	public static void fieldTestOne() throws Exception{
		Person person=new Person("uid002", "114.2314", "30.1254", 12, 15);
		Field fieldX=person.getClass().getField("x");
		System.out.println("person.x:"+fieldX.getInt(person));
		System.out.println("person.x:"+fieldX.get(person));
		
		Field fieldLat=person.getClass().getDeclaredField("lat");
		fieldLat.setAccessible(true);
		System.out.println("person.lat:"+fieldLat.get(person));
		//遍历参数为int类型的字段（public）
		Field[] fieldArray1=person.getClass().getFields();//getFields()只能获得public访问控制符的字段
		for(Field field:fieldArray1){	
		   
			System.out.println("输出："+field.get(person));
			
			if(field.getType()==int.class){
				System.out.println("满足条件field.getType()==int.class的输出："+field.get(person));
			}
			
		}
		
		//遍历参数为String类型的字段(private)
		Field[] fieldArray2=person.getClass().getDeclaredFields();//可以获得所有字段
		for(Field field:fieldArray2){	
			field.setAccessible(true);
			System.out.println("输出："+field.get(person));
			
			if(field.getType()==String.class){
				System.out.println("满足条件field.getType()==String.class的输出："+field.get(person));
			}
			if(field.getType()==int.class){
				System.out.println("满足条件field.getType()==int.class的输出："+field.get(person));
			}
			
		}
	}
	
	
	/**
	 * 关于成员方法的反射
	 */
	public static void methodTestOne() throws Exception{
		Person person=new Person("uid002", "114.2314", "30.1254", 12, 15);
		System.out.println("--单个方法反射--");
		Method methodSetUid=Person.class.getMethod("setUid",String.class);
		Method methodGetUid=Person.class.getMethod("getUid");
		System.out.println(methodGetUid.invoke(person));
		methodSetUid.invoke(person,"uid002改变为uid001");
		System.out.println(methodGetUid.invoke(person));
		System.out.println("----------");
		
		Method[] methodArray=person.getClass().getDeclaredMethods();
		for(Method method:methodArray){
			if(method.getReturnType()==String.class){
				if(method.getParameterCount()==0){
				method.setAccessible(true);
				System.out.println(method.getName()+" -- run result:"+method.invoke(person));
				}
			}
		}
	}
	
	

}
