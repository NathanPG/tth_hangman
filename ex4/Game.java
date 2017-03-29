class Game{
    public static final int MAX_MISSES = 7;
    private String answer;
    private String misses;
    private String hits;
//To read answer in lower case
    public Game(String answer){
        this.answer = answer.toLowerCase();
        hits = "";
        misses = "";
    }
//To see if the answer is a letter
    private char normalizeGuess(char letter){
	if (!Character.isLetter(letter)){
		throw new IllegalArgumentException("A letter is required");
	}
	letter = Character.toLowerCase(letter);
        return letter;
    }
//To check isHit or miss
    public boolean applyGuess(char letter){
	letter = normalizeGuess(letter);
        if (misses.indexOf(letter) != -1|| hits.indexOf(letter) != -1){
              throw new IllegalArgumentException(letter + "has already been guessed");  
        }
        boolean isHit = answer.indexOf(letter) != -1;
        if(isHit){
           hits += letter;
        } else{
           misses += letter;
        }
        return isHit;
    }
//To get remaining tries
    public int getRemainingTries(){
       return MAX_MISSES - misses.length();
    }
//
  public String getCurrentProgress() {
    String progress = "";
    for (char letter: answer.toCharArray()) {
      char display = '-';
      if (hits.indexOf(letter) >= 0) {
        display = letter;
      }
      progress += display;
    }
    return progress;
  }
}

