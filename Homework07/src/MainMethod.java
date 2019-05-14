/*
 * Tyler Shatley
 * csce146
 * homework07
 */
public class MainMethod {	
	public static void main(String[] args) {
		
		char [][] letters = new char[5][5];
		Methods meth = new Methods();
		meth.populateArr("stuff.txt",letters);
		meth.populateWords("dict.txt");
		meth.wordFinder(letters);
		
		
	}
}
