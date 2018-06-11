package com.auto.env.model;

public class ProductBuilder {

	public ProductBuilder() {
		super();
	}
	private String PBL_DATE;
	private String GT_CODE;
	private String ACTION;
	private String CHANNEL;
	private String PBL_RETMSG;

	public ProductBuilder(String pBL_DATE, String gT_CODE, String aCTION, String cHANNEL, String pBL_RETMSG) {
		super();
		this.PBL_DATE = pBL_DATE;
		this.GT_CODE = gT_CODE;
		this.ACTION = aCTION;
		this.CHANNEL = cHANNEL;
		this.PBL_RETMSG = pBL_RETMSG;
	}

	public ProductBuilder(String pBL_DATE, String gT_CODE, String aCTION, String cHANNEL) {
		super();
		this.PBL_DATE = pBL_DATE;
		this.GT_CODE = gT_CODE;
		this.ACTION = aCTION;
		this.CHANNEL = cHANNEL;
		this.PBL_RETMSG = "";
	}

	public String getPBL_DATE() {
		return PBL_DATE;
	}
	public void setPBL_DATE(String pBL_DATE) {
		PBL_DATE = pBL_DATE;
	}
	public String getGT_CODE() {
		return GT_CODE;
	}
	public void setGT_CODE(String gT_CODE) {
		GT_CODE = gT_CODE;
	}
	public String getACTION() {
		return ACTION;
	}
	public void setACTION(String aCTION) {
		ACTION = aCTION;
	}
	public String getCHANNEL() {
		return CHANNEL;
	}
	public void setCHANNEL(String cHANNEL) {
		CHANNEL = cHANNEL;
	}
	public String getPBL_RETMSG() {
		return PBL_RETMSG;
	}
	public void setPBL_RETMSG(String pBL_RETMSG) {
		PBL_RETMSG = pBL_RETMSG;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ACTION == null) ? 0 : ACTION.hashCode());
		result = prime * result + ((CHANNEL == null) ? 0 : CHANNEL.hashCode());
		result = prime * result + ((GT_CODE == null) ? 0 : GT_CODE.hashCode());
		result = prime * result + ((PBL_DATE == null) ? 0 : PBL_DATE.hashCode());
		result = prime * result + ((PBL_RETMSG == null) ? 0 : PBL_RETMSG.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProductBuilder other = (ProductBuilder) obj;
		if (ACTION == null) {
			if (other.ACTION != null)
				return false;
		} else if (!ACTION.equals(other.ACTION))
			return false;
		if (CHANNEL == null) {
			if (other.CHANNEL != null)
				return false;
		} else if (!CHANNEL.equals(other.CHANNEL))
			return false;
		if (GT_CODE == null) {
			if (other.GT_CODE != null)
				return false;
		} else if (!GT_CODE.equals(other.GT_CODE))
			return false;
		if (PBL_DATE == null) {
			if (other.PBL_DATE != null)
				return false;
		} else if (!PBL_DATE.equals(other.PBL_DATE))
			return false;
		if (PBL_RETMSG == null) {
			if (other.PBL_RETMSG != null)
				return false;
		} else if (!PBL_RETMSG.equals(other.PBL_RETMSG))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "\n[PBL_DATE=" + PBL_DATE + ", GT_CODE=" + GT_CODE + ", ACTION=" + ACTION + ", CHANNEL="
				+ CHANNEL + ", PBL_RETMSG=" + PBL_RETMSG+"]";
	}





}