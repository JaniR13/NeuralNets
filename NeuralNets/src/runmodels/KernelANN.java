package runmodels;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Random;

public class KernelANN extends AbstractModel {

    //private ArrayList<Double> inputs;
    private ArrayList<RBFNode> functions;
    private ArrayList<Double> outputs;
    private ArrayList<Double> targets;
    private double eta = 0.1;//learning rate
    private Distance dist = new Distance();
    private double variance;
    private double totalError;
    public KernelANN() {

    }

    @Override
    void compileResults() {
        // TODO Auto-generated method stub

    }

    @Override
    void execute() {
        // TODO Auto-generated method stub

    }

    public void buildNetwork(int numInputs, int numOutputs, int numFunctions) {
        Random rand = new Random();
//        for(int i = 0; i < numInputs; i++){ //TODO need to figure out if inputs means features or training examples...
//            inputs.add(0.0);
//        }
        for(int j = 0; j < numOutputs; j++){
            outputs.add(0.0);
        }
        for(int k = 0; k < numFunctions; k++){
            RBFNode node = new RBFNode();
            functions.set(k, node);
            for(int i = 0; i < outputs.size(); i++){
                functions.get(k).outweights.add(rand.nextDouble());//initialize to Random weights
            }
            
        }
    }
    
    public ArrayList<ArrayList> readData(String fname){
        BufferedReader br = null;
	String line = "";
	String cvsSplitBy = ",";
        ArrayList<ArrayList> input = new ArrayList();
        int count = 0;
        //ArrayList output = new ArrayList();
	try {

		br = new BufferedReader(new FileReader(fname));
		while ((line = br.readLine()) != null) {
                    String[] example = line.split(cvsSplitBy);
                    int n = example.length;
                    for(int i = 0; i<n-1; i++){
                        input.get(count).add(Double.parseDouble(example[i]));
                    }
                    targets.add(Double.parseDouble(example[n-1]));
                }
        }catch(Exception e){
            e.printStackTrace();
        }
        return input;
    }

    public void trainNetwork(String fname, double var, int k, double threshold){
        ArrayList<ArrayList> input = readData(fname);
        kMeansClustering(k, input, 1, var);
        totalError = Double.MAX_VALUE;
        int count = 0;
        while(totalError > 0.00001 && count < Integer.MAX_VALUE){
            for(int i = 0; i < input.size(); i++){//for each training example
                for(int j = 0; j < functions.size(); j++){//for each RBF function
                    functions.get(j).activationOut = 
                            functions.get(j).calculateActivation(input.get(i), variance);
                       
                }
                generateOutputs();
                updateAllWeights(targets);
                ArrayList<Double> tar = new ArrayList();
                tar.add(targets.get(i));
                totalError = calcError(tar, outputs);
            }
        }
        
    }
    
    public double calcError(ArrayList target, ArrayList out){
        return dist.calculateDistance(target, out);
    }
    public void kMeansClustering(int k, ArrayList<ArrayList> in, int outDim, double var){//input all examples and k
        KMeans kmeans = new KMeans();
        //ArrayList in = readData(fname);
        ArrayList<ArrayList> meanslist = kmeans.createClusters(k, in);
        int inDim = meanslist.get(0).size();
        buildNetwork(inDim, outDim, k);
        for(int i = 0; i < functions.size(); i++){
            functions.get(i).means.addAll(meanslist.get(i));
        }
        //variance?
        variance = var;    
    }

    public double updateIndWeight(double inweight, double input, ArrayList<Double> target, ArrayList<Double> observed) {
        double outweight = inweight;
        outweight += dist.calculateDistance(target, observed)*eta*input;//multiply this by input
        return outweight;
    }
    public void updateAllWeights(ArrayList<Double> target){
        double x = 0;
        for(int i = 0; i < functions.size(); i++){//for each hidden node
            for(int j = 0; j <outputs.size(); j++){
                x = updateIndWeight(functions.get(i).outweights.get(j), 
                        functions.get(i).activationOut, target, outputs);
                functions.get(i).outweights.set(j, x);
            }
        }
    }
    public void generateOutputs() {
        for (int i = 0; i < outputs.size(); i++) {
            //for each output node calculate weighted sum of hidden layers
            double sum = 0; //
            for (int j = 0; j < functions.size(); j++) {//each hidden node has output
                sum += functions.get(j).activationOut * functions.get(j).outweights.get(i);
            }
            outputs.set(i, sum);
        }
    }
}
