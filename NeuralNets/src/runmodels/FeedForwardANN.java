package runmodels;

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
		nodes = new ArrayList<ArrayList<ANNNode>>(this.layers);
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

}
