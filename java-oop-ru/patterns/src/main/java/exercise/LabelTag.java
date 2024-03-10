package exercise;

public class LabelTag implements TagInterface {
    private String labelText;
    private TagInterface innerTag;

    public LabelTag(String labelText, TagInterface innerTag) {
        this.labelText = labelText;
        this.innerTag = innerTag;
    }

    @Override
    public String render() {
        String innerHtml = innerTag.render();
        return "<label>" + labelText + innerHtml + "</label>";
    }
}

