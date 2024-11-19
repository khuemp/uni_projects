package de.uni_saarland.cs.se
package traits

import utils.{ListStorage, MapStorage, Storage, StorageType}

import scala.collection.mutable


/**
 * Database interface for all database implementations and traits.
 */
trait Database {
  /**
   * The database's storage type, i.e., MAP or LIST.
   */
  val storageType: StorageType

  /**
   * Gives subclasses and traits access to the database's storage.
   *
   * @return the database's storage
   */
  protected def storage(): Storage

  protected def hasTransaction: Boolean = false
  def write(key: String, value: String): Unit = {}
}

// DONE: implement task 1c
class MapStoreDatabase extends Database {
  var storagevar: Storage = MapStorage()
  override val storageType: StorageType = storagevar.storageType
  override protected def storage(): Storage = storagevar
}

class ListStoreDatabase extends Database {
  var storagevar: Storage = ListStorage()
  override val storageType: StorageType = storagevar.storageType
  override protected def storage(): Storage = storagevar
}

trait Read extends Database {
  def read(key: String): Option[String] = {
      return storage().get(key)
  }
}

trait Write extends Database {
  override def write(key: String, value: String): Unit = {
    if super.hasTransaction then
      super.write(key, value)
    else
      storage().put(key, value)
  }
}

trait Transaction extends Database {
  override protected def hasTransaction: Boolean = true
  
  private var tmpstoragevar: Storage = _
  if storageType == StorageType.LIST then
    tmpstoragevar = ListStorage()
  else
    tmpstoragevar = MapStorage()

  override def write(key: String, value: String): Unit = {
    tmpstoragevar.put(key, value)
  }
  def commit(): Int = {
    val size = tmpstoragevar.size()
    tmpstoragevar.foreach((k, v) => storage().put(k, v))
    if storageType == StorageType.LIST then
      tmpstoragevar = ListStorage()
    else
      tmpstoragevar = MapStorage()
    return size
  }
  def rollback(): Int = {
    val size = tmpstoragevar.size()
    if storageType == StorageType.LIST then
      tmpstoragevar = ListStorage()
    else
      tmpstoragevar = MapStorage()
    return size
  }
}

trait ReadWithLogging extends Database {
  def read(key: String): Option[String] = {
    println(s"Reading value for key '$key'.")
    return storage().get(key)
  }
}

trait WriteWithLogging extends Database {
  override def write(key: String, value: String): Unit = {
    if super.hasTransaction then
      super.write(key, value)
    else
      println(s"Writing value '$value' at key '$key'.")
      storage().put(key, value)
  }
}

trait TransactionWithLogging extends Database {
  override protected def hasTransaction: Boolean = true
  
  private var tmpstoragevar: Storage = _
  if storageType == StorageType.LIST then
    tmpstoragevar = ListStorage()
  else
    tmpstoragevar = MapStorage()

  override def write(key: String, value: String): Unit = {
    println(s"Writing value '$value' at key '$key'.")
    tmpstoragevar.put(key, value)
  }
  def commit(): Int = {
    val size = tmpstoragevar.size()
    tmpstoragevar.foreach((k, v) => storage().put(k, v))
    if storageType == StorageType.LIST then
      tmpstoragevar = ListStorage()
    else
      tmpstoragevar = MapStorage()
    println(s"Committing $size entries.")
    return size
  }
  def rollback(): Int = {
    val size = tmpstoragevar.size()
    if storageType == StorageType.LIST then
      tmpstoragevar = ListStorage()
    else
      tmpstoragevar = MapStorage()
    println(s"Rolling back $size entries.")
    return size
  }
}