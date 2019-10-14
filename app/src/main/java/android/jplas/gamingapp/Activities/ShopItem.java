package android.jplas.gamingapp.Activities;

import android.os.Parcel;
import android.os.Parcelable;

public class ShopItem implements Parcelable {
    public static final int MOUSE = 0;
    public static final int KEYBOARD = 1;
    public static final int HEADPHONE = 2;

    private String nama;
    private int type;
    private int satuan;
    private int jumlah;

    public String getNama() {
        return nama;
    }

    public int getType() {
        return type;
    }

    public int getSatuan() {
        return satuan;
    }



    public ShopItem(String nama, int type, int satuan){
        this.nama = nama;
        this.type = type;
        this.satuan = satuan;
        this.jumlah = calculate();
    }

    protected ShopItem(Parcel in) {
        nama = in.readString();
        type = in.readInt();
        satuan = in.readInt();
        jumlah = in.readInt();
    }

    public static final Creator<ShopItem> CREATOR = new Creator<ShopItem>() {
        @Override
        public ShopItem createFromParcel(Parcel in) {
            return new ShopItem(in);
        }

        @Override
        public ShopItem[] newArray(int size) {
            return new ShopItem[size];
        }
    };

    public int getJumlah(){
        return jumlah;
    }

    private int calculate(){
        switch (type){
            case MOUSE: return satuan * 650000;
            case KEYBOARD: return satuan * 2000000;
            case HEADPHONE: return satuan * 1400000;
            default: return 0;
        }
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(nama);
        parcel.writeInt(type);
        parcel.writeInt(satuan);
        parcel.writeInt(jumlah);
    }
}