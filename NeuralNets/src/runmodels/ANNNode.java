package runmodels;

import java.text.DecimalFormat;
import java.util.ArrayList;

//import java.lang.Math.*;

public class ANNNode extends AbstractNode {
	
	private AbstractFunction f;
	private AbstractFunction lossFunction;
	private ArrayList<Double> inputs;
	// TODO: do the weights need to be < 1?
	private ArrayList<Double> weights;
	// TODO: should probably set output to whatever wo is
	private double output = 0;
	
	// these two only have meaning if it's part of a network
	private int layer = 0;
	private int depth = 0;
	
	// TODO: still need to add these
	private ArrayList<ANNNode> descendants = new ArrayList<ANNNode>();
	private ArrayList<ANNNode> ancestors = new ArrayList<ANNNode>();
	
	// input has no ancestors
	private boolean isInputNode = false;
	// output has no descendants
	private boolean isOutputNode = false;
	
	/**
	 * Constructs a perceptron
	 * @param activationFunction an activation function (usually Logistic)
	 * @param numInputs the number of inputs this node/perceptron will take
	 */
	public ANNNode(AbstractFunction activationFunction, int numInputs){
		// creates random initial weights. 
		weights = new ArrayList<Double>();
		for (int i = 0; i < numInputs; i++){
			weights.add(Math.random());
		}
		
		// TODO: Inputs will be passed in to another function (probably calcOutput())
		
		// TODO: pass in a new Logistic function
		f = activationFunction;
		
	}


	/**
	 * Calculates the output of the node: multiplies input vector by weight vector and sums
	 */
	@Override
	public double calcOutput(ArrayList<Double> inputs) {
		output = 0;
		
		// calculates \sum_i w_i x_i
		for (int i = 0; i < inputs.size(); i++){
			output += (weights.get(i) * inputs.get(i));
		}
		
		return f.calcfx(output);
	}
	
	/**
	 * Adds input node to this node's list of ancestors, i.e. those nodes from which it gets inputs
	 * @param n the ancestor node to add
	 */
	public void addAncestor(ANNNode n){
		if (!isInputNode){
			ancestors.add(n);
		}
	}
	
	/**
	 * Adds input node to this node's list of descendants, i.e. those nodes to which it sends outputs
	 * @param n the ancestor node to add
	 */
	public void addDescendant(ANNNode n){
		if (!isOutputNode){
			descendants.add(n);
		}
	}
	
	public String toString(){
		String s = "";
		
		s += "[" + layer + ", " + depth + "] " + "< ";
		
		for (int w = 0; w < weights.size(); w++) {
			DecimalFormat twoDForm = new DecimalFormat("#.##");
			double weight = Double.valueOf(twoDForm.format(weights.get(w)));
			s += weight + " ";
		}
		
		s += ": " + output +" >  ";
		
		return s;
	}
	
	public ArrayList<Double> getWeights() {
		return weights;
	}
	
	public double getOutput(){
		return output;
	}


	public boolean isInputNode() {
		return isInputNode;
	}


	public void setInputNode(boolean isInputNode) {
		this.isInputNode = isInputNode;
	}


	public boolean isOutputNode() {
		return isOutputNode;
	}


	public void setOutputNode(boolean isOutputNode) {
		this.isOutputNode = isOutputNode;
	}


	public ArrayList<ANNNode> getDescendants() {
		return descendants;
	}


	public ArrayList<ANNNode> getAncestors() {
		return ancestors;
	}


	public int getLayer() {
		return layer;
	}


	public void setLayer(int layer) {
		this.layer = layer;
	}


	public int getDepth() {
		return depth;
	}


	public void setDepth(int depth) {
		this.depth = depth;
	}
	
	
	

}
