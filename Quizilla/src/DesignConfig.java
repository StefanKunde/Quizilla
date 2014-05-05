import java.io.File;



public class DesignConfig 
{
	// Dateipfade.
	static final String FILE_XML_QUESTIONS_FILE = "Questions\\Fragen.xml";
	static final String FILE_NAME_HIGHSCORE = "Highscore.data";
	
	// MIN-MAX Einstellungen.
	static final int MIN_PUFFER_EACH_LINE = 4;
	static final int MIN_ROW_LENGTH = 40;
	static final int MAX_ROW_LENGTH = 100;
	static final int MAX_USER_NAME_LENGTH = 12;
	static final int MAX_LENGTH_QUESTION = 40;
	static final int MAX_LENGTH_FOR_QUESTIONS_EACH_LINE = MAX_ROW_LENGTH - MIN_PUFFER_EACH_LINE;
	static final int MAX_LENGTH_ANSWER = 30;
	static final int MAX_LENGTH_FOR_ANSWERS_EACH_LINE = 30;
	static final int MAX_PLAYER_ON_HIGHSCORE_LIST = 10;
	static final int MAX_HIGHSCORE_COUNT = 10;
	
	// Diverse andere. -> In eine der bestehenden Kategorien passen diese Einstellungen nicht direkt rein.
	static final char FREE_SPACE_CHAR = ' ';
	static final int OPEN_CHAR_LENGTH = 1;
	static final int CLOSE_CHAR_LENGTH = 1;
	static final int BORDER_LENGTH = 1;
	static final String NEW_LINE = "\n";
	static final char SIGN_FOR_RESULT = '%';
	
	// Puffereinstellungen -> Entfernung vom linken Rand.
	static final int PUFFER_TITLE = 0;
	static final int PUFFER_QUESTION = 6;
	static final int PUFFER_ANSWER = 2;
	static final int PUFFER_LIFE_LEFT = 84;
	static final int PUFFER_QUESTION_AMOUNT = 7;
	static final int PUFFER_USER_REQUEST = 8;
	static final int PUFFER_USER_INFO = 40;
	static final int PUFFER_MENU = 5;
	static final int PUFFER_RESULT = 15;
	static final int PUFFER_HIGHSCORE_RANK = 10;
	static final int PUFFER_HIGHSCORE_NAME = 30;
	static final int PUFFER_HIGHSCORE_RESULT = 60;
	static final int PUFFER_INVALID_INPUT = 0;
	
	// Text Umhüllungszeichen und Einstellungen.
	static final char OPEN_TITLE_CHAR = '[';
	static final char CLOSE_TITLE_CHAR = ']';
	static final char OPEN_QUESTION_CHAR = ' ';
	static final char CLOSE_QUESTION_CHAR = ' ';
	static final char OPEN_ANSWER_CHAR = ' ';
	static final char CLOSE_ANSWER_CHAR = ' ';
	static final char OPEN_REQUEST_CHAR = ' ';
	static final char CLOSE_REQUEST_CHAR = ' ';
	static final char OPEN_INFO_CHAR = '[';
	static final char CLOSE_INFO_CHAR = ']';
	static final char OPEN_STATUS_CHAR = '[';
	static final char CLOSE_STATUS_CHAR = ']';
	static final char OPEN_MENU_CHAR = '.';
	static final char CLOSE_MENU_CHAR = '.';
	static final char OPEN_RESULT_CHAR = ' ';
	static final char CLOSE_RESULT_CHAR = ' ';
	static final char OPEN_HIGHSCORE_CHAR = ' ';
	static final char CLOSE_HIGHSCORE_CHAR = ' ';
	static final char OPEN_INVALID_INPUT_CHAR = ' ';
	static final char CLOSE_INVALID_INPUT_CHAR = ' ';
	
	// Boarderzeichen und Einstellungen..
	static final char BORDER_CHAR_DEFAULT = '#';
	static final char BOARDER_CHAR_QUESTION = '?';
	static final char BORDER_CHAR_ANSWER = 'A';
	static final char BORDER_CHAR_REQUEST = 'U';
	static final char BORDER_CHAR_INFO = 'I';
	static final char BORDER_CHAR_DELIMITER_LINE = '#';
	static final char BORDER_CHAR_MENU = 'M';
	static final char BORDER_CHAR_RESULT = '%';
	static final char BORDER_CHAR__RANK = '.';
	static final char BORDER_CHAR_HIGHSCORE = 'H';
	static final char BORDER_CHAR_INVALID_INPUT = '!';
	
	// Leerstellenzeichen.
	static final char FILL_CHAR_DEFAULT = '#';
	static final char FILL_CHAR_FOR_TITLES = '#';
	static final char FILL_CHAR_FOR_DELIMITING = '-';
	static final char FILL_CHAR_FOR_QUESTIONS = ' ';
	static final char FILL_CHAR_FOR_ANSWERS = ' ';
	static final char FILL_CHAR_FOR_REQUEST = ' ';
	static final char FILL_CHAR_FOR_INFO = '-';
	static final char FILL_CHAR_FOR_STATUS = '#';
	static final char FILL_CHAR_FOR_MENU = '.';
	static final char FILL_CHAR_FOR_RESULT = '.';
	static final char FILL_CHAR_FOR_HIGHSCORE = '-';
	static final char FILL_CHAR_FOR_INVALID_INPUTS = '-';
	
