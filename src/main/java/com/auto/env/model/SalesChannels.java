package com.auto.env.model;

public class SalesChannels {
	
	private String CHANNEL = "";
	private String ISINCLUDED = "";
	
	
	@Override
	public String toString() {
		return "\n[CHANNEL="+ CHANNEL + ":ISINCLUDED=" + ISINCLUDED+"]";
	}
	public SalesChannels() {
		
	}
	public SalesChannels(String CHANNEL, String ISINCLUDED) {
		super();
		this.CHANNEL = CHANNEL;
		this.ISINCLUDED = ISINCLUDED;
	}
	
	
	public SalesChannels(String CHANNEL) {
		super();
		this.CHANNEL = CHANNEL;
		
	}
	
	public String getCHANNEL() {
		return CHANNEL;
	}
	public void setCHANNEL(String cHANNEL) {
		CHANNEL = cHANNEL;
	}
	public String getISINCLUDED() {
		return ISINCLUDED;
	}
	public void setISINCLUDED(String iSINCLUDED) {
		ISINCLUDED = iSINCLUDED;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((CHANNEL == null) ? 0 : CHANNEL.hashCode());
		result = prime * result + ((ISINCLUDED == null) ? 0 : ISINCLUDED.hashCode());
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
		SalesChannels other = (SalesChannels) obj;
		if (CHANNEL == null) {
			if (other.CHANNEL != null)
				return false;
		} else if (!CHANNEL.equals(other.CHANNEL))
			return false;
		if (ISINCLUDED == null) {
			if (other.ISINCLUDED != null)
				return false;
		} else if (!ISINCLUDED.equals(other.ISINCLUDED))
			return false;
		return true;
	}

}