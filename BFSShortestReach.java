package com.kkd.ds;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/bfsshortreach/problem
 * Ref - Robert Lafore
 * @author ssingh
 *
 */
public class BFSShortestReach {

	class Vertex {
		int data;
		boolean wasVisited;

		public Vertex(int data) {
			this.data = data;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			return true;
		}

		@Override
		public String toString() {
			return "data=" + data + ", wasVisited=" + wasVisited;
		}

	}

	class Graph {
		private int adjMtx[][];
		private Vertex vtxList[];
		private int nVtx;
		private int[] shortestPath;
		private Queue<Vertex> queue = new ArrayDeque<>();

		Graph(int nVtx) {
			this.nVtx = nVtx;

			adjMtx = new int[nVtx][nVtx];
			vtxList = new Vertex[nVtx];
			shortestPath = new int[nVtx];

			for (int i = 0; i < nVtx; i++) {
				for (int j = 0; j < nVtx; j++) {
					adjMtx[i][j] = -1;
				}
				shortestPath[i] = -1;
			}
		}

		public void addEdge(int start, int end) {
			adjMtx[start - 1][end - 1] = 6;
			adjMtx[end - 1][start - 1] = 6;
		}

		public void addVtx(int data) {
			vtxList[data - 1] = new Vertex(data);
		}

		public int[] bfs(int start) {

			Vertex curr = vtxList[start - 1];
			if (curr != null) {
				curr.wasVisited = true;
				queue.add(curr);

				Vertex v;
				while (!queue.isEmpty()) {
					Vertex u = queue.remove();
					int uPath = shortestPath[u.data - 1];
					if (uPath == -1) {
						uPath = 0;
					}
					while ((v = getUnvisitedAdjVtx(u)) != null) {
						v.wasVisited = true;
						queue.add(v);
						shortestPath[v.data - 1] = 6 + uPath;
					}
				}
			}
			return shortestPath;
		}

		private Vertex getUnvisitedAdjVtx(Vertex u) {
			for (int i = 0; i < nVtx; i++) {
				if (adjMtx[u.data - 1][i] == 6 && !vtxList[i].wasVisited) {
					return vtxList[i];
				}
			}

			return null;
		}
	}

	public static void main(String[] args) {

		BFSShortestReach shortestReachDijsktra = new BFSShortestReach();

		try (Scanner sc = new Scanner(System.in)) {
			int q = sc.nextInt();
			while (q != 0) {
				int nVtx = sc.nextInt();
				int nEdg = sc.nextInt();
				Graph graph = shortestReachDijsktra.new Graph(nVtx);

				while (nEdg != 0) {
					int start = sc.nextInt();
					int end = sc.nextInt();
					graph.addEdge(start, end);
					graph.addVtx(start);
					graph.addVtx(end);

					nEdg--;
				}

				int start = sc.nextInt();
				int[] sp = graph.bfs(start);
				for (int i = 0; i <= sp.length - 1; i++) {
					if (i != start - 1) {
						System.out.print(sp[i] + " ");
					}
				}
				q--;
				System.out.println();
			}
		}
	}

}
