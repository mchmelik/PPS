package pps.pomdp.util;

public class State<T> extends Object{
    private final Long id;
    private final String name;
    private T data;
    private Distribution<Observation> obsDistr;
    private Integer hashcode;


    /**
     * The State contructor that represents the POMDP state. The State instance is uniquely defined by the the id parameter.
     * @param id The unique identification number of the state.
     * @param name The name of the state, to be used in the toString method.
     * @param obsDistr The probabilistic distribution over observations observable in the state.
     */
    public State(Long id, String name, Distribution<Observation> obsDistr) {
        this(id, name, obsDistr, null);
    }

    /**
     * The State contructor that represents the POMDP state. The State instance is uniquely defined by the the id parameter.
     * @param id The unique identification number of the state.
     * @param name The name of the state, to be used in the toString method.
     * @param obsDistr The probabilistic distribution over observations observable in the state.
     * @param data The optional argument to store additional data in the state.
     */
    public State(Long id, String name, Distribution<Observation> obsDistr, T data) {
        if(id==null){
            throw new NullPointerException("Class State does allow the id parameter to be null");
        }
        if(name==null){
            throw new NullPointerException("Class State does not allow the name parameter to be null");
        }
        if(obsDistr==null){
            throw new NullPointerException("Class State does not allow the observation distribution parameter to be null");
        }

        this.id = id;
        this.name = name;
        this.obsDistr = obsDistr;
        this.data = data;
        this.hashcode = this.id.hashCode();
    }


    /**
     * A method that returns the data stored in the state and {@code null} in case the state does not store any data.
     * @return The data stored in the state.
     */
    public T getData() {
        return data;
    }

    /**
     * A method to store data in a state.
     * @param data to be stored in the state, can be {@code null}
     */
    public void setData(T data) {
        this.data = data;
    }

    /**
     * A method that returns the observation distribution of the state.
     * @return The observation distribution of the state.
     */
    public Distribution<Observation> getObsDistr() {
        return obsDistr;
    }

    /**
     * A method to retrieve the unique id of the state.
     * @return The id of the state.
     */
    public Long getId() {
        return id;
    }

    /**
     * A method that returns the name attribute.
     * @return The name of the state.
     */
    public String getName() {
        return name;
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return "State{" +
                "name='" + name + '\'' +
                '}';
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        State<?> state = (State<?>) o;

        return id.equals(state.id);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        return this.hashcode;
    }
}
