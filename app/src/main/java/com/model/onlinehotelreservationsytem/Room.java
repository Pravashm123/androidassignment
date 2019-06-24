package com.model.onlinehotelreservationsytem;

public class Room {
    private String _id;
    private String desc;
    private String price;
    private String bedtype;
    private String roomtype;
    private String image;

    @Override
    public String toString() {
        return "Room{" +
                "_id='" + _id + '\'' +
                ", desc='" + desc + '\'' +
                ", price='" + price + '\'' +
                ", bedtype='" + bedtype + '\'' +
                ", roomtype='" + roomtype + '\'' +
                ", image='" + image + '\'' +
                '}';
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }




    public Room(String desc, String price, String bedtype, String image, String roomtype) {
        this.desc = desc;
        this.price = price;
        this.bedtype = bedtype;
        this.image = image;
        this.roomtype = roomtype;
    }






    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getBedtype() {
        return bedtype;
    }

    public void setBedtype(String bedtype) {
        this.bedtype = bedtype;
    }

    public String getRoomtype() {
        return roomtype;
    }

    public void setRoomtype(String roomtype) {
        this.roomtype = roomtype;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

}
