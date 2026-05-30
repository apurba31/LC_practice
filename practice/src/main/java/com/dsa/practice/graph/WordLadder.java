package com.dsa.practice.graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class WordLadder {
/**
 * Brute Force Approach: O(N * M^2) time and O(N) space
 * 1. For each word in the dictionary, perform a Depth-First Search (DFS
 * ) to find the shortest path from the start word to the end word.
 * 2. During the DFS, generate all possible one-letter transformations of
 * the current word and check if they are in the dictionary.
 * 3. Keep track of the visited words to avoid cycles and update the
 * shortest path length when the end word is reached.
 * Optimized Approach using Breadth-First Search (BFS): O(N * M^
 * 2) time and O(N) space
 * 1. Use a queue to perform a breadth-first search (BFS) starting from
 * the start word.
 * 2. Enqueue the start word and mark it as visited.
 * 3. For each word dequeued, generate all possible one-letter transformations
 * and check if they are in the dictionary.
 * 4. If a transformation is the end word, return the current path length + 1.
 * 5. If a transformation is in the dictionary and not visited, enqueue it and mark
 * it as visited.
 * Time Complexity: O(N * M^2) where N is the number of words in
 * the dictionary and M is the length of the longest word. This is because for each word, we generate M possible transformations, and checking if a transformation is in the dictionary takes O(M) time.
 * Space Complexity: O(N) for the queue and visited set in the worst case.
 */
record WordNode(String word, int level) {}

public int ladderLength(String beginWord, String endWord, List<String> wordList) {
    //Since all words are of same length
    int L = beginWord.length();

    //Dictionary of word to hold all combinations of words that
    // can be formed by changing one letter at a time
    Map<String, List<String>> allComboDict = new HashMap<>();
    
    wordList.forEach( word -> {
        for(int i = 0; i < L; i++) {
            // Key is generic word
            // Value is a list of words which have the same intermediate
            // generic word.
            String newWord = word.substring(0, i) + '*' 
                            + word.substring(i + 1, L);
            List<String> transformations = allComboDict
            .getOrDefault(newWord, new ArrayList<>());
            transformations.add(word);
            allComboDict.put(newWord, transformations);
        }
    });

    //Queue for BFS
    Queue<WordNode> queue = new ArrayDeque<>();
    queue.offer(new WordNode(beginWord, 1));

    Set<String> visited = new HashSet<>();
    visited.add(beginWord);

    while(!queue.isEmpty()) {
        WordNode node = queue.poll();
        String word = node.word();
        int level = node.level();

        for(int i = 0; i < L; i++) {
            String pattern = 
            word.substring(0, i)
            + '*'
            + word.substring(i + 1, L);

            List<String> neighbors = 
            allComboDict.getOrDefault(pattern, new ArrayList<>());
            for (String adjacentWord : neighbors) {
                if (adjacentWord.equals(endWord)) {
                    return level + 1;
                }
                // Otherwise, add it to the BFS Queue. Also mark it visited
                if (!visited.contains(adjacentWord)) {
                    visited.add(adjacentWord);
                        queue.offer(new WordNode(adjacentWord, level + 1));
                    }
                }
        }
    }
    return 0;
}
public static void main(String[] args) {
    WordLadder solution = new WordLadder();
    String beginWord = "hit";
    String endWord = "cog";
    List<String> wordList = List.of("hot", "dot", "dog", "lot", "log", "cog");

    int result = solution.ladderLength(beginWord, endWord, wordList);
    System.out.println("Length of shortest transformation sequence: " + result);
}
}
