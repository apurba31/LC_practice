package com.dsa.practice.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class ReconstructItinerary {
/**
 * Brute Force Approach:
 * 1. Generate all possible itineraries using backtracking.
 * 2. Sort the itineraries lexicographically and return the first one.
 * Time Complexity: O(E! * E) where E is the number of tickets (edges).
 * Space Complexity: O(E) for storing the itinerary.
 * Optimized Approach:
 * 1. Use a graph (adjacency list) to represent the tickets.
 * 2. Perform a depth-first search (DFS) to find the itinerary, ensuring to visit the smallest lexical airport first.
 * 3. Use a linked list to store the itinerary in reverse order as we backtrack.
 * Time Complexity: O(E log E) for sorting the adjacency list and O(E) for DFS, resulting in O(E log E).
 * Space Complexity: O(E) for the graph and O(E) for the recursion stack in
 */
 public List<String> findItinerary(List<List<String>> tickets){
    // Create a map to store the list of destinations for each departure airport
    Map<String, List<String>> graph = new HashMap<>();
    for (List<String> ticket : tickets) {
        String from = ticket.get(0);
        String to = ticket.get(1);
        graph.computeIfAbsent(from, k -> new ArrayList<>()).add(to);
    }

    // Sort the destinations for each departure airport in lexicographical order
    for ( List<String> destinations : graph.values()) {
        destinations.sort(String::compareTo);
    }

    // Start the itinerary from "JFK"
    LinkedList<String> itinerary = new LinkedList<>();
    dfs("JFK", graph, itinerary);
    return itinerary;
 }

 private void dfs(String airport, Map<String, List<String>> graph, LinkedList<String> itinerary) {
    List<String> destinations = graph.get(airport);
    while( destinations != null && !destinations.isEmpty()) {
        // Remove the next destination from the list to avoid revisiting
        String next = destinations.remove(0);
        dfs(next, graph, itinerary);
    }
    // Add the airport to the itinerary after visiting all its destinations
    itinerary.addFirst(airport);
 }

 public static void main(String[] args) {
    ReconstructItinerary solution = new ReconstructItinerary();
    List<List<String>> tickets = List.of(
        List.of("MUC", "LHR"),
        List.of("JFK", "MUC"),
        List.of("SFO", "SJC"),
        List.of("LHR", "SFO")
    );
    List<String> itinerary = solution.findItinerary(tickets);
    System.out.println(itinerary); // Output: [JFK, MUC, LHR, SFO, SJC]
 }
}
