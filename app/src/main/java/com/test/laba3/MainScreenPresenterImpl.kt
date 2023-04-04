package com.test.laba3

class MainScreenPresenterImpl : MainScreenPresenter {

    private var view: MainScreenView? = null
    private val listEvents = mutableListOf<Event>()

    override fun setView(v: MainScreenView) {
        view = v
    }
    private fun calculateAllEvents(): Int {
        var result = 0
        listEvents.forEachIndexed { index, event ->
            if (event is Event.Action) {
                val prevEvent = listEvents[index - 1]
                val nextEvent = listEvents[index + 1]
                val prevNumber = (prevEvent as? Event.Number)?.number ?: 0
                val nextNumber = (nextEvent as? Event.Number)?.number ?: 0
                result = ResultActionManager().processAction(prevNumber, nextNumber, event)
            }
        }
        return result
    }

    override fun reset() {
        listEvents.clear()
        view?.printEvents(listEvents)
    }
    override fun addEvent(action: Event) {
        if (action == Event.Action.Equals) {
            val result = calculateAllEvents()
            listEvents.clear()
//            listEvents.add(Event.Number(result))
            view?.printResult(result)
        } else {
            listEvents.add(action)
        }
        view?.printEvents(listEvents)
    }
}