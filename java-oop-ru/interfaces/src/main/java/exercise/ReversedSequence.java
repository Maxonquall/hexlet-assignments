package exercise;

public class ReversedSequence implements CharSequence {

    private String string;

    public ReversedSequence(String string) {
        this.string = string;
    }

    @Override
    public int length() {
        return string.length();
    }

    @Override
    public char charAt(int index) {
        return string.charAt(string.length() - 1 - index);
    }

    @Override
    public CharSequence subSequence(int start, int end) {
        return new ReversedSequence(string.substring(start, end));
    }

    @Override
    public String toString() {
        StringBuilder reversed = new StringBuilder(string).reverse();
        return reversed.toString();
    }
}
