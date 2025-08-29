public class StudentCollection2B {
	RMITStudent[] students;
	int n ;
	int size;
	public StudentCollection2B(int n ){
		this.n = n;
		students = new RMITStudent[n];
		size = 0;
	}


	int getHashValue(char c){
		String s = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		return s.indexOf(c);
	}

	int getIndex(String s){
		int index = 0;
		for (int i = 0; i < s.length();i++){
			char c = s.charAt(i);
			index += getHashValue(c);
		}
		return index % n;
	}
	boolean putLinear(RMITStudent student){
		int index = getIndex(student.getStudentId());

		if (size == n){
			return false;
		}

		while(students[index] != null){
			if (students[index].getStudentId().equals(student.getStudentId())){
				return false;
			}
			index = index +1;
		}
		students[index] = student;
		size++;
		return true;

	}

	RMITStudent getLinear(String studentId){
		int index = getIndex(studentId);

		while (students[index] != null){
			if (students[index].getStudentId().equals(studentId)){
				return students[index];
			}
			index = index +1;
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
