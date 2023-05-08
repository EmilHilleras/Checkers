package GameRules;

public class PlayerTurn {

    //Instansvariabler
    private static boolean isRedTurn;

    //Konstruktor

    //Sätter in boolean isRedTurn som parameter
    public PlayerTurn(boolean isRedTurn) {

        this.isRedTurn = isRedTurn;
    }

    //Metoder

    //Returnerar värdet av isRedTurn variabeln
    public static boolean isRedTurn() {

        return isRedTurn;
    }

    //Byter tur varje gång switchTurn anges

    public static void switchTurn() {

        if (isRedTurn()) {
            isRedTurn = !isRedTurn;
        } else if (!isRedTurn()) {
            isRedTurn = true;
        }
    }


    //GetSet
    public static boolean getPlayerTurn() {
        return isRedTurn;
    }
}
