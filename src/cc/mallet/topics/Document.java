package cc.mallet.topics;

import cc.mallet.util.CommandOption;

/**
 * Created by IntelliJ IDEA.
 * User: jroesler
 * Date: 7/31/11
 * Time: 7:51 PM
 * To change this template use File | Settings | File Templates.
 */
public interface Document {
    String getDocumentTopicString(double v, int numTopics, String separator);
}
