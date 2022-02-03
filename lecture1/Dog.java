public class Dog {
    public int weightInPounds;

    // Constructor for Dogs
    public Dog (int w) {
        weightInPounds = w;
    }

    public void MakeNoise() {
        if (weightInPounds < 10) {
            System.out.println("Yip!");
        } else if (weightInPounds < 30) {
            System.out.println("Bark!");
        } else {
            System.out.println("Woof!");
        }
    }
}