import org.apache.commons.math3.distribution.NormalDistribution;

public class Galaxy {
    Star[] stars;
    //will be used to organize, and have stars do things like look for their nearby neighbors and stuff.

    public Galaxy(int num){
        stars = new Star[num];
        NormalDistribution noise3 = new NormalDistribution(5.0, 1.5);
        for (int i = 0; i < num; ++i){
            stars[i] = new Star((int)noise3.sample(), i+1);
        }
    }

}
