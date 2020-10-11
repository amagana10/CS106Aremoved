
public class DeletingCharacterFromString {
	
	public static String removelAllOccurrences(String str, char ch) {
		String result = "";
		for (int i = 0; i< str.length(); i++) {
			if (str.charAt(i)!= ch) {
				result += str.charAt(i);
			}
			
		}
		
		return result;
	}
 public static void main(String[] args) {
	 
	System.out.println(removelAllOccurrences("This is a test", 't'));
	System.out.println(removelAllOccurrences("summer is a here!", 'e'));
	System.out.println(removelAllOccurrences("-----0---- ", '-'));
	
	 
 }
}
