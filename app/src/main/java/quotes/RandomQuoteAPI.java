package quotes;

public class RandomQuoteAPI {

    private String content;
    private String author;

    public String getContent() {
        return content;
    }

    public String getAuthor() {
        return author;
    }

    @Override
    public String toString() {
        return "RandomQuoteAPI{" +
                "content='" + content + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}
