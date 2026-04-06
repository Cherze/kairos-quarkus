package br.com.kairos.timetabling.flyweight;

 
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class FlyIntFactory {

	private final Map<Integer, FlyInteger> flyIntegerPool;
	private final Random random;
	
	private static FlyIntFactory flyIntegerFactory;

	public static FlyIntFactory getFlyIntFactory(){
		if(flyIntegerFactory == null)
			flyIntegerFactory = new FlyIntFactory();
		return flyIntegerFactory;
	}	
	
	private FlyIntFactory(){
		this.flyIntegerPool = new HashMap<Integer, FlyInteger>();
		this.random = new Random();
	}
	
	public FlyInteger getFlyInteger(int allele){
		FlyInteger flyInteger = this.flyIntegerPool.get(Integer.valueOf(allele));
		if(flyInteger == null){
			flyInteger = new FlyInteger(allele);
			this.flyIntegerPool.put(Integer.valueOf(allele), flyInteger);
		}
		return flyInteger;
	}
	
	public FlyInteger getFlyInteger(){
		return this.getFlyInteger(this.random.nextInt());
	}
	
	public FlyInteger getFlyIntegerWithRange(int maxValue){
		FlyInteger flyInteger = this.getFlyInteger(this.random.nextInt(maxValue));
		flyInteger.setMaxValue(maxValue);
		return flyInteger;
	}

}
