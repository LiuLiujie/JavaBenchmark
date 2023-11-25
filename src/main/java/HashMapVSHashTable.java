import java.util.HashMap;
import java.util.Hashtable;
import java.util.UUID;

public class HashMapVSHashTable {

    public void benchmarkInsertionSpeed(int problemSize) {

        //Generate keys and values
        String[] keys = new String[problemSize];
        String[] values = new String[problemSize];
        for (int i=0; i < problemSize; i++) {
            keys[i] = UUID.randomUUID().toString().replace("-", "").toLowerCase();
            values[i] = UUID.randomUUID().toString().replace("-", "").toLowerCase();
        }
        HashMap<String, String> map = new HashMap<>();
        Hashtable<String, String> table = new Hashtable<>();

        long start, end;

        start = System.currentTimeMillis();
        for (int i=0; i < problemSize; i++){
            map.put(keys[i], values[i]);
        }

        end = System.currentTimeMillis();

        System.out.println("HashMap takes "+(end - start) + " milliseconds to insert "+ problemSize + " elements");

        //Re-generate the code to avoid CPU register optimization.
        for (int i=0; i < problemSize; i++) {
            keys[i] = UUID.randomUUID().toString().replace("-", "").toLowerCase();
            values[i] = UUID.randomUUID().toString().replace("-", "").toLowerCase();
        }

        start = System.currentTimeMillis();
        for (int i=0; i < problemSize; i++){
            table.put(keys[i], values[i]);
        }
        end = System.currentTimeMillis();

        System.out.println("HashTable takes "+(end - start) + " milliseconds to insert "+ problemSize + " elements");
    }

    public static void main(String[] args) {
        HashMapVSHashTable benchmark = new HashMapVSHashTable();
        benchmark.benchmarkInsertionSpeed(1<<22);
    }
}
