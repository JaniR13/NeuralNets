package runmodels;

//import java.text.DecimalFormat;
import java.util.ArrayList;

public class FeedForwardANN extends AbstractModel {

	// https://svn.cms.waikato.ac.nz/svn/weka/branches/stable-3-2-1/weka/classifiers/neural/NeuralNetwork.java

	// private AbstractFunction lossFunction;
	private ArrayList<Double> inputs;
	private double bias = 1;
	// learning rate
	private double eta = .4;
	private ArrayList<Double> output;
	private int layers;
	// each "sub" arraylist is the nodes in a layer (didn't use a 2D array in
	// case different
	// layers have different numbers of nodes)
	private ArrayList<ArrayList<ANNNode>> nodes;

	// TODO: this needs to go away once we figure out how to actually set this
	// to something reasonable.
	private int arbitraryLayerDepth = 4;
	private ArrayList<Double> expectedOutputs = new ArrayList<Double>();
	private boolean firstRun = true;

	/**
	 * Creates a new feed-forward neural network
	 * 
	 * @param layers
	 *            number of layers in the network, INCLUDING hidden layer
	 */
	public FeedForwardANN(int layers) {
		this.layers = layers;
		output = new ArrayList<Double>();
		nodes = new ArrayList<ArrayList<ANNNode>>();
		createNetworkNodes();

	}

	/**
	 * Populates network with nodes
	 */
	protected void createNetworkNodes() {
		// creates EMPTY input layer
		ArrayList<ANNNode> inputLayer = new ArrayList<ANNNode>();
		nodes.add(inputLayer);

		for (int i = 1; i < layers; i++) {
			// creates one layer at a time
			ArrayList<ANNNode> nextLayer = new ArrayList<ANNNode>();
			for (int j = 0; j < arbitraryLayerDepth; j++) {
				ANNNode nextNode = new ANNNode(new LogisticFunction());
				nextLayer.add(nextNode);
				// these two act as sort of an ID for the node
				nextNode.setLayer(i);
				nextNode.setDepth(j);

				// sets output nodes as, well, input nodes
				if (j == arbitraryLayerDepth) {
					nextNode.setOutputNode(true);
				}
			}
			nodes.add(nextLayer);
		}
	}

	/** Creates input-layer nodes once inputs are all given */
	private void populateInputLayer() {
		ANNNode biasNode = createBiasNode();

		for (int i = 1; i < inputs.size(); i++) {
			ANNNode nextNode = new ANNNode(new LogisticFunction());
			nextNode.setLayer(0);
			nextNode.setDepth(i);
			nextNode.setInputNode(true);
			nodes.get(0).add(nextNode);
		}

		// adds every non-input node in the network as a descendant of bias node
		for (int l = 1; l < layers; l++) {
			for (ANNNode n : nodes.get(l)) {
				biasNode.addDescendant(n);
			}
		}

	}

	/** Creates input-layer nodes with a number of given inputs - TESTING ONLY */
	protected void populateInputLayer(int numInputs) {
		createBiasNode();
		for (int i = 0; i < numInputs; i++) {
			ANNNode nextNode = new ANNNode(new LogisticFunction());
			nextNode.setLayer(0);
			nextNode.setDepth(i);
			nextNode.setInputNode(true);
			nodes.get(0).add(nextNode);
		}
	}

	/**
	 * Creates bias node and adds it to network
	 */
	private ANNNode createBiasNode() {
		ANNNode biasNode = new ANNNode(new LogisticFunction());

		// lives at first index of first layer
		biasNode.setLayer(0);
		biasNode.setDepth(0);
		biasNode.setInputNode(true);

		// sets its output
		biasNode.setIsBiasNode(true);
		biasNode.addInput(bias);

		// adds itself to the network
		nodes.get(0).add(biasNode);

		return biasNode;

	}

	/**
	 * Sets ancestor/descendant relationships for each node in network
	 */
	protected void createNetworkLinks() {
		// set descendants
		for (int i = 0; i < layers - 1; i++) {
			for (ANNNode n1 : nodes.get(i)) {
				// sets every node in the next layer as a descendant
				for (ANNNode n2 : nodes.get(i + 1)) {
					// DON'T DOUBLE COUNT BIAS NODE
					if (!n1.isBiasNode()) {
						n1.addDescendant(n2);
					}
				}
			}
		}

		// set ancestors
		for (int i = 1; i < layers; i++) {
			for (ANNNode n1 : nodes.get(i)) {
				// sets every node in the previous layer as an ancestor
				for (ANNNode n2 : nodes.get(i - 1)) {
					n1.addAncestor(n2);
				}
			}
		}
	}

