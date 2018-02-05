SELECT * FROM WmallIntroduceEntity WHERE 1=1
<#if WmallIntroduceEntity.mall_id ? exists>
	and mall_id = WmallIntroduceEntity.mall_id
</#if>