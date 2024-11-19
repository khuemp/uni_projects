package de.uni_saarland.cs.se

import runtime.*
import utils.ConfigurationError
import utils.StorageType

import org.scalatest.flatspec.AnyFlatSpec

import java.io.ByteArrayOutputStream

class RuntimeDatabaseTest extends AnyFlatSpec {

  "A read-only database" should "only allow read operations." in {
    val config = DatabaseConfig(
      read = true,
      write = false,
      transaction = false,
      logging = false,
      storageType = StorageType.MAP
    )
    val db = new Database(config)
    assert(db.read("foo").isEmpty)
    assertThrows[ConfigurationError] { db.write("foo", "bar") }
    assertThrows[ConfigurationError] { db.commit() }
    assertThrows[ConfigurationError] { db.rollback() }
    assert(db.storageType == StorageType.MAP)
  }

  "A read-write database" should "allow read and write operations." in {
    val config = DatabaseConfig(
      read = true,
      write = true,
      transaction = false,
      logging = false,
      storageType = StorageType.MAP
    )
    val db = new Database(config)
    assert(db.read("foo").isEmpty)
    db.write("foo", "bar")
    assert(db.read("foo").contains("bar"))
    assertThrows[ConfigurationError] { db.commit() }
    assertThrows[ConfigurationError] { db.rollback() }
  }

  "A database with transactions" should "require committing before reading." in {
    val config = DatabaseConfig(
      read = true,
      write = true,
      transaction = true,
      logging = false,
      storageType = StorageType.MAP
    )
    val db = new Database(config)
    assert(db.read("foo").isEmpty)
    db.write("foo", "bar")
    assert(db.read("foo").isEmpty)
    db.commit()
    assert(db.read("foo").contains("bar"))
  }

  "A database with transactions" should "not store roll-backed values." in {
    val config = DatabaseConfig(
      read = true,
      write = true,
      transaction = true,
      logging = false,
      storageType = StorageType.MAP
    )
    val db = new Database(config)
    assert(db.read("foo").isEmpty)
    assert(db.read("bar").isEmpty)
    db.write("foo", "1")
    db.rollback()
    db.write("bar", "2")
    db.commit()
    assert(db.read("foo").isEmpty)
    assert(db.read("bar").contains("2"))
  }

  "A data base with logging" should "log all operations" in {
    val config = DatabaseConfig(
      read = true,
      write = true,
      transaction = true,
      logging = true,
      storageType = StorageType.MAP
    )
    val db = new Database(config)

    val stream = new ByteArrayOutputStream()
    Console.withOut(stream) {
      db.write("foo", "1")
      assert(stream.toString().startsWith("Writing value '1' at key 'foo'."))
      stream.reset()

      db.rollback()
      assert(stream.toString().startsWith("Rolling back 1 entries."))
      stream.reset()

      db.write("bar", "2")
      assert(stream.toString().startsWith("Writing value '2' at key 'bar'."))
      stream.reset()

      db.commit()
      assert(stream.toString().startsWith("Committing 1 entries."))
      stream.reset()

      db.read("foo")
      assert(stream.toString().startsWith("Reading value for key 'foo'."))
      stream.reset()

      db.read("bar")
      assert(stream.toString().startsWith("Reading value for key 'bar'."))
      stream.reset()
    }
  }

  "Foo" should "Bar" in {
    val config = DatabaseConfig(
      read = true,
      write = true,
      transaction = false,
      logging = false,
      storageType = StorageType.LIST
    )
    val db = new Database(config)
    assert(db.storageType == StorageType.LIST)
  }
}
