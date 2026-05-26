import java.util.*;

class Anggota {
    String idAnggota;
    String nama;
    String tipe;

    public Anggota(String idAnggota, String nama, String tipe){
        this.idAnggota = idAnggota;
        this.nama = nama;
        this.tipe = tipe;
    }

    // public void setTipe (String tipe){
    //     if (tipe.equalsIgnoreCase("Mahasiswa") || tipe.equalsIgnoreCase("Dosen")){
    //         this.tipe = tipe;
    //     }
    // }

    @Override
    public boolean equals (Object o){
        if (this == o){
            return true;
        }
        if (o == null || getClass() != o.getClass()){
            return false;
        }
        Anggota agt = (Anggota) o;
        return Objects.equals(idAnggota, agt.idAnggota);
    }

    public int hashCode(){
        return Objects.hash(idAnggota);
    }
}