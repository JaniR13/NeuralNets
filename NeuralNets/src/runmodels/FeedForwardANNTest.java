package runmodels;

import static org.junit.Assert.*;

import org.junit.Test;

public class FeedForwardANNTest {

	@Test
	public void testPrint() {
		FeedForwardANN net = new FeedForwardANN(3);
		net.print();
	}

}
