package com.cooksys.ftd.assignments.objects;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class Rational implements IRational {
	
	private int n;
	private int d;
	
    /**
     * Constructor for rational values of the type:
     * <p>
     * `numerator / denominator`
     * <p>
     * No simplification of the numerator/denominator pair should occur in this method.
     *
     * @param numerator   the numerator of the rational value
     * @param denominator the denominator of the rational value
     * @throws IllegalArgumentException if the given denominator is 0
     */
	
    public Rational(int numerator, int denominator) throws IllegalArgumentException {
        if(denominator == 0){
        	throw new IllegalArgumentException();
        }
        this.n = numerator;
        this.d = denominator;
    }

    /**
     * @return the numerator of this rational number
     */
    @Override
    public int getNumerator() {
        
    	return this.n;
    }

    /**
     * @return the denominator of this rational number
     */
    @Override
    public int getDenominator() {
        
    	return this.d;
    }

    /**
     * Specializable constructor to take advantage of shared code between Rational and SimplifiedRational
     * <p>
     * Essentially, this method allows us to implement most of IRational methods directly in the interface while
     * preserving the underlying type
     *
     * @param numerator the numerator of the rational value to construct
     * @param denominator the denominator of the rational value to construct
     * @return the constructed rational value
     * @throws IllegalArgumentException if the given denominator is 0
     */
    @Override
    public Rational construct(int numerator, int denominator) throws IllegalArgumentException {
        if(denominator == 0){
        	throw new IllegalArgumentException();
        }
        
        return new Rational(numerator, denominator);
    }

    /**
     * @param obj the object to check this against for equality
     * @return true if the given obj is a rational value and its
     * numerator and denominator are equal to this rational value's numerator and denominator,
     * false otherwise
     */
    @Override
    public boolean equals(Object obj) { // how to compare obj values to 'this'?
        if(obj instanceof Rational){
        	if(((Rational)obj).n == this.n && (((Rational)obj).d) == this.d){
        		return true;
        	}else{
        		return false;
        	}
        }else{
        	return false;
        }
    }

    /**
     * If this is positive, the string should be of the form `numerator/denominator`
     * <p>
     * If this is negative, the string should be of the form `-numerator/denominator`
     *
     * @return a string representation of this rational value
     */
    @Override
    public String toString() {
    								
        if((getNumerator() < 0 && getDenominator() < 0) || (getNumerator() > 0 && getDenominator() > 0)){
        	
        	return Math.abs(getNumerator()) + "/" + Math.abs(getDenominator());
        	
        }else if(getNumerator() < 0 || getDenominator() < 0){
        	
        	return "-" + Math.abs(getNumerator()) + "/" + Math.abs(getDenominator());
        }else{
        	
        	return Math.abs(getNumerator()) + "/" + Math.abs(getDenominator());
        }
    }
}