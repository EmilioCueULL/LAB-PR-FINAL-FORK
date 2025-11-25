package es.edu.ull.esit;

import es.edu.ull.esit.algorithm.AstarAlgorithm;
import es.edu.ull.esit.algorithm.BfsAlgorithm;
import es.edu.ull.esit.algorithm.BidirectionalSearchAlgorithm;
import es.edu.ull.esit.algorithm.DfsAlgorithm;
import es.edu.ull.esit.algorithm.DijkstraAlgorithm;
import es.edu.ull.esit.algorithm.GreedyBestFirstAlgorithm;
import es.edu.ull.esit.algorithm.SearchAlgorithm;

/**
 * Context class for pathfinding algorithms using the Strategy pattern.
 * Supports DFS, BFS, A*, Dijkstra, Greedy Best-First Search, and Bidirectional Search.
 * Each algorithm is implemented as a separate strategy class.
 */
public class Algorithm {
	
	private int searchtime = 100;
	
	// Strategy instances for each algorithm
	private final SearchAlgorithm dfsAlgorithm = new DfsAlgorithm();
	private final SearchAlgorithm bfsAlgorithm = new BfsAlgorithm();
	private final SearchAlgorithm astarAlgorithm = new AstarAlgorithm();
	private final SearchAlgorithm dijkstraAlgorithm = new DijkstraAlgorithm();
	private final SearchAlgorithm greedyBestFirstAlgorithm = new GreedyBestFirstAlgorithm();
	private final SearchAlgorithm bidirectionalSearchAlgorithm = new BidirectionalSearchAlgorithm();
	
	/**
	 * Gets the current search time delay in milliseconds.
	 * 
	 * @return The search time in milliseconds
	 */
	public int getSearchTime() {
		return searchtime;
	}
	
	/**
	 * Sets the search time delay for visualization.
	 * Controls the speed of the search animation.
	 * 
	 * @param searchtime The search time in milliseconds
	 */
	public void setSearchTime(int searchtime) {
		this.searchtime = searchtime;
	}

	/**
	 * Performs a Depth-First Search (DFS) to find a path from start to end.
	 * Uses a stack to explore as far as possible along each branch before backtracking.
	 * 
	 * @param start The starting node
	 * @param end The target/end node
	 * @param graphWidth The width of the grid
	 * @param graphHeight The height of the grid
	 */
	public void dfs(Node start, Node end, int graphWidth, int graphHeight) {
		dfsAlgorithm.search(start, end, graphWidth, graphHeight, searchtime);
	}

	/**
	 * Performs a Breadth-First Search (BFS) to find the shortest path from start to end.
	 * Uses a queue to explore all neighbors at the current depth before moving to the next level.
	 * 
	 * @param start The starting node
	 * @param end The target/end node
	 * @param graphWidth The width of the grid
	 * @param graphHeight The height of the grid
	 */
	public void bfs(Node start, Node end, int graphWidth, int graphHeight) {
		bfsAlgorithm.search(start, end, graphWidth, graphHeight, searchtime);
	}

	/**
	 * Performs an A* search to find the optimal path from start to end.
	 * Combines actual distance from start (g-cost) with estimated distance to end (h-cost).
	 * 
	 * @param start The starting node
	 * @param targetNode The target/end node
	 * @param graphWidth The width of the grid
	 * @param graphHeight The height of the grid
	 */
	public void Astar(Node start, Node targetNode, int graphWidth, int graphHeight) {
		astarAlgorithm.search(start, targetNode, graphWidth, graphHeight, searchtime);
	}

	/**
	 * Performs Dijkstra's algorithm to find the shortest path from start to end.
	 * Guarantees the shortest path by exploring nodes in order of their distance from start.
	 * 
	 * @param start The starting node
	 * @param end The target/end node
	 * @param graphWidth The width of the grid
	 * @param graphHeight The height of the grid
	 */
	public void dijkstra(Node start, Node end, int graphWidth, int graphHeight) {
		dijkstraAlgorithm.search(start, end, graphWidth, graphHeight, searchtime);
	}

	/**
	 * Performs a Greedy Best-First Search to find a path from start to end.
	 * Prioritizes nodes that appear to be closer to the goal based on heuristic.
	 * May not find the optimal path but is fast.
	 * 
	 * @param start The starting node
	 * @param end The target/end node
	 * @param graphWidth The width of the grid
	 * @param graphHeight The height of the grid
	 */
	public void greedyBestFirstSearch(Node start, Node end, int graphWidth, int graphHeight) {
		greedyBestFirstAlgorithm.search(start, end, graphWidth, graphHeight, searchtime);
	}

	/**
	 * Performs a Bidirectional Search to find a path from start to end.
	 * Searches from both start and end simultaneously until the searches meet.
	 * More efficient than unidirectional search for finding paths.
	 * 
	 * @param start The starting node
	 * @param end The target/end node
	 * @param graphWidth The width of the grid
	 * @param graphHeight The height of the grid
	 */
	public void bidirectionalSearch(Node start, Node end, int graphWidth, int graphHeight) {
		bidirectionalSearchAlgorithm.search(start, end, graphWidth, graphHeight, searchtime);
	}
}
