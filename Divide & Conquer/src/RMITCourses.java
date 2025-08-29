import javax.swing.plaf.IconUIResource;
import java.util.ArrayList;
import java.util.List;
import java.util.prefs.PreferenceChangeEvent;

public class RMITCourses {
	public static void main(String[] args) {
//		// Example input
//		String[] courses = {"Course0", "Course1", "Course2", "Course3"};
//		int[][] prerequisites = {
//				{0, 0, 0, 0},
//				{1, 0, 1, 0},
//				{0, 0, 0, 1},
//				{1, 0, 0, 0}
//		};
//
//		List<String> order = courseOrder(courses, prerequisites);
//
//		if (order.isEmpty()) {
//			System.out.println("No valid order exists!");
//		} else {
//			System.out.println("Valid course order: " + order);
//		}
	}

	static List<Integer> courseOrder(String[] course, int[][] prereq){
		int n = prereq.length;
		boolean[] visited = new boolean[n];
		boolean[] visiting = new boolean[n];
		ArrayStack<Integer> stack = new ArrayStack<>();

		for (int i = 0; i < n ;i++){
			if (!visited[i]){
				if (!dfs(i, prereq, visited, visiting, stack)){
					return new ArrayList<>();
				}
			}
		}


		//Pop stack to get order FILO
		List<Integer> order = new ArrayList<>();
		while(!stack.isEmpty()){
			order.add(stack.pop());
		}
		return order;
	}

	static boolean dfs(int course, int[][] prereq, boolean[] visited, boolean[] visiting, ArrayStack<Integer> stack) {
		if (visiting[course]) return false;
		if (visited[course]) return true;

		for (int j = 0; j < prereq[course].length;j++){
			if (prereq[course][j] == 1){
				if (!dfs(j, prereq, visited, visiting, stack)) return false;
			}
		}

		visiting[course] = false;
		visited[course] = true;
		stack.push(course);
		return true;
	}
}
