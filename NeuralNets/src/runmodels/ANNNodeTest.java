package runmodels;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class ANNNodeTest {

	@Test
	public void testInitWeights() {
		LogisticFunction l = new LogisticFunction();
		ANNNode n = new ANNNode(l);
		n.addInput(1.0);
		n.addInput(2.0);
		n.addInput(-1.0);
		n.addInput(0.0);
		n.addInput(1.0);
		// note: this output value doesn't matter, but you need to call calcOutput to initialize the weights :)
		double networkOutput = n.calcOutput();
				
		ArrayList<Double> weights = n.getWeights();
		System.out.println("Weights: ");
		for (int i = 0; i < 5; i++){
			System.out.print(weights.get(i) + " ");
		}
		System.out.println();
		
		// check that running again won't change weights (not randomly intializing every time)
		n.calcOutput();
		ArrayList<Double> weights2 = n.getWeights();
		for (int i = 0; i < weights.size(); i++){
			assertEquals(true, weights.get(i).equals(weights2.get(i)));
		}

		System.out.println("New Weights: ");
		for (int i = 0; i < 5; i++){
			System.out.print(weights2.get(i) + " ");
		}
		System.out.println();
	}
	
	@Test
	public void testOutput() {
		LogisticFunction l = new LogisticFunction();
		ANNNode n = new ANNNode(l);
		
		ArrayList<Double> inputs = new ArrayList<Double>();
		inputs.add(1.0);
		inputs.add(2.0);
		inputs.add(-1.0);
		inputs.add(0.0);
		inputs.add(1.0);
		n.addInput(1.0);
		n.addInput(2.0);
		n.addInput(-1.0);
		n.addInput(0.0);
		n.addInput(1.0);
		double networkOutput = n.calcOutput();
		
		ArrayList<Double> weights = n.getWeights();
		double output = (inputs.get(0)*weights.get(0))+(inputs.get(1)*weights.get(1))+(inputs.get(2)*weights.get(2))+(inputs.get(3)*weights.get(3))+(inputs.get(4)*weights.get(4));
		
		assertEquals(l.calcfx(output), networkOutput, 0.0005);
	}
	
	@Test
	public void testAddAncestor(){
		LogisticFunction l = new LogisticFunction();
		ANNNode n1 = new ANNNode(l);
		ANNNode n2 = new ANNNode(l);
		
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
		ANNNode n1 = new ANNNode(l);
		ANNNode n2 = new ANNNode(l);
		
		n1.setOutputNode(true);
		n1.addDescendant(n2);
		// since n1 is an output node, shouldn't be able to add descendants
		assertEquals(0, n1.getDescendants().size());
		
		n2.addDescendant(n1);
		// since n2 is in a hidden layer, can add descendants
		assertEquals(1, n2.getDescendants().size());
		
	}

}
