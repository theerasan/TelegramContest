package org.telegram.drop;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.view.View;

import org.telegram.messenger.AndroidUtilities;

public class ProfileDrop {

    private static Paint paint;

    public static void drawDrop(Canvas canvas, float w, float h, View avatarContainer) {
        if (paint == null) {
            paint = new Paint();
            paint.setColor(Color.BLACK);
            paint.setAntiAlias(true);
            paint.setStyle(Paint.Style.FILL);
        }

        float inset = AndroidUtilities.dp(0);
        float radius = Math.min(AndroidUtilities.dp(62), ((avatarContainer.getMeasuredWidth() * avatarContainer.getScaleX()) / 2) - inset);
        float centerX = w / 2 + inset;
        float centerY = avatarContainer.getY() + radius + inset;

        if (avatarContainer.getScaleY() < 1.2f) {
            // draw a circle behind the avatar
            canvas.drawCircle(centerX, centerY, radius, paint);
        }
        if (avatarContainer.getScaleY() < 1.1f) {
            float step = (1.1f - avatarContainer.getScaleY()) / 1.1f;
            // Ripple path
            Path path = new Path();
            if (avatarContainer.getY() > 0) {
                float y = 40 - avatarContainer.getY();
                path.moveTo(centerX - radius, 0);
                path.cubicTo(centerX - (radius / 2), 0, centerX - (radius / 2), y, centerX, y);
                path.cubicTo(centerX + (radius / 2), y, centerX + (radius / 2), 0, centerX + radius, 0);
            } else {
                float previousY = 0f;
                previousY = Math.max(previousY, 40 - avatarContainer.getY());
                float newY = avatarContainer.getY() + avatarContainer.getMeasuredHeight() * avatarContainer.getScaleY();
                float factor = Math.min((step - 0.2f) / (0.5f - 0.2f), 1);
                float y = AndroidUtilities.lerp(previousY, newY, factor);
                float r = AndroidUtilities.lerp(radius, radius * 2, factor);
                float leftX = AndroidUtilities.lerp(centerX - (radius / 2), centerX - (r / 2), factor);
                float rightX = AndroidUtilities.lerp(centerX + (radius / 2), centerX + (r / 2), factor);
                path.moveTo(centerX - r, 0);
                path.cubicTo(leftX, 0, leftX, y, centerX, y);
                path.cubicTo(rightX, y, rightX, 0, centerX + r, 0);
            }
            canvas.drawPath(path, paint);
        }
    }
}
