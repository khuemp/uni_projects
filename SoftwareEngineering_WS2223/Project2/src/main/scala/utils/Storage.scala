package de.uni_saarland.cs.se
package utils

import scala.collection.mutable

/**
 * Available storage types.
 */
enum StorageType:
  case MAP, LIST


/**
 * Interface for database storage implementations.
 */
trait Storage(val storageType: StorageType) {
  def put(key: String, value: String): Unit
  def get(key: String): Option[String]
  def foreach(func: (String, String) => Unit): Unit
  def size(): Int
}


/**
 * Map-based storage implementation.
 */
class MapStorage() extends Storage(StorageType.MAP) {
  private val storage: mutable.Map[String, String] = mutable.Map()

  override def put(key: String, value: String): Unit = storage += (key -> value)

  override def get(key: String): Option[String] = storage.get(key)

  override def size(): Int = storage.size

  override def foreach(func: (String, String) => Unit): Unit = storage.foreachEntry(func)
}


/**
 * List-based storage implementation.
 */
class ListStorage() extends Storage(StorageType.LIST) {
  private var storage: List[(String, String)] = Nil

  override def put(key: String, value: String): Unit = {
    storage = (key, value) :: storage
  }

  override def get(key: String): Option[String] = storage.find((k, *) => k == key).map((*, v) => v)

  override def size(): Int = storage.size

  override def foreach(func: (String, String) => Unit): Unit = storage.foreach((k, v) => func(k, v))
}