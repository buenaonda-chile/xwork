/*
 * Copyright 2008-2010 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.denso.common.intf;

import java.util.ArrayList;
import java.util.List;

/**
 * Abstract interface for pagination information.
 * 
 * @author Oliver Gierke
 */
public interface Pageable {
	
	public static enum Direction {
		ASC, DESC;
	}
	
	public static class Order {
		public String column;
		public Direction direction;
		
		public Order(String column, Direction direction) {
			this.column = column;
			this.direction = direction;
		}
	}
	
	public static class Sort {
		private List<Order> orders;
		
		public Sort(Order... orders) {
			this.orders = new ArrayList<Pageable.Order>();
			for(Order order : orders)
			this.orders.add(order);
		}
		
		public List<Order> getOrders() {
			return orders;
		}
	}

	/**
	 * Returns the page to be returned.
	 * 
	 * @return the page to be returned.
	 */
	int getPageNumber();

	/**
	 * Returns the number of items to be returned.
	 * 
	 * @return the number of items of that page
	 */
	int getPageSize();

	/**
	 * Returns the offset to be taken according to the underlying page and page size.
	 * 
	 * @return the offset to be taken
	 */
	int getOffset();
	
	/**
	 * Returns the sorting parameters.
	 * 
	 * @return
	 */
	Sort getSort();

}
