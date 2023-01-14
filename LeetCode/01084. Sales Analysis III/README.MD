```
select product_id, product_name
from product
where product_id in (select s.product_id
                    from sales s
                    group by s.product_id
                    having min(sale_date) >= '2019-01-01' and max(sale_date) <= '2019-03-31')

```