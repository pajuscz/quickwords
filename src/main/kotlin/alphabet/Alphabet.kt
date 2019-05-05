package alphabet

/**
 * Alphabet is a list of letters
 * Letter is represented as a string because it may contain more characters e.g. 'Ch' is one letter in Czech Alphabet
 * Letters in Alphabet are expected to be 'sorted'. In other words order of letters is given by Alphabet
 * Alphabet may contain national characters in UTF8 encoding
 */
interface Alphabet {
    /**
     * Request a letter from the Alphabet (first position is 1, last position is Alphabet.size())
     * Letter may contain more characters.
     * @param position of requested letter in the Alphabet
     * @return letter on certain position in the Alphabet
     */
    fun get(position: Int): String

    /**
     * Size of the Alphabet
     * @return number of letters in the Alphabet
     */
    fun size(): Int
}