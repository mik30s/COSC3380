package tarleton.lab11

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.RelativeLayout
import android.widget.TextView
import java.lang.Integer.parseInt

class MainActivity : AppCompatActivity() {

    fun evaluate(s:String):String {
        val nums = s.split("(+|-|/|x)").map{x -> parseInt(x)}
        val ops = s.filter { c: Char -> c in "${0..9}" }
        val ans = ArrayList<Int>()
        val i = -1
        for(op in ops) {
            i.inc()
            ans.add(when(op){
                '+' ->  nums[i] + nums[i+1]
                'x' ->  nums[i] * nums[i+1]
                '/' ->  nums[i] / nums[i+1]
                '-' ->  nums[i] - nums[i+1]
                else -> 0
            })
        }
        return ""+ans.get(0)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val answerText = findViewById<TextView>(R.id.textView2)
        listOf(
            findViewById<Button>(R.id.oneBtn),
            findViewById<Button>(R.id.twoBtn),
            findViewById<Button>(R.id.button3),
            findViewById<Button>(R.id.button4),
            findViewById<Button>(R.id.button5),
            findViewById<Button>(R.id.button6),
            findViewById<Button>(R.id.button7),
            findViewById<Button>(R.id.button8),
            findViewById<Button>(R.id.button9),
            findViewById<Button>(R.id.button0),
            findViewById<Button>(R.id.addButton),
            findViewById<Button>(R.id.mulButton),
            findViewById<Button>(R.id.divButton),
            findViewById<Button>(R.id.subButton),
            findViewById<Button>(R.id.eqButton)
        ).map {
            v:Button ->
                v.setOnClickListener({
                    _: View? ->
                    answerText.text = when(v.text) {
                        "=" -> evaluate(answerText.text as String)
                        else -> "${answerText.text}${v.text}"
                    }
                })
        }
    }

}
