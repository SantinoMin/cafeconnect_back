package com.kong.cc.dto;

import java.sql.Date;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

import com.kong.cc.entity.Item;
import com.kong.cc.entity.ShopOrder;
import com.kong.cc.entity.Store;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ShopOrderDto {
	private Integer orderNum;
	
	private String orderCode;
	private Integer orderCount;
	private Date orderDate;

	private String orderState;
	private String orderDelivery;
	private String orderPayment;

	private Integer storeCode;
	private String  storeName;
	private String storeAddress;
	private String storeAddressNum;
	private String storePhone;
	private String ownerName;
	
	private String itemCode;
	private String itemName;
	private Integer itemPrice;
	private Integer orderPrice;
	
	private String orderDateStr;
	private Integer itemFileNum;
	private String itemFileName;
	private String itemMajorCategoryName;
	private String itemMiddleCategoryName;
	private String itemSubCategoryName;
	private String itemCapacity;
	private Integer itemUnitQuantity;
	private String itemUnit;
	private String itemStorage;
	
	private String impUid;
	
	//주문번호 생성
	public String makeOrderCode () {
		//241127(주문날짜)+랜덤숫자문자(4자리)+결제시간(시분초) 조합 
		
		String date = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyMMddHHmmss"));  
		String orderDate = date.substring(0, 6);
		String orderTime = date.substring(6);
				
		String uuid = UUID.randomUUID().toString().substring(0,4); //36자 문자열에서 앞 4자만 가져옴

		return orderDate+uuid+orderTime;
	}

	
	public ShopOrder toEntity() {
		return ShopOrder.builder()
				.orderNum(orderNum)
				.orderCode(orderCode)
				.orderCount(orderCount)
				.orderDate(orderDate)
				.orderState(orderState)
				.orderDelivery(orderDelivery)
				.orderPayment(orderPayment)
				.storeO(Store.builder().storeCode(storeCode).build())
				.itemO(Item.builder().itemCode(itemCode).build())
				.impUid(impUid)
				.build();
	}
}
