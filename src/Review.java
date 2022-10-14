public class Review {
    User reviewer;
    String content;
    int stars;

    public Review(User reviewer, String content, int stars) {
        this.reviewer = reviewer;
        this.content = content;
        this.stars = stars;
    }
    public void report(){

    }

    @Override
    public String toString() {
        return "Review{" +
                "reviewer=" + reviewer +
                ", content='" + content + '\'' +
                ", stars=" + stars +
                '}';
    }
}
