package test;

public class Test2 {

	
	public static void main(String[] args) {
		String s0 = "111";   			//pool
		String s1 = new String("111");  //heap
		final String s2 = "111";        //pool
		String s3 = "sss111";           //pool
		String s4 = "sss" + "111";      //pool
		String s5 = "sss" + s0;         //heap 
		String s6 = "sss" + s1;         //heap
		String s7 = "sss" + s2;         //pool
		String s8 = "sss" + s0;         //heap
		System.out.println(s3 == s4);   //true
		System.out.println(s3 == s5);   //false
		System.out.println(s3 == s6);   //false
		System.out.println(s3 == s7);   //true
		System.out.println(s5 == s6);   //false
		System.out.println(s5 == s8);	//false
	}

}	
