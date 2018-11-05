package ranges;

import java.util.ArrayList;
import java.util.Collections;

public class OverlappingRanges {

	/**
	 * Returns the smallest integer that is present in the maximum number of
	 * input ranges
	 * 
	 * @param startPoints
	 *            the list of starting points for the ranges
	 * @param endPoints
	 *            the list of end points for the ranges
	 * @return the smallest integer that is present in the maximum number of
	 *         ranges
	 * @throws NoOverlapException
	 *             when there is no overlap between any of the ranges
	 */
	public static Integer maxOverlapInt(ArrayList<Integer> startPoints,
			ArrayList<Integer> endPoints) throws NoOverlapException {

        int maxOverlaps = 0;
        int maxNum = 0;

        int overlaps;

        int a = Collections.min(startPoints);
        int b = Collections.max(endPoints);

        for (int i = a; i <= b; i++) {

            overlaps = numOverlaps(i, startPoints, endPoints);

            if (overlaps > maxOverlaps) {
                maxNum = i;
                maxOverlaps = overlaps;
            }

        }

        if (maxOverlaps == 0) {
            throw new NoOverlapException();
        }

		return maxNum;

	}

	private static Integer numOverlaps(int n, ArrayList<Integer> startPoints, ArrayList<Integer> endPoints) {

	    int count = 0;

	    for (int i = 0; i < startPoints.size(); i++) {
	        if (inRange(n, startPoints.get(i), endPoints.get(i))) {
	            count++;
            }
        }

        return count;

    }

    private static boolean inRange(int n, int a, int b) {
	    return ((n > a) && (n <= b)) || ((n >= a) && (n < b));
    }

}