	/** Gives inputs to the input layer */
	private void giveInputs() {
		int numInputNodes = nodes.get(0).size();

		// all except bias node, which was taken care of by createBiasNode()
		for (int i = 0; i < numInputNodes; i++) {
			if (!nodes.get(0).get(i).isBiasNode()) {
				nodes.get(0).get(i).addInput(inputs.get(i));
				// TODO: testing, remove
				// System.out.println("Added input " + inputs.get(i) +
				// " to input node " + i);
				// TODO: removed this so we stopped double-calculating this
				// input
				// nodes.get(0).get(i).calcOutput();
			} else {
				// TODO: testing, remove
				// System.out.println("Bias node has input " +
				// nodes.get(0).get(i).getInputs().get(0));
			}
		}
	}

	@Override
	void compileResults() {
		// TODO Auto-generated method stub

	}

	@Override
	void execute() {
		// TODO: this will need to somehow take our input, so that we can
		// generate the output and use backprop
		// when executing...

	}

	/**
	 * Runs input through neural net and reports outputs
	 * 
	 * @param inputs
	 *            ArrayList of Double-valued inputs, excluding bias
	 * @return ArrayList of all outputs
	 */
	public ArrayList<Double> generateOutput(ArrayList<Double> inputs) {

		// TODO: next several lines should be done ONLY the first time this is
		// run!!!

		if (firstRun == true) {
			// sets inputs
			this.inputs = inputs;
			// puts nodes into first layer of network (others were already
			// created
			// by createNetworkNodes)
			populateInputLayer();
			// links nodes in network
			createNetworkLinks();
			// gives inputs to input nodes
			giveInputs();
		} else {
			// clear inputs to all non-input nodes
			for (int i = 1; i < layers; i++) {
				for (int j = 0; j < nodes.get(i).size(); j++) {
					nodes.get(i).get(j).clearInputs();
				}
			}
			// clear outputs
			output.clear();
		}
		firstRun = false;

		// runs through one layer at a time, EXCEPT output layer
		for (int i = 0; i < layers - 1; i++) {
			for (ANNNode n : nodes.get(i)) {
				// calculates output of this node
				double nodeOutput = n.calcOutput();

				for (ANNNode d : n.getDescendants()) {
					// adds this node's output to the inputs of its descendants
					d.addInput(nodeOutput);
					// System.out.println("Node " + n.getLayer() + n.getDepth()
					// + " passed an input to node " + d.getLayer() +
					// d.getDepth());
				}
			}
			// System.out.println(" ");
		}

		// 4. once you hit the output layer, save the output of that layer into
		// a list/array
		for (ANNNode n : nodes.get(layers - 1)) {
			output.add(n.calcOutput());
		}

		// TODO: testing, remove
		System.out.println();
		System.out.println("Outputs:");
		for (int i = 0; i < output.size(); i++) {
			System.out.println(output.get(i));
		}
		System.out.println();

		return output;
	}

