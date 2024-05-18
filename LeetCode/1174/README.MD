```sql
with earlier_order as (
    select 
        customer_id, 
        min(order_date)
    from
        Delivery
    group by
        1
)

select
    round(avg(order_date = customer_pref_delivery_date)*100
        , 2) as 'immediate_percentage'
from
    delivery
where
    (customer_id, order_date) in (select * from earlier_order)

```