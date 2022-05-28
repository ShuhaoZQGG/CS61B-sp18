public class Planet {
    public double xxPos;
    public double xxVel;
    public double yyPos;
    public double yyVel;
    public double mass;
    String imgFileName;

    public Planet(double xP, double yP, double xV, double yV, double m, String img) {
        xxPos = xP;
        yyPos = yP;
        xxVel = xV;
        yyVel = yV;
        mass = m;
        imgFileName = img;
    }

    public Planet(Planet p) {
        this.xxPos = p.xxPos;
        this.xxVel = p.xxVel;
        this.yyPos = p.yyPos;
        this.yyVel = p.yyVel;
        this.mass = p.mass;
        this.imgFileName = p.imgFileName;
    }

    public double calcDistance(Planet p) {
        double dx_sqr = Math.pow(p.xxPos - this.xxPos, 2);
        double dy_sqr = Math.pow(p.yyPos - this.yyPos, 2);
        double r = Math.sqrt(dx_sqr + dy_sqr);
        return r;
    }

    public double calcForceExertedBy(Planet p) {
        double G = 6.67 * Math.pow(10, -11);
        double m1 = this.mass;
        double m2 = p.mass;
        double r = this.calcDistance(p);
        double F = G * m1 * m2 / Math.pow(r, 2);
        return F;
    }

    public double calcForceExertedByX(Planet p) {
        double r = this.calcDistance(p);
        double dx = p.xxPos - this.xxPos;
        double F = this.calcForceExertedBy(p);
        double Fx = F * dx / r;
        return Fx;
    }

    public double calcForceExertedByY(Planet p) {
        double r = this.calcDistance(p);
        double dy = p.yyPos - this.yyPos;
        double F = this.calcForceExertedBy(p);
        double Fy = F * dy / r;
        return Fy;
    }

    public double calcNetForceExertedByX(Planet[] allP) {
        double Fnetx = 0.0;
        for (int i = 0; i < allP.length; i ++) {
            if (!this.equals(allP[i])) {
                Fnetx += this.calcForceExertedByX(allP[i]);
            }
        }

        return Fnetx;
    }

    public double calcNetForceExertedByY(Planet[] allP) {
        double Fnety = 0.0;
        for (int i = 0; i < allP.length; i ++) {
            if (!this.equals(allP[i])) {
                Fnety += this.calcForceExertedByY(allP[i]);
            }
        }

        return Fnety;
    }

    public void update(double dt, double Fx, double Fy) {
        double ax = Fx / this.mass;
        double ay = Fy / this.mass;
        this.xxVel += ax * dt;
        this.yyVel += ay * dt;
        this.xxPos += this.xxVel * dt;
        this.yyPos += this.yyVel * dt;
    }

    public void draw() {
        StdDraw.picture(this.xxPos, this.yyPos, "images/" + this.imgFileName);
    }
}
