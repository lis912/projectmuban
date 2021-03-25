package com.lishichang.mubanentity;

public class SAGlevel {
    private int S;
    private int A;
    private int G;

    public SAGlevel(int s, int a, int g) {
        S = s; A = a; G = g;
    }
    public SAGlevel(String sag){
        if( sag.contains("三级") ){
            G = 3;
            if (sag.contains("S2")){
                S = 2; A = 3;
            }else if (sag.contains("A2")){
                S = 3; A = 2;
            } else {
                S = 3; A = 3;
            }
        }else if( sag.contains("二级") ){
            S = 2; A = 2; G = 2;
        }else{
            S = 3; A = 3; G = 3;
        }
    }

    public int getS() {
        return S;
    }

    public void setS(int s) {
        S = s;
    }

    public int getA() {
        return A;
    }

    public void setA(int a) {
        A = a;
    }

    public int getG() {
        return G;
    }

    public void setG(int g) {
        G = g;
    }
}
