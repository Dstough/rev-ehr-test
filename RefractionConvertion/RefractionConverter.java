package RefractionConvertion;

public class RefractionConverter
{
    public static void ConvertToPlusCylinderNotation(Refraction refraction) throws Exception
    {
        //TODO: verify if zero ought to be treated as a positive number in this context
        if (refraction.getCylinderPower() >= 0)
            return;

        InvertRefraction(refraction);
    }

    public static void ConvertToMinusCylinderNotation(Refraction refraction) throws Exception
    {
        if (refraction.getCylinderPower() < 0)
            return;

        InvertRefraction(refraction);
    }

    public static void InvertRefraction(Refraction refraction) throws Exception
    {
        var spherePower = refraction.getSpherePower() + refraction.getCylinderPower();
        var cylinderPower = refraction.getCylinderPower() * -1f;
        var axis = refraction.getAxis() <= 90f ? refraction.getAxis() + 90f : refraction.getAxis() - 90f;

        refraction.setSpherePower(spherePower);
        refraction.setCylinderPower(cylinderPower);
        refraction.setAxis(axis);
    }
}
