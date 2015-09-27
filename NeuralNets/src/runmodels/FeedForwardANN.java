package runmodels;

//import java.text.DecimalFormat;
import java.util.ArrayList;

public class FeedForwardANN extends AbstractModel {
	
	// https://svn.cms.waikato.ac.nz/svn/weka/branches/stable-3-2-1/weka/classifiers/neural/NeuralNetwork.java

	
	private AbstractFunction lossFunction;
	private ArrayList<Double> inputs;
	private double bias = 1;
	private double output;
	private int layers;
	// each "sub" arraylist is the nodes in a layer (didn't use a 2D array in case different
	// layers have different numbers of nodes)
	private ArrayList<ArrayList<ANNNode>> nodes;
	
	
	// TODO: this needs to go away once we figure out how to actually set this to something reasonable.
	private int arbitraryLayerDepth = 4;
	
	/**
	 * Creates a new feed-forward neural network
	 * @param layers number of layers in the network, INCLUDING hidden layer
	 */
	public FeedForwardANN(int layers){
		// TODO: refactor out into separate methods
		
		this.layers = layers;
		
		// TODO: decide how deep we want our layers to be...for now, just arbitrarily chose 4, with 4 inputs
		nodes = new ArrayList<ArrayList<ANNNode>>();
		
		createNetworkNodes();
		createNetworkLinks();
		
	}
	
	/** 
	 * Populates network with nodes
	 */
	private void createNetworkNodes(){
		LogisticFunction l = new LogisticFunction();
		
		// creates individual nodes
		for (int i = 0; i < layers; i++){
			// creates one layer at a time
			ArrayList<ANNNode> nextLayer = new ArrayList<ANNNode>();
			for (int j = 0; j < arbitraryLayerDepth; j++){
				ANNNode nextNode = new ANNNode(l);
				nextLayer.add(nextNode);
				// these two act as sort of an ID for the node
				nextNode.setLayer(i);
				nextNode.setDepth(j);
				
				// sets input nodes as, well, input nodes
				if (j == 0){
					nextNode.setInputNode(true);
					// and output nodes as output nodes
				} else if (j == arbitraryLayerDepth){
					nextNode.setOutputNode(true);
				}
			}
			nodes.add(nextLayer);
		}
	}
	
	/**
	 * Sets ancestor/descendant relationships for each node in network
	 */
	private void createNetworkLinks(){
		// set descendants
		for (int i = 0; i < layers-1; i++){
			for (ANNNode n1 : nodes.get(i)){
				// sets every node in the next layer as a descendant
				for (ANNNode n2 : nodes.get(i+1)){
					n1.addDescendant(n2);
				}
			}
		}
		
		// set ancestors
		for (int i = 1; i < layers; i++){
			for (ANNNode n1 : nodes.get(i)){
				// sets every node in the previous layer as an ancestor
				for (ANNNode n2 : nodes.get(i-1)){
					n1.addAncestor(n2);
				}
			}
		}
	}

	@Override
	void compileResults() {
		// TODO Auto-generated method stub

	}

	@Override
	void execute() {
		// TODO: this will need to somehow take input, so that we can generate the output and use backprop 
		// when executing

	}
	
	/**
	 * Runs input through neural net and reports outputs
	 * @param inputs ArrayList of Double-valued inputs, excluding bias
	 * @return ArrayList of all outputs 
	 */
	public ArrayList<Double> generateOutput(ArrayList<Double> inputs){
		// TODO: this would be a great place to throw an error if we get the wrong number of inputs
		// or at least check that our number of inputs matches our number of input nodes.
		this.inputs = inputs;
		
		// TODO: this is going to be broken. SO broken.
		// TODO: I think this is right - just add bias to input vector (?)
		this.inputs.add(bias);
		
		// steps: 
		// 1. get inputs into input nodes
		
		
		// runs through one layer at a time, EXCEPT input and output layers
		for (int i = 1; i < layers - 1 ; i++){
			for (ANNNode n : nodes.get(i)){
				// 2. pass output of input nodes into first hidden layer
				// 3. calculate output for each node in hidden layer, pass output into next layer
			}	
		}
		
		// 4. once you hit the output layer, save the output of that layer into a list/array and print
		
		return null;
	}
	
	public void backProp(){
		
	}
	
	/** To be used for testing */
	public void print(){
		// goes by layer
		for (int l = 0; l < layers; l++){
			// for each node in the layer:
			for (int n = 0; n < nodes.get(l).size(); n++){
				System.out.print(nodes.get(l).get(n).toString());
			}
			System.out.println();
			System.out.println();
		}
	}

	public ArrayList<Double> getInputs() {
		return inputs;
	}

	public ArrayList<ArrayList<ANNNode>> getNodes() {
		return nodes;
	}
	
	

}
