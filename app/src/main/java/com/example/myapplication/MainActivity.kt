package com.example.myapplication

import android.graphics.drawable.ClipDrawable.HORIZONTAL
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.BoringLayout
import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Recycler

class MainActivity : AppCompatActivity() {
    lateinit var parentLayout: LinearLayout;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        parentLayout = findViewById(R.id.parent_layout)

        for (i in 1 .. 100) {
            parentLayout.addView(
                LinearLayout(this).apply {
                    orientation = LinearLayout.HORIZONTAL
                    addView(TextView(this@MainActivity).apply {text = "Text Avtivity"})
                    addView(Button(this@MainActivity).apply {text = "Button"})


                }
            )
        }

    }
    class MainActivityAdapter(val data: List<RecyclerItemData>): RecyclerView.Adapter<MainViewHolder>() {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
            val view = LayoutInflater
                .from((parent.context)).inflate(R.layout.item_main_adapter, parent, false)
            return MainViewHolder(view)
        }

        override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
            val currentItemData = data [position]

            holder.textView.text = currentItemData.text
            holder.button.text = currentItemData.buttonText
        }

        override fun getItemCount() = data.size
    }

    class MainViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView
        val button: Button

        init {
            textView = view.findViewById(R.id.adapterItemTextView)
            button = view.findViewById(R.id.adapterItemTextView)
        }
    }
}