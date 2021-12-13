package com.example.bd_bay_list;

public class State {

    private String PRODUCT;
    private final String DATE;
    private final String COL;
    private final String COST;


    public State(String PRODUCT,String DATE,String COL,String COST){
        this.PRODUCT = PRODUCT;
        this.DATE = DATE;
        this.COL = COL;
        this.COST = COST;
    }

    public String getPRODUCT() {
        return this.PRODUCT;
    }
    public String getDATE(){return this.DATE;}

    public String getCOL(){return this.COL;}

    public String getCOST(){return this.COST;}

    public void setName(String PRODUCT) {
        this.PRODUCT = PRODUCT;
    }

}
//("PRODUCT " + PRODUCT +
//        "\n COL "  + COL +
//        "\n TYPE " + TYPE +
//        "\n COST " + COST +
//        "\n CATEGORY" + CATEGORY+"\n" )