package Problem2;

public class BenBST {
    Node root; //Store data
    public BenBST(){
        this.root = null;
    }

    public static void main(String[] args) {
        BenBST benBST = new BenBST();
        Student student1 = new Student(3.6,123,"A");
        Student student2 = new Student(2.78,456,"A");
        Student student3 = new Student(1.5,789,"A");
        Student student4 = new Student(1.2,101,"A");

        System.out.println("Level: " +benBST.addStudent(student1));
        System.out.println("Level: " +benBST.addStudent(student2));
        System.out.println("Level: " +benBST.addStudent(student3));
        System.out.println("Level: " +benBST.addStudent(student4));
    }


    int addStudent(Student student){
        if (root == null){
            root = new Node(student);
            return 0;
        }
        return  insertRecursive(root, student, 0);

    }
    //Time Complexity = O(1)
    private int insertRecursive(Node current, Student student, int level){ //Insert 1 node at a time.
        if (student.getGPA() < current.data.getGPA()){
            if (current.left == null){ //Check if any node is on that level, if no add node on that level
                current.left = new Node(student);
                return level +1; //Root is Zero.
            }
            else {
                return insertRecursive(current.left, student, level+1 );
                /*
                This block means that if the left node, is not null, we must keep on traversing down the tree
                until when we see there's an empty left node to insert the new node in
                 */
            }
        }
        else {
            if (current.right == null){
                current.right = new Node(student);
                return level +1;
            }
            else {
                return insertRecursive(current.right, student,level + 1);
                /*
                This block means that if the right node, is not null, we must keep on traversing down the tree
                until when we see there's an empty right node to insert the new node in.
                 */
            }
        }
    }
    //Time Complexity = O(N)
    private Student nearestStudent (double targetGPA){ //Do a loop to find the nearest
        Student nearestStudent = root.data; //All node starts at root
        Node current = root; //Use this to refer back when we are traversing

        while (current != null){ //Make sure that the current/root isn't empty
            double nearestGPA = nearestStudent.getGPA(); //Initialize the current closest GPA with target
            double currentGPA = current.data.getGPA(); //The current GPA that's currently on after we traverse. Can only access 1 node at a time
            if (Math.abs(nearestGPA-targetGPA) > Math.abs(currentGPA-targetGPA)){
                //If distance with current GPA is < nearest. Nearest =  current.
                nearestStudent = current.data;
            }
            //Traverse down the tree depending on the node value we are on.
            if (targetGPA < currentGPA){
                current = current.left; //Target GPA is greater so we need to go lower
            } else if (targetGPA > currentGPA){
                current = current.right;
            } else { //If current gpa == targetGPA current = target; return current student with that GPA
                return current.data;
            }
        }
        return nearestStudent;
    }


    static class Node{
        Node left;
        Node right;
        Student data;
        public Node (Student data){
            this.data = data;
            this.right = this.left = null;
        }
    }
    static class Student{
        int id;
        String name;
        double GPA;

        public Student(double GPA, int id, String name) {
            this.GPA = GPA;
            this.id = id;
            this.name = name;
        }

        public double getGPA() {
            return GPA;
        }

        public void setGPA(double GPA) {
            this.GPA = GPA;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "GPA=" + GPA +
                    ", id=" + id +
                    ", name='" + name + '\'' +
                    '}';
        }
    }
}
