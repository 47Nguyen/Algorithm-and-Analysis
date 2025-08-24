import java.util.prefs.PreferenceChangeEvent;

public class RMITLinearProbing {
    RMITStudent[] rmitStudents;
    int size;
    int N;
    public RMITLinearProbing(int N){
        this.N = N;
        this.size = 0;
        this.rmitStudents = new RMITStudent[N];
    }

    public static void main(String[] args) {
        RMITLinearProbing rmitLinearProbing = new RMITLinearProbing(13);
    }
    int hash(char c) {
        String s = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        return s.indexOf(c);
    }

    int getIndex(String studentId) {
        int index = 0;
        for (int i = 0; i < studentId.length(); i++) {
            char c = studentId.charAt(i);
            index += hash(c);
        }
        return index % N; // Return the index of studentId
    }

    boolean getLinearProbing(RMITStudent student){
        int index = getIndex(student.getStudentId());
        if (size == N){ //Reach its maz
            return false;
        }
        while(rmitStudents[index] !=  null){
            if(rmitStudents[index].getStudentId().equals(student.getStudentId())){
                return false;
            }
            index = index +1; //Increase index by one until find index that is null
        }
        rmitStudents[index] =student;
        size++;
        return true;
    }

    RMITStudent get (String studentId){
        int index = getIndex(studentId); // Get the index of this studentId

        while(rmitStudents[index] != null){
            if(rmitStudents[index].getStudentId().equals(studentId)){
                return rmitStudents[index];
            }
            index = index +1;
        }
        return null;
    }

    static class RMITStudent {
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
            return "RMITStudent{" + "fullName='" + fullName + '\'' + ", studentId='" + studentId + '\'' + ", major='" + major + '\'' + ", gpa=" + gpa + '}';
        }
    }
}
