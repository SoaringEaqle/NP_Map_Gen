public class ScaleCalc {

    private final double scale = 0.0625;//units per lightyear
    private double units;
    private double ltyr;



    public double ltyrPUnt(double lightyears)
    {
        units = lightyears * scale;
        return units;
    }
    public double ltyrPUnt()
    {
        units = ltyr * scale;
        return units;
    }

    public double maxRange(int level)
    {
        return level + 4;
    }

    public double maxRangeU(int level)
    {
        double maxRange1 = this.maxRange(level);
        return this.ltyrPUnt(maxRange1);
    }

    public double unitPLy() {
        return this.units / scale;
    }

    public void setUnits(double units)
    {
        this.units = units;
    }

    public void setLtyr(double ltyr)
    {
        this.ltyr = ltyr;
    }

}
