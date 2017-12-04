package pps.pomdp.util;

import java.lang.String;
import java.lang.Integer;


/**
 * A class that represents a POMDP observation.
 * @author Martin Chmelik
 */
public final class Observation extends Object{
    private final String name;
    private final Integer id;
    private Integer hashCode;


    /**
     * The constructor takes two parameters the observation name and the observation id.
     * @param name the observation name.
     * @param id the observation id.
     * @throws NullPointerException if {@code name} or {@code id} is {@code null}.
     */
    public Observation(String name, Integer id) {
        if(name == null){
            throw new NullPointerException("Observation does not allow null as name parameter");
        }
        if(id == null){
            throw new NullPointerException("Observation does not allow null as id parameter");
        }
        this.name = name;
        this.id = id;
        this.hashCode = null;
    }


    /**
     *  The method returns the name of the observation.
     * @return the name of the observation.
     */
    public String getName() {
        return name;
    }

    /**
     * The method returns the id of the observation.
     * @return the id of the observation.
     */
    public Integer getId() {
        return id;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Observation that = (Observation) o;

        if (!name.equals(that.name)) return false;
        return id.equals(that.id);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        if(hashCode == null) {
            hashCode = name.hashCode();
            hashCode = 31 * hashCode + id.hashCode();
        }
        return hashCode;

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return "Observation{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                '}';
    }


}
