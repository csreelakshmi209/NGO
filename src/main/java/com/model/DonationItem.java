package com.model;

public class DonationItem {
	private int itemId;
	private DonationType item;
	private String itemDescription;
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public DonationType getItem() {
		return item;
	}
	public void setItem(DonationType item) {
		this.item = item;
	}
	public String getItemDescription() {
		return itemDescription;
	}
	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}
	@Override
	public String toString() {
		return "DonationItem [itemId=" + itemId + ", itemDescription=" + itemDescription + "]";
	}

}
