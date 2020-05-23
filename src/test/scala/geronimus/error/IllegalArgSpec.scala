package geronimus.error

import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers._

class IllegalArgSpec extends AnyFunSpec {

  describe( "StdError.illegalArg( parameter : String, expected : String, found : Any[, explanation : String ] )" ) {

    val parameter = "testValue"
    val expected = "Describe the legal value."
    val found = "An literal illegal value, or its String representation."
    val explanation = "An optional, additional message explaining the error."

    it( "Thows an exception of type IllegalArgumentException" ) {
      
      assertThrows[ IllegalArgumentException ]{
        StdError.illegalArg( parameter, expected, found, explanation )  
      }
    }

    it( "Passing null to any parameter does not change the type of exception." ) {
      
      assertThrows[ IllegalArgumentException ]{
        StdError.illegalArg( null, expected, found, explanation )  
      }
      
      assertThrows[ IllegalArgumentException ]{
        StdError.illegalArg( parameter, null, found, explanation )  
      }
      
      assertThrows[ IllegalArgumentException ]{
        StdError.illegalArg( parameter, expected, null, explanation )  
      }
      
      assertThrows[ IllegalArgumentException ]{
        StdError.illegalArg( parameter, expected, found, null )  
      }
    }

    it( "Its error message contains all of the text values you pass in." ) {
    
      val error = the [ IllegalArgumentException ] thrownBy {  
        StdError.illegalArg( parameter, expected, found, explanation )  
      }

      assert( error.getMessage.contains( parameter ) )
      assert( error.getMessage.contains( expected ) )
      assert( error.getMessage.contains( found ) )
      assert( error.getMessage.contains( explanation ) )
      assert( error.getMessage.count( _ == '\n' ) == 5 )
    }

    it( "The explanation (additional comment) is optional." ) {  
    
      val error = the [ IllegalArgumentException ] thrownBy {  
        StdError.illegalArg( parameter, expected, found )  
      }

      assert( error.getMessage.contains( parameter ) )
      assert( error.getMessage.contains( expected ) )
      assert( error.getMessage.contains( found ) )
      assert( !error.getMessage.contains( explanation ) )
      assert( error.getMessage.count( _ == '\n' ) == 3 )
    }
  }
}

