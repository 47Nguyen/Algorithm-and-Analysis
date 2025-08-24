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
            if (curr.data.getGpa() > student.getGpa()){
                if (curr.left == null){
                    curr.left = new StudentNode(student);
                    level++;
                    return level;
                }
                curr = curr.left;
            } else if (curr.data.getGpa() < student.getGpa()) {
                if (curr.right == null){
                    curr.right = new StudentNode(student);
                    level++;
                    return level;
                }
                curr = curr.right;
            }
        }
    }

    StudentNode nearestStudent(double gpa){
        StudentNode current = root;
        StudentNode found = root;

        double nearestDiff = Math.abs(root.data.getGpa() - gpa) ;
        while(current != null){
            double currentDiff = Math.abs(current.data.getGpa() - gpa);

            if (currentDiff < nearestDiff){
                nearestDiff = currentDiff;
                found = current;
            }

            if (gpa < current.data.getGpa()){
                current = current.left;
            }
            else if (gpa > current.data.getGpa()){
                current = current.right;
            }
            else {
                return current;
            }
        }
        return found;

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

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
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
    static class StudentNode{
        Student data;
        StudentNode left, right;
        StudentNode root;
        public StudentNode(Student data ){
            this.data = data;
            left = right = root = null;
        }
    }
}
