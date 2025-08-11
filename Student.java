public class Student {
    private int roll_no;
    private String name;
    private String department;
    private String email;
    private long phn_no;


    Student(int roll_no,String name,String department,String email,long phn_no){
        this.roll_no=roll_no;
        this.name=name;
        this.department=department;
        this.email=email;
        this.phn_no=phn_no;
    }

    //getter for students
    public int getRoll_no(){

        return roll_no;
    }
    public String getName(){

        return name;
    }
    public String getDepartment(){

        return department;
    }
    public String getEmail(){

        return  email;
    }
    public long getPhn_no(){

        return phn_no;
    }

        //setters
    public void setRoll_no(int roll_no){

        this.roll_no=roll_no;
    }
    public void setName(String name){

        this.name=name;
    }
    public void setDepartment(String department){

        this.department=department;
    }
    public void setEmail(String email){

        this.email=email;
    }
    public void setPhn_no(long phn_no){

        this.phn_no=phn_no;
    }

    @Override
    public String toString() {
        return "Student : [" +
                "Roll Number : "+ roll_no + " , " +" Name : "+name+" , " +" Department : "+department+" , " +" Email : "+email+" , " +" Phone Number : "+phn_no + "]";
    }
}
