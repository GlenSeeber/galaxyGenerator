import org.apache.commons.math3.distribution.NormalDistribution;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Random;

public class Star {
    int[] position; //[x, y, z], using scale of -1000 <= x,y,z <= 1000
    
    Planet planets[];

    public int id;

    public Star(int num, int id){
        //all stars must have at least 1 planet, no negative or zero values
        if(num < 1){
            num = 1;
        }
        this.id = id;
        
        System.out.printf("Star #%d\nPlanet(s): %d\n\n", id, num);

        DecimalFormat dFormat = new DecimalFormat("#.##");
        planets = new Planet[num];
        //create some new planets.
        //for(Planet p : planets){
        //}
        Random linearNoise = new Random();
        NormalDistribution noise10 = new NormalDistribution(6, 2.0);
        //loop through planets[], call the current planet p and save it to the array.
        for(int currentPlanet = 0; currentPlanet < num; ++currentPlanet){
            Planet p = new Planet();
            planets[currentPlanet] = p;

            //Physical Characteristics:
            p.size = Double.valueOf(dFormat.format(noise10.sample()));
            p.gravity = Double.valueOf(dFormat.format(noise10.sample()));
            //assign with a random option from the list, using linear random noise 
            p.biome = p.biomeOptions[linearNoise.nextInt(p.biomeOptions.length)];

            //Economics:
            p.gdp = Double.valueOf(dFormat.format(noise10.sample()));
            p.econInequality = Double.valueOf(dFormat.format(noise10.sample()));
            p.importReliance = Double.valueOf(dFormat.format(noise10.sample()));
            //don't deal with trade allies until you've generated all the star systems.
            p.mainExport = 
                p.exportOptions[linearNoise.nextInt((p.exportOptions.length))];

            //Culture:
            int raceCount = p.raceOptions.length;
            //somewhere between 1 and 3 major demographics
            int majorCount = linearNoise.nextInt(2) + 1;
            int[] majors = new int[majorCount]; 
            //setup which index of race will be major demographics
            for (int i = 0; i < majorCount; ++i){
                majors[i] = linearNoise.nextInt(raceCount);
            }

            double[] racePop = new double[raceCount];
            //bell curves for major pop and minor pop.
            NormalDistribution noiseMajor = new NormalDistribution(6.5, 1.5);
            NormalDistribution noiseMinor = new NormalDistribution(2.5, 2.3);

            double totalPop = 0;
            //iterate through each item, use major or minor bell curve depending
            //  on what they were randomly assigned to be.
            for(int i = 0; i < raceCount; ++i){
                if(Arrays.asList(majors).contains(i)){
                    racePop[i] = Double.valueOf(dFormat.format(noiseMajor.sample()));
                } else{
                    racePop[i] = Double.valueOf(dFormat.format(noiseMinor.sample()));
                }
                //no negative populations
                if (racePop[i] < 0.0){
                    racePop[i] = 0.0;
                }
                //count population as a total, use as the bottom of a fraction later
                totalPop += racePop[i];
            }
            //turn racePop into percentages by getting the ratio compared to totalPop, multiply by 100.0
            for(int i = 0; i< raceCount; ++i){
                racePop[i] /= totalPop;
                racePop[i] *= 100.0;
                racePop[i] = Double.valueOf(dFormat.format(racePop[i]));
            }

            p.racePopDistribution = racePop;
            p.populationDensity = Double.valueOf(dFormat.format(noise10.sample()));
            p.globalistCulture = Double.valueOf(dFormat.format(noise10.sample()));
            p.galacticCulture = Double.valueOf(dFormat.format(noise10.sample()));

            p.parentStar = this;

            p.printVals(currentPlanet);
            System.out.println("\n");
        }
        System.out.println("________________________________________________________________\n\n");
    }


}
