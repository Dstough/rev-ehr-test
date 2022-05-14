import RefractionConvertion.*;

public class Main
{
    public static void main(String[] args)
    {
        try
        {
            var refraction = new Refraction(-3.75f, +2.00f, 154f);

            System.out.println(refraction.toString());
        }
        catch (Exception ex)
        {
            System.out.println(ex.toString());
        }
    }
}