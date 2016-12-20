package main;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		User us = new User();
		System.out.println(us.getAdress());
		System.out.println(us.getAdress().getJSONObject());
		System.out.println(us.getJSONObject());
	}

}
