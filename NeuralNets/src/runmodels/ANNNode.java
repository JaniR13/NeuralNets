package runmodels;

import java.lang.Math.*;

public class ANNNode extends AbstractNode {
	
	private AbstractFunction f;
	// TODO: what to do about loss function?
	private AbstractFunction lossFunction;
	private double[] inputs;
	// TODO: do the weights need to be < 1?
	private double[] weights;
	private double output;
	
	public ANNNode(AbstractFunction activationFunction, int numInputs){
		// creates random initial weights. 
		weights = new double[numInputs];
		for (int i = 0; i < numInputs; i++){
			weights[i] = Math.random();
		}
		
		// TODO: Inputs will be passed in to another function (probably calcOutput())
		
		// TODO: pass in a new Logistic function
		f = activationFunction;
		
	}


	/**
	 * Calculates the output of the node: multiplies input vector by weight vector and sums
	 */
	@Override
	public double calcOutput(double[] inputs) {
		double output = 0;
		
		// calculates \sum_i w_i x_i
		for (int i = 0; i < inputs.length; i++){
			output += (weights[i] * inputs[i]);
		}
		
		return output;
	}
	
	public double[] getWeights() {
		return weights;
	}

}
