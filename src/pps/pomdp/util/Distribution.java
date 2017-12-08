package pps.pomdp.util;

import java.util.Set;


/**
 * An interface that represents a probability distribution.
 * @author Martin Chmelik
 */

public interface Distribution<T> {
    /**
     * Returns the probability of item T
     * @param item the element to return the probability of.
     * @return the probability of the element, 0 if the probability is not positive.
     * @throws NullPointerException if {@code item} is {@code null}.
     */
    public Double getProbability(T item);

    /**
     * Returns the support of the probability distribution, i.e., a set of all the items {code item} on which
     * getProbability(item) > 0
     * @return the set of items.
     */
    public Set<T>  getDistSupport();

    /**
     * Returns whether an {code item} has positive probability, i.e., getProbabilit(item)>0;
     * @param item the item to check for presence in the support.
     * @return a Boolean value, {code True} when {code item} is in the support and {code False} otherwise.
     */
    public Boolean isInSupport(T item);
}
