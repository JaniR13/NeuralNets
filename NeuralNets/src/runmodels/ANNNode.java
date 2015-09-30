package runmodels;

import java.text.DecimalFormat;
import java.util.ArrayList;

//import java.lang.Math.*;

public class ANNNode extends AbstractNode {

	private AbstractFunction f;
	private MeanSquaredError loss;
	private ArrayList<Double> inputs;
	// TODO: do the weights need to be < 1?
	private ArrayList<Double> weights;
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
	private boolean isBias = false;

	// true if this is the first time network has been run
	private boolean isFirstRun = true;

	/**
	 * Constructs a perceptron
	 * 
	 * @param activationFunction
	 *            an activation function (usually Logistic)
	 * @param numInputs
	 *            the number of inputs this node/perceptron will take
	 */
	public ANNNode(AbstractFunction activationFunction) {
		f = activationFunction;
		// starts list of inputs
		inputs = new ArrayList<Double>();
		loss = new MeanSquaredError();
	}

	/**
	 * Called only by CalcOutput - it'll randomize weights every time it's
	 * called! TODO: if you want to reuse the network, need to call this to
	 * "reset", along with clearInputs();
	 */
	private void initializeWeights(int numInputs) {
		// creates random initial weights.
		weights = new ArrayList<Double>();

		for (int i = 0; i < numInputs; i++) {
			weights.add(Math.random());
		}
	}

	/**
	 * Calculates the output of the node: multiplies input vector by weight
	 * vector and sums. ASSUMES ALL INPUTS HAVE ALREADY BEEN ADDED.
	 */
	@Override
	public double calcOutput() {

		if (isFirstRun) {
			initializeWeights(this.inputs.size());
		}

		output = 0;
		// calculates \sum_i w_i x_i
		for (int i = 0; i < inputs.size(); i++) {
			output += (weights.get(i) * inputs.get(i));
		}
		output = f.calcfx(output);

		// it's no longer the first run - we don't want to keep randomly
		// initializing weights!
		setFirstRun(false);

		return output;
	}

	/**
	 * Calculates error using the node's loss function
	 */
	public double calcError(double expectedOutput) {
		return loss.calcError(output, expectedOutput);
	}

	/**
	 * Adds input node to this node's list of ancestors, i.e. those nodes from
	 * which it gets inputs
	 * 
	 * @param n
	 *            the ancestor node to add
	 */
	public void addAncestor(ANNNode n) {
		if (!isInputNode) {
			ancestors.add(n);
		}
	}

	/**
	 * Adds input node to this node's list of descendants, i.e. those nodes to
	 * which it sends outputs
	 * 
	 * @param n
	 *            the ancestor node to add
	 */
	public void addDescendant(ANNNode n) {
		if (!isOutputNode) {
			descendants.add(n);
		}
	}

	/** Adds to the variable's list of inputs, but does NOT initiate calculation */
	public void addInput(double i) {
		inputs.add(i);
	}

	public void clearInputs() {
		// TODO: to be used after a set of inputs has been run through, so that
		// we don't just accumulate new inputs
		// on top of previously used ones
		inputs.clear();
	}

	public String toString() {
		String s = "";
		s += "[" + layer + ", " + depth + "] " + "< ";

		// System.out.print("# weights: " + weights.size() + " ");
		DecimalFormat twoDForm = new DecimalFormat("#.##");
		DecimalFormat threeDForm = new DecimalFormat("#.###");
		for (int w = 0; w < weights.size(); w++) {
			double weight = Double.valueOf(twoDForm.format(weights.get(w)));
			s += weight + " ";
		}

		s += ": " + Double.valueOf(threeDForm.format(output)) + " >  ";

		return s;
	}

	public ArrayList<Double> getWeights() {
		return weights;
	}

	public double getOutput() {
		return output;
	}
	
	public ArrayList<Double> getInputs(){
		return inputs;
	}

	public boolean isInputNode() {
		return isInputNode;
	}

	public void setInputNode(boolean isInputNode) {
		this.isInputNode = isInputNode;
	}

	public boolean isBiasNode() {
		return isBias;
	}

	public void setIsBiasNode(boolean isBias) {
		this.isBias = isBias;
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

	public boolean isFirstRun() {
		return isFirstRun;
	}

	public void setFirstRun(boolean isFirstRun) {
		this.isFirstRun = isFirstRun;
	}

	/** This should be used ONLY for input nodes */
	public void setOutput(double o) {
		output = o;
	}

}