	/**
	 * Carries out a single backward propagation - will need to be called
	 * repeatedly, alternating with generateOutput
	 */
	public void backProp() {

		// TODO: testing, remove
		/**
		 * ArrayList<ArrayList<Double>> initWeights = new
		 * ArrayList<ArrayList<Double>>(); for (int i = 0; i < layers; i++) {
		 * for (ANNNode n : nodes.get(i)) { initWeights.add(n.getWeights()); } }
		 */

		// remove all previous errors
		for (int i = 0; i < layers; i++) {
			for (ANNNode n : nodes.get(i)) {
				n.setError(0);
			}
		}

		// case 1 - output layer
		System.out.println("Output Layer: ");
		// foreach node N in output layer
		for (int n = 0; n < output.size(); n++) {
			int numWeights = nodes.get(layers - 1).get(n).getWeights().size();
			// foreach weight on node N
			for (int weightIndex = 0; weightIndex < numWeights; weightIndex++) {
				// gets the value of the "weightIndex"th weight of node n
				double w = nodes.get(layers - 1).get(n).getWeights()
						.get(weightIndex);

				ANNNode thisNode = nodes.get(layers - 1).get(n);
				double expectedNOutput = expectedOutputs.get(n);
				thisNode.calcError(expectedNOutput);
				// calculates change in weight
				double delta_w = eta * (expectedNOutput - thisNode.getOutput())
						* thisNode.getOutput() * (1 - thisNode.getOutput())
						* thisNode.getInputs().get(weightIndex);
				w += delta_w;

				// TODO: testing, remove
				System.out.println("[Node: WI | " + n + ": " + weightIndex
						+ "] delta: " + delta_w + "   error: "
						+ thisNode.getError());

				// sets this weight's value to w
				nodes.get(layers - 1).get(n).getWeights().set(weightIndex, w);
			}
			nodes.get(layers - 1).get(n).printWeights();
			System.out.println();
		}

		// case 2 - hidden units & input

		// foreach layer L, working backward from last hidden layer
		for (int layer = (layers - 2); layer >= 0; layer--) {
			// TODO: testing, remove
			System.out.println();
			System.out.println("Layer: " + layer);

			// foreach node in this layer
			for (int n = 0; n < (nodes.get(layer).size()); n++) {
				ANNNode thisNode = nodes.get(layer).get(n);

				// calculates error on this node
				double nodeError = thisNode.getOutput()
						* (1 - thisNode.getOutput());
				for (ANNNode desc : thisNode.getDescendants()) {
					// factors in descendants' errors
					// TODO: need to include the gradient/derivative!
					nodeError += (desc.getError() * desc.getWeights().get(n));
				}

				thisNode.setError(nodeError);
				int numWeights = thisNode.getWeights().size();

				// foreach weight on node N
				for (int weightIndex = 0; weightIndex < numWeights; weightIndex++) {
					double w = thisNode.getWeights().get(weightIndex);
					double delta_w = eta * thisNode.getError()
							* thisNode.getWeights().get(weightIndex);
					w += delta_w;

					// TODO: testing, remove
					System.out.println("[Node: WI | " + n + ": " + weightIndex
							+ "] delta: " + delta_w + "   error: "
							+ thisNode.getError());

					// sets this weight's value to w
					nodes.get(layer).get(n).getWeights().set(weightIndex, w);
				}
				thisNode.printWeights();
				System.out.println();
			}
			System.out.println();
		}

		// TODO: testing, remove
		// TODO: testing, remove
/**
		ArrayList<ArrayList<Double>> endWeights = new ArrayList<ArrayList<Double>>();
		for (int i = 0; i < layers; i++) {
			for (ANNNode n : nodes.get(i)) {
				endWeights.add(n.getWeights());
			}
		}

		for (int i = 0; i < initWeights.size(); i++) {
			System.out.println();
			System.out.print("<");
			for (int j = 0; j < initWeights.get(i).size(); j++) {
				System.out.print(initWeights.get(i).get(j) + "  ");
			}
			System.out.print(">");
		}
		System.out.println();
		for (int i = 0; i < endWeights.size(); i++) {
			System.out.println();
			System.out.print("<");
			for (int j = 0; j < endWeights.get(i).size(); j++) {
				System.out.print(endWeights.get(i).get(j) + "  ");
			}
			System.out.print(">");
		}
		System.out.println();*/
	}

	/** To be used for testing */
	public void print() {
		// goes by layer
		for (int l = 0; l < layers; l++) {
			// for each node in the layer:
			for (int n = 0; n < nodes.get(l).size(); n++) {
				System.out.print(nodes.get(l).get(n).toString());
			}
			System.out.println();
			System.out.println();
		}
	}

	public ArrayList<Double> getInputs() {
		return inputs;
	}

	public ArrayList<ArrayList<ANNNode>> getNodes() {
		return nodes;
	}

	public void setExpectedOutputs(ArrayList<Double> expectedOutputs) {
		// TODO: size check
		this.expectedOutputs = expectedOutputs;
	}

	/**
	 * Allows user/caller to set eta, potentially useful for parameter tuning
	 */
	public void setEta(double newEta) {
		if (newEta < 1 && newEta > 0) {
			eta = newEta;
		}
	}

}
