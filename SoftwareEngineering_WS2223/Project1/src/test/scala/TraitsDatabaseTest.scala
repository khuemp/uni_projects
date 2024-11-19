package de.uni_saarland.cs.se

import traits.*
import utils.ConfigurationError
import utils.StorageType

import org.scalatest.flatspec.AnyFlatSpec

import java.io.ByteArrayOutputStream

class TraitsDatabaseTest extends AnyFlatSpec {

  class ROMapDB extends MapStoreDatabase with Read {}
  class RWMapDB extends MapStoreDatabase with Write with Read {}
  class RWListDB extends ListStoreDatabase with Write with Read {}
  class TxnMapDB extends MapStoreDatabase with Transaction with Write with Read {}
  class FullMapDB extends MapStoreDatabase
    with TransactionWithLogging with WriteWithLogging with ReadWithLogging {}

  "A read-only database" should "only allow read operations." in {
    val db = ROMapDB()
    assert(db.read("foo").isEmpty)
    assert(db.storageType == StorageType.MAP)
  }

  "A read-write database" should "allow read and write operations." in {
    val db = RWMapDB()
    assert(db.read("foo").isEmpty)
    db.write("foo", "bar")
    assert(db.read("foo").contains("bar"))
  }

  "A database with transactions" should "require committing before reading." in {
    val db = TxnMapDB()
    assert(db.read("foo").isEmpty)
    db.write("foo", "bar")
    assert(db.read("foo").isEmpty)
    db.commit()
    assert(db.read("foo").contains("bar"))
  }

  "A database with transactions" should "not store roll-backed values." in {
    val db = TxnMapDB()
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
    val db = FullMapDB()

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
    val db = RWListDB()
    assert(db.storageType == StorageType.LIST)
  }
}
