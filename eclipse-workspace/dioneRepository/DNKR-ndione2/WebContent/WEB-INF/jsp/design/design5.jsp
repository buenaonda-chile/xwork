<%--
 * PROJECT：
 *
 * [KR] 
 * 
 * $Id$
 *
 * Copyright (c) 2017 DENSO CORPORATION. All rights reserved.
 *
--%>
<!-- [EN] Contents area -->
<!-- [JP] コンテンツエリア -->
<%-- <spring:message code="label.filename" /> : <c:out value="${url }"></c:out> --%>

<%-- <c:if test="${fn:substring(authBinaryNum, 3, 4) eq '1' }">조회권한
</c:if> --%>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/design4.css" />
<script>
	var gridList = [
	                {mode:"TMA", alc:"E010", customer:"94001-S2010", pn:"11003-92973DA", opt:"STD", stock:"0", 
	                	Delevery:"Delevery", receiving: "receiving", Shortage: "Shortage",
	                	w00d:"", w00r:"", w00s:"0", 
	                	w01d:"", w01r:"", w01s:"0", 
	                	w02d:"", w02r:"0", w02s:"0", 
	                	w03d:"", w03r:"65", w03s:"65", 
	                	w04d:"0", w04r:"100", w04s:"165", 
	                	w05d:"114", w05r:"100", w05s:"151", 
	                	w06d:"204", w06r:"400", w06s:"347", 
	                	w07d:"86", w07r:"400", w07s:"661", 
	                	w08d:"338", w08r:"200", w08s:"523", 
	                	w09d:"407", w09r:"200", w09s:"316", },
	                {mode:"TMA", alc:"E010", customer:"94001-S2010", pn:"11003-92973DA", opt:"STD", stock:"0",
	                		Delevery:"Delevery", receiving: "receiving", Shortage: "Shortage",
		                	w00d:"", w00r:"", w00s:"0", 
		                	w01d:"", w01r:"", w01s:"0", 
		                	w02d:"", w02r:"0", w02s:"0", 
		                	w03d:"", w03r:"159", w03s:"159", 
		                	w04d:"0", w04r:"250", w04s:"409", 
		                	w05d:"247", w05r:"350", w05s:"512", 
		                	w06d:"377", w06r:"450", w06s:"585", 
		                	w07d:"167", w07r:"450", w07s:"868", 
		                	w08d:"644", w08r:"450", w08s:"674", 
		                	w09d:"680", w09r:"300", w09s:"294", },
	                {mode:"TMA", alc:"E010", customer:"94001-S2010", pn:"11003-92973DA", opt:"STD", stock:"0",
		                		Delevery:"Delevery", receiving: "receiving", Shortage: "Shortage",
			                	w00d:"", w00r:"", w00s:"0", 
			                	w01d:"", w01r:"", w01s:"0", 
			                	w02d:"", w02r:"0", w02s:"0", 
			                	w03d:"", w03r:"5", w03s:"5", 
			                	w04d:"2", w04r:"", w04s:"3", 
			                	w05d:"", w05r:"", w05s:"3", 
			                	w06d:"0", w06r:"", w06s:"3", 
			                	w07d:"1500", w07r:"1550", w07s:"53", 
			                	w08d:"0", w08r:"", w08s:"53", 
			                	w09d:"0", w09r:"", w09s:"53", },
	                ];
	var shipGrid = {
			initView: function() {
				this.target = new ax5.ui.grid();
				this.target.setConfig({
					target : $('[data-ax5grid="ship-grid"]'),
					showLineNumber: true,
					header: {
			            align: "center"
			        },
			        body: {
			        	align: "center",
			        },
			        columns:
		        	[
						/* {label: "", align: "right",
							columns: [ */
								{label: "18-5-9", align: "right",
									columns: [     
										{label: "mode", key: "mode", width: 80,},
										{label: "alc", key: "alc", width: 80, },
										{label: "customer P/N", key: "customer", width: 100,},
										{label: "DENSO P/N", key: "pn", width: 100,},
										{label: "OPT", key: "opt", width: 50, },
										{label: "Stock", key: "stock", width: 50,},
									]
								},
							/* ]
						}, */
	            		    {label: "", key:"Delevery", width:80,
		        	 		columns: [
	     					   {label: "", key: "receiving", align: "center" ,width:80,
	     						  columns: [
	     		     					   {label: "", key: "Shortage", align: "center", width:80,},
	     							]   
	     					   },
						]}, 
						{label: "", key:"w00d", width:70,
		        	 		columns: [
	     					   {label: "W + 00", key: "w00r", align: "center", width:70,
	     						  columns: [
	     		     					   {label: "4-16", key: "w00s", align: "center", width:70,},
	     							]   
	     					   },
						]},
						{label: "", key:"w01d", width:70,
		        	 		columns: [
	     					   {label: "W + 01", key: "w01r", align: "center", width:70,
	     						  columns: [
	     		     					   {label: "4-23", key: "w01s", align: "center", width:70,},
	     							]   
	     					   },
						]},
						{label: "", key:"w02d", width:70,
		        	 		columns: [
	     					   {label: "W + 02", key: "w02r", align: "center", width:70,
	     						  columns: [
	     		     					   {label: "4-30", key: "w02s", align: "center", width:70,},
	     							]   
	     					   },
						]},
						{label: "", key:"w03d", width:70,
		        	 		columns: [
	     					   {label: "W + 03", key: "w03r", align: "center", width:70,
	     						  columns: [
	     		     					   {label: "5-7", key: "w03s", align: "center", width:70,},
	     							]   
	     					   },
						]},
						{label: "", key:"w04d", width:70,
		        	 		columns: [
	     					   {label: "W + 04", key: "w04r", align: "center", width:70,
	     						  columns: [
	     		     					   {label: "5-14", key: "w04s", align: "center", width:70,},
	     							]   
	     					   },
						]},
						{label: "", key:"w05d", width:70,
		        	 		columns: [
	     					   {label: "W + 05", key: "w05r", align: "center", width:70,
	     						  columns: [
	     		     					   {label: "5-21", key: "w05s", align: "center", width:70,},
	     							]   
	     					   },
						]},
						{label: "", key:"w06d", width:70,
		        	 		columns: [
	     					   {label: "W + 06", key: "w06r", align: "center", width:70,
	     						  columns: [
	     		     					   {label: "5-28", key: "w06s", align: "center", width:70,},
	     							]   
	     					   },
						]},
						{label: "", key:"w07d", width:70,
		        	 		columns: [
	     					   {label: "W + 07", key: "w07r", align: "center", width:70,
	     						  columns: [
	     		     					   {label: "6-4", key: "w07s", align: "center", width:70,},
	     							]   
	     					   },
						]},
						{label: "", key:"w08d", width:70,
		        	 		columns: [
	     					   {label: "W + 08", key: "w08r", align: "center", width:70,
	     						  columns: [
	     		     					   {label: "6-11", key: "w08s", align: "center", width:70,},
	     							]   
	     					   },
						]},
						{label: "", key:"w09d", width:70,
		        	 		columns: [
	     					   {label: "W + 09", key: "w09r", align: "center", width:70,
	     						  columns: [
	     		     					   {label: "6-18", key: "w09s", align: "center", width:70,},
	     							]   
	     					   },
						]},
							
		        	 ],
		        	
				});
				return this;
			},
			setData: function() {
				var list = gridList;
				this.target.setData(list);
			}
	};
	
	$(document.body).ready(function() {
		shipGrid.initView()
				.setData();
	});
</script>
<div class="wrap">
	<div>
		<!-- 물류센터ID -->
		<select>
			<option value="0000001480">KCP창원물류센터</option>
			<option value="0000001101">KCP미국향수출선적</option>
			<option value="0000001102">LOGISALL USA물류센터</option>
		</select>
		<button type="button" class="AXButton Black _searchBtn_" onclick="">
			<i class="axi axi-ion-android-search"></i>
			<spring:message code='label.search'/>
		</button>
	</div>
	<div class="ssgap"></div>
	<div class="gridWarp" style="height: 400px;">
		<div data-ax5grid="ship-grid" data-ax5grid-config="{}" style="height: 100%;">
        </div>
    </div>
</div>