	// Menütexte.
	static final String MENU_PLAY_GAME = "Spiel starten";
	static final String MENU_HIGH_SCORE = "Highscore";
	static final String MENU_MANUAL = "Anleitung";
	static final String MENU_EXIT_GAME = "Spiel beenden";
	static final char MENU_NUMBER_TEXT_CLOSE_CHAR = ':';
	static final int MENU_NUMBER_ONE = 1;
	static final int MENU_NUMBER_TWO = 2;
	static final int MENU_NUMBER_THREE = 3;
	static final int MENU_NUMBER_FOUR = 4;
	static final String MENU_NUMBER_ONE_TEXT = ("" + MENU_NUMBER_ONE + MENU_NUMBER_TEXT_CLOSE_CHAR + FREE_SPACE_CHAR);
	static final String MENU_NUMBER_TWO_TEXT = ("" + MENU_NUMBER_TWO + MENU_NUMBER_TEXT_CLOSE_CHAR + FREE_SPACE_CHAR);
	static final String MENU_NUMBER_THREE_TEXT = ("" + MENU_NUMBER_THREE + MENU_NUMBER_TEXT_CLOSE_CHAR + FREE_SPACE_CHAR);
	static final String MENU_NUMBER_FOUR_TEXT = ("" + MENU_NUMBER_FOUR + MENU_NUMBER_TEXT_CLOSE_CHAR + FREE_SPACE_CHAR);
	static final String MENU_ANSWER_TEXT = ("Antwort" + FREE_SPACE_CHAR);
	
	// Titeltexte.
	static final String TITLE_HIGHSCORE = "HIGHSCORE";
	static final String TITLE_MANUAL = "ANLEITUNG";
	static final String TITLE_QUIZILLA = "QUIZILA";
	static final String TITLE_GAME_START = "SPIEL BEGINNT";
	static final String TITLE_GOOD_LUCK = "GOOD LUCK!";
	static final String TITLE_GOOD_BYE = "AUF WIEDERSEHEN";
	static final String TITLE_CONGRATULATIONS = "HERZLICHEN GLÜCKWUNSCH";
	static final String TITLE_WON = "GEWONNEN";
	static final String TITLE_LOST = "LEIDER VERLOREN";
	static final String TITLE_RESULT = "ERGEBNIS";
	
	// Benutzereingabe Aufforderungstexte.
	static final String USER_REQUEST_TEXT_NAME = "Geben Sie Ihren Namen ein:" + FREE_SPACE_CHAR;
	static final String USER_REQUEST_ENTER = "Weiter mit Enter...";
	static final String USER_REQUEST_ANSWER_MENU = "Auswahl:" + FREE_SPACE_CHAR;
	static final String USER_REQUEST_ANSWER_QUESTION = "Antwort:" + FREE_SPACE_CHAR;
	
	// Informationstexte
	static final String INFO_ANSWER_CORRECT = "KORREKT";
	static final String INFO_ANSWER_WRONG = "FALSCH";
	static final char INFO_TEXT_CLOSE_CHAR = ':';
	static final String INFO_QUESTIONS_OVERALL = ("Fragen Gesamt" + INFO_TEXT_CLOSE_CHAR + FREE_SPACE_CHAR);
	static final String INFO_ANSWERED_QUESTIONS = ("Beantwortete Fragen" + INFO_TEXT_CLOSE_CHAR + FREE_SPACE_CHAR);
	static final String INFO_CORRECT_ANSWERED_QUESTIONS = ("Davon richtig" + INFO_TEXT_CLOSE_CHAR + FREE_SPACE_CHAR);
	static final String INFO_RESULT = ("Ergebnis" + INFO_TEXT_CLOSE_CHAR + FREE_SPACE_CHAR);
	
	// Resulttexte
	static final String RESULT_EMPTY = "LEER";
	static final int RESULT_IS_NOT_AVAILABLE_INT = -1; // -1 gibt an, dass dass es kein Ergebnis gibt (also die Highscore liste nicht voll ist.).
	
	// Statusleiste Texte.
	static final String STATUS_LIFE_TEXT = "Leben:" + FREE_SPACE_CHAR;
	static final String STATUS_QUESTIONS_AMOUNT_TEXT = "Frage:" + FREE_SPACE_CHAR;
	
	// Invalide Eingaben Texte
	static final String INVALID_DEFAULT_MSG = "Ungültiger Eingabe!";
	static final String INVALID_NAME_MSG = "Mindestens 1 und maximal 16 Buchstaben erlaubt!";
	static final String INVALID_MENU_CHOICE = "Nur zahlen zwischen 1 und 4 sind erlaubt";
	static final String INVALID_ANSWER = "Nur zahlen zwischen 1 und 4 sind erlaubt";
}
