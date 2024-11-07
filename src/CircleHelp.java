public class CircleHelp {
    public static double PtoCX(double r, double angle, double cenX)
    {
        double difX = r * Math.cos(angle);

        return difX + cenX;

    }
    public static double PtoCY(double r, double angle, double cenY)
    {
        double difY = r * Math.sin(angle);
        return difY + cenY;
    }

    public static double round4(double num)
    {
        return (Math.round(num * 10000.0)/10000.0);
    }

}