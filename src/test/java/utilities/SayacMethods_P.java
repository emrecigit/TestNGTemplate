package utilities;

import org.testng.annotations.Test;

import java.time.LocalTime;

public class SayacMethods_P {
    @Test
    public void Sayac(){
        // x saniyelik bir sayac yapalim
        int x=5;
        LocalTime baslangic = LocalTime.now();
        int basSaniye = baslangic.getSecond();
        int saniyeKontrol = 123;
        int bitisSaniyesi = basSaniye+3>60 ? basSaniye+x-60 : basSaniye+x;
        while (bitisSaniyesi!= saniyeKontrol){
            saniyeKontrol = LocalTime.now().getSecond();
        }
        System.out.println("baslangic saniyesi : "+basSaniye);
        System.out.println("saniyeKontrol : "+saniyeKontrol);
    }
}
