import java.util.Arrays;
import java.util.Map;
import org.apache.commons.math3.distribution.NormalDistribution;


public class Planet{
    //presets
    public String[] biomeOptions = new String[] {
        "Desert", "Forest", "Beaches", "City", "Ocean", "Wasteland",
        "Firelands", "Icy", "Islands", "Rocky"
    };

    public String[] exportOptions = new String[] {
        "Computers", "Spaceships", "Health", "Food", "Skilled Labor",
        "Grunt Labor", "Information Services (online)", "Entertainment"
    };

    public String[] raceOptions = new String[] {
        "Human", "Elf", "Dwarf", "Gnome", "Goblin", "Android",
        "Wookie"
    };

    public String[] planetNaming = new String[] {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k"};

    //physics
    public double size;
    public double gravity;
    public String biome;
    //public boolean multiBiome;   //false -> the whole planet is the same biome

    //economics
    public double gdp;
    public double econInequality;
    public double importReliance;
    public Planet[] tradeAllies;
    public String mainExport;

    //culture
    public double[] racePopDistribution;   //what percentage of each race lives here (comparing with raceOptions[])
    public double populationDensity;
    public double globalistCulture;    //how globalist (or nationalist) is the planet overall
    public double galacticCulture; //how galactic (or planet-centric) is the planet overall

    //misc
    public Star parentStar;

    public void printVals(int id){
        System.out.printf("Object #%d-%s\n", parentStar.id, planetNaming[id]);
        System.out.println("(Planet "+id+")");

        System.out.println("\nsize, gravity, biome");
        System.out.printf("%.2f, %.2f, %s\n", size, gravity, biome);

        System.out.println("gdp, inequality, import reliance, mainExport");
        System.out.printf("%.2f, %.2f, %.2f, %s\n", gdp, econInequality, importReliance, mainExport);
        
        System.out.println("racePopDistro, popDensity, globalism, galacticism");
        System.out.printf("%s, %.2f, %.2f, %.2f\n", Arrays.toString(racePopDistribution), 
                            populationDensity, globalistCulture, galacticCulture);
    }
}