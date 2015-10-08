package runmodels;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class FeedForwardANNTest {


	
	/**@Test
	public void backPropTestLessThanOne(){
		FeedForwardANN net = new FeedForwardANN(4);
		ArrayList<Double> inputs = new ArrayList<Double>();
		inputs.add(-2.5);
		inputs.add(2.0);
		inputs.add(-1.0);
		inputs.add(3.0);
		
		ArrayList<Double> expectedOutputs = new ArrayList<Double>();
		expectedOutputs.add(.99);
		expectedOutputs.add(.99);
		expectedOutputs.add(.99);
		expectedOutputs.add(.99);
		
		net.setExpectedOutputs(expectedOutputs);
		net.generateOutput(inputs);	
		net.backProp();

		for (int i = 0; i < 30; i++){
			net.generateOutput(inputs);	
			net.backProp();
		}
	} */
	
	@Test
	public void backPropTestMoreThanOne(){
		FeedForwardANN net = new FeedForwardANN(3);
		ArrayList<Double> inputs = new ArrayList<Double>();
		inputs.add(-2.5);
		inputs.add(2.0);
		inputs.add(-1.0);
		inputs.add(3.0);
		
		ArrayList<Double> expectedOutputs = new ArrayList<Double>();
		expectedOutputs.add(5.0);
		expectedOutputs.add(1.0);
		expectedOutputs.add(6.2);
		expectedOutputs.add(1.0);
		
		net.setExpectedOutputs(expectedOutputs);
		net.generateOutput(inputs);	
		net.backProp();

		for (int i = 0; i < 10; i++){
			net.generateOutput(inputs);	
			net.backProp();
		}
	} 

}
