package Records;

public record NewsAboutDunno(String report, boolean isAlive) {
    public NewsAboutDunno {
        System.out.printf("Город был потрясен новостью о путешественнике: %s%n", report);
    }
}
