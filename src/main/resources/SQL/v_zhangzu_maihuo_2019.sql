CREATE 
	OR REPLACE VIEW lingzhu.v_zhangzu_maihuo_2019 AS SELECT
	SUBSTR( z_date, 1, 7 ) AS ac,
	sum( z_amount ) as amount
FROM
	t_zhangzu 
WHERE
	z_date LIKE '2019%' 
	AND z_io_div = '买货' 
GROUP BY
	SUBSTR( z_date, 1, 7 );
