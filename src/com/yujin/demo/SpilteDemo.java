package com.yujin.demo;

public class SpilteDemo {
	public static void main(String[] args) {
		String str = "$BDSIM,320572, 0, 11, 6, \n60, 3, 0, 00\n";
		String[] str2 = str.split("\n");
		System.out.println(str2.length);
//		for (int i = 0; i < str2.length; i++) {
//			System.out.println(str2[i]);
//		}
		
		String str3 = "$BDPOW, 0, 0, 0, 0, 0, 2";
		String[] splite = str.split(",");
        for (int i = 0; i < splite.length; i++) {
        	System.out.println(splite[i]);
        }
        
        switch(1) {
        case 1:
        	System.out.println("--->1");
        	break;
        case 2:
        	System.out.println("--->2");
        	break;
        case 3:
        	System.out.println("--->3");
        	break;
        	default:
        		System.out.println("default");
        }
	}
	
	public void playGame() {
		int a = 0;
	}
}
