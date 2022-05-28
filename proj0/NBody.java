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

    public static void main(String[] args) {
        double time = 0;
        double T = Double.parseDouble(args[0]);
        double dT = Double.parseDouble(args[1]);
        String filename = args[2];
        Planet[] planets = NBody.readPlanets(filename);
        double radius = NBody.readRadius(filename);

        while (time < T) {
            double[] xForces = new double[planets.length];
            double[] yForces = new double[planets.length];
            StdDraw.enableDoubleBuffering();
            StdDraw.setScale(-radius, radius);
            StdDraw.picture(0,0,"images/starfield.jpg");
            for (int i = 0; i < planets.length; i++) {
                xForces[i] = planets[i].calcNetForceExertedByX(planets);
                yForces[i] = planets[i].calcNetForceExertedByY(planets);
            }
            for (int i = 0; i < planets.length; i++) {
                planets[i].update(dT, xForces[i], yForces[i]);
                planets[i].draw();
            }

            StdDraw.show();
            StdDraw.pause(10);
            time += dT;
        }

        StdOut.printf("%d\n", planets.length);
        StdOut.printf("%.2e\n", radius);
        for (int i = 0; i < planets.length; i++) {
            StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                    planets[i].xxPos, planets[i].yyPos, planets[i].xxVel,
                    planets[i].yyVel, planets[i].mass, planets[i].imgFileName);
        }
    }
}