package Problem2;

public class BenStudentBST {
//    static class Node{
//        /*
//        Initializing the Binary Tree node
//         */
//        int data;
//        Node left;
//        Node right;
//
//        public Node(int data){
//            this.data = data;
//            this.left = null;
//            this.right = null;
//
//        }
//    }

    static class Student{
        int id;
        String name;
        double GPA;
        Student left;
        Student right;

        public Student(double GPA, int id, String name) {
            this.GPA = GPA;
            this.id = id;
            this.name = name;
            this.left = null;
            this.right = null;
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
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }


    static class StudentBST{
        private Student root;
        public StudentBST(){
            this.root = null;
        }

        // addStudent time complexity = O (log N)
        public int addStudent(Student student){
            if (root == null){
                root = student;
                return 0;
            }
            return insertElement(root, student, 0);
            /*
               This method will be run where the root are currently.
               So the first node that is inserted will become the root, and will be on top so level is 0.
             */
        }

        public int insertElement(Student current, Student newStudent, int level){
            // If current node is null, the first node that is inserted becomes the ROOT.
            /*
            If inserted value is less than the root, it will traverse to the left
            If inserted value is greater than the root, it will traverse to the right.
             */

            if (newStudent.getGPA() < current.getGPA()){
                if (current.left == null){
                    current.left = newStudent;
                    return level + 1;
                }
                else {
                    return insertElement(current.left, newStudent, level+1);
                }
            }
            else {
                if (current.right == null){
                    current.right = newStudent;
                    return level + 1 ;
                }
                else {
                    return insertElement(current.right, newStudent, level+1);
                    /*
                    This line is executed when the new student's GPA is greater than or equal to
                     the current node's GPA, and there's already a right child (i.e., current.right != null).
                     So we recurse down the right subtree.
                     */
                }
            }
        }


        public Student nearestStudent(double GPA){
            /*
            Initialize the current and closest.
             */
            return nearest(root, GPA, root);
        }

        private Student nearest(Student current, double gpa, Student closest){
            /*
            Current and closest = Will be equal to root Node.
            We assume that the closet GPA is the root unless it's proven.

             */
            if (current == null){
                return closest;
            }

            if (Math.abs(current.getGPA() - gpa) < Math.abs(closest.getGPA() - gpa)){
                /*
                If the (closest GPA - target GPA) > (current GPA - target GPA).
                The current GPA will be the new closest.
                 */
                closest = current;
            }
            if (gpa < current.getGPA()){
                /*
                If target GPA is less than current GPA go left.
                We will go the left, because that is where the target GPA is or the GPA that's closest.
                Else if target GPA is greater than current GPA go right.
                 */
                return nearest(current.left, gpa, closest);
            } else {
                return nearest(current.right, gpa, closest);
            }
        }

    }

    public static void main(String[] args) {
        StudentBST sbt = new StudentBST();
        Student s1 = new Student(3.3, 1,"Alice");
        Student s2 = new Student(3.1, 2,"Bob");
        Student s3 = new Student(3.2, 3,"Carol");
        Student s4 = new Student(3.5, 4,"David");

        System.out.println("Tree level of the current student: "  + sbt.addStudent(s1));
        System.out.println("Tree level of the current student: "  + sbt.addStudent(s2));
        System.out.println("Tree level of the current student: "  + sbt.addStudent(s3));
        System.out.println("Tree level of the current student: "  + sbt.addStudent(s4));
    }


}
