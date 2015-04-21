package mf.model;

import java.util.Date;

/**
 * The Class TradeMsg.
 */
public class TradeMsg {

	/** The user id. */
	private long userId;
	
	/** The currency from. */
	private String currencyFrom;
	
	/** The currency to. */
	private String currencyTo;
	
	/** The amount sell. */
	private double amountSell;
	
	/** The amount buy. */
	private double amountBuy;
	
	/** The rate. */
	private double rate;
	
	/** The time placed. */
	private Date timePlaced;
	
	/** The originating country. */
	private String originatingCountry;

	/**
	 * Instantiates a new trade msg.
	 *
	 * @param userId the user id
	 * @param currencyFrom the currency from
	 * @param currencyTo the currency to
	 * @param amountSell the amount sell
	 * @param amountBuy the amount buy
	 * @param rate the rate
	 * @param timePlaced the time placed
	 * @param originatingCountry the originating country
	 */
	public TradeMsg(long userId, String currencyFrom, String currencyTo,
			double amountSell, double amountBuy, double rate, Date timePlaced,
			String originatingCountry) {
		super();
		this.userId = userId;
		this.currencyFrom = currencyFrom;
		this.currencyTo = currencyTo;
		this.amountSell = amountSell;
		this.amountBuy = amountBuy;
		this.rate = rate;
		this.timePlaced = timePlaced;
		this.originatingCountry = originatingCountry;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(amountBuy);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(amountSell);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result
				+ ((currencyFrom == null) ? 0 : currencyFrom.hashCode());
		result = prime * result
				+ ((currencyTo == null) ? 0 : currencyTo.hashCode());
		result = prime
				* result
				+ ((originatingCountry == null) ? 0 : originatingCountry
						.hashCode());
		temp = Double.doubleToLongBits(rate);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result
				+ ((timePlaced == null) ? 0 : timePlaced.hashCode());
		result = prime * result + (int) (userId ^ (userId >>> 32));
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof TradeMsg))
			return false;
		TradeMsg other = (TradeMsg) obj;
		if (Double.doubleToLongBits(amountBuy) != Double
				.doubleToLongBits(other.amountBuy))
			return false;
		if (Double.doubleToLongBits(amountSell) != Double
				.doubleToLongBits(other.amountSell))
			return false;
		if (currencyFrom == null) {
			if (other.currencyFrom != null)
				return false;
		} else if (!currencyFrom.equals(other.currencyFrom))
			return false;
		if (currencyTo == null) {
			if (other.currencyTo != null)
				return false;
		} else if (!currencyTo.equals(other.currencyTo))
			return false;
		if (originatingCountry == null) {
			if (other.originatingCountry != null)
				return false;
		} else if (!originatingCountry.equals(other.originatingCountry))
			return false;
		if (Double.doubleToLongBits(rate) != Double
				.doubleToLongBits(other.rate))
			return false;
		if (timePlaced == null) {
			if (other.timePlaced != null)
				return false;
		} else if (!timePlaced.equals(other.timePlaced))
			return false;
		if (userId != other.userId)
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "TRADE MESSAGE:userId:" + userId +" currencyFrom:" + currencyFrom + " currencyTo:" + currencyTo;
	}

	/**
	 * Gets the user id.
	 *
	 * @return the user id
	 */
	public long getUserId() {
		return userId;
	}

	/**
	 * Sets the user id.
	 *
	 * @param userId the new user id
	 */
	public void setUserId(long userId) {
		this.userId = userId;
	}

	/**
	 * Gets the currency from.
	 *
	 * @return the currency from
	 */
	public String getCurrencyFrom() {
		return currencyFrom;
	}

	/**
	 * Sets the currency from.
	 *
	 * @param currencyFrom the new currency from
	 */
	public void setCurrencyFrom(String currencyFrom) {
		this.currencyFrom = currencyFrom;
	}

	/**
	 * Gets the currency to.
	 *
	 * @return the currency to
	 */
	public String getCurrencyTo() {
		return currencyTo;
	}

	/**
	 * Sets the currency to.
	 *
	 * @param currencyTo the new currency to
	 */
	public void setCurrencyTo(String currencyTo) {
		this.currencyTo = currencyTo;
	}

	/**
	 * Gets the amount sell.
	 *
	 * @return the amount sell
	 */
	public double getAmountSell() {
		return amountSell;
	}

	/**
	 * Sets the amount sell.
	 *
	 * @param amountSell the new amount sell
	 */
	public void setAmountSell(double amountSell) {
		this.amountSell = amountSell;
	}

	/**
	 * Gets the amount buy.
	 *
	 * @return the amount buy
	 */
	public double getAmountBuy() {
		return amountBuy;
	}

	/**
	 * Sets the amount buy.
	 *
	 * @param amountBuy the new amount buy
	 */
	public void setAmountBuy(double amountBuy) {
		this.amountBuy = amountBuy;
	}

	/**
	 * Gets the rate.
	 *
	 * @return the rate
	 */
	public double getRate() {
		return rate;
	}

	/**
	 * Sets the rate.
	 *
	 * @param rate the new rate
	 */
	public void setRate(double rate) {
		this.rate = rate;
	}

	/**
	 * Gets the time placed.
	 *
	 * @return the time placed
	 */
	public Date getTimePlaced() {
		return timePlaced;
	}

	/**
	 * Sets the time placed.
	 *
	 * @param timePlaced the new time placed
	 */
	public void setTimePlaced(Date timePlaced) {
		this.timePlaced = timePlaced;
	}

	/**
	 * Gets the originating country.
	 *
	 * @return the originating country
	 */
	public String getOriginatingCountry() {
		return originatingCountry;
	}

	/**
	 * Sets the originating country.
	 *
	 * @param originatingCountry the new originating country
	 */
	public void setOriginatingCountry(String originatingCountry) {
		this.originatingCountry = originatingCountry;
	}
}
