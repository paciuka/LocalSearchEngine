import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        InvertedIndex myIndex = new InvertedIndex();
        List<String> allTxtFiles = new ArrayList<>();

        System.out.println("Starting full computer scan...");
        System.out.println("WARNING: This may take a lot of time (5-20 minutes)!\n");

        File[] drives = File.listRoots();
        if (drives != null) {
            for (File drive : drives) {
                System.out.println("Scanning drive: " + drive.getAbsolutePath() + "...");
                List<String> filesOnDrive = FileCrawler.findTextFiles(drive.getAbsolutePath());
                allTxtFiles.addAll(filesOnDrive);
            }
        }

        System.out.println("\nFound " + allTxtFiles.size() + " text files.");
        System.out.println("Starting indexing (reading content). Please wait...\n");

        int count = 0;
        for (String filePath : allTxtFiles) {
            FileIndexer.indexFile(filePath, myIndex);
            count++;
            if (count % 1000 == 0) {
                System.out.println("Indexed " + count + " files out of " + allTxtFiles.size() + "...");
            }
        }

        System.out.println("\n--- Indexing completely finished! ---\n");

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Enter a word to search (or type 'exit' to quit): ");
            String searchWord = scanner.nextLine().trim();

            if (searchWord.equalsIgnoreCase("exit")) {
                System.out.println("Process terminated. Goodbye!");
                break;
            }

            if (searchWord.isEmpty()) {
                continue;
            }

            Set<String> results = myIndex.search(searchWord);

            if (results.isEmpty()) {
                System.out.println("Word '" + searchWord + "' not found on the computer :(\n");
            } else {
                System.out.println("Word '" + searchWord + "' found in " + results.size() + " files:");

                int printCount = 0;
                for (String path : results) {
                    System.out.println("- " + path);
                    printCount++;
                    if (printCount >= 20) {
                        System.out.println("...and " + (results.size() - 20) + " more files. (Showing top 20)");
                        break;
                    }
                }
                System.out.println();
            }
        }

        scanner.close();
    }
}