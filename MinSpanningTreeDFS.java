package com.kkd.ds;

import java.util.ArrayDeque;
import java.util.Deque;

public class MinSpanningTreeDFS {

	class Vertex {
		public char label;
		public boolean wasVisited;

		Vertex(char label) {
			this.label = label;
			wasVisited = false;
		}

		@Override
		public String toString() {
			return label + " ";
		}
		
		
	}

	class Graph {
		private int maxVerts = 20;
		private int adjMat[][] = new int[maxVerts][maxVerts];
		private Vertex verList[] = new Vertex[maxVerts];
		Deque<Integer> stack = new ArrayDeque<>();
		int nVerts = 0;

		Graph() {
			for (int i = 0; i < maxVerts; i++) {
				for (int j = 0; j < maxVerts; j++) {
					adjMat[i][j] = 0;
				}
			}
		}

		public void addVertex(char label) {
			verList[nVerts++] = new Vertex(label);
		}

		public void addEdge(int start, int end) {
			adjMat[start][end] = 1;
			adjMat[end][start] = 1;
		}

		public void mst() {
			verList[0].wasVisited = true;
			stack.add(0);

			while (!stack.isEmpty()) {
				int currVtx = stack.peekLast();
				int v = getNextUnvisitedAdjVtx(currVtx);
				if (v == -1) {
					// no unvisited neighbor found
					stack.pop();
				} else {
					verList[v].wasVisited = true;
					stack.add(v);
					displayVtx(currVtx);
					displayVtx(v);
					System.out.print(" ");
				}
			}
		}

		private void displayVtx(int v) {
			System.out.print(verList[v].label);
		}

		private int getNextUnvisitedAdjVtx(int currVtx) {
			for (int j = 0; j < nVerts; j++) {
				if (adjMat[currVtx][j] == 1 && !verList[j].wasVisited) {
					return j;
				}
			}
			return -1;
		}

	}

	public static void main(String[] args) {
		MinSpanningTreeDFS mst = new MinSpanningTreeDFS();
		Graph graph = mst.new Graph();
		graph.addVertex('A');
		graph.addVertex('B');
		graph.addVertex('C');
		graph.addVertex('D');
		graph.addVertex('E');
		
		graph.addEdge(0, 1); // AB
		graph.addEdge(0, 2); // AC
		graph.addEdge(0, 3); // AD
		graph.addEdge(0, 4); // AE
		graph.addEdge(1, 2); // BC
		graph.addEdge(1, 3); // BD
		graph.addEdge(1, 4); // BE
		graph.addEdge(2, 3); // CD
		graph.addEdge(2, 4); // CE
		graph.addEdge(3, 4); // DE
		
		System.out.print("Minimum spanning tree: ");
		System.out.println();
		graph.mst(); // minimum spanning tree
	}
}
