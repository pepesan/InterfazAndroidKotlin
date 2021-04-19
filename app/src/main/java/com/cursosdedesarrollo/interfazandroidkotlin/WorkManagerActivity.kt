package com.cursosdedesarrollo.interfazandroidkotlin

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.work.*
import com.example.workmanagerkotlin.ImageDownloadWorker
import com.example.workmanagerkotlin.ImageDownloadedEvent
import com.squareup.picasso.Picasso
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode
import java.io.File

class WorkManagerActivity : AppCompatActivity() {
    var iv_1: ImageView? = null
    var iv_2: ImageView? = null
    var iv_3: ImageView? = null


    val jsonString: String = "[\n" +
            "  {\n" +
            "    \"albumId\": 1,\n" +
            "    \"id\": 1,\n" +
            "    \"title\": \"200x300\",\n" +
            "    \"url\": \"https://www.fillmurray.com/200/300\",\n" +
            "    \"thumbnailUrl\": \"https://via.placeholder.com/150/92c952\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"albumId\": 1,\n" +
            "    \"id\": 2,\n" +
            "    \"title\": \"200x300\",\n" +
            "    \"url\": \"https://www.fillmurray.com/200/300\",\n" +
            "    \"thumbnailUrl\": \"https://via.placeholder.com/150/771796\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"albumId\": 1,\n" +
            "    \"id\": 3,\n" +
            "    \"title\": \"200x300g\",\n" +
            "    \"url\": \"https://fillmurray.com/g/200/300\",\n" +
            "    \"thumbnailUrl\": \"https://via.placeholder.com/150/24f355\"\n" +
            "  }]"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_work_manager)
        val constraints = Constraints.Builder()
            .setRequiresCharging(true)
            .build()

        var request = OneTimeWorkRequestBuilder<MyWork>()
            .setConstraints(constraints)
            .build()


        findViewById<Button>(R.id.btnClick).setOnClickListener {

            WorkManager.getInstance().enqueue(request)
        }

        WorkManager.getInstance().getWorkInfoByIdLiveData(request.id)
            .observe(this, Observer {

                val status: String = it.state.name
                Toast.makeText(this,status, Toast.LENGTH_SHORT).show()
            })
        iv_1 = findViewById(R.id.iv_1)
        iv_2 = findViewById(R.id.iv_2)
        iv_3 = findViewById(R.id.iv_3)
        findViewById<Button>(R.id.btn_download).setOnClickListener {
            startWorker()
        }

    }
    private fun startWorker() {
        val data = Data.Builder()
                .putString("images", jsonString)
                .build()

        val constraints = Constraints.Builder()
                .setRequiredNetworkType(NetworkType.CONNECTED)

        val oneTimeRequest = OneTimeWorkRequest.Builder(ImageDownloadWorker::class.java)
                .setInputData(data)
                .setConstraints(constraints.build())
                .addTag("demo")
                .build()

        Toast.makeText(this, "Starting worker", Toast.LENGTH_SHORT).show()

        WorkManager.getInstance()
                .enqueueUniqueWork("AndroidVille", ExistingWorkPolicy.KEEP, oneTimeRequest)
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onEvent(imageDownloadedEvent: ImageDownloadedEvent) {
        val file = File("${imageDownloadedEvent.path}/${imageDownloadedEvent.name}")
        when (imageDownloadedEvent.id) {
            "1" -> Picasso.get().load(file).into(iv_1)
            "2" -> Picasso.get().load(file).into(iv_2)
            "3" -> Picasso.get().load(file).into(iv_3)
        }
    }

    override fun onStart() {
        super.onStart()
        EventBus.getDefault().register(this)
    }

    override fun onStop() {
        super.onStop()
        EventBus.getDefault().unregister(this)
    }

}