package config;


//! In dieser Klasse befinden sich alle für das Programm nötige Konstanten.
/*
 * Diese Klasse kann nicht instanziert werden. 
 * 
 * @author Stefan Kunde
 * @date 01.05.2014
 * @version 1.0
 * 
 */
public final class Config
{
	// Privater Konstruktor um das Instanzieren zu verbieten.
	private Config() {}
	
	/*
	 * #####################EINSTELLUNGEN#####################
	*/
	
	// Dateipfade.
	public static final String _FILE_XML_QUESTIONS_FILE = "Questions\\Fragen.xml";
	public static final String _FILE_NAME_HIGHSCORE = "Highscore.data";
	public static final String _FILE_MANUAL_PATH = "Anleitung.txt";
	
	// MIN Einstellungen.
	public static final int _MIN_PUFFER_EACH_LINE = 4;
	public static final int _MIN_ROW_LENGTH = 40;
	
	// MAX Einstellungen.
	public static final int _MAX_ROW_LENGTH = 78;
	public static final int _MAX_QUESTIONS_EACH_GAME = 25;
	public static final int _MAX_USER_NAME_LENGTH = 12;
	public static final int _MAX_LENGTH_QUESTION = 40;
	public static final int _MAX_TEXT_LENGTH_EACH_LINE = _MAX_ROW_LENGTH - _MIN_PUFFER_EACH_LINE;
	public static final int _MAX_LENGTH_ANSWER = 30;
	public static final int _MAX_LENGTH_FOR_ANSWERS_EACH_LINE = 30;
	public static final int _MAX_PLAYER_ON_HIGHSCORE_LIST = 10;
	public static final int _MAX_HIGHSCORES_ON_LIST = 10;
	public static final int _MAX_RESULT = 100;
	public static final int _MAX_MANUAL_TEXT_LENGTH_EACH_ROW = _MAX_ROW_LENGTH - 10; 
	
	// Diverse andere. -> In eine der bestehenden Kategorien passen diese Einstellungen nicht direkt rein.
	public static final char _FREE_SPACE_CHAR = ' ';
	public static final int _OPEN_CHAR_LENGTH = 1;
	public static final int _CLOSE_CHAR_LENGTH = 1;
	public static final int _BORDER_LENGTH = 1;
	public static final String _NEW_LINE = "\n";
	public static final int _START_ROW = 0;
	public static final int _INVALID_PUFFER = 0;
	public static final int _RESET_CURRENT_QUESTION_VALUE = 0;
	public static final int _DECREASE_LIFE_VALUE = 1;
	public static final int _START_LIFES = 3;
	
	// Besondere Zeichen.
	public static final char _SIGN_FOR_RESULT = '%';
	
	// Puffereinstellungen -> Entfernung vom linken Rand.
	public static final int _PUFFER_TITLE = 0;
	public static final int _PUFFER_QUESTION = 6;
	public static final int _PUFFER_ANSWER = 2;
	public static final int _PUFFER_LIFE_LEFT = _MAX_ROW_LENGTH - 20;
	public static final int _PUFFER_QUESTION_AMOUNT = 7;
	public static final int _PUFFER_USER_REQUEST = 8;
	public static final int _PUFFER_USER_INFO = 25;
	public static final int _PUFFER_MENU = 5;
	public static final int _PUFFER_RESULT = 15;
	public static final int _PUFFER_HIGHSCORE_RANK = 10;
	public static final int _PUFFER_HIGHSCORE_NAME = 30;
	public static final int _PUFFER_HIGHSCORE_RESULT = 60;
	public static final int _PUFFER_INVALID_INPUT = 0;
	public final static int _PUFFER_MANUAL_LINE = 5;
	
