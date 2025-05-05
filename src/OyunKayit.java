import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class OyunKayit {

    public static void oyunKaydet(Kart[][] kartlar ){
        try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("kayit.bin"))){
            System.out.println("oyun kaydediliyor...");

            out.writeObject(kartlar);


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static Kart[][] kayittanAl(){
        try(ObjectInputStream in = new ObjectInputStream(new FileInputStream("kayit.bin"))){

            Kart[][] cikti = (Kart[][]) in.readObject();
            return cikti;

        } catch (IOException ex) {
            Logger.getLogger(OyunKayit.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(OyunKayit.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
