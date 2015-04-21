package mf.model.validator;

import static org.junit.Assert.*;
import mf.exceptions.InvalidFieldException;
import mf.messages.Msg;
import mf.model.TradeMsg;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Test;

public class TradeMessageValidatorTest {

	@Test
	public void whenCorrectMessageThenValidateOk() throws JSONException, InvalidFieldException {
		JSONObject json = new JSONObject(Msg.CORRECT_MSG);
		TradeMessageValidator.validateTradeMessage(json);
	}

	@Test(expected=InvalidFieldException.class)
	public void whenWrongRateThenThrowsInvalidFieldException() throws JSONException, InvalidFieldException {
		JSONObject json = new JSONObject(Msg.WRONG_RATE);
		TradeMessageValidator.validateTradeMessage(json);
	}
	
	@Test
	public void whenWrongDateThenThrowsInvalidFieldException() throws JSONException {
		JSONObject json = new JSONObject(Msg.WRONG_DATE);
		
		try {
			TradeMessageValidator.validateTradeMessage(json);
		} catch (InvalidFieldException e) {
			assertEquals(e.getMessage(), "Invalid date format");
		}
	}
	
	@Test
	public void whenSameBuyAndSellAmountThenThrowsInvalidFieldException() throws JSONException {
		JSONObject json = new JSONObject(Msg.FAKE_TRADE);
		
		try {
			TradeMessageValidator.validateTradeMessage(json);
		} catch (InvalidFieldException e) {
			assertEquals(e.getMessage(), "Trade message is not accepted, buy and sell amount are the same.");
		}
	}
	
	@Test
	public void whenWrongCurrencyThenThrowsInvalidFieldException() throws JSONException {
		JSONObject json = new JSONObject(Msg.WRONG_CURRENCY);
		
		try {
			TradeMessageValidator.validateTradeMessage(json);
		} catch (InvalidFieldException e) {
			assertEquals(e.getMessage(), "Message contains an invalid currency.");
		}
	}
	
	@Test
	public void whenWrongCountryThenThrowsInvalidFieldException() throws JSONException {
		JSONObject json = new JSONObject(Msg.WRONG_COUNTRY);
		
		try {
			TradeMessageValidator.validateTradeMessage(json);
		} catch (InvalidFieldException e) {
			assertEquals(e.getMessage(), "Message contains an invalid country.");
		}
	}
	
	@Test
	public void whenRateRoundedWellThenResultOk() throws JSONException {
		JSONObject json = new JSONObject(Msg.RATE_ROUNDED);
		
		try {
			TradeMsg msg = TradeMessageValidator.validateTradeMessage(json);
			assertNotNull(msg);
		} catch (InvalidFieldException e) {
			assertEquals(e.getMessage(), "Message contains an invalid currency.");
		}
		
	}
	
}
