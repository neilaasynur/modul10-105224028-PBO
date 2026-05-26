import java.util.*;

public class Bioskop {
    public static void main(String[] args) throws Exception {
        Map<String, Film> jadwal = new HashMap<>();
        jadwal.put("J001", new Film("Boboiboy Galaxy The Movie 3", 40000));
        jadwal.put ("J002", new Film("Ejen Ali The Movie 3", 40000));
        jadwal.put ("J003", new Film("Ghost In The Cell", 38000));

        Set<String> kursiPenonton = new HashSet<>();
        List<Tiket> riwayatPesanan = new ArrayList<>();

        pesanFilm("Neila", "J001", "D9", jadwal, kursiPenonton, riwayatPesanan);
        pesanFilm("Elisabeth", "J001", "E12", jadwal, kursiPenonton, riwayatPesanan);
        pesanFilm("Iyaa", "J002", "D10", jadwal, kursiPenonton, riwayatPesanan);
        pesanFilm("Jodie", "J003", "G11", jadwal, kursiPenonton, riwayatPesanan);

        for (Tiket listPesanan : riwayatPesanan) {
            listPesanan.cetakTiket();
        }
    }

    public static void pesanFilm(String nama, String kodeFilm, String kursi, Map<String, Film> jadwal, Set<String> kursiTerpesan, List<Tiket> riwayat) {
        if (!jadwal.containsKey(kodeFilm)) {
            System.out.println("Kode film " + kodeFilm + " tidak valid!");
            return;
        }

        Film filmPilihan = jadwal.get(kodeFilm);

        if (!kursiTerpesan.add(kursi)) {
            System.out.println("Kursi " + kursi + " sudah dipesan untuk film " + filmPilihan.judulFilm);
            return;
        }

        Tiket pesananBaru = new Tiket(nama, filmPilihan, kursi);
        riwayat.add(pesananBaru);
        System.out.println("Berhasil memesan kursi " + kursi + " untuk film " + filmPilihan.judulFilm);
    }
}
