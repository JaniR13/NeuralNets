package runmodels;

// https://svn.cms.waikato.ac.nz/svn/weka/branches/stable-3-2-1/weka/classifiers/neural/NeuralMethod.java
public abstract class AbstractFunction {
	
	public AbstractFunction(){
		
	}
	
	abstract double calcfx(double x);
	abstract double calcderivfx(double x);

}
