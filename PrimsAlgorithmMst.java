package com.kkd.ds;

import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Set;

/**
 * https://www.hackerrank.com/challenges/primsmstsub/problem
 *
 */
public class PrimsAlgorithmMst {

	class Vertex {
		int data;
		boolean isIncluded;

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
			return "data=" + data + ", isIncluded=" + isIncluded;
		}

	}

	class Key {
		int nextVtx;
		int edge;

		public Key(int nextVtx, int edge) {
			this.edge = edge;
			this.nextVtx = nextVtx;
		}

		@Override
		public String toString() {
			return "nextVtx=" + nextVtx + ", edge=" + edge;
		}
	}

	class Graph {

		int nVerts;
		int adjMtx[][];
		Vertex vtxSet[];
		Set<Vertex> mstSet = new HashSet<>();
		PriorityQueue<Key> keys = new PriorityQueue<>(new Comparator<Key>() {

			@Override
			public int compare(Key o1, Key o2) {
				if (o1.edge < o2.edge)
					return -1;
				else if (o1.edge > o2.edge)
					return 1;
				else
					return 0;
			}
		});

		public Graph(int nVerts) {
			this.nVerts = nVerts;
			adjMtx = new int[nVerts][nVerts];
			vtxSet = new Vertex[nVerts];

			for (int i = 0; i < nVerts; i++) {
				for (int j = 0; j < nVerts; j++) {
					// initialize to -1 since edges can also b 0
					adjMtx[i][j] = -1;
				}
			}
		}

		public void addEdge(int start, int end, int wt) {
			adjMtx[start - 1][end - 1] = wt;
			adjMtx[end - 1][start - 1] = wt;
		}

		public void addVtx(int d) {
			vtxSet[d - 1] = new Vertex(d);
		}

		private Key getMin(int data) {
			for (int i = 0; i < nVerts; i++) {
				if (adjMtx[data - 1][i] >= 0 && !vtxSet[i].isIncluded) {
					keys.add(new Key(i + 1, adjMtx[data - 1][i]));
				}
			}
			return keys.poll();
		}

		public int primsMst(int d) {
			Vertex start = vtxSet[d - 1];
			start.isIncluded = true;
			mstSet.add(start);

			int sum = 0;
			while (mstSet.size() != nVerts) {
				Key minKey = getMin(start.data);
				Vertex nextVtx = vtxSet[minKey.nextVtx - 1];
				if (!nextVtx.isIncluded) {
					nextVtx.isIncluded = true;
					mstSet.add(nextVtx);
					sum = sum + minKey.edge;
				}

				start = nextVtx;
			}
			return sum;
		}
	}

	public static void main(String[] args) {
		PrimsAlgorithmMst prim = new PrimsAlgorithmMst();

		try (Scanner sc = new Scanner(System.in)) {
			int nVtx = sc.nextInt();
			int nEdge = sc.nextInt();

			Graph graph = prim.new Graph(nVtx);

			while (nEdge != 0) {
				int u = sc.nextInt();
				int v = sc.nextInt();
				int wt = sc.nextInt();

				graph.addEdge(u, v, wt);
				graph.addEdge(v, u, wt);

				graph.addVtx(u);
				graph.addVtx(v);

				nEdge--;
			}

			int start = sc.nextInt();

			System.out.println(graph.primsMst(start));
		}
	}
}
