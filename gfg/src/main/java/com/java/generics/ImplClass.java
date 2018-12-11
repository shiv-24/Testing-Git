package com.java.generics;

public class ImplClass {

	public static void main(String[] args) {
//		List<BigDecimal> x	=	new List<>();
//		x.set(new BigDecimal(2.0));
//		System.out.println(x.add(new BigDecimal(4.0)));
		
		List<Integer> list	=	new List<Integer>();
		list.add(2);
		list.add(3);
		for(int i=0;i<list.size();i++) {
			System.out.println(list.getEle(i));
		}
		
		List<Double> listD	=	new List<Double>();
		
		listD.add(2.0);
		listD.add(3.0);
		listD.add(4.0);
		System.out.println("Double Values::");
		for(int i=0;i<listD.size();i++) {
			System.out.println(listD.getEle(i));
		}
		
		List<String> listS	=	new List<>();
		
		listS.add("Shivam");
		listS.add("Aggarwal");
		System.out.println("String Values::");
//		for(int i=0;i<listS.size();i++) {
//			System.out.println(listS.getEle(i));
//		}
		listS.forEach(lis->System.out.println(lis));
	}
}
