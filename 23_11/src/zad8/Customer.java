package zad8;

public class Customer {
	private String name;
	private boolean member=false;
	private String memberType="None";
	
	public Customer(String name){
		this.name=name;
	}
	
	public Customer(String name,String memberType){
		this.name=name;
		this.memberType=memberType;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isMember() {
		return member;
	}

	public void setMember(boolean member) {
		this.member = member;
	}

	public String getMemberType() {
		return memberType;
	}

	public void setMemberType(String memberType) {
		this.memberType = memberType;
	}
	
	public String toString(){
		return "Customer[name="+name+",member type="+memberType+"]";
	}
	
	

}
