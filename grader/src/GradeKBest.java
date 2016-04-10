import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;


public class GradeKBest {

	public static void main(String[] args) throws IOException {

		BufferedWriter writer = new BufferedWriter(new FileWriter("grade.txt"));

		int k = 7;

		KBestCounterGold<Integer> gold = new KBestCounterGold<>(k);
		KBestCounter<Integer> student = new KBestCounter<>(k);

		// Test case 1: no elements
		if (!student.kbest().equals(gold.kbest())) {
			writer.append("empty kbest() returns either empty list or null:0");
			writer.append("\n");
		} else{
			writer.append("empty kbest() returns either empty list or null:2");
			writer.append("\n");
		}

		// Test case 2: inserting 5 elements
		student.count(7);
		student.count(4);
		student.count(8);
		student.count(5);
		student.count(8);
		gold.count(7);
		gold.count(4);
		gold.count(8);
		gold.count(5);
		gold.count(8);
		
		if (!student.kbest().equals(gold.kbest())) {
			writer.append("kbest() returns x elements when x elements are inserts for x < k:0");
			writer.append("\n");
		} else{
			writer.append("kbest() returns x elements when x elements are inserts for x < k:3");
			writer.append("\n");
		}
		
		// Test case 3: inserting more than 7 elements
		for (int i = 0; i < 3; i++){
			student.count(i);
			gold.count(i);
		}

		for (int i = 99; i < 103; i++){
			student.count(i);
			gold.count(i);
		}
		
		for (int i = 0; i < 10; i++){
			student.count(i);
			gold.count(i);
		}
		
		if (!student.kbest().equals(gold.kbest())) {
			writer.append("kbest() returns top k elements when x > k elements are inserted:0");
			writer.append("\n");
		} else{
			writer.append("kbest() returns top k elements when x > k elements are inserted:5");
			writer.append("\n");
		}
		
		// Test case 4: inserting more elements
		
		for (int i = 10; i < 15; i++){
			student.count(i);
			gold.count(i);
		}
		
		for (int i = 99; i < 103; i++){
			student.count(i);
			gold.count(i);
		}
		
		if (!student.kbest().equals(gold.kbest())) {
			writer.append("kbest() returns new list of k elements (some of which are from the previous insert) when y more elements are inserted:0");
			writer.append("\n");
		} else{
			writer.append("kbest() returns new list of k elements (some of which are from the previous insert) when y more elements are inserted:3");
			writer.append("\n");
		}
		
		writer.close();
	}
}
