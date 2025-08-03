import javax.swing.plaf.synth.SynthTableUI;

public class ManageStudent {
}
class RMITStudentCollection {
    public static void main(String[] args) {
        RMITStudentCollection collection = new RMITStudentCollection();
        RMITStudent s1 = new RMITStudent("Jay",3.5,"ENG","123");
        RMITStudent s2 = new RMITStudent("John",4.5,"IT","456");
        RMITStudent s3 = new RMITStudent("Jack",2.5,"SEF","789");
        RMITStudent s4 = new RMITStudent("Joe",1.5,"SEF","111");

        // Put - Separate Chaining
        collection.putSeparateChaining(s1);
        collection.putSeparateChaining(s2);
        collection.putSeparateChaining(s3);
        collection.putSeparateChaining(s4);

        //Get - Separate chaining
        System.out.println(collection.getSeparateChaining("123"));
        System.out.println(collection.getSeparateChaining("456"));

        //Remove - Separate Chaining
        System.out.println(collection.removeForSeparateChaining("123"));

        System.out.println(collection.getSeparateChaining("456"));


        //Linear Probing
//        System.out.println(collection.putLinearProbing(s1));
//        System.out.println(collection.putLinearProbing(s2));
//        System.out.println(collection.putLinearProbing(s3));
//        System.out.println(collection.putLinearProbing(s4));


        //Get Linear Probing
//        System.out.println(collection.getLinearProbing("123"));
//        System.out.println(collection.getLinearProbing("456"));
//
//        //Remove for linearProbing
//        System.out.println(collection.removeForProbing("123"));
//        System.out.println(collection.removeForProbing("456"));
//
//        //Get Linear Probing
//        System.out.println(collection.getLinearProbing("123"));
//        System.out.println(collection.getLinearProbing("456"));
    }
    int maxSize = 13;
    Node[] studentTable;
    RMITStudent[] hashTable;
    public RMITStudentCollection(){
        studentTable = new Node[maxSize];
        hashTable = new RMITStudent[maxSize];
    }

    int hashValue(char c){
        String str = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        return str.indexOf(c) % 13; //Split the string
    }

    // Put separate chaining
    boolean putSeparateChaining(RMITStudent s){ // Separate Chaining
        if (s == null || s.getStudentId() == null || s.getStudentId().isEmpty()) return false;

        int index = hashValue(s.getStudentId().charAt(s.getStudentId().length() - 1));
        if (index == -1) return false;

        Node head = studentTable[index];

        // Check for duplicate
        Node current = head;
        while (current != null) {
            if (current.data.getStudentId().equals(s.getStudentId())) {
                return false; // Duplicate found
            }
            current = current.next;
        }

        // Insert at head (you can also insert at tail if preferred)
        Node newNode = new Node(s);
        newNode.next = head;
        studentTable[index] = newNode;

        return true;
    }

    // Put Linear probing
    boolean putLinearProbing(RMITStudent s){
        if (s == null || s.getStudentId() == null || s.getStudentId().isEmpty()) return false;
        int index = hashValue(s.getStudentId().charAt(s.getStudentId().length() - 1));
        if (index == -1) return false;

        int startIndex = index;
        do {
            if (hashTable[index] == null) {
                hashTable[index] = s;
                return true; // Inserted successfully
            } else if (hashTable[index].getStudentId().equals(s.getStudentId())) {
                return false; // Duplicate student ID
            }

            index = (index + 1) % maxSize; // Wraparound
        } while (index != startIndex);

        return false; // Table full
    }

    //Get for separate chaining
    RMITStudent getSeparateChaining(String studentId){
        if (studentId == null || studentId.isEmpty()) return null;

        int index = hashValue(studentId.charAt(studentId.length() - 1));
        if (index == -1) return null;

        Node curr = studentTable[index];

        while (curr != null){
            if (curr.data != null && curr.data.getStudentId().equals(studentId)) {
                return curr.data;
            }

            curr = curr.next;
        }
        return null;
    }

    //Get for Linear Probing
    RMITStudent getLinearProbing(String sid) {
        if (sid == null || sid.isEmpty()) return null;

        for (RMITStudent student : hashTable) {
            if (student != null && sid.equals(student.getStudentId())) {
                return student;
            }
        }

        return null; // Not found
    }

    //Remove for Separate Chaining
    boolean removeForSeparateChaining(String studentId){
        if (studentId == null || studentId.isEmpty()) return false;

        int index = hashValue(studentId.charAt(studentId.length() - 1));
        if (index == -1) return false;

        Node current = studentTable[index];

        while (current.data != null){
            if (current.data.getStudentId().equals(studentId)){
                current.data = null;
                return true;
            }
        }
        return false;
    }


    // Remove for Linear Probing
    boolean removeForProbing(String studentId){
        if (studentId == null || studentId.isEmpty()) return false;
        for (int i = 0; i < hashTable.length;i++){
            if (hashTable[i] != null && studentId.equals(hashTable[i].getStudentId())) {
                hashTable[i] = null;
                return true;
            }
        }
        return false;
    }


    static class Node {
        RMITStudent data;
        public Node next;
        Node(RMITStudent data) {
            this.data = data;
            this.next = null;
        }
    }


}
    class RMITStudent {
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
                ", GPA=" + GPA +
                '}';
    }
}