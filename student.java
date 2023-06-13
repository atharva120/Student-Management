package mainpack.mypack2;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class student {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        SystemUsers su=new SystemUsers();
        int accid=0;
        int adminid=0;
        for (int i = 0; i <5; i--) {
            System.out.println("1.sign up\n2.login");
            int action=sc.nextInt();
            if(action==1){
                System.out.println("1.Sign up as Accountant\n2.Sign Up as Admin");
                String acti1= sc.next();
                System.out.println("1");
                if (acti1.equals("1")){
                    System.out.println("Enter Your Name");
                    String name= sc.next();
                    System.out.println("Enter Password");
                    String pass= sc.next();
                    accid+=1;
                    String tempid=String.valueOf(accid);
                    su.addAcc(tempid,name,pass);

                }
                else if (acti1.equals("2")) {
                    System.out.println("Enter your Name");
                    String name=sc.next();
                    System.out.println("enter password");
                    String pass=sc.next();
                    adminid+=1;
                    String tempid=String.valueOf(adminid);
                    su.addadmin(tempid,name,pass);
                }
            }
            else if (action==2) {
                System.out.println("1.Sign up as Accountant\n2.Sign Up as Admin");
                String acti1= sc.next();
                if (acti1.equals("1")){
                    System.out.println("Enter Your Name");
                    String name= sc.next();
                    System.out.println("Enter Password");
                    String pass= sc.next();
                    accid+=1;
                    String tempid=String.valueOf(accid);
                    su.addAcc(tempid,name,pass);
                    System.out.println("login sucess full");
                    for (int j = 0; j <1; j--) {
                        System.out.println("1.Add Students" + "\n2.View Students" + "\n3.Edit Students" + "\n4.Delete Students" + "\n5.Pay Student Fee" + "\n6.Logout");
                        String act1= sc.next();
                        if(act1.equals("1")){
                            System.out.println("Enter Student ID");
                            String sid= sc.next();
                            System.out.println("Enter Student Name");
                            String sname= sc.next();
                            System.out.println("Enter Student's Total fee");
                            String stotalfee= sc.next();
                            System.out.println("Enter Student's Paid fee");
                            String spaidfee= sc.next();
                            su.addstudent(sid,sname,stotalfee,spaidfee);
                        } else if (act1.equals("2")) {
                            System.out.println("Enter Accountant ID");
                            String sid= sc.next();
                            System.out.println(su.accountantdetail.get(sid));
                        } else if (act1.equals("3")) {
                            System.out.println("Enter Accountant ID");
                            String sid= sc.next();
                            System.out.println(su.accountantdetail.get(tempid));
                            System.out.println("Enter Accountant New Name");
                            String  nname= sc.next();
                            System.out.println("Enter Accountant New Password");
                            String  npass= sc.next();
                            su.editAccountant(tempid,nname,npass);
                        } else if (act1.equals("4")) {
                            System.out.println("Enter Accountant ID to Delete Accountant");
                            String sid= sc.next();
                            su.deleteAccountant(tempid);
                        } else if (act1.equals("5")) {
                            break;
                        }
                    }
                }
                else if (acti1.equals("2")) {
                    System.out.println("Enter your Name");
                    String name=sc.next();
                    System.out.println("enter password");
                    String pass=sc.next();
                    adminid+=1;
                    String tempid=String.valueOf(adminid);
                    su.addadmin(tempid,name,pass);
                }
            }
        }
    }
}
class SystemUsers{
    HashMap<String,HashMap> accountantdetail=new HashMap<>();
    HashMap<String,HashMap> admindetail=new HashMap<>();
    HashMap<String,studentdata> studentdetail=new HashMap<>();
    HashMap<String, ArrayList> feedata=new HashMap<>();
    public void addadmin(String id,String name,String pass){
        HashMap<String,String > temp1=new HashMap<>();
        temp1.put("name",name);
        temp1.put("pass",pass);
        admindetail.put(id,temp1);
    }
    public void addAcc(String id,String name,String pass){
        HashMap<String,String > temp1=new HashMap<>();
        temp1.put("name",name);
        temp1.put("pass",pass);
        accountantdetail.put(id,temp1);
    }
    public void addstudent(String sid,String sname,String stotalfee,String spaidfee){
        studentdata sd=new studentdata(sid,sname,stotalfee,spaidfee);
        ArrayList<Integer> temp=new ArrayList<>();
        temp.add(Integer.valueOf(spaidfee));
        feedata.put(sid,temp);
        studentdetail.put(sid,sd);
    }
    public void deleteAccountant(String  id){
        System.out.println(accountantdetail.get(id));
        accountantdetail.remove(id);
        System.out.println("Accountant deleted Successfully");
    }
    public void editAccountant(String  id,String  nname,String nid){
        accountantdetail.remove(id);
        HashMap<String ,String > temphash=new HashMap<>();
        temphash.put(nname,nid);
        accountantdetail.put(id,temphash);
    }
    public void viewstudent(String id){
        if (id.equals(studentdetail.get(id).id)){
            System.out.println("Name      : "+studentdetail.get(id).id);
            System.out.println("ID        : "+studentdetail.get(id).name);
            System.out.println("Total fee : "+studentdetail.get(id).totalfee);
            System.out.println("Paid Fee  : "+studentdetail.get(id).paidfee);
        }
    }
    public void deletestudent(String id){
        if (id.equals(studentdetail.get(id).id)){
            System.out.println("Name      : "+studentdetail.get(id).id);
            System.out.println("ID        : "+studentdetail.get(id).name);
            System.out.println("Total fee : "+studentdetail.get(id).totalfee);
            System.out.println("Paid Fee  : "+studentdetail.get(id).paidfee);
            System.out.println("Above Details has been removed from database");
            studentdetail.remove(id);
        }
    }

    public void editstudentname(String id,String name){
        studentdetail.get(id).name=name;
        System.out.println("Name Edited");
    }
    public void editstudenttotalfee(String id,String totalfee){
        studentdetail.get(id).totalfee=totalfee;
        System.out.println("Totalfee Edited");
    }
    public void editstudentpaidfee(String id,String paidfee){
        studentdetail.get(id).paidfee=paidfee;
        System.out.println("ID Edited");
    }
    public void paystudentfee(int fee,String id){

        ArrayList<Integer> temp=new ArrayList<>();
        temp.add(fee);
        feedata.get(id).add(temp);
        fee+=Integer.parseInt(studentdetail.get(id).paidfee);
        studentdetail.get(id).paidfee=String.valueOf(fee);
    }
    public void editstudent(String id,String name, String totalfee, String paidfee){

        studentdetail.get(id).name=name;
        studentdetail.get(id).totalfee=totalfee;
        studentdetail.get(id).paidfee=paidfee;
        System.out.println("Student Profile Edited");
    }

}
class studentdata{

    String id, name, totalfee, paidfee;

    public studentdata(String id, String name, String totalfee, String paidfee) {
        this.id = id;
        this.name = name;
        this.totalfee = totalfee;
        this.paidfee = paidfee;
    }
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getTotalfee() {
        return totalfee;
    }
    public String getPaidfee() {
        return paidfee;
    }
    @Override
    public String toString() {
        return "Studentdata :\n" +
                "ID        = " + id +
                "Name      = " + name +
                "Totalfee  = " + totalfee +
                "Paidfee   = " + paidfee ;
    }
}
