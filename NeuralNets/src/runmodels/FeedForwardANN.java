package runmodels;

import java.text.DecimalFormat;
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
				System.out.print("[" + l + ", " + n + "] ");
				double[] weights = nodes.get(l).get(n).getWeights();
				System.out.print("< ");
				for (int w = 0; w < weights.length; w++){
					DecimalFormat twoDForm = new DecimalFormat("#.##");
				    double weight = Double.valueOf(twoDForm.format(weights[w]));
					System.out.print(weight + " ");
				}
				System.out.print(": " + nodes.get(l).get(n).getOutput() +" >  ");
			}
			System.out.println();
			System.out.println();
		}
	}

}
