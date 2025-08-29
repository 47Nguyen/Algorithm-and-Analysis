//Separate Chaining
public class StudentCollection2A {
	int N; //Max capacity
	Node[] students ;
	int size;
	public StudentCollection2A(int N){
		this.N = N;
		students = new Node[N];
		this.size = 0;
	}

	int getHashValue(char c){
		String s = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

		return s.indexOf(c);
	}

	int getIndex(String c){
		int index = 0;
		for (int i = 0; i < c.length();i++){
			char ch = c.charAt(i);
			index += getHashValue(ch);
		}
		return index % N;
	}

	boolean putRMITStudent(RMITStudent student){
		int index = getIndex(student.getStudentId());

		if (size == N){
			return false; //Full
		}

		// If this index is empty add new head
		if (students[index] == null){
			students[index] = new Node(student);
			size++;
			return true;
		}

		Node current = students[index];
		while(true){
			if (current.data.getStudentId().equals(student.getStudentId())){
				return false;
			}

			if (current.next == null){
				current.next = new Node(student);
				size++;
				return true;
			}
			current = current.next;
		}
	}

	RMITStudent getStudent(String studentId){
		int index = getIndex(studentId);
		Node current = students[index];

		if (current.data.getStudentId().equals(studentId)){
			return current.data;
		}

		return null;
	}

	static class Node {
		RMITStudent data;
		Node head, next;
		public Node(RMITStudent data){
			this.data = data;
			head  = next = null;
		}
	}
	static class RMITStudent {
		String studentId;
		String fullName;
		String major;
		double GPA;

		public RMITStudent(String fullName, double GPA, String major, String studentId) {
			this.fullName = fullName;
			this.GPA = GPA;
			this.major = major;
			this.studentId = studentId;
		}

		public String getFullName() {
			return fullName;
		}

		public void setFullName(String fullName) {
			this.fullName = fullName;
		}

		public double getGPA() {
			return GPA;
		}

		public void setGPA(double GPA) {
			this.GPA = GPA;
		}

		public String getStudentId() {
			return studentId;
		}

		public void setStudentId(String studentId) {
			this.studentId = studentId;
		}

		@Override
		public String toString() {
			return "RMITStudent{" +
					"fullName='" + fullName + '\'' +
					", studentId='" + studentId + '\'' +
					", major='" + major + '\'' +
					", GPA=" + GPA +
					'}';
		}


	}

}
