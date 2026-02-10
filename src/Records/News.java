package Records;

public record News(String report, boolean isAlive) {
    public News {
        System.out.printf("Город был потрясен новостью о путешественнике, который '%s'%n", report);
    }
}
