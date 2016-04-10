import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class KBestCounter<T extends Comparable<? super T>> {

	int k;
	private PriorityQueue<T> prQueue;

	public KBestCounter(int k) {
		this.k = k;
		prQueue = new PriorityQueue<>(k);
	}

	public void count(T x) {
		if (prQueue.size() < k) {
			prQueue.add(x);
		} else {
			if (prQueue.peek().compareTo(x) <= 0) {
				prQueue.poll();
				prQueue.add(x);
			}
		}
	}

	public List<T> kbest() {
		List<T> sorted = new LinkedList<>();
		ArrayList<T> temp = new ArrayList<>(prQueue.size());

		while (prQueue.size() > 0) {
			T value = prQueue.poll();
			sorted.add(0, value);
			temp.add(value);
		}
		for (int i = 0; i < temp.size(); i++) {
			prQueue.add(temp.get(i));
		}
		return sorted;
	}

}
