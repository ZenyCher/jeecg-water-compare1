select sum(recharge_statistics) from w_recharge_statistics where 1=1 
<#if member_phone ? exists && member_phone ?length gt 0>
	and member_phone = :member_phone
</#if>
<#if sumType ? exists && sumType == '0' >
	and date_format(create_date,'%D')=date_format(now(),'%D')
</#if>
<#if sumType ? exists && sumType == '1' >
	and date_format(create_date,'%Y-%m')=date_format(now(),'%Y-%m')
</#if>
<#if sumType ? exists && sumType == '2' >
	and date_format(create_date,'%Y')=date_format(CURDATE(),'%Y')
</#if>
GROUP BY  member_phone, member_name