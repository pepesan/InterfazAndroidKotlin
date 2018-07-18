package com.cursosdedesarrollo.interfazandroidkotlin

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity

import kotlinx.android.synthetic.main.activity_notificaciones.*
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.support.v4.app.NotificationCompat

import android.view.View
import android.app.NotificationChannel
import android.graphics.Color
import android.os.Build


class NotificacionesActivity : AppCompatActivity() {
    var numMessages = 0
    private lateinit var mNotifyMgr: NotificationManager
    var channelName: String = ""
    val NOTIFICATION_CHANNEL_ID = "4565"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notificaciones)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        mNotifyMgr = getSystemService(NOTIFICATION_SERVICE) as NotificationManager
        channelName = "Mi Canal de Notificaciones"
        createNotificationChannel()
        borraNotificacion()
    }
    fun createNotificationChannel(){
        if (Build.VERSION.SDK_INT < 26) {
            return;
        }

        //Notification Channel
        val importance = NotificationManager.IMPORTANCE_LOW
        val notificationChannel = NotificationChannel(NOTIFICATION_CHANNEL_ID, channelName, importance)
        notificationChannel.enableLights(true)
        notificationChannel.lightColor = Color.RED
        notificationChannel.enableVibration(true)
        notificationChannel.vibrationPattern = longArrayOf(100, 200, 300, 400, 500, 400, 300, 200, 400)
        notificationChannel.setDescription("Channel description");
        mNotifyMgr.createNotificationChannel(notificationChannel);
    }

    fun lanza(v: View) {

        val mBuilder = NotificationCompat.Builder(applicationContext,channelName)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle("Mi notificación")
                .setContentText("Hola Mundo!")
                .setChannelId(NOTIFICATION_CHANNEL_ID)
        val resultIntent = Intent(
                applicationContext,
                MainActivity::class.java)
        val resultPendingIntent = PendingIntent.getActivity(
                applicationContext,
                0,
                resultIntent,
                PendingIntent.FLAG_UPDATE_CURRENT
        )
        mBuilder.setContentIntent(resultPendingIntent)
        // Sets an ID for the notification
        val mNotificationId = 1

        // Builds the notification and issues it.
        mNotifyMgr.notify(mNotificationId, mBuilder.build())
    }

    fun cambia(v: View) {

        val mNotifyBuilder = NotificationCompat.Builder(this,channelName)
                .setContentTitle("Nuevo Mensaje")
                .setContentText("Tienes mensajes nuevos!")
                .setSmallIcon(R.mipmap.ic_launcher)
                .setChannelId(NOTIFICATION_CHANNEL_ID)

        // Start of a loop that processes data and then notifies the user
        val currentText = "Texto"
        mNotifyBuilder.setContentText(currentText)
                .setNumber(++numMessages)
        val resultIntent = Intent(this, MainActivity::class.java)
        val resultPendingIntent = PendingIntent.getActivity(
                this,
                0,
                resultIntent,
                PendingIntent.FLAG_UPDATE_CURRENT
        )
        mNotifyBuilder.setContentIntent(resultPendingIntent)
        // Sets an ID for the notification, so it can be updated
        val notifyID = 1
        // Because the ID remains unchanged, the existing notification is
        // updated.
        mNotifyMgr.notify(
                notifyID,
                mNotifyBuilder.build())
    }

    fun borraNotificacion() {
        val notifyID = 1
        mNotifyMgr.cancel(notifyID)
    }

    fun borra(v: View) {
        borraNotificacion()
    }


}
