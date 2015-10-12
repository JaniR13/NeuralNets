package runmodels;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Random;

public class FeedForwardExperiment {

	// TRAINING DATA
	// examples with 2 inputs
	ArrayList<ArrayList<Double>> twodtraininputs = new ArrayList<ArrayList<Double>>();
	ArrayList<ArrayList<Double>> twodtrainoutputs = new ArrayList<ArrayList<Double>>();
	// examples with 3 inputs
	ArrayList<ArrayList<Double>> threedtraininputs = new ArrayList<ArrayList<Double>>();
	ArrayList<ArrayList<Double>> threedtrainoutputs = new ArrayList<ArrayList<Double>>();
	// examples with 4 inputs
	ArrayList<ArrayList<Double>> fourdtraininputs = new ArrayList<ArrayList<Double>>();
	ArrayList<ArrayList<Double>> fourdtrainoutputs = new ArrayList<ArrayList<Double>>();
	// examples with 5 inputs
	ArrayList<ArrayList<Double>> fivedtraininputs = new ArrayList<ArrayList<Double>>();
	ArrayList<ArrayList<Double>> fivedtrainoutputs = new ArrayList<ArrayList<Double>>();
	// examples with 6 inputs
	ArrayList<ArrayList<Double>> sixdtraininputs = new ArrayList<ArrayList<Double>>();
	ArrayList<ArrayList<Double>> sixdtrainoutputs = new ArrayList<ArrayList<Double>>();
	
	// TEST NETWORKS
	// nets with 2 inputs
	ArrayList<FeedForwardANN> twodnets = new ArrayList<FeedForwardANN>();
	// nets with 3 inputs
	ArrayList<FeedForwardANN> threednets = new ArrayList<FeedForwardANN>();
	// nets with 4 inputs
	ArrayList<FeedForwardANN> fourdnets = new ArrayList<FeedForwardANN>();
	// nets with 5 inputs
	ArrayList<FeedForwardANN> fivednets = new ArrayList<FeedForwardANN>();
	// nets with 6 inputs
	ArrayList<FeedForwardANN> sixdnets = new ArrayList<FeedForwardANN>();
	
	// TEST DATA
	// examples with 2 inputs
	ArrayList<ArrayList<Double>> twodtestinputs = new ArrayList<ArrayList<Double>>();
	ArrayList<ArrayList<Double>> twodtestoutputs = new ArrayList<ArrayList<Double>>();
	// examples with 3 inputs
	ArrayList<ArrayList<Double>> threedtestinputs = new ArrayList<ArrayList<Double>>();
	ArrayList<ArrayList<Double>> threedtestoutputs = new ArrayList<ArrayList<Double>>();
	// examples with 4 inputs
	ArrayList<ArrayList<Double>> fourdtestinputs = new ArrayList<ArrayList<Double>>();
	ArrayList<ArrayList<Double>> fourdtestoutputs = new ArrayList<ArrayList<Double>>();
	// examples with 5 inputs
	ArrayList<ArrayList<Double>> fivedtestinputs = new ArrayList<ArrayList<Double>>();
	ArrayList<ArrayList<Double>> fivedtestoutputs = new ArrayList<ArrayList<Double>>();
	// examples with 6 inputs
	ArrayList<ArrayList<Double>> sixdtestinputs = new ArrayList<ArrayList<Double>>();
	ArrayList<ArrayList<Double>> sixdtestoutputs = new ArrayList<ArrayList<Double>>();
	
	int numHidden = 0; // TODO: 0, 1, 2
	
	// network error values
	ArrayList<Double> twoderrors = new ArrayList<Double>();
	ArrayList<Double> threederrors = new ArrayList<Double>();
	ArrayList<Double> fourderrors = new ArrayList<Double>();
	ArrayList<Double> fivederrors = new ArrayList<Double>();
	ArrayList<Double> sixderrors = new ArrayList<Double>();

	public FeedForwardExperiment() {
		// TODO: feed all six training sets into trainExamplesFromFile
		
		// TODO: feed all six test sets into testExamplesFromFile
		// TODO: output error values to file
		// TODO: also keep errors in something local (arraylist?) so we can find average
		
		// TODO: print average of errors for each ArrayList of errors
		
	}

