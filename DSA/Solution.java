
public class Solution {
	public int solution(int[] A) {
		//O(n^2)
//		int n = A.length;
//		
//		for (int q = 0; q < n; q++) {
//			boolean isPole =  true;
//			
//			for (int p = 0; p < q; p++) {
//				if (A[p] > A[q]) {
//					isPole = false;
//					break;
//				}
//			}
//			if (isPole) {
//				for (int r = q + 1; r < n; r++) {
//					if (A[r] < A[q]) {
//						isPole = false;
//						break;
//					}
//				}
//			}
//			if (isPole) {
//				return q;
//			}
//		}
//		return -1;
//	}
		int candidate = -1;
		int valueMax = Integer.MIN_VALUE;
		
		for (int i =0; i < A.length; i++) {
			if (candidate == -1) {
				if (A[i] >= valueMax) {
					candidate = i;
				}
			} else if (A[i] < A[candidate]) {
				candidate = -1;
			}
			valueMax = Math.max(valueMax,A[i]);
		}
		return candidate;
	}
	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.solution(new int[]{4, 2, 2, 3, 1, 4, 7, 8, 6, 9}));
		System.out.println(s.solution(new int[] {3,2,4,1,4,6,1,3,5,6}));
	}

}
