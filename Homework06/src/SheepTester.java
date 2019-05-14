/*
 * Tyler Shatley
 * csce146
 * homework06
 */
public class SheepTester {

	public static void main(String[] args) {
		
		SheepHeap SH = new SheepHeap(15); //i think it should be 15??
		Sheep sheep = new Sheep();
		
		
		//inserting 15 sheep
		
		//sheep #1
		sheep = new Sheep();
		SH.addSheep(new Sheep("Jasmine",69.0));//1)
		SH.addSheep(new Sheep("Jerome",69.8));//2 
		SH.addSheep(new Sheep("Jamal",64));//3//
		SH.addSheep(new Sheep("Lynn",12));//4
		SH.addSheep(new Sheep("Tyler",420));//5
		SH.addSheep(new Sheep("DiAngelo",66.6));//6
		SH.addSheep(new Sheep("Ebony",12));//7
		SH.addSheep(new Sheep("Precious",45));//8
		SH.addSheep(new Sheep("Dale",100));//9
		SH.addSheep(new Sheep("Crystal",86));//10
		SH.addSheep(new Sheep("De'Shawn",105));//11
		SH.addSheep(new Sheep("Rolonda",32));//12
		SH.addSheep(new Sheep("Betsy",734));//13
		SH.addSheep(new Sheep("LaQuisha",345));//14
		SH.addSheep(new Sheep("Jeff",87));//15
		
		System.out.println("\nRoll call for the sheep!!");
		SH.sheepRollCall();
		
		System.out.println("\nPrinting in order by weight");
		SH.sheepHeapSort();
		
		System.out.println("\nRemoving 5 sheep");
		SH.removeSheep();
		SH.removeSheep();
		SH.removeSheep();
		SH.removeSheep();
		SH.removeSheep();
		
		
		System.out.println("\nRoll call for the 10 remaining sheep");
		SH.sheepRollCall();	
	}
}
