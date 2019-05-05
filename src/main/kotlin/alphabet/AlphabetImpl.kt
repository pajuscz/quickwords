package alphabet

class AlphabetImpl(): Alphabet{
    private var letters = mutableSetOf<String>()

    constructor(letters: String) : this() {
        for(i in 0 until letters.length)
        {
            require(letters[i].isLetter()){ "Alphabet can contain only Letters: [${letters[i]}] was found" }
            if(letters[i].isUpperCase())
            {
                val wasAdded = this.letters.add(letterFrom(letters, i))
                require(wasAdded){ "Alphabet cannot have duplicate letters" }
            }
        }
    }
    private fun letterFrom(letters: String, index: Int): String
    {
        var letter = letters[index].toString()

        for(i in index+1 until letters.length)
        {
            if(letters[i].isLowerCase())
            {
                letter += letters[i]
            }
            else
            {
                return letter
            }
        }
        return letter
    }


    override operator fun get(position: Int): String {
        require(position > 0) { "Position of a letter must be positive number [$position] given" }
        return letters.toList()[position-1]
    }

    override fun size(): Int {
        return letters.size
    }
}