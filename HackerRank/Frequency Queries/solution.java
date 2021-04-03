import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the freqQuery function below.
    static List<Integer> freqQuery(List<List<Integer>> queries) {
        List<Integer> output = new ArrayList<Integer>();
        
        //      num         freq
        HashMap<Integer, Integer> cntMap = new HashMap<>();
        
        
        for(int i = 0; i < queries.size(); i++){
            int command = queries.get(i).get(0),
                value = queries.get(i).get(1);
            if(command == 1){
                if(!cntMap.containsKey(value)){
                    cntMap.put(value, 0);
                }               
                cntMap.put(value, cntMap.get(value) + 1);
            }else if(command == 2){
                if(cntMap.containsKey(value) && cntMap.get(value) <= 0){
                    continue;
                }
                if(cntMap.containsKey(value))
                    cntMap.put(value, cntMap.get(value) - 1);
            }else if(command == 3){
                boolean inside = false;
                for(Integer num: cntMap.keySet()){
                    int freq = cntMap.get(num);
                    if(freq == value){
                        inside = true;
                        output.add(1);
                        break;
                    }
                }
                if(!inside){
                    output.add(0);
                }
            }
        }
        return output;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<Integer>> queries = new ArrayList<>();

        for (int i = 0; i < q; i++) {
            String[] queriesRowTempItems = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

            List<Integer> queriesRowItems = new ArrayList<>();

            for (int j = 0; j < 2; j++) {
                int queriesItem = Integer.parseInt(queriesRowTempItems[j]);
                queriesRowItems.add(queriesItem);
            }

            queries.add(queriesRowItems);
        }

        List<Integer> ans = freqQuery(queries);

        for (int i = 0; i < ans.size(); i++) {
            bufferedWriter.write(String.valueOf(ans.get(i)));

            if (i != ans.size() - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
