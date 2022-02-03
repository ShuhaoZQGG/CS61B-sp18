public class DogLauncher {
    public static void main(String[] args) {
        Dog smallDog = new Dog(7);
        smallDog.MakeNoise();
        // This is what we do without a constructor
        // smallDog.weightInPounds = 7;

        Dog bigDog = new Dog(35);
        bigDog.MakeNoise();
    }
}