	private void trainExamplesFromFile(String fname) {
		BufferedReader br = null; // read from data
		String line = "";
		String cvsSplitBy = ",";

		ArrayList<Double> inputs = new ArrayList<Double>();

		try {
			br = new BufferedReader(new FileReader(fname));
			while ((line = br.readLine()) != null) {
				line = br.readLine();
				String[] example = line.split(cvsSplitBy);

				// adds inputs (all but last number on line)
				for (int i = 0; i < example.length - 1; i++) {
					Double in = Double.parseDouble(example[i]);
					inputs.add(in);
				}

				// puts input array into correctly-sized ArrayList of examples
				int size = inputs.size();
				if (size == 2) {
					twodtraininputs.add(inputs);
				} else if (size == 3) {
					threedtraininputs.add(inputs);
				} else if (size == 4) {
					fourdtraininputs.add(inputs);
				} else if (size == 5) {
					fivedtraininputs.add(inputs);
				} else if (size == 6) {
					sixdtraininputs.add(inputs);
				}

				// gets output
				String stringoutput = example[example.length - 1];
				Double o = Double.parseDouble(stringoutput);
				ArrayList<Double> output = new ArrayList<Double>();
				output.add(o);

				// adds output to corresponding output ArrayList
				// then initializes and trains a new feed forward net with 
				// corresponding inputs and outputs
				// then stores new net
				if (size == 2) {
					twodtrainoutputs.add(output);
					FeedForwardANN newNet = new FeedForwardANN(numHidden, 5, inputs, output, true, false);
					ArrayList<Double> netOutputs = newNet.train();
					twodnets.add(newNet);
				} else if (size == 3) {
					threedtrainoutputs.add(output);
					FeedForwardANN newNet = new FeedForwardANN(numHidden, 5, inputs, output, true, false);
					ArrayList<Double> netOutputs = newNet.train();
					threednets.add(newNet);
				} else if (size == 4) {
					fourdtrainoutputs.add(output);
					FeedForwardANN newNet = new FeedForwardANN(numHidden, 5, inputs, output, true, false);
					ArrayList<Double> netOutputs = newNet.train();
					fourdnets.add(newNet);
				} else if (size == 5) {
					fivedtrainoutputs.add(output);
					FeedForwardANN newNet = new FeedForwardANN(numHidden, 5, inputs, output, true, false);
					ArrayList<Double> netOutputs = newNet.train();
					fivednets.add(newNet);
				} else if (size == 6) {
					sixdtrainoutputs.add(output);
					FeedForwardANN newNet = new FeedForwardANN(numHidden, 5, inputs, output, true, false);
					ArrayList<Double> netOutputs = newNet.train();
					sixdnets.add(newNet);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void testExamplesFromFile(String fname){
		BufferedReader br = null;// read from data
		String line = "";
		String cvsSplitBy = ",";

		ArrayList<Double> inputs = new ArrayList<Double>();

		try {
			br = new BufferedReader(new FileReader(fname));
			while ((line = br.readLine()) != null) {
				line = br.readLine();
				String[] example = line.split(cvsSplitBy);

				// adds inputs (all but last number on line)
				for (int i = 0; i < example.length - 1; i++) {
					Double in = Double.parseDouble(example[i]);
					inputs.add(in);
				}

				// puts input array into correctly-sized ArrayList of examples
				int size = inputs.size();
				if (size == 2) {
					twodtestinputs.add(inputs);
				} else if (size == 3) {
					threedtestinputs.add(inputs);
				} else if (size == 4) {
					fourdtestinputs.add(inputs);
				} else if (size == 5) {
					fivedtestinputs.add(inputs);
				} else if (size == 6) {
					sixdtestinputs.add(inputs);
				}

				// gets output
				String stringoutput = example[example.length - 1];
				Double o = Double.parseDouble(stringoutput);
				ArrayList<Double> output = new ArrayList<Double>();
				output.add(o);

				Random networkPicker = new Random();
				// select a random network from appropriately sized set
				// and then give it a new set of inputs and outputs (associated w/ test example)
				// and get the error
				if (size == 2) {
					int index = networkPicker.nextInt(twodnets.size());
					twodtestoutputs.add(output);
					FeedForwardANN testNet = twodnets.get(index);
					testNet.setInputs(inputs);
					testNet.setTargetOutputs(output);
					testNet.train();
					// TODO: write error to file
					Double error = testNet.calcNetworkError();
					twoderrors.add(error);
				} else if (size == 3) {
					int index = networkPicker.nextInt(threednets.size());
					threedtestoutputs.add(output);
					FeedForwardANN testNet = threednets.get(index);
					testNet.setInputs(inputs);
					testNet.setTargetOutputs(output);
					testNet.train();
					// TODO: write error to file
					Double error = testNet.calcNetworkError();
					threederrors.add(error);
				} else if (size == 4) {
					int index = networkPicker.nextInt(fourdnets.size());
					fourdtestoutputs.add(output);
					FeedForwardANN testNet = fourdnets.get(index);
					testNet.setInputs(inputs);
					testNet.setTargetOutputs(output);
					testNet.train();
					// TODO: write error to file
					Double error = testNet.calcNetworkError();
					fourderrors.add(error);
				} else if (size == 5) {
					int index = networkPicker.nextInt(fivednets.size());
					fivedtestoutputs.add(output);
					FeedForwardANN testNet = fivednets.get(index);
					testNet.setInputs(inputs);
					testNet.setTargetOutputs(output);
					testNet.train();
					// TODO: write error to file
					Double error = testNet.calcNetworkError();
					fivederrors.add(error);
				} else if (size == 6) {
					int index = networkPicker.nextInt(sixdnets.size());
					sixdtestoutputs.add(output);
					FeedForwardANN testNet = sixdnets.get(index);
					testNet.setInputs(inputs);
					testNet.setTargetOutputs(output);
					testNet.train();
					// TODO: write error to file
					Double error = testNet.calcNetworkError();
					sixderrors.add(error);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

}
