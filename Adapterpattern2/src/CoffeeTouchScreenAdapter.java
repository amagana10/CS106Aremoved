
public class CoffeeTouchScreenAdapter implements CoffeeMachineInterface  {

	OldCoffeeMachine theMachine;
	public CoffeeTouchScreenAdapter(OldCoffeeMachine newMachine) {
		theMachine = newMachine;
	}
	public void chooseFirstSelection() {
		theMachine.selectA();
	}
	public void chooseSecondSelection() {
		theMachine.selectB();
	}
}
