package com.cursosdedesarrollo.interfazandroidkotlin

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Intent
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat
import androidx.core.content.ContextCompat.getSystemService

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [NotificationFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class NotificationFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    var numMessages = 0
    private lateinit var mNotifyMgr: NotificationManager
    var channelName: String = ""
    val NOTIFICATION_CHANNEL_ID = "4565"
    var lanza_button : Button? = null
    var cambia_button : Button? = null
    var borra_button : Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val mivista = inflater.inflate(R.layout.fragment_notification, container, false)
        lanza_button =  view?.findViewById<Button>(R.id.button)
        lanza_button?.setOnClickListener{
            val mBuilder = NotificationCompat.Builder(requireContext(),channelName)
                    .setSmallIcon(R.mipmap.ic_launcher)
                    .setContentTitle("Mi notificación")
                    .setContentText("Hola Mundo!")
                    .setChannelId(NOTIFICATION_CHANNEL_ID)
            val resultIntent = Intent(
                    requireContext(),
                    NotificacionesActivity::class.java)
            val resultPendingIntent = PendingIntent.getActivity(
                    requireContext(),
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
        cambia_button =  view?.findViewById<Button>(R.id.button2)
        cambia_button?.setOnClickListener{
            ++numMessages
            val mNotifyBuilder = NotificationCompat.Builder(requireContext(),channelName)
                    .setContentTitle("Nuevo Mensaje")

                    .setContentText("Tienes mensajes "+numMessages+ " nuevos!")
                    .setSmallIcon(R.mipmap.ic_launcher)
                    .setChannelId(NOTIFICATION_CHANNEL_ID)

            // Start of a loop that processes data and then notifies the user
            //val currentText = "Texto"
            //mNotifyBuilder.setContentText(currentText)
            //.setNumber(++numMessages)
            val resultIntent = Intent(requireContext(), MainActivity::class.java)
            val resultPendingIntent = PendingIntent.getActivity(
                    requireContext(),
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
        borra_button =  view?.findViewById<Button>(R.id.button3)
        borra_button?.setOnClickListener{
            borraNotificacion()
        }
        mNotifyMgr = activity?.getSystemService(AppCompatActivity.NOTIFICATION_SERVICE) as NotificationManager
        channelName = "Mi Canal de Notificaciones"
        createNotificationChannel()
        borraNotificacion()
        return mivista
    }

    fun createNotificationChannel(){
        if (Build.VERSION.SDK_INT < 26) {
            return;
        }

        //Notification Channel
        val importance = NotificationManager.IMPORTANCE_LOW
        val notificationChannel = NotificationChannel(
                NOTIFICATION_CHANNEL_ID, channelName, importance)
        notificationChannel.enableLights(true)
        notificationChannel.lightColor = Color.RED
        notificationChannel.enableVibration(true)
        notificationChannel.vibrationPattern = longArrayOf(100, 200, 300, 400, 500, 400, 300, 200, 400)
        notificationChannel.setDescription("Channel description");
        mNotifyMgr.createNotificationChannel(notificationChannel);
    }


    fun borraNotificacion() {
        val notifyID = 1
        mNotifyMgr.cancel(notifyID)
    }

    fun borra(v: View) {
        borraNotificacion()
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment NotificationFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
                NotificationFragment().apply {
                    arguments = Bundle().apply {
                        putString(ARG_PARAM1, param1)
                        putString(ARG_PARAM2, param2)
                    }
                }
    }
}