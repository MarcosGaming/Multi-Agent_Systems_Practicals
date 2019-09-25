import jade.core.Profile;
import jade.core.ProfileImpl;
import jade.wrapper.AgentController;
import jade.wrapper.ContainerController;
import jade.core.Runtime;

public class Application {
	
	public static void main(String[] args) {
		// Setup JADE environment
		Profile myProfile = new ProfileImpl();
		Runtime myRuntime = Runtime.instance();
		ContainerController myContainer = myRuntime.createMainContainer(myProfile);
		try {
			// Start the agent controller which is itself an agent
			AgentController rma = myContainer.createNewAgent("rma","jade.tools.rma.rma", null);
			rma.start();
			// Now start your own BookBuyerAgent called buyer
			String[] books = {"Java for Dummies"};
			AgentController myAgent = myContainer.createNewAgent("buyer", BookBuyerAgent.class.getCanonicalName(), books);
			myAgent.start();
		} catch(Exception e){
			System.out.println("Exception starting agent: " + e.toString());
		}
	}

}
