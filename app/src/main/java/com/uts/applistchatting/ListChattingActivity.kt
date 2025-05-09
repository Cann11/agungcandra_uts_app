package com.uts.applistchatting
import android.os.Bundle
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity

class ListChattingActivity : AppCompatActivity() {

    private lateinit var listView: ListView
    private lateinit var productList: List<Product>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_chatting)

        listView = findViewById(R.id.listView)

        // Contoh data produk
        productList = listOf(
            Product(R.drawable.bw, "Product 1", "Willy Cardy Crop Kancing", 35.000, "https://vt.tokopedia.com/t/ZShDBDecF/"),
            Product(R.drawable.burgandi, "Product 2", "Cardigan Belle Rajut Wanita Panjang", 47.000, "https://vt.tokopedia.com/t/ZShDB22Yt/"),
            Product(R.drawable.kriwil, "Product 3", "Daisy Curly Inner Rajut", 35.000, "https://vt.tokopedia.com/t/ZShDB9rbV/"),
            Product(R.drawable.kulot, "Product 3", "Celana Kulot Tali Rajut", 33.000, "https://vt.tokopedia.com/t/ZShDBm6B1/")
        )

        // Menghubungkan ListView dengan adapter
        val adapter = CustomAdapter(this, productList)
        listView.adapter = adapter
    }
}
