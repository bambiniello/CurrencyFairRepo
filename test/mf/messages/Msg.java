package mf.messages;

public final class Msg {


	public static final String CORRECT_MSG = "{" +
			"\"userId\": \"134256\", " +
			"\"currencyFrom\": \"EUR\", " +
			"\"currencyTo\": \"GBP\", " +
			"\"amountSell\": 1000, " +
			"\"amountBuy\": 747.10, " +
			"\"rate\": 0.7471, " +
			"\"timePlaced\" : \"24-JAN-15 10:27:44\", " +
			"\"originatingCountry\" : \"FR\"" +
			"}";

	public static final String WRONG_RATE = "{" +
			"\"userId\": \"134256\", " +
			"\"currencyFrom\": \"EUR\", " +
			"\"currencyTo\": \"GBP\", " +
			"\"amountSell\": 920.33, " +
			"\"amountBuy\": 747.10, " +
			"\"rate\": 0.7471, " +
			"\"timePlaced\" : \"24-JAN-15 10:27:44\", " +
			"\"originatingCountry\" : \"FR\"" +
			"}";

	public static final String WRONG_DATE = "{" +
			"\"userId\": \"134256\", " +
			"\"currencyFrom\": \"EUR\", " +
			"\"currencyTo\": \"GBP\", " +
			"\"amountSell\": 1000, " +
			"\"amountBuy\": 747.10, " +
			"\"rate\": 0.7471, " +
			"\"timePlaced\" : \"32-JAN-15 10:27:44\", " +
			"\"originatingCountry\" : \"FR\"" +
			"}";

	public static final String FAKE_TRADE = "{" +
			"\"userId\": \"134256\", " +
			"\"currencyFrom\": \"EUR\", " +
			"\"currencyTo\": \"EUR\", " +
			"\"amountSell\": 1000, " +
			"\"amountBuy\": 1000, " +
			"\"rate\":1, " +
			"\"timePlaced\" : \"12-JAN-15 10:27:44\", " +
			"\"originatingCountry\" : \"FR\"" +
			"}";
	
	public static final String WRONG_CURRENCY = "{" +
			"\"userId\": \"134256\", " +
			"\"currencyFrom\": \"EUR\", " +
			"\"currencyTo\": \"PSD\", " +
			"\"amountSell\": 1000, " +
			"\"amountBuy\": 1000, " +
			"\"rate\":1, " +
			"\"timePlaced\" : \"12-JAN-15 10:27:44\", " +
			"\"originatingCountry\" : \"FR\"" +
			"}";
	
	public static final String WRONG_COUNTRY = "{" +
			"\"userId\": \"134256\", " +
			"\"currencyFrom\": \"EUR\", " +
			"\"currencyTo\": \"GBP\", " +
			"\"amountSell\": 1000, " +
			"\"amountBuy\": 1000, " +
			"\"rate\":1, " +
			"\"timePlaced\" : \"12-JAN-15 10:27:44\", " +
			"\"originatingCountry\" : \"ITA\"" +
			"}";
	
	public static final String RATE_ROUNDED = "{" +
			"\"userId\": \"134256\", " +
			"\"currencyFrom\": \"EUR\", " +
			"\"currencyTo\": \"GBP\", " +
			"\"amountSell\": 1000, " +
			"\"amountBuy\": 747.1000000001, " +
			"\"rate\": 0.7471, " +
			"\"timePlaced\" : \"24-JAN-15 10:27:44\", " +
			"\"originatingCountry\" : \"FR\"" +
			"}";
	
}
