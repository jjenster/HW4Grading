import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class KBestCounter<T extends Comparable<T>> {

  PriorityQueue<T> heap;
  int k;

  public KBestCounter(int k) {
    this.k = k;
    heap = new PriorityQueue<>(k);
  }

  public void count(T x) {
    if (heap.size() < k) {
      heap.offer(x);
    } else {
      if (heap.peek().compareTo(x) < 0) {
        heap.poll();
        heap.offer(x);
      }
    }
  }

  public List<T> kbest() {
    LinkedList<T> result = new LinkedList<>();
    PriorityQueue<T> newHeap = new PriorityQueue<T>();
    while (!heap.isEmpty()) {
      T next = heap.remove();
      result.addFirst(next);
      newHeap.add(next);
    }
    heap = newHeap;
    return result;
  }

  public static void main(String[] args) {
    KBestCounter<Integer> kbest = new KBestCounter<>(3);
    kbest.count(1);
    kbest.count(4);
    for (Integer i : kbest.kbest()) {
      System.out.print(i + " ");
    }
    System.out.println();
    kbest.count(3);
    kbest.count(2);
    kbest.count(5);
    for (Integer i : kbest.kbest()) {
      System.out.print(i + " ");
    }
    System.out.println();
    kbest.count(1);
    kbest.count(3);
    kbest.count(10);
    for (Integer i : kbest.kbest()) {
      System.out.print(i + " ");
    }
  }
}
