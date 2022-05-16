public class NBody {
    public static double readRadius(String path) {
        In in = new In(path);
        int counter = 0;
        while (counter < 1) {
            in.readLine();
            counter += 1;
        }
        double res = in.readDouble();
        return res;
    }

    public static Planet[] readPlanets(String path) {
        In in = new In(path);
        Planet[] planets = new Planet[in.readInt()];
        int counter = 0;
        while (counter < 2) {
            in.readLine();
            counter += 1;
        }

//      double xP, double yP, double xV, double yV, double m, String img
        counter = 0;
        while (counter < 5) {
            double xP = in.readDouble();
            double yP = in.readDouble();
            double xV = in.readDouble();
            double yV = in.readDouble();
            double m = in.readDouble();
            String img = in.readString();
            planets[counter] = new Planet(xP, yP, xV, yV, m, img);
            counter += 1;
        }
        return planets;
    }
}