	// Text Umhüllungszeichen und Einstellungen.
	public static final char _OPEN_TITLE_CHAR = '[';
	public static final char _CLOSE_TITLE_CHAR = ']';
	public static final char _OPEN_QUESTION_CHAR = ' ';
	public static final char _CLOSE_QUESTION_CHAR = ' ';
	public static final char _OPEN_ANSWER_CHAR = ' ';
	public static final char _CLOSE_ANSWER_CHAR = ' ';
	public static final char _OPEN_REQUEST_CHAR = ' ';
	public static final char _CLOSE_REQUEST_CHAR = ' ';
	public static final char _OPEN_INFO_CHAR = '[';
	public static final char _CLOSE_INFO_CHAR = ']';
	public static final char _OPEN_STATUS_CHAR = '[';
	public static final char _CLOSE_STATUS_CHAR = ']';
	public static final char _OPEN_MENU_CHAR = '.';
	public static final char _CLOSE_MENU_CHAR = '.';
	public static final char _OPEN_RESULT_CHAR = ' ';
	public static final char _CLOSE_RESULT_CHAR = ' ';
	public static final char _OPEN_HIGHSCORE_CHAR = ' ';
	public static final char _CLOSE_HIGHSCORE_CHAR = ' ';
	public static final char _OPEN_INVALID_INPUT_CHAR = ' ';
	public static final char _CLOSE_INVALID_INPUT_CHAR = ' ';
	public final static char _OPEN_MANUAL_LINE_CHAR = ' ';
	public final static char _CLOSE_MANUAL_LINE_CHAR = ' ';
	
	// Boarderzeichen und Einstellungen..
	public static final char _BORDER_DEFAULT = '#';
	public static final char _BORDER_QUESTION = '?';
	public static final char _BORDER_ANSWER = 'A';
	public static final char _BORDER_REQUEST = 'U';
	public static final char _BORDER_INFO = 'I';
	public static final char _BORDER_DELIMITER_LINE = '#';
	public static final char _BORDER_MENU = 'M';
	public static final char _BORDER_RESULT = '%';
	public static final char _BORDER_RANK = '.';
	public static final char _BORDER_HIGHSCORE = 'H';
	public static final char _BORDER_INVALID_INPUT = '!';
	public static final char _BORDER_MANUAL = '|';
	
	// Leerstellenzeichen.
	public static final char _FILL_SPACE_DEFAULT = '#';
	public static final char _FILL_SPACE_TITLES = '#';
	public static final char _FILL_SPACE_DELIMITING = '-';
	public static final char _FILL_SPACE_QUESTIONS = ' ';
	public static final char _FILL_SPACE_ANSWERS = ' ';
	public static final char _FILL_SPACEREQUEST = ' ';
	public static final char _FILL_SPACE_INFO = '-';
	public static final char _FILL_SPACE_STATUS = '#';
	public static final char _FILL_SPACE_MENU = '.';
	public static final char _FILL_SPACE_RESULT = '.';
	public static final char _FILL_SPACE_HIGHSCORE = '-';
	public static final char _FILL_SPACE_INVALID_INPUTS = '-';
	public static char _FILL_SPACE_MANUAL = '-';
	
	// Menütexte.
	public static final String _MENU_PLAY_GAME = "Spiel starten";
	public static final String _MENU_HIGH_SCORE = "Highscore";
	public static final String _MENU_MANUAL = "Anleitung";
	public static final String _MENU_EXIT_GAME = "Spiel beenden";
	public static final char _MENU_NUMBER_TEXT_CLOSE_CHAR = ':';
	public static final int _MENU_NUMBER_ONE_INT = 1;
	public static final int _MENU_NUMBER_TWO_INT = 2;
	public static final int _MENU_NUMBER_THREE_INT = 3;
	public static final int _MENU_NUMBER_FOUR_INT = 4;
	public static final String _MENU_NUMBER_ONE_TEXT = ("" + _MENU_NUMBER_ONE_INT + _MENU_NUMBER_TEXT_CLOSE_CHAR + _FREE_SPACE_CHAR);
	public static final String _MENU_NUMBER_TWO_TEXT = ("" + _MENU_NUMBER_TWO_INT + _MENU_NUMBER_TEXT_CLOSE_CHAR + _FREE_SPACE_CHAR);
	public static final String _MENU_NUMBER_THREE_TEXT = ("" + _MENU_NUMBER_THREE_INT + _MENU_NUMBER_TEXT_CLOSE_CHAR + _FREE_SPACE_CHAR);
	public static final String _MENU_NUMBER_FOUR_TEXT = ("" + _MENU_NUMBER_FOUR_INT + _MENU_NUMBER_TEXT_CLOSE_CHAR + _FREE_SPACE_CHAR);
	public static final String _MENU_ANSWER_TEXT = ("Antwort" + _FREE_SPACE_CHAR);
	
