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
	
	public double calcError(ArrayList<Double> predictions, ArrayList<Double> expectedOutputs){
		int n = predictions.size();
		double error = 0;
		for (int i = 0; i < n; i++){
			error += (predictions.get(i) - expectedOutputs.get(i));
		}	
		return error/n;
	}

}
