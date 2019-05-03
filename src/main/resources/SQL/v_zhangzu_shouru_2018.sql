CREATE 
	OR REPLACE VIEW lingzhu.v_zhangzu_shouru_2018 AS SELECT
	SUBSTR( z_date, 1, 7 ) AS ac,
	sum( z_amount ) as amount
FROM
	t_zhangzu 
WHERE
	z_date LIKE '2018%' 
	AND z_io_div = '收入' 
GROUP BY
	SUBSTR( z_date, 1, 7 );