	// Titeltexte.
	public static final String _TITLE_HIGHSCORE = "HIGHSCORE";
	public static final String _TITLE_MANUAL = "ANLEITUNG";
	public static final String _TITLE_QUIZILLA = "QUIZILLA";
	public static final String _TITLE_GAME_START = "SPIEL BEGINNT";
	public static final String _TITLE_GOOD_LUCK = "GOOD LUCK!";
	public static final String _TITLE_GOOD_BYE = "AUF WIEDERSEHEN";
	public static final String _TITLE_CONGRATULATIONS = "HERZLICHEN GLÜCKWUNSCH";
	public static final String _TITLE_WON = "GEWONNEN";
	public static final String _TITLE_LOST = "LEIDER VERLOREN";
	public static final String _TITLE_RESULT = "ERGEBNIS";
	
	// Benutzereingabe Aufforderungstexte.
	public static final String _USER_REQUEST_NAME_TEXT = "Geben Sie Ihren Namen ein:" + _FREE_SPACE_CHAR;
	public static final String _USER_REQUEST_ENTER_TEXT = "Weiter mit Enter...";
	public static final String _USER_REQUEST_MENU_CHOICE_TEXT = "Auswahl:" + _FREE_SPACE_CHAR;
	public static final String _USER_REQUEST_ANSWER_QUESTION_TEXT = "Antwort:" + _FREE_SPACE_CHAR;
	
	// Informationstexte
	public static final String _INFO_ANSWER_CORRECT_TEXT = "KORREKT";
	public static final String _INFO_ANSWER_WRONG_TEXT = "FALSCH";
	public static final char _INFO_TEXT_CLOSE_CHAR = ':';
	public static final String _INFO_QUESTIONS_OVERALL_TEXT = ("Fragen Gesamt" + _INFO_TEXT_CLOSE_CHAR + _FREE_SPACE_CHAR);
	public static final String _INFO_ANSWERED_QUESTIONS_TEXT = ("Beantwortete Fragen" + _INFO_TEXT_CLOSE_CHAR + _FREE_SPACE_CHAR);
	public static final String _INFO_CORRECT_ANSWERED_QUESTIONS_TEXT = ("Davon richtig" + _INFO_TEXT_CLOSE_CHAR + _FREE_SPACE_CHAR);
	public static final String _INFO_RESULT_TEXT = ("Ergebnis" + _INFO_TEXT_CLOSE_CHAR + _FREE_SPACE_CHAR);
	
	// Resulttexte
	public static final String _RESULT_EMPTY_TEXT = "LEER";
	
	/*! Verwendungszeck und Erklärung der folgenden Konstante.
	 * -1 gibt an, dass dass es kein Ergebnis gibt (also die Highscoreliste nicht 10 Scores beinhaltet) 
	 *  und wird als Indikator (als Parameter einer Funktion in der Designerklasse) dafür verwendet.
	 *  Wenn sie in der Methode übergeben wird, weiß die Methode, dass es sich um eine leere Zeile der Highscoreliste handelt.
	*/
	public static final int _RESULT_IS_NOT_AVAILABLE_INT = -1; // 
															   
	
	// Statusleiste Texte.
	public static final String _STATUS_LIFE_TEXT = "Leben:" + _FREE_SPACE_CHAR;
	public static final String _STATUS_QUESTIONS_AMOUNT_TEXT = "Frage:" + _FREE_SPACE_CHAR;
	
	// Invalide Eingaben - Texte.
	public static final String _INVALID_DEFAULT_MSG = "Ungültiger Eingabe!";
	public static final String _INVALID_NAME_MSG = "Mindestens 1 und maximal 16 Buchstaben erlaubt!";
	public static final String _INVALID_MENU_CHOICE_MSG = "Nur zahlen zwischen 1 und 4 sind erlaubt";
	public static final String _INVALID_ANSWER_MSG = "Nur zahlen zwischen 1 und 4 sind erlaubt";
	
	// Errortexte.
	public static final String _ERROR_CANT_LOAd_XML_FILE_TEXT = ("Fehler beim Einlesen der Datei: " + _FILE_XML_QUESTIONS_FILE);
	public static final String _ERROR_CLOSE_APPLICATION_TEXT = "Programm wird beendet.";
}
