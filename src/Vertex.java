public class Vertex<E> implements Comparable<Vertex<E>> {    private final E data;    private int distance;    /**     * @param data a generic element     */    Vertex(E data) {        this.data = data;    }    /**     * @return returns the name of the element     */    public String toString() {        return data.toString();    }    /**     * @return returns the element     */    E getData() {        return data;    }    /**     * @return returns the distance of the element     */    int getDistance() {        return distance;    }    /**     * @param d the value which the distance is to be set to     */    void setDistance(int d) {        distance = d;    }    /**     * Sets the distance variable to "infinity"     */    void setMax() {        distance = Integer.MAX_VALUE;    }    /**     * @param o another vertex     * @return the difference between the distance variables of the vertices     */    @Override    public int compareTo(Vertex<E> o) {        return getDistance() - o.getDistance();    }}