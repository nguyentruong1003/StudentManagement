public class StudentManagement{
    public static boolean sameGroup(Student s1, Student s2){
        if (s1.getGroup().equals(s2.getGroup())) {
            return false;
        }
        return true;
    }

    Student[] students = new Student[100];
    int len = 0;

    public void addStudent(Student newStudent) {
        students[len ++] = new Student(newStudent);
    }

    public String studentsByGroup(){
        String result = "";
        int[] temp_group = new int[len];
        for (int i=0; i<len;i++){
            temp_group[i] = 1;
        }
        for (int i=0;i<len;i++){
            for (int j=i+1;j<len;j++){
                if (students[i].getGroup().equals(students[j].getGroup())){
                    temp_group[j] = 0;
                }
            }
        }
        for (int i=0;i<len;i++) {
            if (temp_group[i] == 1){
                result += students[i].getGroup() + "\n";
                for (int j=0;j<len;j++){
                    if (students[j].getGroup().contentEquals(students[i].getGroup())){
                        result += students[j].getInfo() + "\n";
                    }
                }
            }
        }
        return result;
    }

   public void removeStudent(String id){
        for (int i= 0;i<len; ++i){
            if (students[i].getId().equals(id)) {
                for (int j = i; j< len; j ++) {
                    students[j] = students[j + 1];
                }
                len--;
            }
        }
    }
    public static void main(String[] args){
        StudentManagement s1 = new StudentManagement();
        Student s2 = new Student("Nguyen Van B", "17020002", "17020002@vnu.edu.vn");
        s1.addStudent(s2);
        s1.removeStudent("17020002");
        System.out.println(s1.studentsByGroup());
    }
}
