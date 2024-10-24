import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;

public class Proj2 {
    public static void main(String[] args) throws IOException {
        // Use command line arguments to specify the input file
        if (args.length != 2) {
            System.err.println("Usage: java TestAvl <input file> <number of lines>");
            System.exit(1);
        }

        String inputFileName = args[0]; //Health_Sleep_Statistics.csv
        int numLines = Integer.parseInt(args[1]); //101 lines in csv file

        // For file input
        FileInputStream inputFileNameStream = null;
        Scanner inputFileNameScanner = null;

        // Open the input file
        inputFileNameStream = new FileInputStream(inputFileName);
        inputFileNameScanner = new Scanner(inputFileNameStream);

        // ignore first line
        inputFileNameScanner.nextLine();

        //ArrayList to store the Sleep data
        ArrayList<SleepData> sleepDataArrayList = new ArrayList<SleepData>();

        // Read the file line by line
        while (inputFileNameScanner.hasNext() && sleepDataArrayList.size() < numLines) {
            String line = inputFileNameScanner.nextLine();
            String[] parts = line.split(","); // split the string into multiple parts


            //User ID, Age, Gender, Sleep Quality, Bedtime, Wake-up Time, Daily Steps, Calories Burned, Physical Activity, Dietary Habits, Sleep Disorders, Medication Usage
            // New sleep data object
            SleepData data = new SleepData(
                    Integer.parseInt(parts[0]),
                    Integer.parseInt(parts[1]),
                    parts[2],
                    Integer.parseInt(parts[3]),
                    parts[4],
                    parts[5],
                    Integer.parseInt(parts[6]),
                    Integer.parseInt(parts[7]),
                    parts[8],
                    parts[9],
                    parts[10],
                    parts[11]
            );

                sleepDataArrayList.add(data); // add the data onto the ArrayList
        }
        inputFileNameStream.close(); // because I care

        Collections.sort(sleepDataArrayList); //sort data

        BST<SleepData> bstSorted = new BST<>(); //new bst object
        AvlTree<SleepData> avlTreeSorted = new AvlTree<>(); //new avl tree object

        // 4 insertions...
        long AvlTreeSortedInsertTime = System.nanoTime();
        for (SleepData data : sleepDataArrayList) {//sorted insert into avl tree and bst
            avlTreeSorted.insert(data); // 1
        }
        AvlTreeSortedInsertTime = System.nanoTime() - AvlTreeSortedInsertTime; // time of sorted avl tree insertions

        long BstSortedInsertTime = System.nanoTime();
        for (SleepData data : sleepDataArrayList) {
            bstSorted.insert(data); // 2
        }
        BstSortedInsertTime = System.nanoTime() - BstSortedInsertTime; // time of sorted bst insertions

        ArrayList<SleepData> sleepDataArrayListShuffled = new ArrayList<>(sleepDataArrayList); // new arraylist for shuffled
        Collections.shuffle(sleepDataArrayListShuffled); //shuffle data


        BST<SleepData> bstShuffled = new BST<>();
        AvlTree<SleepData> avlTreeShuffled = new AvlTree<>();

        long AvlTreeShuffledInsertTime = System.nanoTime();
        for (SleepData data : sleepDataArrayListShuffled) {//shuffled insert into avl tree and bst
            avlTreeShuffled.insert(data); // 3
        }
        AvlTreeShuffledInsertTime = System.nanoTime() - AvlTreeShuffledInsertTime; // time of avl tree shuffled insertions

        long bstShuffledInsertTime = System.nanoTime();
        for (SleepData data : sleepDataArrayListShuffled) {
            bstShuffled.insert(data); //4
        }
        bstShuffledInsertTime = System.nanoTime() - bstShuffledInsertTime; // time of bst shuffled insertions

        //4 searches for data from original sleep data array list

        long bstSortedSearchTime = System.nanoTime();
        for (SleepData data : sleepDataArrayList) { // 1: sorted bst search
            if ( bstSorted.find(data) != null )
                System.out.println("Found: " + data);
            else
                System.out.println("Not found: " + bstSorted.find(data));
        }
        bstSortedSearchTime = System.nanoTime() - bstSortedSearchTime; // time of bst sorted searches

        long bstShuffledSearchTime = System.nanoTime();
        for (SleepData data : sleepDataArrayList) { // 2: shuffled bst search
            if ( bstShuffled.find(data) != null )
                System.out.println("Found: " + data);
            else
                System.out.println("Not found: " + data);
        }
        bstShuffledSearchTime = System.nanoTime() - bstShuffledSearchTime; //time of bst shuffled searches

        long AvlTreeSortedSearchTime = System.nanoTime();
        for (SleepData data : sleepDataArrayList) { // 3: sorted avl tree search
            if ( avlTreeSorted.contains(data) )
                System.out.println("Found: " + data);
            else
                System.out.println("Not found: " + data);
        }
        AvlTreeSortedSearchTime = System.nanoTime() - AvlTreeSortedSearchTime; // time of avl tree sorted searches

        long AvlTreeShuffledSearchTime = System.nanoTime();
        for (SleepData data : sleepDataArrayList) { // 4: shuffled avl tree search
            if ( avlTreeShuffled.contains(data) )
                System.out.println("Found: " + data);
            else
                System.out.println("Not found: " + data);
        }
        AvlTreeShuffledSearchTime = System.nanoTime() - AvlTreeShuffledSearchTime; // time of avl tree shuffled searches

        //Printing results
        System.out.println("Number of lines: " + sleepDataArrayList.size());
        System.out.println("AVL Tree Sorted Insert Running Time: " + AvlTreeSortedInsertTime + " nanoseconds.");
        System.out.println("AVL Tree Shuffled Insert Running Time: " + AvlTreeShuffledInsertTime + " nanoseconds.");
        System.out.println("BST Sorted Insert Running Time: " + BstSortedInsertTime + " nanoseconds.");
        System.out.println("BST Shuffled Insert Running Time: " + bstShuffledInsertTime + " nanoseconds.");
        System.out.println("AVL Tree Sorted Search Running Time: " + AvlTreeSortedSearchTime + " nanoseconds.");
        System.out.println("AVL Tree Shuffled Search Running Time: " + AvlTreeShuffledSearchTime + " nanoseconds.");
        System.out.println("BST Sorted Search Running Time: " + bstSortedSearchTime + " nanoseconds.");
        System.out.println("BST Shuffled Search Running Time: " + bstShuffledSearchTime + " nanoseconds.");

        try (PrintWriter pw = new PrintWriter(new FileOutputStream("output.txt", true))) {
            pw.append("Number of lines: " + sleepDataArrayList.size());
            pw.append("AVL Tree Sorted Insert Running Time: " + AvlTreeSortedInsertTime + " nanoseconds.");
            pw.append("AVL Tree Shuffled Insert Running Time: " + AvlTreeShuffledInsertTime + " nanoseconds.");
            pw.append("BST Sorted Insert Running Time: " + BstSortedInsertTime + " nanoseconds.");
            pw.append("BST Shuffled Insert Running Time: " + bstShuffledInsertTime + " nanoseconds.");
            pw.append("AVL Tree Sorted Search Running Time: " + AvlTreeSortedSearchTime + " nanoseconds.");
            pw.append("AVL Tree Shuffled Search Running Time: " + AvlTreeShuffledSearchTime + " nanoseconds.");
            pw.append("BST Sorted Search Running Time: " + bstSortedSearchTime + " nanoseconds.");
            pw.append("BST Shuffled Search Running Time: " + bstShuffledSearchTime + " nanoseconds.");
        }
        catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }
}
