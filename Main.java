import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import RefractionConvertion.*;

public class Main
{
    public static void main(String[] args)
    {
        try
        {
            var file = new File(args[0]);

            if(!file.exists())
                throw new Exception("Data file doesn't exist or is not accessible");

            try (var reader = new BufferedReader(new FileReader(args[0])))
            {
                String line;
                var lineNumber = 0;
                while ((line = reader.readLine()) != null)
                {
                    if(lineNumber == 0)
                        System.out.println("Line | PlusCylinderNotation | MinusCylinderNotation ");

                    var lineText = String.format("%4s", lineNumber);

                    try
                    {
                        var refraction = RefractionConverter.ParseRefraction(line);

                        RefractionConverter.ConvertToPlusCylinderNotation(refraction);

                        var plusNotationText = String.format("%20s", refraction);

                        RefractionConverter.ConvertToMinusCylinderNotation(refraction);

                        var minusNotationText = String.format("%21s", refraction);

                        System.out.println(lineText + " | " + plusNotationText + " | " + minusNotationText);
                    }
                    catch (Exception ex)
                    {
                        System.out.println(lineText + " | " + ex.toString());
                    }
                    lineNumber++;
                }
            }
        }
        catch (Exception ex)
        {
            System.out.println(ex.toString());
        }
    }
}