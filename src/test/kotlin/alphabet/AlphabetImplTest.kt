package alphabet

import io.kotlintest.matchers.startWith
import io.kotlintest.should
import io.kotlintest.shouldBe
import io.kotlintest.shouldThrow
import org.junit.jupiter.api.Test
import java.lang.IllegalArgumentException

internal class AlphabetImplTest{

    @Test
    fun `Size of alphabet with ten letters should be 10`() {
        val alphabetWithThree = AlphabetImpl("ABCDEFGHIJ")

        alphabetWithThree.size() shouldBe 10
    }

    @Test
    fun `Alphabet starting with lowercase letter should not count lowercased letters`() {
        val alphabetLowercase = AlphabetImpl("axBCDEFGHIJ")

        alphabetLowercase.size() shouldBe 9
        alphabetLowercase[1] shouldBe "B"
    }


    @Test
    fun `Size of alphabet with eleven characters, ten letters where one letter is multi-letter should be 10`() {
        val alphabetWithThree = AlphabetImpl("ABCDEFGHChI")

        alphabetWithThree.size() shouldBe 10
    }

    @Test
    fun `Alphabet defined with no capital letters should be size of 0`() {
        //GIVEN
        val emptyAlphabet = AlphabetImpl("abcderfvn")

        emptyAlphabet.size() shouldBe 0
    }

    @Test
    fun `Alphabed with capital national characters`() {
        val nationalAlphabet = AlphabetImpl("ŠUaxRÚÖdaXW")

        nationalAlphabet.size() shouldBe 7
    }

    @Test
    fun `Get zero letter from Alphabet`() {
        val multiLetterAlphebet = AlphabetImpl("AchoaUjaD")

        val exception = shouldThrow<IllegalArgumentException> {
            multiLetterAlphebet[0]
        }
        exception.message should startWith("Position of a letter must be positive number")
    }

    @Test
    fun `Get First multi-letter from alphabet`() {
        val multiLetterAlphebet = AlphabetImpl("AChJouČeňdaENDXda")

        multiLetterAlphebet[1] shouldBe "A"
        multiLetterAlphebet[2] shouldBe "Ch"
        multiLetterAlphebet[3] shouldBe "Jou"
        multiLetterAlphebet[4] shouldBe "Čeňda"
        multiLetterAlphebet[5] shouldBe "E"
        multiLetterAlphebet[8] shouldBe "Xda"
    }

    @Test
    fun `More multi-letters with same prefix`()
    {
        val multiLetterAlphebet = AlphabetImpl("ChChaChoChouh")

        multiLetterAlphebet.size() shouldBe 4
        multiLetterAlphebet[1] shouldBe "Ch"
        multiLetterAlphebet[2] shouldBe "Cha"
        multiLetterAlphebet[3] shouldBe "Cho"
        multiLetterAlphebet[4] shouldBe "Chouh"
    }


    @Test
    fun `Alphabet should not have duplicite letters`()
    {
        val exception = shouldThrow<IllegalArgumentException> {
            AlphabetImpl("ABCDACD")
        }
        exception.message should startWith("Alphabet cannot have duplicate letters")
    }

    @Test
    fun `Alphabet should not have duplicite multi-letters`()
    {
        val exception = shouldThrow<IllegalArgumentException> {
            AlphabetImpl("ABChšDAChšD")
        }
        exception.message should startWith("Alphabet cannot have duplicate letters")
    }

    @Test
    fun `Alphabet with digits`()
    {
        val exception = shouldThrow<IllegalArgumentException>
        {
            AlphabetImpl("A1C")
        }
        exception.message should startWith("Alphabet can contain only Letters")
    }

    @Test
    fun `Alphabet with special character`()
    {
        val exception = shouldThrow<IllegalArgumentException>
        {
            AlphabetImpl("asdAB!C")
        }
        exception.message should startWith("Alphabet can contain only Letters")
    }

//    @Test
//    fun `Czech alphabhet`()
//    {
//        val CzechAlphabet = Alphabets.CZECH
//
//        CzechAlphabet.size() shouldBe 42
//    }
}