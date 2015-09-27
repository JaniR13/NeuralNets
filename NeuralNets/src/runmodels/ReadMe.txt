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
	
NOTE: NeuralNets.java will soon become an abstract class as well, from which our two neural net classes will inherit. We
	just need to figure out what shared functionalities they will have first. Stay tuned!
	
///////// Other Classes /////////

FeedForwardANN.java
	Will implement a feed-forward neural network that uses back-propagation.
	
ANNNode.java
	Node for a FeedForwardANN. I should rename this to reflect that - my naming is bad and I feel bad.
	
KernelANN.java
	Will implement a radial basis function network.
	
LogisticFunction.java
	A Logistic activation function for a neural network.
	
MeanSquaredError.java
 	A loss function for calculating error. I know this is used for backprop, not sure if it can extend to an RBF.
 	
NeuralNets.java
 	Will eventually become parent classes for KernelANN and FeedForwardANN, probably.
 	
RunModels.java
	??????????????????????



##########################################
############## KNOWN ISSUES: #############
##########################################	

* There is not yet a specific node class for KernelANN, but it can't use ANNNode (I think).

* MeanSquareError function is not yet implemented or tested - can't measure error yet.

* We're including the input nodes as a layer for FeedForward, so we need to make sure we know how to deal with that.

* We need some way to determine the structure of the network, i.e. how many layers and how many nodes per layer, AND
	number of inputs.
	
* We don't yet have the bias node really included.

* Need to find some way to define the ancestors and descendants of each node - right now, it's a list in the ANNNode class