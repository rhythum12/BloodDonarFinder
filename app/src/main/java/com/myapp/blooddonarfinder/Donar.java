package com.myapp.blooddonarfinder;

public class Donar {
    String id, fullname, address, contactno, age, bloodgroup, date;


    public Donar(){

    }

    public Donar( String id, String fullname,String address,String contactno, String age, String bloodgroup, String date ) {
       this.id=id;
        this.fullname = fullname;
        this.address=address;
        this.contactno=contactno;
        this.age=age;
        this. bloodgroup=bloodgroup;

        this.date=date;


    }
    public String getId()
    {
        return id;
    }
    public String getDate(){
        return date;
    }
    public String getContactno(){
        return contactno;
    }

    public String getFullname() {

        return fullname;
    }
    public String getAddress() {

        return address;
    }
    public String getAge() {

        return age;
    }
    public String getBloodgroup() {

        return bloodgroup;
    }


}

