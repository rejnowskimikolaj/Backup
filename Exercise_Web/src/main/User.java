package main;
import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import org.json.simple.JSONObject;

public class User {

	/* Zaprojektuj strukturê danych dla przyk³adowego u¿ytkownika. 
	 * Struktura powinna deklarowaæ pola tj. imiê, nazwisko, adres, telefon, numer karty kredytowej,
	 *  pesel. Przygotuj plik imiona.txt, nazwiska.txt, ulice.txt, które bêd¹ zawiera³y przyk³adowe dane. 
	 *  Nastêpnie w klasie dostarcz metody, które wygeneruj¹ losowe dane, losowego u¿ytkownika. 
	 *  Generator numeru pesel powinien generowaæ pesel, który przedzie walidacjê (tj. poprawny numer).
`*/
	
	
	private String name;
	private String lastName;
	private Adress adress;
	private long phoneNumber;
	private long cc;
	private String pesel;
	private GenderType gender;
	
	
	
	
	
	public User(String name, String lastName, Adress adress, long phoneNumber, long cc, String pesel) {
		super();
		this.name = name;
		this.lastName = lastName;
		this.adress = adress;
		this.phoneNumber = phoneNumber;
		this.cc = cc;
		this.pesel = pesel;
		
	}
	
	public User(){
		
		this.name=randomName();
		this.lastName=randomLastName();
		this.cc=randomCC();
		this.phoneNumber=randomPhoneNumber();
		this.adress = new Adress();
		setGender();
		this.pesel=randomPesel();
	}
	
	public  String  randomPesel(){
		Random rd = new Random();
		String pesel = getPeselYear();
		String []peselStringArr = pesel.split("");
		int []	peselIntArr = new int[peselStringArr.length+5];
		for(int i=0;i<peselStringArr.length;i++){
			peselIntArr[i]=Integer.parseInt(peselStringArr[i]);
		}
		
		for(int i = 6;i<=8;i++){
			peselIntArr[i]=rd.nextInt(10);
		}
		
		int [] odds = {1,3,5,7,9};
		int [] notOdds={0,2,4,6,8};
		if(this.gender.equals(GenderType.Female)){
			peselIntArr[9] = notOdds[rd.nextInt(5)];
		}
		
		else {
			peselIntArr[9] = odds[rd.nextInt(5)];
		}
		
		
		//9×a + 7×b + 3×c + 1×d + 9×e + 7×f + 3×g + 1×h + 9×i + 7×j
		
		int [] weights = {9,7,3,1,9,7,3,1,9,7};
		double sum=0;
		for(int i=0;i<weights.length;i++){
			sum+=weights[i]*peselIntArr[i];
		}
		 sum=sum%10;
		 peselIntArr[10]=(int) sum;
		 pesel = "";
		 for(int x: peselIntArr){
				pesel+=x;
			}
		return pesel;
		
	}

	private String getPeselYear(){
		Random random = new Random();
		int minDay = (int) LocalDate.of(1900, 1, 1).toEpochDay();
		int maxDay = (int) LocalDate.of(2015, 1, 1).toEpochDay();
		long randomDay = minDay + random.nextInt(maxDay - minDay);
		LocalDate randomBirthDate = LocalDate.ofEpochDay(randomDay);
		String pesel = "";
		String year = randomBirthDate.getYear()+"";
		pesel+=year.substring(2);
		int month = randomBirthDate.getMonthValue();
		String monthString;
		if(month<10) monthString ="0"+month;
		else monthString=month+"";
		int day = randomBirthDate.getDayOfMonth();
		String dayString="";
		if(day<10) dayString = "0"+day;
		else dayString = day+"";
		
		return pesel+monthString+dayString;
	}
		
	
	private String randomName(){
		File f = new File("src//resources//imiona.txt");
		ArrayList<String> list = new ArrayList<String>();
		Scanner sc;
		try {
			sc = new Scanner(f);
			while(sc.hasNextLine()){
				list.add(sc.nextLine());
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Random rd = new Random();
		
		return list.get(rd.nextInt(list.size()));
	}
	
	private String randomLastName(){
		File f = new File("src//resources//nazwiska.txt");
		ArrayList<String> list = new ArrayList<String>();
		Scanner sc;
		try {
			sc = new Scanner(f);
			while(sc.hasNextLine()){
				list.add(sc.nextLine());
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Random rd = new Random();
		
		return list.get(rd.nextInt(list.size()));
	}
	private void setGender(){
		String lastLetter = this.name.substring(this.name.length()-1);
		if(lastLetter.equals("a")) this.gender=GenderType.Female;
		else this.gender=GenderType.Male;
	}
	
	
	
	private long randomPhoneNumber(){
		Random rd = new Random();
		String result="";
		for(int i =0;i<9;i++){
			result+= rd.nextInt(10);
		}
		return Long.parseLong(result);
	}
	
	private long randomCC(){
		Random rd = new Random();
		String result="";
		for(int i =0;i<12;i++){
			result+= rd.nextInt(10);
		}
		return Long.parseLong(result);
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Adress getAdress() {
		return adress;
	}
	public void setAdress(Adress adress) {
		this.adress = adress;
	}
	public long getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public long getCc() {
		return cc;
	}
	public void setCc(long cc) {
		this.cc = cc;
	}
	public String getPesel() {
		return pesel;
	}
	public void setPesel(String pesel) {
		this.pesel = pesel;
	}

	public GenderType getGender() {
		return gender;
	}

	public void setGender(GenderType gender) {
		this.gender = gender;
	}
	
	public String toString(){
		return name+" "+lastName+" "+pesel+"\n"+adress+"\n"+"cc "+cc;
	}
	
	public JSONObject getJSONObject(){
		
		JSONObject user = new JSONObject();
		user.put("name", name);
		user.put("lastName", lastName);
		user.put("pesel", pesel);
		user.put("adress", adress.getJSONObject());
		user.put("gender", gender.toString());
		user.put("cc", cc);

		return user;
	}
}
