package org.xiangbalao.org.xiangbalao.utils;

import android.annotation.TargetApi;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;

import java.util.UUID;


/**
 * Created by daxiong on 2015/8/7.
 */
public class NotificationUtils {

    /**
     * @param context
     * @param intent
     * @param icon
     * @param title
     * @param text
     * @param nunber
     * @param notification_flag FLAG_AUTO_CANCEL  该通知能被状态栏的清除按钮给清除掉
     *                          FLAG_NO_CLEAR     该通知能被状态栏的清除按钮给清除掉
     *                          FLAG_ONGOING_EVENT 通知放置在正在运行
     *                          FLAG_INSISTENT 是否一直进行，比如音乐一直播放，知道用户响应
     * @return
     */
    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    public static Notification getNotification(Context context, long when,Intent intent, int icon,
                                               String title, String text,String ticker,
                                               int nunber, int notification_flag) {
        int sdkInt = Build.VERSION.SDK_INT;
        PendingIntent pendingIntent = PendingIntent.getActivity(context, UUID.randomUUID().hashCode(),
                intent, 0);
        Notification notify = null;
        if (sdkInt > 15) {
            // 通过Notification.Builder来创建通知，注意API Level
            // API16之后才支持
            notify = new Notification.Builder(context)
                    .setSmallIcon(icon)
                    .setTicker(ticker)
                    .setContentTitle(title)
                    .setContentText(text)
                    .setPriority(Notification.PRIORITY_DEFAULT) //设置该通知优先级
                    .setContentIntent(pendingIntent)
                    .setNumber(nunber)
                    .setWhen(when)
                    .build(); // 需要注意build()是在API
            // level16及之后增加的，API11可以使用getNotificatin()来替代
        } else if (sdkInt < 16 && sdkInt > 10) {
            // 通过Notification.Builder来创建通知，注意API Level
            // API11之后才支持
            notify = new Notification.Builder(context)
                    .setSmallIcon(icon) // 设置状态栏中的小图片，尺寸一般建议在24×24，这个图片同样也是在下拉状态栏中所显示，如果在那里需要更换更大的图片，可以使用setLargeIcon(Bitmap
                            // icon)
                    .setTicker(ticker)// 设置在status
                            // bar上显示的提示文字
                    .setContentTitle(title)// 设置在下拉status
                            // bar后Activity，本例子中的NotififyMessage的TextView中显示的标题
                    .setContentText(text)// TextView中显示的详细内容
                    .setContentIntent(pendingIntent) // 关联PendingIntent
                    .setNumber(nunber) // 在TextView的右方显示的数字，可放大图片看，在最右侧。这个number同时也起到一个序列号的左右，如果多个触发多个通知（同一ID），可以指定显示哪一个。
                    .setWhen(when)
                    .getNotification(); // 需要注意build()是在API level
            // 16及之后增加的，在API11中可以使用getNotificatin()来代替
        } else {//已废弃，不过兼容所有版本的通知
            // 在Android进行通知处理，首先需要重系统哪里获得通知管理器NotificationManager，它是一个系统Service。
            // 创建一个PendingIntent，和Intent类似，不同的是由于不是马上调用，需要在下拉状态条出发的activity，所以采用的是PendingIntent,即点击Notification跳转启动到哪个Activity
            // 下面需兼容Android 2.x版本是的处理方式
            notify = new Notification();
            notify.icon = icon;
            notify.tickerText = ticker;
            notify.when = when;
            notify.setLatestEventInfo(context, title,
                    text, pendingIntent);
            notify.number = nunber;
            // 通过通知管理器来发起通知。如果id不同，则每click，在statubar那里增加一个提示
        }
        notify.flags |= Notification.FLAG_AUTO_CANCEL;
        notify.flags |= notification_flag; // FLAG_AUTO_CANCEL表明当通知被用户点击时，通知将被清除。
        return notify;
    }

    /**
     * 优选版本通知发送
     *
     * @param context
     * @param intent
     * @param icon              设置通知栏icon
     * @param title             设置通知栏标题
     * @param text              设置通知栏内容
     * @param nunber            设置通知集合的数量
     * @param notificationFlag
     * @param notificationId
     */
    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    public static void sendNotification(Context context, Intent intent, int icon, String title,
                                        String text, String ticker,int nunber, int notificationFlag,int notificationId ) {
        NotificationManager manager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        int sdkInt = Build.VERSION.SDK_INT;
        PendingIntent pendingIntent = PendingIntent.getActivity(context, UUID.randomUUID().hashCode(),
                intent, 0);
        Notification notify = null;
        if (sdkInt > 15) {
            // 通过Notification.Builder来创建通知，注意API Level
            // API16之后才支持
            notify = new Notification.Builder(context)
                    .setSmallIcon(icon)
                    .setTicker(ticker)
                    .setContentTitle(title)
                    .setContentText(text)
                    .setPriority(Notification.PRIORITY_DEFAULT) //设置该通知优先级
                    .setContentIntent(pendingIntent)
                    .setNumber(nunber)
                    .build(); // 需要注意build()是在API
            // level16及之后增加的，API11可以使用getNotificatin()来替代
        } else if (sdkInt < 16 && sdkInt > 10) {
            // 通过Notification.Builder来创建通知，注意API Level
            // API11之后才支持
            notify = new Notification.Builder(context)
                    .setSmallIcon(icon) // 设置状态栏中的小图片，尺寸一般建议在24×24，这个图片同样也是在下拉状态栏中所显示，如果在那里需要更换更大的图片，可以使用setLargeIcon(Bitmap
                            // icon)
                    .setTicker(ticker)// 设置在status
                            // bar上显示的提示文字
                    .setContentTitle(title)// 设置在下拉status
                            // bar后Activity，本例子中的NotififyMessage的TextView中显示的标题
                    .setContentText(text)// TextView中显示的详细内容
                    .setContentIntent(pendingIntent) // 关联PendingIntent
                    .setNumber(nunber) // 在TextView的右方显示的数字，可放大图片看，在最右侧。这个number同时也起到一个序列号的左右，如果多个触发多个通知（同一ID），可以指定显示哪一个。
                    .getNotification(); // 需要注意build()是在API level
            // 16及之后增加的，在API11中可以使用getNotificatin()来代替
        } else {//已废弃，不过兼容所有版本的通知
            // 在Android进行通知处理，首先需要重系统哪里获得通知管理器NotificationManager，它是一个系统Service。
            // 创建一个PendingIntent，和Intent类似，不同的是由于不是马上调用，需要在下拉状态条出发的activity，所以采用的是PendingIntent,即点击Notification跳转启动到哪个Activity
            // 下面需兼容Android 2.x版本是的处理方式
            notify = new Notification();
            notify.icon = icon;
            notify.tickerText = ticker;
            notify.when = System.currentTimeMillis();
            notify.setLatestEventInfo(context, title,
                    text, pendingIntent);
            notify.number = nunber;
        }
        notify.flags |= Notification.FLAG_AUTO_CANCEL; // FLAG_AUTO_CANCEL表明当通知被用户点击时，通知将被清除。
        notify.flags |= notificationFlag;
        manager.notify(notificationId, notify);// 步骤4：通过通知管理器来发起通知。如果id不同，则每click，在status哪里增加一个提示
    }
}
