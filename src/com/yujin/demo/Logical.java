package com.yujin.demo;

public class Logical {

	public static void main(String[] args) {
		boolean a = true;
		boolean b = false;
		boolean c = true;
		System.out.println(a&b);
		System.out.println(a&c);
		System.out.println(b&c);
		System.out.println(a&b&c);
		int aa = 3;
		int bb = 3;
		int cc = 3;
		System.out.println("=============================");
		System.out.println(aa&bb);
		System.out.println(aa&cc);
		System.out.println(bb&cc);
		System.out.println(aa&bb&cc);
		if (a & b){
			System.out.println("a&b");
		} else 
			System.out.println("! a&b");
		if (a && b) {
			System.out.println("a&&b");
		} else {
			System.out.println("! a&&b");
		}
		System.out.println("=====================================");
		String str = "asdfadf";
		String str2 = null;
		System.out.println(str2 != null && str2.equals("sss"));
		//System.out.println(str2 != null & str2.equals("sss"));
		System.out.println("===================================");
		System.out.println(aa | bb);
		
		System.out.println("===============================");
		int x = 12;
		int k = 3;
		System.out.println(Integer.toBinaryString(x));
		System.out.println((x&((1<<k)-1)));
		System.out.println("===========================");
		swap(2,5);
		System.out.println("=================================");
		int i = 25;
		int clear = 3;
		System.out.println(Integer.toBinaryString(i));
		System.out.println("before:" + i);
		System.out.println(i = i & ~clear);
		System.out.println("end:" + i);
	}
	
//	static void swap(int x, int y) {
//		System.out.println(x + ":" + y);
//		x ^= y;
//		y ^= x;
//		x ^= y;
//		System.out.println(x + ":" + y);
//	}

	static void swap(int x, int y) {
		System.out.println(x + ":" + y);
		y ^= x;
		x ^= y;
		y ^= x;
		System.out.println(x + ":" + y);
	}
}
