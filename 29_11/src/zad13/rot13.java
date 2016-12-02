package zad13;

public class rot13 {

	public static String[] cypher(String[] arr) {
		String[] result = new String[arr.length];
		for (int i = 0; i < arr.length; i++) {
			if (!arr[i].trim().equals("")) {
				char s = arr[i].charAt(0);
				int nr=(int)s;
				int tillEnd;
				int k=0;
				if(nr>96){
				tillEnd=122-nr;
				k=1;
				}
				else{
				tillEnd=90-nr;
				}
				if(tillEnd<13){
				if(k==1){
				s=(char)(13-tillEnd+96);
				}
				else s=(char)(13-tillEnd+64);
				}
				
				else s+=13;
				
				result[i]=String.valueOf(s);
			
			}
			else result[i]=arr[i];
		}
		return result;
	}
	
	
	public static String[] deCypher(String[] arr) {
		String[] result = new String[arr.length];
		for (int i = 0; i < arr.length; i++) {
			if (!arr[i].trim().equals("")) {
				char s = arr[i].charAt(0);
				int nr=(int)s;
				int tillBeg;
				int k=0;
				if(nr>96){
				k=1;
				tillBeg=nr-97;
				}
				else{
				tillBeg=nr-65;
				}
				if(tillBeg<13){
					if(k==1){
				
				s=(char)(123+tillBeg-13);
					}
					else s=(char)(91+tillBeg-13);
				}
				
				else s-=13;
				
				result[i]=String.valueOf(s);
			
			}
			else result[i]=arr[i];
		}
		return result;
	}
}
