public class Problem2B {
    public static void main(String[] args) {

    }
}
class RMITStudentProbing{
    RMITStudent[] studentsList;
    int n;
    int size;
    public RMITStudentProbing(){
        n = 13;
        size =0;
        studentsList = new RMITStudent[n];
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
        return sum % studentsList.length; // %n the max n to fit all values within the index
    }

    boolean putLinearProbing(RMITStudent student){
        int index = getIndex(student.getStudentId()); //Get index
        while(studentsList[index] != null){ //Already know the index of the value we input so it will access that index directly
            if (studentsList[index].getStudentId().equals(student.getStudentId())){
                return false; // Already exists, move to the next index position +1
            }
            index = index+1; //Move the index forward by one if that index is already occyupied
            /*
            Repeat the process until we found an empty index that can add our new element
             */
        }
        studentsList[index] = student; //Add new element at index
        n++; //Increase the size of list
        return true;
    }

    RMITStudent getLinearProbing(String studentId){
        if (studentId == null){ //Check if student
            return null;
        }
        int index = getIndex(studentId); //Get index of studentId

        while (studentsList != null){ //Check if student list have student or not, if yes continue in loop
            if(studentsList[index].getStudentId().equals(studentId)){ //Access the index directly and check if studentId exist
                return studentsList[index]; 
            }
            index = index+1;
        }
        return null;
    }

    boolean remove(String studentId){
        int hash = getIndex(studentId);
        while(studentsList[hash]!= null ){
            if (studentsList[hash].getStudentId().equals(studentId)){
                studentsList[hash] = null;
                return true;
            }
        }
        return false;
    }


}