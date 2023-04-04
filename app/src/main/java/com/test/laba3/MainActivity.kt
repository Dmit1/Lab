package com.test.laba3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import com.test.laba3.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), MainScreenView {
    private lateinit var vBinding: ActivityMainBinding
    private var presenter: MainScreenPresenter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        presenter = MainScreenPresenterImpl()
        presenter?.setView(this)
        vBinding = ActivityMainBinding.inflate(LayoutInflater.from(this))

        setContentView(vBinding.root)
        super.onCreate(savedInstanceState)

        vBinding.num0.setOnClickListener {presenter?.addEvent(Event.Number(0)) }
        vBinding.num1.setOnClickListener {presenter?.addEvent(Event.Number(1)) }
        vBinding.num2.setOnClickListener {presenter?.addEvent(Event.Number(2)) }
        vBinding.num3.setOnClickListener { presenter?.addEvent(Event.Number(3)) }
        vBinding.num4.setOnClickListener { presenter?.addEvent(Event.Number(4)) }
        vBinding.num5.setOnClickListener { presenter?.addEvent(Event.Number(5)) }
        vBinding.num6.setOnClickListener { presenter?.addEvent(Event.Number(6)) }
        vBinding.num7.setOnClickListener { presenter?.addEvent(Event.Number(7)) }
        vBinding.num8.setOnClickListener { presenter?.addEvent(Event.Number(8)) }
        vBinding.num9.setOnClickListener {presenter?.addEvent(Event.Number(9)) }

        vBinding.actDiv.setOnClickListener {presenter?.addEvent(Event.Action.Divide) }
        vBinding.actEq.setOnClickListener {presenter?.addEvent(Event.Action.Equals) }
        vBinding.actMinus.setOnClickListener {presenter?.addEvent(Event.Action.Minus) }
        vBinding.actPlus.setOnClickListener {presenter?.addEvent(Event.Action.Plus) }
        vBinding.actMulti.setOnClickListener {presenter?.addEvent(Event.Action.Multiply) }

        vBinding.clear.setOnClickListener { presenter?.reset() }
    }
    override fun printResult(result: Int) {
        vBinding.txtResult.text = result.toString()
    }

    override fun printEvents(events: List<Event>) {
        val fullHistoryString = events.joinToString(separator = " ") { event ->
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
