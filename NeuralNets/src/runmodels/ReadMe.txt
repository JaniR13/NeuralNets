##########################################
################# FILES: #################
##########################################

///////// Abstract Classes /////////

AbstractFunction.java
	Template for a function, e.g. an activation function like a Logistic function.

AbstractModel.java
	Template for a general machine learning model, e.g. an artificial neural network (ANN).
	
AbstractNode.java
	Template for a node/unit in a neural network. Currently, the only shared functionality is to calculate the output (double) 
	based on a vector of inputted doubles.

ActivationFunction.java
	Template for the neural node activation functions. Per the project parameters we need
	to implement 2 possibilities for the feed forward neural net (hereafter, FFNN) and one
	for the radial basis function neural network (hereafter, RBFNN). 

NeuralNets.java
	Template for a neural network. 
	
NOTE: Not all of these abstract classes were fully implemented, but we kept them to 
use as a template going forward, because we feel that is good programming practice. 
	
///////// Other Classes /////////



FeedForwardANN.java
	Will implement a feed-forward neural network that uses back-propagation.
	
ANNNode.java
	Node for a FeedForwardANN. I should rename this to reflect that - my naming is bad and I feel bad.
	
KernelANN.java
	Implements a radial basis function network, with k-means clustering, gradient descent and 
        Gaussian function for basis nodes. Simple weighted sum for output. 
	
LogisticFunction.java
	A Logistic activation function for a neural network.
	
MeanSquaredError.java
 	A loss function for calculating error. I know this is used for backprop, not sure if it can extend to an RBF.
 	
NeuralNets.java
 	Will eventually become parent classes for KernelANN and FeedForwardANN, probably.

RBFNode.java
        Stores the weights, function, variance, mean for each Basis Function. 
 	
RunModels.java
	??????????????????????



##########################################
############## KNOWN ISSUES: #############
##########################################	

* There is not yet a specific node class for KernelANN, but it can't use ANNNode (I think).

* MeanSquareError function is not yet implemented or tested - can't measure error yet.

* We're including the input nodes as a layer for FeedForward, so we need to make sure we know how to deal with that.

* I have no idea how output nodes work or whether or not we're including them. 

* We need some way to determine the structure of the network, i.e. how many layers and how many nodes per layer, AND
	number of inputs.
