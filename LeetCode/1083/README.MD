```sql
with iphone_buyers as (
    select buyer_id
    from Sales s
    join Product p on s.product_id = p.product_id
    and p.product_name = 'iPhone'
),
s8_buyers as (
    select buyer_id
    from Sales s
    join Product p on s.product_id = p.product_id
    and p.product_name = 'S8'
)

select distinct s8.buyer_id
from s8_buyers s8
where not exists (
    select 1
    from iphone_buyers iphone
    where iphone.buyer_id = s8.buyer_id
);
```
