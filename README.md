# Local Search Engine 🔍

A fast, lightweight, and purely Java-based local file search engine built from scratch. This project was developed as a hands-on implementation of core **Data Structures and Algorithms (DSA)** to demonstrate how they solve real-world performance challenges.

The engine scans your computer for text files, builds an in-memory inverted index, and allows you to perform instantaneous word searches across all indexed documents.

##  Features

* **Recursive Directory Crawling:** Automatically traverses your file system to locate all `.txt` files.
* **Text Normalization & Tokenization:** Cleans and processes raw text (removes punctuation, converts to lowercase) using Regular Expressions.
* **Fast In-Memory Indexing:** Builds a dictionary mapping words to their file locations.
* **Instant Search:** Achieves $O(1)$ average time complexity for word lookups.

## Data Structures & Algorithms Used

This project heavily relies on fundamental DSA concepts:

* **Depth-First Search (DFS) & Stack (`java.util.Stack`):** Used in the `FileCrawler` to traverse the hierarchical directory tree of the computer. A Stack ensures we efficiently explore nested folders without relying on recursion limits.
* **Inverted Index (`HashMap<String, Set<String>>`):** The core of the search engine. Instead of scanning files upon every query, it maps each unique word (Key) to a `HashSet` of file paths (Value) where it appears.
* **Hash Sets (`java.util.HashSet`):** Used to store file paths to automatically prevent duplicate entries when a word appears multiple times in the same document.

##  Project Structure

* `Main.java` - The entry point that orchestrates the crawling, indexing, and interactive console search.
* `FileCrawler.java` - Handles the DFS traversal of the file system.
* `FileIndexer.java` - Reads files line by line (memory efficient) and passes content to the index.
* `Tokenizer.java` - Processes raw strings into clean, valid search tokens.
* `InvertedIndex.java` - The core data structure maintaining the mapping of words to documents.

## 💻 How to Run

1. Clone the repository:
   ```bash
   git clone [https://github.com/paciuka/LocalSearchEngine.git](https://github.com/paciuka/LocalSearchEngine.git)
