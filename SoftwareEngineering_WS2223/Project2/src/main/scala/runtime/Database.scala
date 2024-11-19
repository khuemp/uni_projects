package de.uni_saarland.cs.se
package runtime

import utils.ConfigurationError
import utils.{ListStorage, MapStorage, Storage, StorageType}

import scala.collection.mutable


/**
 * Configuration class for databases.
 * 
 * @param read whether the database should support read operations
 * @param write whether the database should support write operations
 * @param transaction whether the database should support transactions
 * @param logging whether the database should support logging
 * @param storageType the type of storage the database should use
 */
class DatabaseConfig(
  val read: Boolean,
  val write: Boolean,
  val transaction: Boolean,
  val logging: Boolean,
  val storageType: StorageType
) {}


/**
 * A runtime-configurable version of our database SPL.
 * 
 * @param config the configuration for the database
 */
class Database(val config: DatabaseConfig) {
  // DONE: implement task 1a

  private var storage : Storage = _
  private var tmpStorage: Storage = _

  if !config.read && !config.write then
    throw new ConfigurationError

  if config.storageType == StorageType.MAP then
    storage = MapStorage()
    tmpStorage = MapStorage()
  else if config.storageType == StorageType.LIST then
    storage = ListStorage()
    tmpStorage = ListStorage()
  else
    throw new ConfigurationError

  def read(key: String): Option[String] = {
    if !config.read then
      throw new ConfigurationError
    if config.logging then
      println(s"Reading value for key '$key'.")
    return storage.get(key)
  }

  def write(key: String, value: String): Unit = {
    if !config.write then
      throw new ConfigurationError
    if config.logging then
      println(s"Writing value '$value' at key '$key'.")
    if config.transaction then
      tmpStorage.put(key, value)
    else
      storage.put(key, value)
  }
  
  def commit(): Int = {
    if ! (config.transaction && config.write) then
      throw new ConfigurationError
    val size = tmpStorage.size()
    if config.logging then
      println(s"Committing $size entries.")
    tmpStorage.foreach((k, v) => storage.put(k, v))
    tmpStorage = ListStorage()
    return size
  }
  
  def rollback(): Int = {
    if !(config.transaction && config.write) then
      throw new ConfigurationError
    val size = tmpStorage.size()
    if config.logging then
      println(s"Rolling back $size entries.")
    tmpStorage = ListStorage()
    return size
  }
  
  val storageType = storage.storageType
}