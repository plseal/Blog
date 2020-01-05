/*select z_date,z_name,z_amount,z_type,z_io_div,z_remark,z_m_amount from t_zhangzu where z_date like '2019/%' and z_name like '%电话费';
*/
select z_date,z_name,z_amount,z_type,z_io_div,z_remark,z_m_amount from t_zhangzu where z_date like '2019/%' and z_remark = 'UFJ_NICOS_68837';