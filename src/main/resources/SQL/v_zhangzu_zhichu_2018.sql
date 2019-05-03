CREATE 
	OR REPLACE VIEW lingzhu.v_zhangzu_zhichu_2018 AS SELECT
	SUBSTR( z_date, 1, 7 ) AS ac,
	sum( z_amount ) as amount
FROM
	t_zhangzu 
WHERE
	z_date LIKE '2018%' 
	AND z_io_div = '支出' 
GROUP BY
	SUBSTR( z_date, 1, 7 );
