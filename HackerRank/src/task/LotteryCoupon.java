package task;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;



class Result {

    /*
     * Complete the 'lotteryCoupons' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER n as parameter.
     */

    public static int lotteryCoupons(int n) {
    	     HashMap<Integer, Integer> resultMap = new HashMap<Integer, Integer>();
             int i=1;
             for(i=1;i<=n;i++) {
            	 int j= i;
            	 int sum = 0,m;
            	 while(j > 0)
                 {
                     m = j % 10;
                     sum = sum + m;
                     j = j / 10;
                 }
            	 Integer existingCount = resultMap.get(sum);
            	 if(existingCount != null) {
            		 existingCount = existingCount+1;
            	 }else {
            		 existingCount = 1;
            	 }
            	 resultMap.put(sum, existingCount);
             }
             System.out.println(resultMap);

             Integer key = resultMap.entrySet().stream().max((entry1, entry2) -> entry1.getValue() > entry2.getValue() ? 1 : -1).get().getKey();
             Integer maxValue = resultMap.get(key);
             Set<Integer> collect = resultMap.entrySet().stream().filter(entry -> Objects.equals(entry.getValue(), maxValue)).map(Map.Entry::getKey).collect(Collectors.toSet());
             
          return collect.size();
    }

}

public class LotteryCoupon {
    public static void main(String[] args) throws IOException {
    	int lotteryCoupons = Result.lotteryCoupons(22);
    	System.out.println(lotteryCoupons);
    }
}
