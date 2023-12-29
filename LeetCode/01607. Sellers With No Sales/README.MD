```
select 
    s.seller_name
from
    Seller s left join Orders o
    on s.seller_id = o.seller_id and YEAR(sale_date) = 2020
where
    sale_date is null
order by
    s.seller_name asc
```