package com.test.laba3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import com.test.laba3.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var vBinding: ActivityMainBinding
    private val listEvents = mutableListOf<Event>()
    override fun onCreate(savedInstanceState: Bundle?) {
        vBinding = ActivityMainBinding.inflate(LayoutInflater.from(this))

        setContentView(vBinding.root)
        super.onCreate(savedInstanceState)

        vBinding.num0.setOnClickListener { addEvent(Event.Number(0)) }
        vBinding.num1.setOnClickListener { addEvent(Event.Number(1)) }
        vBinding.num2.setOnClickListener { addEvent(Event.Number(2)) }
        vBinding.num3.setOnClickListener { addEvent(Event.Number(3)) }
        vBinding.num4.setOnClickListener { addEvent(Event.Number(4)) }
        vBinding.num5.setOnClickListener { addEvent(Event.Number(5)) }
        vBinding.num6.setOnClickListener { addEvent(Event.Number(6)) }
        vBinding.num7.setOnClickListener { addEvent(Event.Number(7)) }
        vBinding.num8.setOnClickListener { addEvent(Event.Number(8)) }
        vBinding.num9.setOnClickListener { addEvent(Event.Number(9)) }

        vBinding.actDiv.setOnClickListener { addEvent(Event.Action.Divide) }
        vBinding.actEq.setOnClickListener { addEvent(Event.Action.Equals) }
        vBinding.actMinus.setOnClickListener { addEvent(Event.Action.Minus) }
        vBinding.actPlus.setOnClickListener { addEvent(Event.Action.Plus) }
        vBinding.actMulti.setOnClickListener { addEvent(Event.Action.Multiply) }

        vBinding.clear.setOnClickListener { (clearEvents()) }
    }
    private fun clearEvents() {
        listEvents.clear()
        printAllEvents()
    }
    private fun addEvent(action: Event) {
        if (action == Event.Action.Equals) {
            val result = calculateAllEvents()
            listEvents.clear()
//            listEvents.add(Event.Number(result))
            printResult(result)
        } else {
            listEvents.add(action)
        }
        printAllEvents()
    }

    private fun printResult(result: Int) {
        vBinding.txtResult.text = result.toString()
    }

    private fun calculateAllEvents(): Int {
        var result = 0
        listEvents.forEachIndexed { index, event ->
            if (event is Event.Action) {
                val prevEvent = listEvents[index - 1]
                val nextEvent = listEvents[index + 1]
                val prevNumber = (prevEvent as? Event.Number)?.number ?: 0
                val nextNumber = (prevEvent as? Event.Number)?.number ?: 0
                result = ResultActionManager().processAction(prevNumber, nextNumber, event)
            }
        }
        return result
    }

    private fun printAllEvents() {
        val fullHistoryString = listEvents.joinToString(separator = " ") { event ->
            when (event) {
                is Event.Action -> {
                    EventActionToStringAdapter().toString(event)
                }
                is Event.Number -> {
                    event.number.toString()
                }
            }
        }
        vBinding.txtHistory.text = fullHistoryString
    }
}
