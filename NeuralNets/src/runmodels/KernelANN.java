package runmodels;

import java.util.ArrayList;
import java.util.Random;

public class KernelANN extends AbstractModel {

    private ArrayList<Double> inputs;
    private ArrayList<RBFNode> functions;
    private ArrayList<Double> outputs;
    private double eta = 0.1;//learning rate
    private Distance dist = new Distance();
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
        for(int i = 0; i < numInputs; i++){ //TODO need to figure out if inputs means features or training examples...
            inputs.set(i, 0.0);
        }
        for(int j = 0; j < numOutputs; j++){
            outputs.set(j, 0.0);
        }
        for(int k = 0; k < numFunctions; k++){
            RBFNode node = new RBFNode();
            functions.set(k, node);
            for(int i = 0; i < outputs.size(); i++){
                functions.get(k).outweights.set(i, rand.nextDouble());//initialize to Random weights?
            }
//            for(int j = 0; j < outputs.size(); j++){
//                functions.get(k).inweights.set(j, rand.nextDouble());//initialize to Random weights?
//            }
            //TODO set variance
            //TODO set means via k-means
        }
    }

    public void kMeansClustering(int k) {
        //TODO figure out how to do k-means...
    }

    public double updateIndWeight(double inweight, double input, ArrayList<Double> target, ArrayList<Double> observed, ArrayList<Double> x) {
        double outweight = inweight;
        outweight += dist.calculateDistance(target, observed)*eta*input;//multiply this by input
        return outweight;
    }
    public void updateAllWeights(){
        
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
