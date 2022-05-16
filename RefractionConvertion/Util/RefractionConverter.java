package RefractionConvertion.Util;

import RefractionConvertion.Model.Refraction;
import java.util.regex.Pattern;

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

    public static Refraction ParseRefraction(String input) throws Exception
    {
        //TODO: Verify if a valid data format is only the Cylinder Power and Axis alone.
        // This type of pattern: -3.75 +2.00 x154
        var pattern = Pattern.compile("[+|-]\\d\\.\\d{2} [+|-]\\d\\.\\d{2} x\\d{3}");
        var matcher = pattern.matcher(input);

        if(!matcher.find())
            throw new Exception(String.format("Could not parse refraction \"%s\". Invalid data format.", input));

        var value = input.split(" ");
        var spherePower = Float.parseFloat(value[0]);
        var cylinderPower = Float.parseFloat(value[1]);
        var axis = Float.parseFloat(value[2].replace("x", ""));

        return new Refraction(spherePower, cylinderPower, axis);
    }
}
