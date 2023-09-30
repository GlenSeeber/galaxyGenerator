import java.util.Arrays;
import org.apache.commons.math3.distribution.NormalDistribution;

public class TestApache {
    public static void main(String[] args){
        NormalDistribution myData = new NormalDistribution(5.0, 1.3);

        int[] counts = new int[10];

    
        for(int i = 0; i < 1000; ++i){
            try{
                counts[(int)myData.sample()] += 1;
            }catch (Exception e){
                ;
            }
        }
        System.out.println(Arrays.toString(counts));
    }
}