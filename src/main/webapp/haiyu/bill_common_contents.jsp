<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

							<div class="form-group">
								<label class="col-sm-2 control-label">客户名称：</label>
								<div class="col-sm-10">
									<input type="text" class="form-control" id="customer_name" name="customer_name" value="${bill.customer_name}" placeholder=""    >							
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-2 control-label">联系人：</label>
								<div class="col-sm-10">
									<input type="text" class="form-control" id="customer_contact" name="customer_contact" value="${bill.customer_contact}" placeholder=""    >							
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-2 control-label">联系电话：</label>
								<div class="col-sm-10">
									<input type="text" class="form-control" id="customer_tel" name="customer_tel" value="${bill.customer_tel}" placeholder=""    >							
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-2 control-label">日期：</label>
								 <div class="col-sm-10 ">
									<div class="input-group date form_date " data-date="${bill.bill_date}" data-date-format="yyyy/mm/dd" data-link-field="dtp_input2" data-link-format="yyyy/mm/dd">
										<input  id="child_birth" class="form-control" size="16" type="text" value="${bill.bill_date}" readonly >
										<span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
										<span class="input-group-addon"><span class="glyphicon glyphicon-calendar"></span></span>
									</div>
									<input type="text" id="bill_date" name="bill_date" style="display:none" value="${bill.bill_date}" check-type="required" required-message="请输入日期"><br/>
								 </div>
								
							</div>
							
							<table id="bill_detail" class="gridtable">
							  <tr>
								<th class="danger"width="30%">文件名称</th>
								<th class="danger"width="20%">成品尺寸</th>
								<th class="danger"width="15%">数量</th>
								<th class="danger"width="20%">纸张</th>
								<th class="danger"width="15%">页数</th>
								</tr>
								<TR>
								<td><input type='text' class='form-control' id='bill_name1' name='bill_name1' value='${bill.bill_name1}' placeholder=''    ></td>
								<td><input type='text' class='form-control' id='bill_size1' name='bill_size1' value='${bill.bill_size1}' placeholder=''    ></td>
								<td><input type='text' class='form-control' id='bill_num1' name='bill_num1' value='${bill.bill_num1}' placeholder=''    ></td>
								<td><input type='text' class='form-control' id='bill_paper1' name='bill_paper1' value='${bill.bill_paper1}' placeholder=''    ></td>
								<td><input type='text' class='form-control' id='bill_pages1' name='bill_pages1' value='${bill.bill_pages1}' placeholder=''    ></td>
								</TR>
								<TR>
								<td><input type='text' class='form-control' id='bill_name2' name='bill_name2' value='${bill.bill_name2}' placeholder=''    ></td>
								<td><input type='text' class='form-control' id='bill_size2' name='bill_size2' value='${bill.bill_size2}' placeholder=''    ></td>
								<td><input type='text' class='form-control' id='bill_num2' name='bill_num2' value='${bill.bill_num2}' placeholder=''    ></td>
								<td><input type='text' class='form-control' id='bill_paper2' name='bill_paper2' value='${bill.bill_paper2}' placeholder=''    ></td>
								<td><input type='text' class='form-control' id='bill_pages2' name='bill_pages2' value='${bill.bill_pages2}' placeholder=''    ></td>
								</TR>
								<TR>
								<td><input type='text' class='form-control' id='bill_name3' name='bill_name3' value='${bill.bill_name3}' placeholder=''    ></td>
								<td><input type='text' class='form-control' id='bill_size3' name='bill_size3' value='${bill.bill_size3}' placeholder=''    ></td>
								<td><input type='text' class='form-control' id='bill_num3' name='bill_num3' value='${bill.bill_num3}' placeholder=''    ></td>
								<td><input type='text' class='form-control' id='bill_paper3' name='bill_paper3' value='${bill.bill_paper3}' placeholder=''    ></td>
								<td><input type='text' class='form-control' id='bill_pages3' name='bill_pages3' value='${bill.bill_pages3}' placeholder=''    ></td>
								</TR>
								<TR>
								<td><input type='text' class='form-control' id='bill_name4' name='bill_name4' value='${bill.bill_name4}' placeholder=''    ></td>
								<td><input type='text' class='form-control' id='bill_size4' name='bill_size4' value='${bill.bill_size4}' placeholder=''    ></td>
								<td><input type='text' class='form-control' id='bill_num4' name='bill_num4' value='${bill.bill_num4}' placeholder=''    ></td>
								<td><input type='text' class='form-control' id='bill_paper4' name='bill_paper4' value='${bill.bill_paper4}' placeholder=''    ></td>
								<td><input type='text' class='form-control' id='bill_pages4' name='bill_pages4' value='${bill.bill_pages4}' placeholder=''    ></td>
								</TR>
								<TR>
								<td><input type='text' class='form-control' id='bill_name5' name='bill_name5' value='${bill.bill_name5}' placeholder=''    ></td>
								<td><input type='text' class='form-control' id='bill_size5' name='bill_size5' value='${bill.bill_size5}' placeholder=''    ></td>
								<td><input type='text' class='form-control' id='bill_num5' name='bill_num5' value='${bill.bill_num5}' placeholder=''    ></td>
								<td><input type='text' class='form-control' id='bill_paper5' name='bill_paper5' value='${bill.bill_paper5}' placeholder=''    ></td>
								<td><input type='text' class='form-control' id='bill_pages5' name='bill_pages5' value='${bill.bill_pages5}' placeholder=''    ></td>
								</TR>
								<TR>
								<td><input type='text' class='form-control' id='bill_name6' name='bill_name6' value='${bill.bill_name6}' placeholder=''    ></td>
								<td><input type='text' class='form-control' id='bill_size6' name='bill_size6' value='${bill.bill_size6}' placeholder=''    ></td>
								<td><input type='text' class='form-control' id='bill_num6' name='bill_num6' value='${bill.bill_num6}' placeholder=''    ></td>
								<td><input type='text' class='form-control' id='bill_paper6' name='bill_paper6' value='${bill.bill_paper6}' placeholder=''    ></td>
								<td><input type='text' class='form-control' id='bill_pages6' name='bill_pages6' value='${bill.bill_pages6}' placeholder=''    ></td>
								</TR>


							</table>
							<br/>
							<div class="form-group">
								<label class="col-sm-2 control-label">印品名称：</label>
								<div class="col-sm-10">
									<input type="text" class="form-control" id="bill_name" name="bill_name" value="${bill.bill_name}" placeholder=""    >								
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-2 control-label">印刷数量：</label>
								<div class="col-sm-10">
									<input type="text" class="form-control" id="bill_num" name="bill_num" value="${bill.bill_num}" placeholder=""    >								
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-2 control-label">印品单价：</label>
								<div class="col-sm-10">
									<input type="text" class="form-control" id="bill_unit_price" name="bill_unit_price" value="${bill.bill_unit_price}" placeholder=""    >								
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-2 control-label">印品总价：</label>
								<div class="col-sm-10">
									<input type="text" class="form-control" id="bill_all_price" name="bill_all_price" value="${bill.bill_all_price}" placeholder=""    >								
								</div>
							</div>



							<div class="form-group">
								<label class="col-sm-2 control-label">印刷要求：</label>
								<div class="col-sm-10">
									<input type="text" class="form-control" id="bill_require" name="bill_require" value="${bill.bill_require}" placeholder=""    >								
								</div>
							</div>
															
							<div class="form-group">
								<label class="col-sm-2 control-label">订单状态：</label>
								<div class="col-sm-10">
									<select class="form-control" id="bill_status" name="bill_status" >
									  <option value="接到活儿">接到活儿</option>
									  <option value="已交定金">已交定金</option>
									  <option value="已经发片">已经发片</option>
									  <option value="上机印刷">上机印刷</option>
									  <option value="等待交货">等待交货</option>
									  <option value="已经交货">已经交货</option>
									  <option value="尾款结清">尾款结清</option>
									</select>
								</div>

							</div>
