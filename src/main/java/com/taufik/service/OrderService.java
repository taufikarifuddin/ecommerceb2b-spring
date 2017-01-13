package com.taufik.service;

import java.util.List;
import java.util.Set;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.taufik.base.BaseResponse;
import com.taufik.base.BaseService;
import com.taufik.model.Member;
import com.taufik.model.MemberCart;
import com.taufik.model.Order;
import com.taufik.model.OrderItem;
import com.taufik.model.OrderStatus;
import com.taufik.model.ProductDiscount;
import com.taufik.other.Constant;
import com.taufik.repository.MemberCartRepository;
import com.taufik.repository.MemberRepository;
import com.taufik.repository.OrderItemRepository;
import com.taufik.repository.OrderRepository;


@Service
public class OrderService extends BaseService<Order,OrderRepository>{
	

	public static final String API_ROUTE = Constant.API_USER_PREFIX+"/order";
	
	@Autowired
	MemberRepository memberRepo;
	
	@Autowired
	OrderItemRepository orderItemRepo;
	
	@Autowired
	MemberCartRepository cartRepository;
	
	public BaseResponse update(int id,String status){
		BaseResponse response = this.setResponse();
		try{
			Order order = this.repo.findOne(id);
			order.setStatusId( OrderStatus.valueOf(status) );
			this.save(order);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return response;
	}
	
	@Override
	public BaseResponse save(Order data) {
		BaseResponse response = this.setResponse();
		//save order
		String emailUser = SecurityContextHolder.getContext().getAuthentication().getName();			
		Member member = memberRepo.findByEmail(emailUser);
		
		if( member == null ) return response;
		
		try{
			data.setMemberId(member.getId());
			data.setMemberName( member.getName() );
			data.setStatusId( OrderStatus.PENDING );
			this.repo.save(data);
			
		}catch (Exception e) {
			e.printStackTrace();
			response.setMessageResponse("Error dalam penyimpanan Order, ulangi sekali lagi");
			return response;
		}
		
		//save order item
		try{						
			List<MemberCart> listItem = cartRepository.findByMemberId(member.getId());
			for( MemberCart cart : listItem ){
				OrderItem item = new OrderItem();
				
				//get final price dari item dengan cara kalkulasi discount dengan method ini
				int finalPrice = this.calculateDiscount(
						cart.getQty(), cart.getProduct().getDiscounts(), cart.getProduct().getPrice())
						* cart.getQty();
				
				item.setOrderId(data.getId());
				item.setFinalPrice(finalPrice);
				item.setProductCode( cart.getProduct().getCode() );
				item.setProductId(cart.getProduct().getId());
				item.setQty(cart.getQty());
				item.setProductName(cart.getProduct().getName());
				orderItemRepo.save(item);
				System.out.println("testinggan");
			}
			cartRepository.deleteAllUserCart(member.getId());
			response.setErrorResponse(false);			
			response.setDataResponse(true);
		}catch (Exception e) {
			e.printStackTrace();
			response.setErrorResponse(true);			
			response.setMessageResponse("Error dalam penyimpanan aksi CheckOut dibatalkan");			
			this.repo.delete(data.getId());
			return response;
		}
		
		return response;
	}
	
	
	private int calculateDiscount(int total,Set<ProductDiscount> set,int price){	
		
		int discount = price;
		//discount ada ketika tracehold dari discount kurang dari total barang
		//dan akan di break ketika tracehold > qty karena jelas tidak mungkin m endapatkan diskon 
		//pada qty itu
		for( ProductDiscount detailDiscount : set ){
			if( total >= detailDiscount.getTracehold() ){
				discount = detailDiscount.getDiscount();
			}else{
				break;
			}
		}
		return discount;
	}
	
	public BaseResponse changeDataOrder(Order order){
		return super.save(order);
	}
	
	public BaseResponse getUserOrder(){
		BaseResponse response = this.setResponse();
		try{
		Member member = this.memberRepo.findByEmail(
				SecurityContextHolder.getContext().getAuthentication()
				.getName());
		List<Order> order = this.repo.findByMemberId(member.getId());
		response.setErrorResponse(false);
		response.setDataResponse(order);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return response;		
	}
	
}
