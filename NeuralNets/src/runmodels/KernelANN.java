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
       // for(int i = 0; i < numInputs; i++){ //TODO need to figure out if inputs means features or training examples...
           // inputs.set(i, 0.0);
        //}
        for(int j = 0; j < numOutputs; j++){
            outputs.set(j, 0.0);
        }
        for(int k = 0; k < numFunctions; k++){
            RBFNode node = new RBFNode();
            functions.set(k, node);
            for(int i = 0; i < inputs.size(); i++){
                functions.get(k).inweights.set(i, 0.0);//initialize to Random weights?
            }
            for(int j = 0; j < outputs.size(); j++){
                functions.get(k).inweights.set(j, 0.0);//initialize to Random weights?
            }
            functions.get(k).var = 0.0; //TODO set variance
            //TODO how to set mean?
        }
    }

    public void kMeansClustering(int k) {
        //TODO figure out how to do k-means...
    }

    public void updateWeights() {
        //TODO do weight updates
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
