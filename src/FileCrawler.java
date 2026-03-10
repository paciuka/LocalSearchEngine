import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class FileCrawler {
    public static List<String> findTextFiles(String rootDirPath) {
        List<String> txtFiles = new ArrayList<>();
        File rootDir = new File(rootDirPath);

        if (!rootDir.exists() || !rootDir.isDirectory()) {
            System.out.println("Error: Invalid directory path!");
            return txtFiles;
        }

        Stack<File> stack = new Stack<>();
        stack.push(rootDir);

        while (!stack.isEmpty()) {
            File current = stack.pop();
            File[] filesAndDirs = current.listFiles();

            if (filesAndDirs != null) {
                for (File item : filesAndDirs) {
                    if (item.isDirectory()) {
                        stack.push(item);
                    } else if (item.isFile() && item.getName().endsWith(".txt")) {
                        txtFiles.add(item.getAbsolutePath());
                    }
                }
            }
        }
        return txtFiles;
    }
}