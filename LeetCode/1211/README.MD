# Queries Quality and Percentage

```sql
select
    query_name,
    round(avg(rating/position), 2)as 'quality',
    round(100*avg(rating < 3), 2) as 'poor_query_percentage'
from
    Queries
where
    query_name is not null
group by
    1

```
