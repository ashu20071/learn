package GeekTrust.TameOfThrones;

import java.io.*;
import java.util.*;
import java.util.concurrent.*;

/**
 * Driver class to get input from text file as argument and based on input, build the message object.
 * Print the output to console after deciphering the input secret messages to kingdoms.
 */

public class Geektrust {
    public static MessageObject buildObject(String message) {
        message = message.toUpperCase();
        String[] messageComponent = message.split(" ", 2);
        String kingdomName = messageComponent[0];
        KingdomSymbols kingdomSymbols = KingdomSymbols.valueOf(messageComponent[0]);
        if (messageComponent.length < 2 || messageComponent[1].isBlank())
            throw new IllegalArgumentException("No message found");
        List<Integer> secretMessage = new ArrayList<>();
        // Store ascii values of char in secret message
        for (int count = 0; count < messageComponent[1].length(); count++)
            secretMessage.add((int) messageComponent[1].charAt(count));
        return new MessageObject(kingdomName, kingdomSymbols.getKingdomSymbol(), secretMessage);
    }

    public static String driver(String filePath) throws IOException, InterruptedException, ExecutionException {
        File file = new File(filePath);
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        DecipherMessage decipherMessage = new DecipherMessage();
        Set<String> allies = new HashSet<>();
        int minAlliesRequired = 3;
        String output = "";
        String message;
        List<Callable<String>> tasks = new ArrayList<>();
        // Iterate through input stream in input file; build message object and send each object to decipher
        while ((message = bufferedReader.readLine()) != null) {
            String finalMessage = message;
            Callable<String> callable = new Callable<>() {
                @Override
                public String call() {
                    MessageObject messageObject = buildObject(finalMessage);
                    return decipherMessage.decipher(messageObject);
                }
            };
            tasks.add(callable);
        }
        // Parallel processing
        ExecutorService executorService = Executors.newCachedThreadPool();
        try {
            List<Future<String>> results = executorService.invokeAll(tasks);
            for (Future<String> futureResult : results) {
                if (!futureResult.get().isEmpty()) {
                    allies.add(futureResult.get());
                    output = output.concat(" " + futureResult.get());
                }
            }
        }
        finally {
            executorService.shutdown();
        }
        // If allegiance counter less than 3; set output to NONE
        output = (allies.size() < minAlliesRequired) ? "NONE" : "SPACE" + output;
        return output;
    }

    public static void main(String[] args) throws IOException, InterruptedException, ExecutionException {
        String filePath = args[0];
//        long start = System.nanoTime();
        System.out.println(driver(filePath));
//        long end = System.nanoTime();
//        long execution = end - start;
//        System.out.println("Execution time: " + execution + " nanoseconds");
    }

}