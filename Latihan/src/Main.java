import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Map<String, Buku> katalogBuku = new HashMap<>();

        katalogBuku.put("1234567890", new Buku("1234567890", "Pemrograman Berorientasi"));
        katalogBuku.put("223344556677", new Buku ("223344556677", "Jaringan Komputer"));
        katalogBuku.put("123123456", new Buku ("123123456", "Basis Data"));  
        
        Set<Anggota> kumpulanAnggota = new HashSet<>();

        kumpulanAnggota.add(new Anggota("ID001", "Neila Asynur","Dosen"));
        kumpulanAnggota.add(new Anggota("ID002", "Elisabeth","Mahasiswa"));
        kumpulanAnggota.add(new Anggota("ID003", "Zakiati","Mahasiswa"));
        kumpulanAnggota.add(new Anggota("ID001", "Fatin","Mahasiswa"));

        System.out.println("Jumlah Anggota yang unik: " + kumpulanAnggota.size());

        LinkedList<String> antrian = new LinkedList<>();

        List<String[]> antreanPeminjaman = new ArrayList<>();
        antreanPeminjaman.add(new String[] {"ID002", "1234567890", "Mahasiswa"});
        antreanPeminjaman.add(new String[] {"ID001", "223344556677", "Dosen"});
        antreanPeminjaman.add(new String[] {"ID003", "123123456", "Dosen"});
        antreanPeminjaman.add(new String[] {"ID001", "123123456", "Dosen"});

        for (String[] data : antreanPeminjaman){
            String idAnggota = data[0];
            String isbn = data[1];
            String tipe = data[2];
            String entry = idAnggota + "#" + isbn;

            if (tipe.equals("Dosen")){
                antrian.addFirst(entry);
            } else if (tipe.equals("Mahasiswa")) {
                antrian.addLast(entry);
            }
        }

        for (int i = 0; i < antrian.size(); i++){
            System.out.println((i  +1) + ". " + antrian.get(i));
        }

        List<Buku> bukuSedangDipinjam = new ArrayList<>();
        while (!antrian.isEmpty()){
            String dataPeminjaman = antrian.removeFirst();
            String[] bagian  = dataPeminjaman.split("#");
            String idAnggota = bagian[0];
            String isbn      = bagian[1];

            boolean isAnggotaValid = false;
            String namaAnggota = "";
            for (Anggota anggota : kumpulanAnggota) {
                if (anggota.idAnggota.equals(idAnggota)) {
                    isAnggotaValid = true;
                    namaAnggota = anggota.nama;
                    break;
                }
            }

            boolean isBukuValid = katalogBuku.containsKey(isbn);

            boolean isSedangDipinjam = false;
            for (Buku b : bukuSedangDipinjam) {
                if (b.isbn.equals(isbn)) {
                    isSedangDipinjam = true;
                    break;
                }
            }

            if (!isAnggotaValid) {
                System.out.println("Gagal: Anggota dengan ID (" + idAnggota + ") tidak terdaftar.");
            } else if (!isBukuValid) {
                System.out.println("Gagal: Buku dengan ISBN (" + isbn + ") tidak ditemukan di katalog.");
            } else if (isSedangDipinjam) {
                System.out.println("Gagal: Buku '" + katalogBuku.get(isbn).judul + "' sedang dipinjam oleh orang lain.");
            } else {
                Buku bukuDipinjam = katalogBuku.get(isbn);
                bukuSedangDipinjam.add(bukuDipinjam);
                System.out.println("Berhasil: " + namaAnggota + " meminjam buku '" + bukuDipinjam.judul + "'.");
            }
        }
    }
}
