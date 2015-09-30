package runmodels;

import java.util.ArrayList;

public class MeanSquaredError extends AbstractFunction {
	// TODO: will we even need this?
	
	public MeanSquaredError(){
		//does nothing
	}
	
	@Override
	double calcfx(double x) {
		// distance from a single instance to itself is zero
		return 0;
	}

	@Override
	double calcderivfx(double x) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	/**
	 * Calculated mean squared error for a vector of outputs
	 * @param predictions node/network outputs
	 * @param expectedOutputs expected node/network output
	 * @return error
	 */
	public double calcError(ArrayList<Double> predictions, ArrayList<Double> expectedOutputs){
		int n = predictions.size();
		double error = 0;
		for (int i = 0; i < n; i++){
			error += (predictions.get(i) - expectedOutputs.get(i));
		}	
		return error/n;
	}
	

	/** Calculates mean squared error for a single output
	 * @param target expected node/network output
	 * @param observedOutput observed node/network output
	 * @return
	 */
	public double calcError(double target, double observedOutput){	
		return target - observedOutput;
	}
	
	/**
	 * Calculates partial derivative of error with respect to expected output
	 * @param target expected node/network output
	 * @param observedOutput observed node/network output
	 * @return
	 */
	public double calcDerivError(double target, double observedOutput){	
		return -1*(target - observedOutput);
	}

}
