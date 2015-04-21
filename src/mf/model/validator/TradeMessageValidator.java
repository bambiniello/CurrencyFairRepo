package mf.model.validator;

import java.math.BigDecimal;
import java.math.MathContext;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Currency;
import java.util.Date;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

import mf.exceptions.InvalidFieldException;
import mf.model.TradeMsg;
import mf.model.constants.MsgConst;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * The Class TradeMessageValidator.
 */
public class TradeMessageValidator {

	/** The Constant ISO_COUNTRIES. */
	private static final Set<String> ISO_COUNTRIES = new HashSet<String>(Arrays.asList(Locale.getISOCountries()));
	
	/**
	 * Validate trade message.
	 *
	 * @param jsonMessage the json message
	 * @return the trade msg
	 * @throws InvalidFieldException the invalid field exception
	 */
	public static TradeMsg validateTradeMessage (JSONObject jsonMessage) throws InvalidFieldException {
		TradeMsg result = null;
		
		try {
			double amountBuy = jsonMessage.getDouble(MsgConst.KEY_BUY);
			double amountSell = jsonMessage.getDouble(MsgConst.KEY_SELL);
			double rate = jsonMessage.getDouble(MsgConst.KEY_RATE);
			BigDecimal calcRate = new BigDecimal(amountBuy/amountSell, MathContext.DECIMAL32);
			calcRate = calcRate.setScale(4, BigDecimal.ROUND_FLOOR);
			if (calcRate.doubleValue() != rate) { // TODO define a requirements for the precision check.
				throw new InvalidFieldException("Invalid rate received");
			}
			
			String timpePlaced = jsonMessage.getString(MsgConst.KEY_TIME);
			SimpleDateFormat formatter = new SimpleDateFormat(MsgConst.DATE_FORMAT, Locale.ENGLISH);
			Date parsedDate = null;
			try {
				formatter.setLenient(false);
				parsedDate = formatter.parse(timpePlaced);
			} catch (ParseException e) {
				throw new InvalidFieldException("Invalid date format");
			}
			
			String currencyFrom = jsonMessage.getString(MsgConst.KEY_FROM);
			String currencyTo = jsonMessage.getString(MsgConst.KEY_TO);
			if (currencyFrom.equalsIgnoreCase(currencyTo) && amountBuy == amountSell) {
				throw new InvalidFieldException("Trade message is not accepted, buy and sell amount are the same.");
			}
			try {
				Currency.getInstance(currencyFrom);
				Currency.getInstance(currencyTo);
			} catch (IllegalArgumentException e) {
				throw new InvalidFieldException("Message contains an invalid currency.", e);
			}
			
			String originatingCountry = jsonMessage.getString(MsgConst.KEY_COUNTRY);
			if (!ISO_COUNTRIES.contains(originatingCountry)) {
				throw new InvalidFieldException("Message contains an invalid country.");
			}
			
			int userId = jsonMessage.getInt(MsgConst.KEY_USER_ID);
			result = new TradeMsg(userId, currencyFrom, currencyTo, amountSell, amountBuy, rate, parsedDate, originatingCountry);
			
		} catch (JSONException e) {
			e.printStackTrace();
		}
		
		return result;
	}
}
