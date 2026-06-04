package io.github.mrandrey24.portfolio

class JVMPlatform : Platform {
  override val name: String = "Java ${System.getProperty("java.version")}"
}

actual fun getPlatform(): Platform = JVMPlatform()
