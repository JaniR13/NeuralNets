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
	
	public FeedForwardANN(int layers){
		this.layers = layers;
		
		// makes list of nodes
		// TODO: decide if we want an input layer or not
		// TODO: also decide how deep we want our layers to be...for now, just arbitrarily chose 4, with 4 inputs
		nodes = new ArrayList<ArrayList<ANNNode>>();
		LogisticFunction l = new LogisticFunction();
		
		for (int i = 0; i < layers; i++){
			ArrayList<ANNNode> nextLayer = new ArrayList<ANNNode>();
			for (int j = 0; j < 4; j++){
				nextLayer.add(new ANNNode(l, 4));
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
		// TODO Auto-generated method stub

	}
	
	public void backProp(){
		
	}
	
	/** To be used for testing */
	public void print(){
		// goes by layer
		for (int l = 0; l < layers; l++){
			// for each node in the layer:
			for (int n = 0; n < nodes.get(l).size(); n++){
				System.out.print("[" + l + ", " + n + "]  ");
				double[] weights = nodes.get(l).get(n).getWeights();
				for (int w = 0; w < weights.length; w++){
					DecimalFormat twoDForm = new DecimalFormat("#.##");
				    double weight = Double.valueOf(twoDForm.format(weights[w]));
					System.out.print(" w" + w + ": " + weight);
				}
				System.out.print(" ");
			}
			System.out.println();
			System.out.println();
		}
	}

}
