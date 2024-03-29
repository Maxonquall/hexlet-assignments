package exercise;

import java.util.Map;

abstract class Tag {
    protected String tagName;
    protected Map<String, String> attributes;

    Tag(String tagName, Map<String, String> attributes) {
        this.tagName = tagName;
        this.attributes = attributes;
    }

    public abstract String toString();
}
