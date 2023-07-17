package Compilation;

interface TextAnalyzer {
    Label processText(String text);
}

enum Label {
    SPAM, NEGATIVE_TEXT, TOO_LONG, OK
}

abstract class KeywordAnalyzer implements TextAnalyzer {

    abstract protected String[] getKeywords();

    abstract protected Label getLabel();

    @Override
    public Label processText(String text) {
        for (String s : getKeywords()) {
            if (text.contains(s)) {
                return getLabel();
            }
        }
        return Label.OK;
    }
}

class SpamAnalyzer extends KeywordAnalyzer {
    private final String[] keywords;


    public SpamAnalyzer(String[] keywords) {
        this.keywords = keywords;
    }

    @Override
    protected String[] getKeywords() {
        return keywords;
    }

    @Override
    protected Label getLabel() {
        return Label.SPAM;
    }
}


class NegativeTextAnalyzer extends KeywordAnalyzer {
    private final String[] keywords = {":(", "=(", ":|"}; //change keywords


    @Override
    protected String[] getKeywords() {
        return keywords;
    }

    @Override
    protected Label getLabel() {
        return Label.NEGATIVE_TEXT;
    }
}


class TooLongTextAnalyzer implements TextAnalyzer {
    private final int maxLength;

    public TooLongTextAnalyzer(int maxLength) {
        this.maxLength = maxLength;
    }


    @Override
    public Label processText(String text) {
        return text.length() > maxLength ? Label.TOO_LONG : Label.OK;
    }
}

public class Text {

    public Label checkLabels(TextAnalyzer[] analyzers, String text) {
        for (TextAnalyzer analyzer : analyzers) {
            Label result = analyzer.processText(text);
            if (result != Label.OK) {
                return result;
            }
        }
        return Label.OK;
    }

    public static double sqrt(double x) {
        if (x < 0) {
            throw new IllegalArgumentException("Expected non-negative number got " + x);
        }
        return Math.sqrt(x);
    }
}



















