import java.lang.foreign.StructLayout;

public class StudentBST {
    StudentNode root;


    int addStudent(Student student){
        int level = 0;
        if (root == null){
            root = new StudentNode(student);
            return level;
        }
        StudentNode curr = root;

        while (true){
            if (student.getGpa() > curr.data.getGpa()){
                if (curr.right == null){
                    curr.right = new StudentNode(student);
                    return level+1;
                }
                curr = curr.right;
                level++;
            } else if(student.getGpa() < curr.data.getGpa()){
                if (curr.left == null){
                    curr.left = new StudentNode(student);
                    return level+1;
                }
                curr = curr.left;
                level++;
            } else {
                return -1;
            }
        }
    }

    StudentNode nearestStudent(double gpa){
        if (root == null){
            return null;
        }

        StudentNode curr = root;
        StudentNode foundNode = root;
        double nearestDiff = Math.abs(root.data.getGpa() - gpa);
        while(curr != null){

            double currentDiff = Math.abs(curr.data.getGpa() - gpa);

            if (currentDiff < nearestDiff){
                nearestDiff = currentDiff;
                foundNode = curr;
            }

            //Traversing
            if (gpa > curr.data.getGpa()){
                curr = curr.right;

            } else if(gpa < curr.data.getGpa()){
                curr = curr.left;
            } else {
                return curr;
            }
        }
        return foundNode;

    }

    static class StudentNode{
        Student data;
        StudentNode right, left, root;
        public StudentNode(Student node){
            this.data = node;
            right = left = root = null;
        }
    }
    static class Student{
        int id;
        String name;
        double gpa;

        public Student(double gpa, int id, String name) {
            this.gpa = gpa;
            this.id = id;
            this.name = name;
        }

        public double getGpa() {
            return gpa;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "gpa=" + gpa +
                    ", id=" + id +
                    ", name='" + name + '\'' +
                    '}';
        }
    }
}
