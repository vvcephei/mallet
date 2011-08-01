package cc.mallet.topics;

import cc.mallet.types.IDSorter;
import cc.mallet.types.InstanceList;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

/**
 * Created by IntelliJ IDEA.
 * User: jroesler
 * Date: 7/31/11
 * Time: 7:47 PM
 * I'm adding this interface to try and abstract away some of the complexity from MALLET's Topic Modeling
 */
public interface TopicModel {
    List<TopicModelResult> getDocumentTopics();

    void estimate()
            throws IOException;

    void addInstances(InstanceList instances);

    void setParams(Map params);

    ArrayList<TreeSet<IDSorter>> getSortedWords();
}
