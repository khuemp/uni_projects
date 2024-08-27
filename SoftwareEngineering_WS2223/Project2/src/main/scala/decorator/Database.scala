package de.uni_saarland.cs.se
package decorator

import utils.ConfigurationError
import utils.{ListStorage, MapStorage, Storage, StorageType}

import scala.collection.mutable


/**
 * Interface for the database components and decorators.
 */
trait Database {
  def read(key: String): Option[String]
  def write(key: String, value: String): Unit
  def commit(): Int
  def rollback(): Int
  val storageType: StorageType
  private[decorator] def storage(): Storage
  private[decorator] def tmpstorage(): Storage
}

// DONE: implement task 1b

class MapStorageDatabase() extends Database {
  override def read(key: String): Option[String] = {
    throw new ConfigurationError
  }
  override def write(key: String, value: String): Unit = {
    throw new ConfigurationError
  }
  override def commit(): Int = {
    throw new ConfigurationError
  }
  override def rollback(): Int = {
    throw new ConfigurationError
  }
  private var storagevar: Storage = MapStorage()
  override val storageType: StorageType = storagevar.storageType
  override private[decorator] def storage(): Storage = storagevar
  override private[decorator] def tmpstorage(): Storage = {
    throw new ConfigurationError
  }
}

class ListStorageDatabase() extends Database {
  override def read(key: String): Option[String] = {
    throw new ConfigurationError
  }
  override def write(key: String, value: String): Unit = {
    throw new ConfigurationError
  }
  override def commit(): Int = {
    throw new ConfigurationError
  }
  override def rollback(): Int = {
    throw new ConfigurationError
  }
  private var storagevar: Storage = ListStorage()
  override val storageType: StorageType = storagevar.storageType
  override private[decorator] def storage(): Storage = storagevar
  override private[decorator] def tmpstorage(): Storage = {
    throw new ConfigurationError
  }
}

trait StorageDecorator(val database: Database) extends Database {
  def read(key: String): Option[String]
  def write(key: String, value: String): Unit
  def commit(): Int
  def rollback(): Int
  val storageType: StorageType
  private[decorator] def storage(): Storage
  private[decorator] def tmpstorage(): Storage
}

class Read(override val database: Database) extends StorageDecorator(database) {
  override def read(key: String): Option[String] = {
    return this.storage().get(key)
  }
  override def write(key: String, value: String): Unit = {
    throw new ConfigurationError
  }
  override def commit(): Int = {
    throw new ConfigurationError
  }
  override def rollback(): Int = {
    throw new ConfigurationError
  }
  override val storageType: StorageType = database.storageType
  override private[decorator] def storage(): Storage = database.storage()
  override private[decorator] def tmpstorage(): Storage = {
    throw new ConfigurationError
  }
}

class Write(override val database: Database) extends StorageDecorator(database) {
  override def read(key: String): Option[String] = {
    return database.read(key)
  }
  override def write(key: String, value: String): Unit = {
    this.storage().put(key, value)
  }
  override def commit(): Int = {
    throw new ConfigurationError
  }
  override def rollback(): Int = {
    throw new ConfigurationError
  }
  override val storageType: StorageType = database.storageType
  override private[decorator] def storage(): Storage = database.storage()
  override private[decorator] def tmpstorage(): Storage = {
    throw new ConfigurationError
  }
}

class Transaction(override val database: Database) extends StorageDecorator(database) {
  private var tmpstoragevar: Storage = _
  if storageType == StorageType.LIST then
    tmpstoragevar = ListStorage()
  else
    tmpstoragevar = MapStorage()
  override def read(key: String): Option[String] = {
    return database.read(key)
  }
  override def write(key: String, value: String): Unit = {
    tmpstoragevar.put(key, value)
  }
  override def commit(): Int = {
    val size = tmpstoragevar.size()
    tmpstoragevar.foreach((k, v) => database.write(k, v))
    if storageType == StorageType.LIST then
      tmpstoragevar = ListStorage()
    else
      tmpstoragevar = MapStorage()
    return size
  }
  override def rollback(): Int = {
    val size = tmpstoragevar.size()
    if storageType == StorageType.LIST then
      tmpstoragevar = ListStorage()
    else
      tmpstoragevar = MapStorage()
    return size
  }
  override val storageType: StorageType = database.storageType
  override private[decorator] def storage(): Storage = database.storage()
  override private[decorator] def tmpstorage(): Storage = tmpstoragevar
}
class Logging(override val database: Database) extends StorageDecorator(database) {
  override def read(key: String): Option[String] = {
    println(s"Reading value for key '$key'.")
    return database.read(key)
  }
  override def write(key: String, value: String): Unit = {
    println(s"Writing value '$value' at key '$key'.")
    database.write(key, value)
  }
  override def commit(): Int = {
    val size = tmpstorage().size()
    println(s"Committing $size entries.")
    return database.commit()
  }
  override def rollback(): Int = {
    val size = tmpstorage().size() 
    println(s"Rolling back $size entries.")
    return database.rollback()
  }
  override val storageType: StorageType = database.storageType
  override private[decorator] def storage(): Storage = database.storage()
  override private[decorator] def tmpstorage(): Storage = database.tmpstorage()
}