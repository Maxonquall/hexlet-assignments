package exercise;

import java.util.Map;

class PairedTag extends Tag {
    private String body;
    private java.util.List<Tag> children;

    PairedTag(String tagName, Map<String, String> attributes, String body, java.util.List<Tag> children) {
        super(tagName, attributes);
        this.body = body;
        this.children = children;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("<").append(tagName);
        for (Map.Entry<String, String> entry : attributes.entrySet()) {
            sb.append(" ").append(entry.getKey()).append("=\"").append(entry.getValue()).append("\"");
        }
        sb.append(">");
        sb.append(body);
        for (Tag child : children) {
            sb.append(child.toString());
        }
        sb.append("</").append(tagName).append(">");
        return sb.toString();
    }
}

