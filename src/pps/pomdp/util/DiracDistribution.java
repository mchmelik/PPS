package pps.pomdp.util;

import java.util.HashSet;
import java.util.Set;

/**
 * A class that represents the Dirac probability distribution, i.e., only one element with probability 1. Null elements
 * are not allowed in the distribution.
 * @author Martin Chmelik
 */


public class DiracDistribution<T> implements Distribution<T>{


    private final T item;
    private final Integer hashCode;

    /**
     * The contructor of the Dirac distribution
     * @param item is the only argument with probability 1.0
     * @throws NullPointerException if {code item} is null.
     */
    public DiracDistribution(T item) throws NullPointerException{
        if(item == null){
            throw new NullPointerException("The argument item is not allowed to be null");
        }
        this.item = item;
        this.hashCode = item.hashCode();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DiracDistribution<?> that = (DiracDistribution<?>) o;

        return item.equals(that.item);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        return hashCode;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return "Dirac Distribution: " + item.toString() + " -> 1.0";
    }

    /**
     * Returns the probability of item T
     *
     * @param item the element to return the probability of.
     * @return the probability of the element, 0 if the probability is not positive.
     * @throws NullPointerException if {@code item} is {@code null}.
     */
    @Override
    public Double getProbability(T item) throws NullPointerException {
        if(item == null){
            throw new NullPointerException("The item argument is not allowed to be null");
        }

        if(item.equals(this.item)){
            return 1.0D;
        }
        return 0.0D;
    }

    /**
     * Returns the support of the probability distribution, i.e., a set of all the items {code item} on which
     * getProbability(item) > 0
     *
     * @return the set of items.
     */
    @Override
    public Set<T> getDistSupport() {
        Set<T> support = new HashSet<>();
        support.add(item);
        return support;
    }

    /**
     * Returns whether an {code item} has positive probability, i.e., getProbabilit(item)>0;
     *
     * @param item the item to check for presence in the support.
     * @return a Boolean value, {code True} when {code item} is in the support and {code False} otherwise.
     */
    @Override
    public Boolean isInSupport(T item) throws NullPointerException{
        if(item == null){
            throw new NullPointerException("The argument item is not allowed to be null");
        }
        if(this.item.equals(item)){
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    /**
     * Sample an element from the distribution according to the distribution.
     *
     * @return {code item} sampled from the distribution
     */
    @Override
    public T sampleItem() {
        return item;
    }
}
