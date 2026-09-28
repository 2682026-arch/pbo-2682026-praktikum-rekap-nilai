import java.util.Scanner;

public class RekapNilai {
    static final int SELESAI = -1;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int nomor = 1;
        int jumlahNilai = 0;
        double total = 0;

        System.out.println("===== REKAP NILAI KELAS =====");
        System.out.println("Ketik -1 kalau sudah selesai.");

        // do-while lebih pas karena nilai pertama memang harus diminta dulu sebelum kondisi diperiksa.
        int nilai;
        do {
            System.out.print("Nilai ke-" + nomor + " : ");
            nilai = input.nextInt();

            if (nilai == SELESAI) {
                break;
            }

            if (nilai < 0 || nilai > 100) {
                System.out.println("  ditolak — nilai harus 0..100");
                continue;
            }

            char grade;

            if (nilai >= 90) {
                grade = 'A';
            } else if (nilai >= 80) {
                grade = 'B';
            } else if (nilai >= 70) {
                grade = 'C';
            } else if (nilai >= 60) {
                grade = 'D';
            } else {
                grade = 'E';
            }

            String keterangan = switch (grade) {
                case 'A' -> "Sangat Baik";
                case 'B' -> "Baik";
                case 'C' -> "Cukup";
                case 'D' -> "Kurang";
                default -> "Tidak Lulus";
            };

            System.out.println("  Grade " + grade + " — " + keterangan);

            total += nilai;
            jumlahNilai++;
            nomor++;

        } while (nilai != SELESAI);

        System.out.println();

        System.out.println("Nilai sah   : " + jumlahNilai);

        if (jumlahNilai > 0) {
            double rata = total / jumlahNilai;
            String rataFormatted = String.format("%.2f", rata);
            String status = rata >= 60 ? "LULUS" : "TIDAK LULUS";

            System.out.println("Rata-rata   : " + rataFormatted);
            System.out.println("Status      : " + status);
        } else {
            System.out.println("Rata-rata   : 0,00");
            System.out.println("Status      : TIDAK LULUS");
        }

        input.close();
    }
}
