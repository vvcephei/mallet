package cc.mallet.topics;

import cc.mallet.types.IDSorter;

/**
 * Created by IntelliJ IDEA.
 * User: jroesler
 * Date: 7/10/11
 * Time: 11:30 AM
 * To change this template use File | Settings | File Templates.
 */
public class TopicModelResult {

    private class WeightedWord{
        private int _id;
        private double _weight;
        WeightedWord(int id, double weight) {
            _id = id;
            _weight = weight;
        }

        public int getId() {
            return _id;
        }

        public double getWeight() {
            return _weight;
        }
    }

    private int _id;
    private String _source;
    private WeightedWord[] _sortedTopics;

    private String safeToString(Object o) {
        if (o == null) {
            return "null";
        } else {
            return o.toString();
        }
    }

    public TopicModelResult(int id, Object source, IDSorter[] sortedTopics) {
        _id = id;
        _source = safeToString(source);
        setSortedTopics(sortedTopics);
    }

    private void setSortedTopics(IDSorter[] sortedTopics){
        _sortedTopics = new WeightedWord[sortedTopics.length];
        for (int i=0; i<sortedTopics.length; i++){
            _sortedTopics[i] = new WeightedWord(sortedTopics[i].getID(), sortedTopics[i].getWeight());
        }
    }
    
    public Double getWeight(int i){
        return (Double) _sortedTopics[i].getWeight();
    }
    public Integer getID(int i){
        return (Integer) _sortedTopics[i].getId();
    }

    public String toString(double threshold, int max, String separator) {

        String result = String.format("%d%s",_id, separator);
        for (int i = 0; i < max; i++) {
            if (getWeight(i) < threshold) {
                break;
            }

            result += String.format("%d%s%.3f%s", getID(i), separator, getWeight(i), separator);
        }
        return result+ _source;
    }
}
