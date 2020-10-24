
public class CoffeeTouchscreenAdapter<theMachine> implements CoffeeMachineInterface  {
	static OldCoffeeMachine theMachine;

	public CoffeeTouchscreenAdapter(OldCoffeeMachine newMachine) {
		theMachine = newMachine;
	}
	
	public void chooseFirstSelection() {
		theMachine.selectA();
	}
	
	public void chooseSecondSelection() {
		theMachine.selectB();
}
public static void main(String[] args) {
	CoffeeTouchscreenAdapter d = new CoffeeTouchscreenAdapter(theMachine);
	
	d.chooseFirstSelection();
	d.chooseSecondSelection();
}
}
