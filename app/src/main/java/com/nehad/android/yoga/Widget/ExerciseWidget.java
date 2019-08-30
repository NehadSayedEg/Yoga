package com.nehad.android.yoga.Widget;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.widget.RemoteViews;

import com.nehad.android.yoga.Exercises_List;
import com.nehad.android.yoga.R;

import io.paperdb.Paper;

public class ExerciseWidget extends AppWidgetProvider {

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        for (int appWidgetId : appWidgetIds) {
            Intent intent = new Intent(context, Exercises_List.class);
            PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, intent, 0);

            RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.exercise_widget);
            views.setOnClickPendingIntent(R.id.widget_btn, pendingIntent);

            appWidgetManager.updateAppWidget(appWidgetId, views);
        }
    }
}

