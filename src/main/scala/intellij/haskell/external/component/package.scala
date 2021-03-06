package intellij.haskell.external

package object component {

  sealed trait NoInfo {
    def message: String
  }

  case object ReplNotAvailable extends NoInfo {
    def message: String = "No info because REPL is not (yet) available"
  }

  case class NoInfoAvailable(name: String, locationName: String) extends NoInfo {
    override def message: String = s"No info available for $name in $locationName"
  }

  case object IndexNotReady extends NoInfo {
    override def message: String = "No info because index is not ready"
  }

  case class ModuleNotAvailable(name: String) extends NoInfo {
    override def message: String = s"No info because $name is not loaded or found"
  }

  case class ReadActionTimeout(readActionDescription: String) extends NoInfo {
    def message = s"No info because read action timeout while $readActionDescription"
  }

}
