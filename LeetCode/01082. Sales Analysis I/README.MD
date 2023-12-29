```
with aggregate_sale as (
    select 
        seller_id, 
        sum(price) as 'total_price'
    from 
        Sales
    group by 
        seller_id
)
select 
    seller_id
from 
    aggregate_sale
where 
    total_price = 
(                   select 
                        max(total_price) 
                    from 
                        aggregate_sale)
```