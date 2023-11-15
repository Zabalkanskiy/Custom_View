package com.example.customlayout

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

class CustomButton @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {
    private val paint = Paint()
    private val textPaint = Paint()
    private var customText: String? = null
    private var customTextColor: Int = Color.BLACK

    init {
        val typedArray = context.obtainStyledAttributes(attrs, R.styleable.CustomButton, defStyleAttr, 0)
        customText = typedArray.getString(R.styleable.CustomButton_customText)
        customTextColor = typedArray.getColor(R.styleable.CustomButton_customTextColor, Color.BLACK)
        typedArray.recycle()
    }


    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        paint.color = Color.RED
        paint.style = Paint.Style.FILL

        textPaint.apply { textAlign = Paint.Align.CENTER
        color = Color.BLACK
            textSize = 40f
        }

        val xPos = width/2
        val yPos = ((height/2) - ((textPaint.descent() + textPaint.ascent())/2) )


        canvas.drawCircle(width/2f, height /2f, 100f, paint)
        if (customText != null){

            canvas.drawText(customText!!, xPos.toFloat(), yPos, textPaint )
        }
    }



}