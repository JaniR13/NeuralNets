package runmodels;

import java.util.ArrayList;

public class KernelANN extends AbstractModel {

    private ArrayList<Double> inputs;
    private ArrayList<RBFNode> functions;
    private ArrayList<Double> outputs;

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

    }

    public void kMeansClustering(int k) {

    }

    public void updateWeights() {

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
