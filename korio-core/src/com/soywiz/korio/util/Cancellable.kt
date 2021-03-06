package com.soywiz.korio.util

import java.util.concurrent.CancellationException

interface Cancellable {
	fun cancel(e: Throwable = CancellationException()): Unit

	interface Listener {
		fun onCancel(handler: (Throwable) -> Unit): Unit
	}

	companion object {
		operator fun invoke(callback: (Throwable) -> Unit) = object : Cancellable {
			override fun cancel(e: Throwable) = callback(e)
		}
	}
}