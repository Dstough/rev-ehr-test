package RefractionConvertion.Model;

public class Refraction
{
    private float SpherePower;
    private float CylinderPower;
    private float Axis;

    public Refraction(float spherePower, float cylinderPower, float axis) throws Exception
    {
        //TODO: Confirm if the axis should be an int (requirements say "normally" in 1 degree increments, not "always")
        this.setSpherePower(spherePower);
        this.setCylinderPower(cylinderPower);
        this.setAxis(axis);
    }

    public void setSpherePower(float value) throws Exception
    {
        if (value < -25.0 || value > 25.0)
            throw new Exception(String.format("Sphere Power %s is incorrect. Must be between -25 and 25.", value));

        //TODO: Confirm if this needs to be rounded to the nearest increment of .25 units (requirements say "normally" not "always")

        this.SpherePower = value;
    }

    public float getSpherePower()
    {
        return this.SpherePower;
    }

    public void setCylinderPower(float value)
    {
        //TODO: Confirm if this needs to enforce +/- 15.00 (requirements say "generally" not "always")

        this.CylinderPower = value;
    }

    public float getCylinderPower()
    {
        return this.CylinderPower;
    }

    public void setAxis(float value)
    {
        var translatedValue = value;

        //TODO: Confirm if I need to account for, or enforce against, values larger than 360, or less than -180, etc...
        while (translatedValue < 1f)
            translatedValue += 180f;

        while (translatedValue > 180f)
            translatedValue -= 180f;

        this.Axis = translatedValue;
    }

    public float getAxis()
    {
        return this.Axis;
    }


    @Override
    public String toString()
    {
        var sphereValue = String.format(this.getSpherePower() >= 0f ? "+%.2f" : "%.2f", this.getSpherePower());
        var cylinderValue = String.format(this.getCylinderPower() >= 0f ?"+%.2f" : "%.2f", this.getCylinderPower());
        var axisValue = String.format("x%d",(long)this.getAxis());

        return sphereValue + " " + cylinderValue + " " + axisValue;
    }
}
