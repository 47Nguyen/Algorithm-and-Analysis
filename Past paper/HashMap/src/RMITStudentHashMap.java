public class RMITStudentHashMap {
    RMITStudent[] rmitStudents;
    int N;
    public RMITStudentHashMap(){
        this.N = 13;
        this.rmitStudents = new RMITStudent[N]; //Max size is 13 or N.
    }

    public static void main(String[] args) {
        RMITStudentHashMap s = new RMITStudentHashMap();

    }

    int hash(char c){
        String s = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        return s.indexOf(c);
    }

    int getIndex(String studentId){
        int index = 0;
        for (int i = 0 ; i < studentId.length();i++){
            char c =  studentId.charAt(i);
            index += hash(c);
        }
        return index % N; // Return the index of studentId
    }

    //With no collision resistance
    boolean put (RMITStudent rmitStudent){
        int index = getIndex(rmitStudent.getStudentId());
        if (rmitStudents[index] == null) { // Slot empty
            rmitStudents[index] = rmitStudent;
            return true;
        } else if (rmitStudents[index].getStudentId().equals(rmitStudent.getStudentId())) {
            return false;

        }
        return false;
    }


    RMITStudent get (String studentId){
        int index = getIndex(studentId); // Get the index of this studentId

        if (rmitStudents[index].getStudentId().equals(studentId) && rmitStudents[index] != null ){
            return rmitStudents[index];
        }
        return null;
    }
    static class RMITStudent{
        String studentId;
        String fullName;
        String major;
        double gpa;

        public RMITStudent(String fullName, double gpa, String major, String studentId) {
            this.fullName = fullName;
            this.gpa = gpa;
            this.major = major;
            this.studentId = studentId;
        }

        public String getFullName() {
            return fullName;
        }

        public void setFullName(String fullName) {
            this.fullName = fullName;
        }

        public double getGpa() {
            return gpa;
        }

        public void setGpa(double gpa) {
            this.gpa = gpa;
        }

        public String getMajor() {
            return major;
        }

        public void setMajor(String major) {
            this.major = major;
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
                    ", gpa=" + gpa +
                    '}';
        }
    }

}
