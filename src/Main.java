public class Main {
    public static void main(String[] args) {
        boolean gameOver = false;
        MagicWord magic = new MagicWord();

        while (! gameOver){
            System.out.println(magic);
            System.out.println("Enter a word or letter");
            String s = Input.readString();
            magic.shoot(s);
        if (magic.wins()){
            System.out.println("You win ");
            System.out.print(" " + magic.getHiddenword());
            gameOver = true;
        }else {
            if (magic.losses()){
                System.out.println("You loose the hidden word is " + magic.getHiddenword());
                gameOver = true;
            }
        }
        }
    }
}
