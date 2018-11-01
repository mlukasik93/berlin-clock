public class test {

    public static void main(String[] args) {
        String test = "00:00:00";
        BerlinClock berlinClock = new BerlinClock();
        System.out.println(berlinClock.getClock(test));
    }
}