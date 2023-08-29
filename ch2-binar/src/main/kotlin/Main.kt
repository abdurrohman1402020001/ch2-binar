/////Abdurrohmannn
class MenuMakanan {
    // Data class untuk menyimpan informasi menu
    data class ItemMenu(val nama: String, val harga: Int)

    // Daftar menu makanan beserta harga
    val daftarMenu = listOf(
        ItemMenu("Ayam Bakar", 50000),
        ItemMenu("Ayam Goreng", 40000),
        ItemMenu("Ayam Geprek", 40000),
        ItemMenu("Kulit Ayam Crispy", 15000),
        ItemMenu("Sate Usus Ayam", 5000)
    )
}

class ProsesPesanan(private val menu: MenuMakanan) {
    // Tampilin daftar menu lezat dengan harganya
    fun tampilMenu() {
        println("Cek nih menu enak-enak:")
        menu.daftarMenu.forEachIndexed { index, item ->
            println("${index + 1}. ${item.nama} = Rp ${item.harga} per porsi")
        }
    }

    // Tanya-tanya mau pilih menu yang mana
    fun pilihMenu(): Int {
        println("Pilih menu makanan (ketik nomornya):")
        return readLine()?.toIntOrNull() ?: 0
    }

    // Tampilin menu yang dipilih
    fun tampilMenuTerpilih(indexMenuTerpilih: Int) {
        val menuTerpilih = menu.daftarMenu.getOrNull(indexMenuTerpilih - 1)
        menuTerpilih?.let {
            println("Pilihanmu: ${it.nama} = Rp ${it.harga} per porsi")
        } ?: println("Menu tidak valid.")
    }

    // Masukkan jumlah pembayaran
    fun masukkanPembayaran(): Int {
        println("Masukkan jumlah pembayaran:")
        return readLine()?.toIntOrNull() ?: 0
    }

    // Proses pembayaran dan mengembalikan status
    fun prosesPembayaran(totalHarga: Int, pembayaran: Int): Boolean {
        return pembayaran >= totalHarga
    }

    // Tampilin hasil pembayaran
    fun tampilHasilPembayaran(statusPembayaran: Boolean) {
        if (statusPembayaran) {
            println("Makasih banyak! Pesanan makananmu sudah tercatat!")
        } else {
            println("Maaf, pembayaran gagal!")
        }
    }

    // Pilih metode pengiriman
    fun pilihMetodePengiriman(): Int {
        println("Metode Pengiriman Makanan:")
        println("1. Bawa Pulang")
        println("2. Antar")
        return readLine()?.toIntOrNull() ?: 0
    }

    // Proses metode pengiriman yang dipilih
    fun prosesMetodePengiriman(metodePengiriman: Int) {
        when (metodePengiriman) {
            1 -> {
                println("Makanannya lagi dimasak...")
                Thread.sleep(5000)
                println("Makananmu udah siap! Silakan ambil di resto ya!")
                Thread.sleep(5000)
                println("Pesanan selesai!")
                Thread.sleep(3000)
            }
            2 -> {
                println("Makanannya lagi dimasak...")
                Thread.sleep(5000)
                println("Makananmu udah siap! Driver segera meluncur!")
                Thread.sleep(5000)
                println("Driver sampe! Pesanan selesai!")
                Thread.sleep(3000)
            }
            else -> println("Metode pengiriman tidak valid.")
        }
    }
}

fun main() {
    val menu = MenuMakanan()
    val prosesPesanan = ProsesPesanan(menu)

    // Tampilan awal: Daftar menu makanan
    prosesPesanan.tampilMenu()

    // Memilih menu makanan
    val indexMenuTerpilih = prosesPesanan.pilihMenu()
    prosesPesanan.tampilMenuTerpilih(indexMenuTerpilih)

    // Memasukkan pembayaran
    val pembayaran = prosesPesanan.masukkanPembayaran()
    val totalHarga = menu.daftarMenu.getOrNull(indexMenuTerpilih - 1)?.harga ?: 0

    // Proses pembayaran dan menampilkan hasilnya
    val statusPembayaran = prosesPesanan.prosesPembayaran(totalHarga, pembayaran)
    prosesPesanan.tampilHasilPembayaran(statusPembayaran)

    // Memilih metode pengiriman
    val metodePengiriman = prosesPesanan.pilihMetodePengiriman()

    // Memproses metode pengiriman yang dipilih
    prosesPesanan.prosesMetodePengiriman(metodePengiriman)

    // Pesan terima kasih setelah selesai memesan
    println("Selamat menikmati makanannya! Terima kasih sudah mampir:)!")
}
