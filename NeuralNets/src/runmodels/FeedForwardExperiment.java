package runmodels;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Random;
import java.util.Arrays;

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

	public FeedForwardExperiment(String filePathTrain, String filePathTest) {
		// TODO: feed all six training sets into trainExamplesFromFile
		trainExamplesFromFile(filePathTrain);
		
		// TODO: feed all six test sets into testExamplesFromFile
		testExamplesFromFile(filePathTest);
		
		// TODO: normalizeTestOutputs();
		// TODO: normalizeTrainOutputs();
		
		// TODO: create training nets
		
		// TODO: run test instances
		
		// TODO: print average of errors for each ArrayList of errors
		
	}
	
	private void runTestInstances(){
		Random networkPicker = new Random();
		
		//runs through each test example
		for (int i = 0; i < twodtestinputs.size(); i++){
			int index = networkPicker.nextInt(twodnets.size());
			FeedForwardANN testNet = twodnets.get(index);
			// runs with this test example's inputs and outputs
			testNet.setInputs(twodtestinputs.get(i));
			testNet.setTargetOutputs(twodtestoutputs.get(i));
			testNet.train();
			// adds error to appropriate arraylist
			twoderrors.add(testNet.calcNetworkError());
		}
		
		//runs through each test example
		for (int i = 0; i < threedtestinputs.size(); i++){
			int index = networkPicker.nextInt(threednets.size());
			FeedForwardANN testNet = threednets.get(index);
			// runs with this test example's inputs and outputs
			testNet.setInputs(threedtestinputs.get(i));
			testNet.setTargetOutputs(threedtestoutputs.get(i));
			testNet.train();
			// adds error to appropriate arraylist
			threederrors.add(testNet.calcNetworkError());
		}
		
		//runs through each test example
		for (int i = 0; i < fourdtestinputs.size(); i++){
			int index = networkPicker.nextInt(fourdnets.size());
			FeedForwardANN testNet = fourdnets.get(index);
			// runs with this test example's inputs and outputs
			testNet.setInputs(fourdtestinputs.get(i));
			testNet.setTargetOutputs(fourdtestoutputs.get(i));
			testNet.train();
			// adds error to appropriate arraylist
			fourderrors.add(testNet.calcNetworkError());
		}
		
		//runs through each test example
		for (int i = 0; i < fivedtestinputs.size(); i++){
			int index = networkPicker.nextInt(fivednets.size());
			FeedForwardANN testNet = fivednets.get(index);
			// runs with this test example's inputs and outputs
			testNet.setInputs(fivedtestinputs.get(i));
			testNet.setTargetOutputs(fivedtestoutputs.get(i));
			testNet.train();
			// adds error to appropriate arraylist
			fivederrors.add(testNet.calcNetworkError());
		}
		
		//runs through each test example
		for (int i = 0; i < sixdtestinputs.size(); i++){
			int index = networkPicker.nextInt(sixdnets.size());
			FeedForwardANN testNet = sixdnets.get(index);
			// runs with this test example's inputs and outputs
			testNet.setInputs(sixdtestinputs.get(i));
			testNet.setTargetOutputs(sixdtestoutputs.get(i));
			testNet.train();
			// adds error to appropriate arraylist
			sixderrors.add(testNet.calcNetworkError());
		}
	}
	
	private void createTrainingNets(){
		//runs through each training example
		for (int i = 0; i < twodtraininputs.size(); i++){
			// creates new ANN
			FeedForwardANN newNet = new FeedForwardANN(numHidden, 5, twodtraininputs.get(i), twodtrainoutputs.get(i), true, false);
			// trains net
			newNet.train();
			// adds net to appropriate group
			twodnets.add(newNet);
		}
		
		for (int i = 0; i < threedtraininputs.size(); i++){
			// creates new ANN
			FeedForwardANN newNet = new FeedForwardANN(numHidden, 5, threedtraininputs.get(i), threedtrainoutputs.get(i), true, false);
			// trains net
			newNet.train();
			// adds net to appropriate group
			threednets.add(newNet);
		}
		
		for (int i = 0; i < fourdtraininputs.size(); i++){
			// creates new ANN
			FeedForwardANN newNet = new FeedForwardANN(numHidden, 5, fourdtraininputs.get(i), fourdtrainoutputs.get(i), true, false);
			// trains net
			newNet.train();
			// adds net to appropriate group
			fourdnets.add(newNet);
		}
		
		for (int i = 0; i < fivedtraininputs.size(); i++){
			// creates new ANN
			FeedForwardANN newNet = new FeedForwardANN(numHidden, 5, fivedtraininputs.get(i), fivedtrainoutputs.get(i), true, false);
			// trains net
			newNet.train();
			// adds net to appropriate group
			fivednets.add(newNet);
		}
		
		for (int i = 0; i < sixdtraininputs.size(); i++){
			// creates new ANN
			FeedForwardANN newNet = new FeedForwardANN(numHidden, 5, sixdtraininputs.get(i), sixdtrainoutputs.get(i), true, false);
			// trains net
			newNet.train();
			// adds net to appropriate group
			sixdnets.add(newNet);
		}
	}

	
	private void normalizeTestOutputs(){
		Double[] twodcopy = new Double[twodtestoutputs.size()];
		// adds all outputs to a new arraylist
		for (ArrayList<Double> a : twodtestoutputs){
			twodcopy[0] = (a.get(0));
		}
		// sorts new arraylist
		Arrays.sort(twodcopy);
		// gets max and min
		Double max = twodcopy[twodcopy.length-1];
		Double min = twodcopy[0];
		// normalizes each output
		for(ArrayList<Double> a: twodtestoutputs){
			Double newval = (a.get(0) - min)/(max-min);
			a.set(0, newval);
		}
		
		Double[] threedcopy = new Double[threedtestoutputs.size()];
		// adds all outputs to a new arraylist
		for (ArrayList<Double> a : threedtestoutputs){
			threedcopy[0] = (a.get(0));
		}
		// sorts new arraylist
		Arrays.sort(threedcopy);
		// gets max and min
		max = threedcopy[threedcopy.length-1];
		min = threedcopy[0];
		// normalizes each output
		for(ArrayList<Double> a: threedtestoutputs){
			Double newval = (a.get(0) - min)/(max-min);
			a.set(0, newval);
		}
		
		Double[] fourdcopy = new Double[fourdtestoutputs.size()];
		// adds all outputs to a new arraylist
		for (ArrayList<Double> a : fourdtestoutputs){
			fourdcopy[0] = (a.get(0));
		}
		// sorts new arraylist
		Arrays.sort(fourdcopy);
		// gets max and min
		max = fourdcopy[fourdcopy.length-1];
		min = fourdcopy[0];
		// normalizes each output
		for(ArrayList<Double> a: fourdtestoutputs){
			Double newval = (a.get(0) - min)/(max-min);
			a.set(0, newval);
		}
		
		Double[] fivedcopy = new Double[fivedtestoutputs.size()];
		// adds all outputs to a new arraylist
		for (ArrayList<Double> a : fivedtestoutputs){
			fivedcopy[0] = (a.get(0));
		}
		// sorts new arraylist
		Arrays.sort(fivedcopy);
		// gets max and min
		max = fivedcopy[fivedcopy.length-1];
		min = fivedcopy[0];
		// normalizes each output
		for(ArrayList<Double> a: fivedtestoutputs){
			Double newval = (a.get(0) - min)/(max-min);
			a.set(0, newval);
		}
		
		Double[] sixdcopy = new Double[sixdtestoutputs.size()];
		// adds all outputs to a new arraylist
		for (ArrayList<Double> a : sixdtestoutputs){
			sixdcopy[0] = (a.get(0));
		}
		// sorts new arraylist
		Arrays.sort(sixdcopy);
		// gets max and min
		max = sixdcopy[sixdcopy.length-1];
		min = sixdcopy[0];
		// normalizes each output
		for(ArrayList<Double> a: sixdtestoutputs){
			Double newval = (a.get(0) - min)/(max-min);
			a.set(0, newval);
		}
	}
	
	private void normalizeTrainOutputs(){
		Double[] twodcopy = new Double[twodtrainoutputs.size()];
		// adds all outputs to a new arraylist
		for (ArrayList<Double> a : twodtrainoutputs){
			twodcopy[0] = (a.get(0));
		}
		// sorts new arraylist
		Arrays.sort(twodcopy);
		// gets max and min
		Double max = twodcopy[twodcopy.length-1];
		Double min = twodcopy[0];
		// normalizes each output
		for(ArrayList<Double> a: twodtrainoutputs){
			Double newval = (a.get(0) - min)/(max-min);
			a.set(0, newval);
		}
		
		Double[] threedcopy = new Double[threedtrainoutputs.size()];
		// adds all outputs to a new arraylist
		for (ArrayList<Double> a : threedtrainoutputs){
			threedcopy[0] = (a.get(0));
		}
		// sorts new arraylist
		Arrays.sort(threedcopy);
		// gets max and min
		max = threedcopy[threedcopy.length-1];
		min = threedcopy[0];
		// normalizes each output
		for(ArrayList<Double> a: threedtrainoutputs){
			Double newval = (a.get(0) - min)/(max-min);
			a.set(0, newval);
		}
		
		Double[] fourdcopy = new Double[fourdtrainoutputs.size()];
		// adds all outputs to a new arraylist
		for (ArrayList<Double> a : fourdtrainoutputs){
			fourdcopy[0] = (a.get(0));
		}
		// sorts new arraylist
		Arrays.sort(fourdcopy);
		// gets max and min
		max = fourdcopy[fourdcopy.length-1];
		min = fourdcopy[0];
		// normalizes each output
		for(ArrayList<Double> a: fourdtrainoutputs){
			Double newval = (a.get(0) - min)/(max-min);
			a.set(0, newval);
		}
		
		Double[] fivedcopy = new Double[fivedtrainoutputs.size()];
		// adds all outputs to a new arraylist
		for (ArrayList<Double> a : fivedtrainoutputs){
			fivedcopy[0] = (a.get(0));
		}
		// sorts new arraylist
		Arrays.sort(fivedcopy);
		// gets max and min
		max = fivedcopy[fivedcopy.length-1];
		min = fivedcopy[0];
		// normalizes each output
		for(ArrayList<Double> a: fivedtrainoutputs){
			Double newval = (a.get(0) - min)/(max-min);
			a.set(0, newval);
		}
		
		Double[] sixdcopy = new Double[sixdtrainoutputs.size()];
		// adds all outputs to a new arraylist
		for (ArrayList<Double> a : sixdtrainoutputs){
			sixdcopy[0] = (a.get(0));
		}
		// sorts new arraylist
		Arrays.sort(sixdcopy);
		// gets max and min
		max = sixdcopy[sixdcopy.length-1];
		min = sixdcopy[0];
		// normalizes each output
		for(ArrayList<Double> a: sixdtrainoutputs){
			Double newval = (a.get(0) - min)/(max-min);
			a.set(0, newval);
		}
	}
	
	private void trainExamplesFromFile(String fname) {
		BufferedReader br = null; // read from data
		String line = "";
		String cvsSplitBy = ",";

		ArrayList<Double> inputs = new ArrayList<Double>();

		try {
			br = new BufferedReader(new FileReader(fname));
			while ((br.readLine()) != null) {
				line = br.readLine();
				System.out.println(line);
				String[] example = line.split(cvsSplitBy);
				
				
				// adds inputs (all but last number on line)
				for (int i = 0; i < example.length - 1; i++) {
					Double in = Double.parseDouble(example[i]);
					inputs.add(in);
				}

				// puts input array into correctly-sized ArrayList of examples
				int size = inputs.size();
				
				// gets output
				String stringoutput = example[example.length - 1];
				Double o = Double.parseDouble(stringoutput);
				ArrayList<Double> output = new ArrayList<Double>();
				output.add(o);
				
				if (size == 2) {
					twodtraininputs.add(inputs);
					twodtrainoutputs.add(output);
				} else if (size == 3) {
					threedtraininputs.add(inputs);
					threedtrainoutputs.add(output);
				} else if (size == 4) {
					fourdtraininputs.add(inputs);
					fourdtrainoutputs.add(output);
				} else if (size == 5) {
					fivedtraininputs.add(inputs);
					fivedtrainoutputs.add(output);
				} else if (size == 6) {
					sixdtraininputs.add(inputs);
					sixdtrainoutputs.add(output);
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

				// gets output
				String stringoutput = example[example.length - 1];
				Double o = Double.parseDouble(stringoutput);
				ArrayList<Double> output = new ArrayList<Double>();
				output.add(o);
				
				// puts input array into correctly-sized ArrayList of examples
				int size = inputs.size();
				
				if (size == 2) {
					twodtestinputs.add(inputs);
					twodtestoutputs.add(output);
				} else if (size == 3) {
					threedtestinputs.add(inputs);
					threedtestoutputs.add(output);
				} else if (size == 4) {
					fourdtestinputs.add(inputs);
					fourdtestoutputs.add(output);
				} else if (size == 5) {
					fivedtestinputs.add(inputs);
					fivedtestoutputs.add(output);
				} else if (size == 6) {
					sixdtestinputs.add(inputs);
					sixdtestoutputs.add(output);
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

}
