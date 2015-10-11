package runmodels;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Random;

public class KernelANN extends AbstractModel {

    //private ArrayList<Double> inputs;
    private ArrayList<RBFNode> functions = new ArrayList();
    private ArrayList<Double> outputs = new ArrayList();
    private ArrayList<Double> targets = new ArrayList();
    private double eta = 0.1;//learning rate
    private Distance dist = new Distance();
    private double variance;
    public double totalError;
    public int dim2 = 0;
    public int datasize = 0;
    public double obs;
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
        //System.out.println("build networks: in: " + numInputs + ", out: " + numOutputs + ", func: " +numFunctions);
        Random rand = new Random();
//        for(int i = 0; i < numInputs; i++){ //TODO need to figure out if inputs means features or training examples...
//            inputs.add(0.0);
//        }
        for(int j = 0; j < numOutputs; j++){
            outputs.add(0.0);
        }
        for(int m = 0; m < numFunctions; m++){
            RBFNode node = new RBFNode();
            functions.add(node);
            //System.out.println(outputs.size());
            for(int i = 0; i < outputs.size(); i++){
                double r = rand.nextDouble();
                functions.get(m).outweights.add(r);//initialize to Random weights
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
                    //System.out.println(line + " : " + count);
                    String[] example = line.split(cvsSplitBy);
                    dim2 = example.length;
                    //System.out.println(n-1);
                    input.add(new ArrayList());
                    for(int i = 0; i<dim2-1; i++){
                        //System.out.println(i + " " + count);
                        int x = Integer.parseInt(example[i]);
                        //System.out.println(x);
                        input.get(count).add(x);
                    }
                    dim2 = dim2-1;
                    double x = Double.parseDouble(example[dim2]);
                    //System.out.println(x);
                    targets.add(x);
                    count++;
                }
                datasize = count;
        }catch(Exception e){
            e.printStackTrace();
        }
        return input;
    }

    public void trainNetwork(String fname, double var, int k, double threshold){
        ArrayList<ArrayList> input = readData(fname);
        System.out.println("finished read data");
        kMeansClustering(k, input, 1, var);
        System.out.println("finished clustering");
        //System.out.println(Double.MAX_VALUE);
        totalError = (double)(Integer.MAX_VALUE);
        int count2 = 0;
        while(totalError > threshold && count2 < 10){
            //System.out.println(" run " + count2);
            System.out.println(count2 + " : " + totalError);
            for(int i = 0; i < datasize; i++){//for each training example
                for(int j = 0; j < k; j++){//for each RBF function
                    //System.out.println("input: " + input.get(i));
                    //System.out.println("Run: " + i + " " + j + " : "+ functions.get(j).calculateActivation(input.get(i), variance));
                    functions.get(j).activationOut = 
                            functions.get(j).calculateActivation(input.get(i), variance);
                    //System.out.println("out error: " + functions.get(j).activationOut);
                       
                }
                generateOutputs();
                updateAllWeights(targets.get(i));
                //ArrayList<Double> tar = new ArrayList();
               //tar.add(targets.get(i));
                //System.out.println("Unupdated error: " + totalError);
                totalError = calcError(targets.get(i), outputs.get(0));
                System.out.println("Total Error: " + totalError);
                //System.out.println(totalError + " : " + count2);
            }
            count2++;
        }
        
    }
    
    public double calcError(ArrayList target, ArrayList out){
        System.out.println("target: " + target + ", out: " + out);
        return dist.calculateDistance(target, out, 1);
    }
    public double calcError(double target, double out){
        return dist.calculateDistance(target, out);
    }
    public void kMeansClustering(int k, ArrayList<ArrayList> in, int outDim, double var){//input all examples and k
        KMeans kmeans = new KMeans();
        //ArrayList in = readData(fname);
        ArrayList<ArrayList> meanslist = kmeans.createClusters(k, in, dim2);
        //System.out.println(meanslist);
        //int inDim = meanslist.get(0).size();
        buildNetwork(dim2, outDim, k);
        for(int i = 0; i < functions.size(); i++){
            
            functions.get(i).means.addAll(meanslist.get(i));
            //System.out.println(functions.get(i).means);
        }
        //variance?
        variance = var;    
    }

    public double updateIndWeight(double inweight, double input, double target, double observed) {
        double outweight = inweight;
        outweight += (target-observed)*eta*input;//multiply this by input
        System.out.println("outweight: "+outweight);
        return outweight;
    }
    public void updateAllWeights(double target){
        double x = 0;
        for(int i = 0; i < functions.size(); i++){//for each hidden node
            for(int j = 0; j <outputs.size(); j++){
                System.out.println(targets);
                //System.out.println(outputs);
                x = updateIndWeight(functions.get(i).outweights.get(j), 
                        functions.get(i).activationOut, targets.get(i), outputs.get(i));
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
                System.out.println("outweight ij: " + i+ " : " + j+" : " + functions.get(j).outweights.get(i));
            }
            //System.out.println("i: " + i + ", output: " + sum);
            outputs.set(i, sum);
        }
    }
}
