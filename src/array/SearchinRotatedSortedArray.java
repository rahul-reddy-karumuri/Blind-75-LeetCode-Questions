package array;

//https://leetcode.com/problems/search-in-rotated-sorted-array/
public class SearchinRotatedSortedArray {
	public int search(int[] nums, int target) {
		int left = 0, right = nums.length - 1;
		while (left <= right) {
			int mid = left + (right - left) / 2;
			if (nums[mid] == target)
				return mid;
			if (nums[left] == target)
				return left;
			if (nums[right] == target)
				return right;

			if (nums[left] <= nums[mid]) {
				if (target >= nums[left] && target < nums[mid])
					right = mid - 1;
				else
					left = mid + 1;
			} else {
				if (target <= nums[right] && target > nums[mid])
					left = mid + 1;
				else
					right = mid - 1;
			}
		}
		return -1;
	}
}

//Time Complexity T(n) = O(logn)