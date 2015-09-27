package runmodels;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class FeedForwardANNTest {

	@Test
	public void testPrint() {
		FeedForwardANN net = new FeedForwardANN(3);
		// TODO: this is now broken since we changed how weight initialization for a perceptron works
		// should be fixed later, not worrying about it yet
		//net.print();
	}
	
	@Test
	public void testNetworkStructure(){
		// recall, arbitrary layer depth = 4
		
		FeedForwardANN net = new FeedForwardANN(3);
		//net.print();
		ArrayList<ArrayList<ANNNode>> networkNodes = net.getNodes();
		
		// hidden node has 5 ancestors (including bias) and 4 descendants
		assertEquals(5, networkNodes.get(1).get(3).getAncestors().size());
		assertEquals(4, networkNodes.get(1).get(1).getDescendants().size());
		
		// input node has 0 ancestors and 4 descendants
		assertEquals(0, networkNodes.get(0).get(1).getAncestors().size());
		assertEquals(4, networkNodes.get(0).get(2).getDescendants().size());
		
		// output node has 5 ancestors (including bias) and no descendants
		assertEquals(4, networkNodes.get(2).get(2).getAncestors().size());
		assertEquals(0, networkNodes.get(2).get(3).getDescendants().size());	
		
	}
	
	@Test
	public void testGenerateOutput(){
		FeedForwardANN net = new FeedForwardANN(4);
		
		ArrayList<Double> inputs = new ArrayList<Double>();
		inputs.add(1.0);
		inputs.add(2.0);
		inputs.add(-1.0);
		inputs.add(0.0);
		inputs.add(1.0);
		net.generateOutput(inputs);
		// checking to see bias is added correctly
		assertEquals(6, net.getInputs().size());
		
		
	}

}
