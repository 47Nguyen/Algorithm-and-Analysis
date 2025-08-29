public class RMITStudentCollection {
	int N;
	RMITStudent[] students;
	int size;
	public RMITStudentCollection(int N){
		this.N = N;
		students = new RMITStudent[N];
		this.size = 0;
	}

	public static void main(String[] args) {
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

	boolean put(RMITStudent student){
		int index = getIndex(student.getStudentId());

		if (size == N){
			return false; //
		}

		for (int i =0 ; i < students.length;i++){
			if (students[index] != null && students[index].getStudentId().equals(student.getStudentId())){
				return false;
			}
		}
		if (students[index] ==  null){
			students[index] = student;
			size++;
			return true;
		}
		else {
			return false;
		}
	}

	RMITStudent getStudent (String studentId){
		int index = getIndex(studentId);
		RMITStudent foundStudent = null;

		if (students[index] != null && students[index].getStudentId().equals(studentId)){
			foundStudent = students[index];
			return foundStudent;
		}
		return null;
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
