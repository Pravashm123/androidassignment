package com.model.onlinehotelreservationsytem;

public class Reservation {
    private String firstname;
    private String middlename;
    private String lastname;
    private String roomtype;
    private String contact;
    private String reservedate;
    private String amount;
    private String email;

    @Override
    public String toString() {
        return "Reservation{" +
                "firstname='" + firstname + '\'' +
                ", middlename='" + middlename + '\'' +
                ", lastname='" + lastname + '\'' +
                ", roomtype='" + roomtype + '\'' +
                ", contact='" + contact + '\'' +
                ", reservedate='" + reservedate + '\'' +
                ", amount='" + amount + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getMiddlename() {
        return middlename;
    }

    public void setMiddlename(String middlename) {
        this.middlename = middlename;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getRoomtype() {
        return roomtype;
    }

    public void setRoomtype(String roomtype) {
        this.roomtype = roomtype;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getReservedate() {
        return reservedate;
    }

    public void setReservedate(String reservedate) {
        this.reservedate = reservedate;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Reservation(String firstname, String middlename, String lastname, String roomtype, String contact, String reservedate, String amount, String email) {
        this.firstname = firstname;
        this.middlename = middlename;
        this.lastname = lastname;
        this.roomtype = roomtype;
        this.contact = contact;
        this.reservedate = reservedate;
        this.amount = amount;
        this.email = email;
    }
}

