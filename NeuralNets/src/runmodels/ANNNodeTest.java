package runmodels;

import static org.junit.Assert.*;

import org.junit.Test;

public class ANNNodeTest {

	@Test
	public void testInitWeights() {
		LogisticFunction l = new LogisticFunction();
		ANNNode n = new ANNNode(l,5);
		double[] weights = n.getWeights();
		System.out.println("Weights: ");
		for (int i = 0; i < 5; i++){
			System.out.print(weights[i] + " ");
		}
		System.out.println();
	}
	
	@Test
	public void testOutput() {
		LogisticFunction l = new LogisticFunction();
		ANNNode n = new ANNNode(l,5);
		double[] weights = n.getWeights();
		double[] inputs = {1, 2, -1, 0, 1};
		double output = (inputs[0]*weights[0])+(inputs[1]*weights[1])+(inputs[2]*weights[2])+(inputs[3]*weights[3])+(inputs[4]*weights[4]);
		
		assertEquals(l.calcfx(output), n.calcOutput(inputs), 0.0005);
	}

}
