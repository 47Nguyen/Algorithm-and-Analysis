// Hash functions
public class ManageRMIT {
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

    public String getStudentId() {
        return studentId;
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
class RMITStudentCollection {
    RMITStudent[] studentHashTable;
    int size;
    int maxSize =13;
    public RMITStudentCollection(int size){
        this.size = size;
        this.studentHashTable = new RMITStudent[maxSize];

    }
    //h(S) = (h(s1) + h(s2) + ... + h(sn)) % N

    static int hashValue(char c){
        String string = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        return string.indexOf(c);
    }

    boolean put(RMITStudent student){
//        if (studentHashTable.length == maxSize){
//            return false;
//        }
        for (RMITStudent data : studentHashTable){
            if (data != null && student.getStudentId().equals(data.getStudentId())) {
                return false;
            }
        }
        if (size < maxSize){
            studentHashTable[size] = student;
            size++;
            return true;
        }
        return false;
    }
    RMITStudent get(String studentId) {
        for (RMITStudent student : studentHashTable) {
            if (student != null && student.getStudentId().equals(studentId)) {
                return student;
            }
        }
        return null;
    }


    public static void main(String[] args) {
        RMITStudent student1 = new RMITStudent("A",1,"IT","s3977756");
        RMITStudent student2 = new RMITStudent("B",2.0,"IT","s3977757");
        RMITStudent student3 = new RMITStudent("C",2.0,"IT","s3977758");
        RMITStudent student4 = new RMITStudent("D",3.5,"IT","s3977759");
        RMITStudent student5 = new RMITStudent("E",4.0,"IT","s3977777");

        RMITStudentCollection collection = new RMITStudentCollection(4);
        System.out.println(collection.put(student1));
        collection.put(student2);
        collection.put(student3);
        collection.put(student4);
        collection.put(student5);

        System.out.println(collection.get("s3977756"));
        System.out.println(collection.get("s3977757"));
        System.out.println(collection.get("s3977777"));
    }
}