package leetcode;

class ListNode {
	int val;
	ListNode next;

	ListNode() {
	}

	ListNode(int val) {
		this.val = val;
	}

	ListNode(int val, ListNode next) {
		this.val = val;
		this.next = next;
	}
}

public class AddTwoNumbers {
	public static void main(String[] args) {
		ListNode l1_3 = new ListNode(3);
		ListNode l1_2 = new ListNode(4, l1_3);
		ListNode l1_1 = new ListNode(2, l1_2);

		ListNode l2_3 = new ListNode(4);
		ListNode l2_2 = new ListNode(6, l2_3);
		ListNode l2_1 = new ListNode(5, l2_2);

		AddTwoNumbers addTwoNumbers = new AddTwoNumbers();
		//		ListNode result = addTwoNumbers.addTwoNumbers(l1_1, l2_1);
		//		System.out.print(result.val);
		//		System.out.print(result.next.val);
		//		System.out.println(result.next.next.val);

		l1_2 = new ListNode(8);
		l1_1 = new ListNode(1, l1_2);

		l2_1 = new ListNode(0);

		ListNode result2 = addTwoNumbers.addTwoNumbers(l1_1, l2_1);
		System.out.println(result2.val);
		System.out.println(result2.next.val);
	}

	/**
	 * Runtime: 3 ms, faster than 38.59% of Java online submissions for Add Two Numbers.
	 * Memory Usage: 39.1 MB, less than 95.00% of Java online submissions for Add Two Numbers.
	 *
	 * @param l1
	 * @param l2
	 * @return
	 */
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		int roundUp = 0;    //자릿수 올림
		ListNode childNode = null;
		ListNode firstNode = new ListNode(-1);

		while (l1 != null || l2 != null || (l1 == null && roundUp > 0)) {
			int sum = roundUp;

			//자릿수가 다른 값을 더하는 경우까지 고려한다
			if (l1 != null) {
				sum += l1.val;
				l1 = l1.next;
			}
			if (l2 != null) {
				sum += l2.val;
				l2 = l2.next;
			}

			//자릿수 올림을 처리한다
			if (sum >= 10) {
				roundUp = 1;
				sum -= 10;
			} else {
				roundUp = 0;
			}

			//1자리 숫자 이상인 경우 next에 추가한다
			ListNode node = new ListNode(sum);
			if (firstNode.val > -1) {
				childNode.next = node;
			} else {
				firstNode = node;
			}
			childNode = node;
		}

		return firstNode;
	}
	// https://leetcode.com/problems/add-two-numbers/submissions/
}
