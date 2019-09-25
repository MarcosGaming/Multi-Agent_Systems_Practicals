import jade.core.Agent;
import jade.core.AID;

public class BookBuyerAgent extends Agent {
	// Title of the book to buy
	private String targetBookTitle;
	// The list of knwon seller agents
	private AID[] sellerAgents = {new AID("seller1", AID.ISLOCALNAME), new AID("seller2", AID.ISLOCALNAME)};
	
	// Agent initialization
	protected void setup() {
		// Print welcome message
		System.out.println("Hello! Buyer-agent " + this.getAID().getName()+" is ready.");
		// Get the title of the book to buy
		Object[] args = getArguments();
		if(args != null && args.length > 0) {
			targetBookTitle = (String) args[0];
			System.out.println("Trying to buy " + targetBookTitle);
		}else {
			// Agent terminates when there is no book to buy
			System.out.println("No book title specified");
			doDelete();
		}
	}
	
	// Agent clean-up operations
	protected void takeDown() {
		// Printout dismissal message
		System.out.println("Buyer-agent " + this.getAID().getName() + " terminating.");
	}

}
