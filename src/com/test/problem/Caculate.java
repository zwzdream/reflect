package com.test.problem;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Caculate {

	public static void main(String[] args) {
		 //可选选项
        String[] numArray = new String[]{"A","B","C","D"};
        //穷举每一次产生的一条选项结果
        String[] initArray = new String[]{"A","A","A","A","A","A","A","A","A","A"};
        List<String> selectList = Arrays.asList(initArray);
        for(String a : numArray){
            selectList.set(0,a);
            for(String b : numArray){
                selectList.set(1,b);
                for(String c : numArray){
                    selectList.set(2,c);
                    for(String d : numArray){
                        selectList.set(3,d);
                        for(String e : numArray){
                            selectList.set(4,e);
                            for(String f : numArray){
                                selectList.set(5,f);
                                for(String g : numArray){
                                    selectList.set(6,g);
                                    for(String h : numArray){
                                        selectList.set(7,h);
                                        for(String i : numArray){
                                            selectList.set(8,i);
                                            for(String j : numArray){
                                                selectList.set(9,j);
                                                boolean result = check(selectList);
                                                if(result==true){
                                                    System.out.println("结果为:"+selectList.toString());
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    


	}
	

	
	//所有条件满足才是正确答案
	 public static boolean check(List<String> list){
		 if(check3(list)&&check4(list)&&check5(list)&&check6(list)&&check7(list)&&check8(list)&&check9(list)&&check10(list)){
			 return true;
		 }
		 return false;
	 }

	
	/**
	 * 查看参数（String类型）是否全部相同，是的话，返回true，否则返回false；
	 * @return
	 */
	public  static boolean functionOne(String... strings ){
		boolean flag= true;
		for(int i=1;i<strings.length;i++){
			flag =strings[i].equals(strings[i-1]);
			if(flag == false)
				break;
		}
		return flag;
	}
	
	/**
	 * 计算出十道题里面每个选项出现次数的总数
	 * @return
	 */
	public  static Map<Integer,String> functionTwo(List<String> list ){
		Map<Integer,String> counts=new HashMap<Integer,String>();
		int A = 0,B=0,C=0,D=0;
	     for(String str :list){
		   switch (str) {
		   case "A":A+=1;break;
		   case "B":B+=1;break;
		   case "C":C+=1;break;
		   case "D":D+=1;break;
		   default:
		   break;
		  }
	    }
	     counts.put(A, "A");
	     counts.put(B, "B");
	     counts.put(C, "C");
	     counts.put(D, "D");
		return counts;
	}
	
	/**
	 * 计算出十道题里面每个选项出现次数的总数,并查看最小的是哪个字母
	 * @return
	 */
	public  static boolean functionThree(String str,Map<Integer,String> counts ){
		// 先求Map<K,V>中Key(键)的最小值
		Set<Integer> set=counts.keySet();
		Object[] obj=  set.toArray();
		Arrays.sort(obj);
		String minStr=counts.get(obj[0]);
		//根据key拿到value，与传过来的值比较
		if(minStr.equals(str)){
			return true;
		}
		return false;
	}
	
	
	public static boolean check3(List<String> list){// 2 3 4 6
		String anwser=list.get(2);
		switch (anwser)
		{
	    case "A"://2 4 6  same
	    	return functionOne(list.get(1),list.get(3),list.get(5));
	    case "B":  //2 3 4 same
	    	return functionOne(list.get(1),list.get(2),list.get(3));
		case "C": //3 4 6   same
			return functionOne(list.get(2),list.get(3),list.get(5));
		case "D": //2 3 6   same
			return functionOne(list.get(1),list.get(2),list.get(5));
		default:
				return false;
		}
			
	}
	
	public static boolean check4(List<String> list){//15  27  19  6 10
		String anwser=list.get(3);
		switch (anwser)
		{
	    case "A"://1  5  same
	    	return  functionOne(list.get(0),list.get(4));
	    case "B":  //2 7 same
	    	return  functionOne(list.get(1),list.get(6));
		case "C": //1   9 same
			return  functionOne(list.get(0),list.get(8));
		case "D": // 6  10 same
			return  functionOne(list.get(5),list.get(9));
		default:
			return false;
		}
	}
	
	public static boolean check5(List<String> list){//8 4 9  7
		String anwser=list.get(4);
		switch (anwser)
		{
		case "A"://8  5  same
			return  functionOne(list.get(7),list.get(4));
		case "B":  //4   5 same
			return  functionOne(list.get(3),list.get(4));
		case "C": //5   9 same
			return  functionOne(list.get(4),list.get(8));
		case "D": // 5  7 same
			return  functionOne(list.get(4),list.get(6));
		default:
			return false;
		}
	}
	
	public static boolean check6(List<String> list){
		String anwser=list.get(5);
		switch (anwser)
		{
		case "A"://8  2  4  same
			return  functionOne(list.get(7),list.get(1),list.get(3));
		case "B":  //8  1   6 same
			return  functionOne(list.get(7),list.get(0),list.get(5));
		case "C": //8  3   10 same
			return  functionOne(list.get(7),list.get(2),list.get(9));
		case "D": //8 5  9 same
			return  functionOne(list.get(7),list.get(4),list.get(8));
		default:
			return false;
		}
	}
	
	public static boolean check7(List<String> list){
		String anwser=list.get(6);
		Map<Integer,String> counts=functionTwo(list);
		switch (anwser)
		{
		case "A"://C  min
			return  functionThree("A",counts);
		case "B":  //B  min
			return  functionThree("B",counts);
		case "C": //A   min
			return  functionThree("C",counts);
		case "D": //D   min
			return  functionThree("D",counts);
		default:
			return false;
		}
	}
	
	public static boolean check8(List<String> list){
		String anwser7=list.get(7);
		String anwser1=list.get(0);
		switch (anwser7)//与第一题的答案在字母中不相邻
		{
		case "A"://7 
			return  Math.abs((int)list.get(6).charAt(0)-(int)anwser1.charAt(0))>1;
		case "B":  //5
			return  Math.abs((int)list.get(4).charAt(0)-(int)anwser1.charAt(0))>1;
		case "C": //2
			return  Math.abs((int)list.get(1).charAt(0)-(int)anwser1.charAt(0))>1;
		case "D": //10
			return  Math.abs((int)list.get(9).charAt(0)-(int)anwser1.charAt(0))>1;
		default:
			return false;
		}
	}
	
	
	public static boolean check9(List<String> list){
		String anwser9=list.get(8);
		String anwser6=list.get(5);
		String anwser1=list.get(0);
		String anwser5=list.get(4);
		
		if(anwser1.equals(anwser6)){
			switch (anwser9) {
			case "A"://6
				if(!list.get(5).equals(anwser5))  return true;  break;
			case "B"://10
				if(!list.get(9).equals(anwser5))  return true;  break;
			case "C"://2
				if(!list.get(1).equals(anwser5))  return true;  break;
			case "D"://9
				if(!list.get(8).equals(anwser5))  return true;  break;
				 

			default: return false;
			}
			  
			
		}else{
			switch (anwser9) {
			case "A"://6
				if(list.get(5).equals(anwser5))  return true;  break;
			case "B"://10
				if(list.get(9).equals(anwser5))  return true;  break;
			case "C"://2
				if(list.get(1).equals(anwser5))  return true;  break;
			case "D"://9
				if(list.get(8).equals(anwser5))  return true;  break;
				 

			default: return false;
			}
		}
		return false;
	}
	
	public static boolean check10(List<String> list){
		String anwser=list.get(9);
		Map<Integer,String> counts=functionTwo(list);
		Set<Integer> set=counts.keySet();
		Object[] obj=  set.toArray();
		Arrays.sort(obj);
		int a=(int) obj[obj.length-1]-(int) obj[0];
		//根据key拿到value，与传过来的值比较
		switch (anwser) {
		case "A"://6
			if(3==a)  return true;  break;
		case "B"://10
			if(2==a)  return true;  break;
		case "C"://2
			if(4==a)  return true;  break;
		case "D"://9
			if(1==a)  return true;  break;
			 

		default: return false;
		}
		
		return false;
	}
	
	

}
