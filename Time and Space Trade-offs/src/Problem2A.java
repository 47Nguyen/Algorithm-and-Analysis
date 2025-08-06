public class Problem2A {
    public static void main(String[] args) {
        RMITStudentChaining rmitLinkedList = new RMITStudentChaining();

        RMITStudent s1 = new RMITStudent("A",3.5,"IT","s397777");
        RMITStudent s2 = new RMITStudent("A",3.5,"IT","s397777");
        System.out.println(rmitLinkedList.put(s1));
        System.out.println(rmitLinkedList.get(s1.getStudentId()));

        System.out.println(rmitLinkedList.remove("s397777"));
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

    public double getGPA() {
        return GPA;
    }

    public String getMajor() {
        return major;
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

class RMITStudentChaining {
    RMITLinkedList[] hashtable;
    int n;
    public RMITStudentChaining(){
        this.n = 13;
        hashtable = new RMITLinkedList[n]; //Max size = n
    }


    int getHashValue(char c){
        String string = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        return string.indexOf(Character.toUpperCase(c));
    }

    int getIndex(String value) {
        int sum = 0;
        for (int i = 0; i < value.length(); i++) {
            sum += getHashValue(value.charAt(i));
        }
        return sum % hashtable.length; // Modulo to avoid IndexOutOfBounds
    }

    //With chaining
    boolean put(RMITStudent student){
        if (student == null){
            return false;
        }
        int index = getIndex(student.getStudentId()); //Initalize this index, so we can access that index directly

        if (hashtable[index] == null){ //Conditions to makes if index here is null or not.
            hashtable[index] = new RMITLinkedList(); //Create new linked list to store node
        }
        return hashtable[index].add(student); //Add data into node
    };

    RMITStudent get(String studentId){
        if (studentId == null ){
            return null;
        }
        int index = getIndex(studentId);
        if (hashtable[index] == null){ //Conditions to makes if index here is null or not.
            return null;
        }
        return hashtable[index].get(studentId);
    }

    boolean remove(String studentId){
        if (studentId == null ){
            return false;
        }
        int index = getIndex(studentId);
        if (hashtable[index] == null) return false;

        return hashtable[index].remove(studentId);
    }


class RMITLinkedList {
    Node head;
    int size;
    public RMITLinkedList(){
        this.head = null;
        this.size = 0;
    }

    boolean isEmpty() {
        return size == 0;
    }

    boolean add(RMITStudent item) {
        Node node = new Node(item);
        if (!isEmpty()) {
            Node curr = head;
            while(curr.next != null)
                curr = curr.next;
            curr.next = node;
        }else{ // if empty, add new node at the head
            head = node;
        }
        size++;
        return true;
    }

    RMITStudent get(String string){
        Node node = head;
        while (node != null){
            if (node.data.getStudentId().equals(string)){
                return node.data;
            }
            node = node.next;
        }
        return null;
    }
    boolean remove(String studentId) {
        if (size == 0) {
            return false;
        }
        Node parent = null;
        Node current = head;
        while (current != null) {
            if (current.data.studentId.equals(studentId)) {
                if (current == head) {
// remove head => need to update head
                    head = head.next;
                    size--;
                    return true;
                }
                parent.next = current.next;
                size--;
                return true;
            }
            parent = current;
            current = current.next;
        }
        return false;
    }
}

}

class Node{
    Node next;
    RMITStudent data;
    public Node(RMITStudent data){
        this.next = null;
        this.data = data;
    }
}