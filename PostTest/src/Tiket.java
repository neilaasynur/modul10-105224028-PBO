public class Tiket {
    String namaPemesan; 
    Film judulFilm;
    String noKursi;
    
    public Tiket(String namaPemesan, Film judulFilm, String noKursi){
        this.namaPemesan = namaPemesan;
        this.judulFilm = judulFilm;
        this.noKursi = noKursi;
    }

    public void cetakTiket(){
        System.out.println("Nama: " + namaPemesan);
        System.out.println("Judul Film: " + judulFilm);
        System.out.println("No.Kursi: " + noKursi);
        System.out.println("Harga: Rp" + judulFilm.harga);
    }
}
