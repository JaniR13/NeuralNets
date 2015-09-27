package runmodels;

//import java.text.DecimalFormat;
import java.util.ArrayList;

public class FeedForwardANN extends AbstractModel {
	
	// https://svn.cms.waikato.ac.nz/svn/weka/branches/stable-3-2-1/weka/classifiers/neural/NeuralNetwork.java

	
	private AbstractFunction lossFunction;
	private double[] inputs;
	private double output;
	private int layers;
	// note: each "sub" arraylist is the nodes in a layer (didn't use a 2D array in case different
	// layers have different numbers of nodes)
	private ArrayList<ArrayList<ANNNode>> nodes;
	
	// TODO: this needs to go away once we figure out how to actually set this to something reasonable.
	private int arbitraryLayerDepth = 4;
	
	public FeedForwardANN(int layers){
		this.layers = layers;
		
		// makes list of nodes
		// TODO: decide how deep we want our layers to be...for now, just arbitrarily chose 4, with 4 inputs
		nodes = new ArrayList<ArrayList<ANNNode>>();
		LogisticFunction l = new LogisticFunction();
		
		// creates individual nodes
		for (int i = 0; i < layers; i++){
			// creates one layer at a time
			ArrayList<ANNNode> nextLayer = new ArrayList<ANNNode>();
			for (int j = 0; j < arbitraryLayerDepth; j++){
				ANNNode nextNode = new ANNNode(l, arbitraryLayerDepth);
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

	@Override
	void compileResults() {
		// TODO Auto-generated method stub

	}

	@Override
	void execute() {
		// TODO: this will need to somehow take input, so that we can generate the output and use backprop 
		// when executing

	}
	
	public double generateOutput(double[] inputs){
		// TODO: this would be a great place to throw an error if we get the wrong number of inputs
		this.inputs = inputs;
		
		// TODO: this is going to be broken. SO broken.
		// TODO: figure out stuff with bias node
		
		// runs through one layer at a time
		for (int i = 0; i < layers; i++){
			for (ANNNode n : nodes.get(i)){
				// steps: 
				// 1. get inputs into input nodes
				// 2. pass output of input nodes into first hidden layer
				// 3. calculate output for each node in hidden layer, pass output into next layer
				// 4. once you hit the output layer, save the output of that layer into a list/array and print
			}	
		}
		
		return -1.0;
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

}
