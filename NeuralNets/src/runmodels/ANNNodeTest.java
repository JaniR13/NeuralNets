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
	
	@Test
	public void testAddAncestor(){
		LogisticFunction l = new LogisticFunction();
		ANNNode n1 = new ANNNode(l,5);
		ANNNode n2 = new ANNNode(l,5);
		
		n1.setInputNode(true);
		n1.addAncestor(n2);
		// since n1 is an input node, shouldn't be able to add ancestors
		assertEquals(0, n1.getAncestors().size());
		
		n2.addAncestor(n1);
		// since n2 is in a hidden layer, can add ancestors
		assertEquals(1, n2.getAncestors().size());
		
	}
	
	@Test
	public void testAddDescendant(){
		LogisticFunction l = new LogisticFunction();
		ANNNode n1 = new ANNNode(l,5);
		ANNNode n2 = new ANNNode(l,5);
		
		n1.setOutputNode(true);
		n1.addDescendant(n2);
		// since n1 is an output node, shouldn't be able to add descendants
		assertEquals(0, n1.getDescendants().size());
		
		n2.addDescendant(n1);
		// since n2 is in a hidden layer, can add descendants
		assertEquals(1, n2.getDescendants().size());
		
	}

}
