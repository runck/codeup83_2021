package bowling;

// Please don't modify the class name.
/**
 * @author tiger
 * @date 2021/3/11
 */
public class Bowling {
    
    public final static int NUM_TURN = 10;
    
    int score;
    // int rolls[] = new int[21];
    int rolls[] = new int[23];
    int rollsIndex = 0;

    // Please don't modify the signature of this method.
    public void roll(int n) {
        this.rolls[rollsIndex] = n;
        this.rollsIndex++;
    }

    // Please don't modify the signature of this method.
    public int getScore() {
        this.score = 0;
        int count = 0;
        boolean midFrame = false;

        for(int i = 0; count < NUM_TURN; i++) {
            if(this.rolls[i] == 10){
                this.score += 10 + this.rolls[i+1] + this.rolls[i+2];
                count++;
                continue;
            }
            if (this.rolls[i] + this.rolls[i+1] == 10){
                this.score += 10 + this.rolls[i+2];
            } else {
                this.score += this.rolls[i] + this.rolls[i+1];
            }
            i++;
            count++;
        }
        return this.score;
    }
}
