/**
 * Created by Sam on 12/13/15.
 */
public class driverTemp {
    public static void main(String[] args) {
        YahtzeeDie die1 = new YahtzeeDie(6);
        YahtzeeDie die2 = new YahtzeeDie(6);
        YahtzeeDie die3 = new YahtzeeDie(6);
        YahtzeeDie die4 = new YahtzeeDie(6);
        YahtzeeDie die5 = new YahtzeeDie(6);
        die1.rollDie();
        die2.rollDie();
        die3.rollDie();
        die4.rollDie();
        die5.rollDie();
        System.out.println(die1.getValue());
        System.out.println(die2.getValue());
        System.out.println(die3.getValue());
        System.out.println(die4.getValue());
        System.out.println(die5.getValue());
    }
}
