package android.jplas.gamingapp;

public class ShopItem {
    public static final int MOUSE = 0;
    public static final int KEYBOARD = 1;
    public static final int HEADPHONE = 2;

    private String nama;
    private int type;
    private int satuan;
    private int jumlah;

    public ShopItem(String nama, int type, int satuan){
        this.nama = nama;
        this.type = type;
        this.satuan = satuan;
        this.jumlah = calculate();
    }

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


}