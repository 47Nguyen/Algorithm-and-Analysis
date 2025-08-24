public class RMITSeparateChaining {
    Node[] rmitStudents;
    int N;
    Node head;
    int size;

    public RMITSeparateChaining(){
        this.N = 13;
        this.rmitStudents = new Node[N]; //Max size is 13 or N.
        this.size = 0;
    }


    public static void main(String[] args) {
        RMITStudentHashMap s = new RMITStudentHashMap();

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

    // With collision resistance
    boolean putSeparateChain(RMITStudent rmitStudent) {
        int index = getIndex(rmitStudent.getStudentId());

        // If this slot is empty, create a new linked list head
        if (rmitStudents[index] == null) {
            rmitStudents[index] = new Node(rmitStudent);
            size++;
            return true;
        }

        // Traverse the chain at this index
        Node current = rmitStudents[index];

        while(true){
            if (current.data.getStudentId().equals(rmitStudent.getStudentId())){
                return false; //Id already exist
            }
            if (current.next == null){
                current.next = new Node(rmitStudent);
                size++;
                return true;
            }
            current = current.next;
        }
    }

    RMITStudent get (String studentId){
        int index = getIndex(studentId); // Get the index of this studentId
        Node current = rmitStudents[index];
        if (rmitStudents[index]== null){
            return null; //Empty
        }
        return current.data;
    }

    boolean remove(String studentId){
        int index = getIndex(studentId); // Get the index of this studentId
        if (rmitStudents[index]== null){
            return false; //Empty
        }
        rmitStudents[index] = null;
        return true;
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

    static class Node{
        RMITStudent data;
        Node next;
        Node head;

        public Node(RMITStudent data){
            this.data = data;
            this.next = head = null;
        }
    }
}
